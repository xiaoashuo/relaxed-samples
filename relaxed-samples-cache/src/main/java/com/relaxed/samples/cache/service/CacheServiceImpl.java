package com.relaxed.samples.cache.service;


import cn.hutool.core.thread.ThreadUtil;
import com.relaxed.common.redis.RedisHelper;
import com.relaxed.common.redis.core.annotation.CacheDel;
import com.relaxed.common.redis.core.annotation.CachePut;
import com.relaxed.common.redis.core.annotation.Cached;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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



	@Override
	public String cacheSet(String key, String param, Long timeout) {
		RedisHelper.set(key, param, timeout);
		return "OK";
	}

	@Override
	public String cacheGet(String key) {
		String s = RedisHelper.get(key);
		return s;
	}

	@Override
	public String cacheDelete(String key) {
		RedisHelper.del(key);
		return "OK";
	}

	@Cached(prefix = "t", keyJoint = "#param")
	@Override
	public String lockRenewal(Integer param) {
		ThreadUtil.safeSleep(2*60*1000);
		return "success";
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
