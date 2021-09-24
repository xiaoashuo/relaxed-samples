package com.relaxed.samples.risk.admin;

import com.relaxed.common.swagger.annotation.EnableSwagger2Provider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Yakir
 * @Topic RiskAdminApplication
 * @Description
 * @date 2021/9/24 11:31
 * @Version 1.0
 */
@EnableAsync
@EnableSwagger2Provider
@MapperScan(basePackages = "com.relaxed.**.mapper")
@SpringBootApplication(scanBasePackages = "com.relaxed")
public class RiskAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskAdminApplication.class);
	}

}
