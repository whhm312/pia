package com.pines.student.common.vo;

public class Timetable {
	private int totalCount;
	private int timetableSeq;
	private int studySeq;
	private int levelSeq;
	private String studyTime;
	private String subjet;
	private String staffId;
	private String updateDate;
	private String registerDate;
	private String formUpdateDate;
	private String formRegisterDate;
	private boolean isDeleted;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTimetableSeq() {
		return timetableSeq;
	}

	public void setTimetableSeq(int timetableSeq) {
		this.timetableSeq = timetableSeq;
	}

	public int getStudySeq() {
		return studySeq;
	}

	public void setStudySeq(int studySeq) {
		this.studySeq = studySeq;
	}

	public int getLevelSeq() {
		return levelSeq;
	}

	public void setLevelSeq(int levelSeq) {
		this.levelSeq = levelSeq;
	}

	public String getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}

	public String getSubjet() {
		return subjet;
	}

	public void setSubjet(String subjet) {
		this.subjet = subjet;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Timetable [totalCount=" + totalCount + ", timetableSeq=" + timetableSeq + ", studySeq=" + studySeq + ", levelSeq=" + levelSeq + ", studyTime=" + studyTime + ", subjet=" + subjet + ", staffId=" + staffId + ", updateDate=" + updateDate + ", registerDate="
				+ registerDate + ", formUpdateDate=" + formUpdateDate + ", formRegisterDate=" + formRegisterDate + ", isDeleted=" + isDeleted + "]";
	}

}
