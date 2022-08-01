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
 * @since 2021-08-29T13:57:50.664
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class PreItemQO implements Serializable {

	/**
	 * ID
	 */
	@Schema(title = "ID", description = "ID")
	private Long id;

}
