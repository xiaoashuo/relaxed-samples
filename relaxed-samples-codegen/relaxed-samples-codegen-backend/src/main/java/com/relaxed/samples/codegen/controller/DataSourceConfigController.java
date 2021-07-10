package com.relaxed.samples.codegen.controller;

import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;
import com.relaxed.common.core.domain.SelectData;
import com.relaxed.common.core.result.BaseResultCode;
import com.relaxed.common.core.result.R;
import com.relaxed.samples.codegen.model.dto.DataSourceConfigDTO;
import com.relaxed.samples.codegen.model.qo.DataSourceConfigQO;
import com.relaxed.samples.codegen.model.vo.DataSourceConfigVO;
import com.relaxed.samples.codegen.service.DataSourceConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据源配置控制层
 *
 * @author Yakir
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/tool/database")
@Api(tags = "数据源管理")
public class DataSourceConfigController {

	private final DataSourceConfigService dataSourceConfigService;

	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param dataSourceConfigQO 数据源查询对象
	 * @return R 通用返回体
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R<PageResult<DataSourceConfigVO>> getDataSourceConfigPage(PageParam page,
			DataSourceConfigQO dataSourceConfigQO) {
		return R.ok(dataSourceConfigService.selectPageVo(page, dataSourceConfigQO));
	}

	@ApiOperation(value = "获取数据源下拉数据", notes = "获取数据源下拉数据")
	@GetMapping("/select/data")
	public R<List<SelectData<?>>> listSelectData() {
		return R.ok(dataSourceConfigService.listSelectData());
	}

	/**
	 * 新增数据源
	 * @param dataSourceConfigDTO 数据源
	 * @return R 通用返回体
	 */
	@ApiOperation(value = "新增数据源", notes = "新增数据源")
	@PostMapping
	public R<?> save(@RequestBody DataSourceConfigDTO dataSourceConfigDTO) {
		return dataSourceConfigService.saveDataSourceConfig(dataSourceConfigDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据源失败");
	}

	/**
	 * 修改数据源
	 * @param dataSourceConfigDTO 数据源
	 * @return R 通用返回体
	 */
	@ApiOperation(value = "修改数据源", notes = "修改数据源")
	@PutMapping
	public R<?> updateById(@RequestBody DataSourceConfigDTO dataSourceConfigDTO) {
		return dataSourceConfigService.update(dataSourceConfigDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "修改数据源失败");
	}

	/**
	 * 通过id删除数据源
	 * @param id id
	 * @return R 通用返回体
	 */
	@ApiOperation(value = "通过id删除数据源", notes = "通过id删除数据源")
	@DeleteMapping("/{id}")
	public R<?> removeById(@PathVariable Integer id) {
		return dataSourceConfigService.removeDataSourceConfigById(id) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "通过id删除数据源失败");
	}

}
