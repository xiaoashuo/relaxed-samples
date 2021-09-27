package com.relaxed.samples.risk.engine;

import com.relaxed.common.swagger.annotation.EnableSwagger2Provider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yakir
 * @Topic EngineApplication
 * @Description
 * <p>
 * 风控引擎 核心思路 1.提交事件 2.提取特征 3.机器学习打分 4.决策集模块 (支持多决策集) 一、提取规则 二、计算打分 三、计算总分 四、决定单决策集打分是否通过
 * </p>
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
