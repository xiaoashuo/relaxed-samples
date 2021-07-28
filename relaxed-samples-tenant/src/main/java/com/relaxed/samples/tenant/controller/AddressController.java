package com.relaxed.samples.tenant.controller;

import com.relaxed.samples.tenant.model.entity.Address;
import com.relaxed.samples.tenant.model.qo.AddressQO;
import com.relaxed.samples.tenant.model.vo.AddressVO;

import com.relaxed.samples.tenant.service.AddressService;

import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;
import com.relaxed.common.core.result.BaseResultCode;
import com.relaxed.common.core.result.R;
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
 * @since 2021-07-28T16:57:52.865
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/address")
@Api(tags = "地址服务")
public class AddressController {

	private final AddressService addressService;

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam} 分页参数
	 * @param addressQO {@link AddressQO} 查询条件
	 * @return @{code R<PageResult<AddressVO>>} 通用返回体
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R<PageResult<AddressVO>> page(PageParam pageParam, AddressQO addressQO) {
		return R.ok(addressService.selectByPage(pageParam, addressQO));
	}

	/**
	 * 新增数据
	 * @param address {@link Address} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@ApiOperation(value = "新增数据", notes = "新增数据")
	@PostMapping
	public R<?> save(@RequestBody Address address) {
		return addressService.save(address) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param address {@link Address} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@ApiOperation(value = "更新数据", notes = "更新数据")
	@PutMapping
	public R<?> updateById(@RequestBody Address address) {
		return addressService.updateById(address) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "更新数据失败");
	}

	/**
	 * 根据id删除数据
	 * @param id {@code id} id
	 * @return {@code R<?>} 通用返回体
	 */
	@ApiOperation(value = "根据id删除数据", notes = "根据id删除数据")
	@DeleteMapping("/{id}")
	public R<?> removeById(@PathVariable Long id) {
		return addressService.removeById(id) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

}
