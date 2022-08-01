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
 * @since 2021-08-29T18:48:19.341
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class DataListMetaVO implements Serializable {

	/**
	 * 主键
	 */
	@Schema(title = "主键", description = "主键")
	private Long id;

	/**
	 * 数据列表ID
	 */
	@Schema(title = "数据列表ID", description = "数据列表ID")
	private Long dataListId;

	/**
	 * 字段名
	 */
	@Schema(title = "字段名", description = "字段名")
	private String fieldName;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String label;

	/**
	 * 字段序号
	 */
	@Schema(title = "字段序号", description = "字段序号")
	private Integer seqNum;

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
