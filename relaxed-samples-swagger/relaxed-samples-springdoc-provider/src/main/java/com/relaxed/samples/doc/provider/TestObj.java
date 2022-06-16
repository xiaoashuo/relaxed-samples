package com.relaxed.samples.doc.provider;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Schema
@Data
public class TestObj {

	@Schema
	private Integer userId;

	@Schema(title = "姓名")
	private String name;

	@Schema
	private BigDecimal money;

}
