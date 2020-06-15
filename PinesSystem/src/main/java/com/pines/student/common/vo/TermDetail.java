package com.pines.student.common.vo;

public class TermDetail {
	private int totalCount;
	private int termDetailSeq;
	private int termSeq;
	private int branchSeq;
	private String termName;
	private String startDate;
	private String endDate;
	private String formStartDate;
	private String formEndDate;
	private boolean isDeleted;
	private String registerDate;
	private String formRegisterDate;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTermDetailSeq() {
		return termDetailSeq;
	}

	public void setTermDetailSeq(int termDetailSeq) {
		this.termDetailSeq = termDetailSeq;
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

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
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

	@Override
	public String toString() {
		return "TermDetail [totalCount=" + totalCount + ", termDetailSeq=" + termDetailSeq + ", termSeq=" + termSeq + ", branchSeq=" + branchSeq + ", termName=" + termName + ", startDate=" + startDate + ", endDate=" + endDate + ", formStartDate=" + formStartDate
				+ ", formEndDate=" + formEndDate + ", isDeleted=" + isDeleted + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + "]";
	}

}
