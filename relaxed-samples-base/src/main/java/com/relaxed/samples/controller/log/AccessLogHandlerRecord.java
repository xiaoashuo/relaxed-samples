package com.relaxed.samples.controller.log;

import cn.hutool.core.util.URLUtil;
import com.relaxed.common.core.util.IpUtils;
import com.relaxed.common.log.access.handler.AccessLogHandler;
import com.relaxed.common.log.constant.LogConstant;
import com.relaxed.common.log.util.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Yakir
 * @Topic AccessLogHandlerRecord
 * @Description 模板模式 先生成日志 -- 保存
 * @date 2021/6/27 16:46
 * @Version 1.0
 */
@Slf4j
@Component
public class AccessLogHandlerRecord implements AccessLogHandler<Object> {

	@Override
	public Object prodLog(HttpServletRequest request, HttpServletResponse httpServletResponse, Long aLong,
			Throwable throwable) {
		Object matchingPatternAttr = request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		String matchingPattern = matchingPatternAttr == null ? "" : String.valueOf(matchingPatternAttr);
		log.info("请求映射地址:{}", matchingPattern);
		return null;
	}

	@Override
	public void saveLog(Object o) {
		// 进行保存操作
	}

}
