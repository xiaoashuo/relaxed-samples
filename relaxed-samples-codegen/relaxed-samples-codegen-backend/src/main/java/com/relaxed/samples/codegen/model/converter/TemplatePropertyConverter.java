package com.relaxed.samples.codegen.model.converter;

import com.relaxed.samples.codegen.model.dto.TemplatePropertyDTO;
import com.relaxed.samples.codegen.model.entity.TemplateProperty;
import com.relaxed.samples.codegen.model.vo.TemplatePropertyVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 模板属性转换器
 *
 * @author Yakir
 */
@Mapper
public interface TemplatePropertyConverter {

	TemplatePropertyConverter INSTANCE = Mappers.getMapper(TemplatePropertyConverter.class);

	/**
	 * po -> vo
	 * @param templateProperty {@link TemplateProperty}
	 * @return {@link TemplatePropertyVO}
	 */
	TemplatePropertyVO poToVo(TemplateProperty templateProperty);

	/**
	 * dto -> po
	 * @param templatePropertyDTO {@link TemplatePropertyDTO}
	 * @return {@link TemplateProperty}
	 */
	TemplateProperty dtoToPo(TemplatePropertyDTO templatePropertyDTO);

	/**
	 * po -> vos
	 * @param templateProperties {@link List<TemplateProperty>}
	 * @return {@link List<TemplatePropertyVO>}
	 */
	List<TemplatePropertyVO> poToVOs(List<TemplateProperty> templateProperties);

}
