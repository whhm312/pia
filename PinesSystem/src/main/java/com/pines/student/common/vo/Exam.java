package com.pines.student.common.vo;

import java.util.List;

public class Exam {
	private int totalCount;
	private int examSeq;
	private int branchSeq;
	private int campusSeq;
	private int termSeq;
	private String examStartDate;
	private String examEndDate;
	private String formExamStartDate;
	private String formExamEndDate;
	private String examType;
	private String staffId;
	private String registerDate;
	private String formRegisterDate;
	private boolean isDeleted;
	private String updateDate;
	private String formUpdateDate;
	private String writer;
	private String branch;
	private String campus;
	private String term;
	private int saveResultCount;
	private List<ExamResult> results;
	private int applicantSeq;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getExamSeq() {
		return examSeq;
	}

	public void setExamSeq(int examSeq) {
		this.examSeq = examSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getCampusSeq() {
		return campusSeq;
	}

	public void setCampusSeq(int campusSeq) {
		this.campusSeq = campusSeq;
	}

	public int getTermSeq() {
		return termSeq;
	}

	public void setTermSeq(int termSeq) {
		this.termSeq = termSeq;
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

	public String getFormExamStartDate() {
		return formExamStartDate;
	}

	public void setFormExamStartDate(String formExamStartDate) {
		this.formExamStartDate = formExamStartDate;
	}

	public String getFormExamEndDate() {
		return formExamEndDate;
	}

	public void setFormExamEndDate(String formExamEndDate) {
		this.formExamEndDate = formExamEndDate;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getFormUpdateDate() {
		return formUpdateDate;
	}

	public void setFormUpdateDate(String formUpdateDate) {
		this.formUpdateDate = formUpdateDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public int getSaveResultCount() {
		return saveResultCount;
	}

	public void setSaveResultCount(int saveResultCount) {
		this.saveResultCount = saveResultCount;
	}

	public List<ExamResult> getResults() {
		return results;
	}

	public void setResults(List<ExamResult> results) {
		this.results = results;
	}

	public int getApplicantSeq() {
		return applicantSeq;
	}

	public void setApplicantSeq(int applicantSeq) {
		this.applicantSeq = applicantSeq;
	}

	@Override
	public String toString() {
		return "Exam [totalCount=" + totalCount + ", examSeq=" + examSeq + ", branchSeq=" + branchSeq + ", campusSeq=" + campusSeq + ", termSeq=" + termSeq + ", examStartDate=" + examStartDate + ", examEndDate=" + examEndDate + ", formExamStartDate=" + formExamStartDate
				+ ", formExamEndDate=" + formExamEndDate + ", examType=" + examType + ", staffId=" + staffId + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + ", isDeleted=" + isDeleted + ", updateDate=" + updateDate + ", formUpdateDate="
				+ formUpdateDate + ", writer=" + writer + ", branch=" + branch + ", campus=" + campus + ", term=" + term + ", saveResultCount=" + saveResultCount + ", results=" + results + ", applicantSeq=" + applicantSeq + "]";
	}

}
