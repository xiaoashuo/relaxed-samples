package com.relaxed.samples.risk.admin.service;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.risk.model.entity.Abstraction;
import com.relaxed.common.risk.model.qo.AbstractionQO;
import com.relaxed.common.risk.model.vo.AbstractionVO;
import com.relaxed.samples.risk.admin.model.domain.DataColumn;

import java.util.List;

/**
 * @author Yakir
 * @Topic AbstractionManageService
 * @Description
 * @date 2021/9/24 17:56
 * @Version 1.0
 */
public interface AbstractionManageService {

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam}
	 * @param abstractionQO {@link AbstractionQO}
	 * @return {@link PageResult<AbstractionVO>}
	 */
	PageResult<AbstractionVO> selectByPage(PageParam pageParam, AbstractionQO abstractionQO);

	/**
	 * 根据模型id获取特征列表
	 * @author yakir
	 * @date 2021/8/29 18:59
	 * @param modelId
	 * @return java.util.List<com.relaxed.common.risk.model.vo.AbstractionVO>
	 */
	List<AbstractionVO> listByModelId(Long modelId);

	/**
	 * 添加抽象特征
	 * @author yakir
	 * @date 2021/9/22 15:26
	 * @param abstraction
	 * @return boolean
	 */
	boolean add(Abstraction abstraction);

	/**
	 * 编辑特征信息
	 * @author yakir
	 * @date 2021/9/22 15:30
	 * @param abstraction
	 * @return boolean
	 */
	boolean edit(Abstraction abstraction);

	/**
	 * 删除特征信息
	 * @author yakir
	 * @date 2021/9/22 15:41
	 * @param id
	 * @return boolean
	 */
	boolean del(Long id);

	/**
	 * 查询特征使用数据列
	 * @author yakir
	 * @date 2021/9/26 13:56
	 * @param modelId
	 * @return java.util.List<com.relaxed.samples.risk.admin.model.domain.DataColumn>
	 */
	List<DataColumn> selectColumns(Long modelId);

}
