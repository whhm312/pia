package com.pines.student.push.vo;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.StudentDevice;

public class AddStudentDeviceRequest {
	private String os;
	private String token;

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
		return "AddStudentDeviceRequest [os=" + os + ", token=" + token + "]";
	}

	public StudentDevice getStudentDevice(String studentId) {
		StudentDevice result = new StudentDevice();
		result.setStudentId(studentId);
		result.setOs(Tools.getUpperCase(os));
		result.setToken(token);
		return result;
	}

}
