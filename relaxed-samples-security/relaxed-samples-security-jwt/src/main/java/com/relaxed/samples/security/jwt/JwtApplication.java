package com.relaxed.samples.security.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yakir
 * @Topic JwtApplication
 * @Description
 * @date 2021/8/15 12:29
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.relaxed")
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

}
