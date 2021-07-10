package com.relaxed.samples.codegen.model.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 模板属性配置
 * </p>
 *
 * @author Yakir
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TemplatePropertyDTO implements Serializable {

	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 模板组ID
	 */
	private Integer groupId;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 属性键
	 */
	private String propKey;

	/**
	 * 默认值
	 */
	private String defaultValue;

	/**
	 * 必填，1：是，0：否
	 */
	private Integer required;

	/**
	 * 备注信息
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
