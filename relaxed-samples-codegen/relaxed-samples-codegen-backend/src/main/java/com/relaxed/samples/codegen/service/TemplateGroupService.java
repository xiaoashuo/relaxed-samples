package com.relaxed.samples.codegen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.domain.SelectData;
import com.relaxed.samples.codegen.model.dto.TemplateGroupDTO;
import com.relaxed.samples.codegen.model.entity.TemplateGroup;
import com.relaxed.samples.codegen.model.vo.TemplateGroupVO;

import java.util.List;

/**
 * <p>
 * 模板组 服务类
 * </p>
 *
 * @author Yakir
 * @since 2021-03-16
 */
public interface TemplateGroupService extends IService<TemplateGroup> {

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam}
	 * @param templateGroupDTO {@link TemplateGroupDTO}
	 * @return {@link PageResult<TemplateGroupVO>}
	 */
	PageResult<TemplateGroupVO> selectByPage(PageParam pageParam, TemplateGroupDTO templateGroupDTO);

	/**
	 * 查询所有模板组
	 * @return {@link List<SelectData<?>> }
	 */
	List<SelectData<?>> selectAllTemplateGroup();

}
