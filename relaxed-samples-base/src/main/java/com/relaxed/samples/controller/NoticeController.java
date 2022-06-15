package com.relaxed.samples.controller;

import com.baomidou.mybatisplus.annotation.Version;

import com.relaxed.extend.dingtalk.message.DingTalkTextMessage;
import com.relaxed.extend.dingtalk.request.DingTalkResponse;
import com.relaxed.extend.dingtalk.request.DingTalkSender;
import com.relaxed.extend.wechat.message.WechatTextMessage;
import com.relaxed.extend.wechat.request.WechatResponse;
import com.relaxed.extend.wechat.request.WechatSender;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yakir
 * @Topic DingTalkController
 * @Description
 * @date 2021/6/21 11:29
 * @Version 1.0
 */
@RequiredArgsConstructor
@RestController
public class NoticeController {

	private final WechatSender wechatSender;
	private final DingTalkSender dingTalkSender;

	/**
	 * 测试ding talk 简单文本发送
	 * @param msg
	 * @return
	 */
	@GetMapping("ding/send")
	public DingTalkResponse dingSend(String msg) {
		DingTalkTextMessage dingTalkTextMessage = new DingTalkTextMessage();
		dingTalkTextMessage.setContent(msg);
		DingTalkResponse dingTalkResponse = dingTalkSender.sendMessage(dingTalkTextMessage);
		return dingTalkResponse;
	}


	/**
	 * 测试wechat发送
	 * @param msg
	 * @return
	 */
	@GetMapping("wechat/send")
	public WechatResponse wechatSend(String msg) {
		WechatTextMessage wechatTextMessage = new WechatTextMessage()
				.setContent(msg)
				.atAll();
		return wechatSender.sendMessage(wechatTextMessage);
	}

}
