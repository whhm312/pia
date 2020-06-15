package com.pines.student.common.vo;

import java.util.List;

public class Staff {
	private int staffSeq;
	private int branchSeq;
	private String staffId;
	private String password;
	private String realName;
	private String name;
	private String title;
	private String nickName;
	private String nationality;
	private boolean isDeleted;
	private String registerDate;
	private String contact;
	private String updateStaffId;
	private String shortNationality;
	private int nationalitySeq;
	private String updateDate;
	private String formUpdateDate;
	private String formRegisterDate;
	private String branch;
	private int totalCount;
	private String status;
	private List<StaffAuthorization> staffAuthorizations;
	private String idCardSerialNumber;

	public int getStaffSeq() {
		return staffSeq;
	}

	public void setStaffSeq(int staffSeq) {
		this.staffSeq = staffSeq;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getUpdateStaffId() {
		return updateStaffId;
	}

	public void setUpdateStaffId(String updateStaffId) {
		this.updateStaffId = updateStaffId;
	}

	public String getShortNationality() {
		return shortNationality;
	}

	public void setShortNationality(String shortNationality) {
		this.shortNationality = shortNationality;
	}

	public int getNationalitySeq() {
		return nationalitySeq;
	}

	public void setNationalitySeq(int nationalitySeq) {
		this.nationalitySeq = nationalitySeq;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getFormUpdateDate() {
		return formUpdateDate;
	}

	public void setFormUpdateDate(String formUpdateDate) {
		this.formUpdateDate = formUpdateDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<StaffAuthorization> getStaffAuthorizations() {
		return staffAuthorizations;
	}

	public void setStaffAuthorizations(List<StaffAuthorization> staffAuthorizations) {
		this.staffAuthorizations = staffAuthorizations;
	}

	public String getIdCardSerialNumber() {
		return idCardSerialNumber;
	}

	public void setIdCardSerialNumber(String idCardSerialNumber) {
		this.idCardSerialNumber = idCardSerialNumber;
	}

	@Override
	public String toString() {
		return "Staff [staffSeq=" + staffSeq + ", branchSeq=" + branchSeq + ", staffId=" + staffId + ", password=" + password + ", realName=" + realName + ", name=" + name + ", title=" + title + ", nickName=" + nickName + ", nationality=" + nationality + ", isDeleted="
				+ isDeleted + ", registerDate=" + registerDate + ", contact=" + contact + ", updateStaffId=" + updateStaffId + ", shortNationality=" + shortNationality + ", nationalitySeq=" + nationalitySeq + ", updateDate=" + updateDate + ", formUpdateDate=" + formUpdateDate
				+ ", formRegisterDate=" + formRegisterDate + ", branch=" + branch + ", totalCount=" + totalCount + ", status=" + status + ", staffAuthorizations=" + staffAuthorizations + ", idCardSerialNumber=" + idCardSerialNumber + "]";
	}

}
