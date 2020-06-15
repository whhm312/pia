package com.pines.student.common.vo;

public class StudyUnknownStudent {
	private int unknownSeq;
	private int studySeq;
	private String studentName;
	private String studentLevel;
	private String staffId;
	private String writer;
	private String registerDate;
	private String formRegisterDate;

	public int getUnknownSeq() {
		return unknownSeq;
	}

	public void setUnknownSeq(int unknownSeq) {
		this.unknownSeq = unknownSeq;
	}

	public int getStudySeq() {
		return studySeq;
	}

	public void setStudySeq(int studySeq) {
		this.studySeq = studySeq;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentLevel() {
		return studentLevel;
	}

	public void setStudentLevel(String studentLevel) {
		this.studentLevel = studentLevel;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	@Override
	public String toString() {
		return "StudyUnknownStudent [unknownSeq=" + unknownSeq + ", studySeq=" + studySeq + ", studentName=" + studentName + ", studentLevel=" + studentLevel + ", staffId=" + staffId + ", writer=" + writer + ", registerDate=" + registerDate + ", formRegisterDate="
				+ formRegisterDate + "]";
	}

}
