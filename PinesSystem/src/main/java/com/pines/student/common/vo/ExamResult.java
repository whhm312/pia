package com.pines.student.common.vo;

public class ExamResult {
	private int totalCount;
	private int examResultSeq;
	private int examSeq;
	private String level;
	private String studentId;
	private String resultFilePath;
	private String staffId;
	private String registerDate;
	private String formRegisterDate;
	private boolean isDeleted;
	private String deleteDate;
	private String formDeleteDate;
	private String studentName;
	private int levelSeq;
	private String birthday;
	private String term;
	private String examType;
	private String examStartDate;
	private String examEndDate;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getExamResultSeq() {
		return examResultSeq;
	}

	public void setExamResultSeq(int examResultSeq) {
		this.examResultSeq = examResultSeq;
	}

	public int getExamSeq() {
		return examSeq;
	}

	public void setExamSeq(int examSeq) {
		this.examSeq = examSeq;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getResultFilePath() {
		return resultFilePath;
	}

	public void setResultFilePath(String resultFilePath) {
		this.resultFilePath = resultFilePath;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getFormDeleteDate() {
		return formDeleteDate;
	}

	public void setFormDeleteDate(String formDeleteDate) {
		this.formDeleteDate = formDeleteDate;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getLevelSeq() {
		return levelSeq;
	}

	public void setLevelSeq(int levelSeq) {
		this.levelSeq = levelSeq;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getExamEndDate() {
		return examEndDate;
	}

	public void setExamEndDate(String examEndDate) {
		this.examEndDate = examEndDate;
	}

	@Override
	public String toString() {
		return "ExamResult [totalCount=" + totalCount + ", examResultSeq=" + examResultSeq + ", examSeq=" + examSeq + ", level=" + level + ", studentId=" + studentId + ", resultFilePath=" + resultFilePath + ", staffId=" + staffId + ", registerDate=" + registerDate
				+ ", formRegisterDate=" + formRegisterDate + ", isDeleted=" + isDeleted + ", deleteDate=" + deleteDate + ", formDeleteDate=" + formDeleteDate + ", studentName=" + studentName + ", levelSeq=" + levelSeq + ", birthday=" + birthday + ", term=" + term + ", examType="
				+ examType + ", examStartDate=" + examStartDate + ", examEndDate=" + examEndDate + "]";
	}

}
