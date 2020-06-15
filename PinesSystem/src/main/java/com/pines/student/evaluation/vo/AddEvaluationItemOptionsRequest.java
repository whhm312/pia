package com.pines.student.evaluation.vo;

public class AddEvaluationItemOptionsRequest {
	private int orderNo;
	private String optionContent;
	private int optionNo;

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
		return "AddEvaluationItemOptionsRequest [orderNo=" + orderNo + ", optionContent=" + optionContent + ", optionNo=" + optionNo + "]";
	}

}
