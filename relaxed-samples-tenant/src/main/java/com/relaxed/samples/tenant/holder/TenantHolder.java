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

	private static final ThreadLocal<TenantInfo> USER_HOLDER = new NamedThreadLocal<>("table");

	public static TenantInfo get() {
		return USER_HOLDER.get();
	}

	public static String getSchema() {
		return get().getSchema();
	}

	public static String getTenantId() {
		return get().getTenantId();
	}

	public static void set(TenantInfo tenantInfo) {
		USER_HOLDER.set(tenantInfo);
	}

	public static void remove() {
		USER_HOLDER.remove();
	}

}
