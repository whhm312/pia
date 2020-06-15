package com.pines.student.evaluation.vo;

import java.util.List;

public class EvaluationItemsResponse {
	private int evaluationItemSeq;
	private int evaluationGroupSeq;
	private int languageSeq;
	private String language;
	private int orderNo;
	private String itemContent;
	private String optionType;
	private List<EvaluationItemOptionsResponse> options;

	public int getEvaluationItemSeq() {
		return evaluationItemSeq;
	}

	public void setEvaluationItemSeq(int evaluationItemSeq) {
		this.evaluationItemSeq = evaluationItemSeq;
	}

	public int getEvaluationGroupSeq() {
		return evaluationGroupSeq;
	}

	public void setEvaluationGroupSeq(int evaluationGroupSeq) {
		this.evaluationGroupSeq = evaluationGroupSeq;
	}

	public int getLanguageSeq() {
		return languageSeq;
	}

	public void setLanguageSeq(int languageSeq) {
		this.languageSeq = languageSeq;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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

	public List<EvaluationItemOptionsResponse> getOptions() {
		return options;
	}

	public void setOptions(List<EvaluationItemOptionsResponse> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "EvaluationItemsResponse [evaluationItemSeq=" + evaluationItemSeq + ", evaluationGroupSeq=" + evaluationGroupSeq + ", languageSeq=" + languageSeq + ", language=" + language + ", orderNo=" + orderNo + ", itemContent=" + itemContent + ", optionType=" + optionType
				+ ", options=" + options + "]";
	}

}
