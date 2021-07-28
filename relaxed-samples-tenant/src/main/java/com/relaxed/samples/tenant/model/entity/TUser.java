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
 * @since 2021-07-28T16:57:52.841
 */
@ApiModel(value = "")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_user")
public class TUser extends Model<TUser> {

	/**
	 * 主键ID
	 */
	@TableId(value = "id")
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
