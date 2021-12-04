package com.relaxed.samples.test;

import com.relaxed.common.oss.s3.OssClient;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.relaxed.common.oss")
@SpringBootTest
@ActiveProfiles("minio")
public class OssTest {

	@Autowired
	private OssClient ossClient;

	@SneakyThrows
	@Test
	void aliList() {
		String bucketName = "t";
		List<String> paths = ossClient.list(bucketName);
		log.info("结果数组:{}", paths);
	}

}
