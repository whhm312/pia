package com.pines.student.common.vo;

public class IdCardExcel {
	private String A_Name;
	private String B_StudentId;
	private String C_CardSerialNumber;

	public String getA_Name() {
		return A_Name;
	}

	public void setA_Name(String a_Name) {
		A_Name = a_Name;
	}

	public String getB_StudentId() {
		return B_StudentId;
	}

	public void setB_StudentId(String b_StudentId) {
		B_StudentId = b_StudentId;
	}

	public String getC_CardSerialNumber() {
		return C_CardSerialNumber;
	}

	public void setC_CardSerialNumber(String c_CardSerialNumber) {
		C_CardSerialNumber = c_CardSerialNumber;
	}

	@Override
	public String toString() {
		return "IdCardExcel [A_Name=" + A_Name + ", B_StudentId=" + B_StudentId + ", C_CardSerialNumber=" + C_CardSerialNumber + "]";
	}

}
