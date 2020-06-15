package com.pines.student.student.admin.vo;

public class ChangeStudentNameRequest {
	private String studentName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "ChangeStudentNameRequest [studentName=" + studentName + "]";
	}

}
