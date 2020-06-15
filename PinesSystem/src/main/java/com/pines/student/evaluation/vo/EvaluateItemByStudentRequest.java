package com.pines.student.evaluation.vo;

public class EvaluateItemByStudentRequest {
	private int evaluationItemSeq;
	private int optionSeq;
	private String optionType;
	private String opinion;

	public int getEvaluationItemSeq() {
		return evaluationItemSeq;
	}

	public void setEvaluationItemSeq(int evaluationItemSeq) {
		this.evaluationItemSeq = evaluationItemSeq;
	}

	public int getOptionSeq() {
		return optionSeq;
	}

	public void setOptionSeq(int optionSeq) {
		this.optionSeq = optionSeq;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	@Override
	public String toString() {
		return "EvaluateItemByStudentRequest [evaluationItemSeq=" + evaluationItemSeq + ", optionSeq=" + optionSeq + ", optionType=" + optionType + ", opinion=" + opinion + "]";
	}

}
