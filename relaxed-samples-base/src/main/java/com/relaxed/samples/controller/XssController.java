package com.relaxed.samples.controller;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.relaxed.common.model.result.R;
import com.relaxed.common.xss.config.XssProperties;
import com.relaxed.common.xss.json.XssStringJsonDeserializer;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yakir
 * @Topic XssController
 * @Description
 * @date 2021/6/27 15:52
 * @Version 1.0
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/xss")
public class XssController {

	/**
	 * 测试 默认配置反序列化成实体过滤 单String 类型参数过滤
	 * @param params 1233<script>alert(1)123</script> 仅保留1233
	 * @return
	 */
	@PostMapping("/test")
	public R xss(String params) {
		log.info("params{}", params);
		return R.ok();
	}

}
