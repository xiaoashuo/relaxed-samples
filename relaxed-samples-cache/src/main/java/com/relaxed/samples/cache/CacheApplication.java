package com.relaxed.samples.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yakir
 * @Topic CacheApplication
 * @Description
 * @date 2021/7/24 13:49
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.relaxed")
public class CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}

}
