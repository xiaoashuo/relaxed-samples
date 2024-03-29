package com.relaxed.common.risk.engine.rules;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yakir
 * @Topic EvaluateReport
 * @Description 评估报告
 * @date 2021/8/29 17:12
 * @Version 1.0
 */
@Data
public class EvaluateReport implements Serializable {

	/**
	 * 信息描述
	 */
	private String errorMsg;

	/**
	 * 评估报告 扩展参数 记录各接阶段评估数据
	 */
	private Map<String, Map<String, ?>> evaluateData = new HashMap<>();

	/**
	 * 执行开始时间
	 */
	private LocalDateTime startTime;

	/**
	 * 执行结束时间
	 */
	private LocalDateTime endTime;

	/**
	 * 阶段耗时
	 */
	private Map<String, Object> phaseTime = new HashMap<>();

	/**
	 * 放入评估数据报告中
	 * @param key
	 * @param evaluateMap
	 */
	public void putEvaluateMap(String key, Map<String, Object> evaluateMap) {
		evaluateData.put(key, evaluateMap);
	}

	/**
	 * 填充阶段耗时
	 * @author yakir
	 * @date 2021/8/31 14:48
	 * @param name
	 * @param time
	 */
	public void putPhaseTime(String name, Long time) {
		phaseTime.put(name, time);
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void setErrorMsg(String msgTemplate, Object... params) {
		this.errorMsg = StrUtil.format(msgTemplate, params);
	}

}
