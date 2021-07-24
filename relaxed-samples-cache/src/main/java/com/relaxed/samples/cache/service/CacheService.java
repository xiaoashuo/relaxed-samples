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

}
