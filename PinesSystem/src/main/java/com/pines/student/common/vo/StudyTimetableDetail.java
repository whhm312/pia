package com.pines.student.common.vo;

public class StudyTimetableDetail {
	private String studyTime;
	private String subject;

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

	@Override
	public String toString() {
		return "StudyTimetableDetail [studyTime=" + studyTime + ", subject=" + subject + "]";
	}

}
