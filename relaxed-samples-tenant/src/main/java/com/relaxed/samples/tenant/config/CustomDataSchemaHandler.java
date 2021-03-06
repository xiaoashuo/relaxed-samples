package com.relaxed.samples.tenant.config;

import com.relaxed.common.tenant.core.schema.SchemaHandler;
import com.relaxed.samples.tenant.holder.TenantHolder;
import lombok.RequiredArgsConstructor;

/**
 * @author Yakir
 * @Topic CustomDataSchemaHandler
 * @Description
 * @date 2021/7/27 20:30
 * @Version 1.0
 */
@RequiredArgsConstructor
public class CustomDataSchemaHandler implements SchemaHandler {

	/**
	 * 开启schema 独立数据库 多schema 多数据源实现方式类似
	 * @author yakir
	 * @date 2021/7/27 21:27
	 * @return boolean
	 */
	@Override
	public boolean enable() {
		return true;
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
		return TenantHolder.getSchema();
	}

}
