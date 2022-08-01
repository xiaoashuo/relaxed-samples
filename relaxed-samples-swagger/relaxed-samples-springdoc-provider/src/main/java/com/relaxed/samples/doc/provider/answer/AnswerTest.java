package com.relaxed.samples.doc.provider.answer;

import cn.hutool.core.lang.id.NanoId;
import cn.hutool.json.JSONUtil;
import com.relaxed.samples.doc.provider.answer.SurveySchema.Attribute;
import com.relaxed.samples.doc.provider.answer.SurveySchema.QuestionType;
import com.relaxed.samples.doc.provider.answer.SurveySchema;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yakir
 * @Topic AnswerTest
 * @Description
 * @date 2022/6/16 18:15
 * @Version 1.0
 */
public class AnswerTest {

	public static void main(String[] args) {
		SurveySchema surveySchema = new SurveySchema();
		surveySchema.setId("qs");
		surveySchema.setTitle("满意度调查问卷");
		surveySchema.setDescription("请根据您的使用情况，认真填写");
		surveySchema.setType(QuestionType.Survey);
		Attribute attribute = new Attribute();
		surveySchema.setAttribute(attribute);
		List<SurveySchema> childrens = new ArrayList<>();
		// 单选题
		SurveySchema radioSchema = new SurveySchema();
		radioSchema.setId("qsRadio");
		radioSchema.setTitle("你的性别?");
		radioSchema.setDescription("请选择你的性别");
		radioSchema.setType(QuestionType.Radio);
		radioSchema.setAttribute(new Attribute());
		ArrayList<SurveySchema> radioList = new ArrayList<>();
		SurveySchema radioValue = new SurveySchema();
		radioValue.setTitle("男");
		radioValue.setId("qsV1");
		SurveySchema radioValue2 = new SurveySchema();
		radioValue2.setTitle("女");
		radioValue2.setId("qsV2");
		radioList.add(radioValue);
		radioList.add(radioValue2);
		radioSchema.setChildren(radioList);
		childrens.add(radioSchema);
		surveySchema.setChildren(childrens);

		String s = JSONUtil.toJsonStr(surveySchema);
		System.out.println(s);
		LinkedHashMap<String, String> answer = new LinkedHashMap<>();
		AnswerScoreEvaluator evaluator = new AnswerScoreEvaluator(surveySchema, answer);
		Double eval = evaluator.eval();

	}

	/**
	 * The default alphabet used by this class. Creates url-friendly NanoId Strings using
	 * 64 unique symbols. 去掉 l 避免和 1 产生视觉混淆
	 */
	public static final char[] DEFAULT_ALPHABET = "0123456789abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
			.toCharArray();

	public static String generateProjectId() {

		String projectId = NanoId.randomNanoId(null, DEFAULT_ALPHABET, 6);
		// 不要以数字开头，否则工作流 xml 保存会报错
		if (Character.isDigit(projectId.charAt(0))) {
			return generateProjectId();
		}
		// if (getById(projectId) != null) {
		// return generateProjectId();
		// }
		return projectId;
	}

}
