package com.pines.student.common.vo;

import java.util.List;

public class Request {
	private int totalCount;
	private int requestSeq;
	private int branchSeq;
	private String branch;
	private List<String> typies;
	private String type;
	private String studentId;
	private String student;
	private String detail;
	private String staffId;
	private String staff;
	private String reply;
	private boolean isReply;
	private String replyDate;
	private String formReplyDate;
	private String registerDate;
	private String formRegisterDate;
	private boolean isDeleted;
	private String status;
	private String nationality;
	private String birthday;
	private String sex;
	private List<String> statuses;
	private String progressStaff;
	private String progressStaffId;
	private String progressDate;
	private String formProgressDate;
	private String progressDetail;
	private int campusSeq;
	private String campus;
	private int studentDeviceCount;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getRequestSeq() {
		return requestSeq;
	}

	public void setRequestSeq(int requestSeq) {
		this.requestSeq = requestSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setReply(boolean isReply) {
		this.isReply = isReply;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public boolean getIsReply() {
		return isReply;
	}

	public void setIsReply(boolean isReply) {
		this.isReply = isReply;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getFormReplyDate() {
		return formReplyDate;
	}

	public void setFormReplyDate(String formReplyDate) {
		this.formReplyDate = formReplyDate;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getTypies() {
		return typies;
	}

	public void setTypies(List<String> typies) {
		this.typies = typies;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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

	public List<String> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<String> statuses) {
		this.statuses = statuses;
	}

	public String getProgressStaff() {
		return progressStaff;
	}

	public void setProgressStaff(String progressStaff) {
		this.progressStaff = progressStaff;
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

	public String getFormProgressDate() {
		return formProgressDate;
	}

	public void setFormProgressDate(String formProgressDate) {
		this.formProgressDate = formProgressDate;
	}

	public String getProgressDetail() {
		return progressDetail;
	}

	public void setProgressDetail(String progressDetail) {
		this.progressDetail = progressDetail;
	}

	public int getCampusSeq() {
		return campusSeq;
	}

	public void setCampusSeq(int campusSeq) {
		this.campusSeq = campusSeq;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public int getStudentDeviceCount() {
		return studentDeviceCount;
	}

	public void setStudentDeviceCount(int studentDeviceCount) {
		this.studentDeviceCount = studentDeviceCount;
	}

	@Override
	public String toString() {
		return "Request [totalCount=" + totalCount + ", requestSeq=" + requestSeq + ", branchSeq=" + branchSeq + ", branch=" + branch + ", typies=" + typies + ", type=" + type + ", studentId=" + studentId + ", student=" + student + ", detail=" + detail + ", staffId=" + staffId
				+ ", staff=" + staff + ", reply=" + reply + ", isReply=" + isReply + ", replyDate=" + replyDate + ", formReplyDate=" + formReplyDate + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + ", isDeleted=" + isDeleted + ", status=" + status
				+ ", nationality=" + nationality + ", birthday=" + birthday + ", sex=" + sex + ", statuses=" + statuses + ", progressStaff=" + progressStaff + ", progressStaffId=" + progressStaffId + ", progressDate=" + progressDate + ", formProgressDate=" + formProgressDate
				+ ", progressDetail=" + progressDetail + ", campusSeq=" + campusSeq + ", campus=" + campus + ", studentDeviceCount=" + studentDeviceCount + "]";
	}

}
