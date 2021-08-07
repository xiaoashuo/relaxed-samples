package com.relaxed.samples.codegen.model.entity;

import lombok.Data;

import java.util.List;

/**
 * 生成属性
 *
 * @author Yakir
 */
@Data
public class GenerateProperties {

	/**
	 * 生成代码的即时时间
	 */
	private String currentTime;

	/**
	 * controller 路径 t_code_gen ==> t/code/gen
	 */
	private String path;

	/**
	 * 表名称
	 */
	private String tableName;

	/**
	 * 默认的表别名,主要用户多表联查使用 根据类名的大写字母拼接转小写得到 eg: TableInfo => ti
	 */
	private String tableAlias;

	/**
	 * 类名称: 大驼峰 eg: TableInfo
	 */
	private String className;

	/**
	 * 类名: 小驼峰 eg: tableInfo
	 */
	private String lowerClassName;

	/**
	 * 表备注
	 */
	private String comments;

	/**
	 * 主键
	 */
	private ColumnProperties pk;

	/**
	 * 列信息
	 */
	private List<ColumnProperties> columns;

}
