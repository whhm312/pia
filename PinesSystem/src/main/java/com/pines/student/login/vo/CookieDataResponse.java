package com.pines.student.login.vo;

public class CookieDataResponse {
	private int seq;
	private String name;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CookieDataResponse [seq=" + seq + ", name=" + name + "]";
	}

}
