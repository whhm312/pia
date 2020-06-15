package com.pines.student.student.vo;

public class ChangeStudentPasswordRequest {
	private String newPassword;
	private String currentPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	@Override
	public String toString() {
		return "ChangeStudentPasswordRequest [newPassword=" + newPassword + ", currentPassword=" + currentPassword + "]";
	}

}
