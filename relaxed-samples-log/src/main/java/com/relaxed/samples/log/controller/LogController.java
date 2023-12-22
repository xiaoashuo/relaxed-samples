package com.relaxed.samples.log.controller;

import cn.hutool.core.util.IdUtil;
import com.apifan.common.random.source.NumberSource;
import com.apifan.common.random.source.PersonInfoSource;
import com.relaxed.common.model.result.R;
import com.relaxed.common.log.operation.annotation.CreateLog;
import com.relaxed.common.log.operation.annotation.DeleteLog;
import com.relaxed.common.log.operation.annotation.Log;
import com.relaxed.common.log.operation.annotation.UpdateLog;

import com.relaxed.samples.log.domain.LogUser;
import com.relaxed.samples.log.service.BizLogService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

	private final BizLogService bizLogService;
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
	@Log(group = "日志管理", msg = "公共调用", type = 6)
	public R common(String param) {
		log.info("params: {}", param);
		return R.ok();
	}

	@GetMapping("/nested")
	@Log(group = "嵌入业务日志", msg = "嵌入业务日志", type = 7)
	public R nested(String param) {
		LogUser logUser = getLogUser();
		bizLogService.simpleMethod(logUser);
		return R.ok();
	}

	@GetMapping("/diff")
	@Log(group = "差异化比较日志", msg = "差异化比较日志", type = 8)
	public R diffLog(String param) {
		LogUser oldLogUser = getLogUser();
		bizLogService.simpleMethodDiff(oldLogUser);
		return R.ok();
	}

	private static LogUser getLogUser() {
		LogUser logUser = new LogUser();
		logUser.setUsername( PersonInfoSource.getInstance().randomMaleChineseName());
		logUser.setStatus(NumberSource.getInstance().randomInt(1, 101));
		logUser.setBizNo(IdUtil.getSnowflakeNextIdStr());
		return logUser;
	}

}
