package com.pines.student.push.vo;

import com.pines.student.common.Tools;

public class PushCondition {
	private String menu;
	private int studySeq;
	private int noticeSeq;
	private int examSeq;
	private int requestSeq;
	private String studentId;

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

	public boolean isStudyHistory() {
		return this.studySeq > 0;
	}

	public int getNoticeSeq() {
		return noticeSeq;
	}

	public void setNoticeSeq(int noticeSeq) {
		this.noticeSeq = noticeSeq;
	}

	public boolean isNoticeHistory() {
		return this.noticeSeq > 0;
	}

	public int getExamSeq() {
		return examSeq;
	}

	public void setExamSeq(int examSeq) {
		this.examSeq = examSeq;
	}

	public boolean isExamHistory() {
		return this.examSeq > 0;
	}

	public int getRequestSeq() {
		return requestSeq;
	}

	public void setRequestSeq(int requestSeq) {
		this.requestSeq = requestSeq;
	}

	public boolean isRequestHistory() {
		return this.requestSeq > 0;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public boolean isStudentHistory() {
		return Tools.isNotEmpty(studentId);
	}

	@Override
	public String toString() {
		return "PushCondition [menu=" + menu + ", studySeq=" + studySeq + ", noticeSeq=" + noticeSeq + ", examSeq=" + examSeq + ", requestSeq=" + requestSeq + ", studentId=" + studentId + "]";
	}

}
