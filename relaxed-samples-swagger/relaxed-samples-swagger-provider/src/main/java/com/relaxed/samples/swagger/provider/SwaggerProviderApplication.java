package com.relaxed.samples.swagger.provider;

import com.relaxed.common.swagger.annotation.EnableSwagger2Provider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yakir
 * @Topic SwaggerProviderApplication
 * @Description
 * @date 2021/7/8 14:44
 * @Version 1.0
 */
@EnableSwagger2Provider
@SpringBootApplication(scanBasePackages = "com.relaxed")
public class SwaggerProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerProviderApplication.class, args);
	}

}
