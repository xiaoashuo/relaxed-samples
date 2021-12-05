package com.relaxed.samples.test;

import com.relaxed.common.oss.s3.OssClient;
import com.relaxed.common.oss.s3.domain.StreamMeta;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.relaxed.common.oss")
@SpringBootTest
@ActiveProfiles("tx")
public class OssTest {

	@Autowired
	private OssClient ossClient;
	@SneakyThrows
	@Test
	void txUpload() {

		String relativePath = "tx/test3.jpg";
		File file = new File("D:\\other\\images\\duola.jpg");
		InputStream stream = new FileInputStream(file);
		StreamMeta streamMeta = StreamMeta.convertToByteStreamMeta(stream);
		String downloadUrl = ossClient.upload(streamMeta.getInputStream(), streamMeta.getSize(), relativePath);
		log.info("上传结果:{}", downloadUrl);
		Assert.state(ossClient.getDownloadUrl(relativePath).equals(downloadUrl), "下载地址不一致");
	}

	@SneakyThrows
	@Test
	void txCopy() {
		String sourcePath = "tx/test3.jpg";
		String destPath = "tx/test4.jpg";
		String copyDownloadUrl = ossClient.copy(sourcePath, destPath);
		// String copyDownloadUrl = ossClient.copy("test", "img/test3.jpg",
		// destBucketName, destPath);
		Assert.state(ossClient.getDownloadUrl(destPath).equals(copyDownloadUrl), "Copy下载地址不一致");
		log.info("copy结果:{}", copyDownloadUrl);
	}

	@SneakyThrows
	@Test
	void txDelete() {
		// 单条删除
		String relativePath = "tx/test4.jpg";
		ossClient.delete(relativePath);

		// 批量删除
		// Set<String> paths = new HashSet<>();
		// paths.add("img/test2.jpg");
		// paths.add("img/test3.jpg");
		// ossClient.batchDelete(paths);
	}

	@SneakyThrows
	@Test
	void aliList() {
		String bucketName = "t";
		List<String> paths = ossClient.list(bucketName);
		log.info("结果数组:{}", paths);
	}

}
