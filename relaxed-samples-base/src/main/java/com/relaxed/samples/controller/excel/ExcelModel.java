package com.relaxed.samples.controller.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Yakir
 * @Topic ExcelModel
 * @Description
 * @date 2022/1/19 16:54
 * @Version 1.0
 */
@Data
public class ExcelModel {

	/**
	 * id
	 */
	@ExcelProperty(value = "标识id", index = 0)
	private Integer id;

	/**
	 * 用户名
	 */
	@ExcelProperty(value = "用户名", index = 1)
	private String username;

	/**
	 * 年龄
	 */
	@ExcelProperty(value = "年龄", index = 2)
	private Integer age;

	/**
	 * 性别
	 */
	@ExcelProperty(value = "创建时间", index = 3)
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@ExcelProperty(value = "更新时间", index = 4)
	private LocalDateTime updateTime;

}
