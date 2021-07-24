package com.relaxed.samples.cache.controller;

import com.relaxed.common.core.result.R;
import com.relaxed.samples.cache.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yakir
 * @Topic CacheController
 * @Description
 * @date 2021/7/24 14:15
 * @Version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/cache")
public class CacheController {

	private final CacheService cacheService;

	/**
	 * 根据条件决定是否缓存
	 * @param param
	 * @return
	 */
	@GetMapping("/lock/condition")
	public String cacheLockCondition(Integer param) {
		return cacheService.cacheLockCondition(param);
	}

	/**
	 * 带前缀缓存
	 * @param param
	 * @return
	 */
	@GetMapping("/lock/prefix")
	public String cacheLockPrefix(Integer param) {
		return cacheService.cacheLockPrefix(param);
	}

	@GetMapping("/lock/suffix")
	public String cacheLockSuffix(Integer param) {
		return cacheService.cacheLockSuffix(param);
	}

	@GetMapping("/lock/all")
	public String cacheLockPrefixSuffix(Integer param) {
		return cacheService.cacheLockPrefixSuffix(param);
	}

	@GetMapping("/lock/gen")
	public String cacheLockKeyGenerator(Integer param) {
		return cacheService.cacheLockKeyGenerator(param);
	}

	@GetMapping("/lock/time")
	public String cacheLockKeyTime(Integer param) {
		return cacheService.cacheLockKeyTime(param);
	}

	@GetMapping("/lock/del")
	public String cacheDel(Integer param) {
		return cacheService.cacheDel(param);
	}

	@GetMapping("/lock/put")
	public String cachePut(Integer param) {
		return cacheService.cachePut(param);
	}
	@GetMapping("/lock/no")
	public String cacheNo(Integer param) {
		return cacheService.noCache(param);
	}
}
