package com.relaxed.samples.security.jwt.config;

import com.relaxed.common.security.jwt.config.JwtConfigurer;
import com.relaxed.common.security.jwt.core.JwtTokenService;
import com.relaxed.common.security.jwt.handler.FormLoginSuccessHandler;
import com.relaxed.common.security.jwt.handler.JwtAuthenticationSuccessHandler;

import com.relaxed.common.security.jwt.provider.JwtAuthenticationProvider;
import com.relaxed.samples.security.jwt.service.CustomUserDetailsServiceImpl;
import com.relaxed.samples.security.jwt.service.TokenServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author Yakir
 * @Topic WebSecurityConfig
 * @Description
 * @date 2021/8/15 13:17
 * @Version 1.0
 */
@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final DaoAuthenticationProvider daoAuthenticationProvider;

	private final JwtAuthenticationProvider jwtAuthenticationProvider;

	private final JwtTokenService jwtTokenService;

	private final AuthenticationEntryPoint authenticationEntryPoint;

	/**
	 * anyRequest | 匹配所有请求路径 access | SpringEl表达式结果为true时可以访问 anonymous | 匿名可以访问 denyAll |
	 * 用户不能访问 fullyAuthenticated | 用户完全认证可以访问（非remember-me下自动登录） hasAnyAuthority |
	 * 如果有参数，参数表示权限，则其中任何一个权限可以访问 hasAnyRole | 如果有参数，参数表示角色，则其中任何一个角色可以访问 hasAuthority |
	 * 如果有参数，参数表示权限，则其权限可以访问 hasIpAddress | 如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问 hasRole |
	 * 如果有参数，参数表示角色，则其角色可以访问 permitAll | 用户可以任意访问 rememberMe | 允许通过remember-me登录的用户访问
	 * authenticated | 用户登录后可访问
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// CSRF禁用，因为不使用session
				.csrf().disable()
				// 支持跨域
				.cors().and()
				// 防止iframe 造成跨域
				.headers().frameOptions().disable().and()
				// 认证失败处理类
				.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
				// 基于token，所以不需要session 不禁用会出现从session获取缓存信息 因为jwt 处理并未针对session进行无效化
				// SessionManagementFilter#109
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/image/**").permitAll().antMatchers("/extension/**").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/login", "/captchaImage").anonymous()
				// 其余所有请求都需要认证
				.anyRequest().authenticated().and()
				// 表单登录支持注册
				.formLogin().successHandler(new FormLoginSuccessHandler(jwtTokenService)).and()
				// jwt configurer 注册
				.apply(new JwtConfigurer<>())
				.successHandlerRegister(new JwtAuthenticationSuccessHandler(jwtTokenService)).and().logout()
				// .logoutUrl("/logout") //默认就是"/logout"
				// .addLogoutHandler(new CustomLogoutHandler())
				.logoutSuccessHandler(new CustomLogoutSuccessHandler());
	}

	/**
	 * 配置 提供者
	 * @author yakir
	 * @date 2021/8/18 16:06
	 * @param auth
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider).authenticationProvider(jwtAuthenticationProvider);
	}

}
