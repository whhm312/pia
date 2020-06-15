package com.pines.student.student.admin.vo;

import java.util.List;

import com.pines.student.common.vo.IdCardExcel;

public class RegisterIdCardsResultResponse {
	private List<IdCardExcel> updateFailedStudents;

	public List<IdCardExcel> getUpdateFailedStudents() {
		return updateFailedStudents;
	}

	public void setUpdateFailedStudents(List<IdCardExcel> updateFailedStudents) {
		this.updateFailedStudents = updateFailedStudents;
	}

	@Override
	public String toString() {
		return "RegisterIdCardsResultResponse [updateFailedStudents=" + updateFailedStudents + "]";
	}

}
