package com.relaxed.samples.doc.provider;

import com.relaxed.common.model.result.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "测试接口", description = "测试商品描述")
@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

	/**
	 * 测试查询
	 * @return
	 */
	@Operation(summary = "查询结果", description = "查询结果")
	@GetMapping("/get/result")
	public R<ResultObj> getResult() {
		ResultObj resultObj = new ResultObj(10);
		R<ResultObj> objectR = new R<>();
		objectR.setCode(200);
		objectR.setData(resultObj);
		return objectR;
	}

	@Operation(summary = "查询测试", description = "查询测试")
	@GetMapping("/get/test")
	public R<TestObj> getTest() {
		TestObj testObj = new TestObj(10, "sha", BigDecimal.ZERO);
		R<TestObj> objectR = new R<>();
		objectR.setCode(200);
		objectR.setData(testObj);
		return objectR;
	}

	// /**
	// * 更新测试
	// * @param testObj
	// * @return
	// */
	// @Operation(summary = "更新测试", description = "更新数据不能为空")
	// @PutMapping
	// public Re update(@RequestBody TestObj testObj) {
	// return Re.ok(new TestObj(11, "更新测试", BigDecimal.ZERO));
	// }

}
