package com.pines.student.student.admin.vo;

import com.pines.student.common.vo.StudentPeriodHistory;

public class ChangePeriodRequest {
	private String newPeriodStartDate;
	private String newPeriodEndDate;

	public String getNewPeriodStartDate() {
		return newPeriodStartDate;
	}

	public void setNewPeriodStartDate(String newPeriodStartDate) {
		this.newPeriodStartDate = newPeriodStartDate;
	}

	public String getNewPeriodEndDate() {
		return newPeriodEndDate;
	}

	public void setNewPeriodEndDate(String newPeriodEndDate) {
		this.newPeriodEndDate = newPeriodEndDate;
	}

	@Override
	public String toString() {
		return "ChangePeriodRequest [newPeriodStartDate=" + newPeriodStartDate + ", newPeriodEndDate=" + newPeriodEndDate + "]";
	}

	public StudentPeriodHistory getNewPeriod(String staffId, String studentId) {
		StudentPeriodHistory result = new StudentPeriodHistory();
		result.setStaffId(staffId);
		result.setStudentId(studentId);
		result.setNewStartDate(newPeriodStartDate);
		result.setNewEndDate(newPeriodEndDate);
		return result;
	}

}
