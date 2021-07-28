package com.relaxed.samples.tenant.service;

import com.relaxed.extend.mybatis.plus.service.ExtendService;
import com.relaxed.samples.tenant.model.dto.AddressDTO;
import com.relaxed.samples.tenant.model.qo.AddressQO;
import com.relaxed.samples.tenant.model.vo.AddressVO;
import com.relaxed.samples.tenant.model.entity.Address;

import com.baomidou.mybatisplus.extension.service.IService;
import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;

/**
 * <p>
 * 业务层
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T16:57:52.865
 */
public interface AddressService extends ExtendService<Address> {

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam}
	 * @param addressQO {@link AddressQO}
	 * @return {@link PageResult<AddressVO>}
	 */
	PageResult<AddressVO> selectByPage(PageParam pageParam, AddressQO addressQO);

}