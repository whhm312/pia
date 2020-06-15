package com.pines.student.study.vo;

public class StudyScheduleStudentVaildateResult {
	private String studyTime;
	private String studyRoom;
	private String studentName;

	public String getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}

	public String getStudyRoom() {
		return studyRoom;
	}

	public void setStudyRoom(String studyRoom) {
		this.studyRoom = studyRoom;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "StudyScheduleStudentVaildateResult [studyTime=" + studyTime + ", studyRoom=" + studyRoom + ", studentName=" + studentName + "]";
	}

}
