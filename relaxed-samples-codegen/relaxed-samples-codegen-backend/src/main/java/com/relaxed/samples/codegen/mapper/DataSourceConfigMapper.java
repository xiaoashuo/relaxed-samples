package com.relaxed.samples.codegen.mapper;

import com.relaxed.common.core.domain.SelectData;
import com.relaxed.extend.mybatis.plus.mapper.ExtendMapper;
import com.relaxed.samples.codegen.model.entity.DataSourceConfig;

import java.util.List;

/**
 * 数据库管理
 *
 * @author Yakir
 */
public interface DataSourceConfigMapper extends ExtendMapper<DataSourceConfig> {

	/**
	 * 展示数据源下来列表
	 * @return
	 */
	List<SelectData<?>> listSelectData();

}