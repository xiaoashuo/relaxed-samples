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
 * @since 2021-08-31T11:30:23.273
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("engine_rule")
@Schema(title = "")
public class Rule extends Model<Rule> {

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
	private Long modelId;

	/**
	 * 激活ID
	 */
	@Schema(title = "激活ID", description = "激活ID")
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
	 * 创建时间
	 */
	@Schema(title = "创建时间", description = "创建时间")
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@Schema(title = "更新时间", description = "更新时间")
	private LocalDateTime updateTime;

}
