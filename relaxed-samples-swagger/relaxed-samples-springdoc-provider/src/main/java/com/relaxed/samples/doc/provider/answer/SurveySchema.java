package com.relaxed.samples.doc.provider.answer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.List;

/**
 * @author Yakir
 * @Topic SurveySchema
 * @Description
 * @date 2022/6/16 18:03
 * @Version 1.0
 */
@Data
public class SurveySchema {

	/**
	 * 问卷id
	 */
	private String id;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 描述
	 */
	private String description;

	private QuestionType type;

	private Attribute attribute;

	/**
	 * 问卷选项
	 */
	private List<SurveySchema> children;

	public enum QuestionType {

		FillBlank, Textarea, MultipleBlank, Signature, Score, Radio, Checkbox, Select, Cascader, Upload, MatrixAuto, MatrixRadio, MatrixCheckbox, MatrixFillBlank, MatrixScore, MatrixNps, Survey, QuestionSet, Pagination, Remark, SplitLine, Option, User, Dept, Nps, HorzBlank, Address;

		/**
		 * 分为数据类型和空类型
		 * @return
		 */
		public static EnumSet<QuestionType> dataType() {
			return EnumSet.of(FillBlank, Textarea, MultipleBlank, Signature, Score, Radio, Checkbox, Select, Cascader,
					Upload, MatrixAuto, MatrixRadio, MatrixCheckbox, MatrixFillBlank, MatrixScore, MatrixNps, User,
					Dept, Nps, HorzBlank, Address);
		}

		public static EnumSet<QuestionType> voidType() {
			return EnumSet.of(Survey, QuestionSet, Pagination, Remark, SplitLine, Option);
		}

		/**
		 * 考试自动计分支持题型
		 * @return
		 */
		public static EnumSet<QuestionType> examType() {
			return EnumSet.of(FillBlank, Textarea, MultipleBlank, Radio, Checkbox, Select, HorzBlank);
		}

	}

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Attribute implements Serializable {

		/**
		 * none/visible/hidden
		 */
		private String display;

		private Boolean hidden;

		private Integer width;

		private String dataType;

		private Boolean required;

		private Boolean defaultChecked;

		private Boolean readOnly;

		/**
		 * 文字长度限制 [1,2] [,5]
		 */
		private String textLimit;

		/**
		 * 多选答案数量限制 [1, 2] [,3]
		 */
		private String answerLimit;

		private String submitButton;

		/**
		 * 显示隐藏规则
		 */
		private String visibleRule;

		/**
		 * 必填校验规则
		 */
		private String requiredRule;

		/**
		 * 文本替换规则
		 */
		private String replaceTextRule;

		/**
		 * 校验规则
		 */
		private String validateRule;

		/**
		 * 计算规则
		 */
		private String calculate;

		/**
		 * 多选题选项排他
		 */
		private RejectOtherOption rejectOtherOption;

		/**
		 * 分值
		 */
		private Double examScore;

		/**
		 * 计分方式
		 */
		private ExamScoreMode examAnswerMode;

		/**
		 * 答案匹配规则
		 */
		private ExamMatchRule examMatchRule;

		/**
		 * 考试正确答案，当前选项 id 或者文本
		 */
		private String examCorrectAnswer;

		/**
		 * 答案解析
		 */
		private String examAnalysis;

	}

	public enum ExamMatchRule {

		/** 与答案完全相同才得分 */
		completeSame,
		/** 包含答案，多个答案分号间隔 */
		contain

	}

	public enum RejectOtherOption {

		/**
		 * 选项排他
		 */
		rejectAll,
		/**
		 * 排他选项互斥
		 */
		rejectOther

	}

	public enum ExamScoreMode {

		/** 只有一个选项 */
		onlyOne,
		/** 精确匹配，全部选对得分 */
		selectAll,
		/** 答对几项得几分，打错不得分(单选、多选、下拉) 答对几项得几分(填空) */
		selectCorrect,
		/** 部分选中，按选中分值算分/按选中计分 */
		select,
		/** 人工打分 */
		manual,
		/** 非考试题型 */
		none

	}

}
