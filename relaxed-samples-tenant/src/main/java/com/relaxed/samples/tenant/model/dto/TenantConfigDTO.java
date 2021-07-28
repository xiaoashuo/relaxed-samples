package com.relaxed.samples.tenant.model.dto;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;

import lombok.experimental.Accessors;

/**
 * 租户配置 数据传输对象
 *
 * @author yakir
 * @since 2021-07-28T16:45:18.822
 */
@Data
@Accessors(chain = true)
public class TenantConfigDTO implements Serializable {

	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 租户名称
	 */
	private String tenantName;

	/**
	 * 租户id
	 */
	private Long tenantId;

	/**
	 * 数据库名称
	 */
	private String tenantSchema;

}
