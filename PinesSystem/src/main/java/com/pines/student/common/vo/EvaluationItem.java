package com.pines.student.common.vo;

import java.util.List;

public class EvaluationItem {
	private int totalCount;
	private int evaluationItemSeq;
	private int evaluationSeq;
	private String optionType;
	private int orderNo;
	private String itemContent;
	private boolean isDeleted;
	private String registerDate;
	private String formRegisterDate;
	private List<EvaluationItemOption> options;
	private int evaluationGroupSeq;
	private int languageSeq;
	private String language;
	private boolean isEditedOptions;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getEvaluationItemSeq() {
		return evaluationItemSeq;
	}

	public void setEvaluationItemSeq(int evaluationItemSeq) {
		this.evaluationItemSeq = evaluationItemSeq;
	}

	public int getEvaluationSeq() {
		return evaluationSeq;
	}

	public void setEvaluationSeq(int evaluationSeq) {
		this.evaluationSeq = evaluationSeq;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
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

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public List<EvaluationItemOption> getOptions() {
		return options;
	}

	public void setOptions(List<EvaluationItemOption> options) {
		this.options = options;
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

	public boolean getIsEditedOptions() {
		return isEditedOptions;
	}

	public void setIsEditedOptions(boolean isEditedOptions) {
		this.isEditedOptions = isEditedOptions;
	}

	@Override
	public String toString() {
		return "EvaluationItem [totalCount=" + totalCount + ", evaluationItemSeq=" + evaluationItemSeq + ", evaluationSeq=" + evaluationSeq + ", optionType=" + optionType + ", orderNo=" + orderNo + ", itemContent=" + itemContent + ", isDeleted=" + isDeleted + ", registerDate="
				+ registerDate + ", formRegisterDate=" + formRegisterDate + ", options=" + options + ", evaluationGroupSeq=" + evaluationGroupSeq + ", languageSeq=" + languageSeq + ", language=" + language + ", isEditedOptions=" + isEditedOptions + "]";
	}

}
