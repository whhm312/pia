package com.pines.student.common.vo;

import java.util.List;

public class Evaluation {
	private int totalCount;
	private int evaluationSeq;
	private int branchSeq;
	private String branch;
	private boolean isDeleted;
	private String registerDate;
	private String formRegisterDate;
	private String staffId;
	private String writer;
	private String summary;
	private List<EvaluationItem> items;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

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

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<EvaluationItem> getItems() {
		return items;
	}

	public void setItems(List<EvaluationItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Evaluation [totalCount=" + totalCount + ", evaluationSeq=" + evaluationSeq + ", branchSeq=" + branchSeq + ", branch=" + branch + ", isDeleted=" + isDeleted + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + ", staffId=" + staffId
				+ ", writer=" + writer + ", summary=" + summary + ", items=" + items + "]";
	}

}
