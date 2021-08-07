package com.relaxed.samples.codegen.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.domain.SelectData;
import com.relaxed.samples.codegen.mapper.TemplateGroupMapper;
import com.relaxed.samples.codegen.model.converter.TemplateGroupConverter;
import com.relaxed.samples.codegen.model.dto.TemplateGroupDTO;
import com.relaxed.samples.codegen.model.entity.TemplateGroup;
import com.relaxed.samples.codegen.model.vo.TemplateGroupVO;
import com.relaxed.samples.codegen.service.TemplateGroupService;
import com.relaxed.samples.codegen.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 模板组 服务实现类
 * </p>
 *
 * @author Yakir
 * @since 2021-03-16
 */
@RequiredArgsConstructor
@Service
public class TemplateGroupServiceImpl extends ServiceImpl<TemplateGroupMapper, TemplateGroup>
		implements TemplateGroupService {

	@Override
	public PageResult<TemplateGroupVO> selectByPage(PageParam pageParam, TemplateGroupDTO templateGroupDTO) {
		IPage<TemplateGroup> page = PageUtil.prodPage(pageParam);
		LambdaQueryWrapper<TemplateGroup> wrapper = Wrappers.lambdaQuery(TemplateGroup.class)
				.eq(ObjectUtil.isNotNull(templateGroupDTO.getId()), TemplateGroup::getId, templateGroupDTO.getId())
				.eq(StrUtil.isNotEmpty(templateGroupDTO.getName()), TemplateGroup::getName, templateGroupDTO.getName());
		this.baseMapper.selectPage(page, wrapper);
		IPage<TemplateGroupVO> voPage = page.convert(TemplateGroupConverter.INSTANCE::poToVo);
		return new PageResult<>(voPage.getRecords(), voPage.getTotal());
	}

	@Override
	public List<SelectData<?>> selectAllTemplateGroup() {
		return baseMapper.selectAllTemplateGroup();
	}

}
