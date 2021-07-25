package com.relaxed.samples.datascope.controller;

import com.relaxed.common.core.result.R;
import com.relaxed.samples.datascope.config.UserHolder;
import com.relaxed.samples.datascope.mapper.UserMapper;
import com.relaxed.samples.datascope.model.User;
import com.relaxed.samples.datascope.model.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yakir
 * @Topic UserController
 * @Description
 * @date 2021/7/25 17:11
 * @Version 1.0
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

	private final UserMapper userMapper;

	@GetMapping("/list")
	public R list(@RequestParam Integer pid) {

		List<User> data;
		try {
			UserHolder.set(pid.equals(1) ? "1" : "2");
			data = userMapper.listUser();
		}
		finally {
			UserHolder.remove();
		}

		return R.ok(data);
	}

}
