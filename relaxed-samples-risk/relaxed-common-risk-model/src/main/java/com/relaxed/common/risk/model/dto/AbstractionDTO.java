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
 * @since 2021-08-29T18:48:19.507
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class AbstractionDTO implements Serializable {

	/**
	 * 主键
	 */
	@Schema(title = "主键", description = "主键")
	private Long id;

	/**
	 * Abstraction 名称
	 */
	@Schema(title = "Abstraction 名称", description = "Abstraction 名称")
	private String name;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String label;

	/**
	 * MODEL ID
	 */
	@Schema(title = "MODEL ID", description = "MODEL ID")
	private Long modelId;

	/**
	 * 统计类型
	 */
	@Schema(title = "统计类型", description = "统计类型")
	private Integer aggregateType;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String searchField;

	/**
	 * 时间段类型
	 */
	@Schema(title = "时间段类型", description = "时间段类型")
	private Integer searchIntervalType;

	/**
	 * 时间段具体值
	 */
	@Schema(title = "时间段具体值", description = "时间段具体值")
	private Integer searchIntervalValue;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String functionField;

	/**
	 * 数据校验
	 */
	@Schema(title = "数据校验", description = "数据校验")
	private String ruleScript;

	/**
	 * 数据校验入口
	 */
	@Schema(title = "数据校验入口", description = "数据校验入口")
	private String ruleScriptEntry;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String ruleDefinition;

	/**
	 * 状态
	 */
	@Schema(title = "状态", description = "状态")
	private Integer status;

	/**
	 * 备注
	 */
	@Schema(title = "备注", description = "备注")
	private String comment;

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
