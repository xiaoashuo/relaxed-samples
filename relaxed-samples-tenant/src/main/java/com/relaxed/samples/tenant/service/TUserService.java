package com.relaxed.samples.tenant.service;

import com.relaxed.extend.mybatis.plus.service.ExtendService;
import com.relaxed.samples.tenant.model.dto.TUserDTO;
import com.relaxed.samples.tenant.model.qo.TUserQO;
import com.relaxed.samples.tenant.model.vo.TUserVO;
import com.relaxed.samples.tenant.model.entity.TUser;

import com.baomidou.mybatisplus.extension.service.IService;
import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;

/**
 * <p>
 * 业务层
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T16:57:52.841
 */
public interface TUserService extends ExtendService<TUser> {

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam}
	 * @param tUserQO {@link TUserQO}
	 * @return {@link PageResult<TUserVO>}
	 */
	PageResult<TUserVO> selectByPage(PageParam pageParam, TUserQO tUserQO);

}