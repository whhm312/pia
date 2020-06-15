package com.pines.student.exam.vo;

public class ApplyExamResponse {
	private int applicantSeq;

	public int getApplicantSeq() {
		return applicantSeq;
	}

	public void setApplicantSeq(int applicantSeq) {
		this.applicantSeq = applicantSeq;
	}

	@Override
	public String toString() {
		return "ApplyExamResponse [applicantSeq=" + applicantSeq + "]";
	}

}
