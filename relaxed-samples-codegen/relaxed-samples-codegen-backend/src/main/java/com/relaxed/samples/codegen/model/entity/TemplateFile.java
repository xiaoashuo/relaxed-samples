package com.relaxed.samples.codegen.model.entity;

import lombok.Data;

/**
 * 模板文件
 *
 * @author Yakir
 */
@Data
public class TemplateFile {

	/**
	 * 文件名称
	 */
	private String fileName;

	/**
	 * 文件路径
	 */
	private String filePath;

	/**
	 * 模板内容
	 */
	private String context;

	/**
	 * 模板引擎类型 1: Velocity
	 */
	private Integer engineType;

}
