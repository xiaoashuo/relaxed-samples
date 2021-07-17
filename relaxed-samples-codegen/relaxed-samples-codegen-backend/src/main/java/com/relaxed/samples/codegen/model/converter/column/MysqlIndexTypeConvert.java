package com.relaxed.samples.codegen.model.converter.column;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yakir
 * @Topic IndexTypeConvert
 * @Description 将jparser 的索引类型 转换为 mysql
 * @date 2021/7/17 16:01
 * @Version 1.0
 */
public class MysqlIndexTypeConvert {

	private static Map<String, String> INDEX_MAP = new HashMap<>();
	static {
		INDEX_MAP.put("PRIMARY KEY", "PRI");
	}

	/**
	 * 获取数据库的索引类型
	 * @param jsqlIndexKey
	 * @return
	 */
	public static String getType(String jsqlIndexKey) {
		return INDEX_MAP.getOrDefault(jsqlIndexKey, "UNKNOWN");
	}

}
