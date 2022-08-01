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
 * @since 2021-09-01T13:49:40.174
 */
@Data
@Accessors(chain = true)
@Schema(title = "")
public class MobileInfoDTO implements Serializable {

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private Long id;

	/**
	 * 主键
	 */
	@Schema(title = "主键", description = "主键")
	private String mobile;

	/**
	 * 省
	 */
	@Schema(title = "省", description = "省")
	private String province;

	/**
	 * 市
	 */
	@Schema(title = "市", description = "市")
	private String city;

	/**
	 * 卡信息
	 */
	@Schema(title = "卡信息", description = "卡信息")
	private String supplier;

	/**
	 * 区号
	 */
	@Schema(title = "区号", description = "区号")
	private String regionCode;

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
