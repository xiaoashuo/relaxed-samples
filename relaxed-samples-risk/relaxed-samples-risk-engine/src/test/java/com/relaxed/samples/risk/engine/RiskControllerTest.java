package com.relaxed.samples.risk.engine;

import com.relaxed.common.risk.engine.core.plugins.PluginService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * @author Yakir
 * @Topic RiskControllerTest
 * @Description
 * @date 2021/9/7 17:17
 * @Version 1.0
 */
@SpringBootTest(classes = RiskEngineApplication.class)
class RiskControllerTest {

	@Test
	public void test() {
		List<PluginService> pluginServices = SpringFactoriesLoader.loadFactories(PluginService.class, null);
		System.out.println(pluginServices);
	}

}