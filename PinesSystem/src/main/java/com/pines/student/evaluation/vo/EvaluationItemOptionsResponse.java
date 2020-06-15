package com.pines.student.evaluation.vo;

public class EvaluationItemOptionsResponse {
	private int optionSeq;
	private String optionContent;
	private int orderNo;
	private int optionNo;

	public int getOptionSeq() {
		return optionSeq;
	}

	public void setOptionSeq(int optionSeq) {
		this.optionSeq = optionSeq;
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

	public int getOptionNo() {
		return optionNo;
	}

	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}

	@Override
	public String toString() {
		return "EvaluationItemOptionsResponse [optionSeq=" + optionSeq + ", optionContent=" + optionContent + ", orderNo=" + orderNo + ", optionNo=" + optionNo + "]";
	}

}
