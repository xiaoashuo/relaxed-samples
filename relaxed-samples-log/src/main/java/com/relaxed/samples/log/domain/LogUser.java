package com.relaxed.samples.log.domain;

import com.relaxed.common.log.biz.annotation.LogDiffTag;
import lombok.Data;

/**
 * @author Yakir
 * @Topic User
 * @Description
 * @date 2023/12/14 15:09
 * @Version 1.0
 */
@Data
public class LogUser {

	/**
	 * 用户名称
	 */
	@LogDiffTag
	private String username;

	/**
	 * 状态 1 待发货 2 发货中 3 待收货 4 待评价 5已完成
	 */
	@LogDiffTag
	private Integer status;

	/**
	 * 物流单号
	 */
	@LogDiffTag
	private String bizNo;

}
