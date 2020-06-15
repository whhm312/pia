package com.pines.student.common.vo;

public class Violation {
	private int totalCount;
	private int violationSeq;
	private int ruleSeq;
	private String ruleType;
	private String studentId;
	private String staffId;
	private String staff;
	private String detail;
	private String memo;
	private boolean isDeleted;
	private String registerDate;
	private String formRegisterDate;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getViolationSeq() {
		return violationSeq;
	}

	public void setViolationSeq(int violationSeq) {
		this.violationSeq = violationSeq;
	}

	public int getRuleSeq() {
		return ruleSeq;
	}

	public void setRuleSeq(int ruleSeq) {
		this.ruleSeq = ruleSeq;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
		return "Violation [totalCount=" + totalCount + ", violationSeq=" + violationSeq + ", ruleSeq=" + ruleSeq + ", ruleType=" + ruleType + ", studentId=" + studentId + ", staffId=" + staffId + ", staff=" + staff + ", detail=" + detail + ", memo=" + memo + ", isDeleted="
				+ isDeleted + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + "]";
	}

}
