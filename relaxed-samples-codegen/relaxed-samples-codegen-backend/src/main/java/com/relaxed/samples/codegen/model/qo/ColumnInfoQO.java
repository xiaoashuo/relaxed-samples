package com.relaxed.samples.codegen.model.qo;

import lombok.Data;

/**
 * 列信息
 *
 * @author Yakir
 */
@Data
public class ColumnInfoQO {

	/**
	 * 列表
	 */
	private String columnName;

	/**
	 * 数据类型
	 */
	private String dataType;

	/**
	 * 备注
	 */
	private String columnComment;

	/**
	 * 其他信息
	 */
	private String extra;

	/**
	 * 是否可以为空
	 */
	private String isNullable;

	/**
	 * 字段类型
	 */
	private String columnType;

	/**
	 * 索引类型
	 */
	private String columnKey;

}
