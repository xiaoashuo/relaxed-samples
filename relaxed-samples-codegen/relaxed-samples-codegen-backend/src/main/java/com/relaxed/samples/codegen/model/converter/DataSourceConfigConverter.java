package com.relaxed.samples.codegen.model.converter;

import com.relaxed.samples.codegen.model.dto.DataSourceConfigDTO;
import com.relaxed.samples.codegen.model.entity.DataSourceConfig;
import com.relaxed.samples.codegen.model.vo.DataSourceConfigVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 数据源配置转换器
 *
 * @author Yakir
 */
@Mapper
public interface DataSourceConfigConverter {

	DataSourceConfigConverter INSTANCE = Mappers.getMapper(DataSourceConfigConverter.class);

	/**
	 * dto -> po
	 * @param dataSourceConfigDTO {@code dataSourceConfigDTO}
	 * @return {@code dataSourceConfig }
	 */
	DataSourceConfig dtoToPo(DataSourceConfigDTO dataSourceConfigDTO);

	/**
	 * po -> dto
	 * @param dataSourceConfig
	 * @return
	 */
	DataSourceConfigDTO poToDTO(DataSourceConfig dataSourceConfig);

	/**
	 * po -> vo
	 * @param dataSourceConfig
	 * @return
	 */
	DataSourceConfigVO poToVo(DataSourceConfig dataSourceConfig);

}
