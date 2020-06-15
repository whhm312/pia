package com.pines.student.notice.vo;

public class NoticesByLanguageResponse {
	private int noticeSeq;
	private String registerDate;
	private String shortRegisterDate;
	private String title;
	private String writer;
	private boolean hasAttachment;
	private boolean isTopOfList;

	public int getNoticeSeq() {
		return noticeSeq;
	}

	public void setNoticeSeq(int noticeSeq) {
		this.noticeSeq = noticeSeq;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getShortRegisterDate() {
		return shortRegisterDate;
	}

	public void setShortRegisterDate(String shortRegisterDate) {
		this.shortRegisterDate = shortRegisterDate;
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

	public boolean isHasAttachment() {
		return hasAttachment;
	}

	public void setHasAttachment(boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	public boolean isTopOfList() {
		return isTopOfList;
	}

	public void setTopOfList(boolean isTopOfList) {
		this.isTopOfList = isTopOfList;
	}

	@Override
	public String toString() {
		return "NoticesByLanguageResponse [noticeSeq=" + noticeSeq + ", registerDate=" + registerDate + ", shortRegisterDate=" + shortRegisterDate + ", title=" + title + ", writer=" + writer + ", hasAttachment=" + hasAttachment + ", isTopOfList=" + isTopOfList + "]";
	}

}
