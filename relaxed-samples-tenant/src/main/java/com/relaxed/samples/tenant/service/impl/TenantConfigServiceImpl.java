package com.relaxed.samples.tenant.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.relaxed.extend.mybatis.plus.service.impl.ExtendServiceImpl;
import com.relaxed.samples.tenant.mapper.TenantConfigMapper;
import com.relaxed.samples.tenant.model.converter.TenantConfigConverter;
import com.relaxed.samples.tenant.model.entity.TenantConfig;
import com.relaxed.samples.tenant.model.qo.TenantConfigQO;

import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;
import com.relaxed.samples.tenant.model.vo.TenantConfigVO;
import com.relaxed.samples.tenant.service.TenantConfigService;
import com.relaxed.samples.tenant.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户配置 业务层实现
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T15:36:12.618
 */
@RequiredArgsConstructor
@Service
public class TenantConfigServiceImpl extends ExtendServiceImpl<TenantConfigMapper, TenantConfig>
		implements TenantConfigService {

	@Override
	public PageResult<TenantConfigVO> selectByPage(PageParam pageParam, TenantConfigQO tenantConfigQO) {
		IPage<TenantConfig> page = PageUtil.prodPage(pageParam);
		LambdaQueryWrapper<TenantConfig> wrapper = Wrappers.lambdaQuery(TenantConfig.class)
				.eq(ObjectUtil.isNotNull(tenantConfigQO.getId()), TenantConfig::getId, tenantConfigQO.getId());
		this.baseMapper.selectPage(page, wrapper);
		IPage<TenantConfigVO> pageVo = page.convert(TenantConfigConverter.INSTANCE::poToVo);
		return new PageResult<>(pageVo.getRecords(), pageVo.getTotal());
	}

	@Override
	public TenantConfig getByTenantId(Long tenantId) {
		LambdaQueryWrapper<TenantConfig> wrapper = Wrappers.lambdaQuery(TenantConfig.class)
				.eq(TenantConfig::getTenantId, tenantId);
		return baseMapper.selectOne(wrapper);
	}

}
