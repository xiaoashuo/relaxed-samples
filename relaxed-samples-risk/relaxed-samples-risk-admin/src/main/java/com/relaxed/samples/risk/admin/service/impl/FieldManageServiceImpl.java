package com.relaxed.samples.risk.admin.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.relaxed.common.cache.annotation.CacheDel;
import com.relaxed.common.cache.annotation.Cached;
import com.relaxed.common.risk.biz.distributor.event.EventDistributor;
import com.relaxed.common.risk.biz.distributor.event.subscribe.SubscribeEnum;
import com.relaxed.common.risk.biz.exception.RiskCode;
import com.relaxed.common.risk.biz.exception.RiskException;
import com.relaxed.common.risk.biz.service.FieldService;
import com.relaxed.common.risk.biz.service.ModelService;
import com.relaxed.common.risk.biz.service.PreItemService;
import com.relaxed.common.risk.model.converter.FieldConverter;
import com.relaxed.common.risk.model.converter.PreItemConverter;
import com.relaxed.common.risk.model.entity.Field;
import com.relaxed.common.risk.model.entity.Model;
import com.relaxed.common.risk.model.entity.PreItem;
import com.relaxed.common.risk.model.vo.FieldVO;
import com.relaxed.common.risk.model.vo.PreItemVO;
import com.relaxed.samples.risk.admin.service.FieldManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * @author Yakir
 * @Topic FieldManageServiceImpl
 * @Description
 * @date 2021/9/26 11:57
 * @Version 1.0
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class FieldManageServiceImpl implements FieldManageService {

	private final FieldService fieldService;

	private final PreItemService preItemService;

	private final ModelService modelService;

	private final EventDistributor eventDistributor;

	@Override
	public List<FieldVO> fieldListByModelId(Long modelId) {
		return fieldService.listByModelId(modelId);
	}


	@Override
	public boolean fieldAdd(Field field) {
		Long modelId = field.getModelId();
		String fieldName = field.getFieldName();
		Field sqlField = fieldService.selectOne(modelId, fieldName);
		Assert.isNull(sqlField, "model field name already exists.");
		if (fieldService.save(field)) {
			// 发布订阅
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_FIELD_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(FieldConverter.INSTANCE.poToVo(field)));
			return true;
		}
		return false;
	}


	@Override
	public boolean fieldEdit(Field field) {
		Field sqlField = fieldService.getById(field.getId());
		Assert.notNull(sqlField, "field can not exists.");
		if (fieldService.updateById(field)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_FIELD_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(FieldConverter.INSTANCE.poToVo(field)));
			return true;
		}
		return false;
	}


	@Override
	public boolean fieldDel(Long id) {
		Field field = fieldService.getById(id);
		Assert.notNull(field, "field can not exists.");
		Long modelId = field.getModelId();
		Model model = modelService.getById(modelId);
		Assert.notNull(field, "model can not exists.");
		String fieldName = field.getFieldName();
		if (model.getEntryName().equals(fieldName) || model.getReferenceDate().equals(fieldName)) {
			throw new RiskException(RiskCode.FIELD_NOT_ALLOWED_DEL);
		}
		if (fieldService.removeById(id)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_FIELD_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(FieldConverter.INSTANCE.poToVo(field)));
			return true;
		}
		return false;
	}

	@Override
	public List<PreItemVO> preItemListByModelId(Long modelId) {
		return preItemService.listByModelId(modelId);
	}

	@Override
	public boolean preItemFieldAdd(PreItem preItem) {
		PreItem sqlPreItem = preItemService.getOne(preItem.getModelId(), preItem.getDestField());
		// 预处理字段已存在 则抛出异常
		Assert.isNull(sqlPreItem, "pre item has already exists.");
		// 保存预处理字段
		if (preItemService.save(preItem)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_PRE_ITEM_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(PreItemConverter.INSTANCE.poToVo(preItem)));
			return true;
		}
		return false;
	}

	@Override
	public boolean preItemFieldEdit(PreItem preItem) {
		PreItem sqlPreItem = preItemService.getById(preItem.getId());
		Assert.notNull(sqlPreItem, "pre item can not be null.");
		if (preItemService.updateById(preItem)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_PRE_ITEM_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(PreItemConverter.INSTANCE.poToVo(preItem)));
			return true;
		}
		return false;
	}

	@Override
	public boolean preItemFieldDel(Long modelId, Long id) {
		PreItem preItem = preItemService.getOne(modelId, id);
		Assert.notNull(preItem, "pre item not exists.");
		if (preItemService.removeById(id)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_PRE_ITEM_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(PreItemConverter.INSTANCE.poToVo(preItem)));
			return true;
		}
		return false;
	}

}
