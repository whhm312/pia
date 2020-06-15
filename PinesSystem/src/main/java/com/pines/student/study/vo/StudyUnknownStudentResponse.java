package com.pines.student.study.vo;

public class StudyUnknownStudentResponse {
	private String studentName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "StudyUnknownStudentResponse [studentName=" + studentName + "]";
	}

}
