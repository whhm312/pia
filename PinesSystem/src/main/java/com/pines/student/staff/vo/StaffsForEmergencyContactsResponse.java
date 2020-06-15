package com.pines.student.staff.vo;

public class StaffsForEmergencyContactsResponse {
	private String staffId;
	private String name;
	private String nationality;
	private String contact;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "StaffResponse [staffId=" + staffId + ", name=" + name + ", nationality=" + nationality + ", contact=" + contact + "]";
	}

}
