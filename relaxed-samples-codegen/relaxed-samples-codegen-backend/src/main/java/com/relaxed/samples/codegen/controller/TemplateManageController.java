package com.relaxed.samples.codegen.controller;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.domain.SelectData;

import com.relaxed.common.model.result.BaseResultCode;
import com.relaxed.common.model.result.R;
import com.relaxed.samples.codegen.model.dto.TemplateGroupDTO;
import com.relaxed.samples.codegen.model.dto.TemplateInfoDTO;
import com.relaxed.samples.codegen.model.dto.TemplatePropertyDTO;
import com.relaxed.samples.codegen.model.qo.TemplatePropertyQO;
import com.relaxed.samples.codegen.model.vo.TemplateGroupVO;
import com.relaxed.samples.codegen.model.vo.TemplateInfoVO;
import com.relaxed.samples.codegen.model.vo.TemplatePropertyPageVO;
import com.relaxed.samples.codegen.model.vo.TemplatePropertyVO;
import com.relaxed.samples.codegen.service.TemplateManageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 模板管理控制层
 *
 * @author Yakir
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/tool/tpl")
@Tag(name = "模板管理")
public class TemplateManageController {

	private final TemplateManageService templateManageService;

	/**
	 * 新增模板组
	 * @param templateGroupDTO {@code templateGroupDTO}
	 * @return {@code R<?>}
	 */
	@PostMapping("/group")
	@io.swagger.v3.oas.annotations.Operation(summary = "新增模板组", description = "新增模板组")
	public R<?> saveTemplateGroup(@RequestBody TemplateGroupDTO templateGroupDTO) {
		return templateManageService.saveTemplateGroup(templateGroupDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增模板组失败");
	}

	/**
	 * 删除
	 * @param templateGroupId {@code Long}
	 * @return {@link R}
	 */
	@DeleteMapping("/group/remove/{templateGroupId}")
	@io.swagger.v3.oas.annotations.Operation(summary = "删除模板组", description = "删除模板组")
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
	@PutMapping("/group/update")
	@io.swagger.v3.oas.annotations.Operation(summary = "修改模板组", description = "修改模板组")
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
	@GetMapping("/group/page")
	@io.swagger.v3.oas.annotations.Operation(summary = "模板组分页查询", description = "模板组分页查询")
	public R<PageResult<TemplateGroupVO>> selectTemplateGroupPage(PageParam pageParam,
			TemplateGroupDTO templateGroupDTO) {
		return R.ok(templateManageService.selectTemplateGroupPage(pageParam, templateGroupDTO));
	}

	/**
	 * 查询所有模板组
	 * @return {@link R < List < SelectData <?>>>}
	 */
	@GetMapping("/group/all")
	@io.swagger.v3.oas.annotations.Operation(summary = "模板组列表", description = "模板组列表")
	public R<List<SelectData<?>>> selectAllTemplateGroup() {
		return R.ok(templateManageService.selectAllTemplateGroup());
	}

	/**
	 * 查询属性列表根据模板组id
	 * @param templateGroupId {@code templateGroupId}
	 * @return {@link R < List < TemplatePropertyVO >> }
	 */
	@GetMapping("/property/list/{templateGroupId}")
	@io.swagger.v3.oas.annotations.Operation(summary = "模板属性列表", description = "模板属性列表")
	public R<List<TemplatePropertyVO>> listTemplatePropertyByGid(@PathVariable Integer templateGroupId) {
		return R.ok(templateManageService.listTemplatePropertyByGid(templateGroupId));
	}

	/**
	 * 分页查询
	 * @param pageParam 分页对象
	 * @param templatePropertyQO 模板属性配置
	 * @return R
	 */
	@GetMapping("/property/page")
	@io.swagger.v3.oas.annotations.Operation(summary = "分页查询", description = "分页查询")
	public R<PageResult<TemplatePropertyPageVO>> getTemplatePropertyPage(PageParam pageParam,
			TemplatePropertyQO templatePropertyQO) {
		return R.ok(templateManageService.selectTemplatePropertyPage(pageParam, templatePropertyQO));
	}

	/**
	 * 新增模板属性
	 * @param templatePropertyDTO {@link TemplatePropertyDTO}
	 * @return {@code R<?>}
	 */
	@PostMapping("/property")
	@io.swagger.v3.oas.annotations.Operation(summary = "新增模板属性", description = "新增模板属性")
	public R<?> saveTemplateProperty(@RequestBody TemplatePropertyDTO templatePropertyDTO) {
		return templateManageService.saveTemplateProperty(templatePropertyDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增模板属性失败");
	}

	/**
	 * 删除模板属性通过id
	 * @param templatePropertyId {@code Long}
	 * @return {@link R}
	 */
	@DeleteMapping("/property/remove/{templatePropertyId}")
	@io.swagger.v3.oas.annotations.Operation(summary = "删除模板属性", description = "删除模板属性")
	public R<?> removeTempLatePropertyById(@PathVariable Long templatePropertyId) {
		return templateManageService.removeTempLatePropertyById(templatePropertyId) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "通过id删除模板属性失败");
	}

	/**
	 * 修改
	 * @param templatePropertyDTO {@link TemplatePropertyDTO}
	 * @return {@link R}
	 */
	@PutMapping("/property/update")
	@io.swagger.v3.oas.annotations.Operation(summary = "修改模板属性", description = "修改模板属性")
	public R<?> updateTemplatePropertyById(@RequestBody TemplatePropertyDTO templatePropertyDTO) {
		return templateManageService.updateTemplatePropertyById(templatePropertyDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "修改模板属性失败");
	}

	/**
	 * 新增模板信息
	 * @param templateInfoDTO {@link TemplateInfoDTO}
	 * @return {@code R<?>}
	 */
	@PostMapping("/info")
	@io.swagger.v3.oas.annotations.Operation(summary = "新增模板信息", description = "新增模板信息")
	public R<?> saveTemplateInfo(@RequestBody TemplateInfoDTO templateInfoDTO) {
		return templateManageService.saveTemplateInfo(templateInfoDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "新增模板信息失败");
	}

	/**
	 * 删除模板信息通过id
	 * @param templateInfoId {@code Long}
	 * @return {@link R}
	 */
	@DeleteMapping("/info/remove/{templateInfoId}")
	@io.swagger.v3.oas.annotations.Operation(summary = "删除模板信息", description = "删除模板信息")
	public R<?> removeTempLateInfoById(@PathVariable Long templateInfoId) {
		return templateManageService.removeTempLateInfoById(templateInfoId) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "通过id删除模板信息失败");
	}

	/**
	 * 修改
	 * @param templateInfoDTO {@link TemplateInfoDTO}
	 * @return {@link R}
	 */
	@PutMapping("/info/update")
	@io.swagger.v3.oas.annotations.Operation(summary = "修改模板信息", description = "修改模板信息")
	public R<?> updateTemplateInfoById(@RequestBody TemplateInfoDTO templateInfoDTO) {
		return templateManageService.updateTemplateInfoById(templateInfoDTO) ? R.ok()
				: R.failed(BaseResultCode.UPDATE_DATABASE_ERROR, "修改模板信息失败");
	}

	/**
	 * 获取模板信息列表
	 * @param templateGroupId
	 * @return {@link R < List < TemplateInfoVO >>}
	 */
	@GetMapping("/info/list/{templateGroupId}")
	@io.swagger.v3.oas.annotations.Operation(summary = "模板信息列表", description = "模板信息列表")
	public R<List<TemplateInfoVO>> listTemplateInfos(@PathVariable Integer templateGroupId) {
		return R.ok(templateManageService.listTemplateInfosByGid(templateGroupId));
	}

}
