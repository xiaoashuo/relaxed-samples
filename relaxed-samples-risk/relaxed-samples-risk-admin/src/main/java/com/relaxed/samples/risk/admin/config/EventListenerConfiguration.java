package com.relaxed.samples.risk.admin.config;

import com.relaxed.common.risk.biz.service.RuleHistoryService;
import com.relaxed.samples.risk.admin.listener.RuleChangeListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yakir
 * @Topic EventListenerConfiguration
 * @Description
 * @date 2021/9/24 15:08
 * @Version 1.0
 */
@Configuration
public class EventListenerConfiguration {

	/**
	 * 规则改变 监听事件
	 * @author yakir
	 * @date 2021/9/24 15:09
	 * @param ruleHistoryService
	 * @return com.relaxed.common.risk.admin.listener.RuleChangeListener
	 */
	@Bean
	public RuleChangeListener ruleChangeListener(RuleHistoryService ruleHistoryService) {
		return new RuleChangeListener(ruleHistoryService);
	}

}
