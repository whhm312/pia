package com.pines.student.common.vo;

public class StudentNameExcel {
	private String A_StudentId;
	private String B_OriginalName;
	private String C_NewName;

	public String getA_StudentId() {
		return A_StudentId;
	}

	public void setA_StudentId(String a_StudentId) {
		A_StudentId = a_StudentId;
	}

	public String getB_OriginalName() {
		return B_OriginalName;
	}

	public void setB_OriginalName(String b_OriginalName) {
		B_OriginalName = b_OriginalName;
	}

	public String getC_NewName() {
		return C_NewName;
	}

	public void setC_NewName(String c_NewName) {
		C_NewName = c_NewName;
	}

	@Override
	public String toString() {
		return "StudentNameExcel [A_StudentId=" + A_StudentId + ", B_OriginalName=" + B_OriginalName + ", C_NewName=" + C_NewName + "]";
	}

}
