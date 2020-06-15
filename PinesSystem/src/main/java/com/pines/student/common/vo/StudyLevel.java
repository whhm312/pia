package com.pines.student.common.vo;

import java.util.List;

public class StudyLevel {
	private int levelSeq;
	private int branchSeq;
	private int campusSeq;
	private String branch;
	private String campus;
	private String levelName;
	private String staffId;
	private String writer;
	private String updateDate;
	private String registerDate;
	private String formUpdateDate;
	private String formRegisterDate;
	private List<StudyLevelGrouping> students;

	public int getLevelSeq() {
		return levelSeq;
	}

	public void setLevelSeq(int levelSeq) {
		this.levelSeq = levelSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getCampusSeq() {
		return campusSeq;
	}

	public void setCampusSeq(int campusSeq) {
		this.campusSeq = campusSeq;
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

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
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

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getFormUpdateDate() {
		return formUpdateDate;
	}

	public void setFormUpdateDate(String formUpdateDate) {
		this.formUpdateDate = formUpdateDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public List<StudyLevelGrouping> getStudents() {
		return students;
	}

	public void setStudents(List<StudyLevelGrouping> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "StudyLevel [levelSeq=" + levelSeq + ", branchSeq=" + branchSeq + ", campusSeq=" + campusSeq + ", branch=" + branch + ", campus=" + campus + ", levelName=" + levelName + ", staffId=" + staffId + ", writer=" + writer + ", updateDate=" + updateDate
				+ ", registerDate=" + registerDate + ", formUpdateDate=" + formUpdateDate + ", formRegisterDate=" + formRegisterDate + ", students=" + students + "]";
	}

}
