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
 * @since 2021-08-31T11:30:23.317
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("engine_rule_history")
@Schema(title = "")
public class RuleHistory extends Model<RuleHistory> {

	/**
	 * 主键
	 */
	@TableId(value = "ID")
	@Schema(title = "主键", description = "主键")
	private Long id;

	/**
	 * 模型ID
	 */
	@Schema(title = "模型ID", description = "模型ID")
	private Long ruleId;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String merchantCode;

	/**
	 * 规则名称
	 */
	@Schema(title = "规则名称", description = "规则名称")
	private String label;

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
	 *
	 */
	@Schema(title = "", description = "")
	private String ruleDefinition;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private LocalDateTime updateTime;

}
