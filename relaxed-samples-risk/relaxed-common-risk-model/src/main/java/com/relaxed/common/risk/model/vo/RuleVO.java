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
 * @since 2021-08-31T11:30:23.273
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class RuleVO implements Serializable {

	/**
	 * 主键
	 */
	@Schema(title = "主键", description = "主键")
	private Long id;

	/**
	 * 模型ID
	 */
	@Schema(title = "模型ID", description = "模型ID")
	private Long modelId;

	/**
	 * 策略ID
	 */
	@Schema(title = "策略ID", description = "策略ID")
	private Long activationId;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String name;

	/**
	 * 规则名称
	 */
	@Schema(title = "规则名称", description = "规则名称")
	private String label;

	/**
	 * 检验脚本
	 */
	@Schema(title = "检验脚本", description = "检验脚本")
	private String scripts;

	/**
	 * 检验脚本入口
	 */
	@Schema(title = "检验脚本入口", description = "检验脚本入口")
	private String scriptEntry;

	/**
	 * 初始分数
	 */
	@Schema(title = "初始分数", description = "初始分数")
	private Integer initScore;

	/**
	 * 基数
	 */
	@Schema(title = "基数", description = "基数")
	private Integer baseNum;

	/**
	 * 运算符
	 */
	@Schema(title = "运算符", description = "运算符")
	private String operator;

	/**
	 * 抽象名称
	 */
	@Schema(title = "抽象名称", description = "抽象名称")
	private String abstractionName;

	/**
	 * 比例
	 */
	@Schema(title = "比例", description = "比例")
	private Integer rate;

	/**
	 * 最大得分值
	 */
	@Schema(title = "最大得分值", description = "最大得分值")
	private Integer max;

	/**
	 * 状态
	 */
	@Schema(title = "状态", description = "状态")
	private Integer status;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String ruleDefinition;

	/**
	 * 规则顺序
	 */
	@Schema(title = "规则顺序", description = "规则顺序")
	private Integer ruleOrder;

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
