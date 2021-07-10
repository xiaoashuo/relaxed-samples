package com.relaxed.samples.codegen.controller;

import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;
import com.relaxed.common.core.result.BaseResultCode;
import com.relaxed.common.core.result.R;
import com.relaxed.samples.codegen.model.entity.TemplateDirectory;
import com.relaxed.samples.codegen.model.qo.TemplateDirectoryQO;
import com.relaxed.samples.codegen.model.vo.TemplateDirectoryVO;
import com.relaxed.samples.codegen.service.TemplateDirectoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping
@Api(tags = "模板文件目录项")
public class TemplateDirectoryController {

	private final TemplateDirectoryService templateDirectoryService;

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam} 分页参数
	 * @param templateDirectoryQO {@link TemplateDirectoryQO} 查询条件
	 * @return @{code R<PageResult<TemplateDirectoryVO>>} 通用返回体
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R<PageResult<TemplateDirectoryVO>> page(PageParam pageParam, TemplateDirectoryQO templateDirectoryQO) {
		return R.ok(templateDirectoryService.selectByPage(pageParam, templateDirectoryQO));
	}

	/**
	 * 新增数据
	 * @param templateDirectory {@link TemplateDirectory} 数据参数
	 * @return {@code R<?>} 通用返回体
	 */
	@ApiOperation(value = "新增数据", notes = "新增数据")
	@PostMapping
	public R<?> save(@RequestBody TemplateDirectory templateDirectory) {
		return templateDirectoryService.save(templateDirectory) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增数据失败");
	}

	/**
	 * 更新数据
	 * @param templateDirectory {@link TemplateDirectory} 更新数据
	 * @return {@code R<?>}通用返回体
	 */
	@ApiOperation(value = "更新数据", notes = "更新数据")
	@PutMapping
	public R<?> updateById(@RequestBody TemplateDirectory templateDirectory) {
		return templateDirectoryService.updateById(templateDirectory) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "更新数据失败");
	}

	/**
	 * 根据id删除数据
	 * @param id {@code id} id
	 * @return {@code R<?>} 通用返回体
	 */
	@ApiOperation(value = "根据id删除数据", notes = "根据id删除数据")
	@DeleteMapping("/{id}")
	public R<?> removeById(@PathVariable Integer id) {
		return templateDirectoryService.removeById(id) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "根据id删除数据失败");
	}

}
