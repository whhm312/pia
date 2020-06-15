package com.pines.student.common.response;

import java.util.ArrayList;

import com.pines.student.common.code.ResultCode;

public class CommonResponseResult {
	private CommonResponseHead head;
	private CommonResponseBody body;

	public CommonResponseResult() {
		super();
		this.head = new CommonResponseHead();
		this.body = new CommonResponseBody();
	}

	public CommonResponseHead getHead() {
		return head;
	}

	public void setHead(CommonResponseHead head) {
		this.head = head;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(CommonResponseBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "CommonResponseResults [head=" + head + ", body=" + body + "]";
	}

	public void setSuccessHead() {
		this.head.setStatus(ResultCode.STATUS_200.getStatus());
		this.head.setMessage(ResultCode.STATUS_200.getMessage());
	}

	public void setSuccessHead(String msg) {
		this.head.setStatus(ResultCode.STATUS_200.getStatus());
		this.head.setMessage(msg);
	}

	public void setFailureHead(ResultCode status) {
		this.head.setStatus(status.getStatus());
		this.head.setMessage(status.getMessage());
		this.body.setTotalCount(0);
		this.body.setData(new ArrayList<Object>());
	}

	public void setFailureHead(ResultCode status, String message) {
		this.head.setStatus(status.getStatus());
		this.head.setMessage(message);
		this.body.setTotalCount(0);
		this.body.setData(new ArrayList<Object>());
	}

	public void setSuccessBody() {
		this.body.setData(new ArrayList<Object>());
		this.body.setTotalCount(0);
	}
}
