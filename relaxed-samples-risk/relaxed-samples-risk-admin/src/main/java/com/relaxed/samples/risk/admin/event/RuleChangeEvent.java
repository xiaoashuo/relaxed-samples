package com.relaxed.samples.risk.admin.event;

import com.relaxed.common.risk.model.entity.RuleHistory;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author Yakir
 * @Topic RuleChangeEvent
 * @Description
 * @date 2021/9/24 15:04
 * @Version 1.0
 */
@Getter
public class RuleChangeEvent extends ApplicationEvent {

	/**
	 * 规则
	 */
	private final RuleHistory ruleHistory;

	public RuleChangeEvent(RuleHistory ruleHistory) {
		super(ruleHistory);
		this.ruleHistory = ruleHistory;
	}

}
