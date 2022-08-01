package com.relaxed.samples.risk.admin.controller;

import com.relaxed.common.risk.model.entity.DataListMeta;
import com.relaxed.common.risk.model.qo.DataListMetaQO;
import com.relaxed.common.risk.model.vo.DataListMetaVO;
import com.relaxed.samples.risk.admin.service.DataListManageService;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.result.BaseResultCode;
import com.relaxed.common.model.result.R;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 控制器
 * </p>
 *
 * @author Yakir
 * @since 2021-09-28T09:46:31.326
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("data/list/meta")
@Tag(name = "数据列表字段控制器")
public class DataListMetaController {

	private final DataListManageService dataListMetaService;

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam} 分页参数
	 * @param dataListMetaQO {@link DataListMetaQO} 查询条件
	 * @return @{code R<PageResult<DataListMetaVO>>} 通用返回体
	 */
	@GetMapping("/page")
	@io.swagger.v3.oas.annotations.Operation(summary = "分页查询", description = "分页查询")
	public R<PageResult<DataListMetaVO>> page(PageParam pageParam, DataListMetaQO dataListMetaQO) {
		return R.ok(dataListMetaService.selectDataListMetaByPage(pageParam, dataListMetaQO));
	}

	/**
	 * 新增数据
	 * @param dataListMeta {@link DataListMeta} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@PostMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "新增数据", description = "新增数据")
	public R<?> save(@RequestBody DataListMeta dataListMeta) {
		return dataListMetaService.addDataListMeta(dataListMeta) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param dataListMeta {@link DataListMeta} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@PutMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "更新数据", description = "更新数据")
	public R<?> updateById(@RequestBody DataListMeta dataListMeta) {
		return dataListMetaService.editDataListMeta(dataListMeta) ? R.ok()
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
		return dataListMetaService.delDataListMeta(id) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

}
