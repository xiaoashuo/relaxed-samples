package com.relaxed.samples.risk.admin.service;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.risk.model.entity.Plugin;
import com.relaxed.common.risk.model.qo.PluginQO;
import com.relaxed.common.risk.model.vo.PluginVO;

import java.util.List;

/**
 * @author Yakir
 * @Topic PluginManageService
 * @Description
 * @date 2021/9/28 13:54
 * @Version 1.0
 */
public interface PluginManageService {

	/**
	 * 获取所有启用的插件
	 * @author yakir
	 * @date 2021/9/28 13:55
	 * @return java.util.List<com.relaxed.common.risk.model.vo.PluginVO>
	 */
	List<PluginVO> listEnabledPlugins();

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam}
	 * @param pluginQO {@link PluginQO}
	 * @return {@link PageResult<PluginVO>}
	 */
	PageResult<PluginVO> selectByPage(PageParam pageParam, PluginQO pluginQO);

	/**
	 * 添加插件
	 * @author yakir
	 * @date 2021/9/28 13:59
	 * @param plugin
	 * @return boolean
	 */
	boolean add(Plugin plugin);

	/**
	 * 编辑插件
	 * @author yakir
	 * @date 2021/9/28 13:59
	 * @param plugin
	 * @return boolean
	 */
	boolean edit(Plugin plugin);

	/**
	 * 删除插件
	 * @author yakir
	 * @date 2021/9/28 13:59
	 * @param id
	 * @return boolean
	 */
	boolean del(Long id);

}
