package com.relaxed.samples.tenant.model.converter;

import com.relaxed.samples.tenant.model.dto.TenantDataSourceConfigDTO;
import com.relaxed.samples.tenant.model.entity.TenantDataSourceConfig;
import com.relaxed.samples.tenant.model.vo.TenantDataSourceConfigVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 数据源 转换器
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T16:43:41.262
 */
@Mapper
public interface TenantDataSourceConfigConverter {

	TenantDataSourceConfigConverter INSTANCE = Mappers.getMapper(TenantDataSourceConfigConverter.class);

	/**
	 * po -> vo
	 * @param tenantDataSourceConfig {@link TenantDataSourceConfig}
	 * @return {@link TenantDataSourceConfigVO}
	 */
	TenantDataSourceConfigVO poToVo(TenantDataSourceConfig tenantDataSourceConfig);

	/**
	 * dto -> po
	 * @param tenantDataSourceConfigDTO {@link TenantDataSourceConfigDTO}
	 * @return {@link TenantDataSourceConfig}
	 */
	TenantDataSourceConfig dtoToPo(TenantDataSourceConfigDTO tenantDataSourceConfigDTO);

	/**
	 * po -> vos
	 * @param tenantDataSourceConfigProperties {@link List<TenantDataSourceConfig>}
	 * @return {@link List<TenantDataSourceConfigVO>}
	 */
	List<TenantDataSourceConfigVO> poToVOs(List<TenantDataSourceConfig> tenantDataSourceConfigProperties);

}
