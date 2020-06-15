package com.pines.student.login.vo;

public class LoginNoticeResponse {
	private int noticeSeq;
	private String title;
	private String content;
	private String registerDate;
	private String writer;

	public int getNoticeSeq() {
		return noticeSeq;
	}

	public void setNoticeSeq(int noticeSeq) {
		this.noticeSeq = noticeSeq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "LoginNotice [noticeSeq=" + noticeSeq + ", title=" + title + ", content=" + content + ", registerDate=" + registerDate + ", writer=" + writer + "]";
	}

}
