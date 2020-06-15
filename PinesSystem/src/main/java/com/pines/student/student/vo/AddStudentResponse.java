package com.pines.student.student.vo;

public class AddStudentResponse {
	private String studentId;

	public AddStudentResponse(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "AddStudentResponse [studentId=" + studentId + "]";
	}

}
