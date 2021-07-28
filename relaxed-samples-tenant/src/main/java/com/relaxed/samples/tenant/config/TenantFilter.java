package com.relaxed.samples.tenant.config;

import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.relaxed.common.tenant.exception.TenantException;
import com.relaxed.samples.tenant.holder.TenantHolder;
import com.relaxed.samples.tenant.holder.TenantInfo;
import com.relaxed.samples.tenant.holder.TenantMap;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yakir
 * @Topic TenantFilter
 * @Description
 * @date 2021/7/28 20:39
 * @Version 1.0
 */
@RequiredArgsConstructor
public class TenantFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String tenant_id = request.getParameter("tenant_id");
		if (StrUtil.isEmpty(tenant_id)) {
			throw new TenantException("租户id不存在");
		}
		// 根据id信息 发现租户配置信息 也可以动态添加数据源进来
		//
		TenantInfo tenantInfo = TenantMap.getBTenantId(tenant_id);
		if (tenantInfo == null) {
			throw new TenantException("租户信息不存在");
		}
		TenantHolder.set(tenantInfo);
		DynamicDataSourceContextHolder.push(tenantInfo.getSchema());
		try {
			filterChain.doFilter(request, response);
		}
		finally {
			// 清空线程变量 也可以写在拦截器中
			TenantHolder.remove();
			DynamicDataSourceContextHolder.clear();
		}

	}

}
