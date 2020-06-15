package com.pines.student.login.vo;

public class LoginActivityResponse {
	private int activitySeq;
	private String title;
	private StringBuffer content;
	private String acceptStartDate;
	private String acceptEndDate;

	public int getActivitySeq() {
		return activitySeq;
	}

	public void setActivitySeq(int activitySeq) {
		this.activitySeq = activitySeq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public StringBuffer getContent() {
		return content;
	}

	public void setContent(StringBuffer content) {
		this.content = content;
	}

	public String getAcceptStartDate() {
		return acceptStartDate;
	}

	public void setAcceptStartDate(String acceptStartDate) {
		this.acceptStartDate = acceptStartDate;
	}

	public String getAcceptEndDate() {
		return acceptEndDate;
	}

	public void setAcceptEndDate(String acceptEndDate) {
		this.acceptEndDate = acceptEndDate;
	}

	@Override
	public String toString() {
		return "LoginActivityResponse [activitySeq=" + activitySeq + ", title=" + title + ", content=" + content + ", acceptStartDate=" + acceptStartDate + ", acceptEndDate=" + acceptEndDate + "]";
	}

}
