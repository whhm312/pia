package com.pines.student.evaluation.vo;

public class EvaluationClassesResponse {
	private int scheduleSeq;
	private String teacherName;
	private String subject;

	public int getScheduleSeq() {
		return scheduleSeq;
	}

	public void setScheduleSeq(int scheduleSeq) {
		this.scheduleSeq = scheduleSeq;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "EvaluationClassesResponse [scheduleSeq=" + scheduleSeq + ", teacherName=" + teacherName + ", subject=" + subject + "]";
	}

}
