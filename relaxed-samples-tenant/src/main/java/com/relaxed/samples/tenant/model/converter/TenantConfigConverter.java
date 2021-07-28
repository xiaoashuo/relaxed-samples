package com.relaxed.samples.tenant.model.converter;

import com.relaxed.samples.tenant.model.dto.TenantConfigDTO;
import com.relaxed.samples.tenant.model.entity.TenantConfig;
import com.relaxed.samples.tenant.model.vo.TenantConfigVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 租户配置 转换器
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T16:43:41.247
 */
@Mapper
public interface TenantConfigConverter {

	TenantConfigConverter INSTANCE = Mappers.getMapper(TenantConfigConverter.class);

	/**
	 * po -> vo
	 * @param tenantConfig {@link TenantConfig}
	 * @return {@link TenantConfigVO}
	 */
	TenantConfigVO poToVo(TenantConfig tenantConfig);

	/**
	 * dto -> po
	 * @param tenantConfigDTO {@link TenantConfigDTO}
	 * @return {@link TenantConfig}
	 */
	TenantConfig dtoToPo(TenantConfigDTO tenantConfigDTO);

	/**
	 * po -> vos
	 * @param tenantConfigProperties {@link List<TenantConfig>}
	 * @return {@link List<TenantConfigVO>}
	 */
	List<TenantConfigVO> poToVOs(List<TenantConfig> tenantConfigProperties);

}
