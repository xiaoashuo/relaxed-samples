package com.relaxed.samples.codegen.model.dto;

import com.relaxed.samples.codegen.model.entity.ColumnInfo;
import com.relaxed.samples.codegen.model.entity.TableInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Yakir
 * @Topic TableInfoDTO
 * @Description
 * @date 2021/7/17 16:24
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableInfoDTO {

	/**
	 * 表信息
	 */
	private TableInfo tableInfo;

	/**
	 * 列信息
	 */
	private List<ColumnInfo> columnInfos;

}
