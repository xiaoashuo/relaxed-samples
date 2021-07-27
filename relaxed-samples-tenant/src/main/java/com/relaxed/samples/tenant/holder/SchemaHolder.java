package com.relaxed.samples.tenant.holder;

import org.springframework.core.NamedThreadLocal;

/**
 * @author Yakir
 * @Topic SchemaHolder
 * @Description
 * @date 2021/7/27 21:31
 * @Version 1.0
 */
public class SchemaHolder {

	private static final ThreadLocal<String> USER_HOLDER = new NamedThreadLocal<>("schema");

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
