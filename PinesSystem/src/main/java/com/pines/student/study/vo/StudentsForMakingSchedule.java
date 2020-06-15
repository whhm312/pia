package com.pines.student.study.vo;

public class StudentsForMakingSchedule {
	private String branch;
	private String campus;
	private String term;
	private String studentName;
	private String nationality;
	private String preLevel;
	private String arrivalDate;
	private String departureDate;
	private String course;
	private String sex;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPreLevel() {
		return preLevel;
	}

	public void setPreLevel(String preLevel) {
		this.preLevel = preLevel;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "StudentsForMakingSchedule [branch=" + branch + ", campus=" + campus + ", term=" + term + ", studentName=" + studentName + ", nationality=" + nationality + ", preLevel=" + preLevel + ", arrivalDate=" + arrivalDate + ", departureDate=" + departureDate + ", course="
				+ course + ", sex=" + sex + "]";
	}

}
