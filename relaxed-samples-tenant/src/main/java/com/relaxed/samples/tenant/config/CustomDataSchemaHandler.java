package com.relaxed.samples.tenant.config;

import com.relaxed.common.tenant.handler.schema.DataSchemaHandler;
import com.relaxed.samples.tenant.holder.SchemaHolder;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Yakir
 * @Topic CustomDataSchemaHandler
 * @Description
 * @date 2021/7/27 20:30
 * @Version 1.0
 */
@RequiredArgsConstructor
public class CustomDataSchemaHandler implements DataSchemaHandler {

	private final List<String> schemaList;

	/**
	 * 开启schema 独立数据库 多schema 多数据源实现方式类似 TODO 暂时不开启 需要建立多数据源方式
	 * @author yakir
	 * @date 2021/7/27 21:27
	 * @return boolean
	 */
	@Override
	public boolean enable() {
		return false;
	}

	/**
	 * 获取所有schema
	 * @author yakir
	 * @date 2021/7/27 21:31
	 * @return java.util.List<java.lang.String>
	 */
	@Override
	public List<String> getAllSchemas() {
		return schemaList;
	}

	/**
	 *
	 * 根据当前schema name 决定是否忽略
	 * @author yakir
	 * @date 2021/7/27 21:28
	 * @param currentSchema
	 * @return boolean
	 */
	@Override
	public boolean ignore(String currentSchema) {
		return false;
	}

	/**
	 * 根据mapper statement id 决定是否忽略当前schema
	 * @author yakir
	 * @date 2021/7/27 21:28
	 * @param mapperStatementId
	 * @return boolean
	 */
	@Override
	public boolean ignoreMethod(String mapperStatementId) {
		return false;
	}

	@Override
	public String getCurrentSchema() {
		// 此处可以拿动态数据源当前数据库名称
		// 拿到当前系统使用的数据库schema
		return SchemaHolder.get();
	}

}
