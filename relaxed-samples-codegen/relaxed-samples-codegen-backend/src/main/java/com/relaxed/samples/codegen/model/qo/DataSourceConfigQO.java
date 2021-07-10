package com.relaxed.samples.codegen.model.qo;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据源配置QO
 *
 * @author yakir
 */
@Data
public class DataSourceConfigQO implements Serializable {

	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 数据源名称
	 */
	private String name;

}