package com.relaxed.samples.codegen.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;

import com.relaxed.common.core.constants.GlobalConstants;
import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;
import com.relaxed.common.core.domain.SelectData;
import com.relaxed.samples.codegen.model.converter.TemplateGroupConverter;
import com.relaxed.samples.codegen.model.converter.TemplateInfoConverter;
import com.relaxed.samples.codegen.model.converter.TemplatePropertyConverter;
import com.relaxed.samples.codegen.model.dto.TemplateGroupDTO;
import com.relaxed.samples.codegen.model.dto.TemplateInfoDTO;
import com.relaxed.samples.codegen.model.dto.TemplatePropertyDTO;
import com.relaxed.samples.codegen.model.entity.*;
import com.relaxed.samples.codegen.model.enums.DirectoryTypeEnum;
import com.relaxed.samples.codegen.model.qo.TemplatePropertyQO;
import com.relaxed.samples.codegen.model.vo.TemplateGroupVO;
import com.relaxed.samples.codegen.model.vo.TemplateInfoVO;
import com.relaxed.samples.codegen.model.vo.TemplatePropertyPageVO;
import com.relaxed.samples.codegen.model.vo.TemplatePropertyVO;
import com.relaxed.samples.codegen.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 模板管理 业务层实现
 *
 * @author Yakir
 */
@RequiredArgsConstructor
@Service
public class TemplateManageServiceImpl implements TemplateManageService {

	private final TemplateGroupService templateGroupService;

	private final TemplatePropertyService templatePropertyService;

	private final TemplateInfoService templateInfoService;

	private final TemplateDirectoryService templateDirectoryService;

	@Override
	public List<SelectData<?>> selectAllTemplateGroup() {
		return templateGroupService.selectAllTemplateGroup();
	}

	@Override
	public boolean saveTemplateGroup(TemplateGroupDTO templateGroupDTO) {
		return templateGroupService.save(TemplateGroupConverter.INSTANCE.dtoToPo(templateGroupDTO));
	}

	@Override
	public boolean removeTemplateGroupById(Long templateGroupId) {
		// 效验模板组下面是否存在子项
		return templateGroupService.removeById(templateGroupId);
	}

	@Override
	public boolean updateTemplateGroupById(TemplateGroupDTO templateGroupDTO) {
		TemplateGroup templateGroup = templateGroupService.getById(templateGroupDTO.getId());
		Assert.notNull(templateGroup, "template group that does not exist");
		TemplateGroup updateTemplateGroup = TemplateGroupConverter.INSTANCE.dtoToPo(templateGroupDTO);
		return templateGroupService.updateById(updateTemplateGroup);
	}

	@Override
	public PageResult<TemplateGroupVO> selectTemplateGroupPage(PageParam pageParam, TemplateGroupDTO templateGroupDTO) {
		return templateGroupService.selectByPage(pageParam, templateGroupDTO);
	}

	@Override
	public PageResult<TemplatePropertyPageVO> selectTemplatePropertyPage(PageParam pageParam,
			TemplatePropertyQO templatePropertyQO) {
		return templatePropertyService.selectByPage(pageParam, templatePropertyQO);
	}

	@Override
	public List<TemplatePropertyVO> listTemplatePropertyByGid(Integer templateGroupId) {
		return templatePropertyService.selectListByGid(templateGroupId);
	}

	@Override
	public boolean removeTempLatePropertyById(Long templatePropertyId) {
		TemplateProperty templateProperty = templatePropertyService.getById(templatePropertyId);
		Assert.notNull(templateProperty, "template property that does not exist");
		return templatePropertyService.removeById(templatePropertyId);
	}

	@Override
	public boolean updateTemplatePropertyById(TemplatePropertyDTO templatePropertyDTO) {
		TemplateProperty templateProperty = templatePropertyService.getById(templatePropertyDTO.getId());
		Assert.notNull(templateProperty, "template property that does not exist");
		TemplateProperty updateTemplateProperty = TemplatePropertyConverter.INSTANCE.dtoToPo(templatePropertyDTO);
		return templatePropertyService.updateById(updateTemplateProperty);
	}

	@Override
	public boolean saveTemplateProperty(TemplatePropertyDTO templatePropertyDTO) {
		TemplateProperty templateProperty = TemplatePropertyConverter.INSTANCE.dtoToPo(templatePropertyDTO);
		return templatePropertyService.save(templateProperty);
	}

