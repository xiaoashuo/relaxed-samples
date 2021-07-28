package com.relaxed.samples.tenant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;
import com.relaxed.extend.mybatis.plus.service.ExtendService;
import com.relaxed.samples.tenant.model.entity.TenantConfig;
import com.relaxed.samples.tenant.model.qo.TenantConfigQO;
import com.relaxed.samples.tenant.model.vo.TenantConfigVO;

/**
 * <p>
 * 租户配置 业务层
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T15:36:12.618
 */
public interface TenantConfigService extends ExtendService<TenantConfig> {

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam}
	 * @param tenantConfigQO {@link TenantConfigQO}
	 * @return {@link PageResult<TenantConfigVO>}
	 */
	PageResult<TenantConfigVO> selectByPage(PageParam pageParam, TenantConfigQO tenantConfigQO);

	/**
	 * 根据租户id获取租户配置
	 * @author yakir
	 * @date 2021/7/28 17:48
	 * @param tenantId
	 * @return com.relaxed.samples.tenant.model.entity.TenantConfig
	 */
	TenantConfig getByTenantId(Long tenantId);

}