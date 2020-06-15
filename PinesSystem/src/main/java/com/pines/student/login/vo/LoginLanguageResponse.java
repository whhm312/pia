package com.pines.student.login.vo;

public class LoginLanguageResponse {
	private int languageSeq;
	private String languageName;

	public int getLanguageSeq() {
		return languageSeq;
	}

	public void setLanguageSeq(int languageSeq) {
		this.languageSeq = languageSeq;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@Override
	public String toString() {
		return "LoginLanguageResponse [languageSeq=" + languageSeq + ", languageName=" + languageName + "]";
	}

}
