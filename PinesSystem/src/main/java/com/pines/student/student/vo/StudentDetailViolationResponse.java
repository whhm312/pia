package com.pines.student.student.vo;

public class StudentDetailViolationResponse {
	private int violationSeq;
	private String type;
	private String detail;
	private String dateOfViolation;
	private String registerName;
	private String memo;

	public int getViolationSeq() {
		return violationSeq;
	}

	public void setViolationSeq(int violationSeq) {
		this.violationSeq = violationSeq;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDateOfViolation() {
		return dateOfViolation;
	}

	public void setDateOfViolation(String dateOfViolation) {
		this.dateOfViolation = dateOfViolation;
	}

	public String getRegisterName() {
		return registerName;
	}

	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "StudentDetailViolationResponse [violationSeq=" + violationSeq + ", type=" + type + ", detail=" + detail + ", dateOfViolation=" + dateOfViolation + ", registerName=" + registerName + ", memo=" + memo + "]";
	}

}
