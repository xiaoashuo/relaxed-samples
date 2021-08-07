package com.relaxed.samples.codegen.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.samples.codegen.mapper.TemplateDirectoryMapper;
import com.relaxed.samples.codegen.model.converter.TemplateDirectoryConverter;
import com.relaxed.samples.codegen.model.entity.TemplateDirectory;
import com.relaxed.samples.codegen.model.qo.TemplateDirectoryQO;
import com.relaxed.samples.codegen.model.vo.TemplateDirectoryVO;
import com.relaxed.samples.codegen.service.TemplateDirectoryService;
import com.relaxed.samples.codegen.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 模板文件目录项 业务层实现
 * </p>
 *
 * @author yakir
 * @since 2021-03-17T19:37:07.933
 */
@RequiredArgsConstructor
@Service
public class TemplateDirectoryServiceImpl extends ServiceImpl<TemplateDirectoryMapper, TemplateDirectory>
		implements TemplateDirectoryService {

	@Override
	public PageResult<TemplateDirectoryVO> selectByPage(PageParam pageParam, TemplateDirectoryQO templateDirectoryQO) {
		IPage<TemplateDirectory> page = PageUtil.prodPage(pageParam);
		LambdaQueryWrapper<TemplateDirectory> wrapper = Wrappers.lambdaQuery(TemplateDirectory.class).eq(
				ObjectUtil.isNotNull(templateDirectoryQO.getId()), TemplateDirectory::getId,
				templateDirectoryQO.getId());
		this.baseMapper.selectPage(page, wrapper);
		IPage<TemplateDirectoryVO> voPage = page.convert(TemplateDirectoryConverter.INSTANCE::poToVo);
		return new PageResult<>(voPage.getRecords(), voPage.getTotal());
	}

	@Override
	public List<TemplateDirectory> listByTemplateGroupId(Integer templateGroupId) {
		return this.baseMapper.selectList(
				Wrappers.lambdaQuery(TemplateDirectory.class).eq(TemplateDirectory::getGroupId, templateGroupId));
	}

}
