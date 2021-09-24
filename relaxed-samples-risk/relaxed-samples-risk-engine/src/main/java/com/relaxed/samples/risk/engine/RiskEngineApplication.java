package com.relaxed.samples.risk.engine;

import com.relaxed.common.swagger.annotation.EnableSwagger2Provider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yakir
 * @Topic EngineApplication
 * @Description
 * @date 2021/9/1 15:11
 * @Version 1.0
 */
@EnableSwagger2Provider
@MapperScan(basePackages = "com.relaxed.**.mapper")
@SpringBootApplication(scanBasePackages = "com.relaxed")
public class RiskEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskEngineApplication.class, args);
	}

}
