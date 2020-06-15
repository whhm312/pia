package com.pines.student.study.vo;

public class StudyScheduleResponse {
	private String studyTime;
	private String teacherName;
	private String studentName;
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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudyMember() {
		return studyMember;
	}

	public void setStudyMember(int studyMember) {
		this.studyMember = studyMember;
	}

	@Override
	public String toString() {
		return "StudyScheduleResponse [studyTime=" + studyTime + ", teacherName=" + teacherName + ", studentName=" + studentName + ", studyMember=" + studyMember + "]";
	}

}
