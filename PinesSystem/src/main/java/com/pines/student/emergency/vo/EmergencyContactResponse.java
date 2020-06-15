package com.pines.student.emergency.vo;

public class EmergencyContactResponse {
	private int contactSeq;
	private String staffId;
	private String title;
	private String name;
	private String nationality;
	private String contact;
	private int orderNo;
	private boolean isShown;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public int getContactSeq() {
		return contactSeq;
	}

	public void setContactSeq(int contactSeq) {
		this.contactSeq = contactSeq;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public boolean getIsShown() {
		return isShown;
	}

	public void setIsShown(boolean isShown) {
		this.isShown = isShown;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "EmergencyContactResponse [contactSeq=" + contactSeq + ", staffId=" + staffId + ", title=" + title + ", name=" + name + ", nationality=" + nationality + ", contact=" + contact + ", orderNo=" + orderNo + ", isShown=" + isShown + "]";
	}

}
