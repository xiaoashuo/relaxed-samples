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
@Schema(name = "测试对象")
public class TestObj implements Serializable {

	private static final long serialVersionUID = 3299444707677885300L;

	@Schema(title = "用户")
	private Integer userId;

	@Schema(title = "姓名")
	private String name;

	@Schema(title = "钱")
	private BigDecimal money;

}
