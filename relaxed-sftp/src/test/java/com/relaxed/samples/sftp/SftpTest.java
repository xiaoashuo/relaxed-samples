package com.relaxed.samples.sftp;

import com.relaxed.common.jsch.sftp.SftpAutoConfiguration;
import com.relaxed.common.jsch.sftp.client.ISftpClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.File;
import java.util.List;

/**
 * @author Yakir
 * @Topic SftpTest
 * @Description
 * @date 2023/8/2 13:48
 * @Version 1.0
 */
//使用@ContextConfiguration或@SpringJUnitConfig指定配置文件或配置类
@Slf4j
//@SpringJUnitConfig(classes = SftpAutoConfiguration.class)
@ContextConfiguration(classes = SftpAutoConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)

//@SpringBootApplication

public class SftpTest {

    @Autowired
    ISftpClient sftpClient;

    private static String ROOT_PATH="/zhixiao/10000003/upload";
    @Test
    void testList(){
        List<String> fileNames = sftpClient.supplyOpen(sftp -> sftp.list(ROOT_PATH));
        for (String fileName : fileNames) {
            String fullPath=ROOT_PATH+"/"+fileName;
            Boolean isDir = sftpClient.supplyOpen(sftp -> sftp.isDir(fullPath));
            log.info("当前文件名称{},是否为目录{},全文件路径{}",fileName,isDir,fullPath);
        }
    }
    @Test
    void testUpload(){
        File uploadFile = new File("D:\\20220713.TXT");
        String filename = uploadFile.getName();
        sftpClient.open(sftp->sftp.upload(ROOT_PATH,filename,uploadFile));
        log.info("文件上传成功,文件路径{}",ROOT_PATH+"/"+filename);
    }

    @Test
    void testMove(){
        String originPath="/zhixiao/10000003/upload/20220713.TXT";
        String targetPath="/zhixiao/10000003/upload/test/20220713.TXT";
        sftpClient.open(sftp->sftp.move(originPath,targetPath));
        log.info("文件移动成功");
    }
    @Test
    void testDownload(){
        String downloadPath="/zhixiao/10000003/upload/test/20220713.TXT";
        File localFile = new File("D:\\2007.TXT");
        sftpClient.open(sftp->sftp.download(downloadPath,localFile));
        //byte[] fileBytes = sftpClient.supplyOpen(sftp -> sftp.download(downloadPath));
        log.info("文件下载成功");


    }
    @Test
    void testDelete(){
        String downloadPath="/zhixiao/10000003/upload/test/20220713.TXT";
        sftpClient.open(sftp->sftp.delete(downloadPath));
        log.info("文件删除成功");
    }
}

