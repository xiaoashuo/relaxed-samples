package com.relaxed.samples.codegen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.relaxed.samples.codegen.mapper.TemplatePropertyMapper;
import com.relaxed.samples.codegen.model.converter.TemplatePropertyConverter;
import com.relaxed.samples.codegen.model.entity.TemplateProperty;
import com.relaxed.samples.codegen.model.vo.TemplatePropertyVO;
import com.relaxed.samples.codegen.service.TemplatePropertyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 模板属性配置 服务实现类
 * </p>
 *
 * @author Yakir
 * @since 2021-03-16
 */
@Service
public class TemplatePropertyServiceImpl extends ServiceImpl<TemplatePropertyMapper, TemplateProperty>
		implements TemplatePropertyService {

	@Override
	public boolean create(TemplateProperty genTemplateProperty) {
		return super.save(genTemplateProperty);
	}

	@Override
	public boolean remove(Long id) {
		return super.removeById(id);
	}

	@Override
	public boolean update(TemplateProperty genTemplateProperty) {
		return super.updateById(genTemplateProperty);
	}

	@Override
	public TemplateProperty get(Long id) {
		return super.getById(id);
	}

	@Override
	public IPage<TemplateProperty> page(int current, int size, TemplateProperty genTemplateProperty) {
		Page<TemplateProperty> page = new Page<>(current, size);
		LambdaQueryWrapper<TemplateProperty> wrapper = new LambdaQueryWrapper<>();

		// TODO 查询
		// TODO 排序

		return super.page(page, wrapper);
	}

	@Override
	public List<TemplatePropertyVO> selectListByGid(Integer templateGroupId) {
		LambdaQueryWrapper<TemplateProperty> wrappers = Wrappers.lambdaQuery(TemplateProperty.class)
				.eq(TemplateProperty::getGroupId, templateGroupId);
		List<TemplateProperty> templateProperties = this.baseMapper.selectList(wrappers);
		return TemplatePropertyConverter.INSTANCE.poToVOs(templateProperties);
	}

}
