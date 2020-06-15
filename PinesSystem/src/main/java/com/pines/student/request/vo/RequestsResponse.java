package com.pines.student.request.vo;

public class RequestsResponse {
	private int requestSeq;
	private String type;
	private String student;
	private String staff;
	private String status;
	private String registerDate;
	private String replyDate;
	private String progressStaffId;
	private String progressDate;
	private String campus;

	public int getRequestSeq() {
		return requestSeq;
	}

	public void setRequestSeq(int requestSeq) {
		this.requestSeq = requestSeq;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getProgressStaffId() {
		return progressStaffId;
	}

	public void setProgressStaffId(String progressStaffId) {
		this.progressStaffId = progressStaffId;
	}

	public String getProgressDate() {
		return progressDate;
	}

	public void setProgressDate(String progressDate) {
		this.progressDate = progressDate;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	@Override
	public String toString() {
		return "RequestsResponse [requestSeq=" + requestSeq + ", type=" + type + ", student=" + student + ", staff=" + staff + ", status=" + status + ", registerDate=" + registerDate + ", replyDate=" + replyDate + ", progressStaffId=" + progressStaffId + ", progressDate="
				+ progressDate + ", campus=" + campus + "]";
	}

}
