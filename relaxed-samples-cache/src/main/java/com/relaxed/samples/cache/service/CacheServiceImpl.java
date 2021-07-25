package com.relaxed.samples.cache.service;

import com.relaxed.common.cache.annotation.CacheDel;
import com.relaxed.common.cache.annotation.CachePut;
import com.relaxed.common.cache.annotation.Cached;
import org.springframework.stereotype.Service;

/**
 * @author Yakir
 * @Topic CacheServiceImpl
 * @Description
 * @date 2021/7/24 14:13
 * @Version 1.0
 */
@Service
public class CacheServiceImpl implements CacheService {

	@Cached(key = "#param", condition = "#p0>1")
	@Override
	public String cacheLockCondition(Integer param) {
		return "testCondition";
	}

	@Cached(prefix = "t", key = "#param")
	@Override
	public String cacheLockPrefix(Integer param) {
		return null;
	}

	@Cached(key = "#param", suffix = "a")
	@Override
	public String cacheLockSuffix(Integer param) {
		return null;
	}

	@Cached(prefix = "b", key = "#param", suffix = "a")
	@Override
	public String cacheLockPrefixSuffix(Integer param) {
		return null;
	}

	@Cached(keyGenerator = "cacheKeyGenerator")
	@Override
	public String cacheLockKeyGenerator(Integer param) {
		return null;
	}

	@Cached(key = "'testTime'", ttl = 5000)
	@Override
	public String cacheLockKeyTime(Integer param) {
		return null;
	}

	@CacheDel(key = "'testTime'")
	@Override
	public String cacheDel(Integer param) {
		return null;
	}

	@CachePut(key = "'testTime'", ttl = -1)
	@Override
	public String cachePut(Integer param) {
		return "12";
	}

	@Override
	public String noCache(Integer param) {
		return "noCache";
	}

}
