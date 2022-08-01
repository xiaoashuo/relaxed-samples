package com.relaxed.common.risk.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 数据传输对象
 *
 * @author Yakir
 * @since 2021-08-31T09:58:08.656
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class ModelConfDTO implements Serializable {

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private Long id;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private Long modelId;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String name;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String path;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String tag;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String operation;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private LocalDateTime updateDate;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String type;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String comment;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private LocalDateTime createTime;

}
