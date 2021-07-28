package com.relaxed.samples.tenant.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 租户配置
 *
 * @author yakir
 * @since 2021-07-28T15:36:12.618
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tenant_config")
public class TenantConfig extends Model<TenantConfig> {

	/**
	 * ID
	 */
	@TableId(value = "id")
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
