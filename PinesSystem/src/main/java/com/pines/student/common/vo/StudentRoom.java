package com.pines.student.common.vo;

import java.util.List;

public class StudentRoom {
	private String room;
	private int assignmentStudentCount;
	private List<StudentIdentify> students;

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getAssignmentStudentCount() {
		return assignmentStudentCount;
	}

	public void setAssignmentStudentCount(int assignmentStudentCount) {
		this.assignmentStudentCount = assignmentStudentCount;
	}

	public List<StudentIdentify> getStudents() {
		return students;
	}

	public void setStudents(List<StudentIdentify> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "StudentRoom [room=" + room + ", assignmentStudentCount=" + assignmentStudentCount + ", students=" + students + "]";
	}

}
