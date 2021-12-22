package com.relaxed.samples.test;

import lombok.Data;

import java.util.List;

/**
 * @author Yakir
 * @Topic TestData
 * @Description
 * @date 2021/12/6 12:30
 * @Version 1.0
 */
@Data
public class TestData {

	/**
	 * 信托计划名称
	 */
	private String trustPlanName;

	/**
	 * 信托计划标题
	 */
	private String title;

	/**
	 * 项目开始日期 2021/12/05
	 */
	private String projectStartDate;

	/**
	 * 项目结束日期
	 */
	private String projectEndDate;

	/**
	 * 预估人日 = 结束-开始 天数
	 */
	private String estimatedPersonDay;

	/**
	 * 开发人员
	 */
	private String developer;

	/**
	 * 需求概述
	 */
	private List<TaskDetail> headTask;

	/**
	 * 核心功能
	 */
	private List<TaskDetail> contentTask;

	/**
	 * 项目发布
	 */
	private TaskDetail projectPublish;

	@Data
	public static class TaskDetail {

		/**
		 * 任务名称
		 *
		 *
		 *
		 *
		 *
		 */
		private String taskName;

		/**
		 * 进度
		 */
		private String progressRate;

		private String taskStartDate;

		private String taskEndDate;

		/**
		 * 预估人日
		 */
		private String estimatedPersonDay;

	}

}
