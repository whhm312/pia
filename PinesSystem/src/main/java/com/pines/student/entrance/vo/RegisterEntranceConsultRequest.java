package com.pines.student.entrance.vo;

import com.pines.student.common.vo.EntranceConsult;

public class RegisterEntranceConsultRequest {
	private String studentId;
	private boolean isExcused;
	private String consultDate;
	private String consultResult;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public boolean isExcused() {
		return isExcused;
	}

	public void setExcused(boolean isExcused) {
		this.isExcused = isExcused;
	}

	public String getConsultDate() {
		return consultDate;
	}

	public void setConsultDate(String consultDate) {
		this.consultDate = consultDate;
	}

	public String getConsultResult() {
		return consultResult;
	}

	public void setConsultResult(String consultResult) {
		this.consultResult = consultResult;
	}

	public EntranceConsult getEntranceConsult(int entranceRecordSeq, String staffId) {
		EntranceConsult result = new EntranceConsult();
		result.setEntranceRecordSeq(entranceRecordSeq);
		result.setStudentId(studentId);
		result.setStaffId(staffId);
		result.setIsExcused(isExcused);
		result.setConsultDate(consultDate);
		result.setConsultResult(consultResult);
		return result;
	}

}
