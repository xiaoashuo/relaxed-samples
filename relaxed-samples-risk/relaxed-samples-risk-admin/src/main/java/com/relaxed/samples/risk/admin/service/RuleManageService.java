package com.relaxed.samples.risk.admin.service;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.risk.model.entity.Rule;
import com.relaxed.common.risk.model.qo.RuleQO;
import com.relaxed.common.risk.model.vo.RuleVO;

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
