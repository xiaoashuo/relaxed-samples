package com.relaxed.samples.tenant.model.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author yakir
 * @since 2021-07-28T16:57:52.865
 */
@ApiModel(value = "")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("address")
public class Address extends Model<Address> {

	/**
	 * 主键ID
	 */
	@TableId(value = "id")
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
