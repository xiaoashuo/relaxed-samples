package com.relaxed.samples.codegen.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.samples.codegen.model.entity.TemplateDirectory;
import com.relaxed.samples.codegen.model.qo.TemplateDirectoryQO;
import com.relaxed.samples.codegen.model.vo.TemplateDirectoryVO;

import java.util.List;

/**
 * <p>
 * 模板文件目录项 业务层
 * </p>
 *
 * @author yakir
 * @since 2021-03-17T19:37:07.933
 */
public interface TemplateDirectoryService extends IService<TemplateDirectory> {

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam}
	 * @param templateDirectoryQO {@link TemplateDirectoryQO}
	 * @return {@link PageResult<TemplateDirectoryVO>}
	 */
	PageResult<TemplateDirectoryVO> selectByPage(PageParam pageParam, TemplateDirectoryQO templateDirectoryQO);

	/**
	 * 查询模板目录列表根据模板组id
	 * @param templateGroupId {@code templateGroupId}
	 * @return {@link List<TemplateDirectory>}
	 */
	List<TemplateDirectory> listByTemplateGroupId(Integer templateGroupId);

}