package com.relaxed.common.risk.model.qo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 查询对象
 *
 * @author Yakir
 * @since 2021-09-01T13:49:40.174
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class MobileInfoQO implements Serializable {

	/**
	*
	*/
	@Schema(title = "", description = "")
	private Long id;

}
