package com.pines.student.common.vo;

import java.util.List;

public class StudySchedule {
	private int totalCount;
	private int scheduleSeq;
	private int studySeq;
	private int levelSeq;
	private int subjectSeq;
	private String branch;
	private String campus;
	private String term;
	private String level;
	private String studentId;
	private String studentName;
	private String studyTime;
	private String studyRoom;
	private int studyMember;
	private String teacherName;
	private String subject;
	private String staffId;
	private String writer;
	private boolean isDeleted;
	private String registerDate;
	private String updateDate;
	private String formRegisterDate;
	private String formUpdateDate;
	private List<StudyScheduleDetail> details;
	private List<TeacherScheduleDetail> teacherScheduleDetails;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getScheduleSeq() {
		return scheduleSeq;
	}

	public void setScheduleSeq(int scheduleSeq) {
		this.scheduleSeq = scheduleSeq;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getSubjectSeq() {
		return subjectSeq;
	}

	public void setSubjectSeq(int subjectSeq) {
		this.subjectSeq = subjectSeq;
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

	public String getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}

	public String getStudyRoom() {
		return studyRoom;
	}

	public void setStudyRoom(String studyRoom) {
		this.studyRoom = studyRoom;
	}

	public int getStudyMember() {
		return studyMember;
	}

	public void setStudyMember(int studyMember) {
		this.studyMember = studyMember;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public List<StudyScheduleDetail> getDetails() {
		return details;
	}

	public void setDetails(List<StudyScheduleDetail> details) {
		this.details = details;
	}

	public List<TeacherScheduleDetail> getTeacherScheduleDetails() {
		return teacherScheduleDetails;
	}

	public void setTeacherScheduleDetails(List<TeacherScheduleDetail> teacherScheduleDetails) {
		this.teacherScheduleDetails = teacherScheduleDetails;
	}

	@Override
	public String toString() {
		return "StudySchedule [totalCount=" + totalCount + ", scheduleSeq=" + scheduleSeq + ", studySeq=" + studySeq + ", levelSeq=" + levelSeq + ", subjectSeq=" + subjectSeq + ", branch=" + branch + ", campus=" + campus + ", term=" + term + ", level=" + level + ", studentId="
				+ studentId + ", studentName=" + studentName + ", studyTime=" + studyTime + ", studyRoom=" + studyRoom + ", studyMember=" + studyMember + ", teacherName=" + teacherName + ", subject=" + subject + ", staffId=" + staffId + ", writer=" + writer + ", isDeleted="
				+ isDeleted + ", registerDate=" + registerDate + ", updateDate=" + updateDate + ", formRegisterDate=" + formRegisterDate + ", formUpdateDate=" + formUpdateDate + ", details=" + details + ", teacherScheduleDetails=" + teacherScheduleDetails + "]";
	}

}
