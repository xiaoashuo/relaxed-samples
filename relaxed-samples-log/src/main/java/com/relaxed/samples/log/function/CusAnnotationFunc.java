package com.relaxed.samples.log.function;

import cn.hutool.json.JSONUtil;
import com.relaxed.common.log.biz.annotation.LogFunc;
import com.relaxed.common.log.biz.constant.LogRecordConstants;
import com.relaxed.common.log.biz.model.AttributeModel;
import com.relaxed.common.log.biz.model.DiffMeta;
import com.relaxed.common.log.biz.service.IDataHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Yakir
 * @Topic CusAnFunc
 * @Description
 * @date 2023/12/15 10:10
 * @Version 1.0
 */
@RequiredArgsConstructor
@Component
@LogFunc
public class CusAnnotationFunc {




	@LogFunc
	public static String testAnnotation(Integer arg) {
		return "test annotation method success" + arg;
	}

	@LogFunc
	public String testAnnotationNoStatic() {
		return "test annotation non static method success";
	}

	/**
	 * 标识为前置函数
	 * @param arg
	 * @return
	 */
	@LogFunc(around = LogRecordConstants.BEFORE_FUNC)
	public static String testBeforeFunc(Integer arg) {
		return "test annotation before method success" + arg;
	}

}
