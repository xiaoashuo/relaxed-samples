package com.relaxed.samples.tenant.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.relaxed.extend.mybatis.plus.service.impl.ExtendServiceImpl;
import com.relaxed.samples.tenant.mapper.TUserMapper;
import com.relaxed.samples.tenant.model.converter.TUserConverter;
import com.relaxed.samples.tenant.model.qo.TUserQO;
import com.relaxed.samples.tenant.service.TUserService;
import com.relaxed.samples.tenant.model.dto.TUserDTO;
import com.relaxed.samples.tenant.model.entity.TUser;
import com.relaxed.samples.tenant.model.vo.TUserVO;

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
 * @since 2021-07-28T16:57:52.841
 */
@RequiredArgsConstructor
@Service
public class TUserServiceImpl extends ExtendServiceImpl<TUserMapper, TUser> implements TUserService {

	@Override
	public PageResult<TUserVO> selectByPage(PageParam pageParam, TUserQO tUserQO) {
		IPage<TUser> page = PageUtil.prodPage(pageParam);
		LambdaQueryWrapper<TUser> wrapper = Wrappers.lambdaQuery(TUser.class).eq(ObjectUtil.isNotNull(tUserQO.getId()),
				TUser::getId, tUserQO.getId());

		IPage<TUserVO> pageVo = this.baseMapper.selectPage(page, wrapper).convert(TUserConverter.INSTANCE::poToVo);
		return new PageResult<>(pageVo.getRecords(), pageVo.getTotal());
	}

}
