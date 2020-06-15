package com.pines.student.push.vo;

import com.pines.student.common.vo.PushRequest;

public class StudentsPushRequest extends PushRequest {
	private String menu;
	private int studySeq;
	private int noticeSeq;
	private int examSeq;

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getStudySeq() {
		return studySeq;
	}

	public void setStudySeq(int studySeq) {
		this.studySeq = studySeq;
	}

	public int getNoticeSeq() {
		return noticeSeq;
	}

	public void setNoticeSeq(int noticeSeq) {
		this.noticeSeq = noticeSeq;
	}

	public int getExamSeq() {
		return examSeq;
	}

	public void setExamSeq(int examSeq) {
		this.examSeq = examSeq;
	}

	@Override
	public String toString() {
		return "StudentsPushRequest [menu=" + menu + ", studySeq=" + studySeq + ", noticeSeq=" + noticeSeq + ", examSeq=" + examSeq + ", getMessage()=" + getMessage() + ", getTitle()=" + getTitle() + ", getImageUrl()=" + getImageUrl() + ", getSite()=" + getSite()
				+ "]";
	}

	public PushRequest getPush() {
		PushRequest result = new PushRequest();
		result.setTitle(getTitle());
		result.setMessage(getMessage());
		result.setImageUrl(getImageUrl());
		result.setSite(getSite());
		return result;
	}

	public PushCondition getCondition() {
		PushCondition condition = new PushCondition();
		condition.setMenu(menu);
		condition.setStudySeq(studySeq);
		condition.setNoticeSeq(noticeSeq);
		condition.setExamSeq(examSeq);
		return condition;
	}

}
