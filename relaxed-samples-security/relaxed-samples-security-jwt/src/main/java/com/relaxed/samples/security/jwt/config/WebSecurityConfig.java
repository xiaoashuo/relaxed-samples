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

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// CSRF禁用，因为不使用session
				.csrf().disable()
				// 认证失败处理类
				.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
				// 基于token，所以不需要session 不禁用会出现从session获取缓存信息 因为jwt 处理并未针对session进行无效化
				// SessionManagementFilter#109
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/image/**").permitAll().antMatchers("/extension/**").permitAll().antMatchers("/admin/**")
				.hasAnyRole("ADMIN").antMatchers("/login", "/captchaImage").anonymous().anyRequest().authenticated()
				.and().formLogin().successHandler(new FormLoginSuccessHandler(jwtTokenService)).and()
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
