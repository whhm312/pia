package com.pines.student.common.vo;

public class EntranceRecord {
	private int totalCount;
	private int entranceRecordSeq;
	private int entranceSeq;
	private int consultSeq;
	private String branch;
	private String campus;
	private String entranceName;
	private String studentId;
	private String studentName;
	private String outDate;
	private String inDate;
	private String formOutDate;
	private String formInDate;
	private int outInGapSeconds;
	private String staffId;
	private String staffName;
	private String nationality;
	private String level;
	private String term;
	private String birthday;
	private String room;
	private String sex;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getEntranceRecordSeq() {
		return entranceRecordSeq;
	}

	public void setEntranceRecordSeq(int entranceRecordSeq) {
		this.entranceRecordSeq = entranceRecordSeq;
	}

	public int getEntranceSeq() {
		return entranceSeq;
	}

	public void setEntranceSeq(int entranceSeq) {
		this.entranceSeq = entranceSeq;
	}

	public int getConsultSeq() {
		return consultSeq;
	}

	public void setConsultSeq(int consultSeq) {
		this.consultSeq = consultSeq;
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

	public String getEntranceName() {
		return entranceName;
	}

	public void setEntranceName(String entranceName) {
		this.entranceName = entranceName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getFormOutDate() {
		return formOutDate;
	}

	public void setFormOutDate(String formOutDate) {
		this.formOutDate = formOutDate;
	}

	public String getFormInDate() {
		return formInDate;
	}

	public void setFormInDate(String formInDate) {
		this.formInDate = formInDate;
	}

	public int getOutInGapSeconds() {
		return outInGapSeconds;
	}

	public void setOutInGapSeconds(int outInGapSeconds) {
		this.outInGapSeconds = outInGapSeconds;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "EntranceRecord [totalCount=" + totalCount + ", entranceRecordSeq=" + entranceRecordSeq + ", entranceSeq=" + entranceSeq + ", consultSeq=" + consultSeq + ", branch=" + branch + ", campus=" + campus + ", entranceName=" + entranceName + ", studentId=" + studentId
				+ ", studentName=" + studentName + ", outDate=" + outDate + ", inDate=" + inDate + ", formOutDate=" + formOutDate + ", formInDate=" + formInDate + ", outInGapSeconds=" + outInGapSeconds + ", staffId=" + staffId + ", staffName=" + staffName + ", nationality="
				+ nationality + ", level=" + level + ", term=" + term + ", birthday=" + birthday + ", room=" + room + ", sex=" + sex + "]";
	}

}
