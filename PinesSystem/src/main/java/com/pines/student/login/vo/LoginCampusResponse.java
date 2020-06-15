package com.pines.student.login.vo;

public class LoginCampusResponse {
	private int branchSeq;
	private int campusSeq;
	private String campusName;

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

	@Override
	public String toString() {
		return "LoginCampusResponse [campusSeq=" + campusSeq + ", branchSeq=" + branchSeq + ", campusName=" + campusName + "]";
	}

}
