package com.relaxed.common.risk.engine.service;

import com.relaxed.common.risk.engine.rules.statistics.domain.AggregateParamBO;
import com.relaxed.common.risk.model.entity.Model;
import com.relaxed.common.risk.model.enums.FieldType;
import com.relaxed.common.risk.model.vo.ModelVO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Yakir
 * @Topic ModelMongoManageService
 * @Description
 * @date 2021/8/29 16:14
 * @Version 1.0
 */
public interface ModelEventManageService {

	/**
	 * 存储事件模型
	 * @author yakir
	 * @date 2021/8/29 16:17
	 * @param modelVO 模型信息
	 * @param jsonString 参数信息
	 * @param attachJson 预处理参数信息
	 * @param isAllowDuplicate 是否覆盖
	 * @return boolean
	 */
	boolean save(ModelVO modelVO, String jsonString, String attachJson, boolean isAllowDuplicate);

	/**
	 * 统计数目 未去重
	 * @author yakir
	 * @date 2021/8/30 16:33
	 * @param aggregateParamBO
	 * @return java.lang.Long
	 */
	Long count(AggregateParamBO aggregateParamBO);

	/**
	 * 去重数目统计
	 * @author yakir
	 * @date 2021/8/30 17:00
	 * @param aggregateParamBO
	 * @return java.lang.Long
	 */
	Long distinctCount(AggregateParamBO aggregateParamBO);

	/**
	 * 聚合总数
	 * @author yakir
	 * @date 2021/8/30 17:32
	 * @param aggregateParamBO
	 * @return java.lang.BigDecimal
	 */
	BigDecimal sum(AggregateParamBO aggregateParamBO);

	/**
	 * 平均值
	 * @author yakir
	 * @date 2021/8/30 18:09
	 * @param aggregateParamBO
	 * @return java.math.BigDecimal
	 */
	BigDecimal average(AggregateParamBO aggregateParamBO);

	/**
	 * 计算最大值
	 * @author yakir
	 * @date 2021/8/30 18:14
	 * @param aggregateParamBO
	 * @return java.math.BigDecimal
	 */
	BigDecimal max(AggregateParamBO aggregateParamBO);

	/**
	 * 求最小值
	 * @author yakir
	 * @date 2021/8/30 18:17
	 * @param aggregateParamBO
	 * @return java.math.BigDecimal
	 */
	BigDecimal min(AggregateParamBO aggregateParamBO);

	/**
	 * 标准差
	 * @author yakir
	 * @date 2021/8/30 18:19
	 * @param aggregateParamBO
	 * @return java.math.BigDecimal
	 */
	BigDecimal sd(AggregateParamBO aggregateParamBO);

	/**
	 * 中位数
	 * @author yakir
	 * @date 2021/8/30 18:24
	 * @param aggregateParamBO
	 * @return java.math.BigDecimal
	 */
	BigDecimal median(AggregateParamBO aggregateParamBO);

	/**
	 * 偏离率计算
	 * @author yakir
	 * @date 2021/8/31 9:16
	 * @param aggregateParamBO
	 * @return java.math.BigDecimal
	 */
	BigDecimal deviation(AggregateParamBO aggregateParamBO);

	/**
	 * 计算方差
	 * @author yakir
	 * @date 2021/8/31 9:19
	 * @param aggregateParamBO
	 * @return java.math.BigDecimal
	 */
	BigDecimal variance(AggregateParamBO aggregateParamBO);

}
