package com.relaxed.samples.log.service;

import cn.hutool.core.util.IdUtil;
import com.relaxed.common.log.biz.annotation.BizLog;
import com.relaxed.common.log.biz.context.LogRecordContext;
import com.relaxed.samples.log.domain.LogUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Yakir
 * @Topic BizLogService
 * @Description
 * @date 2023/12/20 15:25
 * @Version 1.0
 */
@RequiredArgsConstructor
@Service
public class BizLogService {

	private final UserAService userAService;

	/**
	 * 简单注解
	 * @param logUser
	 * @return
	 */
	@BizLog(success = "'simpleMethod执行成功'", bizNo = "{{#logUser.bizNo}}")
	public String simpleMethod(LogUser logUser) {
		return "method [simpleMethod] exec success!!!";
	}

	/**
	 * 测试方法执行失败日志记录
	 * @param logUser
	 * @return
	 */
	@BizLog(success = "'simpleMethodFail执行成功'", bizNo = "{{#logUser.bizNo}}")
	public String simpleMethodFail(LogUser logUser) {
		if (true) {
			throw new RuntimeException("测试方法执行失败日志记录");
		}
		return "method [simpleMethod] exec success!!!";
	}

	@BizLog(success = "'simpleMethod方法嵌套执行成功'", bizNo = "{{#logUser.bizNo}}")
	public String simpleMethodNested(LogUser logUser) {
		userAService.sendGoods(logUser);
		return "method [simpleMethod] exec success!!!";
	}

	@BizLog(success = "'simpleMethod差异比对执行成功'", bizNo = "{{#oldUser.bizNo}}")
	public LogUser simpleMethodDiff(LogUser oldUser) {
		LogUser newUser = new LogUser();
		newUser.setUsername("王麻子");
		newUser.setStatus(3);
		newUser.setBizNo(IdUtil.getSnowflakeNextIdStr());
		LogRecordContext.putDiff(oldUser, newUser);
		return newUser;
	}

	/**
	 * 上下文变量方法
	 * @param logUser
	 * @return
	 */
	@BizLog(success = "'simpleMethod上下文变量执行成功'", bizNo = "{{#logUser.bizNo}}", detail = "物流投递到{{#deliveryAddress}}")
	public String simpleMethodContext(LogUser logUser) {
		String deliveryAddress = "上海市普陀区长寿路1888号";
		LogRecordContext.push("deliveryAddress", deliveryAddress);
		return "method [simpleMethodContext] exec success!!!";
	}

	@BizLog(success = "'simpleMethod函数执行成功'", bizNo = "{{#logUser.bizNo}}",
			detail = "静态方法结果{testAnnotation{#logUser.status}},普通方法{testAnnotationNoStatic{}},"
					+ "接口方法{ifunc_test{#_result}}")
	public String simpleMethodCustomFunc(LogUser logUser) {

		return "method [simpleMethodContext] exec success!!!";
	}

	@BizLog(success = "'simpleMethod前置函数执行成功'", bizNo = "{{#logUser.bizNo}}",
			detail = "前置函数结果{testBeforeFunc{#logUser.status}},函数开始执行时间{{#_stime}}")
	public String simpleMethodCustomBeforFunc(LogUser logUser) {

		return "method [simpleMethodContext] exec success!!!";
	}

}
