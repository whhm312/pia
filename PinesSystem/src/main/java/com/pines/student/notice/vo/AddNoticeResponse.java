package com.pines.student.notice.vo;

public class AddNoticeResponse {
	private int noticeSeq;

	public int getNoticeSeq() {
		return noticeSeq;
	}

	public void setNoticeSeq(int noticeSeq) {
		this.noticeSeq = noticeSeq;
	}

	@Override
	public String toString() {
		return "AddNoticeResponse [noticeSeq=" + noticeSeq + "]";
	}

}
