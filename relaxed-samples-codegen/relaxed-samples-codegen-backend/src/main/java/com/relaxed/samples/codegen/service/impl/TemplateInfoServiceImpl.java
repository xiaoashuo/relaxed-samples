package com.relaxed.samples.codegen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.relaxed.samples.codegen.mapper.TemplateInfoMapper;
import com.relaxed.samples.codegen.model.converter.TemplateInfoConverter;
import com.relaxed.samples.codegen.model.entity.TemplateInfo;
import com.relaxed.samples.codegen.model.vo.TemplateInfoVO;
import com.relaxed.samples.codegen.service.TemplateInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 模板信息 服务实现类
 * </p>
 *
 * @author Yakir
 * @since 2021-03-16
 */
@RequiredArgsConstructor
@Service
public class TemplateInfoServiceImpl extends ServiceImpl<TemplateInfoMapper, TemplateInfo>
		implements TemplateInfoService {

	@Override
	public List<TemplateInfo> selectTemplateInfoListByGid(Integer templateGroupId) {
		LambdaQueryWrapper<TemplateInfo> wrapper = Wrappers.lambdaQuery(TemplateInfo.class).eq(TemplateInfo::getGroupId,
				templateGroupId);
		return this.baseMapper.selectList(wrapper);
	}

	@Override
	public List<TemplateInfoVO> listTemplateInfosByGid(Integer templateGroupId) {
		List<TemplateInfo> templateInfos = baseMapper
				.selectList(Wrappers.lambdaQuery(TemplateInfo.class).eq(TemplateInfo::getGroupId, templateGroupId));
		return TemplateInfoConverter.INSTANCE.poToVOs(templateInfos);
	}

}
