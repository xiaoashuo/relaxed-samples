package com.relaxed.common.risk.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * @author Yakir
 * @since 2021-08-31T09:58:08.892
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("engine_model_conf_param")
@Schema(title = "")
public class ModelConfParam extends Model<ModelConfParam> {

	/**
	 *
	 */
	@TableId(value = "id")
	@Schema(title = "", description = "")
	private Long id;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private Long moldId;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String feed;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String expressions;

}
