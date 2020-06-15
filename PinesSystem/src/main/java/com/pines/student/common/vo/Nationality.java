package com.pines.student.common.vo;

public class Nationality {
	private int nationalitySeq;
	private String code;
	private String nationality;
	private boolean isDeleted;
	private String registerDate;

	public int getNationalitySeq() {
		return nationalitySeq;
	}

	public void setNationalitySeq(int nationalitySeq) {
		this.nationalitySeq = nationalitySeq;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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
		return "Nationality [nationalitySeq=" + nationalitySeq + ", code=" + code + ", nationality=" + nationality + ", isDeleted=" + isDeleted + ", registerDate=" + registerDate + "]";
	}

}
