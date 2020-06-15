package com.pines.student.request.vo;

import com.pines.student.common.vo.Request;

public class AddRequestRequest {
	private String detail;
	private String type;

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "AddRequestRequest [detail=" + detail + ", type=" + type + "]";
	}

	public Request getRequest(int branchSeq, String studentId) {
		Request result = new Request();
		result.setBranchSeq(branchSeq);
		result.setStudentId(studentId);
		result.setDetail(this.detail);
		result.setType(this.type);
		return result;
	}

}
