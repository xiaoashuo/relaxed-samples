package com.relaxed.samples.tenant.controller;

import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;
import com.relaxed.common.core.result.BaseResultCode;
import com.relaxed.common.core.result.R;

import com.relaxed.samples.tenant.model.entity.TenantConfig;
import com.relaxed.samples.tenant.model.qo.TenantConfigQO;
import com.relaxed.samples.tenant.model.vo.TenantConfigVO;
import com.relaxed.samples.tenant.service.TenantConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 租户配置 控制器
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T15:36:12.618
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/tenant/config")
public class TenantConfigController {

	private final TenantConfigService tenantConfigService;

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam} 分页参数
	 * @param tenantConfigQO {@link TenantConfigQO} 查询条件
	 * @return @{code R<PageResult<TenantConfigVO>>} 通用返回体
	 */
	@GetMapping("/page")
	public R<PageResult<TenantConfigVO>> page(PageParam pageParam, TenantConfigQO tenantConfigQO) {
		return R.ok(tenantConfigService.selectByPage(pageParam, tenantConfigQO));
	}

	/**
	 * 新增数据
	 * @param tenantConfig {@link TenantConfig} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@PostMapping
	public R<?> save(@RequestBody TenantConfig tenantConfig) {
		return tenantConfigService.save(tenantConfig) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param tenantConfig {@link TenantConfig} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@PutMapping
	public R<?> updateById(@RequestBody TenantConfig tenantConfig) {
		return tenantConfigService.updateById(tenantConfig) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "更新数据失败");
	}

	/**
	 * 根据id删除数据
	 * @param id {@code id} id
	 * @return {@code R<?>} 通用返回体
	 */
	@DeleteMapping("/{id}")
	public R<?> removeById(@PathVariable Integer id) {
		return tenantConfigService.removeById(id) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

}
