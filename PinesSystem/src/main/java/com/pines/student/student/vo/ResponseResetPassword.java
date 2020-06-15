package com.pines.student.student.vo;

public class ResponseResetPassword {
	private String birthday;

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "ResponseResetPassword [birthday=" + birthday + "]";
	}

}
