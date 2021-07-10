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
 * 模板文件目录项
 *
 * @author yakir
 * @since 2021-03-17T19:37:07.933
 */
@ApiModel(value = "模板文件目录项")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("gen_template_directory")
public class TemplateDirectory extends Model<TemplateDirectory> {

	/**
	 * 主键id
	 */
	@TableId(value = "id")
	@ApiModelProperty(value = "主键id")
	private Integer id;

	/**
	 * 模板组Id
	 */
	@ApiModelProperty(value = "模板组Id")
	private Integer groupId;

	/**
	 * 文件夹路径|模板文件名称（支持占位符）
	 */
	@ApiModelProperty(value = "文件夹路径|模板文件名称（支持占位符）")
	private String fileName;

	/**
	 * 文件类型 1：文件夹 2：模板文件
	 */
	@ApiModelProperty(value = "文件类型 1：文件夹 2：模板文件")
	private Integer type;

	/**
	 * 父级Id
	 */
	@ApiModelProperty(value = "父级Id")
	private Integer parentId;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	@ApiModelProperty(value = "更新时间")
	private LocalDateTime updateTime;

}
