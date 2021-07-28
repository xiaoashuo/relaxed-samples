package com.relaxed.samples.tenant.holder;

import lombok.Data;

/**
 * @author Yakir
 * @Topic TenantInfo
 * @Description
 * @date 2021/7/28 20:40
 * @Version 1.0
 */
@Data
public class TenantInfo {

	/**
	 * 租户数据库
	 */
	private String schema;

	/**
	 * 租户id
	 */
	private String tenantId;

}
