package com.pines.student.login.vo;

public class LoginBranchResponse {
	private int branchSeq;
	private String branchName;

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Override
	public String toString() {
		return "LoginBranchResponse [branchSeq=" + branchSeq + ", branchName=" + branchName + "]";
	}

}
