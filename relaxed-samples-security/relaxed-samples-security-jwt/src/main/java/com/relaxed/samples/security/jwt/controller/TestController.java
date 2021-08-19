package com.relaxed.samples.security.jwt.controller;

import com.relaxed.common.security.jwt.tookit.SecurityUtils;
import com.relaxed.samples.security.jwt.model.JwtUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yakir
 * @Topic TestController
 * @Description
 * @date 2021/8/15 13:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/user")
	public String loadUser(Long id) {
		return "This is my first blogada";
	}

	@GetMapping("/{id}")
	public String load(@PathVariable Long id) {
		return "This is my first blog";
	}

	@PreAuthorize("hasRole('2')")
	@RequestMapping("role1")
	public String testRole1() {
		return "role1 request success!";
	}

	@PreAuthorize("hasRole('ROLE_1')")
	@RequestMapping("role2")
	public String testRole2() {
		return "role2 request success!";
	}

	@PreAuthorize("hasRole('ROLE_3')")
	@RequestMapping("role3")
	public String testRole3() {
		return "role3 request success!";
	}

	@PreAuthorize("hasPermission('TestController', 'edit')")
	@RequestMapping("permission1")
	public String testPermission1() {
		return "permission1 request success!";
	}

	@RequestMapping("permission3")
	public String testPermission3() {
		JwtUser user = SecurityUtils.getUser();
		return "permission3 request success!";
	}

	@PreAuthorize("@pre.hasPermission('sys:user:view')")
	@RequestMapping("permission4")
	public String testCustomPermission() {
		return "permission3 request success!";
	}

}
