package com.pines.student.common.vo;

import com.pines.student.common.Tools;

public class ExamApplicant {
	private int applicantSeq;
	private int examSeq;
	private String studentId;
	private String registerDate;
	private String formRegisterDate;
	private String registerStudentId;
	private String registerStaffId;
	private boolean isCanceled;
	private String cancelDate;
	private String formCancelDate;
	private String cancelStudentId;
	private String cancelStaffId;

	public int getApplicantSeq() {
		return applicantSeq;
	}

	public void setApplicantSeq(int applicantSeq) {
		this.applicantSeq = applicantSeq;
	}

	public int getExamSeq() {
		return examSeq;
	}

	public void setExamSeq(int examSeq) {
		this.examSeq = examSeq;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public String getRegisterStudentId() {
		return registerStudentId;
	}

	public void setRegisterStudentId(String registerStudentId) {
		this.registerStudentId = registerStudentId;
	}

	public String getRegisterStaffId() {
		return registerStaffId;
	}

	public void setRegisterStaffId(String registerStaffId) {
		this.registerStaffId = registerStaffId;
	}

	public boolean getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getFormCancelDate() {
		return formCancelDate;
	}

	public void setFormCancelDate(String formCancelDate) {
		this.formCancelDate = formCancelDate;
	}

	public String getCancelStudentId() {
		return cancelStudentId;
	}

	public void setCancelStudentId(String cancelStudentId) {
		this.cancelStudentId = cancelStudentId;
	}

	public String getCancelStaffId() {
		return cancelStaffId;
	}

	public void setCancelStaffId(String cancelStaffId) {
		this.cancelStaffId = cancelStaffId;
	}

	public boolean isRegisterByStaff() {
		return Tools.isEmpty(registerStudentId);
	}

	public boolean isCancelByStaff() {
		return Tools.isEmpty(cancelStudentId);
	}

	@Override
	public String toString() {
		return "ExamApplicant [applicantSeq=" + applicantSeq + ", examSeq=" + examSeq + ", studentId=" + studentId + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + ", registerStudentId=" + registerStudentId + ", registerStaffId=" + registerStaffId
				+ ", isCanceled=" + isCanceled + ", cancelDate=" + cancelDate + ", formCancelDate=" + formCancelDate + ", cancelStudentId=" + cancelStudentId + ", cancelStaffId=" + cancelStaffId + "]";
	}

}
