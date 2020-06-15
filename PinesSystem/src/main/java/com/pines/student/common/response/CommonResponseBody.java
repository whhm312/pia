package com.pines.student.common.response;

import java.util.ArrayList;

public class CommonResponseBody {
	private int totalCount;
	private Object data;

	public CommonResponseBody() {
		super();
		data = new ArrayList<Object>();
	}

	public CommonResponseBody(int totalCount, Object data) {
		this.totalCount = totalCount;
		this.data = data;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CommonResponseBody [totalCount=" + totalCount + ", data=" + data + "]";
	}

	public void setEmpty() {
		totalCount = 0;
		data = new ArrayList<Object>();
		
	}
}
