package com.relaxed.samples.codegen.mapper;

import com.relaxed.common.core.domain.SelectData;
import com.relaxed.extend.mybatis.plus.mapper.ExtendMapper;
import com.relaxed.samples.codegen.model.entity.TemplateGroup;

import java.util.List;

/**
 * <p>
 * 模板组 Mapper 接口
 * </p>
 *
 * @author Yakir
 * @since 2021-03-16
 */
public interface TemplateGroupMapper extends ExtendMapper<TemplateGroup> {

	/**
	 * 查询所有模板组
	 * @return {@link List<SelectData<?>>}
	 */
	List<SelectData<?>> selectAllTemplateGroup();

}
