package com.pines.student.exam.vo;

public class RecentExamResponse {
	private String examStartDate;
	private String examEndDate;
	private String examType;
	private int examSeq;
	private int applicantSeq;

	public String getExamStartDate() {
		return examStartDate;
	}

	public void setExamStartDate(String examStartDate) {
		this.examStartDate = examStartDate;
	}

	public String getExamEndDate() {
		return examEndDate;
	}

	public void setExamEndDate(String examEndDate) {
		this.examEndDate = examEndDate;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public int getExamSeq() {
		return examSeq;
	}

	public void setExamSeq(int examSeq) {
		this.examSeq = examSeq;
	}

	public int getApplicantSeq() {
		return applicantSeq;
	}

	public void setApplicantSeq(int applicantSeq) {
		this.applicantSeq = applicantSeq;
	}

	@Override
	public String toString() {
		return "RecentExamResponse [examStartDate=" + examStartDate + ", examEndDate=" + examEndDate + ", examType=" + examType + ", examSeq=" + examSeq + ", applicantSeq=" + applicantSeq + "]";
	}

}
