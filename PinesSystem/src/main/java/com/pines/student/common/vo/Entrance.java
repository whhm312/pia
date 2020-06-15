package com.pines.student.common.vo;

public class Entrance {
	private int entranceSeq;
	private int branchSeq;
	private int campusSeq;
	private String name;
	private String staffId;
	private String staffName;
	private boolean isDeleted;
	private String registerDate;
	private String formRegisterDate;

	public int getEntranceSeq() {
		return entranceSeq;
	}

	public void setEntranceSeq(int entranceSeq) {
		this.entranceSeq = entranceSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getCampusSeq() {
		return campusSeq;
	}

	public void setCampusSeq(int campusSeq) {
		this.campusSeq = campusSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
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

	@Override
	public String toString() {
		return "Entrance [entranceSeq=" + entranceSeq + ", branchSeq=" + branchSeq + ", campusSeq=" + campusSeq + ", name=" + name + ", staffId=" + staffId + ", staffName=" + staffName + ", isDeleted=" + isDeleted + ", registerDate=" + registerDate + ", formRegisterDate="
				+ formRegisterDate + "]";
	}

}
