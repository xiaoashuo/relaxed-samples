package com.relaxed.samples.security.jwt.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.relaxed.common.core.util.ServletUtils;
import com.relaxed.common.model.result.R;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yakir
 * @Topic MyAuthenticationEntryPoint
 * @Description
 * @date 2021/8/15 13:39
 * @Version 1.0
 */
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AuthenticationException e) throws IOException, ServletException {
		int code = HttpStatus.UNAUTHORIZED.value();
		String msg = StrUtil.format("请求访问：{}，认证失败，无法访问系统资源,错误消息{}", httpServletRequest.getRequestURI(), e.getMessage());
		ServletUtils.renderString(httpServletResponse, JSONUtil.toJsonStr(R.failed(code, msg)));
	}

}
