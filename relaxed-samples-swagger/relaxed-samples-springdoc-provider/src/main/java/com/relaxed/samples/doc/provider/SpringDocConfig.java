package com.relaxed.samples.doc.provider;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SpringDocConfig {

	@Bean
	public OpenAPI mallTinyOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Mall-Tiny API").description("SpringDoc API 演示").version("v1.0.0")
						.license(new License().name("Apache 2.0").url("https://github.com/macrozheng/mall-learning")))
				.externalDocs(new ExternalDocumentation().description("SpringBoot实战电商项目mall（50K+Star）全套文档")
						.url("http://www.macrozheng.com"));
	}

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("brand").pathsToMatch("/test/**").build();
	}

	@Configuration
	public class WebMvcConfig extends WebMvcConfigurationSupport {

		@Override
		protected void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/swagger-ui/**")
					.addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/3.49.0/");
			super.addResourceHandlers(registry);
		}

	}

	// @Bean
	// public OpenAPI mallTinyOpenAPI() {
	// return new OpenAPI()
	// .info(new Info().title("Mall-Tiny API")
	// .description("SpringDoc API 演示")
	// .version("v1.0.0")
	// .license(new License().name("Apache
	// 2.0").url("https://github.com/macrozheng/mall-learning")))
	// .externalDocs(new ExternalDocumentation()
	// .description("SpringBoot实战电商项目mall（50K+Star）全套文档")
	// .url("http://www.macrozheng.com"));
	// }

}
