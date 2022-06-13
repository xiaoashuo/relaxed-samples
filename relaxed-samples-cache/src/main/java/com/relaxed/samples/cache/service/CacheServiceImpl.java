package com.relaxed.samples.cache.service;

import com.relaxed.common.cache.CacheManage;
import com.relaxed.common.cache.annotation.CacheDel;
import com.relaxed.common.cache.annotation.CachePut;
import com.relaxed.common.cache.annotation.Cached;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Yakir
 * @Topic CacheServiceImpl
 * @Description
 * @date 2021/7/24 14:13
 * @Version 1.0
 */
@RequiredArgsConstructor
@Service
public class CacheServiceImpl implements CacheService {

	private final CacheManage<String> cacheManage;

	@Override
	public String cacheSet(String key, String param, Long timeout) {
		cacheManage.set(key, param, timeout);
		return "OK";
	}

	@Override
	public String cacheGet(String key) {
		String s = cacheManage.get(key);
		return s;
	}

	@Override
	public String cacheDelete(String key) {
		cacheManage.remove(key);
		return "OK";
	}

	@Cached(keyJoint = "#param", condition = "#p0>1")
	@Override
	public String cacheLockCondition(Integer param) {
		return "testCondition";
	}

	@Cached(prefix = "t", keyJoint = "#param")
	@Override
	public String cacheLockPrefix(Integer param) {
		return null;
	}

	@Cached(keyJoint = "#param+'a'")
	@Override
	public String cacheLockSuffix(Integer param) {
		return null;
	}

	@Cached(prefix = "b", keyJoint = "#param+'a'")
	@Override
	public String cacheLockPrefixSuffix(Integer param) {
		return null;
	}

	@Cached
	@Override
	public String cacheLockKeyGenerator(Integer param) {
		return null;
	}

	@Cached(keyJoint = "'testTime'", ttl = 5000)
	@Override
	public String cacheLockKeyTime(Integer param) {
		return null;
	}

	@CacheDel(keyJoint = "#param")
	@Override
	public String cacheDel(Integer param) {
		return null;
	}

	@CachePut(keyJoint = "#param", ttl = -1)
	@Override
	public String cachePut(Integer param) {
		return "12";
	}

	@Override
	public String noCache(Integer param) {
		return "noCache";
	}

}
