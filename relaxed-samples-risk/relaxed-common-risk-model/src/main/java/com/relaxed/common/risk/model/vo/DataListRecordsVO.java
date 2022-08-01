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
 * @since 2021-08-29T18:48:19.131
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class DataListRecordsVO implements Serializable {

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
	 * 数据记录
	 */
	@Schema(title = "数据记录", description = "数据记录")
	private String dataRecord;

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
