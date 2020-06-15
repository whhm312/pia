package com.pines.student.common.vo;

public class EvaluationResult {
	private int totalCount;
	private int evalutaionSeq;
	private int branchSeq;
	private int termSeq;
	private String branch;
	private String term;
	private int answerCount;
	private int termStudentCount;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getEvalutaionSeq() {
		return evalutaionSeq;
	}

	public void setEvalutaionSeq(int evalutaionSeq) {
		this.evalutaionSeq = evalutaionSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getTermSeq() {
		return termSeq;
	}

	public void setTermSeq(int termSeq) {
		this.termSeq = termSeq;
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
		return "EvaluationResult [totalCount=" + totalCount + ", evalutaionSeq=" + evalutaionSeq + ", branchSeq=" + branchSeq + ", termSeq=" + termSeq + ", branch=" + branch + ", term=" + term + ", answerCount=" + answerCount + ", termStudentCount=" + termStudentCount + "]";
	}

}
