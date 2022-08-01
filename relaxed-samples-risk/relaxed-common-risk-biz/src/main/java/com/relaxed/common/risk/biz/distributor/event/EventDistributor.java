package com.relaxed.common.risk.biz.distributor.event;

import com.relaxed.common.risk.biz.distributor.event.subscribe.SubscribeHandle;

/**
 * @author Yakir
 * @Topic EventDistributor
 * @Description 事件分发者 将动作分发出去 交由订阅者做后续处理
 * @date 2021/8/29 9:44
 * @Version 1.0
 */
public interface EventDistributor {

	/**
	 * 风控分发
	 * @author yakir
	 * @date 2021/8/29 9:45
	 * @param channel
	 * @param message
	 */
	void distribute(String channel, String message);

	/**
	 * 风控订阅者
	 * @author yakir
	 * @date 2021/8/29 9:46
	 * @param channel
	 * @param subscribeHandle
	 */
	void subscribe(String channel, SubscribeHandle subscribeHandle);

}
