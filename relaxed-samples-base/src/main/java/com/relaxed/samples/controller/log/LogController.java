package com.relaxed.samples.controller.log;

import com.relaxed.common.core.result.R;
import com.relaxed.common.log.operation.annotation.CreateLog;
import com.relaxed.common.log.operation.annotation.DeleteLog;
import com.relaxed.common.log.operation.annotation.Log;
import com.relaxed.common.log.operation.annotation.UpdateLog;
import com.relaxed.common.log.operation.enums.OperationTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yakir
 * @Topic LogController
 * @Description
 * @date 2021/6/27 16:34
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

	@GetMapping("/read")
	@CreateLog(group = "日志管理", msg = "读取日志")
	public R read(String param) {
		log.info("params: {}", param);
		return R.ok();
	}

	@GetMapping("/create")
	@CreateLog(group = "日志管理", msg = "新建日志")
	public R create(String param) {
		log.info("params: {}", param);
		return R.ok();
	}

	@GetMapping("/update")
	@UpdateLog(group = "日志管理", msg = "更新日志")
	public R update(String param) {
		log.info("params: {}", param);
		return R.ok();
	}

	@GetMapping("/del")
	@DeleteLog(group = "日志管理", msg = "删除日志")
	public R delete(String param) {
		log.info("params: {}", param);
		return R.ok();
	}

	@GetMapping("/common")
	@Log(group = "日志管理", msg = "公共调用", type = OperationTypeEnum.OTHER)
	public R common(String param) {
		log.info("params: {}", param);
		return R.ok();
	}

}
