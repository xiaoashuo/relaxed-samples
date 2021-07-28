package com.relaxed.samples.tenant.model.vo;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;

import lombok.experimental.Accessors;

/**
 * 数据源 视图层
 *
 * @author yakir
 * @since 2021-07-28T16:42:43.396
 */
@Data
@Accessors(chain = true)
public class TenantDataSourceConfigVO implements Serializable {

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
