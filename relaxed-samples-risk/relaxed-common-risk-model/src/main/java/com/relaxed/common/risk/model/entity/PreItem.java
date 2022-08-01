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

import javax.validation.constraints.NotNull;

/**
 * @author Yakir
 * @since 2021-08-29T13:57:50.664
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("engine_pre_item")
@Schema(title = "")
public class PreItem extends Model<PreItem> {

	/**
	 * ID
	 */
	@TableId(value = "ID")
	@Schema(title = "ID", description = "ID")
	private Long id;

	/**
	 * 模型ID
	 */
	@NotNull(message = "模型id不能为空")
	@Schema(title = "模型ID", description = "模型ID")
	private Long modelId;

	/**
	 * 来源字段
	 */
	@Schema(title = "来源字段", description = "来源字段")
	private String sourceField;

	/**
	 * 来源标签
	 */
	@Schema(title = "来源标签", description = "来源标签")
	private String sourceLabel;

	/**
	 * 目标字段
	 */
	@Schema(title = "目标字段", description = "目标字段")
	private String destField;

	/**
	 * 目标字段类型
	 */
	@Schema(title = "目标字段类型", description = "目标字段类型")
	private String destFieldType;

	/**
	 * 目标标签 描述
	 */
	@Schema(title = "目标标签", description = "目标标签")
	private String label;

	/**
	 * 参数
	 */
	@Schema(title = "参数", description = "参数")
	private String args;

	/**
	 * 转换插件
	 */
	@Schema(title = "转换插件", description = "转换插件")
	private String plugin;

	/**
	 * 扩展配置信息
	 */
	@Schema(title = "扩展配置信息", description = "扩展配置信息")
	private String configJson;

	/**
	 * 状态
	 */
	@Schema(title = "状态", description = "状态")
	private Integer status;

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
