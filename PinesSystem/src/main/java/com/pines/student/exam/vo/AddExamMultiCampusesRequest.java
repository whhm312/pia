package com.pines.student.exam.vo;

import java.util.ArrayList;
import java.util.List;

import com.pines.student.common.vo.Exam;

public class AddExamMultiCampusesRequest {
	private List<Integer> campuses = new ArrayList<Integer>();
	private String examStartDate;
	private String examEndDate;
	private String examType;

	public List<Integer> getCampuses() {
		return campuses;
	}

	public void setCampuses(List<Integer> campuses) {
		this.campuses = campuses;
	}

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
		return "AddExamMultiCampusesRequest [campuses=" + campuses + ", examStartDate=" + examStartDate + ", examEndDate=" + examEndDate + ", examType=" + examType + "]";
	}

	public List<Exam> getExams(int branchSeq, int termSeq, String name) {
		List<Exam> results = new ArrayList<Exam>();
		Exam exam = null;
		for (Integer campusSeq : campuses) {
			exam = new Exam();
			exam.setBranchSeq(branchSeq);
			exam.setTermSeq(termSeq);
			exam.setCampusSeq(campusSeq);
			exam.setStaffId(name);
			exam.setExamType(examType);
			exam.setExamStartDate(examStartDate);
			exam.setExamEndDate(examEndDate);
			results.add(exam);
		}
		return results;
	}

}
