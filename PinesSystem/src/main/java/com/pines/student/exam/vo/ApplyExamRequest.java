package com.pines.student.exam.vo;

import org.springframework.security.core.Authentication;

import com.pines.student.common.vo.ExamApplicant;
import com.pines.student.login.vo.StaffLoginDetailsVO;

public class ApplyExamRequest {
	private String studentId;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "ApplyExamRequest [studentId=" + studentId + "]";
	}

	public ExamApplicant getExamApplicant(int examSeq, Authentication authentication) {
		ExamApplicant result = new ExamApplicant();

		if (authentication.getPrincipal() instanceof StaffLoginDetailsVO) {
			result.setRegisterStaffId(authentication.getName());
		} else {
			result.setRegisterStudentId(authentication.getName());
		}
		result.setExamSeq(examSeq);
		result.setStudentId(studentId);

		return result;
	}

}
