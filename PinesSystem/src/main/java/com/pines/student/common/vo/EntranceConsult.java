package com.pines.student.common.vo;

public class EntranceConsult {
	private int consultSeq;
	private int entranceRecordSeq;
	private String studentId;
	private String staffId;
	private boolean isExcused;
	private String consultResult;
	private String consultDate;
	private boolean isDeleted;

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

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "EntranceRecordConsult [consultSeq=" + consultSeq + ", entranceRecordSeq=" + entranceRecordSeq + ", studentId=" + studentId + ", staffId=" + staffId + ", isExcused=" + isExcused + ", consultResult=" + consultResult + ", consultDate=" + consultDate + ", isDeleted="
				+ isDeleted + "]";
	}

}
