package com.pines.student.common.vo;

import java.util.List;

public class StudyUnknownStudentLevels {
	private String level;
	private List<StudyUnknownStudent> students;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<StudyUnknownStudent> getStudents() {
		return students;
	}

	public void setStudents(List<StudyUnknownStudent> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "StudyUnknownStudentLevels [level=" + level + ", students=" + students + "]";
	}

}
