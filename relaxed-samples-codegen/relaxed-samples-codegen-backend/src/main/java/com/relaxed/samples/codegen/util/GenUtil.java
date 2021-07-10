package com.relaxed.samples.codegen.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;

import com.relaxed.samples.codegen.model.converter.column.MysqlColumnTypeConvert;
import com.relaxed.samples.codegen.model.dto.GenerateOptionDTO;
import com.relaxed.samples.codegen.model.entity.*;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成工具类
 *
 * @author Yakir
 */
public class GenUtil {

	/**
	 * 生成代码
	 * @param generateOptionDTO
	 * @param zip
	 * @param templateFiles
	 * @param tableInfo
	 * @param columnInfos
	 * @throws IOException
	 */
	public static void generateCode(GenerateOptionDTO generateOptionDTO, ZipOutputStream zip,
			List<TemplateFile> templateFiles, TableInfo tableInfo, List<ColumnInfo> columnInfos) throws IOException {
		// 生成代码
		GenerateProperties generateProperties = buildGenerateProperties(tableInfo, columnInfos,
				generateOptionDTO.getTablePrefix());
		// 将generateProperties->map
		Map<String, Object> map = BeanUtil.beanToMap(generateProperties);
		// 追加用户自定义属性
		appendCustomAttr(map, generateOptionDTO.getCustomProperties());
		// 模板渲染
		VelocityContext context = new VelocityContext(map);
		for (TemplateFile templateFile : templateFiles) {
			// 渲染模板
			StringWriter sw = new StringWriter();
			Velocity.evaluate(context, sw, tableInfo.getTableName() + templateFile.getFilePath(),
					templateFile.getContext());
			String realFilePath = getRealFilePath(templateFile.getFilePath(), templateFile.getFileName(), map);
			zip.putNextEntry(new ZipEntry(realFilePath));
			IoUtil.write(zip, StandardCharsets.UTF_8, false, sw.toString());
			IoUtil.close(sw);
			zip.closeEntry();
		}
	}

	public static Map<String, String> previewCode(TableInfo tableInfo, List<ColumnInfo> columnInfos,
			List<TemplateFile> templateFiles, String tablePrefix, Map<String, String> customProperties) {
		Map<String, String> dataMap = new HashMap<>();
		GenerateProperties generateProperties = buildGenerateProperties(tableInfo, columnInfos, tablePrefix);
		// 将generateProperties->map
		Map<String, Object> map = BeanUtil.beanToMap(generateProperties);
		// 追加用户自定义属性
		appendCustomAttr(map, customProperties);
		// 模板渲染
		VelocityContext context = new VelocityContext(map);
		for (TemplateFile templateFile : templateFiles) {
			// 渲染模板
			StringWriter sw = new StringWriter();
			Velocity.evaluate(context, sw, tableInfo.getTableName() + templateFile.getFilePath(),
					templateFile.getContext());
			dataMap.put(StrUtil.format(templateFile.getFileName(), map), sw.toString());
			IoUtil.close(sw);
		}

		return dataMap;
	}

	/**
	 * 追加用户自定义属性
	 * @param map
	 * @param customProperties
	 */
	private static void appendCustomAttr(Map<String, Object> map, Map<String, String> customProperties) {
		if (customProperties != null) {
			map.putAll(customProperties);
		}
	}

	/**
	 * 获取真实的文件全路径
	 * @param filePathMaker 文件路径模板
	 * @param map 模板属性
	 * @return filePath 文件路径
	 */
	private static String getRealFilePath(String filePathMaker, String fileNameMaker, Map<String, Object> map) {
		// 占位符替换
		String realFileName = StrUtil.format(fileNameMaker, map);
		String realFilePath = StrUtil.format(filePathMaker, map);
		// 用 . 标识文件夹合并，所以需要替换成 /
		realFilePath = realFilePath.replace(StrUtil.DOT, File.separator);
		// 防止多写了 /
		realFilePath = realFilePath.replace(File.separator + File.separator, File.separator);
		return realFilePath.endsWith(File.separator) ? realFilePath + realFileName
				: realFilePath + File.separator + realFileName;
	}

	/**
	 * 生成配置属性
	 * @param tableInfo
	 * @param columnInfos
	 * @return
	 */
	private static GenerateProperties buildGenerateProperties(TableInfo tableInfo, List<ColumnInfo> columnInfos,
			String tablePrefix) {
		// 配置属性
		GenerateProperties generateProperties = new GenerateProperties();

		// 表名称
		generateProperties.setTableName(tableInfo.getTableName());
		// 表描述
		generateProperties.setComments(tableInfo.getTableComment());
		// 大驼峰类名
		String className = getClassName(generateProperties.getTableName(), tablePrefix);
		generateProperties.setClassName(className);
		// 表别名
		generateProperties.setTableAlias(prodAlias(className));
		// 小驼峰类名
		String classname = StringUtils.uncapitalize(className);
		generateProperties.setLowerClassName(classname);
		// 列信息
		List<ColumnProperties> columnList = new ArrayList<>();
		for (ColumnInfo columnInfo : columnInfos) {
			String columnName = columnInfo.getColumnName();
			ColumnProperties columnProperties = new ColumnProperties();
			columnProperties.setColumnName(columnName);
			columnProperties.setDataType(columnInfo.getDataType());
			columnProperties.setComments(columnInfo.getColumnComment());
			columnProperties.setExtra(columnInfo.getExtra());
			columnProperties.setColumnType(columnInfo.getColumnType());
			// 列名称转换成JAVA属性名
			String capitalizedAttrName = columnToJava(columnName);
			columnProperties.setCapitalizedAttrName(capitalizedAttrName);
			columnProperties.setAttrName(StringUtils.uncapitalize(capitalizedAttrName));
			// 列的数据类型,转换为JAVA类型
			columnProperties.setAttrType(MysqlColumnTypeConvert.convertType(columnInfo.getDataType()));
			// 是否主键
			if ("PRI".equalsIgnoreCase(columnInfo.getColumnKey()) && generateProperties.getPk() == null) {
				generateProperties.setPk(columnProperties);
			}
			columnList.add(columnProperties);

		}
		generateProperties.setColumns(columnList);
		// 没主键 则第一个设置为主键
		if (generateProperties.getPk() == null) {
			generateProperties.setPk(columnList.get(0));
		}
		generateProperties.setCurrentTime(LocalDateTime.now().toString());

		return generateProperties;
	}

	/**
	 * 根据类名生成表别名
	 * @param className 类名
	 * @return 表别名
	 */
	private static String prodAlias(String className) {
		StringBuilder sb = new StringBuilder();
		for (char c : className.toCharArray()) {
			if (c >= 'A' && c <= 'Z') {
				sb.append(Character.toLowerCase(c));
			}
		}
		return sb.toString();
	}

	/**
	 * 列名转换成Java属性名
	 */
	public static String columnToJava(String columnName) {
		return WordUtils.capitalizeFully(columnName, new char[] { '_' }).replace("_", "");
	}

	/**
	 * 表名转换成Java类名
	 */
	private static String getClassName(String tableName, String tablePrefix) {
		if (StrUtil.isNotBlank(tablePrefix) && tableName.startsWith(tablePrefix)) {
			tableName = tableName.substring(tablePrefix.length());
		}
		return columnToJava(tableName);
	}

}
