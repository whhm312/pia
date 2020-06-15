package com.pines.student.request.vo;

import com.pines.student.common.vo.Request;

public class ProgressRequestRequest {
	private String staffId;
	private String detail;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "ProgressRequestRequest [staffId=" + staffId + ", detail=" + detail + "]";
	}

	public Request getRequest(int branchSeq, int requestSeq) {
		Request result = new Request();
		result.setBranchSeq(branchSeq);
		result.setRequestSeq(requestSeq);
		result.setProgressStaffId(staffId);
		result.setProgressDetail(detail);
		return result;
	}

}
