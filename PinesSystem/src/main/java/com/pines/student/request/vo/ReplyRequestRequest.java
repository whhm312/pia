package com.pines.student.request.vo;

import com.pines.student.common.vo.Request;

public class ReplyRequestRequest {
	private String staffId;
	private String reply;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "ReplyRequestRequest [staffId=" + staffId + ", reply=" + reply + "]";
	}

	public Request getRequest(int branchSeq, int requestSeq) {
		Request result = new Request();
		result.setBranchSeq(branchSeq);
		result.setRequestSeq(requestSeq);
		result.setStaffId(this.staffId);
		result.setReply(this.reply);
		return result;
	}

}
