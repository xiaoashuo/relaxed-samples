package com.relaxed.samples.risk.admin.controller;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.result.BaseResultCode;
import com.relaxed.common.model.result.R;
import com.relaxed.common.risk.model.entity.Rule;
import com.relaxed.common.risk.model.qo.RuleQO;
import com.relaxed.common.risk.model.vo.RuleVO;
import com.relaxed.samples.risk.admin.model.domain.DataColumn;
import com.relaxed.samples.risk.admin.service.RuleManageService;
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
 * @since 2021-09-11T11:23:02.509
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("rule")
@Tag(name = "规则控制器")
public class RuleController {

	private final RuleManageService ruleManageService;

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam} 分页参数
	 * @param ruleQO {@link RuleQO} 查询条件
	 * @return @{code R<PageResult<RuleVO>>} 通用返回体
	 */
	@GetMapping("/page")
	@io.swagger.v3.oas.annotations.Operation(summary = "分页查询", description = "分页查询")
	public R<PageResult<RuleVO>> page(PageParam pageParam, RuleQO ruleQO) {
		return R.ok(ruleManageService.selectByPage(pageParam, ruleQO));
	}

	/**
	 * 根据决策id查询所有规则
	 * @author yakir
	 * @date 2021/9/29 10:53
	 * @param activationId
	 * @return com.relaxed.common.model.result.R<java.util.List<com.relaxed.common.risk.model.vo.RuleVO>>
	 */
	@GetMapping("/list/{activationId}")
	@io.swagger.v3.oas.annotations.Operation(summary = "根据决策id查询所有规则", description = "根据决策id查询所有规则")
	public R<List<RuleVO>> listByActivationId(@PathVariable Long activationId) {
		return R.ok(ruleManageService.listByActivationId(activationId));
	}

	/**
	 * 特征提取列
	 * @param modelId {@link PageParam} 分页参数
	 */
	@GetMapping("/columns/{modelId}")
	@io.swagger.v3.oas.annotations.Operation(summary = "特征提取列", description = "特征提取列")
	public R<List<DataColumn>> dataColumns(@PathVariable Long modelId) {
		return R.ok(ruleManageService.selectColumns(modelId));
	}

	/**
	 * 新增数据
	 * @param rule {@link Rule} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@PostMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "新增数据", description = "新增数据")
	public R<?> save(@RequestBody Rule rule) {
		return ruleManageService.add(rule) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param rule {@link Rule} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@PutMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "更新数据", description = "更新数据")
	public R<?> updateById(@RequestBody Rule rule) {
		return ruleManageService.edit(rule) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "更新数据失败");
	}

	/**
	 * 根据id删除数据
	 * @param id {@code id} id
	 * @return {@code R<?>} 通用返回体
	 */
	@DeleteMapping("/{id}")
	@io.swagger.v3.oas.annotations.Operation(summary = "根据id删除数据", description = "根据id删除数据")
	public R<?> removeById(@PathVariable Long id) {
		return ruleManageService.del(id) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

}
