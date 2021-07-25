package com.relaxed.samples.datascope.config;

import com.relaxed.common.datascope.DataScope;
import org.springframework.core.NamedThreadLocal;

import java.util.List;

/**
 * @author Yakir
 * @Topic UserHolder
 * @Description
 * @date 2021/7/25 17:35
 * @Version 1.0
 */
public class UserHolder {

	private static final ThreadLocal<String> USER_HOLDER = new NamedThreadLocal<>("user");

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
