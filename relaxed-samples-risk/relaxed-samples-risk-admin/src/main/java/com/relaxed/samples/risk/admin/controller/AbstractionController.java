package com.relaxed.samples.risk.admin.controller;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.result.BaseResultCode;
import com.relaxed.common.model.result.R;
import com.relaxed.common.risk.model.entity.Abstraction;
import com.relaxed.common.risk.model.qo.AbstractionQO;
import com.relaxed.common.risk.model.vo.AbstractionVO;
import com.relaxed.samples.risk.admin.model.domain.DataColumn;
import com.relaxed.samples.risk.admin.service.AbstractionManageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 控制器
 * </p>
 *
 * @author Yakir
 * @since 2021-09-22T15:24:50.128
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("abstraction")
@Tag(name = "特征提取")
public class AbstractionController {

	private final AbstractionManageService abstractionManageService;

	/**
	 * 特征列提取
	 * @param modelId {@link PageParam} 分页参数
	 */
	@GetMapping("/columns/{modelId}")
	@io.swagger.v3.oas.annotations.Operation(summary = "特征提取列", description = "特征提取列")
	public R<List<DataColumn>> dataColumns(@PathVariable Long modelId) {
		return R.ok(abstractionManageService.selectColumns(modelId));
	}

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam} 分页参数
	 * @param abstractionQO {@link AbstractionQO} 查询条件
	 * @return @{code R<PageResult<AbstractionVO>>} 通用返回体
	 */
	@GetMapping("/page")
	@io.swagger.v3.oas.annotations.Operation(summary = "分页查询", description = "分页查询")
	public R<PageResult<AbstractionVO>> page(PageParam pageParam, AbstractionQO abstractionQO) {
		return R.ok(abstractionManageService.selectByPage(pageParam, abstractionQO));
	}

	/**
	 * 新增数据
	 * @param abstraction {@link Abstraction} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@PostMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "新增数据", description = "新增数据")
	public R<?> save(@RequestBody Abstraction abstraction) {
		return abstractionManageService.add(abstraction) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param abstraction {@link Abstraction} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@PutMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "更新数据", description = "更新数据")
	public R<?> updateById(@RequestBody Abstraction abstraction) {
		return abstractionManageService.edit(abstraction) ? R.ok()
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
		return abstractionManageService.del(id) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

}
