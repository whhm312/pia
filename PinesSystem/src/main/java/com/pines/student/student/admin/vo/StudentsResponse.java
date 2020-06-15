package com.pines.student.student.admin.vo;

public class StudentsResponse {
	private int branchSeq;
	private String studentId;
	private String branch;
	private String campus;
	private String nationality;
	private String group;
	private String sex;
	private String term;
	private String room;
	private String name;
	private String dayOfBirth;
	private String inDate;
	private String outDate;
	private String level;
	private String course;
	private String requestCourse;

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getRequestCourse() {
		return requestCourse;
	}

	public void setRequestCourse(String requestCourse) {
		this.requestCourse = requestCourse;
	}

	@Override
	public String toString() {
		return "StudentsResponse [branchSeq=" + branchSeq + ", studentId=" + studentId + ", branch=" + branch + ", campus=" + campus + ", nationality=" + nationality + ", group=" + group + ", sex=" + sex + ", term=" + term + ", room=" + room + ", name=" + name + ", dayOfBirth="
				+ dayOfBirth + ", inDate=" + inDate + ", outDate=" + outDate + ", level=" + level + ", course=" + course + ", requestCourse=" + requestCourse + "]";
	}

}
