package com.relaxed.samples.tenant.model.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 数据源
 *
 * @author yakir
 * @since 2021-07-28T15:36:12.631
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tenant_data_source_config")
public class TenantDataSourceConfig extends Model<TenantDataSourceConfig> {

	/**
	 * ID
	 */
	@TableId(value = "id")

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
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 删除时间
	 */
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

}
