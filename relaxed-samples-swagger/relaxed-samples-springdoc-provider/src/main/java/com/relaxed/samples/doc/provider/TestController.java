package com.relaxed.samples.doc.provider;

import com.relaxed.common.model.result.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Tag(name = "测试接口", description = "测试商品描述")
@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

	/**
	 * 测试保存
	 * @param testObj
	 * @return
	 */
	@Operation(summary = "测试保存", description = "保存数据不能为空")
	@PostMapping
	public R save(TestObj testObj) {

		return R.ok(new TestObj(10, "测试", BigDecimal.ZERO));
	}

	/**
	 * 更新测试
	 * @param testObj
	 * @return
	 */
	@Operation(summary = "更新测试", description = "更新数据不能为空")
	@PutMapping
	public R update(@RequestBody TestObj testObj) {
		return R.ok(new TestObj(11, "更新测试", BigDecimal.ZERO));
	}

}
