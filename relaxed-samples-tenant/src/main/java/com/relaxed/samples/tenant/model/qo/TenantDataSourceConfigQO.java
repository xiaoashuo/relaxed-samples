package com.relaxed.samples.tenant.model.qo;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 数据源 查询对象
 *
 * @author yakir
 * @since 2021-07-28T16:42:43.396
 */
@Data
@Accessors(chain = true)
public class TenantDataSourceConfigQO implements Serializable {

	/**
	 * ID
	 */
	private Integer id;

}
