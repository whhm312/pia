package com.pines.student.student.admin.vo;

import com.pines.student.common.vo.StudentIdCard;

public class RegisterStudentIdCardRequest {
	private String idCardSerialNumber;
	private String reasonType;
	private String memo;

	public String getIdCardSerialNumber() {
		return idCardSerialNumber;
	}

	public void setIdCardSerialNumber(String idCardSerialNumber) {
		this.idCardSerialNumber = idCardSerialNumber;
	}

	public String getReasonType() {
		return reasonType;
	}

	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "RegisterStudentIdCardRequest [idCardSerialNumber=" + idCardSerialNumber + ", reasonType=" + reasonType + ", memo=" + memo + "]";
	}

	public StudentIdCard getStudentIdCard(String staffId, String studentId) {
		StudentIdCard result = new StudentIdCard();
		result.setStudentId(studentId);
		result.setIdCardSerialNumber(idCardSerialNumber);
		result.setReasonType(reasonType);
		result.setMemo(memo);
		result.setStaffId(staffId);
		return result;
	}

}
