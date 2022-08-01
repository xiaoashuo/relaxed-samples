package com.relaxed.common.risk.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 视图层
 *
 * @author Yakir
 * @since 2021-08-31T09:58:08.656
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class ModelConfVO implements Serializable {

	/**
	 * 主键id
	 */
	@Schema(title = "", description = "")
	private Long id;

	/**
	 * 模型id
	 */
	@Schema(title = "", description = "")
	private Long modelId;

	/**
	 * 模型名称
	 */
	@Schema(title = "", description = "")
	private String name;

	/**
	 * 模型文件路径
	 */
	@Schema(title = "", description = "")
	private String path;

	/**
	 * tensorflow框架保存模型时设置的tag，非tensorflow模型此字段为空
	 */
	@Schema(title = "", description = "")
	private String tag;

	/**
	 * 模型输出操作名称，predict_Y = tf.nn.softmax(softmax_before, name='predict')
	 */
	@Schema(title = "", description = "")
	private String operation;

	/**
	 * 模型更新时间
	 */
	@Schema(title = "", description = "")
	private LocalDateTime updateDate;

	/**
	 * 机器学习类型
	 */
	@Schema(title = "机器学习类型", description = "机器学习类型")
	private String type;

	/**
	 * 描述
	 */
	@Schema(title = "描述", description = "描述")
	private String comment;

	/**
	 * 创建时间
	 */
	@Schema(title = "创建时间", description = "创建时间")
	private LocalDateTime createTime;

	/**
	 * 参数列表
	 */
	private List<ModelConfParamVO> params;

}
