package com.relaxed.samples.risk.admin.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.risk.biz.distributor.event.EventDistributor;
import com.relaxed.common.risk.biz.distributor.event.subscribe.SubscribeEnum;
import com.relaxed.common.risk.biz.service.ModelService;
import com.relaxed.common.risk.model.converter.ModelConverter;
import com.relaxed.common.risk.model.entity.Model;
import com.relaxed.common.risk.model.enums.ModelEnums;
import com.relaxed.common.risk.model.qo.ModelQO;
import com.relaxed.common.risk.model.vo.ModelVO;
import com.relaxed.samples.risk.admin.service.ModelManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author Yakir
 * @Topic ModelManageServiceImpl
 * @Description
 * @date 2021/9/28 11:45
 * @Version 1.0
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class ModelManageServiceImpl implements ModelManageService {

	private final ModelService modelService;

	private final EventDistributor eventDistributor;

	@Override
	public PageResult<ModelVO> selectByPage(PageParam pageParam, ModelQO modelQO) {
		return modelService.selectByPage(pageParam, modelQO);
	}

	@Override
	public boolean add(Model model) {
		String modelName = model.getModelName();
		Model sqlModel = modelService.getByModelName(modelName);
		Assert.isNull(sqlModel, "model name has already exists.");
		model.setGuid(IdUtil.simpleUUID().toUpperCase());
		model.setStatus(ModelEnums.StatusEnum.INIT.getStatus());
		if (modelService.save(model)) {
			// 发布订阅
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_MODEL_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(ModelConverter.INSTANCE.poToVo(model)));
			return true;
		}
		return false;
	}

	@Override
	public boolean edit(Model model) {
		return false;
	}

	@Override
	public boolean del(Long id) {
		Model model = modelService.getById(id);
		Assert.notNull(model, "model not exists.");
		// 模型为模板 则不允许删除
		Assert.state(!ModelEnums.TemplateEnum.isTemplate(model.getTemplate()), "model is template,not allowed del.");
		if (modelService.removeById(id)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_MODEL_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(ModelConverter.INSTANCE.poToVo(model)));
			return true;
		}
		return false;
	}

}
