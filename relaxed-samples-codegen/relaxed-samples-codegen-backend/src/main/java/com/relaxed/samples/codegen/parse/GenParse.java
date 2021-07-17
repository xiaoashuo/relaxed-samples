package com.relaxed.samples.codegen.parse;

import com.relaxed.samples.codegen.model.converter.column.MysqlIndexTypeConvert;
import com.relaxed.samples.codegen.model.dto.TableInfoDTO;
import com.relaxed.samples.codegen.model.entity.ColumnInfo;
import com.relaxed.samples.codegen.model.entity.TableInfo;
import lombok.Data;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.ColDataType;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.create.table.Index;
import net.sf.jsqlparser.statement.select.PlainSelect;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Yakir
 * @Topic GenParse
 * @Description
 * @date 2021/7/17 13:34
 * @Version 1.0
 */
public class GenParse extends JsqlParserSupport {

	@Override
	protected TableInfoDTO processCreate(Statement statement, String sql) {
		TableInfo tableInfo = new TableInfo();
		List<ColumnInfo> columnInfos = new ArrayList<>();
		CreateTable sqlTableInfo = (CreateTable) statement;
		String tableName = removeBackslash(sqlTableInfo.getTable().getName());
		List<String> tableOptionsStrings = sqlTableInfo.getTableOptionsStrings();
		Map<String, String> tableOptionMap = extractTableOptions(tableOptionsStrings);
		tableInfo.setTableName(tableName);
		tableInfo.setEngine(tableOptionMap.get("ENGINE"));
		tableInfo.setTableComment(removeBackslash(tableOptionMap.get("COMMENT")));
		tableInfo.setCreateTime(LocalDateTime.now());
		// 索引处理
		List<Index> indexes = sqlTableInfo.getIndexes();
		Map<String, String> indexMap = convertIndexToMap(indexes);

		// 填充列
		List<ColumnDefinition> columnDefinitions = sqlTableInfo.getColumnDefinitions();
		for (ColumnDefinition columnDefinition : columnDefinitions) {
			ColumnInfo columnInfo = new ColumnInfo();
			String columnName = removeBackslash(columnDefinition.getColumnName());
			List<String> columnSpecs = columnDefinition.getColumnSpecs();
			columnInfo.setColumnName(columnName);
			ColDataType colDataType = columnDefinition.getColDataType();
			String dataType = colDataType.getDataType().toLowerCase();
			List<String> argumentsStringList = colDataType.getArgumentsStringList();
			columnInfo.setDataType(dataType);
			columnInfo.setColumnType(convertColumnType(dataType, argumentsStringList));
			columnInfo.setColumnKey(indexMap.get(columnName));
			columnInfo.setColumnComment(extractColumnOptionsToString(columnSpecs, "COMMENT"));
			columnInfo.setIsNullable(decideNullAble(columnSpecs));
			columnInfos.add(columnInfo);
		}
		return new TableInfoDTO(tableInfo, columnInfos);
	}

	private Map<String, String> convertIndexToMap(List<Index> indexes) {
		Map<String, String> columnIndexMap = new HashMap<>();
		for (Index index : indexes) {
			String type = index.getType();
			List<Index.ColumnParams> columns = index.getColumns();
			for (Index.ColumnParams column : columns) {
				columnIndexMap.put(removeBackslash(column.getColumnName()), MysqlIndexTypeConvert.getType(type));
			}

		}
		return columnIndexMap;
	}

	private String removeBackslash(String source) {
		return source.replaceAll("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~{}\"]", "");
	}

	/**
	 * 决定是否可以为空
	 * @param columnSpecs
	 * @return
	 */
	private String decideNullAble(List<String> columnSpecs) {
		int not_null = PlainSelect.getStringList(columnSpecs, false, false).indexOf("NOT NULL");
		return not_null != -1 ? "NO" : "YES";
	}

	private String convertColumnType(String dataType, List<String> argumentsStringList) {
		return dataType + " " + PlainSelect.getStringList(argumentsStringList, true, true);
	}

	private String extractColumnOptionsToString(List<String> columnSpecs) {
		return PlainSelect.getStringList(columnSpecs, false, false);

	}

	private String extractColumnOptionsToString(List<String> columnSpecs, String keyword) {
		String result = "";
		for (int i = 0; i < columnSpecs.size(); i++) {
			String key = columnSpecs.get(i);
			if (key.equals(keyword)) {
				result = removeBackslash(columnSpecs.get(i + 1));
				return result;
			}
		}
		return result;

	}

	Map<String, String> extractTableOptions(List<String> data) {
		String stringList = PlainSelect.getStringList(data, true, false);
		String[] elements = stringList.replaceAll(" ", "").replaceAll("DEFAULT,CHARSET", "DEFAULT CHARSET")
				.split(",=,");

		SimpleNode rootNode = new SimpleNode();
		SimpleNode tmpNode = new SimpleNode();

		for (int i = 0; i < elements.length; i += 2) {
			if (i == 0) {
				// 第一次
				// 当前key
				String element = elements[i];
				// 下一项 值内容表式 当前项的值,下一项的key
				String nextElement = elements[i + 1];
				String[] keyValue = nextElement.split(",");
				rootNode.setKey(element);
				rootNode.setVal(keyValue[0]);
				tmpNode = new SimpleNode();
				tmpNode.setKey(keyValue[1]);
				rootNode.setNext(tmpNode);

			}
			else if (i + 2 >= elements.length) {
				String element = elements[i];
				String lastValue = elements[i + 1];
				String[] keyValue = element.split(",");
				tmpNode.setVal(keyValue[0]);
				SimpleNode nextNode = new SimpleNode();
				nextNode.setKey(keyValue[1]);
				nextNode.setVal(lastValue);
				tmpNode.setNext(nextNode);
				tmpNode = null;
			}
			else {
				String element = elements[i];
				String[] keyValue = element.split(",");
				tmpNode.setVal(keyValue[0]);
				SimpleNode nextNode = new SimpleNode();
				nextNode.setKey(keyValue[1]);
				tmpNode.setNext(nextNode);
				tmpNode = nextNode;
			}
		}
		Map<String, String> tableOptionMap = new HashMap<>();
		return convertToMap(rootNode, tableOptionMap);

	}

	private Map<String, String> convertToMap(SimpleNode node, Map<String, String> dataMap) {
		if (node != null) {
			dataMap.put(node.getKey(), node.getVal());
			return convertToMap(node.getNext(), dataMap);
		}
		return dataMap;
	}

	@Data
	static class SimpleNode {

		private String key;

		private String val;

		private SimpleNode next;

	}

}
