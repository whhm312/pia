package com.pines.student.evaluation.vo;

import java.util.List;

public class AddEvaluationItemsReqeust {
	private int evaluationGroupSeq;
	private int languageSeq;
	private int orderNo;
	private String itemContent;
	private String optionType;
	private List<AddEvaluationItemOptionsRequest> options;

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

	public List<AddEvaluationItemOptionsRequest> getOptions() {
		return options;
	}

	public void setOptions(List<AddEvaluationItemOptionsRequest> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "AddEvaluationItemsReqeust [evaluationGroupSeq=" + evaluationGroupSeq + ", languageSeq=" + languageSeq + ", orderNo=" + orderNo + ", itemContent=" + itemContent + ", optionType=" + optionType + ", options=" + options + "]";
	}

}
