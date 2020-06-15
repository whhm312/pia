package com.pines.student.student.vo;

public class ChangeStudentLanguageRequest {
	private int languageSeq;

	public int getLanguageSeq() {
		return languageSeq;
	}

	public void setLanguageSeq(int languageSeq) {
		this.languageSeq = languageSeq;
	}

	@Override
	public String toString() {
		return "ChangeStudentLanguageRequest [languageSeq=" + languageSeq + "]";
	}

}
