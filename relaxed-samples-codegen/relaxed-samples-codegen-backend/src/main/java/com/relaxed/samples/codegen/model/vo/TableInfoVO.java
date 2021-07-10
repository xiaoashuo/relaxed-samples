package com.relaxed.samples.codegen.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 表信息
 *
 * @author Yakir
 */
@Data
public class TableInfoVO {

	/**
	 * 表名称
	 */
	private String tableName;

	/**
	 * 存储引擎
	 */
	private String engine;

	/**
	 * 表备注
	 */
	private String tableComment;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

}
