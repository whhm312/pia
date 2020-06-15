package com.pines.student.evaluation.vo;

public class ChangeEvaluationItemOptionsRequest {
	private int optionSeq;
	private boolean isDeleted;
	private int orderNo;
	private String optionContent;
	private int optionNo;

	public int getOptionSeq() {
		return optionSeq;
	}

	public void setOptionSeq(int optionSeq) {
		this.optionSeq = optionSeq;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public int getOptionNo() {
		return optionNo;
	}

	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}

	@Override
	public String toString() {
		return "ChangeEvaluationItemOptionsRequest [optionSeq=" + optionSeq + ", isDeleted=" + isDeleted + ", orderNo=" + orderNo + ", optionContent=" + optionContent + ", optionNo=" + optionNo + "]";
	}

}
