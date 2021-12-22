package com.relaxed.samples.controller.log;

import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONUtil;
import com.relaxed.common.core.util.IpUtils;
import com.relaxed.common.log.access.handler.AccessLogHandler;

import com.relaxed.common.log.access.utils.LogUtils;
import com.relaxed.common.log.mdc.constant.LogConstant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Map;
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
public class AccessLogHandlerRecord implements AccessLogHandler<AccessLog> {

	private static final String APPLICATION_JSON = "application/json";

	@Override
	public AccessLog prodLog(HttpServletRequest request, HttpServletResponse response, Long time, Throwable throwable) {
		Object matchingPatternAttr = request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		String matchingPattern = matchingPatternAttr == null ? "" : String.valueOf(matchingPatternAttr);
		log.info("请求映射地址:{}", matchingPattern);
		String uri = URLUtil.getPath(request.getRequestURI());
		AccessLog accessLog = new AccessLog().setTraceId(MDC.get(LogConstant.TRACE_ID))
				.setCreateTime(LocalDateTime.now()).setTime(time).setIp(IpUtils.getIpAddr(request))
				.setMethod(request.getMethod()).setUserAgent(request.getHeader("user-agent")).setUri(uri)
				.setMatchingPattern(matchingPattern)
				.setErrorMsg(Optional.ofNullable(throwable).map(Throwable::getMessage).orElse(""))
				.setHttpStatus(response.getStatus());
		// @formatter:on
		// 参数获取
		String params = getParams(request);
		accessLog.setReqParams(params);

		// 非文件上传请求，记录body
		if (!LogUtils.isMultipartContent(request)) {
			accessLog.setReqBody(LogUtils.getRequestBody(request));
		}

		// 只记录响应头为 application/json 的返回数据
		// 后台日志对于分页数据请求，不记录返回值
		if (!uri.endsWith("/page") && response.getContentType() != null
				&& response.getContentType().contains(APPLICATION_JSON)) {
			accessLog.setResult(LogUtils.getResponseBody(request, response));
		}
		return accessLog;
	}

	/**
	 * 获取参数信息
	 * @param request 请求信息
	 * @return 请求参数
	 */
	public String getParams(HttpServletRequest request) {
		String params;
		try {
			Map<String, String[]> parameterMap = request.getParameterMap();
			params = JSONUtil.toJsonStr(parameterMap);
		}
		catch (Exception e) {
			params = "记录参数异常";
			log.error("[prodLog]，参数获取序列化异常", e);
		}
		return params;
	}

	@Override
	public void saveLog(AccessLog accessLog) {
		// 进行保存操作
		log.info("日志存储{}", accessLog);
	}

}
