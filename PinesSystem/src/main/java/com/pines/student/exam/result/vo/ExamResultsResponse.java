package com.pines.student.exam.result.vo;

public class ExamResultsResponse {
	private int examResultSeq;
	private String level;
	private String studentId;
	private String studentName;
	private String resultFilePath;
	private String registerDate;
	private String birthday;
	private int levelSeq;

	public int getExamResultSeq() {
		return examResultSeq;
	}

	public void setExamResultSeq(int examResultSeq) {
		this.examResultSeq = examResultSeq;
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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getResultFilePath() {
		return resultFilePath;
	}

	public void setResultFilePath(String resultFilePath) {
		this.resultFilePath = resultFilePath;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getLevelSeq() {
		return levelSeq;
	}

	public void setLevelSeq(int levelSeq) {
		this.levelSeq = levelSeq;
	}

	@Override
	public String toString() {
		return "ExamResultsResponse [examResultSeq=" + examResultSeq + ", level=" + level + ", studentId=" + studentId + ", studentName=" + studentName + ", resultFilePath=" + resultFilePath + ", registerDate=" + registerDate + ", birthday=" + birthday + ", levelSeq=" + levelSeq
				+ "]";
	}

}
