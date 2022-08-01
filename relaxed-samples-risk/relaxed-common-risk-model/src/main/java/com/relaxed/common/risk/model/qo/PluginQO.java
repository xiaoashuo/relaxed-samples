package com.relaxed.common.risk.model.qo;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 查询对象
 *
 * @author Yakir
 * @since 2021-09-28T13:43:11.834
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class PluginQO implements Serializable {

	/**
	 * 主键id
	 */
	@Schema(title = "主键id", description = "主键id")
	private Long id;

}
