package com.relaxed.samples.tenant.controller;

import com.relaxed.common.core.util.ServletUtils;
import com.relaxed.samples.tenant.holder.TenantHolder;
import com.relaxed.samples.tenant.model.entity.TUser;
import com.relaxed.samples.tenant.model.qo.TUserQO;
import com.relaxed.samples.tenant.model.vo.TUserVO;

import com.relaxed.samples.tenant.service.TUserService;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.result.BaseResultCode;
import com.relaxed.common.model.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 控制器
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T16:57:52.841
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("user")
@Api(tags = "")
public class TUserController {

	private final TUserService tUserService;

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam} 分页参数
	 * @param tUserQO {@link TUserQO} 查询条件
	 * @return @{code R<PageResult<TUserVO>>} 通用返回体
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R<PageResult<TUserVO>> page(PageParam pageParam, TUserQO tUserQO) {
		PageResult<TUserVO> data = tUserService.selectByPage(pageParam, tUserQO);
		return R.ok(data);
	}

	/**
	 * 新增数据
	 * @param tUser {@link TUser} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@ApiOperation(value = "新增数据", notes = "新增数据")
	@PostMapping
	public R<?> save(@RequestBody TUser tUser) {
		return tUserService.save(tUser) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param tUser {@link TUser} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@ApiOperation(value = "更新数据", notes = "更新数据")
	@PutMapping
	public R<?> updateById(@RequestBody TUser tUser) {
		return tUserService.updateById(tUser) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "更新数据失败");
	}

	/**
	 * 根据id删除数据
	 * @param id {@code id} id
	 * @return {@code R<?>} 通用返回体
	 */
	@ApiOperation(value = "根据id删除数据", notes = "根据id删除数据")
	@DeleteMapping("/{id}")
	public R<?> removeById(@PathVariable Long id) {
		return tUserService.removeById(id) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

}
