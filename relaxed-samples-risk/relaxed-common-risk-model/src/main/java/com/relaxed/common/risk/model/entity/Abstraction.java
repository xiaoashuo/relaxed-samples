package com.relaxed.common.risk.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * @author Yakir
 * @since 2021-08-29T18:48:19.507
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("engine_abstraction")
@Schema(title = "")
public class Abstraction extends Model<Abstraction> {

	/**
	 * 主键
	 */
	@TableId(value = "ID")
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
