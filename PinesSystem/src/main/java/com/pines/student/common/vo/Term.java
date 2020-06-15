package com.pines.student.common.vo;

public class Term {
	private int totalCount;
	private int termSeq;
	private int branchSeq;
	private String term;
	private String startDate;
	private String endDate;
	private String formStartDate;
	private String formEndDate;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTermSeq() {
		return termSeq;
	}

	public void setTermSeq(int termSeq) {
		this.termSeq = termSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getFormStartDate() {
		return formStartDate;
	}

	public void setFormStartDate(String formStartDate) {
		this.formStartDate = formStartDate;
	}

	public String getFormEndDate() {
		return formEndDate;
	}

	public void setFormEndDate(String formEndDate) {
		this.formEndDate = formEndDate;
	}

	@Override
	public String toString() {
		return "Term [totalCount=" + totalCount + ", termSeq=" + termSeq + ", branchSeq=" + branchSeq + ", term=" + term + ", startDate=" + startDate + ", endDate=" + endDate + ", formStartDate=" + formStartDate + ", formEndDate=" + formEndDate + "]";
	}

}
