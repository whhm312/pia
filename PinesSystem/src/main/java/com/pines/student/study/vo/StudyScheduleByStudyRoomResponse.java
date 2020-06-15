package com.pines.student.study.vo;

import java.util.List;

public class StudyScheduleByStudyRoomResponse {
	private String studyRoom;
	private List<StudyScheduleResponse> details;

	public String getStudyRoom() {
		return studyRoom;
	}

	public void setStudyRoom(String studyRoom) {
		this.studyRoom = studyRoom;
	}

	public List<StudyScheduleResponse> getDetails() {
		return details;
	}

	public void setDetails(List<StudyScheduleResponse> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "StudyScheduleByStudyRoomResponse [studyRoom=" + studyRoom + ", details=" + details + "]";
	}

}
