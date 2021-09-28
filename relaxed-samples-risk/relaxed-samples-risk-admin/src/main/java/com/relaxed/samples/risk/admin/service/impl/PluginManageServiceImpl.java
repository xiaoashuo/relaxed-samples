package com.relaxed.samples.risk.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.risk.biz.service.PluginService;
import com.relaxed.common.risk.model.converter.PluginConverter;
import com.relaxed.common.risk.model.entity.Plugin;
import com.relaxed.common.risk.model.enums.PluginEnum;
import com.relaxed.common.risk.model.qo.PluginQO;
import com.relaxed.common.risk.model.vo.PluginVO;
import com.relaxed.samples.risk.admin.service.PluginManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yakir
 * @Topic PluginManageServiceImpl
 * @Description
 * @date 2021/9/28 13:54
 * @Version 1.0
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class PluginManageServiceImpl implements PluginManageService {

	private final PluginService pluginService;

	@Override
	public List<PluginVO> listEnabledPlugins() {
		List<Plugin> list = pluginService.list(
				Wrappers.lambdaQuery(Plugin.class).eq(Plugin::getStatus, PluginEnum.StatusEnum.ENABLE.getStatus()));
		return PluginConverter.INSTANCE.poToVOs(list);
	}

	@Override
	public PageResult<PluginVO> selectByPage(PageParam pageParam, PluginQO pluginQO) {
		return pluginService.selectByPage(pageParam, pluginQO);
	}

	@Override
	public boolean add(Plugin plugin) {
		return pluginService.save(plugin);
	}

	@Override
	public boolean edit(Plugin plugin) {
		return pluginService.updateById(plugin);
	}

	@Override
	public boolean del(Long id) {
		return pluginService.removeById(id);
	}

}
