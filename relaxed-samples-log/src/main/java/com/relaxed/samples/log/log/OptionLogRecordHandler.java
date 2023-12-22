package com.relaxed.samples.log.log;

import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONUtil;
import com.relaxed.autoconfigure.web.constants.LogConstant;
import com.relaxed.common.core.util.IpUtils;


import com.relaxed.common.core.util.WebUtils;
import com.relaxed.common.log.operation.annotation.Log;
import com.relaxed.common.log.operation.enums.LogStatusEnum;

import com.relaxed.common.log.operation.service.AbstractOperationLogHandler;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Yakir
 * @Topic OptionLogRecord
 * @Description
 * @date 2021/6/27 16:42
 * @Version 1.0
 */
@Slf4j
@Component
public class OptionLogRecordHandler extends AbstractOperationLogHandler<OperationLog> {

	@Override
	public OperationLog buildLog(Log log, ProceedingJoinPoint proceedingJoinPoint) {
		// 获取 Request

		HttpServletRequest request = WebUtils.getRequest();

		// @formatter:off
        OperationLog operationLog = new OperationLog()
                .setCreateTime(LocalDateTime.now())
                .setIp(IpUtils.getIpAddr(request))
                .setMethod(request.getMethod())
                .setUserAgent(request.getHeader("user-agent"))
                .setUri(URLUtil.getPath(request.getRequestURI()))
                .setType(log.type())
                .setMsg(log.msg())
                .setParams(getParams(proceedingJoinPoint))
                .setTraceId(MDC.get(LogConstant.TRACE_ID));
        // @formatter:on

		// 操作用户
		return operationLog;
	}

	@Override
	public OperationLog fillExecutionInfo(OperationLog operationLog, ProceedingJoinPoint proceedingJoinPoint,
			long startTime, long endTime, Throwable throwable, boolean isSaveResult, Object result) {
		// 执行时长
		operationLog.setTime(endTime - startTime);
		// 执行状态
		LogStatusEnum logStatusEnum = throwable == null ? LogStatusEnum.SUCCESS : LogStatusEnum.FAIL;
		operationLog.setStatus(logStatusEnum.getValue());
		// 执行结果
		if (isSaveResult) {
			Optional.ofNullable(result).ifPresent(x -> operationLog.setResult(JSONUtil.toJsonStr(x)));
		}
		return operationLog;
	}

	@Override
	public void handleLog(OperationLog operationLog) {
		// 异步保存
		log.info("操作日志:{}", operationLog);
	}

}
