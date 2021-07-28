package com.relaxed.samples.tenant.controller;

import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;
import com.relaxed.common.core.result.BaseResultCode;
import com.relaxed.common.core.result.R;
import com.relaxed.samples.tenant.model.entity.TenantDataSourceConfig;
import com.relaxed.samples.tenant.model.qo.TenantDataSourceConfigQO;
import com.relaxed.samples.tenant.model.vo.TenantDataSourceConfigVO;
import com.relaxed.samples.tenant.service.TenantDataSourceConfigService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 数据源 控制器
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T15:36:12.631
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("tenant/data/")
public class TenantDataSourceConfigController {

	private final TenantDataSourceConfigService tenantDataSourceConfigService;

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam} 分页参数
	 * @param tenantDataSourceConfigQO {@link TenantDataSourceConfigQO} 查询条件
	 * @return @{code R<PageResult<TenantDataSourceConfigVO>>} 通用返回体
	 */
	@GetMapping("/page")
	public R<PageResult<TenantDataSourceConfigVO>> page(PageParam pageParam,
			TenantDataSourceConfigQO tenantDataSourceConfigQO) {
		return R.ok(tenantDataSourceConfigService.selectByPage(pageParam, tenantDataSourceConfigQO));
	}

	/**
	 * 新增数据
	 * @param tenantDataSourceConfig {@link TenantDataSourceConfig} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@PostMapping
	public R<?> save(@RequestBody TenantDataSourceConfig tenantDataSourceConfig) {
		return tenantDataSourceConfigService.save(tenantDataSourceConfig) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param tenantDataSourceConfig {@link TenantDataSourceConfig} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@PutMapping
	public R<?> updateById(@RequestBody TenantDataSourceConfig tenantDataSourceConfig) {
		return tenantDataSourceConfigService.updateById(tenantDataSourceConfig) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "更新数据失败");
	}

	/**
	 * 根据id删除数据
	 * @param id {@code id} id
	 * @return {@code R<?>} 通用返回体
	 */
	@DeleteMapping("/{id}")
	public R<?> removeById(@PathVariable Integer id) {
		return tenantDataSourceConfigService.removeById(id) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

}
