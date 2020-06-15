package com.pines.student.study.vo;

public class AddStudyResponse {
	private int studySeq;

	public int getStudySeq() {
		return studySeq;
	}

	public void setStudySeq(int studySeq) {
		this.studySeq = studySeq;
	}

	@Override
	public String toString() {
		return "AddStudyResponse [studySeq=" + studySeq + "]";
	}

}
