package com.relaxed.samples.codegen;

import com.relaxed.common.swagger.annotation.EnableSwagger2Provider;
import org.aspectj.apache.bcel.classfile.Code;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yakir
 * @Topic CodeGenApplication
 * @Description
 * @date 2021/7/10 16:41
 * @Version 1.0
 */
@MapperScan(basePackages = "com.relaxed.samples.codegen.mapper")
@EnableSwagger2Provider
@SpringBootApplication(scanBasePackages = "com.relaxed")
public class CodeGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeGenApplication.class, args);
	}

}
