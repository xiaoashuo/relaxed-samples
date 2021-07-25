package com.relaxed.samples.datascope;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yakir
 * @Topic DataScopeApplication
 * @Description
 * @date 2021/7/25 17:04
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.relaxed")
@MapperScan("com.relaxed.samples.datascope.mapper")
public class DataScopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataScopeApplication.class, args);
	}

}
