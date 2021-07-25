package com.relaxed.samples.datascope.config;

import com.relaxed.common.datascope.DataScope;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.schema.Column;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Yakir
 * @Topic CustomDataScope
 * @Description
 * @date 2021/7/25 17:30
 * @Version 1.0
 */
@Component
public class CustomDataScope implements DataScope {

	private static final String columnId = "pid";

	@Override
	public String getResource() {
		return "user";
	}

	@Override
	public Collection<String> getTableNames() {
		Set<String> tableNames = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		tableNames.addAll(Arrays.asList("user"));
		return tableNames;
	}

	@Override
	public Expression getExpression(String tableName, Alias tableAlias) {
		Column column = new Column(tableAlias == null ? columnId : tableAlias.getName() + "." + columnId);
		String pid = UserHolder.get();
		ExpressionList expressionList = new ExpressionList();
		expressionList.setExpressions(Arrays.asList(new StringValue(pid)));
		return new InExpression(column, expressionList);
	}

}
