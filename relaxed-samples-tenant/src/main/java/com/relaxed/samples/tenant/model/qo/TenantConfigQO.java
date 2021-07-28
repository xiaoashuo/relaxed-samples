package com.relaxed.samples.tenant.model.qo;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 租户配置 查询对象
 *
 * @author yakir
 * @since 2021-07-28T16:42:43.380
 */
@Data
@Accessors(chain = true)
public class TenantConfigQO implements Serializable {

	/**
	 * ID
	 */
	private Integer id;

}
