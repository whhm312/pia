package com.pines.student.entrance.vo;

public class EntranceRecordsResponse {
	private int entranceRecordSeq;
	private int entranceSeq;
	private int consultSeq;
	private String entranceName;
	private String studentName;
	private String outDate;
	private String inDate;
	private String overtime;
	private String staffName;
	private String nationality;
	private String level;
	private String term;
	private String birthday;
	private String room;

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

	public String getEntranceName() {
		return entranceName;
	}

	public void setEntranceName(String entranceName) {
		this.entranceName = entranceName;
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

	public String getOvertime() {
		return overtime;
	}

	public void setOvertime(String overtime) {
		this.overtime = overtime;
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

	@Override
	public String toString() {
		return "EntranceRecordsResponse [entranceRecordSeq=" + entranceRecordSeq + ", entranceSeq=" + entranceSeq + ", consultSeq=" + consultSeq + ", entranceName=" + entranceName + ", studentName=" + studentName + ", outDate=" + outDate + ", inDate=" + inDate + ", overtime="
				+ overtime + ", staffName=" + staffName + ", nationality=" + nationality + ", level=" + level + ", term=" + term + ", birthday=" + birthday + ", room=" + room + "]";
	}

}
