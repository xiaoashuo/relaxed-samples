package com.relaxed.samples.mail;

import com.relaxed.common.mail.MailAutoConfiguration;
import com.relaxed.extend.mail.model.MailDetails;
import com.relaxed.extend.mail.model.MailSendInfo;
import com.relaxed.extend.mail.sender.MailSender;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author Yakir
 * @Topic MailTest
 * @Description
 * @date 2023/8/3 10:40
 * @Version 1.0
 */
@Slf4j
@SpringBootTest(classes = {MailSenderAutoConfiguration.class ,MailAutoConfiguration.class})
public class MailTest {
    @Autowired
    private  MailSender mailSender;

    @Test
    void testSimpleMail(){
        String subject = "test";
        String content = "你好";
        String tos = "aaa@vipsave.cn";
        MailSendInfo sendInfo = mailSender.sendTextMail(subject, content, tos);
        //MailSendInfo htmlSendInfo = mailSender.sendHtmlMail(subject, content, tos);
        log.info("邮件发送,是否成功{}",sendInfo.getSuccess());
    }

    @SneakyThrows
    @Test
    void testComplexMail(){
        String subject = "test";
        String content = "你好";
        String[] tos = {"aaa@vipsave.cn"};
        String[] cc = {"xxx@vipsave.cn"};
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "test.txt");
        File[] files={file};
        MailDetails mailDetails = new MailDetails();
        mailDetails.setShowHtml(true);
        mailDetails.setSubject(subject);
        mailDetails.setContent(content);
        mailDetails.setTo(tos);
        mailDetails.setCc(cc);
        mailDetails.setFiles(files);
        MailSendInfo sendInfo = mailSender.sendMail(mailDetails);
        log.info("邮件发送,是否成功{}",sendInfo.getSuccess());
    }

}
