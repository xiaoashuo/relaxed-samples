package com.relaxed.samples.codegen.model.converter;

import com.relaxed.samples.codegen.model.dto.TemplateGroupDTO;
import com.relaxed.samples.codegen.model.entity.TemplateGroup;
import com.relaxed.samples.codegen.model.vo.TemplateGroupVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 模板组 converter
 *
 * @author Yakir
 */
@Mapper
public interface TemplateGroupConverter {

	TemplateGroupConverter INSTANCE = Mappers.getMapper(TemplateGroupConverter.class);

	/**
	 * dto -> po
	 * @param templateGroupDTO {@code templateGroupDTO}
	 * @return {@code TemplateGroup}
	 */
	TemplateGroup dtoToPo(TemplateGroupDTO templateGroupDTO);

	/**
	 * po -> vo
	 * @param templateGroup {@code templateGroup}
	 * @return {@code TemplateGroupVO}
	 */
	TemplateGroupVO poToVo(TemplateGroup templateGroup);

}
