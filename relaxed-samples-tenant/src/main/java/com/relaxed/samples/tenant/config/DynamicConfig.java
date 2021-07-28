package com.relaxed.samples.tenant.config;

import com.baomidou.dynamic.datasource.processor.DsHeaderProcessor;
import com.baomidou.dynamic.datasource.processor.DsProcessor;
import com.baomidou.dynamic.datasource.processor.DsSessionProcessor;
import com.baomidou.dynamic.datasource.processor.DsSpelExpressionProcessor;
import com.relaxed.common.datasource.processor.DsRequestProcessor;
import com.relaxed.samples.tenant.service.TenantConfigService;
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
