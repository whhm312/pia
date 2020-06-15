package com.pines.student.common.vo;

public class StudentIdCard {
	private String studentId;
	private String idCardSerialNumber;
	private String reasonType;
	private String memo;
	private String staffId;
	private String registerDate;
	private String formRegisterDate;
	private String studentName;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getIdCardSerialNumber() {
		return idCardSerialNumber;
	}

	public void setIdCardSerialNumber(String idCardSerialNumber) {
		this.idCardSerialNumber = idCardSerialNumber;
	}

	public String getReasonType() {
		return reasonType;
	}

	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "StudentIdCard [studentId=" + studentId + ", idCardSerialNumber=" + idCardSerialNumber + ", reasonType=" + reasonType + ", memo=" + memo + ", staffId=" + staffId + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + ", studentName="
				+ studentName + "]";
	}

}
