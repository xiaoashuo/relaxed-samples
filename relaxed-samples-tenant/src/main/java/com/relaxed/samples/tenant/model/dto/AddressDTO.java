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
 * @since 2021-07-28T16:57:52.865
 */
@ApiModel(value = "")
@Data
@Accessors(chain = true)
public class AddressDTO implements Serializable {

	/**
	 * 主键ID
	 */
	@ApiModelProperty(value = "主键ID")
	private Long id;

	/**
	 * userid
	 */
	@ApiModelProperty(value = "userid")
	private Long userId;

	/**
	 * 地址名称
	 */
	@ApiModelProperty(value = "地址名称")
	private String addressName;

}
