package com.pines.student.evaluation.vo;

import java.util.List;

public class EvaluationResponse {
	private int evaluationSeq;
	private int branchSeq;
	private String branch;
	private String summary;
	private String registerDate;
	private String writer;
	private List<EvaluationItemsResponse> items;

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

	public List<EvaluationItemsResponse> getItems() {
		return items;
	}

	public void setItems(List<EvaluationItemsResponse> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "EvaluationResponse [evaluationSeq=" + evaluationSeq + ", branchSeq=" + branchSeq + ", branch=" + branch + ", summary=" + summary + ", registerDate=" + registerDate + ", writer=" + writer + ", items=" + items + "]";
	}

}
