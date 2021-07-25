package com.relaxed.samples.datascope.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.relaxed.common.datascope.DataScope;
import com.relaxed.common.datascope.handler.AbstractDataPermissionHandler;
import com.relaxed.common.datascope.handler.DataPermissionHandler;
import com.relaxed.common.datascope.interceptor.DataPermissionInterceptor;
import com.relaxed.common.datascope.parse.DataSqlParse;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author miemie
 * @since 2018-08-10
 */
@Configuration
public class MybatisPlusConfig {

	@Bean
	public DataPermissionInterceptor dataPermissionInterceptor(List<DataScope> dataScopeList) {
		DataPermissionHandler dataPermissionHandler = new AbstractDataPermissionHandler(dataScopeList) {
			@Override
			public boolean ignore(String mappedStatementId) {
				return false;
			}
		};
		DataSqlParse dataScopeSqlProcessor = new DataSqlParse();
		return new DataPermissionInterceptor(dataScopeSqlProcessor, dataPermissionHandler);
	}

}
