package com.relaxed.samples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relaxed.autoconfigure.log.annotation.EnableAccessLog;
import com.relaxed.autoconfigure.log.annotation.EnableOperationLog;
import com.relaxed.common.job.annotation.EnableXxlJob;
import com.relaxed.common.xss.config.XssProperties;
import com.relaxed.common.xss.json.XssStringJsonDeserializer;
import com.relaxed.common.xss.json.XssStringJsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * @author Yakir
 * @Topic SamplesApplication
 * @Description
 * @date 2021/6/21 11:29
 * @Version 1.0
 */
@EnableXxlJob
@EnableAccessLog
@EnableOperationLog
@SpringBootApplication(scanBasePackages = "com.relaxed")
public class SamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamplesApplication.class, args);
	}

}
