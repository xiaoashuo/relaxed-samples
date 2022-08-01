package com.relaxed.samples.risk.admin.controller;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.result.BaseResultCode;
import com.relaxed.common.model.result.R;
import com.relaxed.common.risk.biz.service.DataListRecordsService;
import com.relaxed.common.risk.model.entity.DataListRecords;
import com.relaxed.common.risk.model.qo.DataListRecordsQO;
import com.relaxed.common.risk.model.vo.DataListRecordsVO;
import com.relaxed.samples.risk.admin.service.DataListManageService;
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
 * @since 2021-09-11T11:23:02.762
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("data/list/records")
@Tag(name = "数据列表记录控制器")
public class DataListRecordsController {

	private final DataListManageService dataListRecordsService;

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam} 分页参数
	 * @param dataListRecordsQO {@link DataListRecordsQO} 查询条件
	 * @return @{code R<PageResult<DataListRecordsVO>>} 通用返回体
	 */
	@GetMapping("/page")
	@io.swagger.v3.oas.annotations.Operation(summary = "分页查询", description = "分页查询")
	public R<PageResult<DataListRecordsVO>> page(PageParam pageParam, DataListRecordsQO dataListRecordsQO) {
		return R.ok(dataListRecordsService.selectDataListRecordByPage(pageParam, dataListRecordsQO));
	}

	/**
	 * 新增数据
	 * @param dataListRecords {@link DataListRecords} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@PostMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "新增数据", description = "新增数据")
	public R<?> save(@RequestBody DataListRecords dataListRecords) {
		return dataListRecordsService.addDataListRecord(dataListRecords) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param dataListRecords {@link DataListRecords} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@PutMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "更新数据", description = "更新数据")
	public R<?> updateById(@RequestBody DataListRecords dataListRecords) {
		return dataListRecordsService.editDataListRecord(dataListRecords) ? R.ok()
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
		return dataListRecordsService.delDataListRecord(id) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

}
