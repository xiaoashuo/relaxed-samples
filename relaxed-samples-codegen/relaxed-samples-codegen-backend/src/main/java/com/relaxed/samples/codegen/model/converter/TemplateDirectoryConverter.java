package com.relaxed.samples.codegen.model.converter;

import com.relaxed.samples.codegen.model.dto.TemplateDirectoryDTO;
import com.relaxed.samples.codegen.model.entity.TemplateDirectory;
import com.relaxed.samples.codegen.model.vo.TemplateDirectoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 模板文件目录项 转换器
 * </p>
 *
 * @author yakir
 * @since 2021-03-17T19:37:07.933
 */
@Mapper
public interface TemplateDirectoryConverter {

	TemplateDirectoryConverter INSTANCE = Mappers.getMapper(TemplateDirectoryConverter.class);

	/**
	 * po -> vo
	 * @param templateDirectory {@link TemplateDirectory}
	 * @return {@link TemplateDirectoryVO}
	 */
	TemplateDirectoryVO poToVo(TemplateDirectory templateDirectory);

	/**
	 * dto -> po
	 * @param templateDirectoryDTO {@link TemplateDirectoryDTO}
	 * @return {@link TemplateDirectory}
	 */
	TemplateDirectory dtoToPo(TemplateDirectoryDTO templateDirectoryDTO);

	/**
	 * po -> vos
	 * @param templateDirectoryProperties {@link List<TemplateDirectory>}
	 * @return {@link List<TemplateDirectoryVO>}
	 */
	List<TemplateDirectoryVO> poToVOs(List<TemplateDirectory> templateDirectoryProperties);

}
