package com.relaxed.common.risk.engine.exception;

import cn.hutool.core.util.StrUtil;
import com.relaxed.common.core.exception.BusinessException;
import lombok.RequiredArgsConstructor;

/**
 * @author Yakir
 * @Topic RiskEngineException
 * @Description
 * @date 2021/8/29 17:02
 * @Version 1.0
 */
@RequiredArgsConstructor
public class RiskEngineException extends RuntimeException {

	public RiskEngineException(String message, Throwable cause) {
		super(message, cause);
	}

	public RiskEngineException(String messageTemplate, Throwable cause, Object... params) {
		super(StrUtil.format(messageTemplate, params), cause);
	}

}
