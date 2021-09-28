package com.relaxed.samples.risk.admin.controller;

import com.relaxed.common.risk.model.entity.Plugin;
import com.relaxed.common.risk.model.qo.PluginQO;
import com.relaxed.common.risk.model.vo.PluginVO;

import com.relaxed.common.risk.biz.service.PluginService;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.result.BaseResultCode;
import com.relaxed.common.model.result.R;
import com.relaxed.samples.risk.admin.service.PluginManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 控制器
 * </p>
 *
 * @author Yakir
 * @since 2021-09-28T13:43:11.834
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("plugin")
@Api(tags = "插件管理")
public class PluginController {

	private final PluginManageService pluginService;

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam} 分页参数
	 * @param pluginQO {@link PluginQO} 查询条件
	 * @return @{code R<PageResult<PluginVO>>} 通用返回体
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R<PageResult<PluginVO>> page(PageParam pageParam, PluginQO pluginQO) {
		return R.ok(pluginService.selectByPage(pageParam, pluginQO));
	}

	/**
	 * 获取所有的启用插件
	 * @author yakir
	 * @date 2021/9/28 13:53
	 * @return com.relaxed.common.model.result.R<java.util.List<com.relaxed.common.risk.model.vo.PluginVO>>
	 */
	@ApiOperation(value = "获取所有启用插件", notes = "获取所有启用插件")
	@GetMapping("/list/enabled")
	public R<List<PluginVO>> listEnabledPlugins() {
		return R.ok(pluginService.listEnabledPlugins());
	}

	/**
	 * 新增数据
	 * @param plugin {@link Plugin} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@ApiOperation(value = "新增数据", notes = "新增数据")
	@PostMapping
	public R<?> save(@RequestBody Plugin plugin) {
		return pluginService.add(plugin) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param plugin {@link Plugin} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@ApiOperation(value = "更新数据", notes = "更新数据")
	@PutMapping
	public R<?> updateById(@RequestBody Plugin plugin) {
		return pluginService.edit(plugin) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "更新数据失败");
	}

	/**
	 * 根据id删除数据
	 * @param id {@code id} id
	 * @return {@code R<?>} 通用返回体
	 */
	@ApiOperation(value = "根据id删除数据", notes = "根据id删除数据")
	@DeleteMapping("/{id}")
	public R<?> removeById(@PathVariable Long id) {
		return pluginService.del(id) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

}
