package com.pines.student.common.vo;

public class Study {
	private int totalCount;
	private int studySeq;
	private int branchSeq;
	private int campusSeq;
	private int termDetailSeq;
	private int levelSeq;
	private String term;
	private String branch;
	private String campus;
	private String startDate;
	private String endDate;
	private String formStartDate;
	private String formEndDate;
	private String studentId;
	private String staffId;
	private String writer;
	private boolean isDeleted;
	private String registerDate;
	private String updateDate;
	private String formRegisterDate;
	private String formUpdateDate;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

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

	public int getCampusSeq() {
		return campusSeq;
	}

	public void setCampusSeq(int campusSeq) {
		this.campusSeq = campusSeq;
	}

	public int getTermDetailSeq() {
		return termDetailSeq;
	}

	public void setTermDetailSeq(int termDetailSeq) {
		this.termDetailSeq = termDetailSeq;
	}

	public int getLevelSeq() {
		return levelSeq;
	}

	public void setLevelSeq(int levelSeq) {
		this.levelSeq = levelSeq;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
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

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
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

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public String getFormUpdateDate() {
		return formUpdateDate;
	}

	public void setFormUpdateDate(String formUpdateDate) {
		this.formUpdateDate = formUpdateDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Study [totalCount=" + totalCount + ", studySeq=" + studySeq + ", branchSeq=" + branchSeq + ", campusSeq=" + campusSeq + ", termDetailSeq=" + termDetailSeq + ", levelSeq=" + levelSeq + ", term=" + term + ", branch=" + branch + ", campus=" + campus + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", formStartDate=" + formStartDate + ", formEndDate=" + formEndDate + ", studentId=" + studentId + ", staffId=" + staffId + ", writer=" + writer + ", isDeleted=" + isDeleted + ", registerDate=" + registerDate + ", updateDate="
				+ updateDate + ", formRegisterDate=" + formRegisterDate + ", formUpdateDate=" + formUpdateDate + "]";
	}

}
