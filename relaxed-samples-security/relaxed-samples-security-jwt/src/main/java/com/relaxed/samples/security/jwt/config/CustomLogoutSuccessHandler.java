package com.relaxed.samples.security.jwt.config;

import cn.hutool.json.JSONUtil;
import com.relaxed.common.core.util.ServletUtils;
import com.relaxed.common.model.result.R;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yakir
 * @Topic CustomLogoutSuccessHandler
 * @Description
 * @date 2021/8/18 10:38
 * @Version 1.0
 */
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	/**
	 * LogoutSuccessHandler 在 LogoutFilter 成功注销之后调用，以处理例如重定向或转发到适当的目标。 请注意，该接口几乎与
	 * LogoutHandler 相同，但可能引发异常。 也可以在此处做一些收尾工作 进行原token失效 authentication 为空 则标识没有用户认证信息
	 * 最好将客户端cookie 也一并注销 参考 CookieClearingLogoutHandler LogoutHandler 实现指示能够参与注销处理的类。
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param authentication
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {
		HttpStatus ok = HttpStatus.OK;
		ServletUtils.renderString(httpServletResponse, JSONUtil.toJsonStr(R.ok(ok.value(), "退出成功")));
	}

}
