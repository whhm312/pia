package com.pines.student.exam.vo;

import java.util.List;

import com.pines.student.exam.result.vo.ExamResultsResponse;

public class ExamResponse {
	private int examSeq;
	private String branch;
	private String campus;
	private String term;
	private String examType;
	private String examStartDate;
	private String examEndDate;
	private int saveResultCount;
	private String updateDate;
	private List<ExamResultsResponse> results;

	public int getExamSeq() {
		return examSeq;
	}

	public void setExamSeq(int examSeq) {
		this.examSeq = examSeq;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
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

	public int getSaveResultCount() {
		return saveResultCount;
	}

	public void setSaveResultCount(int saveResultCount) {
		this.saveResultCount = saveResultCount;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public List<ExamResultsResponse> getResults() {
		return results;
	}

	public void setResults(List<ExamResultsResponse> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "ExamResponse [examSeq=" + examSeq + ", branch=" + branch + ", campus=" + campus + ", term=" + term + ", examType=" + examType + ", examStartDate=" + examStartDate + ", examEndDate=" + examEndDate + ", saveResultCount=" + saveResultCount + ", updateDate="
				+ updateDate + ", results=" + results + "]";
	}

}
