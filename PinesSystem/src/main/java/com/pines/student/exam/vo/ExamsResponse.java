package com.pines.student.exam.vo;

public class ExamsResponse {
	private int examSeq;
	private int branchSeq;
	private int campusSeq;
	private int termSeq;
	private String branch;
	private String campus;
	private String term;
	private String examType;
	private String examStartDate;
	private int saveResultCount;
	private String updateDate;

	public int getExamSeq() {
		return examSeq;
	}

	public void setExamSeq(int examSeq) {
		this.examSeq = examSeq;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public String getExamStartDate() {
		return examStartDate;
	}

	public void setExamStartDate(String examStartDate) {
		this.examStartDate = examStartDate;
	}

	public int getSaveResultCount() {
		return saveResultCount;
	}

	public void setSaveResultCount(int saveResultCount) {
		this.saveResultCount = saveResultCount;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getCampusSeq() {
		return campusSeq;
	}

	public void setCampusSeq(int campusSeq) {
		this.campusSeq = campusSeq;
	}

	public int getTermSeq() {
		return termSeq;
	}

	public void setTermSeq(int termSeq) {
		this.termSeq = termSeq;
	}

	@Override
	public String toString() {
		return "ExamsResponse [examSeq=" + examSeq + ", branchSeq=" + branchSeq + ", campusSeq=" + campusSeq + ", termSeq=" + termSeq + ", branch=" + branch + ", campus=" + campus + ", term=" + term + ", examType=" + examType + ", examStartDate=" + examStartDate
				+ ", saveResultCount=" + saveResultCount + ", updateDate=" + updateDate + "]";
	}

}
