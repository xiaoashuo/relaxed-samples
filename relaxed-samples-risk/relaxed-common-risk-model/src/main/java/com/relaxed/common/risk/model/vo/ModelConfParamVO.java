package com.relaxed.common.risk.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 视图层
 *
 * @author Yakir
 * @since 2021-08-31T09:58:08.892
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class ModelConfParamVO implements Serializable {

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private Long id;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private Long moldId;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String feed;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String expressions;

}
