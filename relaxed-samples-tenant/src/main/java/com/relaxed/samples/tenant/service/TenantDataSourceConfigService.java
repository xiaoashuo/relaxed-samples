package com.relaxed.samples.tenant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.extend.mybatis.plus.service.ExtendService;
import com.relaxed.samples.tenant.model.entity.TenantDataSourceConfig;
import com.relaxed.samples.tenant.model.qo.TenantDataSourceConfigQO;
import com.relaxed.samples.tenant.model.vo.TenantDataSourceConfigVO;

/**
 * <p>
 * 数据源 业务层
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T15:36:12.631
 */
public interface TenantDataSourceConfigService extends ExtendService<TenantDataSourceConfig> {

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam}
	 * @param tenantDataSourceConfigQO {@link TenantDataSourceConfigQO}
	 * @return {@link PageResult<TenantDataSourceConfigVO>}
	 */
	PageResult<TenantDataSourceConfigVO> selectByPage(PageParam pageParam,
			TenantDataSourceConfigQO tenantDataSourceConfigQO);

}