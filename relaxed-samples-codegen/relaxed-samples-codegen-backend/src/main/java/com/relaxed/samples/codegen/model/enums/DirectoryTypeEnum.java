package com.relaxed.samples.codegen.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 文件类型
 * @author Yakir
 * @since 2021/3/15
 */
@Getter
@RequiredArgsConstructor
public enum DirectoryTypeEnum {

	/**
	 * 文件夹
	 */
	FOLDER(1),
	/**
	 * 文件
	 */
	FILE(2);

	private final Integer type;

}
