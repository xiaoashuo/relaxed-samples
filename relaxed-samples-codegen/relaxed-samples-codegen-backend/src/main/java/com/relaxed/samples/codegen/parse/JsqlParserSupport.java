package com.relaxed.samples.codegen.parse;

import com.relaxed.samples.codegen.model.dto.TableInfoDTO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.Statements;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.update.Update;

/**
 * @author Yakir
 * @Topic JsqlParserSupport
 * @Description https://github.com/JSQLParser/JSqlParser
 * @date 2021/7/17 12:22
 * @Version 1.0
 */
@Slf4j
public abstract class JsqlParserSupport {

	/**
	 * 格式化定义sql片段
	 * @param sql
	 */
	public TableInfoDTO parseDdl(String sql) {
		if (log.isDebugEnabled()) {
			log.debug("original SQL: " + sql);
		}
		try {
			Statement statement = CCJSqlParserUtil.parse(sql);
			return processDdlParser(statement, sql);
		}
		catch (JSQLParserException e) {
			throw new RuntimeException(String.format("Failed to process, Error SQL: %s", sql), e);
		}
	}

	public String parserSingle(String sql, Object obj) {
		if (log.isDebugEnabled()) {
			log.debug("original SQL: " + sql);
		}
		try {
			Statement statement = CCJSqlParserUtil.parse(sql);
			return processParser(statement, 0, sql, obj);
		}
		catch (JSQLParserException e) {
			throw new RuntimeException(String.format("Failed to process, Error SQL: %s", sql), e);
		}
	}

	public String parserMulti(String sql, Object obj) {
		if (log.isDebugEnabled()) {
			log.debug("original SQL: " + sql);
		}
		try {
			// fixed github pull/295
			StringBuilder sb = new StringBuilder();
			Statements statements = CCJSqlParserUtil.parseStatements(sql);
			int i = 0;
			for (Statement statement : statements.getStatements()) {
				if (i > 0) {
					sb.append(";");
				}
				sb.append(processParser(statement, i, sql, obj));
				i++;
			}
			return sb.toString();
		}
		catch (JSQLParserException e) {
			throw new RuntimeException(String.format("Failed to process, Error SQL: %s", sql), e);
		}
	}

	@SneakyThrows
	protected TableInfoDTO processDdlParser(Statement statement, String sql) {
		if (log.isDebugEnabled()) {
			log.debug("SQL to parse, SQL: " + sql);
		}
		TableInfoDTO tableInfoDTO = null;
		if (statement instanceof CreateTable) {
			tableInfoDTO = this.processCreate(statement, sql);
		}
		return tableInfoDTO;
	}

	/**
	 * 处理定义Sql片段
	 * @param statement
	 * @param sql
	 */
	protected TableInfoDTO processCreate(Statement statement, String sql) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 执行 SQL 解析
	 * @param statement JsqlParser Statement
	 * @return sql
	 */
	protected String processParser(Statement statement, int index, String sql, Object obj) {
		if (log.isDebugEnabled()) {
			log.debug("SQL to parse, SQL: " + sql);
		}

		if (statement instanceof Insert) {
			this.processInsert((Insert) statement, index, sql, obj);
		}
		else if (statement instanceof Select) {
			this.processSelect((Select) statement, index, sql, obj);
		}
		else if (statement instanceof Update) {
			this.processUpdate((Update) statement, index, sql, obj);
		}
		else if (statement instanceof Delete) {
			this.processDelete((Delete) statement, index, sql, obj);
		}
		sql = statement.toString();
		if (log.isDebugEnabled()) {
			log.debug("parse the finished SQL: " + sql);
		}
		return sql;
	}

	/**
	 * 新增
	 */
	protected void processInsert(Insert insert, int index, String sql, Object obj) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 删除
	 */
	protected void processDelete(Delete delete, int index, String sql, Object obj) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 更新
	 */
	protected void processUpdate(Update update, int index, String sql, Object obj) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 查询
	 */
	protected void processSelect(Select select, int index, String sql, Object obj) {
		throw new UnsupportedOperationException();
	}

}
