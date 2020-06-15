package com.pines.student.common.vo;

import java.util.List;

public class PushResponse {
	// {"multicast_id":8954593592069893330,"success":1,"failure":0,"canonical_ids":0,"results":[{"message_id":"0:1537761801482675%10b8ebebf9fd7ecd"}]}

	private String multicast_id;
	private int success;
	private int failure;
	private int canonical_ids;
	private List<PushResponseResult> results;

	public String getMulticast_id() {
		return multicast_id;
	}

	public void setMulticast_id(String multicast_id) {
		this.multicast_id = multicast_id;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getFailure() {
		return failure;
	}

	public void setFailure(int failure) {
		this.failure = failure;
	}

	public int getCanonical_ids() {
		return canonical_ids;
	}

	public void setCanonical_ids(int canonical_ids) {
		this.canonical_ids = canonical_ids;
	}

	public List<PushResponseResult> getResults() {
		return results;
	}

	public void setResults(List<PushResponseResult> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "PushResponse [multicast_id=" + multicast_id + ", success=" + success + ", failure=" + failure + ", canonical_ids=" + canonical_ids + ", results=" + results + "]";
	}

}
