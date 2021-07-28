package com.relaxed.samples.tenant.model.qo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 查询对象
 *
 * @author yakir
 * @since 2021-07-28T16:57:52.865
 */
@ApiModel(value = "")
@Data
@Accessors(chain = true)
public class AddressQO implements Serializable {

	/**
	 * 主键ID
	 */
	@ApiModelProperty(value = "主键ID")
	private Long id;

}
