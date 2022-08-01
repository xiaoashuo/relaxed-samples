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
 * @since 2021-08-31T09:58:08.892
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class ModelConfParamQO implements Serializable {

	/**
	*
	*/
	@Schema(title = "", description = "")
	private Long id;

}
