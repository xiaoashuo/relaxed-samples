package com.relaxed.samples.codegen.model.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 模板文件目录项 查询对象
 *
 * @author yakir
 * @since 2021-03-17T19:37:07.933
 */
@ApiModel(value = "模板文件目录项")
@Data
@Accessors(chain = true)
public class TemplateDirectoryQO implements Serializable {

	/**
	*
	*/
	@ApiModelProperty(value = "")
	private Integer id;

}
