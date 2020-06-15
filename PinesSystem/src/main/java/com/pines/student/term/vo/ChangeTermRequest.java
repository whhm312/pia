package com.pines.student.term.vo;

import com.pines.student.common.vo.Term;

public class ChangeTermRequest {
	private int branchSeq;
	private int termSeq;
	private String name;
	private String startDate;
	private String endDate;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Term getTerm() {
		Term term = new Term();
		term.setBranchSeq(branchSeq);
		term.setTermSeq(termSeq);
		term.setTerm(name);
		term.setStartDate(startDate);
		term.setEndDate(endDate);
		return term;
	}

	@Override
	public String toString() {
		return "ChangeTermRequest [branchSeq=" + branchSeq + ", termSeq=" + termSeq + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
