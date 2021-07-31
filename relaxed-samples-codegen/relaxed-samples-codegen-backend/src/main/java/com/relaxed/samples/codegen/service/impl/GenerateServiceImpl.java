package com.relaxed.samples.codegen.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.relaxed.common.core.exception.BusinessException;
import com.relaxed.samples.codegen.model.dto.DdlGenerateOptionDTO;
import com.relaxed.samples.codegen.model.dto.GenerateOptionDTO;
import com.relaxed.samples.codegen.model.dto.PreGenerateOptionDTO;
import com.relaxed.samples.codegen.model.dto.TableInfoDTO;
import com.relaxed.samples.codegen.model.entity.ColumnInfo;
import com.relaxed.samples.codegen.model.entity.TableInfo;
import com.relaxed.samples.codegen.model.entity.TemplateFile;
import com.relaxed.samples.codegen.parse.GenParse;
import com.relaxed.samples.codegen.service.GenerateService;
import com.relaxed.samples.codegen.service.TableInfoService;
import com.relaxed.samples.codegen.service.TemplateManageService;
import com.relaxed.samples.codegen.util.GenUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 业务生成 业务层
 *
 * @author Yakir
 */
@RequiredArgsConstructor
@Service
public class GenerateServiceImpl implements GenerateService {

	private final TableInfoService tableInfoService;

	private final TemplateManageService templateManageService;

	@Override
	public byte[] generateCode(GenerateOptionDTO generateOptionDTO) throws IOException {
		// 字节数组流不需要关闭
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try (ZipOutputStream zip = new ZipOutputStream(outputStream)) {
			List<TemplateFile> templateFiles = templateManageService.selectTemplateFilesByGid(
					generateOptionDTO.getTemplateGroupId(), generateOptionDTO.getTemplateFileIds());
			Assert.notEmpty(templateFiles, " template file that does not exist ");
			for (String tableName : generateOptionDTO.getTableNames()) {
				// 查询表信息
				TableInfo tableInfo = tableInfoService.selectTableInfo(tableName);
				// 查询列信息
				List<ColumnInfo> columnInfos = tableInfoService.listColumnInfo(tableName);
				GenUtil.generateCode(generateOptionDTO, zip, templateFiles, tableInfo, columnInfos);
			}
		}
		return outputStream.toByteArray();

	}

	@Override
	public byte[] generateCodeByDdl(DdlGenerateOptionDTO generateOptionDTO) throws IOException {
		// 字节数组流不需要关闭
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try (ZipOutputStream zip = new ZipOutputStream(outputStream)) {
			List<TemplateFile> templateFiles = templateManageService.selectTemplateFilesByGid(
					generateOptionDTO.getTemplateGroupId(), generateOptionDTO.getTemplateFileIds());
			Assert.notEmpty(templateFiles, " template file that does not exist ");
			GenParse genParse = new GenParse();
			for (String statement : generateOptionDTO.getDcStatements()) {
				TableInfoDTO tableInfoDTO = genParse.parseDdl(statement);
				if (tableInfoDTO == null) {
					continue;
				}
				GenUtil.generateCodeByDdl(generateOptionDTO, zip, templateFiles, tableInfoDTO.getTableInfo(),
						tableInfoDTO.getColumnInfos());
			}
		}
		return outputStream.toByteArray();
	}

	@Override
	public Map<String, String> previewCodeByDdl(DdlGenerateOptionDTO generateOptionDTO) throws IOException {
		List<TemplateFile> templateFiles = templateManageService.selectTemplateFilesByGid(
				generateOptionDTO.getTemplateGroupId(), generateOptionDTO.getTemplateFileIds());
		Assert.notEmpty(templateFiles, " template file that does not exist ");
		GenParse genParse = new GenParse();
		String[] dcStatements = generateOptionDTO.getDcStatements();
		Assert.isTrue(!ArrayUtil.isEmpty(dcStatements), "ddl can not be empty.");
		TableInfoDTO tableInfoDTO = genParse.parseDdl(dcStatements[0]);
		return GenUtil.previewCodeByDdl(generateOptionDTO, templateFiles, tableInfoDTO.getTableInfo(),
				tableInfoDTO.getColumnInfos());
	}

	@Override
	public Map<String, String> previewCode(PreGenerateOptionDTO preGenerateOptionDTO) {
		List<TemplateFile> templateFiles = templateManageService.selectTemplateFilesByGid(
				preGenerateOptionDTO.getTemplateGroupId(), preGenerateOptionDTO.getTemplateFileIds());
		Assert.notEmpty(templateFiles, " template file that does not exist ");
		String tableName = preGenerateOptionDTO.getTableName();
		// 查询表信息
		TableInfo tableInfo = tableInfoService.selectTableInfo(tableName);
		// 查询列信息
		List<ColumnInfo> columnInfos = tableInfoService.listColumnInfo(tableName);
		return GenUtil.previewCode(tableInfo, columnInfos, templateFiles, preGenerateOptionDTO.getTablePrefix(),
				preGenerateOptionDTO.getCustomProperties());
	}

}
