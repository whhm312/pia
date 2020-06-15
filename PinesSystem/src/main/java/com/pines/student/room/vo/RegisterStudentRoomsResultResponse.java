package com.pines.student.room.vo;

import java.util.ArrayList;
import java.util.List;

public class RegisterStudentRoomsResultResponse {
	private String room;
	private List<String> students = new ArrayList<String>();

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public List<String> getStudents() {
		return students;
	}

	public void addStudent(String studentName) {
		students.add(studentName);
	}

	@Override
	public String toString() {
		return "Saving Failed Information [room=" + room + ", students=" + students + "]";
	}
}
