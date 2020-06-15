package com.pines.student.common.vo;

import java.util.List;

public class TeacherScheduleDetail {
	private String studyTime;
	private String teacherName;
	private List<String> studentNames;
	private String subject;
	private String studyRoom;
	private int studyMember;

	public String getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public List<String> getStudentNames() {
		return studentNames;
	}

	public void setStudentNames(List<String> studentNames) {
		this.studentNames = studentNames;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStudyRoom() {
		return studyRoom;
	}

	public void setStudyRoom(String studyRoom) {
		this.studyRoom = studyRoom;
	}

	public int getStudyMember() {
		return studyMember;
	}

	public void setStudyMember(int studyMember) {
		this.studyMember = studyMember;
	}

	@Override
	public String toString() {
		return "TeacherScheduleDetail [studyTime=" + studyTime + ", teacherName=" + teacherName + ", studentNames=" + studentNames + ", subject=" + subject + ", studyRoom=" + studyRoom + ", studyMember=" + studyMember + "]";
	}

}
