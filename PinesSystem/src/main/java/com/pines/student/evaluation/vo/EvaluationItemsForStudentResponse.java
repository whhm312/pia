package com.pines.student.evaluation.vo;

import java.util.List;

public class EvaluationItemsForStudentResponse {
	private int evaluationItemSeq;
	private String itemContent;
	private String optionType;
	private List<EvaluationItemOptionsForStudentResponse> options;

	public int getEvaluationItemSeq() {
		return evaluationItemSeq;
	}

	public void setEvaluationItemSeq(int evaluationItemSeq) {
		this.evaluationItemSeq = evaluationItemSeq;
	}

	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public List<EvaluationItemOptionsForStudentResponse> getOptions() {
		return options;
	}

	public void setOptions(List<EvaluationItemOptionsForStudentResponse> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "EvaluationItemsForStudentResponse [evaluationItemSeq=" + evaluationItemSeq + ", itemContent=" + itemContent + ", optionType=" + optionType + ", options=" + options + "]";
	}

}
