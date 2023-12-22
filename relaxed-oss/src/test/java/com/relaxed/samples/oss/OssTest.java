package com.relaxed.samples.oss;

import cn.hutool.core.io.FileUtil;
import com.relaxed.common.oss.s3.OssClient;
import com.relaxed.common.oss.s3.OssClientAutoConfiguration;
import com.relaxed.common.oss.s3.domain.StreamMeta;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;
import software.amazon.awssdk.utils.IoUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Yakir
 * @Topic OssTest
 * @Description
 * @date 2023/8/2 15:02
 * @Version 1.0
 */
@Slf4j
//@SpringJUnitConfig(classes = SftpAutoConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,classes = OssClientAutoConfiguration.class)
public class OssTest {

    /**
     * 测试用文件名,该文件在测试资源文件夹下
     */
    private static final String TEST_OBJECT_NAME = "test.txt";

    @Autowired
    private OssClient ossClient;

    @SneakyThrows
    @Test
    void txUpload() {
        String relativePath = "tx/test.txt";
        FileInputStream fileInputStream = new FileInputStream(
                ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + TEST_OBJECT_NAME));
        StreamMeta streamMeta = StreamMeta.convertToByteStreamMeta(fileInputStream);
        String downloadUrl = ossClient.upload(streamMeta.getInputStream(), streamMeta.getSize(), relativePath);
        log.info("上传结果:{}", downloadUrl);
        Assert.state(ossClient.getDownloadUrl(relativePath).equals(downloadUrl), "下载地址不一致");
    }

    @SneakyThrows
    @Test
    void txCopy() {
        String sourcePath = "tx/test.txt";
        String destPath = "tx/testByte.txt";
        String copyDownloadUrl = ossClient.copy(sourcePath, destPath);
        // String copyDownloadUrl = ossClient.copy("test", "img/test3.jpg",
        // destBucketName, destPath);
        Assert.state(ossClient.getDownloadUrl(destPath).equals(copyDownloadUrl), "Copy下载地址不一致");
        log.info("copy结果:{}", copyDownloadUrl);
    }
    @SneakyThrows
    @Test
    void txDownload() {
        String sourcePath = "tx/test.txt";
        File file = new File("D:\\dir\\test.txt");
        //下载到本地文件
        ossClient.download(sourcePath,new FileOutputStream(file));
        byte[] download = ossClient.download(sourcePath);
        File fileBytes = new File("D:\\dir\\testByte.txt");
        FileUtil.writeBytes(download,fileBytes);
        log.info("下载文件成功");
    }

    @SneakyThrows
    @Test
    void aliList() {
        String bucketName = "t";
        List<String> paths = ossClient.list(bucketName);
        log.info("结果数组:{}", paths);
    }
    @SneakyThrows
    @Test
    void txDelete() {
        // 单条删除
        // String relativePath = "tx/test4.jpg";
        // ossClient.delete(relativePath);

        // 批量删除
        Set<String> paths = new HashSet<>();
        paths.add("tx/test.txt");
        paths.add("tx/testByte.txt");
        ossClient.batchDelete(paths);
    }






}