	@Override
	public List<TemplateInfoVO> listTemplateInfosByGid(Integer templateGroupId) {
		return templateInfoService.listTemplateInfosByGid(templateGroupId);
	}

	@Override
	public boolean saveTemplateInfo(TemplateInfoDTO templateInfoDTO) {
		TemplateInfo templateInfo = TemplateInfoConverter.INSTANCE.dtoToPo(templateInfoDTO);
		return templateInfoService.save(templateInfo);
	}

	@Override
	public boolean removeTempLateInfoById(Long templateInfoId) {
		TemplateInfo templateInfo = templateInfoService.getById(templateInfoId);
		Assert.notNull(templateInfo, "template info that does not exist");
		return templateInfoService.removeById(templateInfoId);
	}

	@Override
	public boolean updateTemplateInfoById(TemplateInfoDTO templateInfoDTO) {
		TemplateInfo templateInfo = templateInfoService.getById(templateInfoDTO.getId());
		Assert.notNull(templateInfo, "template info that does not exist");
		TemplateInfo updateTemplateInfo = TemplateInfoConverter.INSTANCE.dtoToPo(templateInfoDTO);
		return templateInfoService.updateById(updateTemplateInfo);
	}

	@Override
	public List<TemplateFile> selectTemplateFilesByGid(Integer templateGroupId, Set<Integer> templateFileIds) {
		List<TemplateInfo> templateInfos = templateInfoService.selectTemplateInfoListByGid(templateGroupId);
		List<TemplateDirectory> list = templateDirectoryService.listByTemplateGroupId(templateGroupId);
		if (CollectionUtil.isNotEmpty(templateInfos) && CollectionUtil.isNotEmpty(templateFileIds)) {
			templateInfos.removeIf(e -> !templateFileIds.contains(e.getId()));
		}
		// 目录map directoryId->TemplateDirectory
		Map<Integer, TemplateDirectory> directoryMap = list.stream()
				.collect(Collectors.toMap(TemplateDirectory::getId, e -> e, (old, news) -> news));
		List<TemplateFile> templateFiles = new ArrayList<>();
		for (TemplateInfo templateInfo : templateInfos) {
			// 当前级别模板目录
			TemplateDirectory templateDirectory = directoryMap.get(templateInfo.getDirectoryId());
			TemplateFile templateFile = new TemplateFile();
			templateFile.setEngineType(templateInfo.getEngineType());
			templateFile.setContext(templateInfo.getContent());
			templateFile.setFileName(templateDirectory.getFileName());
			// 填充模板路径
			List<String> pathList = new ArrayList<>();
			fillTemplatePathList(directoryMap, templateDirectory, pathList);
			templateFile.setFilePath(convertPathsToReverseStr(pathList));
			templateFiles.add(templateFile);
		}
		return templateFiles;
	}

	/**
	 * 获取文件路径根据文件路径列表
	 * @param pathList
	 * @return
	 */
	private String convertPathsToReverseStr(List<String> pathList) {
		if (CollectionUtil.isEmpty(pathList)) {
			return StrUtil.EMPTY;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = pathList.size() - 1; i >= 0; i--) {
			sb.append(pathList.get(i)).append(File.separator);
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}

	/**
	 * 填充模板路径列表 反序
	 * @param directoryMap
	 * @param currentTemplateDirectory
	 * @param pathList
	 */
	private void fillTemplatePathList(Map<Integer, TemplateDirectory> directoryMap,
			TemplateDirectory currentTemplateDirectory, List<String> pathList) {
		Integer parentId = currentTemplateDirectory.getParentId();
		if (DirectoryTypeEnum.FOLDER.getType().equals(currentTemplateDirectory.getType())) {
			pathList.add(currentTemplateDirectory.getFileName());
		}
		// 若父级id不为根节点则进行循环
		if (!GlobalConstants.TREE_ROOT_ID.equals(parentId)) {
			TemplateDirectory templateDirectory = directoryMap.get(parentId);
			fillTemplatePathList(directoryMap, templateDirectory, pathList);
		}
	}

	@Override
	public List<TemplateFile> selectTemplateFiles(Integer templateGroupId, Set<Integer> templateFileIds) {
		// 获取所有模板目录
		List<TemplateDirectory> list = templateDirectoryService.listByTemplateGroupId(templateGroupId);
		if (CollectionUtil.isNotEmpty(list)) {
			// list.removeIf(element->)
		}
		return null;
	}

}
