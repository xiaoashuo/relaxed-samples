package com.relaxed.samples.security.jwt.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

	@PostMapping("add")
	public void create(@AuthenticationPrincipal UserDetails user) {

	}

}
