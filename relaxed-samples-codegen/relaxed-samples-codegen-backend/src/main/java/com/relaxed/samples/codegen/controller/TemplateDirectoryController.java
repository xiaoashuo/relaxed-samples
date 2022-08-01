package com.relaxed.samples.codegen.controller;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.result.BaseResultCode;
import com.relaxed.common.model.result.R;
import com.relaxed.samples.codegen.model.entity.TemplateDirectory;
import com.relaxed.samples.codegen.model.qo.TemplateDirectoryQO;
import com.relaxed.samples.codegen.model.vo.TemplateDirectoryVO;
import com.relaxed.samples.codegen.service.TemplateDirectoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 模板文件目录项 控制器
 * </p>
 *
 * @author yakir
 * @since 2021-03-17T19:37:07.933
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/template/dir")
@Tag(name = "模板文件目录项")
public class TemplateDirectoryController {

	private final TemplateDirectoryService templateDirectoryService;

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam} 分页参数
	 * @param templateDirectoryQO {@link TemplateDirectoryQO} 查询条件
	 * @return @{code R<PageResult<TemplateDirectoryVO>>} 通用返回体
	 */
	@GetMapping("/page")
	@io.swagger.v3.oas.annotations.Operation(summary = "分页查询", description = "分页查询")
	public R<PageResult<TemplateDirectoryVO>> page(PageParam pageParam, TemplateDirectoryQO templateDirectoryQO) {
		return R.ok(templateDirectoryService.selectByPage(pageParam, templateDirectoryQO));
	}

	/**
	 * 新增数据
	 * @param templateDirectory {@link TemplateDirectory} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@PostMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "新增数据", description = "新增数据")
	public R<?> save(@RequestBody TemplateDirectory templateDirectory) {
		return templateDirectoryService.save(templateDirectory) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param templateDirectory {@link TemplateDirectory} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@PutMapping
	@io.swagger.v3.oas.annotations.Operation(summary = "更新数据", description = "更新数据")
	public R<?> updateById(@RequestBody TemplateDirectory templateDirectory) {
		return templateDirectoryService.updateById(templateDirectory) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "更新数据失败");
	}

	/**
	 * 根据id删除数据
	 * @param id {@code id} id
	 * @return {@code R<?>} 通用返回体
	 */
	@DeleteMapping("/{id}")
	@io.swagger.v3.oas.annotations.Operation(summary = "根据id删除数据", description = "根据id删除数据")
	public R<?> removeById(@PathVariable Integer id) {
		return templateDirectoryService.removeById(id) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

}
