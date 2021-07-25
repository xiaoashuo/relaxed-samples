package com.relaxed.samples.datascope.model;

import com.baomidou.mybatisplus.annotation.TableField;
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
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User {

	private Long id;

	/**
	 * 租户 ID
	 */
	private Long pid;

	private String name;

	@TableField(exist = false)
	private String addrName;

}
