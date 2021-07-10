package com.relaxed.samples.codegen.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 数据源配置
 *
 * @author yakir
 */
@Data
@ApiModel(value = "数据源")
public class DataSourceConfigVO {

	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 数据源名称
	 */
	@ApiModelProperty(value = "数据源名称")
	private String name;

	/**
	 * 数据库用户名
	 */
	@ApiModelProperty(value = "数据库用户名")
	private String username;

	/**
	 * 数据库连接
	 */
	private String url;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 删除时间
	 */
	private LocalDateTime updateTime;

}