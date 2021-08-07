package com.relaxed.samples.tenant.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.relaxed.extend.mybatis.plus.service.impl.ExtendServiceImpl;
import com.relaxed.samples.tenant.mapper.AddressMapper;
import com.relaxed.samples.tenant.model.converter.AddressConverter;
import com.relaxed.samples.tenant.model.qo.AddressQO;
import com.relaxed.samples.tenant.service.AddressService;
import com.relaxed.samples.tenant.model.dto.AddressDTO;
import com.relaxed.samples.tenant.model.entity.Address;
import com.relaxed.samples.tenant.model.vo.AddressVO;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.samples.tenant.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务层实现
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T16:57:52.865
 */
@RequiredArgsConstructor
@Service
public class AddressServiceImpl extends ExtendServiceImpl<AddressMapper, Address> implements AddressService {

	@Override
	public PageResult<AddressVO> selectByPage(PageParam pageParam, AddressQO addressQO) {
		IPage<Address> page = PageUtil.prodPage(pageParam);
		LambdaQueryWrapper<Address> wrapper = Wrappers.lambdaQuery(Address.class)
				.eq(ObjectUtil.isNotNull(addressQO.getId()), Address::getId, addressQO.getId());
		IPage<AddressVO> pageVo = this.baseMapper.selectPage(page, wrapper).convert(AddressConverter.INSTANCE::poToVo);
		return new PageResult<>(pageVo.getRecords(), pageVo.getTotal());
	}

}
