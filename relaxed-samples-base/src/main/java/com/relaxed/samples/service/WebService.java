package com.relaxed.samples.service;

import com.relaxed.common.exception.annotation.ExceptionNotice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Yakir
 * @Topic WebService
 * @Description
 * @date 2021/12/22 14:01
 * @Version 1.0
 */
@RequiredArgsConstructor
@Service
public class WebService {

	private final AsyncWebService asyncWebService;

	/**
	 * 同步嵌套异常通知
	 * @author yakir
	 * @date 2021/12/22 14:03
	 * @param param
	 * @return java.lang.String
	 */
	@ExceptionNotice
	public String exceptionNoticeNestedAnnotation(Integer param) {
		if (param % 2 == 0) {
			throw new RuntimeException("参数不能为2整除" + param);
		}
		return "success";
	}

	/**
	 * 同步异常通知
	 * @author yakir
	 * @date 2021/12/22 14:03
	 * @param param
	 * @return java.lang.String
	 */
	public String exceptionNotice(Integer param) {
		if (param % 2 == 0) {
			throw new RuntimeException("参数不能为2整除" + param);
		}
		return "success";
	}

	/**
	 * 异步异常通知
	 * @author yakir
	 * @date 2021/12/22 14:05
	 * @param param
	 * @return java.lang.String
	 */
	public String asyncExceptionNotice(Integer param) {
		new Thread(() -> asyncWebService.asyncError()).start();
		if (param % 2 == 0) {
			throw new RuntimeException("参数不能为2整除" + param);
		}
		return "success";
	}

}
