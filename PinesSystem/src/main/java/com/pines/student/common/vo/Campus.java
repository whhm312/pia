package com.pines.student.common.vo;

public class Campus {
	private int campusSeq;
	private int branchSeq;
	private String campusName;
	private String compusCode;
	private boolean isDeleted;
	private String registerDate;

	public int getCampusSeq() {
		return campusSeq;
	}

	public void setCampusSeq(int campusSeq) {
		this.campusSeq = campusSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public String getCampusName() {
		return campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}

	public String getCompusCode() {
		return compusCode;
	}

	public void setCompusCode(String compusCode) {
		this.compusCode = compusCode;
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

	@Override
	public String toString() {
		return "Campus [campusSeq=" + campusSeq + ", branchSeq=" + branchSeq + ", campusName=" + campusName + ", compusCode=" + compusCode + ", isDeleted=" + isDeleted + ", registerDate=" + registerDate + "]";
	}

}
