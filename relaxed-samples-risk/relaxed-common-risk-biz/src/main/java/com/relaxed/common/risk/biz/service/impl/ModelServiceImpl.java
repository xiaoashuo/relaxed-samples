package com.relaxed.common.risk.biz.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.relaxed.common.cache.annotation.Cached;
import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;

import com.relaxed.common.risk.repository.mapper.ModelMapper;
import com.relaxed.common.risk.biz.service.ModelService;
import com.relaxed.common.risk.model.converter.ModelConverter;
import com.relaxed.common.risk.model.entity.Model;
import com.relaxed.common.risk.model.qo.ModelQO;
import com.relaxed.common.risk.model.vo.ModelVO;
import com.relaxed.extend.mybatis.plus.service.impl.ExtendServiceImpl;
import com.relaxed.extend.mybatis.plus.toolkit.PageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 * 业务层实现
 * </p>
 *
 * @author Yakir
 * @since 2021-08-29T09:04:20.388
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ModelServiceImpl extends ExtendServiceImpl<ModelMapper, Model> implements ModelService {

	@Override
	public Model getByModelName(String modelName) {
		return baseMapper.getByModelName(modelName);
	}

	@Override
	public PageResult<ModelVO> selectByPage(PageParam pageParam, ModelQO modelQO) {
		IPage<Model> page = PageUtil.prodPage(pageParam);
		LambdaQueryWrapper<Model> wrapper = Wrappers.lambdaQuery(Model.class).eq(ObjectUtil.isNotNull(modelQO.getId()),
				Model::getId, modelQO.getId());
		this.baseMapper.selectPage(page, wrapper);
		IPage<ModelVO> voPage = page.convert(ModelConverter.INSTANCE::poToVo);
		return new PageResult<>(voPage.getRecords(), voPage.getTotal());
	}

	@Override
	public List<ModelVO> listByStatus(Integer status) {
		List<Model> list = baseMapper.listByStatus(status);
		return ModelConverter.INSTANCE.poToVOs(list);
	}

	@Override
	public ModelVO getByGuid(String guid) {
		log.info("model service getByGuid,{}", guid);
		Model model = baseMapper.getByGuid(guid);
		return model != null ? ModelConverter.INSTANCE.poToVo(model) : null;
	}

}
