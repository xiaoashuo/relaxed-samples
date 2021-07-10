package com.relaxed.samples.codegen.model.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 模板信息
 * </p>
 *
 * @author Yakir
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TemplateInfoDTO implements Serializable {

	private Integer id;

	/**
	 * 目录id
	 */
	@ApiModelProperty(value = "目录id")
	private Integer directoryId;

	/**
	 * 模板组ID
	 */
	private Integer groupId;

	/**
	 * 模板标题
	 */
	private String title;

	/**
	 * 模板内容
	 */
	private String content;

	/**
	 * 模板引擎类型 1：velocity
	 */
	private Integer engineType;

	/**
	 * 备注
	 */
	private String remarks;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

}
