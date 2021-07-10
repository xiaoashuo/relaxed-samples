package com.relaxed.samples.codegen.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 数据源配置
 *
 * @author Yakir
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DataSourceConfigDTO implements Serializable {

	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 数据源名称
	 */
	private String name;

	/**
	 * 数据库用户名
	 */
	private String username;

	/**
	 * 数据库密码
	 */
	private String password;

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