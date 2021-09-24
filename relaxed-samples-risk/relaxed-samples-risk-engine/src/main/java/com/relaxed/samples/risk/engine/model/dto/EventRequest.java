package com.relaxed.samples.risk.engine.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 事件信息
 *
 * @author yakir
 * @date 2021/9/7 10:52
 */
@Data
public class EventRequest {

	@ApiModelProperty(value = "模型guid")
	@NotBlank(message = "guid 不能为空")
	private String guid;

	@ApiModelProperty(value = "请求流水号")
	@NotBlank(message = "reqId 不能为空")
	private String reqId;

	@ApiModelProperty(value = "事件内容")
	@NotNull(message = "jsonInfo 不能为空")
	private Map jsonInfo;

}
