package com.relaxed.samples.controller;

import com.relaxed.common.log.operation.annotation.Log;
import com.relaxed.common.log.operation.enums.OperationTypeEnum;
import com.relaxed.common.model.result.R;
import com.relaxed.common.oss.s3.OssClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yakir
 * @Topic OssController
 * @Description
 * @date 2021/12/22 14:08
 * @Version 1.0
 */
@RequestMapping("/oss")
@RestController
public class OssController {

	@Autowired
	private OssClient ossClient;

	@Log(msg = "oss列表", type = OperationTypeEnum.OTHER)
	@GetMapping("/list")
	public R list(String prefix) {
		return R.ok(ossClient.list(prefix));
	}

}
