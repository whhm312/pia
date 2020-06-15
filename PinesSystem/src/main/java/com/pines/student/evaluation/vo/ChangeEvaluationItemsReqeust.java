package com.pines.student.evaluation.vo;

import java.util.List;

public class ChangeEvaluationItemsReqeust {
	private int evaluationItemSeq;
	private boolean isDeleted;
	private int evaluationGroupSeq;
	private int languageSeq;
	private int orderNo;
	private String itemContent;
	private String optionType;
	private List<ChangeEvaluationItemOptionsRequest> options;
	private boolean isEditedOptions;

	public int getEvaluationItemSeq() {
		return evaluationItemSeq;
	}

	public void setEvaluationItemSeq(int evaluationItemSeq) {
		this.evaluationItemSeq = evaluationItemSeq;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	public List<ChangeEvaluationItemOptionsRequest> getOptions() {
		return options;
	}

	public void setOptions(List<ChangeEvaluationItemOptionsRequest> options) {
		this.options = options;
	}

	public boolean getIsEditedOptions() {
		return isEditedOptions;
	}

	public void setIsEditedOptions(boolean isEditedOptions) {
		this.isEditedOptions = isEditedOptions;
	}

	@Override
	public String toString() {
		return "ChangeEvaluationItemsReqeust [evaluationItemSeq=" + evaluationItemSeq + ", isDeleted=" + isDeleted + ", evaluationGroupSeq=" + evaluationGroupSeq + ", languageSeq=" + languageSeq + ", orderNo=" + orderNo + ", itemContent=" + itemContent + ", optionType="
				+ optionType + ", options=" + options + ", isEditedOptions=" + isEditedOptions + "]";
	}

}
