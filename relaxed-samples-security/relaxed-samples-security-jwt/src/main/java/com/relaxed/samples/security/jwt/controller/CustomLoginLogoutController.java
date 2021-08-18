package com.relaxed.samples.security.jwt.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.relaxed.common.core.exception.BusinessException;
import com.relaxed.common.core.util.ServletUtils;
import com.relaxed.common.model.result.R;
import com.relaxed.common.security.jwt.core.JwtTokenService;
import com.relaxed.samples.security.jwt.model.JwtUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yakir
 * @Topic CustomLoginLogoutController
 * @Description 默认spring security 已经提供登录退出方法了 有login 退出 就直接调用 logout 即可
 * -->LogoutFilter#doFilter 主要职责 清除安全上下文 以及线程环境绑定 等等
 * @date 2021/8/18 16:26
 * @Version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/extension")
public class CustomLoginLogoutController {

	private final JwtTokenService jwtTokenService;

	private final UserDetailsService userDetailsService;

	@PostMapping("/login")
	public R login(String username, String password, HttpServletResponse response) {
		// 1.效验用户名密码是否正确
		if (StrUtil.isEmpty(username) || StrUtil.isEmpty(password)) {
			throw new RuntimeException("用户名密码不正确");
		}
		// 2.从数据库查询出 用户信息
		// 此处可以使用自定义方法 我这边省事 直接调用了 detail service的方法
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		// 3.效验用户密码是否正确 test 我就忽略了
		// 4.生成token 下发给客户端
		String token = this.jwtTokenService.generateToken(userDetails);
		response.setHeader("Authorization", token);
		Map<String, String> maps = new HashMap();
		maps.put("access_token", token);
		return R.ok(maps);
	}

}
