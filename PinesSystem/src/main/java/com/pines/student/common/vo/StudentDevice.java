package com.pines.student.common.vo;

public class StudentDevice {
	private int studentDeviceSeq;
	private String studentId;
	private String os;
	private String token;

	public int getStudentDeviceSeq() {
		return studentDeviceSeq;
	}

	public void setStudentDeviceSeq(int studentDeviceSeq) {
		this.studentDeviceSeq = studentDeviceSeq;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "StudentDevice [studentDeviceSeq=" + studentDeviceSeq + ", studentId=" + studentId + ", os=" + os + ", token=" + token + "]";
	}

}
