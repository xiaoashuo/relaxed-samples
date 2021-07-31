package com.relaxed.samples.codegen.service;

import com.relaxed.samples.codegen.model.dto.DdlGenerateOptionDTO;
import com.relaxed.samples.codegen.model.dto.GenerateOptionDTO;
import com.relaxed.samples.codegen.model.dto.PreGenerateOptionDTO;

import java.io.IOException;
import java.util.Map;

/**
 * 生成业务层
 *
 * @author Yakir
 */
public interface GenerateService {

	/**
	 * 生成代码
	 * @param generateOptionDTO {@code generateOptionDTO}
	 * @return {@code byte[]}
	 */
	byte[] generateCode(GenerateOptionDTO generateOptionDTO) throws IOException;

	/**
	 * 生成代码
	 * @param generateOptionDTO {@code generateOptionDTO}
	 * @return {@code byte[]}
	 */
	byte[] generateCodeByDdl(DdlGenerateOptionDTO generateOptionDTO) throws IOException;

	/**
	 * 预览代码ddl
	 * @author yakir
	 * @date 2021/7/31 15:40
	 * @param generateOptionDTO
	 * @return java.util.Map<java.lang.String,java.lang.String>
	 * @throws IOException
	 */
	Map<String, String> previewCodeByDdl(DdlGenerateOptionDTO generateOptionDTO) throws IOException;

	/**
	 * 生成预览代码
	 * @param preGenerateOptionDTO {@code preGenerateOptionDTO}
	 * @return {@code Map<String,String>}
	 */
	Map<String, String> previewCode(PreGenerateOptionDTO preGenerateOptionDTO);

}
