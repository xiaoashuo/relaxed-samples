package com.relaxed.samples.controller.log;

import cn.hutool.core.util.URLUtil;
import com.relaxed.common.core.util.IpUtils;
import com.relaxed.common.core.util.ServletUtils;
import com.relaxed.common.log.access.utils.LogUtils;

import com.relaxed.common.log.mdc.constant.LogConstant;
import com.relaxed.common.log.operation.annotation.Log;
import com.relaxed.common.log.operation.enums.LogStatusEnum;

import com.relaxed.common.log.operation.service.AbstractOperationLogHandler;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @author Yakir
 * @Topic OptionLogRecord
 * @Description
 * @date 2021/6/27 16:42
 * @Version 1.0
 */
@Slf4j
@Component
public class OptionLogRecord extends AbstractOperationLogHandler<OperationLog> {

	@Override
	public OperationLog buildLog(Log log, ProceedingJoinPoint proceedingJoinPoint) {
		// 获取 Request

		HttpServletRequest request = ServletUtils.getRequest();

		// @formatter:off
        OperationLog operationLog = new OperationLog()
                .setCreateTime(LocalDateTime.now())
                .setIp(IpUtils.getIpAddr(request))
                .setMethod(request.getMethod())
                .setUserAgent(request.getHeader("user-agent"))
                .setUri(URLUtil.getPath(request.getRequestURI()))
                .setType(log.type().getValue())
                .setMsg(log.msg())
                .setParams(getParams(proceedingJoinPoint))
                .setTraceId(MDC.get(LogConstant.TRACE_ID));
        // @formatter:on

		// 操作用户
		return operationLog;
	}

	@Override
	public OperationLog fillExecutionInfo(OperationLog operationLog, ProceedingJoinPoint proceedingJoinPoint,
			long startTime, long endTime, Object executionResult, Throwable throwable) {
		long executionTime = endTime - startTime;
		// 执行时长
		operationLog.setStartTime(startTime);
		operationLog.setEndTime(endTime);
		operationLog.setTime(executionTime);
		// 执行状态
		LogStatusEnum logStatusEnum = throwable == null ? LogStatusEnum.SUCCESS : LogStatusEnum.FAIL;
		operationLog.setStatus(logStatusEnum.getValue());
		return operationLog;
	}

	@Override
	public void handleLog(OperationLog operationLog) {
		// 异步保存
		log.info("操作日志:{}", operationLog);
	}

}
