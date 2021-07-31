package com.relaxed.samples.codegen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;
import com.relaxed.samples.codegen.model.entity.TemplateProperty;
import com.relaxed.samples.codegen.model.qo.TemplatePropertyQO;
import com.relaxed.samples.codegen.model.vo.TemplatePropertyPageVO;
import com.relaxed.samples.codegen.model.vo.TemplatePropertyVO;

import java.util.List;

/**
 * <p>
 * 模板属性配置 服务类
 * </p>
 *
 * @author Yakir
 * @since 2021-03-16
 */
public interface TemplatePropertyService extends IService<TemplateProperty> {

	/**
	 * 新增
	 * @param genTemplateProperty {@link TemplateProperty}
	 * @return {@code boolean}
	 */
	boolean create(TemplateProperty genTemplateProperty);

	/**
	 * 删除
	 * @param id {@code Long}
	 * @return {@code boolean}
	 */
	boolean remove(Long id);

	/**
	 * 编辑
	 * @param genTemplateProperty {@link TemplateProperty}
	 * @return {@code boolean}
	 */
	boolean update(TemplateProperty genTemplateProperty);

	/**
	 * 获取
	 * @param id {@code Long}
	 * @return {@link TemplateProperty}
	 */
	TemplateProperty get(Long id);

	/**
	 * 分页
	 * @param current {@code int} 页码
	 * @param size {@code int} 笔数
	 * @param genTemplateProperty {@link TemplateProperty}
	 * @return {@code IPage<TemplateProperty>}
	 */
	IPage<TemplateProperty> page(int current, int size, TemplateProperty genTemplateProperty);

	/**
	 * 查询模板属性列表
	 * @return
	 */
	List<TemplatePropertyVO> selectListByGid(Integer templateGroupId);

	PageResult<TemplatePropertyPageVO> selectByPage(PageParam pageParam, TemplatePropertyQO templatePropertyQO);

}
