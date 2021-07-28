package com.relaxed.samples.tenant.model.dto;

import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import lombok.experimental.Accessors;

/**
 * 数据传输对象
 *
 * @author yakir
 * @since 2021-07-28T16:57:52.841
 */
@ApiModel(value = "")
@Data
@Accessors(chain = true)
public class TUserDTO implements Serializable {

	/**
	 * 主键ID
	 */
	@ApiModelProperty(value = "主键ID")
	private Long id;

	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
	private String username;

	/**
	 * 租户id
	 */
	@ApiModelProperty(value = "租户id")
	private Long tenantId;

}
