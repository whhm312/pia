package com.pines.student.study.vo;

public class StudyScheduleTeacherVaildateResult {
	private String studyTime;
	private String studyRoom;
	private String teacherName;

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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "StudyScheduleVaildateResultsResponse [studyTime=" + studyTime + ", studyRoom=" + studyRoom + ", teacherName=" + teacherName + "]";
	}

}
