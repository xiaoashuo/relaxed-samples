package com.relaxed.samples.tenant.config;

import com.baomidou.dynamic.datasource.processor.DsHeaderProcessor;
import com.baomidou.dynamic.datasource.processor.DsProcessor;
import com.baomidou.dynamic.datasource.processor.DsSessionProcessor;
import com.baomidou.dynamic.datasource.processor.DsSpelExpressionProcessor;
import com.relaxed.common.datasource.processor.DsRequestProcessor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yakir
 * @Topic DynamicConfig
 * @Description 动态数据源配置
 * @date 2021/6/23 11:19
 * @Version 1.0
 */
@Configuration
public class DynamicConfig {

	@Bean
	public FilterRegistrationBean<TenantFilter> filterRegistrationBean() {
		FilterRegistrationBean<TenantFilter> registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new TenantFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.setName("tenant-filter");
		registrationBean.setOrder(1);
		return registrationBean;
	}

	@Bean
	public DsProcessor dsProcessor() {
		DsRequestProcessor requestProcessor = new DsRequestProcessor();
		DsHeaderProcessor headerProcessor = new DsHeaderProcessor();
		DsSessionProcessor sessionProcessor = new DsSessionProcessor();
		DsSpelExpressionProcessor spelExpressionProcessor = new DsSpelExpressionProcessor();
		requestProcessor.setNextProcessor(headerProcessor);
		headerProcessor.setNextProcessor(sessionProcessor);
		sessionProcessor.setNextProcessor(spelExpressionProcessor);
		return requestProcessor;
	}

}
