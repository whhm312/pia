package com.pines.student.exam.vo;

import com.pines.student.common.vo.Exam;

public class AddExamRequest {
	private String examStartDate;
	private String examEndDate;
	private String examType;

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

	@Override
	public String toString() {
		return "AddExamRequest [examStartDate=" + examStartDate + ", examEndDate=" + examEndDate + ", examType=" + examType + "]";
	}

	public Exam getExam(int branchSeq, int campusSeq, int termSeq, String staffId) {
		Exam result = new Exam();
		result.setExamEndDate(examEndDate);
		result.setExamStartDate(examStartDate);
		result.setBranchSeq(branchSeq);
		result.setCampusSeq(campusSeq);
		result.setTermSeq(termSeq);
		result.setExamType(examType);
		result.setStaffId(staffId);
		return result;
	}

}
