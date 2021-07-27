package com.relaxed.samples.tenant.config;

import com.relaxed.common.tenant.handler.table.DataScope;
import com.relaxed.samples.tenant.holder.TenantHolder;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.schema.Column;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Yakir
 * @Topic CustomDataScope
 * @Description
 * @date 2021/7/27 20:31
 * @Version 1.0
 */
public class CustomDataScope implements DataScope {

	private final String column_id = "tenant_id";

	@Override
	public String getTenantId() {
		return column_id;
	}

	@Override
	public Collection<String> getTableNames() {
		Set<String> tableNames = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		tableNames.addAll(Arrays.asList("t_user"));
		return tableNames;
	}

	@Override
	public Expression getExpression(String tableName, Alias tableAlias) {
		Column column = new Column(tableAlias == null ? getTenantId() : tableAlias.getName() + "." + getTenantId());
		// 租户id列值 此处可以从用户权限里面获取等等
		String tenantId = TenantHolder.get();
		ExpressionList expressionList = new ExpressionList();
		expressionList.setExpressions(Arrays.asList(new StringValue(tenantId)));
		return new InExpression(column, expressionList);
	}

}
