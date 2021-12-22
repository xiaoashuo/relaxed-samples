package com.relaxed.samples.service;

import com.relaxed.common.exception.annotation.ExceptionNotice;
import org.springframework.stereotype.Service;

/**
 * @author Yakir
 * @Topic AsyncWebService
 * @Description
 * @date 2021/12/22 14:04
 * @Version 1.0
 */
@ExceptionNotice
@Service
public class AsyncWebService {

	public void asyncError() {
		if (true) {
			throw new RuntimeException("异步任务执行支持" + Thread.currentThread().getId());
		}
	}

}
