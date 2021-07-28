package com.relaxed.samples.tenant.model.vo;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;

import lombok.experimental.Accessors;

/**
 * 租户配置 视图层
 *
 * @author yakir
 * @since 2021-07-28T16:42:43.380
 */

@Data
@Accessors(chain = true)
public class TenantConfigVO implements Serializable {

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
