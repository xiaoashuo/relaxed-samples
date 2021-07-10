package com.relaxed.samples.codegen.controller;

import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;
import com.relaxed.common.core.domain.SelectData;
import com.relaxed.common.core.result.BaseResultCode;
import com.relaxed.common.core.result.R;
import com.relaxed.samples.codegen.model.dto.TemplateGroupDTO;
import com.relaxed.samples.codegen.model.dto.TemplateInfoDTO;
import com.relaxed.samples.codegen.model.dto.TemplatePropertyDTO;
import com.relaxed.samples.codegen.model.vo.TemplateGroupVO;
import com.relaxed.samples.codegen.model.vo.TemplateInfoVO;
import com.relaxed.samples.codegen.model.vo.TemplatePropertyVO;
import com.relaxed.samples.codegen.service.TemplateManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 模板管理控制层
 *
 * @author Yakir
 */
@Api(tags = "模板管理")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/tool/tpl")
public class TemplateManageController {

	private final TemplateManageService templateManageService;

	/**
	 * 新增模板组
	 * @param templateGroupDTO {@code templateGroupDTO}
	 * @return {@code R<?>}
	 */
	@ApiOperation(value = "新增模板组", notes = "新增模板组")
	@PostMapping("/group")
	public R<?> saveTemplateGroup(@RequestBody TemplateGroupDTO templateGroupDTO) {
		return templateManageService.saveTemplateGroup(templateGroupDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增模板组失败");
	}

	/**
	 * 删除
	 * @param templateGroupId {@code Long}
	 * @return {@link R}
	 */
	@ApiOperation(value = "删除模板组", notes = "删除模板组")
	@DeleteMapping("/group/remove/{templateGroupId}")
	public R<?> removeTempLateGroupById(@PathVariable Long templateGroupId) {
		// 业务逻辑
		return templateManageService.removeTemplateGroupById(templateGroupId) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "通过id删除模板组失败");
	}

	/**
	 * 修改
	 * @param templateGroupDTO {@link TemplateGroupDTO}
	 * @return {@link R}
	 */
	@ApiOperation(value = "修改模板组", notes = "修改模板组")
	@PutMapping("/group/update")
	public R<?> updateTemplateGroupById(@RequestBody TemplateGroupDTO templateGroupDTO) {
		return templateManageService.updateTemplateGroupById(templateGroupDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "修改模板组失败");
	}

	/**
	 * 分页查询模板组
	 * @param pageParam
	 * @param templateGroupDTO
	 * @return
	 */
	@ApiOperation(value = "模板组分页查询", notes = "模板组分页查询")
	@GetMapping("/group/page")
	public R<PageResult<TemplateGroupVO>> selectTemplateGroupPage(PageParam pageParam,
			TemplateGroupDTO templateGroupDTO) {
		return R.ok(templateManageService.selectTemplateGroupPage(pageParam, templateGroupDTO));
	}

	/**
	 * 查询所有模板组
	 * @return {@link R<List<SelectData<?>>>}
	 */
	@ApiOperation(value = "模板组列表", notes = "模板组列表")
	@GetMapping("/group/all")
	public R<List<SelectData<?>>> selectAllTemplateGroup() {
		return R.ok(templateManageService.selectAllTemplateGroup());
	}

	/**
	 * 查询属性列表根据模板组id
	 * @param templateGroupId {@code templateGroupId}
	 * @return {@link R<List<TemplatePropertyVO>> }
	 */
	@ApiOperation(value = "模板属性列表", notes = "模板属性列表")
	@GetMapping("/property/list/{templateGroupId}")
	public R<List<TemplatePropertyVO>> listTemplatePropertyByGid(@PathVariable Integer templateGroupId) {
		return R.ok(templateManageService.listTemplatePropertyByGid(templateGroupId));
	}

	/**
	 * 新增模板属性
	 * @param templatePropertyDTO {@link TemplatePropertyDTO}
	 * @return {@code R<?>}
	 */
	@ApiOperation(value = "新增模板属性", notes = "新增模板属性")
	@PostMapping("/property")
	public R<?> saveTemplateProperty(@RequestBody TemplatePropertyDTO templatePropertyDTO) {
		return templateManageService.saveTemplateProperty(templatePropertyDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增模板属性失败");
	}

	/**
	 * 删除模板属性通过id
	 * @param templatePropertyId {@code Long}
	 * @return {@link R}
	 */
	@ApiOperation(value = "删除模板属性", notes = "删除模板属性")
	@DeleteMapping("/property/remove/{templatePropertyId}")
	public R<?> removeTempLatePropertyById(@PathVariable Long templatePropertyId) {
		return templateManageService.removeTempLatePropertyById(templatePropertyId) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "通过id删除模板属性失败");
	}

	/**
	 * 修改
	 * @param templatePropertyDTO {@link TemplatePropertyDTO}
	 * @return {@link R}
	 */
	@ApiOperation(value = "修改模板属性", notes = "修改模板属性")
	@PutMapping("/property/update")
	public R<?> updateTemplatePropertyById(@RequestBody TemplatePropertyDTO templatePropertyDTO) {
		return templateManageService.updateTemplatePropertyById(templatePropertyDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "修改模板属性失败");
	}

	/**
	 * 新增模板信息
	 * @param templateInfoDTO {@link TemplateInfoDTO}
	 * @return {@code R<?>}
	 */
	@ApiOperation(value = "新增模板信息", notes = "新增模板信息")
	@PostMapping("/info")
	public R<?> saveTemplateInfo(@RequestBody TemplateInfoDTO templateInfoDTO) {
		return templateManageService.saveTemplateInfo(templateInfoDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增模板信息失败");
	}

	/**
	 * 删除模板信息通过id
	 * @param templateInfoId {@code Long}
	 * @return {@link R}
	 */
	@ApiOperation(value = "删除模板信息", notes = "删除模板信息")
	@DeleteMapping("/info/remove/{templateInfoId}")
	public R<?> removeTempLateInfoById(@PathVariable Long templateInfoId) {
		return templateManageService.removeTempLateInfoById(templateInfoId) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "通过id删除模板信息失败");
	}

	/**
	 * 修改
	 * @param templateInfoDTO {@link TemplateInfoDTO}
	 * @return {@link R}
	 */
	@ApiOperation(value = "修改模板信息", notes = "修改模板信息")
	@PutMapping("/info/update")
	public R<?> updateTemplateInfoById(@RequestBody TemplateInfoDTO templateInfoDTO) {
		return templateManageService.updateTemplateInfoById(templateInfoDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "修改模板信息失败");
	}

	/**
	 * 获取模板信息列表
	 * @param templateGroupId
	 * @return {@link R<List<TemplateInfoVO>>}
	 */
	@ApiOperation(value = "模板信息列表", notes = "模板信息列表")
	@GetMapping("/info/list/{templateGroupId}")
	public R<List<TemplateInfoVO>> listTemplateInfos(@PathVariable Integer templateGroupId) {
		return R.ok(templateManageService.listTemplateInfosByGid(templateGroupId));
	}

}
