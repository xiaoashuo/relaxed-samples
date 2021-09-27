package com.relaxed.samples.risk.engine;

import com.relaxed.common.ip.Ip2RegionSearcher;
import com.relaxed.common.ip.IpAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.lionsoul.ip2region.DataBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author Yakir
 * @Topic IpSearchTest
 * @Description
 * @date 2021/9/27 14:39
 * @Version 1.0
 */
@SpringBootTest(classes = RiskEngineApplication.class)
public class IpSearchTest {

	@Autowired
	private Ip2RegionSearcher ip2RegionSearcher;

	@Test
	public void testIpSearch() throws IOException {
		DataBlock dataBlock = ip2RegionSearcher.getDelegate().memorySearch("140.206.193.86");
		System.out.println(dataBlock);
	}

}
