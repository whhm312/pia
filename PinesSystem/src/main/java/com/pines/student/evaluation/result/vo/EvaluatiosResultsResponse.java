package com.pines.student.evaluation.result.vo;

public class EvaluatiosResultsResponse {
	private int evalutaionSeq;
	private String branch;
	private String term;
	private int answerCount;
	private int termStudentCount;

	public int getEvalutaionSeq() {
		return evalutaionSeq;
	}

	public void setEvalutaionSeq(int evalutaionSeq) {
		this.evalutaionSeq = evalutaionSeq;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public int getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}

	public int getTermStudentCount() {
		return termStudentCount;
	}

	public void setTermStudentCount(int termStudentCount) {
		this.termStudentCount = termStudentCount;
	}

	@Override
	public String toString() {
		return "EvaluatiosResultsResponse [evalutaionSeq=" + evalutaionSeq + ", branch=" + branch + ", term=" + term + ", answerCount=" + answerCount + ", termStudentCount=" + termStudentCount + "]";
	}

}
