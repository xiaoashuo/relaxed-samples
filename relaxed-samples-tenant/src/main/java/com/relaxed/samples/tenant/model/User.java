package com.relaxed.samples.tenant.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户实体对应表 user
 * </p>
 *
 * @author hubin
 * @since 2018-08-11
 */
@TableName("t_user")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User {

	@TableId
	private Long id;

	/**
	 * 租户 ID
	 */
	private Long tenantId;

	private String username;

	// @TableField(exist = false)
	// private String addrName;

}
