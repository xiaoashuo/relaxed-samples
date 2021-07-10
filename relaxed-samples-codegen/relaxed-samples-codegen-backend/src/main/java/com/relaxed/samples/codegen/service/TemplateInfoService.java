package com.relaxed.samples.codegen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.relaxed.samples.codegen.model.entity.TemplateInfo;
import com.relaxed.samples.codegen.model.vo.TemplateInfoVO;

import java.util.List;

/**
 * <p>
 * 模板信息 服务类
 * </p>
 *
 * @author Yakir
 * @since 2021-03-16
 */
public interface TemplateInfoService extends IService<TemplateInfo> {

	/**
	 * 查询模板信息列表 根据组id
	 * @param templateGroupId
	 * @return
	 */
	List<TemplateInfo> selectTemplateInfoListByGid(Integer templateGroupId);

	/**
	 * 查询模板信息
	 * @param templateGroupId {@code templateGroupId}
	 * @return {@link List<TemplateInfoVO>}
	 */
	List<TemplateInfoVO> listTemplateInfosByGid(Integer templateGroupId);

}
