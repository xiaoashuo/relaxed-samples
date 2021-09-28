package com.relaxed.samples.risk.admin.service;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.risk.model.entity.Rule;
import com.relaxed.common.risk.model.qo.RuleQO;
import com.relaxed.common.risk.model.vo.RuleVO;
import com.relaxed.samples.risk.admin.model.domain.DataColumn;

import java.util.List;

/**
 * @author Yakir
 * @Topic RuleManageService
 * @Description
 * @date 2021/9/24 14:34
 * @Version 1.0
 */
public interface RuleManageService {

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam}
	 * @param ruleQO {@link RuleQO}
	 * @return {@link PageResult<RuleVO>}
	 */
	PageResult<RuleVO> selectByPage(PageParam pageParam, RuleQO ruleQO);

	/**
	 * 查询特征使用数据列
	 * @author yakir
	 * @date 2021/9/26 13:56
	 * @param modelId
	 * @return java.util.List<com.relaxed.samples.risk.admin.model.domain.DataColumn>
	 */
	List<DataColumn> selectColumns(Long modelId);

	/**
	 * 添加规则
	 * @author yakir
	 * @date 2021/9/24 14:31
	 * @param rule
	 * @return boolean
	 */
	boolean add(Rule rule);

	/**
	 * 编辑规则
	 * @author yakir
	 * @date 2021/9/24 14:31
	 * @param rule
	 * @return boolean
	 */
	boolean edit(Rule rule);

	/**
	 * 删除规则
	 * @author yakir
	 * @date 2021/9/24 14:32
	 * @param id
	 * @return boolean
	 */
	boolean del(Long id);

}
