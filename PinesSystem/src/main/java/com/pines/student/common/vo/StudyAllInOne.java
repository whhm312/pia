package com.pines.student.common.vo;

import java.util.List;

public class StudyAllInOne {
	private int totalCount;
	private int studySeq;
	private int branchSeq;
	private int campusSeq;
	private int termSeq;
	private String branch;
	private String campus;
	private String term;
	private String startDate;
	private String endDate;
	private String formStartDate;
	private String formEndDate;
	private String staffId;
	private String writer;
	private String registerDate;
	private String updateDate;
	private String formRegisterDate;
	private String formUpdateDate;
	private List<StudyLevel> levels;
	private List<StudyTimetable> timetables;
	private List<StudySchedule> schedules;
	private List<StudyUnknownStudentLevels> unknownStudents;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStudySeq() {
		return studySeq;
	}

	public void setStudySeq(int studySeq) {
		this.studySeq = studySeq;
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

	public int getTermSeq() {
		return termSeq;
	}

	public void setTermSeq(int termSeq) {
		this.termSeq = termSeq;
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

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getFormStartDate() {
		return formStartDate;
	}

	public void setFormStartDate(String formStartDate) {
		this.formStartDate = formStartDate;
	}

	public String getFormEndDate() {
		return formEndDate;
	}

	public void setFormEndDate(String formEndDate) {
		this.formEndDate = formEndDate;
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

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public String getFormUpdateDate() {
		return formUpdateDate;
	}

	public void setFormUpdateDate(String formUpdateDate) {
		this.formUpdateDate = formUpdateDate;
	}

	public List<StudyLevel> getLevels() {
		return levels;
	}

	public void setLevels(List<StudyLevel> levels) {
		this.levels = levels;
	}

	public List<StudyTimetable> getTimetables() {
		return timetables;
	}

	public void setTimetables(List<StudyTimetable> timetables) {
		this.timetables = timetables;
	}

	public List<StudySchedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<StudySchedule> schedules) {
		this.schedules = schedules;
	}

	public List<StudyUnknownStudentLevels> getUnknownStudents() {
		return unknownStudents;
	}

	public void setUnknownStudents(List<StudyUnknownStudentLevels> unknownStudents) {
		this.unknownStudents = unknownStudents;
	}

	@Override
	public String toString() {
		return "StudyAllInOne [totalCount=" + totalCount + ", studySeq=" + studySeq + ", branchSeq=" + branchSeq + ", campusSeq=" + campusSeq + ", termSeq=" + termSeq + ", branch=" + branch + ", campus=" + campus + ", term=" + term + ", startDate=" + startDate + ", endDate="
				+ endDate + ", formStartDate=" + formStartDate + ", formEndDate=" + formEndDate + ", staffId=" + staffId + ", writer=" + writer + ", registerDate=" + registerDate + ", updateDate=" + updateDate + ", formRegisterDate=" + formRegisterDate + ", formUpdateDate="
				+ formUpdateDate + ", levels=" + levels + ", timetables=" + timetables + ", schedules=" + schedules + ", unknownStudents=" + unknownStudents + "]";
	}

}
