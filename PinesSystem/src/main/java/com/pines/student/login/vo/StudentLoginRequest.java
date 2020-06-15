package com.pines.student.login.vo;

public class StudentLoginRequest {
	private String studentId;
	private String password;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "StudentLoginRequest [studentId=" + studentId + ", password=" + password + "]";
	}

}
