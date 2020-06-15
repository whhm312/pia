package com.pines.student.common.vo;

public class EvaluationItemOption {
	private int totalCount;
	private int optionSeq;
	private int evaluationItemSeq;
	private String optionContent;
	private int orderNo;
	private boolean isDeleted;
	private String registerDate;
	private String formRegisterDate;
	private int optionNo;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getOptionSeq() {
		return optionSeq;
	}

	public void setOptionSeq(int optionSeq) {
		this.optionSeq = optionSeq;
	}

	public int getEvaluationItemSeq() {
		return evaluationItemSeq;
	}

	public void setEvaluationItemSeq(int evaluationItemSeq) {
		this.evaluationItemSeq = evaluationItemSeq;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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

	public int getOptionNo() {
		return optionNo;
	}

	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}

	@Override
	public String toString() {
		return "EvaluationItemOption [totalCount=" + totalCount + ", optionSeq=" + optionSeq + ", evaluationItemSeq=" + evaluationItemSeq + ", optionContent=" + optionContent + ", orderNo=" + orderNo + ", isDeleted=" + isDeleted + ", registerDate=" + registerDate
				+ ", formRegisterDate=" + formRegisterDate + ", optionNo=" + optionNo + "]";
	}

}
