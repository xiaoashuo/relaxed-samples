package com.relaxed.samples.controller.log;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 操作日志
 *
 * @author hccake
 * @date 2019-10-15 20:42:32
 */
@Data
@Accessors(chain = true)
public class OperationLog {

	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	private Long id;

	/**
	 * 追踪ID
	 */
	private String traceId;

	/**
	 * 日志消息
	 */
	private String msg;

	/**
	 * 访问IP地址
	 */
	private String ip;

	/**
	 * 用户代理
	 */
	private String userAgent;

	/**
	 * 请求URI
	 */
	private String uri;

	/**
	 * 请求方法
	 */
	private String method;

	/**
	 * 操作提交的数据
	 */
	private String params;

	/**
	 * 操作状态
	 */
	private Integer status;

	/**
	 * 操作类型
	 */
	private Integer type;

	/**
	 * 开始时间
	 */
	private Long startTime;

	/**
	 * 结束时间
	 */
	private Long endTime;

	/**
	 * 执行时长
	 */
	private Long time;

	/**
	 * 创建者
	 */
	private String operator;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

}
