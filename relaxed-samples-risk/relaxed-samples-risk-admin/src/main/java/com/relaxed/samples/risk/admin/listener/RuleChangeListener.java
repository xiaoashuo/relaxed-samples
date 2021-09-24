package com.relaxed.samples.risk.admin.listener;

import com.relaxed.common.risk.biz.service.RuleHistoryService;
import com.relaxed.samples.risk.admin.event.RuleChangeEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * @author Yakir
 * @Topic RuleChangeListener
 * @Description
 * @date 2021/9/24 15:06
 * @Version 1.0
 */
@RequiredArgsConstructor
public class RuleChangeListener {

	private final RuleHistoryService ruleHistoryService;

	@Async
	@EventListener(RuleChangeEvent.class)
	public void onDictChangeEvent(RuleChangeEvent event) {
		ruleHistoryService.save(event.getRuleHistory());
	}

}
