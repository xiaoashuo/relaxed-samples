package com.relaxed.samples.doc.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestObj {

	private Integer userId;

	private String name;

	private BigDecimal money;

}
