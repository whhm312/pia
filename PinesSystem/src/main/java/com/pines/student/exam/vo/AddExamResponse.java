package com.pines.student.exam.vo;

public class AddExamResponse {
	private int examSeq;

	public int getExamSeq() {
		return examSeq;
	}

	public void setExamSeq(int examSeq) {
		this.examSeq = examSeq;
	}

	@Override
	public String toString() {
		return "AddExamResponse [examSeq=" + examSeq + "]";
	}

}
