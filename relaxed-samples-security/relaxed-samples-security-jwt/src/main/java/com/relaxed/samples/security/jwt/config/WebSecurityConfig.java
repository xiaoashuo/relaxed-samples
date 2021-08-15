package com.relaxed.samples.security.jwt.config;

import com.relaxed.common.security.jwt.config.JwtConfigurer;
import com.relaxed.common.security.jwt.core.JwtTokenService;
import com.relaxed.common.security.jwt.handler.FormLoginSuccessHandler;
import com.relaxed.common.security.jwt.handler.JwtAuthenticationSuccessHandler;
import com.relaxed.common.security.jwt.provider.JwtAuthenticationProvider;
import com.relaxed.samples.security.jwt.service.CustomUserDetailsServiceImpl;
import com.relaxed.samples.security.jwt.service.TokenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.header.Header;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @author Yakir
 * @Topic WebSecurityConfig
 * @Description
 * @date 2021/8/15 13:17
 * @Version 1.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		MyAuthenticationEntryPoint myAuthenticationEntryPoint = new MyAuthenticationEntryPoint();
		http.authorizeRequests().antMatchers("/image/**").permitAll().antMatchers("/admin/**").hasAnyRole("ADMIN")
				.antMatchers("/test/**").hasRole("USER").antMatchers("/login", "/captchaImage").anonymous().anyRequest()
				.authenticated().and().csrf().disable()
				// .formLogin().disable()
				.sessionManagement().disable().cors().and().formLogin()
				.successHandler(new FormLoginSuccessHandler(jwtTokenService())).and().apply(new JwtConfigurer<>())
				.successHandlerRegister(new JwtAuthenticationSuccessHandler(jwtTokenService()))
				.authenticationEntryPoint(myAuthenticationEntryPoint).and().logout()
				// .logoutUrl("/logout") //默认就是"/logout"
				// TODO 退出需使token不能再次访问使用
				// .addLogoutHandler(tokenClearLogoutHandler())
				.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler()).and().sessionManagement()
				.disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider()).authenticationProvider(jwtAuthenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(CustomUserDetailsService());
		authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
		return authenticationProvider;
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return CustomUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtAuthenticationProvider jwtAuthenticationProvider() {
		return new JwtAuthenticationProvider(CustomUserDetailsService(), jwtTokenService());
	}

	@Bean
	public UserDetailsService CustomUserDetailsService() {
		return new CustomUserDetailsServiceImpl();
	}

	@Bean
	public JwtTokenService jwtTokenService() {
		return new TokenServiceImpl();
	}

}
