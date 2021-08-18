package com.relaxed.samples.security.jwt.config;

import com.relaxed.common.model.result.R;
import com.relaxed.common.model.result.SysResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @author Yakir
 * @Topic CustomException
 * @Description
 * @date 2021/8/18 13:36
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class CustomException {

	/**
	 * 访问资源需要权限
	 * @author yakir
	 * @date 2021/8/18 15:18
	 * @param e
	 * @return com.relaxed.common.model.result.R<java.lang.String>
	 */
	@ExceptionHandler({ AccessDeniedException.class })
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public R<String> handleMethodArgumentTypeMismatchException(Exception e) {
		log.error("请求入参异常 ex={}", e.getMessage());
		return R.failed(SysResultCode.FORBIDDEN, e.getMessage());
	}

	/**
	 * 访问此资源需要完全身份验证
	 * @author yakir
	 * @date 2021/8/18 15:18
	 * @param e
	 * @return com.relaxed.common.model.result.R<java.lang.String>
	 */
	@ExceptionHandler({ InsufficientAuthenticationException.class, BadCredentialsException.class })
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public R<String> handleInsufficientAuthenticationException(Exception e) {
		log.error("请求入参异常 ex={}", e.getMessage());
		return R.failed(SysResultCode.UNAUTHORIZED, e.getMessage());
	}

}
