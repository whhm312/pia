package com.pines.student.exam.result.vo;

public class StduentExamResultResponse {
	private String examType;
	private String examStartDate;
	private String examEndDate;
	private String term;
	private String filePath;
	private String fileName;

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

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "StduentExamResultResponse [examType=" + examType + ", examStartDate=" + examStartDate + ", examEndDate=" + examEndDate + ", term=" + term + ", filePath=" + filePath + ", fileName=" + fileName + "]";
	}

}
