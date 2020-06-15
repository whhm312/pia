package com.pines.student.common.vo;

public class EmergencyContact {
	private int emergencyContactSeq;
	private int branchSeq;
	private String staffId;
	private String title;
	private String name;
	private String emergencyContact;
	private String nationality;
	private String nationalityAlphaThree;
	private boolean isDeleted;
	private String registerDate;
	private String formRegisterDate;
	private int orderNo;
	private boolean isShown;

	public int getEmergencyContactSeq() {
		return emergencyContactSeq;
	}

	public void setEmergencyContactSeq(int emergencyContactSeq) {
		this.emergencyContactSeq = emergencyContactSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setShown(boolean isShown) {
		this.isShown = isShown;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNationalityAlphaThree() {
		return nationalityAlphaThree;
	}

	public void setNationalityAlphaThree(String nationalityAlphaThree) {
		this.nationalityAlphaThree = nationalityAlphaThree;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
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

	@Override
	public String toString() {
		return "PIAEmergencyContact [emergencyContactSeq=" + emergencyContactSeq + ", branchSeq=" + branchSeq + ", staffId=" + staffId + ", title=" + title + ", name=" + name + ", emergencyContact=" + emergencyContact + ", nationality=" + nationality + ", nationalityAlphaThree="
				+ nationalityAlphaThree + ", isDeleted=" + isDeleted + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + ", orderNo=" + orderNo + ", isShown=" + isShown + "]";
	}

}
