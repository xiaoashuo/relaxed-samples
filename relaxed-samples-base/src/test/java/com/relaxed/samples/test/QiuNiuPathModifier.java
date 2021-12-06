package com.relaxed.samples.test;

import com.relaxed.common.oss.s3.modifier.PathModifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Yakir
 * @Topic QiuNiuPathModifier
 * @Description
 * @date 2021/12/6 11:55
 * @Version 1.0
 */
@Component
public class QiuNiuPathModifier implements PathModifier {

	/**
	 * 七牛对应域名
	 */
	private final String useDomain = "http://r3o8poe9a.hn-bkt.clouddn.com";

	@Override
	public String getDownloadUrl(String domain, String bucket, String downloadPrefix, String relativePath) {
		return StringUtils.hasText(domain) ? String.format("%s/%s/%s", downloadPrefix, bucket, relativePath)
				: String.format("%s/%s", useDomain, relativePath);
	}

}
