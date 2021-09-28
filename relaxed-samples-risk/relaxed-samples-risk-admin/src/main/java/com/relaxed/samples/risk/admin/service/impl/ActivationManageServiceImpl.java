package com.relaxed.samples.risk.admin.service.impl;

import cn.hutool.core.collection.CollectionUtil;

import cn.hutool.json.JSONUtil;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.risk.biz.distributor.event.EventDistributor;
import com.relaxed.common.risk.biz.distributor.event.subscribe.SubscribeEnum;
import com.relaxed.common.risk.biz.service.AbstractionService;
import com.relaxed.common.risk.biz.service.ActivationService;
import com.relaxed.common.risk.biz.service.FieldService;
import com.relaxed.common.risk.biz.service.PreItemService;
import com.relaxed.common.risk.model.converter.ActivationConverter;
import com.relaxed.common.risk.model.entity.Activation;
import com.relaxed.common.risk.model.enums.FieldType;
import com.relaxed.common.risk.model.qo.ActivationQO;
import com.relaxed.common.risk.model.vo.AbstractionVO;
import com.relaxed.common.risk.model.vo.ActivationVO;
import com.relaxed.common.risk.model.vo.FieldVO;
import com.relaxed.common.risk.model.vo.PreItemVO;

import com.relaxed.samples.risk.admin.model.domain.DataColumn;
import com.relaxed.samples.risk.admin.model.enums.DataColumnType;
import com.relaxed.samples.risk.admin.service.ActivationManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yakir
 * @Topic ActivationManageService
 * @Description
 * @date 2021/9/27 18:04
 * @Version 1.0
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class ActivationManageServiceImpl implements ActivationManageService {

	private final ActivationService activationService;

	private final EventDistributor eventDistributor;

	@Override
	public PageResult<ActivationVO> selectByPage(PageParam pageParam, ActivationQO activationQO) {
		return activationService.selectByPage(pageParam, activationQO);
	}

	@Override
	public boolean add(Activation activation) {
		if (activationService.save(activation)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_ACTIVATION_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(ActivationConverter.INSTANCE.poToVo(activation)));
			return true;
		}
		return false;
	}

	@Override
	public boolean edit(Activation activation) {
		Long activationId = activation.getId();
		Activation sqlActivation = activationService.getById(activationId);
		Assert.notNull(sqlActivation, "activation can not exists.");
		if (activationService.updateById(activation)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_ACTIVATION_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(ActivationConverter.INSTANCE.poToVo(activation)));
			return true;
		}
		return false;
	}

	@Override
	public boolean del(Long id) {
		Activation sqlActivation = activationService.getById(id);
		Assert.notNull(sqlActivation, "activation can not exists.");
		if (activationService.removeById(id)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_ACTIVATION_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(ActivationConverter.INSTANCE.poToVo(sqlActivation)));
			return true;
		}
		return false;
	}

}
