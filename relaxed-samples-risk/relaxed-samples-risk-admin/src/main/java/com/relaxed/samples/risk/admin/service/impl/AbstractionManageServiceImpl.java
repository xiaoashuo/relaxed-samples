package com.relaxed.samples.risk.admin.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.relaxed.common.core.util.SpringUtils;
import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.risk.biz.distributor.EventDistributor;
import com.relaxed.common.risk.biz.distributor.subscribe.SubscribeEnum;
import com.relaxed.common.risk.biz.service.AbstractionService;
import com.relaxed.common.risk.model.converter.AbstractionConverter;
import com.relaxed.common.risk.model.converter.RuleConverter;
import com.relaxed.common.risk.model.entity.Abstraction;
import com.relaxed.common.risk.model.entity.Rule;
import com.relaxed.common.risk.model.enums.ModelEnums;
import com.relaxed.common.risk.model.qo.AbstractionQO;
import com.relaxed.common.risk.model.vo.AbstractionVO;
import com.relaxed.samples.risk.admin.event.RuleChangeEvent;
import com.relaxed.samples.risk.admin.service.AbstractionManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

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
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_ABSTRACTION_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(AbstractionConverter.INSTANCE.poToVo(abstraction)));
			return true;
		}
		return false;
	}

	@Override
	public boolean del(Long id) {
		Abstraction sqlAbstraction = abstractionService.getById(id);
		Assert.notNull(sqlAbstraction, "abstraction can not exists.");
		if (abstractionService.removeById(id)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_ABSTRACTION_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(AbstractionConverter.INSTANCE.poToVo(sqlAbstraction)));
			return true;
		}
		return false;
	}

}
