package com.relaxed.common.risk.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 数据传输对象
 *
 * @author Yakir
 * @since 2021-08-29T09:04:20.388
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class ModelDTO implements Serializable {

	/**
	 * 主键
	 */
	@Schema(title = "主键", description = "主键")
	private Long id;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String guid;

	/**
	 * 模型名称
	 */
	@Schema(title = "模型名称", description = "模型名称")
	private String modelName;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String label;

	/**
	 * 事件中标识实体的主键
	 */
	@Schema(title = "事件中标识实体的主键", description = "事件中标识实体的主键")
	private String entityName;

	/**
	 * 事件主键
	 */
	@Schema(title = "事件主键", description = "事件主键")
	private String entryName;

	/**
	 * 事件时间
	 */
	@Schema(title = "事件时间", description = "事件时间")
	private String referenceDate;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private Integer fieldValidate;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String code;

	/**
	 * 1 标识模板
	 */
	@Schema(title = "1 标识模板", description = "1 标识模板")
	private Integer template;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String dashboardUrl;

	/**
	 * 状态
	 */
	@Schema(title = "状态", description = "状态")
	private Integer status;

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
