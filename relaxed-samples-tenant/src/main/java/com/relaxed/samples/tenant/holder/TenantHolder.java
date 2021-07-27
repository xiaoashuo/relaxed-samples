package com.relaxed.samples.tenant.holder;

import org.springframework.core.NamedThreadLocal;

/**
 * @author Yakir
 * @Topic TenantHolder
 * @Description
 * @date 2021/7/27 21:16
 * @Version 1.0
 */
public class TenantHolder {

	private static final ThreadLocal<String> USER_HOLDER = new NamedThreadLocal<>("table");

	public static String get() {
		return USER_HOLDER.get();
	}

	public static void set(String userId) {
		USER_HOLDER.set(userId);
	}

	public static void remove() {
		USER_HOLDER.remove();
	}

}
