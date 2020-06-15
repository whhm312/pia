package com.pines.student.attendance.vo;

import com.pines.student.common.vo.Attendance;

public class AddAttendanceRequest {
	private int branchSeq;
	private int campusSeq;
	private String attendanceType;
	private boolean isExcused;
	private String studentId;
	private String memo;
	private String classDate;
	private int timetableSeq;

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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getClassDate() {
		return classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}

	public int getTimetableSeq() {
		return timetableSeq;
	}

	public void setTimetableSeq(int timetableSeq) {
		this.timetableSeq = timetableSeq;
	}

	@Override
	public String toString() {
		return "AddAttendanceRequest [branchSeq=" + branchSeq + ", campusSeq=" + campusSeq + ", attendanceType=" + attendanceType + ", isExcused=" + isExcused + ", studentId=" + studentId + ", memo=" + memo + ", classDate=" + classDate + ", timetableSeq=" + timetableSeq + "]";
	}

	public Attendance getAttendance(String staffId) {
		Attendance result = new Attendance();
		result.setBranchSeq(branchSeq);
		result.setCampusSeq(campusSeq);
		result.setAttendanceType(attendanceType);
		result.setIsExcused(isExcused);
		result.setStudentId(studentId);
		result.setClassDate(classDate);
		result.setTimetableSeq(timetableSeq);
		result.setMemo(memo);
		result.setRegisterStaffId(staffId);
		return result;
	}

}
