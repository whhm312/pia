package com.pines.student.common.vo;

public class Consulting {
	private int totalCount;
	private int consultingSeq;
	private int branchSeq;
	private String studentId;
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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getConsultingSeq() {
		return consultingSeq;
	}

	public void setConsultingSeq(int consultingSeq) {
		this.consultingSeq = consultingSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public void setFormReplyDate(String formReplyDate) {
		this.formReplyDate = formReplyDate;
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

	public void setFromReplyDate(String formReplyDate) {
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

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Consulting [totalCount=" + totalCount + ", consultingSeq=" + consultingSeq + ", branchSeq=" + branchSeq + ", studentId=" + studentId + ", detail=" + detail + ", staffId=" + staffId + ", staff=" + staff + ", reply=" + reply + ", isReply=" + isReply + ", replyDate="
				+ replyDate + ", formReplyDate=" + formReplyDate + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + ", isDeleted=" + isDeleted + "]";
	}

}
