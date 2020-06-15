package com.pines.student.common.vo;

public class Attendance {
	private int totalCount;
	private int attendanceSeq;
	private int branchSeq;
	private int campusSeq;
	private String branch;
	private String campus;
	private String attendanceType;
	private boolean isExcused;
	private String studentId;
	private String studentName;
	private String classTeacherName;
	private String classDate;
	private String classTime;
	private String classRoom;
	private String registerDate;
	private String formRegisterDate;
	private String registerStaffId;
	private String deleteDate;
	private String formDeleteDate;
	private String deleteStaffId;
	private String memo;
	private boolean isDeleted;
	private int timetableSeq;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getAttendanceSeq() {
		return attendanceSeq;
	}

	public void setAttendanceSeq(int attendanceSeq) {
		this.attendanceSeq = attendanceSeq;
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

	public String getAttendanceType() {
		return attendanceType;
	}

	public void setAttendanceType(String attendanceType) {
		this.attendanceType = attendanceType;
	}

	public boolean getIsExcused() {
		return isExcused;
	}

	public void setIsExcused(boolean isExcused) {
		this.isExcused = isExcused;
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

	public String getClassTeacherName() {
		return classTeacherName;
	}

	public void setClassTeacherName(String classTeacherName) {
		this.classTeacherName = classTeacherName;
	}

	public String getClassDate() {
		return classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}

	public String getClassTime() {
		return classTime;
	}

	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public String getRegisterStaffId() {
		return registerStaffId;
	}

	public void setRegisterStaffId(String registerStaffId) {
		this.registerStaffId = registerStaffId;
	}

	public String getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getFormDeleteDate() {
		return formDeleteDate;
	}

	public void setFormDeleteDate(String formDeleteDate) {
		this.formDeleteDate = formDeleteDate;
	}

	public String getDeleteStaffId() {
		return deleteStaffId;
	}

	public void setDeleteStaffId(String deleteStaffId) {
		this.deleteStaffId = deleteStaffId;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getTimetableSeq() {
		return timetableSeq;
	}

	public void setTimetableSeq(int timetableSeq) {
		this.timetableSeq = timetableSeq;
	}

	@Override
	public String toString() {
		return "Attendance [totalCount=" + totalCount + ", attendanceSeq=" + attendanceSeq + ", branchSeq=" + branchSeq + ", campusSeq=" + campusSeq + ", branch=" + branch + ", campus=" + campus + ", attendanceType=" + attendanceType + ", isExcused=" + isExcused + ", studentId="
				+ studentId + ", studentName=" + studentName + ", classTeacherName=" + classTeacherName + ", classDate=" + classDate + ", classTime=" + classTime + ", classRoom=" + classRoom + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate
				+ ", registerStaffId=" + registerStaffId + ", deleteDate=" + deleteDate + ", formDeleteDate=" + formDeleteDate + ", deleteStaffId=" + deleteStaffId + ", memo=" + memo + ", isDeleted=" + isDeleted + ", timetableSeq=" + timetableSeq + "]";
	}

}
