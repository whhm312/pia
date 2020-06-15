package com.pines.student.study.vo;

import java.util.List;

public class StudyUnknownStudentLevelsResponse {
	private String level;
	private List<StudyUnknownStudentResponse> students;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<StudyUnknownStudentResponse> getStudents() {
		return students;
	}

	public void setStudents(List<StudyUnknownStudentResponse> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "StudyUnknownStudentLevelsResponse [level=" + level + ", students=" + students + "]";
	}

}
