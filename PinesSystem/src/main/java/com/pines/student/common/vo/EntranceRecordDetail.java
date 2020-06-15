package com.pines.student.common.vo;

public class EntranceRecordDetail {
	private int consultSeq;
	private int entranceRecordSeq;
	private String branch;
	private String campus;
	private String entranceName;
	private String studentId;
	private String studentName;
	private String staffId;
	private String staffName;
	private boolean isExcused;
	private String consultResult;
	private String consultDate;
	private String formConsultDate;
	private String consultStaffId;
	private String consultStaffName;
	private String outDate;
	private String inDate;
	private String formOutDate;
	private String formInDate;
	private int outInGapSeconds;

	public int getConsultSeq() {
		return consultSeq;
	}

	public void setConsultSeq(int consultSeq) {
		this.consultSeq = consultSeq;
	}

	public int getEntranceRecordSeq() {
		return entranceRecordSeq;
	}

	public void setEntranceRecordSeq(int entranceRecordSeq) {
		this.entranceRecordSeq = entranceRecordSeq;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getEntranceName() {
		return entranceName;
	}

	public void setEntranceName(String entranceName) {
		this.entranceName = entranceName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

	public boolean getIsExcused() {
		return isExcused;
	}

	public void setIsExcused(boolean isExcused) {
		this.isExcused = isExcused;
	}

	public String getConsultResult() {
		return consultResult;
	}

	public void setConsultResult(String consultResult) {
		this.consultResult = consultResult;
	}

	public String getConsultDate() {
		return consultDate;
	}

	public void setConsultDate(String consultDate) {
		this.consultDate = consultDate;
	}

	public String getFormConsultDate() {
		return formConsultDate;
	}

	public void setFormConsultDate(String formConsultDate) {
		this.formConsultDate = formConsultDate;
	}

	public String getConsultStaffId() {
		return consultStaffId;
	}

	public void setConsultStaffId(String consultStaffId) {
		this.consultStaffId = consultStaffId;
	}

	public String getConsultStaffName() {
		return consultStaffName;
	}

	public void setConsultStaffName(String consultStaffName) {
		this.consultStaffName = consultStaffName;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getFormOutDate() {
		return formOutDate;
	}

	public void setFormOutDate(String formOutDate) {
		this.formOutDate = formOutDate;
	}

	public String getFormInDate() {
		return formInDate;
	}

	public void setFormInDate(String formInDate) {
		this.formInDate = formInDate;
	}

	public int getOutInGapSeconds() {
		return outInGapSeconds;
	}

	public void setOutInGapSeconds(int outInGapSeconds) {
		this.outInGapSeconds = outInGapSeconds;
	}

	@Override
	public String toString() {
		return "EntranceRecordDetail [consultSeq=" + consultSeq + ", entranceRecordSeq=" + entranceRecordSeq + ", branch=" + branch + ", campus=" + campus + ", entranceName=" + entranceName + ", studentId=" + studentId + ", studentName=" + studentName + ", staffId=" + staffId
				+ ", staffName=" + staffName + ", isExcused=" + isExcused + ", consultResult=" + consultResult + ", consultDate=" + consultDate + ", formConsultDate=" + formConsultDate + ", consultStaffId=" + consultStaffId + ", consultStaffName=" + consultStaffName
				+ ", outDate=" + outDate + ", inDate=" + inDate + ", formOutDate=" + formOutDate + ", formInDate=" + formInDate + ", outInGapSeconds=" + outInGapSeconds + "]";
	}

}
