package com.relaxed.common.risk.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;

/**
 * @author Yakir
 * @since 2021-08-31T09:58:08.656
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("engine_model_conf")
@Schema(title = "")
public class ModelConf extends Model<ModelConf> {

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
	private Long modelId;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String name;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String path;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String tag;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String operation;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private LocalDateTime updateDate;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String type;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String comment;

	/**
	 *
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	@Schema(title = "", description = "")
	private LocalDateTime createTime;

}
