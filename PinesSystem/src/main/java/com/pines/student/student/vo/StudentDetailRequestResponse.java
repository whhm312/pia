package com.pines.student.student.vo;

public class StudentDetailRequestResponse {
	private int requestSeq;
	private String registerDate;
	private String detail;
	private boolean isReply;
	private String reply;
	private String replyDate;
	private String replyName;
	private String requestType;

	public int getRequestSeq() {
		return requestSeq;
	}

	public void setRequestSeq(int requestSeq) {
		this.requestSeq = requestSeq;
	}

	public void setReply(boolean isReply) {
		this.isReply = isReply;
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

	public String getReplyName() {
		return replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@Override
	public String toString() {
		return "StudentDetailRequestResponse [requestSeq=" + requestSeq + ", registerDate=" + registerDate + ", detail=" + detail + ", isReply=" + isReply + ", reply=" + reply + ", replyDate=" + replyDate + ", replyName=" + replyName + ", requestType=" + requestType + "]";
	}

}
