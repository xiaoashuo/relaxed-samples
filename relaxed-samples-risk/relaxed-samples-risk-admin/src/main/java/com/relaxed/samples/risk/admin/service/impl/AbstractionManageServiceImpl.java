package com.relaxed.samples.risk.admin.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.relaxed.common.core.util.SpringUtils;
import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;

import com.relaxed.common.risk.biz.distributor.event.EventDistributor;
import com.relaxed.common.risk.biz.distributor.event.subscribe.SubscribeEnum;
import com.relaxed.common.risk.biz.service.AbstractionService;
import com.relaxed.common.risk.biz.service.FieldService;
import com.relaxed.common.risk.biz.service.PreItemService;
import com.relaxed.common.risk.model.converter.AbstractionConverter;
import com.relaxed.common.risk.model.converter.RuleConverter;
import com.relaxed.common.risk.model.entity.Abstraction;
import com.relaxed.common.risk.model.entity.Rule;
import com.relaxed.common.risk.model.enums.FieldType;
import com.relaxed.common.risk.model.enums.ModelEnums;
import com.relaxed.common.risk.model.qo.AbstractionQO;
import com.relaxed.common.risk.model.vo.AbstractionVO;
import com.relaxed.common.risk.model.vo.FieldVO;
import com.relaxed.common.risk.model.vo.PreItemVO;
import com.relaxed.samples.risk.admin.event.RuleChangeEvent;
import com.relaxed.samples.risk.admin.model.domain.DataColumn;
import com.relaxed.samples.risk.admin.model.enums.DataColumnType;
import com.relaxed.samples.risk.admin.service.AbstractionManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yakir
 * @Topic AbstractionManageServiceImpl
 * @Description
 * @date 2021/9/24 17:57
 * @Version 1.0
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class AbstractionManageServiceImpl implements AbstractionManageService {

	private final AbstractionService abstractionService;

	private final EventDistributor eventDistributor;

	private final FieldService fieldService;

	private final PreItemService preItemService;

	@Override
	public PageResult<AbstractionVO> selectByPage(PageParam pageParam, AbstractionQO abstractionQO) {
		return abstractionService.selectByPage(pageParam, abstractionQO);
	}

	@Override
	public List<AbstractionVO> listByModelId(Long modelId) {
		return abstractionService.listByModelId(modelId);
	}

	@Override
	public boolean add(Abstraction abstraction) {
		String abstractionName = abstraction.getName();
		Abstraction sqlAbstraction = abstractionService.getByName(abstractionName);
		Assert.isNull(sqlAbstraction, "abstraction has already exists.");
		abstraction.setStatus(ModelEnums.StatusEnum.INIT.getStatus());
		if (abstractionService.save(abstraction)) {
			// 发布订阅
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_ABSTRACTION_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(AbstractionConverter.INSTANCE.poToVo(abstraction)));
			return true;
		}
		return false;
	}

	@Override
	public boolean edit(Abstraction abstraction) {
		Long abstractionId = abstraction.getId();
		Abstraction sqlAbstraction = abstractionService.getById(abstractionId);
		Assert.notNull(sqlAbstraction, "abstraction can not exists.");
		if (abstractionService.updateById(abstraction)) {
			String abstractionJson = JSONUtil.toJsonStr(AbstractionConverter.INSTANCE.poToVo(abstraction));
			// 发布订阅 脚本从内存清除
			if (!sqlAbstraction.getRuleScript().equals(abstraction.getRuleScript())) {
				eventDistributor.distribute(SubscribeEnum.PUB_SUB_ABSTRACTION_SCRIPT_CHANNEL.getChannel(),
						abstractionJson);
			}
			// 发布订阅信息变动
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_ABSTRACTION_CHANNEL.getChannel(), abstractionJson);
			return true;
		}
		return false;
	}

	@Override
	public boolean del(Long id) {
		Abstraction sqlAbstraction = abstractionService.getById(id);
		Assert.notNull(sqlAbstraction, "abstraction can not exists.");
		if (abstractionService.removeById(id)) {
			String jsonConfig = JSONUtil.toJsonStr(AbstractionConverter.INSTANCE.poToVo(sqlAbstraction));
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_ABSTRACTION_SCRIPT_CHANNEL.getChannel(), jsonConfig);
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_ABSTRACTION_CHANNEL.getChannel(), jsonConfig);
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
		return dataColumns;
	}

}
