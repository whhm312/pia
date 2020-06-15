package com.pines.student.push.vo;

import com.pines.student.common.vo.PushRequest;

public class StudentPushRequest extends PushRequest {
	private String menu;
	private String studentId;
	private int requestSeq;

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getRequestSeq() {
		return requestSeq;
	}

	public void setRequestSeq(int requestSeq) {
		this.requestSeq = requestSeq;
	}

	@Override
	public String toString() {
		return "StudentPushRequest [menu=" + menu + ", studentId=" + studentId + ", requestSeq=" + requestSeq + ", getMessage()=" + getMessage() + ", getTitle()=" + getTitle() + ", getImageUrl()=" + getImageUrl() + ", getSite()=" + getSite() + "]";
	}

	public PushRequest getPush() {
		return this;
	}

	public PushCondition getCondition(String studentId) {
		PushCondition condition = new PushCondition();
		condition.setMenu(menu);

		if (requestSeq > 0) {
			condition.setRequestSeq(requestSeq);
		} else {
			condition.setStudentId(studentId);
		}
		return condition;
	}

}
