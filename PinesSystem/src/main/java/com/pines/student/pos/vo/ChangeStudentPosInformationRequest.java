package com.pines.student.pos.vo;

import com.pines.student.common.vo.StudentIdCard;

public class ChangeStudentPosInformationRequest {
	private String idCardSerialNumber;

	public String getIdCardSerialNumber() {
		return idCardSerialNumber;
	}

	public void setIdCardSerialNumber(String idCardSerialNumber) {
		this.idCardSerialNumber = idCardSerialNumber;
	}

	@Override
	public String toString() {
		return "ChangeStudentPosInformationRequest [idCardSerialNumber=" + idCardSerialNumber + "]";
	}

	public StudentIdCard getStudentIdCard(String studentId, String studentName) {
		StudentIdCard studentIdCard = new StudentIdCard();
		studentIdCard.setStudentId(studentId);
		studentIdCard.setStudentName(studentName);
		studentIdCard.setIdCardSerialNumber(idCardSerialNumber);
		return studentIdCard;
	}

}
