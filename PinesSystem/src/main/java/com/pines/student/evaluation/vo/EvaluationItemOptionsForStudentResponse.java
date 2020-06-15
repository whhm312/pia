package com.pines.student.evaluation.vo;

public class EvaluationItemOptionsForStudentResponse {
	private int optionSeq;
	private String optionContent;

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

	@Override
	public String toString() {
		return "EvaluationItemOptionsForStudentResponse [optionSeq=" + optionSeq + ", optionContent=" + optionContent + "]";
	}

}
