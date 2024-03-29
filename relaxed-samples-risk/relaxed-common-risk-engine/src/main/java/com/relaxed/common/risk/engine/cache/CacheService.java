package com.relaxed.common.risk.engine.cache;

import org.checkerframework.checker.units.qual.K;

/**
 * @author Yakir
 * @Topic CacheService
 * @Description 本地缓存实现 三级缓存
 * @date 2021/8/29 9:10
 * @Version 1.0
 */
public interface CacheService {

	/**
	 * 根据key查询
	 * @author yakir
	 * @date 2021/8/29 9:11
	 * @param key
	 * @return T
	 */
	<V> V get(String key);

	/**
	 * 放入缓存
	 * @author yakir
	 * @date 2021/8/29 9:12
	 * @param key
	 * @param obj
	 * @return boolean
	 */
	default <V> void put(String key, V obj) {
		put(key, obj, null);
	};

	<V> void put(String key, V obj, Long expireTime);

	/**
	 * 根据key删除
	 * @author yakir
	 * @date 2021/8/29 9:12
	 * @param key
	 */
	void del(String key);

}
