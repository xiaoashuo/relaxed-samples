package com.relaxed.samples.codegen.controller;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.domain.SelectData;
import com.relaxed.common.model.result.BaseResultCode;
import com.relaxed.common.model.result.R;
import com.relaxed.samples.codegen.model.dto.DataSourceConfigDTO;
import com.relaxed.samples.codegen.model.qo.DataSourceConfigQO;
import com.relaxed.samples.codegen.model.vo.DataSourceConfigVO;
import com.relaxed.samples.codegen.service.DataSourceConfigService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
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
@Tag(name = "数据源管理")
public class DataSourceConfigController {

	private final DataSourceConfigService dataSourceConfigService;

	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param dataSourceConfigQO 数据源查询对象
	 * @return R 通用返回体
	 */
	@GetMapping("/page")
	@io.swagger.v3.oas.annotations.Operation(summary = "分页查询", description = "分页查询")
	public R<PageResult<DataSourceConfigVO>> getDataSourceConfigPage(PageParam page,
			DataSourceConfigQO dataSourceConfigQO) {
		return R.ok(dataSourceConfigService.selectPageVo(page, dataSourceConfigQO));
	}

	@GetMapping("/select/data")
	@io.swagger.v3.oas.annotations.Operation(summary = "获取数据源下拉数据", description = "获取数据源下拉数据")
	public R<List<SelectData<?>>> listSelectData() {
		return R.ok(dataSourceConfigService.listSelectData());
	}

	/**
	 * 新增数据源
	 * @param dataSourceConfigDTO 数据源
	 * @return R 通用返回体
	 */
	@PostMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "新增数据源", description = "新增数据源")
	public R<?> save(@RequestBody DataSourceConfigDTO dataSourceConfigDTO) {
		return dataSourceConfigService.saveDataSourceConfig(dataSourceConfigDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据源失败");
	}

	/**
	 * 修改数据源
	 * @param dataSourceConfigDTO 数据源
	 * @return R 通用返回体
	 */
	@PutMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "修改数据源", description = "修改数据源")
	public R<?> updateById(@RequestBody DataSourceConfigDTO dataSourceConfigDTO) {
		return dataSourceConfigService.update(dataSourceConfigDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "修改数据源失败");
	}

	/**
	 * 通过id删除数据源
	 * @param id id
	 * @return R 通用返回体
	 */
	@DeleteMapping("/{id}")
	@io.swagger.v3.oas.annotations.Operation(summary = "通过id删除数据源", description = "通过id删除数据源")
	public R<?> removeById(@PathVariable Integer id) {
		return dataSourceConfigService.removeDataSourceConfigById(id) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "通过id删除数据源失败");
	}

}
