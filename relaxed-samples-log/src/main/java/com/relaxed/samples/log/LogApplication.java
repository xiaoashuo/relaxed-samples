package com.relaxed.samples.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yakir
 * @Topic LogApplication
 * @Description
 * @date 2023/12/22 14:44
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.relaxed")
public class LogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class,args);
    }
}
