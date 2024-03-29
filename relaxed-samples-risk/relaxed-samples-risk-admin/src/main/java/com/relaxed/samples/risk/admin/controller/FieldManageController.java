package com.relaxed.samples.risk.admin.controller;

import com.relaxed.common.model.result.BaseResultCode;
import com.relaxed.common.model.result.R;
import com.relaxed.common.risk.model.entity.Field;
import com.relaxed.common.risk.model.entity.PreItem;
import com.relaxed.common.risk.model.enums.FieldType;
import com.relaxed.common.risk.model.enums.ValidTypeEnum;
import com.relaxed.samples.risk.admin.service.FieldManageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yakir
 * @Topic FieldManageController
 * @Description
 * @date 2021/9/26 13:36
 * @Version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("field")
@Tag(name = "字段管理")
public class FieldManageController {

	private final FieldManageService fieldManageService;

	/**
	 * 验证字段列表
	 * @author yakir
	 * @date 2021/9/28 14:50
	 * @return com.relaxed.common.model.result.R
	 */
	@GetMapping("/types/validate")
	@io.swagger.v3.oas.annotations.Operation(summary = "验证字段列表", description = "验证字段列表")
	public R validateType() {
		List<Map<String, Object>> fieldTypeList = new ArrayList<>();
		for (ValidTypeEnum value : ValidTypeEnum.values()) {
			Map<String, Object> map = new HashMap<>(16);
			map.put("name", value.name());
			map.put("desc", value.getDesc());
			fieldTypeList.add(map);
		}
		return R.ok(fieldTypeList);
	}

	/**
	 * 字段类型列表
	 * @author yakir
	 * @date 2021/9/26 13:37
	 * @return com.relaxed.common.model.result.R
	 */
	@GetMapping("/types")
	@io.swagger.v3.oas.annotations.Operation(summary = "字段类型列表", description = "字段类型列表")
	public R listFieldTypes() {
		List<Map<String, Object>> fieldTypeList = new ArrayList<>();

		for (FieldType value : FieldType.values()) {
			Map<String, Object> map = new HashMap<>(16);
			map.put("name", value.name());
			map.put("desc", value.getDesc());
			fieldTypeList.add(map);
		}
		return R.ok(fieldTypeList);
	}

	/**
	 * 根据模型id查询字段列表
	 * @author yakir
	 * @date 2021/9/28 16:23
	 * @param modelId
	 * @return com.relaxed.common.model.result.R<?>
	 */
	@GetMapping("/list/{modelId}")
	public R<?> fieldListByModelId(@PathVariable Long modelId) {
		return R.ok(fieldManageService.fieldListByModelId(modelId));
	}

	/**
	 * 新增数据
	 * @param field {@link Field} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@PostMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "原始字段新增数据", description = "原始字段新增数据")
	public R<?> fieldAdd(@RequestBody Field field) {
		return fieldManageService.fieldAdd(field) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param field {@link Field} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@PutMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "原始字段更新数据", description = "原始字段更新数据")
	public R<?> fieldEdit(@RequestBody Field field) {
		return fieldManageService.fieldEdit(field) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "更新数据失败");
	}

	/**
	 * 根据id删除数据
	 * @param id {@code id} id
	 * @return {@code R<?>} 通用返回体
	 */
	@DeleteMapping("/{id}")
	@io.swagger.v3.oas.annotations.Operation(summary = "原始字段根据id删除数据", description = "原始字段根据id删除数据")
	public R<?> fieldDel(@PathVariable Long id) {
		return fieldManageService.fieldDel(id) ? R.ok() : R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

	/**
	 * 根据模型id查询预字段列表
	 * @author yakir
	 * @date 2021/9/28 16:23
	 * @param modelId
	 * @return com.relaxed.common.model.result.R<?>
	 */
	@GetMapping("/pre/list/{modelId}")
	public R<?> preItemListByModelId(@PathVariable Long modelId) {
		return R.ok(fieldManageService.preItemListByModelId(modelId));
	}

	/**
	 * 新增数据
	 * @param preItem {@link PreItem} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@PostMapping("/pre")
	@io.swagger.v3.oas.annotations.Operation(summary = "预处理字段新增数据", description = "预处理字段新增数据")
	public R<?> preItemFieldAdd(@RequestBody PreItem preItem) {
		return fieldManageService.preItemFieldAdd(preItem) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param preItem {@link PreItem} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@PutMapping("/pre")
	@io.swagger.v3.oas.annotations.Operation(summary = "预处理字段更新数据", description = "预处理字段更新数据")
	public R<?> preItemFieldEdit(@RequestBody PreItem preItem) {
		return fieldManageService.preItemFieldEdit(preItem) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "更新数据失败");
	}

	/**
	 * 根据id删除数据
	 * @param modelId {@code modelId} modelId
	 * @param id {@code id} id
	 * @return {@code R<?>} 通用返回体
	 */
	@DeleteMapping("/pre/{modelId}/{id}")
	@io.swagger.v3.oas.annotations.Operation(summary = "预处理字段根据id删除数据", description = "预处理字段根据id删除数据")
	public R<?> preItemFieldDel(@PathVariable Long modelId, @PathVariable Long id) {
		return fieldManageService.preItemFieldDel(modelId, id) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

}
