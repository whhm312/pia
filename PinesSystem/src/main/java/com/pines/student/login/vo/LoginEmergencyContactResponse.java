package com.pines.student.login.vo;

public class LoginEmergencyContactResponse {
	private String nationality;
	private String name;
	private String contact;

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "LoginEmergencyContactResponse [nationality=" + nationality + ", name=" + name + ", contact=" + contact + "]";
	}

}
