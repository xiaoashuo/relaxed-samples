package com.relaxed.samples.tenant.holder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yakir
 * @Topic TenantMap
 * @Description
 * @date 2021/7/28 21:28
 * @Version 1.0
 */
public class TenantMap {

	private static Map<String, TenantInfo> TENANT_HOLDER = new HashMap<>();
	static {
		// 可以扩展成 1个schema 多个表租户
		TenantInfo tenantInfo1 = new TenantInfo();
		tenantInfo1.setTenantId("1");
		tenantInfo1.setSchema("relaxed_sh");
		TenantInfo tenantInfo2 = new TenantInfo();
		tenantInfo2.setTenantId("2");
		tenantInfo2.setSchema("relaxed_bj");
		TENANT_HOLDER.put("1", tenantInfo1);
		TENANT_HOLDER.put("2", tenantInfo2);
	}

	public static TenantInfo getBTenantId(String tenantId) {
		return TENANT_HOLDER.get(tenantId);
	}

}
