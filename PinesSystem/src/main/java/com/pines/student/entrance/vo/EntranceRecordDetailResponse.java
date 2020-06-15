package com.pines.student.entrance.vo;

public class EntranceRecordDetailResponse {
	private int consultSeq;
	private int entranceRecordSeq;
	private String branch;
	private String campus;
	private String entranceName;
	private String studentName;
	private String staffName;
	private boolean isExcused;
	private String consultResult;
	private String consultDate;
	private String consultStaffName;
	private String outDate;
	private String inDate;
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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

	public int getOutInGapSeconds() {
		return outInGapSeconds;
	}

	public void setOutInGapSeconds(int outInGapSeconds) {
		this.outInGapSeconds = outInGapSeconds;
	}

	@Override
	public String toString() {
		return "EntranceRecordDetailResponse [consultSeq=" + consultSeq + ", entranceRecordSeq=" + entranceRecordSeq + ", branch=" + branch + ", campus=" + campus + ", entranceName=" + entranceName + ", studentName=" + studentName + ", staffName=" + staffName + ", isExcused="
				+ isExcused + ", consultResult=" + consultResult + ", consultDate=" + consultDate + ", consultStaffName=" + consultStaffName + ", outDate=" + outDate + ", inDate=" + inDate + ", outInGapSeconds=" + outInGapSeconds + "]";
	}

}
