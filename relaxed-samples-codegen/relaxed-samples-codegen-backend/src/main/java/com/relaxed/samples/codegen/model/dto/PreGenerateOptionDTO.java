package com.relaxed.samples.codegen.model.dto;

import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * 生成操作 DTO
 *
 * @author Yakir
 */
@Data
public class PreGenerateOptionDTO {

	/**
	 * 表名称
	 */
	private String tableName;

	/**
	 * 表前缀 欲截取的 eg: 原表名 tbl_test prefix tbl 则生成真实属性为 test
	 */
	private String tablePrefix;

	/**
	 * 模板组Id
	 */
	private Integer templateGroupId;

	/**
	 * 生成文件Ids
	 */
	private Set<Integer> templateFileIds;

	/**
	 * 自定义属性配置
	 */
	private Map<String, String> customProperties;

}
