package com.pines.student.common.vo;

public class StudentPeriodHistory {
	private int periodHistorySeq;
	private String studentId;
	private String staffId;
	private String previousStartDate;
	private String previousEndDate;
	private String newStartDate;
	private String newEndDate;
	private String formPreviousStartDate;
	private String formPreviousEndDate;
	private String formNewStartDate;
	private String formNewEndDate;

	public int getPeriodHistorySeq() {
		return periodHistorySeq;
	}

	public void setPeriodHistorySeq(int periodHistorySeq) {
		this.periodHistorySeq = periodHistorySeq;
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

	public String getPreviousStartDate() {
		return previousStartDate;
	}

	public void setPreviousStartDate(String previousStartDate) {
		this.previousStartDate = previousStartDate;
	}

	public String getPreviousEndDate() {
		return previousEndDate;
	}

	public void setPreviousEndDate(String previousEndDate) {
		this.previousEndDate = previousEndDate;
	}

	public String getNewStartDate() {
		return newStartDate;
	}

	public void setNewStartDate(String newStartDate) {
		this.newStartDate = newStartDate;
	}

	public String getNewEndDate() {
		return newEndDate;
	}

	public void setNewEndDate(String newEndDate) {
		this.newEndDate = newEndDate;
	}

	public String getFormPreviousStartDate() {
		return formPreviousStartDate;
	}

	public void setFormPreviousStartDate(String formPreviousStartDate) {
		this.formPreviousStartDate = formPreviousStartDate;
	}

	public String getFormPreviousEndDate() {
		return formPreviousEndDate;
	}

	public void setFormPreviousEndDate(String formPreviousEndDate) {
		this.formPreviousEndDate = formPreviousEndDate;
	}

	public String getFormNewStartDate() {
		return formNewStartDate;
	}

	public void setFormNewStartDate(String formNewStartDate) {
		this.formNewStartDate = formNewStartDate;
	}

	public String getFormNewEndDate() {
		return formNewEndDate;
	}

	public void setFormNewEndDate(String formNewEndDate) {
		this.formNewEndDate = formNewEndDate;
	}

	@Override
	public String toString() {
		return "StudentPeriodHistory [periodHistorySeq=" + periodHistorySeq + ", studentId=" + studentId + ", staffId=" + staffId + ", previousStartDate=" + previousStartDate + ", previousEndDate=" + previousEndDate + ", newStartDate=" + newStartDate + ", newEndDate="
				+ newEndDate + ", formPreviousStartDate=" + formPreviousStartDate + ", formPreviousEndDate=" + formPreviousEndDate + ", formNewStartDate=" + formNewStartDate + ", formNewEndDate=" + formNewEndDate + "]";
	}

}
