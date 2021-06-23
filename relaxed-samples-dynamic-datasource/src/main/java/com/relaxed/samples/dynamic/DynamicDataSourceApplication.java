package com.relaxed.samples.dynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yakir
 * @Topic DynamicDataSourceApplication
 * @Description
 * @date 2021/6/23 10:14
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.relaxed")
public class DynamicDataSourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicDataSourceApplication.class,args);
    }
}
