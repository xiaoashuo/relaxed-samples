package com.relaxed.samples.tenant.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.relaxed.extend.mybatis.plus.service.impl.ExtendServiceImpl;
import com.relaxed.samples.tenant.mapper.TenantDataSourceConfigMapper;
import com.relaxed.samples.tenant.model.converter.TenantConfigConverter;
import com.relaxed.samples.tenant.model.converter.TenantDataSourceConfigConverter;
import com.relaxed.samples.tenant.model.entity.TenantDataSourceConfig;
import com.relaxed.samples.tenant.model.qo.TenantDataSourceConfigQO;

import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;

import com.relaxed.samples.tenant.model.vo.TenantConfigVO;
import com.relaxed.samples.tenant.model.vo.TenantDataSourceConfigVO;
import com.relaxed.samples.tenant.service.TenantDataSourceConfigService;
import com.relaxed.samples.tenant.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据源 业务层实现
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T15:36:12.631
 */
@RequiredArgsConstructor
@Service
public class TenantDataSourceConfigServiceImpl
		extends ExtendServiceImpl<TenantDataSourceConfigMapper, TenantDataSourceConfig>
		implements TenantDataSourceConfigService {

	@Override
	public PageResult<TenantDataSourceConfigVO> selectByPage(PageParam pageParam,
			TenantDataSourceConfigQO tenantDataSourceConfigQO) {
		IPage<TenantDataSourceConfig> page = PageUtil.prodPage(pageParam);
		LambdaQueryWrapper<TenantDataSourceConfig> wrapper = Wrappers.lambdaQuery(TenantDataSourceConfig.class).eq(
				ObjectUtil.isNotNull(tenantDataSourceConfigQO.getId()), TenantDataSourceConfig::getId,
				tenantDataSourceConfigQO.getId());
		IPage<TenantDataSourceConfigVO> pageVo = this.baseMapper.selectPage(page, wrapper)
				.convert(TenantDataSourceConfigConverter.INSTANCE::poToVo);
		return new PageResult<>(pageVo.getRecords(), pageVo.getTotal());
	}

}
