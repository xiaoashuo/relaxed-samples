package com.relaxed.samples.controller.log;

import com.relaxed.common.log.operation.model.OperationLogDTO;
import com.relaxed.common.log.operation.service.OperationLogHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Yakir
 * @Topic OptionLogRecord
 * @Description
 * @date 2021/6/27 16:42
 * @Version 1.0
 */
@Slf4j
@Component
public class OptionLogRecord implements OperationLogHandler {

	@Override
	public void saveLog(OperationLogDTO operationLogDTO) {
		log.info("操作日志{}", operationLogDTO);
	}

}
