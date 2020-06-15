package com.pines.student.common.vo;

public class StudyLevelGrouping {
	private int levelGroupingSeq;
	private int studySeq;
	private int levelSeq;
	private String studentId;
	private String studentName;
	private String updateDate;
	private String registerDate;
	private String formUpdateDate;
	private String formRegisterDate;
	private boolean isDeleted;
	private String course;
	private String requestCourse;
	private String inputStudentName;

	public int getLevelGroupingSeq() {
		return levelGroupingSeq;
	}

	public void setLevelGroupingSeq(int levelGroupingSeq) {
		this.levelGroupingSeq = levelGroupingSeq;
	}

	public int getStudySeq() {
		return studySeq;
	}

	public void setStudySeq(int studySeq) {
		this.studySeq = studySeq;
	}

	public int getLevelSeq() {
		return levelSeq;
	}

	public void setLevelSeq(int levelSeq) {
		this.levelSeq = levelSeq;
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

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getFormUpdateDate() {
		return formUpdateDate;
	}

	public void setFormUpdateDate(String formUpdateDate) {
		this.formUpdateDate = formUpdateDate;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getRequestCourse() {
		return requestCourse;
	}

	public void setRequestCourse(String requestCourse) {
		this.requestCourse = requestCourse;
	}

	public String getInputStudentName() {
		return inputStudentName;
	}

	public void setInputStudentName(String inputStudentName) {
		this.inputStudentName = inputStudentName;
	}

	@Override
	public String toString() {
		return "StudyLevelGrouping [levelGroupingSeq=" + levelGroupingSeq + ", studySeq=" + studySeq + ", levelSeq=" + levelSeq + ", studentId=" + studentId + ", studentName=" + studentName + ", updateDate=" + updateDate + ", registerDate=" + registerDate + ", formUpdateDate="
				+ formUpdateDate + ", formRegisterDate=" + formRegisterDate + ", isDeleted=" + isDeleted + ", course=" + course + ", requestCourse=" + requestCourse + ", inputStudentName=" + inputStudentName + "]";
	}

}
