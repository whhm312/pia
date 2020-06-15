package com.pines.student.study.vo;

public class StudySchedulesResponse {
	private int studySeq;
	private int branchSeq;
	private int campusSeq;
	private int termDetailSeq;
	private String branch;
	private String campus;
	private String term;
	private String writer;
	private String updateDate;

	public int getStudySeq() {
		return studySeq;
	}

	public void setStudySeq(int studySeq) {
		this.studySeq = studySeq;
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

	public int getCampusSeq() {
		return campusSeq;
	}

	public void setCampusSeq(int campusSeq) {
		this.campusSeq = campusSeq;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int getTermDetailSeq() {
		return termDetailSeq;
	}

	public void setTermDetailSeq(int termDetailSeq) {
		this.termDetailSeq = termDetailSeq;
	}

	@Override
	public String toString() {
		return "StudySchedulesResponse [studySeq=" + studySeq + ", branchSeq=" + branchSeq + ", campusSeq=" + campusSeq + ", termDetailSeq=" + termDetailSeq + ", branch=" + branch + ", campus=" + campus + ", term=" + term + ", writer=" + writer + ", updateDate=" + updateDate + "]";
	}

}
