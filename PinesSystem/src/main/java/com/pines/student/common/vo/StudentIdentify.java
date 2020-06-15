package com.pines.student.common.vo;

public class StudentIdentify {
	private String studentId;
	private String name;
	private String sex;
	private String nationality;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "StudentIdentify [studentId=" + studentId + ", name=" + name + ", sex=" + sex + ", nationality=" + nationality + "]";
	}

}
