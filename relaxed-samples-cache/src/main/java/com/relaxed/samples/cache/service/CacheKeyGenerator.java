package com.relaxed.samples.cache.service;

import com.relaxed.common.cache.core.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Yakir
 * @Topic CacheKeyGenerator
 * @Description
 * @date 2021/7/24 17:03
 * @Version 1.0
 */
@Component
public class CacheKeyGenerator implements KeyGenerator {

	@Override
	public String generate(Object o, Method method, Object... objects) {
		return o.getClass().getName().toLowerCase();
	}

}
