package com.relaxed.samples.cache.service;

/**
 * @author Yakir
 * @Topic CacheService
 * @Description
 * @date 2021/7/24 14:13
 * @Version 1.0
 */
public interface CacheService {

	/**
	 * 带条件选则是否缓存
	 * @param param
	 * @return
	 */
	String cacheLockCondition(Integer param);

	/**
	 * 指定前缀
	 * @param param
	 * @return
	 */
	String cacheLockPrefix(Integer param);

	/**
	 * 指定后缀
	 * @param param
	 * @return
	 */
	String cacheLockSuffix(Integer param);

	/**
	 * 指定前缀后缀
	 * @param param
	 * @return
	 */
	String cacheLockPrefixSuffix(Integer param);

	/**
	 * 指定keygenerator
	 * @param param
	 * @return
	 */
	String cacheLockKeyGenerator(Integer param);

	/**
	 * 指定超时 -1 永不超时 0 使用全局默认超时
	 * @param param
	 * @return
	 */
	String cacheLockKeyTime(Integer param);

	/**
	 * 缓存删除
	 * @param param
	 * @return
	 */
	String cacheDel(Integer param);

	/**
	 * 缓存put
	 * @param param
	 * @return
	 */
	String cachePut(Integer param);

	/**
	 * 无缓存
	 * @param param
	 * @return
	 */
	String noCache(Integer param);

	/**
	 * 缓存操作
	 * @param key
	 * @param param
	 * @param timeout
	 * @return
	 */
	String cacheSet(String key, String param, Long timeout);

	/**
	 * 缓存查询
	 * @author yakir
	 * @date 2022/6/13 16:00
	 * @param key
	 * @return java.lang.String
	 */
	String cacheGet(String key);

	/**
	 * 缓存删除
	 * @author yakir
	 * @date 2022/6/13 16:01
	 * @param key
	 * @return java.lang.String
	 */
	String cacheDelete(String key);

}
