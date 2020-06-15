package com.pines.student.common.vo;

public class PushResponseResult {
	// {"multicast_id":8954593592069893330,"success":1,"failure":0,"canonical_ids":0,"results":[{"message_id":"0:1537761801482675%10b8ebebf9fd7ecd"}]}

	private String message_id;
	private String error;

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "PushResponseResult [message_id=" + message_id + ", error=" + error + "]";
	}

}
