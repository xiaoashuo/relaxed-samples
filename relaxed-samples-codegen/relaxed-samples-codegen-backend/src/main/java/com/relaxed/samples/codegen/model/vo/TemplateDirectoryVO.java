package com.relaxed.samples.codegen.model.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 模板文件目录项 视图层
 *
 * @author yakir
 * @since 2021-03-17T19:37:07.933
 */
@ApiModel(value = "模板文件目录项")
@Data
@Accessors(chain = true)
public class TemplateDirectoryVO implements Serializable {

	/**
	 *
	 */
	@ApiModelProperty(value = "")
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
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	private LocalDateTime updateTime;

}
