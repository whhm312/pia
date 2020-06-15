package com.pines.student.study.vo;

import java.util.List;

public class StudyAllInOneResponse {
	private int studySeq;
	private int branchSeq;
	private int campusSeq;
	private int termSeq;
	private String branch;
	private String campus;
	private String term;
	private String writer;
	private String updateDate;
	private List<StudyLevelWithStudentsResponse> studentLevels;
	private List<StudyLevelWithTimetableResponse> studentTimetables;
	private List<StudyScheduleByStudyRoomResponse> studentStudySchedules;
	private List<StudyUnknownStudentLevelsResponse> unknownStudents;

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

	public List<StudyLevelWithStudentsResponse> getStudentLevels() {
		return studentLevels;
	}

	public void setStudentLevels(List<StudyLevelWithStudentsResponse> studentLevels) {
		this.studentLevels = studentLevels;
	}

	public List<StudyLevelWithTimetableResponse> getStudentTimetables() {
		return studentTimetables;
	}

	public void setStudentTimetables(List<StudyLevelWithTimetableResponse> studentTimetables) {
		this.studentTimetables = studentTimetables;
	}

	public List<StudyScheduleByStudyRoomResponse> getStudentStudySchedules() {
		return studentStudySchedules;
	}

	public void setStudentStudySchedules(List<StudyScheduleByStudyRoomResponse> studentStudySchedules) {
		this.studentStudySchedules = studentStudySchedules;
	}

	public List<StudyUnknownStudentLevelsResponse> getUnknownStudents() {
		return unknownStudents;
	}

	public void setUnknownStudents(List<StudyUnknownStudentLevelsResponse> unknownStudents) {
		this.unknownStudents = unknownStudents;
	}

	@Override
	public String toString() {
		return "StudyAllInOneResponse [studySeq=" + studySeq + ", branchSeq=" + branchSeq + ", campusSeq=" + campusSeq + ", termSeq=" + termSeq + ", branch=" + branch + ", campus=" + campus + ", term=" + term + ", writer=" + writer + ", updateDate=" + updateDate
				+ ", studentLevels=" + studentLevels + ", studentTimetables=" + studentTimetables + ", studentStudySchedules=" + studentStudySchedules + ", unknownStudents=" + unknownStudents + "]";
	}

}
