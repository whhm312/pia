package com.pines.student.common.vo;

public class Subject {
	private int subjectSeq;
	private int termSeq;
	private String startDate;
	private String endDate;
	private String formStartDate;
	private String formEndDate;
	private String studyTime;
	private String level;
	private String subject;
	private boolean isDeleted;
	private String registerDate;
	private String updateDate;
	private String formRegisterDate;
	private String formUpdateDate;

	public int getSubjectSeq() {
		return subjectSeq;
	}

	public void setSubjectSeq(int subjectSeq) {
		this.subjectSeq = subjectSeq;
	}

	public int getTermSeq() {
		return termSeq;
	}

	public void setTermSeq(int termSeq) {
		this.termSeq = termSeq;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getFormStartDate() {
		return formStartDate;
	}

	public void setFormStartDate(String formStartDate) {
		this.formStartDate = formStartDate;
	}

	public String getFormEndDate() {
		return formEndDate;
	}

	public void setFormEndDate(String formEndDate) {
		this.formEndDate = formEndDate;
	}

	public String getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public String getFormUpdateDate() {
		return formUpdateDate;
	}

	public void setFormUpdateDate(String formUpdateDate) {
		this.formUpdateDate = formUpdateDate;
	}

	@Override
	public String toString() {
		return "Subject [subjectSeq=" + subjectSeq + ", termSeq=" + termSeq + ", startDate=" + startDate + ", endDate=" + endDate + ", formStartDate=" + formStartDate + ", formEndDate=" + formEndDate + ", studyTime=" + studyTime + ", level=" + level + ", subject=" + subject
				+ ", isDeleted=" + isDeleted + ", registerDate=" + registerDate + ", updateDate=" + updateDate + ", formRegisterDate=" + formRegisterDate + ", formUpdateDate=" + formUpdateDate + "]";
	}

}
