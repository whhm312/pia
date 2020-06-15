package com.pines.student.common.vo;

public class Language {
	private int languageSeq;
	private String languageName;
	private boolean isDeleted;
	private String registerDate;

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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "Language [languageSeq=" + languageSeq + ", languageName=" + languageName + ", isDeleted=" + isDeleted + ", registerDate=" + registerDate + "]";
	}

}
