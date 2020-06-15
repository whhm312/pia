package com.pines.student.staff.vo;

public class ChangeStaffPasswordRequest {
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ChangeStaffPasswordRequest [password=" + password + "]";
	}

}
