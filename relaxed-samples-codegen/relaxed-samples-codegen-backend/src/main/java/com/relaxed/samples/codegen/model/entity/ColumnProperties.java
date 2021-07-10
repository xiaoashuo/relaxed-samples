package com.relaxed.samples.codegen.model.entity;

import lombok.Data;

/**
 * 列属性
 *
 * @author Yakir
 */
@Data
public class ColumnProperties {

	/**
	 * 列名称
	 */
	private String columnName;

	/**
	 * 数据类型
	 */
	private String dataType;

	/**
	 * 备注
	 */
	private String comments;

	/**
	 * 属性名(小驼峰)
	 */
	private String attrName;

	/**
	 * 首字母大写的属性名
	 */
	private String capitalizedAttrName;

	/**
	 * 属性类型
	 */
	private String attrType;

	/**
	 * 其他信息
	 */
	private String extra;

	/**
	 * 字典类型
	 */
	private String columnType;

}
