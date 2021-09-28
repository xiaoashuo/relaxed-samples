package com.relaxed.samples.risk.admin.service;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.risk.model.entity.Model;
import com.relaxed.common.risk.model.qo.ModelQO;
import com.relaxed.common.risk.model.vo.ModelVO;

/**
 * @author Yakir
 * @Topic ModelManageService
 * @Description
 * @date 2021/9/28 11:45
 * @Version 1.0
 */
public interface ModelManageService {

	/**
	 * 查询列表
	 * @author yakir
	 * @date 2021/8/29 9:10
	 * @param pageParam
	 * @param modelQO
	 * @return com.relaxed.common.model.domain.PageResult<com.relaxed.common.risk.model.vo.ModelVO>
	 */
	PageResult<ModelVO> selectByPage(PageParam pageParam, ModelQO modelQO);

	/**
	 * 保存model
	 * @author yakir
	 * @date 2021/9/12 16:59
	 * @param model
	 * @return boolean
	 */
	boolean add(Model model);

	/**
	 * 删除模型
	 * @author yakir
	 * @date 2021/9/12 17:18
	 * @param id
	 * @return boolean
	 */
	boolean del(Long id);

	/**
	 * 编辑模型
	 * @author yakir
	 * @date 2021/9/28 11:50
	 * @param model
	 * @return boolean
	 */
	boolean edit(Model model);

}
