package com.relaxed.samples.tenant.config;

import cn.hutool.core.collection.ListUtil;
import com.relaxed.common.tenant.core.table.DataScope;
import com.relaxed.common.tenant.interceptor.TenantInterceptor;
import com.relaxed.common.tenant.parse.DefaultSqlParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yakir
 * @Topic TenantConfig
 * @Description
 * @date 2021/7/27 20:30
 * @Version 1.0
 */
@Configuration
public class TenantConfig {

	/**
	 * 多租户拦截器
	 * @author yakir
	 * @date 2021/7/27 21:08
	 * @return com.relaxed.common.tenant.interceptor.TenantInterceptor
	 */
	@Bean
	public TenantInterceptor tenantInterceptor() {
		List<String> schemas = ListUtil.toList("db1");
		// schema 处理器
		CustomDataSchemaHandler customDataSchemaHandler = new CustomDataSchemaHandler(schemas);
		// 数据域 主要作为租户列
		CustomDataScope customDataScope = new CustomDataScope();
		List<DataScope> dataScopes = ListUtil.toList(customDataScope);
		// table 处理器 针对表字段
		CustomDataTableHandle customDataTableHandle = new CustomDataTableHandle(dataScopes);
		// sql解析器
		DefaultSqlParser defaultSqlParser = new DefaultSqlParser();
		TenantInterceptor tenantInterceptor = new TenantInterceptor(customDataSchemaHandler, customDataTableHandle,
				defaultSqlParser);
		return tenantInterceptor;
	}

}
