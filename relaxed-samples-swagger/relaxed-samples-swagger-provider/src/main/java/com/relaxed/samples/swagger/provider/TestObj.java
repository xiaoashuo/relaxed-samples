package com.relaxed.samples.swagger.provider;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Yakir
 * @Topic TestObj
 * @Description
 * @date 2021/7/8 14:45
 * @Version 1.0
 */
@ApiModel("测试对象")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestObj {

	/**
	 * 用户名
	 */
	@ApiModelProperty("用户名")
	@NotNull
	private String userName;

	/**
	 * 年龄
	 */
	@ApiModelProperty(value = "年龄", required = true)
	@Min(value = 2)
	private Integer age;

	private Boolean open;

}
