package com.relaxed.samples.codegen.model.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 模板组
 * </p>
 *
 * @author Yakir
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gen_template_group")
public class TemplateGroupDTO implements Serializable {

	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 备注
	 */
	private String remarks;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

}
