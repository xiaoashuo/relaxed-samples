package com.relaxed.samples.tenant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yakir
 * @Topic TenantApplication
 * @Description
 * @date 2021/7/27 20:29
 * @Version 1.0
 */
@MapperScan("com.relaxed.samples.tenant.mapper")
@SpringBootApplication(scanBasePackages = "com.relaxed")
public class TenantApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenantApplication.class, args);
	}

}
