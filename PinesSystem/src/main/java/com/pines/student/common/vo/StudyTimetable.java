package com.pines.student.common.vo;

import java.util.List;

public class StudyTimetable {
	private int subjectSeq;
	private int studySeq;
	private String branch;
	private String campus;
	private String term;
	private int levelSeq;
	private String studyTime;
	private String subject;
	private String staffId;
	private String writer;
	private String registerDate;
	private String updateDate;
	private boolean isDeleted;
	private String levelName;
	private List<StudyTimetableDetail> details;

	public int getSubjectSeq() {
		return subjectSeq;
	}

	public void setSubjectSeq(int subjectSeq) {
		this.subjectSeq = subjectSeq;
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

	public int getStudySeq() {
		return studySeq;
	}

	public void setStudySeq(int studySeq) {
		this.studySeq = studySeq;
	}

	public int getLevelSeq() {
		return levelSeq;
	}

	public void setLevelSeq(int levelSeq) {
		this.levelSeq = levelSeq;
	}

	public String getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public List<StudyTimetableDetail> getDetails() {
		return details;
	}

	public void setDetails(List<StudyTimetableDetail> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "StudyTimetable [subjectSeq=" + subjectSeq + ", studySeq=" + studySeq + ", branch=" + branch + ", campus=" + campus + ", term=" + term + ", levelSeq=" + levelSeq + ", studyTime=" + studyTime + ", subject=" + subject + ", staffId=" + staffId + ", writer=" + writer
				+ ", registerDate=" + registerDate + ", updateDate=" + updateDate + ", isDeleted=" + isDeleted + ", levelName=" + levelName + ", details=" + details + "]";
	}

}
