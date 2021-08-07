package com.relaxed.samples.tenant.mapper;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.extend.mybatis.plus.mapper.ExtendMapper;
import com.relaxed.samples.tenant.model.entity.TenantDataSourceConfig;
import com.relaxed.samples.tenant.model.qo.TenantDataSourceConfigQO;
import com.relaxed.samples.tenant.model.vo.TenantDataSourceConfigVO;

/**
 * <p>
 * 数据源 Mapper 接口
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T15:36:12.631
 */
public interface TenantDataSourceConfigMapper extends ExtendMapper<TenantDataSourceConfig> {

}
