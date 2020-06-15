package com.pines.student.request.vo;

public class StudentRequestsResponse {
	private String registerDate;
	private String type;
	private String detail;
	private boolean isReply;
	private String reply;
	private String replyDate;
	private String staff;
	private String status;
	private String progressStaffId;
	private String progressDate;

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
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

	public boolean getIsReply() {
		return isReply;
	}

	public void setIsReply(boolean isReply) {
		this.isReply = isReply;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
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

	@Override
	public String toString() {
		return "StudentRequestsResponse [registerDate=" + registerDate + ", type=" + type + ", detail=" + detail + ", isReply=" + isReply + ", reply=" + reply + ", replyDate=" + replyDate + ", staff=" + staff + ", status=" + status + ", progressStaffId=" + progressStaffId
				+ ", progressDate=" + progressDate + "]";
	}

}
