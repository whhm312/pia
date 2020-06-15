package com.pines.student.study.vo;

import java.util.List;

public class StudyLevelWithStudentsResponse {
	private String levelName;
	private String writer;
	private String updateDate;
	private List<StudyLevelGroupingResponse> studentNames;

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public List<StudyLevelGroupingResponse> getStudentNames() {
		return studentNames;
	}

	public void setStudentNames(List<StudyLevelGroupingResponse> studentNames) {
		this.studentNames = studentNames;
	}

	@Override
	public String toString() {
		return "StudyLevelWithStudentsResponse [levelName=" + levelName + ", writer=" + writer + ", updateDate=" + updateDate + ", studentNames=" + studentNames + "]";
	}

}
