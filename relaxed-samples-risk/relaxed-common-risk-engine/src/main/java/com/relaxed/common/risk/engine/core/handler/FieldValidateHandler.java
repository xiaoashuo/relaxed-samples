package com.relaxed.common.risk.engine.core.handler;

import com.relaxed.common.risk.model.entity.FieldValidResult;
import com.relaxed.common.risk.model.vo.FieldVO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author Yakir
 * @Topic FiledValidateHandler
 * @Description
 * @date 2021/8/29 13:08
 * @Version 1.0
 */
public interface FieldValidateHandler {

	/**
	 * 字段验证处理器
	 * @author yakir
	 * @date 2021/8/29 13:48
	 * @param fieldVO 字段信息
	 * @param contextInfo 上下文信息
	 * @return com.relaxed.common.risk.engine.core.handler.FieldValidateHandler.FieldValidResult
	 */
	FieldValidResult valid(FieldVO fieldVO, Map contextInfo);

}
