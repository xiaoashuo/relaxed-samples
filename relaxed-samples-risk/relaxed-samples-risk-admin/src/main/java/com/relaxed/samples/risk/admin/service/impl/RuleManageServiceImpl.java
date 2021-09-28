package com.relaxed.samples.risk.admin.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.relaxed.common.core.util.SpringUtils;
import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;

import com.relaxed.common.risk.biz.distributor.event.EventDistributor;
import com.relaxed.common.risk.biz.distributor.event.subscribe.SubscribeEnum;
import com.relaxed.common.risk.biz.service.*;
import com.relaxed.common.risk.model.converter.RuleConverter;
import com.relaxed.common.risk.model.entity.Rule;
import com.relaxed.common.risk.model.entity.RuleHistory;
import com.relaxed.common.risk.model.enums.FieldType;
import com.relaxed.common.risk.model.enums.ModelEnums;
import com.relaxed.common.risk.model.qo.RuleQO;
import com.relaxed.common.risk.model.vo.AbstractionVO;
import com.relaxed.common.risk.model.vo.FieldVO;
import com.relaxed.common.risk.model.vo.PreItemVO;
import com.relaxed.common.risk.model.vo.RuleVO;
import com.relaxed.samples.risk.admin.event.RuleChangeEvent;
import com.relaxed.samples.risk.admin.model.domain.DataColumn;
import com.relaxed.samples.risk.admin.model.enums.DataColumnType;
import com.relaxed.samples.risk.admin.service.RuleManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yakir
 * @Topic RuleManageService
 * @Description
 * @date 2021/9/24 14:34
 * @Version 1.0
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class RuleManageServiceImpl implements RuleManageService {

	private final RuleService ruleService;

	private final RuleHistoryService ruleHistoryService;

	private final EventDistributor eventDistributor;

	private final FieldService fieldService;

	private final PreItemService preItemService;

	private final AbstractionService abstractionService;

	@Override
	public PageResult<RuleVO> selectByPage(PageParam pageParam, RuleQO ruleQO) {
		return ruleService.selectByPage(pageParam, ruleQO);
	}

	@Override
	public boolean add(Rule rule) {
		String ruleName = rule.getName();
		Rule sqlRule = ruleService.getByName(ruleName);
		Assert.isNull(sqlRule, "rule has already exists.");
		rule.setStatus(ModelEnums.StatusEnum.INIT.getStatus());
		if (ruleService.save(rule)) {
			SpringUtils.publishEvent(new RuleChangeEvent(convertToRuleHistory(rule)));
			// 发布订阅
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_RULE_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(RuleConverter.INSTANCE.poToVo(rule)));
			return true;
		}
		return false;
	}

	private RuleHistory convertToRuleHistory(Rule rule) {
		RuleHistory ruleHistory = new RuleHistory();
		ruleHistory.setRuleId(rule.getId());
		ruleHistory.setMerchantCode("system");
		ruleHistory.setLabel(rule.getLabel());
		ruleHistory.setInitScore(rule.getInitScore());
		ruleHistory.setBaseNum(rule.getBaseNum());
		ruleHistory.setOperator(rule.getOperator());
		ruleHistory.setAbstractionName(rule.getAbstractionName());
		ruleHistory.setRate(rule.getRate());
		ruleHistory.setRuleDefinition(rule.getRuleDefinition());
		ruleHistory.setUpdateTime(LocalDateTime.now());
		return ruleHistory;
	}

	@Override
	public boolean edit(Rule rule) {
		Rule sqlRule = ruleService.getById(rule.getId());
		Assert.notNull(sqlRule, "rule  can not exists.");
		if (ruleService.updateById(rule)) {
			SpringUtils.publishEvent(new RuleChangeEvent(convertToRuleHistory(rule)));
			String ruleJson = JSONUtil.toJsonStr(RuleConverter.INSTANCE.poToVo(rule));
			if (!sqlRule.getScripts().equals(rule.getScripts())) {
				eventDistributor.distribute(SubscribeEnum.PUB_SUB_RULE_SCRIPT_CHANNEL.getChannel(), ruleJson);
			}
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_RULE_CHANNEL.getChannel(), ruleJson);
			return true;
		}
		return false;
	}

	@Override
	public boolean del(Long id) {
		Rule rule = ruleService.getById(id);
		Assert.notNull(rule, "rule  can not exists.");
		if (ruleService.removeById(id)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_RULE_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(RuleConverter.INSTANCE.poToVo(rule)));
			return true;
		}
		return false;
	}

	@Override
	public List<DataColumn> selectColumns(Long modelId) {
		List<DataColumn> dataColumns = new ArrayList<>();
		// 1.基础字段列
		DataColumn fieldDataColumn = new DataColumn(DataColumnType.FIELDS.getDesc(), DataColumnType.FIELDS.getName());
		List<FieldVO> fieldVOS = fieldService.listByModelId(modelId);
		if (CollectionUtil.isNotEmpty(fieldVOS)) {
			List<DataColumn> fieldChildren = new ArrayList<>();
			fieldVOS.forEach(field -> fieldChildren
					.add(new DataColumn(field.getLabel(), field.getFieldName(), field.getFieldType())));
			fieldDataColumn.setChildren(fieldChildren);
		}
		dataColumns.add(fieldDataColumn);
		// 2.预处理字段列
		DataColumn parentPreItemDataColumn = new DataColumn(DataColumnType.PREITEMS.getDesc(),
				DataColumnType.PREITEMS.getName());
		List<PreItemVO> preItemVOS = preItemService.listByModelId(modelId);
		if (CollectionUtil.isNotEmpty(preItemVOS)) {
			List<DataColumn> preItemChildren = new ArrayList<>();
			preItemVOS.forEach(preItem -> {
				DataColumn dataColumn = new DataColumn();
				dataColumn.setLabel(preItem.getLabel());
				dataColumn.setValue(preItem.getDestField());
				dataColumn.setType(preItem.getDestFieldType());
				preItemChildren.add(dataColumn);
			});

		}
		dataColumns.add(parentPreItemDataColumn);
		// 3. 特征字段提取
		DataColumn abstractionDataColumn = new DataColumn(DataColumnType.ABSTRACTIONS.getDesc(),
				DataColumnType.ABSTRACTIONS.getName());
		List<AbstractionVO> abstractionVOS = abstractionService.listByModelId(modelId);
		if (CollectionUtil.isNotEmpty(abstractionVOS)) {
			List<DataColumn> preItemChildren = new ArrayList<>();
			abstractionVOS.forEach(abstractionVO -> {
				DataColumn dataColumn = new DataColumn();
				dataColumn.setLabel(abstractionVO.getLabel());
				dataColumn.setValue(abstractionVO.getName());
				dataColumn.setType(FieldType.DOUBLE.name());
				preItemChildren.add(dataColumn);
			});
			abstractionDataColumn.setChildren(preItemChildren);
		}
		dataColumns.add(abstractionDataColumn);
		return dataColumns;
	}

}
