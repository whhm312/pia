package com.pines.student.study.vo;

import java.util.List;

public class StudyLevelWithTimetableResponse {
	private String levelName;
	private List<StudyTimetableDetailResponse> details;

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public List<StudyTimetableDetailResponse> getDetails() {
		return details;
	}

	public void setDetails(List<StudyTimetableDetailResponse> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "StudyLevelWithTimetableResponse [levelName=" + levelName + ", details=" + details + "]";
	}

}
