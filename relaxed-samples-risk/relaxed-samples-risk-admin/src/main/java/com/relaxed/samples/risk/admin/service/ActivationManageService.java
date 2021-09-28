package com.relaxed.samples.risk.admin.service;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.risk.model.entity.Activation;
import com.relaxed.common.risk.model.qo.ActivationQO;
import com.relaxed.common.risk.model.vo.ActivationVO;
import com.relaxed.samples.risk.admin.model.domain.DataColumn;

import java.util.List;

/**
 * @author Yakir
 * @Topic ActivationManageService
 * @Description
 * @date 2021/9/27 18:04
 * @Version 1.0
 */
public interface ActivationManageService {

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam}
	 * @param activationQO {@link ActivationQO}
	 * @return {@link PageResult<ActivationVO>}
	 */
	PageResult<ActivationVO> selectByPage(PageParam pageParam, ActivationQO activationQO);

	/**
	 * 添加决策器
	 * @author yakir
	 * @date 2021/9/22 16:10
	 * @param activation
	 * @return boolean
	 */
	boolean add(Activation activation);

	/**
	 * 编辑决策器
	 * @author yakir
	 * @date 2021/9/22 16:10
	 * @param activation
	 * @return boolean
	 */
	boolean edit(Activation activation);

	/**
	 * 删除决策器
	 * @author yakir
	 * @date 2021/9/22 16:10
	 * @param id
	 * @return boolean
	 */
	boolean del(Long id);

}
