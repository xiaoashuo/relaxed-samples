package com.relaxed.common.risk.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 视图层
 *
 * @author Yakir
 * @since 2021-08-29T18:48:19.389
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class DataListsVO implements Serializable {

	/**
	 * 主键
	 */
	@Schema(title = "主键", description = "主键")
	private Long id;

	/**
	 * 列表名
	 */
	@Schema(title = "列表名", description = "列表名")
	private String name;

	/**
	 * 列表名中文描叙
	 */
	@Schema(title = "列表名中文描叙", description = "列表名中文描叙")
	private String label;

	/**
	 * 模型ID
	 */
	@Schema(title = "模型ID", description = "模型ID")
	private Long modelId;

	/**
	 * 注释
	 */
	@Schema(title = "注释", description = "注释")
	private String comment;

	/**
	 * 列表类型
	 */
	@Schema(title = "列表类型", description = "列表类型")
	private String listType;

	/**
	 * 状态
	 */
	@Schema(title = "状态", description = "状态")
	private Integer status;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private LocalDateTime createTime;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private LocalDateTime updateTime;

}
