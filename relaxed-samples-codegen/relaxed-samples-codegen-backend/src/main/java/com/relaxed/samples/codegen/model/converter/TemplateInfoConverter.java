package com.relaxed.samples.codegen.model.converter;

import com.relaxed.samples.codegen.model.dto.TemplateInfoDTO;
import com.relaxed.samples.codegen.model.entity.TemplateInfo;
import com.relaxed.samples.codegen.model.vo.TemplateInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 模板信息转换器
 *
 * @author Yakir
 */
@Mapper
public interface TemplateInfoConverter {

	TemplateInfoConverter INSTANCE = Mappers.getMapper(TemplateInfoConverter.class);

	/**
	 * po -> vo
	 * @param templateProperty {@link TemplateInfo}
	 * @return {@link TemplateInfoVO}
	 */
	TemplateInfoVO poToVo(TemplateInfo templateProperty);

	/**
	 * dto -> po
	 * @param templatePropertyDTO {@link TemplateInfoDTO}
	 * @return {@link TemplateInfo}
	 */
	TemplateInfo dtoToPo(TemplateInfoDTO templatePropertyDTO);

	/**
	 * po -> vos
	 * @param templateProperties {@link List<TemplateInfo>}
	 * @return {@link List<TemplateInfoVO>}
	 */
	List<TemplateInfoVO> poToVOs(List<TemplateInfo> templateProperties);

}
