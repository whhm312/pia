package com.pines.student.student.vo;

public class StudentDetailConsultingResponse {
	private int consultingSeq;
	private String registerDate;
	private String detail;
	private boolean isReply;
	private String reply;
	private String replyDate;
	private String replyName;

	public int getConsultingSeq() {
		return consultingSeq;
	}

	public void setConsultingSeq(int consultingSeq) {
		this.consultingSeq = consultingSeq;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public boolean isReply() {
		return isReply;
	}

	public void setReply(boolean isReply) {
		this.isReply = isReply;
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

	public String getReplyName() {
		return replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	@Override
	public String toString() {
		return "StudentDetailConsultingResponse [consultingSeq=" + consultingSeq + ", registerDate=" + registerDate + ", detail=" + detail + ", isReply=" + isReply + ", reply=" + reply + ", replyDate=" + replyDate + ", replyName=" + replyName + "]";
	}

}
