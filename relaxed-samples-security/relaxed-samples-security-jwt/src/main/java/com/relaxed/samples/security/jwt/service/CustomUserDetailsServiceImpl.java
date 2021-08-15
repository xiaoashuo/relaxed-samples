package com.relaxed.samples.security.jwt.service;

import com.relaxed.samples.security.jwt.model.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yakir
 * @Topic JwtUserDetailsServiceImpl
 * @Description
 * @date 2021/8/15 12:54
 * @Version 1.0
 */
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Set<GrantedAuthority> strings = new HashSet<>();
		strings.add(new SimpleGrantedAuthority("user:add"));
		strings.add(new SimpleGrantedAuthority("ROLE_USER"));

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
