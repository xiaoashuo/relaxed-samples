package com.relaxed.samples.risk.engine.controller;

import com.relaxed.common.model.result.R;
import com.relaxed.common.risk.engine.core.plugins.PluginService;
import com.relaxed.common.risk.engine.service.RiskAnalysisEngineService;
import com.relaxed.samples.risk.engine.model.dto.EventRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Yakir
 * @Topic RiskController
 * @Description 接受用户事件数据，实时进行分析并返回分析结果。
 * @date 2021/9/7 10:43
 * @Version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/services/risk/v1")
@Api(value = "RiskApi", tags = { "风险分析API(引擎端)" })
public class RiskController {

	private final RiskAnalysisEngineService riskAnalysisEngineService;

	@ApiOperation(value = "查询事件处理结果")
	@GetMapping("/getScore")
	public R getScore(@RequestParam @ApiParam(name = "modelGuid", value = "模型Guid", required = true) String modelGuid,
			@RequestParam @ApiParam(name = "reqId", value = "请求流水号", required = true) String reqId) {
		return riskAnalysisEngineService.evaluateReport(modelGuid, reqId);
	}

	@ApiOperation(value = "事件数据提交接口")
	@PostMapping("/upload")
	public R upload(@Validated @RequestBody EventRequest request) {
		return riskAnalysisEngineService.evaluateRisk(request.getGuid(), request.getReqId(), request.getJsonInfo());
	}

	@ApiOperation(value = "事件数据提交接口")
	@PostMapping("/upload/async")
	public R asyncUpload(@Validated @RequestBody EventRequest request) {
		return riskAnalysisEngineService.evaluateRiskAsync(request.getGuid(), request.getReqId(),
				request.getJsonInfo());
	}

}
