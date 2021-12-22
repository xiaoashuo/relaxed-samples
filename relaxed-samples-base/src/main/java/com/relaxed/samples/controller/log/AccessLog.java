package com.relaxed.samples.controller.log;

/**
 * @author Yakir
 * @Topic AccessLog
 * @Description
 * @date 2021/12/22 13:55
 * @Version 1.0
 */

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 后台访问日志
 */
@Data
@Accessors(chain = true)
public class AccessLog {

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
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 用户名
	 */
	private String username;

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
	 * 请求映射地址
	 */
	private String matchingPattern;

	/**
	 * 操作方式
	 */
	private String method;

	/**
	 * 请求参数
	 */
	private String reqParams;

	/**
	 * 请求body
	 */
	private String reqBody;

	/**
	 * 响应状态码
	 */
	private Integer httpStatus;

	/**
	 * 响应信息
	 */
	private String result;

	/**
	 * 错误消息
	 */
	private String errorMsg;

	/**
	 * 执行时长
	 */
	private Long time;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

}
