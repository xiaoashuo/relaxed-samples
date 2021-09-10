package com.relaxed.samples.risk.engine;

import com.relaxed.common.risk.engine.core.plugins.PluginService;
import com.relaxed.samples.risk.engine.EngineApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Yakir
 * @Topic RiskControllerTest
 * @Description
 * @date 2021/9/7 17:17
 * @Version 1.0
 */
@SpringBootTest(classes = EngineApplication.class)
class RiskControllerTest {

    @Test
    public void test(){
        List<PluginService> pluginServices = SpringFactoriesLoader.loadFactories(PluginService.class, null);
        System.out.println(pluginServices);
    }
}