package com.relaxed.samples.xxljob;

import com.relaxed.common.job.annotation.EnableXxlJob;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

/**
 * @author Yakir
 * @Topic XxlJobApplication
 * @Description
 * @date 2023/8/2 14:56
 * @Version 1.0
 */
@EnableXxlJob
@SpringBootApplication
public class XxlJobApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(XxlJobApplication.class,args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while(true) {
            System.out.println("now is " + new Date().toLocaleString());
            Thread.sleep(1000);
        }
    }
}
