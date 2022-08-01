package com.relaxed.common.risk.model.qo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 查询对象
 *
 * @author Yakir
 * @since 2021-08-31T11:30:23.317
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class RuleHistoryQO implements Serializable {

	/**
	 * 主键
	 */
	@Schema(title = "主键", description = "主键")
	private Long id;

}
