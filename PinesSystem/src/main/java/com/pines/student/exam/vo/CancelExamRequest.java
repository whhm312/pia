package com.pines.student.exam.vo;

import org.springframework.security.core.Authentication;

import com.pines.student.common.vo.ExamApplicant;
import com.pines.student.login.vo.StaffLoginDetailsVO;

public class CancelExamRequest {
	private int applicantSeq;

	public int getApplicantSeq() {
		return applicantSeq;
	}

	public void setApplicantSeq(int applicantSeq) {
		this.applicantSeq = applicantSeq;
	}

	@Override
	public String toString() {
		return "CancelExamRequest [applicantSeq=" + applicantSeq + "]";
	}

	public ExamApplicant getExamApplicant(Authentication authentication) {
		ExamApplicant result = new ExamApplicant();
		if (authentication.getPrincipal() instanceof StaffLoginDetailsVO) {
			result.setCancelStaffId(authentication.getName());
		} else {
			result.setCancelStudentId(authentication.getName());
		}
		result.setApplicantSeq(applicantSeq);

		return result;
	}

}
