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

/**
 * @author Yakir
 * @since 2021-08-29T18:48:19.435
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("engine_activation")
@Schema(title = "")
public class Activation extends Model<Activation> {

	/**
	 * 主键
	 */
	@TableId(value = "ID")
	@Schema(title = "主键", description = "主键")
	private Long id;

	/**
	 * 名称
	 */
	@Schema(title = "名称", description = "名称")
	private String activationName;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String label;

	/**
	 * model id
	 */
	@Schema(title = "model id", description = "model id")
	private Long modelId;

	/**
	 * 注释
	 */
	@Schema(title = "注释", description = "注释")
	private String comment;

	/**
	 * 底部阀值
	 */
	@Schema(title = "底部阀值", description = "底部阀值")
	private Integer bottom;

	/**
	 * 中间阀值
	 */
	@Schema(title = "中间阀值", description = "中间阀值")
	private Integer median;

	/**
	 * 顶部阀值
	 */
	@Schema(title = "顶部阀值", description = "顶部阀值")
	private Integer high;

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
