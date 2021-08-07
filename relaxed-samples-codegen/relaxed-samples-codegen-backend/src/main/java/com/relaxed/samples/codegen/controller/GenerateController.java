package com.relaxed.samples.codegen.controller;

import cn.hutool.core.io.IoUtil;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.result.R;
import com.relaxed.samples.codegen.model.dto.DdlGenerateOptionDTO;
import com.relaxed.samples.codegen.model.dto.GenerateOptionDTO;
import com.relaxed.samples.codegen.model.dto.PreGenerateOptionDTO;
import com.relaxed.samples.codegen.model.entity.ColumnInfo;
import com.relaxed.samples.codegen.model.entity.TableInfo;
import com.relaxed.samples.codegen.model.qo.TableInfoQO;
import com.relaxed.samples.codegen.model.vo.TableInfoVO;
import com.relaxed.samples.codegen.service.GenerateService;
import com.relaxed.samples.codegen.service.TableInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 代码生成控制器
 *
 * @author Yakir
 */
@Api(tags = "代码生成器")
@RequiredArgsConstructor
@RestController
@RequestMapping("tool/gen")
public class GenerateController {

	private final TableInfoService tableInfoService;

	private final GenerateService generateService;

	/**
	 * 表信息分页查询
	 * @param pageParam 分页参数
	 * @param tableInfoQO 表信息查询对象
	 * @return R
	 */
	@ApiOperation(value = "表信息分页查询", notes = "表信息分页查询")
	@GetMapping("/table/info/page")
	public R<PageResult<TableInfoVO>> selectTableInfoPage(PageParam pageParam, TableInfoQO tableInfoQO) {
		return R.ok(tableInfoService.selectTableByPage(pageParam, tableInfoQO));
	}

	/**
	 * 表信息列表
	 * @param tableInfoQO
	 * @return
	 */
	@GetMapping("/table/info/list")
	public R<List<TableInfo>> selectTableList(TableInfoQO tableInfoQO) {
		return R.ok(tableInfoService.selectTableList(tableInfoQO));
	}

	/**
	 * 表列信息列表
	 * @param tableName {@code tableName}
	 * @return {@code R<List<ColumnInfo>>}
	 */
	@ApiOperation(value = "表列信息列表", notes = "表列信息列表")
	@GetMapping("/table/column/list")
	public R<List<ColumnInfo>> selectColumnList(@RequestParam(value = "tableName") String tableName) {
		return R.ok(tableInfoService.listColumnInfo(tableName));
	}

	/**
	 * 生成代码文件
	 * @param generateOptionDTO {@code generateOptionDTO}
	 * @param response {@code Response}
	 */
	@SneakyThrows
	@PostMapping("/code")
	public void generateCode(@RequestBody GenerateOptionDTO generateOptionDTO, HttpServletResponse response) {
		byte[] data = generateService.generateCode(generateOptionDTO);
		response.reset();
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Relaxed-Codegen.zip\"");
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
		response.setContentType("application/octet-stream; charset=UTF-8");
		IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);
	}

	/**
	 * 生成代码文件
	 * @param generateOptionDTO {@code generateOptionDTO}
	 * @param response {@code Response}
	 */
	@SneakyThrows
	@PostMapping("/ddl/code")
	public void generateCodeByDdl(@RequestBody DdlGenerateOptionDTO generateOptionDTO, HttpServletResponse response) {
		byte[] data = generateService.generateCodeByDdl(generateOptionDTO);
		response.reset();
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Relaxed-Codegen.zip\"");
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
		response.setContentType("application/octet-stream; charset=UTF-8");
		IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);
	}

	/**
	 * 生成预览代码
	 * @param generateOptionDTO
	 * @return
	 */
	@PostMapping("/ddl/preview/code")
	public R<Map<String, String>> previewCode(@RequestBody DdlGenerateOptionDTO generateOptionDTO) throws IOException {
		return R.ok(generateService.previewCodeByDdl(generateOptionDTO));
	}

	/**
	 * 生成预览代码
	 * @param preGenerateOptionDTO
	 * @return
	 */
	@PostMapping("/preview/code")
	public R<Map<String, String>> previewCode(@RequestBody PreGenerateOptionDTO preGenerateOptionDTO) {
		return R.ok(generateService.previewCode(preGenerateOptionDTO));
	}

}
