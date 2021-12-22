package com.relaxed.samples.controller;

import com.relaxed.common.model.result.R;
import com.relaxed.samples.service.WebService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yakir
 * @Topic WebController
 * @Description
 * @date 2021/12/22 14:00
 * @Version 1.0
 */
@RequiredArgsConstructor
@RequestMapping("/web")
@RestController
public class WebController {

	private final WebService webService;

	@GetMapping("notice")
	public R exceptionNoticeNested(Integer param) {
		return R.ok(webService.exceptionNotice(param));
	}

	@GetMapping("notice/nested")
	public R exceptionNotice(Integer param) {
		return R.ok(webService.exceptionNoticeNestedAnnotation(param));
	}

	@GetMapping("notice/async")
	public R exceptionNoticeAsync(Integer param) {
		return R.ok(webService.asyncExceptionNotice(param));
	}

}
