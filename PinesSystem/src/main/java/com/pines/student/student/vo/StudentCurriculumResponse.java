package com.pines.student.student.vo;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Student;

public class StudentCurriculumResponse {
	private String startOfContractDate;
	private String endOfContractDate;
	private String course;
	private String level;
	private String weeks;
	private String campus;
	private String term;
	private String requestCourse;

	public String getStartOfContractDate() {
		return startOfContractDate;
	}

	public void setStartOfContractDate(String startOfContractDate) {
		this.startOfContractDate = startOfContractDate;
	}

	public String getEndOfContractDate() {
		return endOfContractDate;
	}

	public void setEndOfContractDate(String endOfContractDate) {
		this.endOfContractDate = endOfContractDate;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getWeeks() {
		return weeks;
	}

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getRequestCourse() {
		return requestCourse;
	}

	public void setRequestCourse(String requestCourse) {
		this.requestCourse = requestCourse;
	}

	@Override
	public String toString() {
		return "StudentCurriculumResponse [startOfContractDate=" + startOfContractDate + ", endOfContractDate=" + endOfContractDate + ", course=" + course + ", level=" + level + ", weeks=" + weeks + ", campus=" + campus + ", term=" + term + ", requestCourse=" + requestCourse
				+ "]";
	}

	public StudentCurriculumResponse(Student student) {
		startOfContractDate = Tools.blankInsteadOfNull(student.getFormDateOfStartContract());
		endOfContractDate = Tools.blankInsteadOfNull(student.getFormDateOfEndContract());
		course = Tools.blankInsteadOfNull(student.getCourse());
		requestCourse = Tools.blankInsteadOfNull(student.getRequestCourse());
		level = Tools.blankInsteadOfNull(student.getLevel());
		weeks = Tools.blankInsteadOfNull(student.getWeeks());
		campus = Tools.blankInsteadOfNull(student.getCampus());
		term = Tools.blankInsteadOfNull(student.getTerm());
	}

}
