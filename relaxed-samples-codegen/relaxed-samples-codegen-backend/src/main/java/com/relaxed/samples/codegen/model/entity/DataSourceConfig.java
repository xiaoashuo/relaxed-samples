package com.relaxed.samples.codegen.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 数据源配置
 *
 * @author yakir
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gen_data_source_config")
public class DataSourceConfig implements Serializable {

	/**
	 * ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
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
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 删除时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

}