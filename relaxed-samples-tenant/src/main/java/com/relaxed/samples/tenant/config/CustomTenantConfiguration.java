package com.relaxed.samples.tenant.config;

import cn.hutool.core.collection.ListUtil;
import com.relaxed.common.tenant.core.table.DataScope;
import com.relaxed.common.tenant.interceptor.TenantInterceptor;
import com.relaxed.common.tenant.parse.DefaultSqlParser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yakir
 * @Topic TenantConfig
 * @Description 若启用表处理器,插入需要自己维护租户列的插入
 * @date 2021/7/27 20:30
 * @Version 1.0
 */
@RequiredArgsConstructor
@Configuration
public class CustomTenantConfiguration {

	/**
	 * 多租户拦截器
	 * @author yakir
	 * @date 2021/7/27 21:08
	 * @return com.relaxed.common.tenant.interceptor.TenantInterceptor
	 */
	@Bean
	public TenantInterceptor tenantInterceptor() {
		CustomDataSchemaHandler customDataSchemaHandler = new CustomDataSchemaHandler();
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
