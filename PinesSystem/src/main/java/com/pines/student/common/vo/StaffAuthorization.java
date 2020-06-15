package com.pines.student.common.vo;

public class StaffAuthorization {
	private int totalCount;
	private int authorizationSeq;
	private String staffId;
	private int branchSeq;
	private String registerDate;
	private String formRegisterDate;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getAuthorizationSeq() {
		return authorizationSeq;
	}

	public void setAuthorizationSeq(int authorizationSeq) {
		this.authorizationSeq = authorizationSeq;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
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
		return "StaffAuthorization [totalCount=" + totalCount + ", authorizationSeq=" + authorizationSeq + ", staffId=" + staffId + ", branchSeq=" + branchSeq + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + "]";
	}

}
