package com.pines.student.study.vo;

public class StudentStudyScheduleResponse {
	private String time;
	private String studyRoom;
	private String subject;
	private String teacher;
	private int studyMember;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStudyRoom() {
		return studyRoom;
	}

	public void setStudyRoom(String studyRoom) {
		this.studyRoom = studyRoom;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getStudyMember() {
		return studyMember;
	}

	public void setStudyMember(int studyMember) {
		this.studyMember = studyMember;
	}

	@Override
	public String toString() {
		return "StudentStudyResponse [time=" + time + ", studyRoom=" + studyRoom + ", subject=" + subject + ", teacher=" + teacher + ", studyMember=" + studyMember + "]";
	}
}
