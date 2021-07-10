package com.relaxed.samples.codegen.model.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 模板信息
 *
 * @author Yakir
 * @since 2021-03-16
 */
@ApiModel(value = "模板信息表")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("gen_template_info")
public class TemplateInfo extends Model<TemplateInfo> {

	/**
	 * 主键id
	 */
	@ApiModelProperty(value = "注解id")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 目录id
	 */
	@ApiModelProperty(value = "目录id")
	private Integer directoryId;

	/**
	 * 模板组ID
	 */
	@ApiModelProperty(value = "模板组id")
	private Integer groupId;

	/**
	 * 模板标题
	 */
	@ApiModelProperty(value = "模板标题")
	private String title;

	/**
	 * 模板内容
	 */
	@ApiModelProperty(value = "模板内容")
	private String content;

	/**
	 * 模板引擎类型 1：velocity
	 */
	@ApiModelProperty(value = "模板信息引擎")
	private Integer engineType;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "模板信息备注")
	private String remarks;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "更新时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

}
