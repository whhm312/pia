package com.pines.student.study.vo;

public class StudyLevelGroupingResponse {
	private String studentName;
	private String course;
	private String requestCourse;
	private String studentId;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "StudyLevelGroupingResponse [studentName=" + studentName + ", course=" + course + ", requestCourse=" + requestCourse + ", studentId=" + studentId + "]";
	}

}
