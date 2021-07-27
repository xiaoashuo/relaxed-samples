package com.relaxed.samples.tenant.config;

import com.relaxed.common.tenant.core.table.DataScope;
import com.relaxed.common.tenant.core.table.TableHandler;

import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Yakir
 * @Topic CustomDataTableHandle
 * @Description
 * @date 2021/7/27 20:31
 * @Version 1.0
 */
@RequiredArgsConstructor
public class CustomDataTableHandle implements TableHandler {

	private final List<DataScope> dataScopes;

	/**
	 * true 启用 数据列 false 不启用
	 * @author yakir
	 * @date 2021/7/27 20:34
	 * @return boolean
	 */
	@Override
	public boolean enable() {
		return true;
	}

	/**
	 * 返回所有的数据权限域
	 * @author yakir
	 * @date 2021/7/27 21:02
	 * @return java.util.List<com.relaxed.common.tenant.handler.table.DataScope>
	 */
	@Override
	public List<DataScope> dataScopes() {
		return dataScopes;
	}

	/**
	 * 根据mapperStatementId 提取数据权限 为空 则不进行过滤租户列 可以在此扩展 自定义注解等等
	 * @author yakir
	 * @date 2021/7/27 21:03
	 * @param mapperStatementId
	 * @return java.util.List<com.relaxed.common.tenant.handler.table.DataScope>
	 */
	@Override
	public List<DataScope> filterDataScopes(String mapperStatementId) {
		return dataScopes;
	}

	/**
	 * 决定 是否忽略当前字段列
	 * @author yakir
	 * @date 2021/7/27 21:04
	 * @param mapperStatementId
	 * @return boolean
	 */
	@Override
	public boolean ignore(String mapperStatementId) {
		return false;
	}

}
