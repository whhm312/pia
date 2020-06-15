package com.pines.student.login.vo;

public class StaffLoginRequest {
	private String staffId;
	private String password;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "StaffLoginRequest [staffId=" + staffId + ", password=" + password + "]";
	}

}
