package com.pines.student.common.vo;

public class StudentChangeName {
	private String studentId;
	private String originalName;
	private String newName;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	@Override
	public String toString() {
		return "StudentChangeName [studentId=" + studentId + ", originalName=" + originalName + ", newName=" + newName + "]";
	}

}
