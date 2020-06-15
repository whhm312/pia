package com.pines.student.student.admin.vo;

public class StudentsByLevelResponse {
	private String studentId;
	private String name;
	private String dayOfBirth;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	@Override
	public String toString() {
		return "StudentsByLevelResponse [studentId=" + studentId + ", name=" + name + ", dayOfBirth=" + dayOfBirth + "]";
	}

}
