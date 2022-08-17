package com.relaxed.samples.doc.provider;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Schema(name = "结果对象")
public class ResultObj implements Serializable {

	private static final long serialVersionUID = -8639657461150007772L;

	@Schema(title = "用户id")
	private Integer usernameId;

}
