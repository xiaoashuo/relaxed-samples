package com.relaxed.samples.risk.admin.controller;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.result.BaseResultCode;
import com.relaxed.common.model.result.R;
import com.relaxed.common.risk.biz.service.ActivationService;
import com.relaxed.common.risk.model.entity.Activation;
import com.relaxed.common.risk.model.qo.ActivationQO;
import com.relaxed.common.risk.model.vo.ActivationVO;
import com.relaxed.samples.risk.admin.model.domain.DataColumn;
import com.relaxed.samples.risk.admin.service.ActivationManageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 控制器
 * </p>
 *
 * @author Yakir
 * @since 2021-09-22T16:03:38.120
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("activation")
@Tag(name = "决策控制器")
public class ActivationController {

	private final ActivationManageService activationManageService;

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam} 分页参数
	 * @param activationQO {@link ActivationQO} 查询条件
	 * @return @{code R<PageResult<ActivationVO>>} 通用返回体
	 */
	@GetMapping("/page")
	@io.swagger.v3.oas.annotations.Operation(summary = "分页查询", description = "分页查询")
	public R<PageResult<ActivationVO>> page(PageParam pageParam, ActivationQO activationQO) {
		return R.ok(activationManageService.selectByPage(pageParam, activationQO));
	}

	/**
	 * 新增数据
	 * @param activation {@link Activation} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@PostMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "新增数据", description = "新增数据")
	public R<?> save(@RequestBody Activation activation) {
		return activationManageService.add(activation) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param activation {@link Activation} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@PutMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "更新数据", description = "更新数据")
	public R<?> updateById(@RequestBody Activation activation) {
		return activationManageService.edit(activation) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "更新数据失败");
	}

	/**
	 * 根据id删除数据
	 * @param id {@code id} id
	 * @return {@code R<?>} 通用返回体
	 */
	@DeleteMapping("/{id}")
	@io.swagger.v3.oas.annotations.Operation(summary = "根据id删除数据", description = "根据id删除数据")
	public R<?> removeById(@PathVariable Long id) {
		return activationManageService.del(id) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

}
