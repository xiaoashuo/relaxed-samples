package com.relaxed.samples.risk.admin.service;

import com.relaxed.common.risk.model.entity.Field;
import com.relaxed.common.risk.model.entity.PreItem;
import com.relaxed.common.risk.model.vo.FieldVO;
import com.relaxed.common.risk.model.vo.PreItemVO;

import java.util.List;

/**
 * @author Yakir
 * @Topic FieldController
 * @Description
 * @date 2021/9/26 11:56
 * @Version 1.0
 */
public interface FieldManageService {

	/**
	 * 根据模型id 查询字段列表
	 * @author yakir
	 * @date 2021/9/28 16:24
	 * @param modelId
	 * @return java.util.List<com.relaxed.common.risk.model.vo.FieldVO>
	 */
	List<FieldVO> fieldListByModelId(Long modelId);

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
	 * 获取预处理项列表
	 * @author yakir
	 * @date 2021/9/28 16:31
	 * @param modelId
	 * @return java.util.List<com.relaxed.common.risk.model.vo.PreItemVO>
	 */
	List<PreItemVO> preItemListByModelId(Long modelId);

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
