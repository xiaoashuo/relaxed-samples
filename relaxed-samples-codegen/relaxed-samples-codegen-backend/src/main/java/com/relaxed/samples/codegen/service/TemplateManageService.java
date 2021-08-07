package com.relaxed.samples.codegen.service;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.domain.SelectData;
import com.relaxed.samples.codegen.model.dto.TemplateGroupDTO;
import com.relaxed.samples.codegen.model.dto.TemplateInfoDTO;
import com.relaxed.samples.codegen.model.dto.TemplatePropertyDTO;
import com.relaxed.samples.codegen.model.entity.TemplateFile;
import com.relaxed.samples.codegen.model.qo.TemplatePropertyQO;
import com.relaxed.samples.codegen.model.vo.TemplateGroupVO;
import com.relaxed.samples.codegen.model.vo.TemplateInfoVO;
import com.relaxed.samples.codegen.model.vo.TemplatePropertyPageVO;
import com.relaxed.samples.codegen.model.vo.TemplatePropertyVO;

import java.util.List;
import java.util.Set;

/**
 * 模板管理 业务层
 *
 * @author Yakir
 */
public interface TemplateManageService {

	/**
	 * 新增模板组
	 * @param templateGroupDTO {@code templateGroupDTO}
	 * @return {@code boolean}
	 */
	boolean saveTemplateGroup(TemplateGroupDTO templateGroupDTO);

	/**
	 * 删除模板组根据id
	 * @param templateGroupId
	 * @return
	 */
	boolean removeTemplateGroupById(Long templateGroupId);

	/**
	 * 更新模板组
	 * @param templateGroupDTO
	 * @return
	 */
	boolean updateTemplateGroupById(TemplateGroupDTO templateGroupDTO);

	/**
	 * 分页查询 模板组
	 * @param pageParam
	 * @param templateGroupDTO
	 * @return
	 */
	PageResult<TemplateGroupVO> selectTemplateGroupPage(PageParam pageParam, TemplateGroupDTO templateGroupDTO);

	/**
	 * 查询模板属性page
	 * @author yakir
	 * @date 2021/7/31 16:55
	 * @param pageParam
	 * @param templatePropertyQO
	 * @return com.relaxed.common.core.domain.PageResult<com.relaxed.samples.codegen.model.vo.TemplatePropertyPageVO>
	 */
	PageResult<TemplatePropertyPageVO> selectTemplatePropertyPage(PageParam pageParam,
			TemplatePropertyQO templatePropertyQO);

	/**
	 * 查询模板属性列表 根据模板组id
	 * @param templateGroupId
	 * @return
	 */
	List<TemplatePropertyVO> listTemplatePropertyByGid(Integer templateGroupId);

	/**
	 * 删除模板属性 根据id
	 * @param templatePropertyId
	 * @return
	 */
	boolean removeTempLatePropertyById(Long templatePropertyId);

	/**
	 * 修改模板属性
	 * @param templatePropertyDTO
	 * @return
	 */
	boolean updateTemplatePropertyById(TemplatePropertyDTO templatePropertyDTO);

	/**
	 * 新增模板属性
	 * @param templatePropertyDTO {@link TemplatePropertyDTO}
	 * @return {@code boolean}
	 */
	boolean saveTemplateProperty(TemplatePropertyDTO templatePropertyDTO);

	/**
	 * 新增模板信息
	 * @param templateInfoDTO {@link TemplateInfoDTO}
	 * @return {@code boolean}
	 */
	boolean saveTemplateInfo(TemplateInfoDTO templateInfoDTO);

	/**
	 * 删除模板信息通过id
	 * @param templateInfoId {@code templateInfoId}
	 * @return {@code boolean}
	 */
	boolean removeTempLateInfoById(Long templateInfoId);

	/**
	 * 更新模板信息 通过id
	 * @param templateInfoDTO {@link TemplateInfoDTO}
	 * @return {@code boolean}
	 */
	boolean updateTemplateInfoById(TemplateInfoDTO templateInfoDTO);

	/**
	 * 查询模板文件根据组id
	 * @param templateGroupId
	 * @param templateFileIds 包含则排除此模板 里面为info id
	 * @return
	 */
	List<TemplateFile> selectTemplateFilesByGid(Integer templateGroupId, Set<Integer> templateFileIds);

	/**
	 * 查询模板文件
	 * @param templateGroupId {@code  templateGroupId}
	 * @param templateFileIds {@code Set<Integer>} 模板文件ids
	 * @return {@link List<TemplateFile>}
	 */
	List<TemplateFile> selectTemplateFiles(Integer templateGroupId, Set<Integer> templateFileIds);

	/**
	 * 模板组列表
	 * @return {@link List<SelectData<?>>}
	 */
	List<SelectData<?>> selectAllTemplateGroup();

	/**
	 * 展示模板信息列表
	 * @param templateGroupId {@code templateGroupId}
	 * @return {@link List<TemplateInfoVO>}
	 */
	List<TemplateInfoVO> listTemplateInfosByGid(Integer templateGroupId);

}
