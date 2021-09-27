package com.relaxed.samples.risk.admin.service;

import com.relaxed.common.risk.model.entity.Field;
import com.relaxed.common.risk.model.entity.PreItem;

/**
 * @author Yakir
 * @Topic FieldController
 * @Description
 * @date 2021/9/26 11:56
 * @Version 1.0
 */
public interface FieldManageService {

	/**
	 * 基础字段添加
	 * @author yakir
	 * @date 2021/9/26 11:58
	 * @param field
	 * @return boolean
	 */
	boolean fieldAdd(Field field);

	/**
	 * 字段编辑
	 * @author yakir
	 * @date 2021/9/26 12:00
	 * @param field
	 * @return boolean
	 */
	boolean fieldEdit(Field field);

	/**
	 * 字段删除
	 * @author yakir
	 * @date 2021/9/26 12:00
	 * @param id
	 * @return boolean
	 */
	boolean fieldDel(Long id);

	/**
	 * 添加预处理字段
	 * @author yakir
	 * @date 2021/9/12 17:31
	 * @param preItem
	 * @return boolean
	 */
	boolean preItemFieldAdd(PreItem preItem);

	/**
	 * 编辑预处理项
	 * @author yakir
	 * @date 2021/9/12 17:56
	 * @param preItem
	 * @return boolean
	 */
	boolean preItemFieldEdit(PreItem preItem);

	/**
	 * 删除预处理项
	 * @author yakir
	 * @date 2021/9/12 17:54
	 * @param modelId
	 * @param id
	 * @return boolean
	 */
	boolean preItemFieldDel(Long modelId, Long id);

}
