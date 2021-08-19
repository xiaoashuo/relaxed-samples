package com.relaxed.samples.security.jwt.service;

import com.relaxed.samples.security.jwt.model.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yakir
 * @Topic JwtUserDetailsServiceImpl
 * @Description 主要用于从数据库提取用户信息
 * @date 2021/8/15 12:54
 * @Version 1.0
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Set<GrantedAuthority> strings = new HashSet<>();

		strings.add(new SimpleGrantedAuthority("ROLE_USER"));
		strings.add(new SimpleGrantedAuthority("ROLE_1"));
		strings.add(new SimpleGrantedAuthority("sys:user:add"));
		strings.add(new SimpleGrantedAuthority("sys:user:edit"));
		strings.add(new SimpleGrantedAuthority("sys:user:del"));
		strings.add(new SimpleGrantedAuthority("sys:user:view"));

		return new JwtUser().setUsername("Jack")
				.setPassword("$2a$10$2dK6H5pOf.0xdY18Kw6Xlu0BvgjCaaNgM1GkCUWlSRHwafmqa2WM.").setAuthorities(strings);
	}

	public static void main(String[] args) {
		Set<GrantedAuthority> strings = new HashSet<>();
		strings.add(new SimpleGrantedAuthority("user:add"));
		strings.add(new SimpleGrantedAuthority("ROLE_USER"));
		JwtUser jack = new JwtUser().setUsername("Jack")
				.setPassword("$2a$10$2dK6H5pOf.0xdY18Kw6Xlu0BvgjCaaNgM1GkCUWlSRHwafmqa2WM.").setAuthorities(strings);
		System.out.println(jack);
	}

}
