package com.pines.student.common.vo;

public class StudentGroup {
	private int studentGroupSeq;
	private int branchSeq;
	private String groupName;
	private boolean isDeleted;
	private String registerDate;

	public int getStudentGroupSeq() {
		return studentGroupSeq;
	}

	public void setStudentGroupSeq(int studentGroupSeq) {
		this.studentGroupSeq = studentGroupSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
		return "StudentGroup [studentGroupSeq=" + studentGroupSeq + ", branchSeq=" + branchSeq + ", groupName=" + groupName + ", isDeleted=" + isDeleted + ", registerDate=" + registerDate + "]";
	}

}
