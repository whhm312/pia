package com.pines.student.student.admin.vo;

import java.util.List;

import com.pines.student.common.vo.StudentNameExcel;

public class ChangeStudentNameResultResponse {
	private List<StudentNameExcel> updateFailedStudents;

	public List<StudentNameExcel> getUpdateFailedStudents() {
		return updateFailedStudents;
	}

	public void setUpdateFailedStudents(List<StudentNameExcel> updateFailedStudents) {
		this.updateFailedStudents = updateFailedStudents;
	}

	@Override
	public String toString() {
		return "ChangeStudentNameResultResponse [updateFailedStudents=" + updateFailedStudents + "]";
	}

}
