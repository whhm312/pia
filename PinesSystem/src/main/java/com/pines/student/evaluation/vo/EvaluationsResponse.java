package com.pines.student.evaluation.vo;

public class EvaluationsResponse {
	private int evaluationSeq;
	private int branchSeq;
	private String branch;
	private String summary;
	private String registerDate;
	private String writer;

	public int getEvaluationSeq() {
		return evaluationSeq;
	}

	public void setEvaluationSeq(int evaluationSeq) {
		this.evaluationSeq = evaluationSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "EvaluationsResponse [evaluationSeq=" + evaluationSeq + ", branchSeq=" + branchSeq + ", branch=" + branch + ", summary=" + summary + ", registerDate=" + registerDate + ", writer=" + writer + "]";
	}

}
