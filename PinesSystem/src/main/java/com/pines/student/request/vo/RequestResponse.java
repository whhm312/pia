package com.pines.student.request.vo;

public class RequestResponse {
	private String branch;
	private String status;
	private String type;
	private String staff;
	private String nationality;
	private String student;
	private String registerDate;
	private String replyDate;
	private String reply;
	private String detail;
	private String birthday;
	private String sex;
	private String progressStaffId;
	private String progressDate;
	private String progressDetail;
	private String studentId;
	private boolean isCanPushMessage;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getProgressDetail() {
		return progressDetail;
	}

	public void setProgressDetail(String progressDetail) {
		this.progressDetail = progressDetail;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public boolean getIsCanPushMessage() {
		return isCanPushMessage;
	}

	public void setIsCanPushMessage(boolean isCanPushMessage) {
		this.isCanPushMessage = isCanPushMessage;
	}

	@Override
	public String toString() {
		return "RequestResponse [branch=" + branch + ", status=" + status + ", type=" + type + ", staff=" + staff + ", nationality=" + nationality + ", student=" + student + ", registerDate=" + registerDate + ", replyDate=" + replyDate + ", reply=" + reply + ", detail=" + detail
				+ ", birthday=" + birthday + ", sex=" + sex + ", progressStaffId=" + progressStaffId + ", progressDate=" + progressDate + ", progressDetail=" + progressDetail + ", studentId=" + studentId + ", isCanPushMessage=" + isCanPushMessage + "]";
	}
}
