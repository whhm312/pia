package com.pines.student.common.response;

public class CommonResponseForm {
	private CommonResponseResult results;

	public CommonResponseResult getResults() {
		return results;
	}

	public void setResults(CommonResponseResult results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "CommonResponseForm [results=" + results + "]";
	}

}
