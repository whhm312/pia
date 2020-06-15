package com.pines.student.common.vo;

public class Rule {
	private int ruleSeq;
	private int branchSeq;
	private int groupSeq;
	private String ruleType;
	private String detail;
	private boolean isDeleted;
	private String registerDate;
	private String formRegisterDate;

	public int getRuleSeq() {
		return ruleSeq;
	}

	public void setRuleSeq(int ruleSeq) {
		this.ruleSeq = ruleSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getGroupSeq() {
		return groupSeq;
	}

	public void setGroupSeq(int groupSeq) {
		this.groupSeq = groupSeq;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
		return "Rule [ruleSeq=" + ruleSeq + ", branchSeq=" + branchSeq + ", groupSeq=" + groupSeq + ", ruleType=" + ruleType + ", detail=" + detail + ", isDeleted=" + isDeleted + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + "]";
	}

}
