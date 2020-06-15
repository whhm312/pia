package com.pines.student.notice.vo;

public class NoticesResponse {
	private int noticeSeq;
	private String branch;
	private String language;
	private String type;
	private String title;
	private String writer;
	private boolean hasAttachment;
	private boolean isTopOfList;
	private String topOfList;
	private String registerDate;
	private boolean isForAll;

	public int getNoticeSeq() {
		return noticeSeq;
	}

	public void setNoticeSeq(int noticeSeq) {
		this.noticeSeq = noticeSeq;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public boolean getHasAttachment() {
		return hasAttachment;
	}

	public void setHasAttachment(boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	public boolean getIsTopOfList() {
		return isTopOfList;
	}

	public void setIsTopOfList(boolean isTopOfList) {
		this.isTopOfList = isTopOfList;
	}

	public String getTopOfList() {
		return topOfList;
	}

	public void setTopOfList(String topOfList) {
		this.topOfList = topOfList;
	}

	public boolean getIsForAll() {
		return isForAll;
	}

	public void setIsForAll(boolean isForAll) {
		this.isForAll = isForAll;
	}

	@Override
	public String toString() {
		return "NoticesResponse [noticeSeq=" + noticeSeq + ", branch=" + branch + ", language=" + language + ", type=" + type + ", title=" + title + ", writer=" + writer + ", hasAttachment=" + hasAttachment + ", isTopOfList=" + isTopOfList + ", topOfList=" + topOfList
				+ ", registerDate=" + registerDate + ", isForAll=" + isForAll + "]";
	}

}
