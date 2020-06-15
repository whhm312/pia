package com.pines.student.attendance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Attendance;
import com.pines.student.common.vo.SearchCondition;

@Repository
public class AttendanceDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Attendance> getAttendances(SearchCondition condition) {
		int idx = 0;
		Object[] params = null;
		int whereCnt = 5;

		StringBuffer query = new StringBuffer();
		query.append("SELECT *, ");
		query.append(" (SELECT  B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = A.BRANCH_SEQ) AS 'BRANCH', ");
		query.append(" (SELECT C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = A.CAMPUS_SEQ) AS 'CAMPUS', ");
		query.append(" (SELECT NAME FROM pia_students T WHERE T.STUDENT_ID = A.STUDENT_ID) AS 'STUDENT_NAME', ");
		query.append(" DATE_FORMAT(A.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append(" (SELECT STUDY_TIME FROM pia_study_timetables T WHERE T.TIMETABLE_SEQ = A.TIMETABLE_SEQ) AS 'CLASS_TIME' ");
		query.append("  FROM pia_attendances A ");
		query.append(" WHERE IS_DELETED IS FALSE ");
		query.append("   AND BRANCH_SEQ = ? ");
		query.append("   AND CAMPUS_SEQ = ? ");
		query.append("   AND CLASS_DATE = ? ");
		if (condition.isNameCondition()) {
			query.append("   AND STUDENT_ID = (SELECT STUDENT_ID FROM pia_student WHERE BRANCH_SEQ = ? AND CAMPUS_SEQ = ? AND NAME LIKE ? ) ");
			whereCnt += 3;
		}
		query.append(" ORDER BY FIELD (CLASS_TIME, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6) ");
		query.append(" LIMIT ?, ? ");

		idx = 0;
		params = new Object[whereCnt];
		params[idx++] = condition.getBranchSeq();
		params[idx++] = condition.getCampusSeq();
		params[idx++] = condition.getClassDate();

		if (condition.isNameCondition()) {
			params[idx++] = condition.getBranchSeq();
			params[idx++] = condition.getCampusSeq();
			params[idx++] = "%" + condition.getName() + "%";
		}

		params[idx++] = condition.getStartIndex();
		params[idx++] = condition.getOffset();

		List<Attendance> results = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Attendance>(Attendance.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<Attendance>();
		}

		query.setLength(0);
		query.append("SELECT COUNT(*) ");
		query.append("  FROM pia_attendances ");
		query.append(" WHERE IS_DELETED IS FALSE ");
		query.append("   AND BRANCH_SEQ = ? ");
		query.append("   AND CAMPUS_SEQ = ? ");
		query.append("   AND CLASS_DATE = ? ");
		if (condition.isNameCondition()) {
			query.append("   AND STUDENT_ID = (SELECT STUDENT_ID FROM pia_student WHERE BRANCH_SEQ = ? AND CAMPUS_SEQ = ? AND NAME LIKE ? ) ");
			whereCnt += 3;
		}

		idx = 0;
		params = new Object[whereCnt - 2];
		params[idx++] = condition.getBranchSeq();
		params[idx++] = condition.getCampusSeq();
		params[idx++] = condition.getClassDate();

		if (condition.isNameCondition()) {
			params[idx++] = condition.getBranchSeq();
			params[idx++] = condition.getCampusSeq();
			params[idx++] = "%" + condition.getName() + "%";
		}

		int totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		if (results.size() > 0) {
			results.get(0).setTotalCount(Tools.getInt(totalCount));
		}

		return results;
	}

	public Attendance getAttendance(int attendanceSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("  FROM pia_attendances ");
		query.append(" WHERE IS_DELETED IS FALSE ");
		query.append("   AND ATTENDANCE_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = attendanceSeq;

		Attendance result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<Attendance>(Attendance.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new Attendance();
		}
		return result;
	}

	public boolean addAttendance(Attendance attendance) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_attendances ( ");
		query.append("BRANCH_SEQ, CAMPUS_SEQ, TIMETABLE_SEQ, ");
		query.append("ATTENDANCE_TYPE, IS_EXCUSED, STUDENT_ID, CLASS_DATE, MEMO, ");
		query.append("REGISTER_DATE, IS_DELETED, REGISTER_STAFF_ID ");
		query.append(") ");
		query.append("VALUES ");
		query.append("( ");
		query.append("?, ?, ?, ");
		query.append("?, ?, ?, ?, ?, ");
		query.append("NOW(), 0, ? ");
		query.append(") ");

		int idx = 0;
		Object[] params = new Object[9];
		params[idx++] = attendance.getBranchSeq();
		params[idx++] = attendance.getCampusSeq();
		params[idx++] = attendance.getTimetableSeq();
		params[idx++] = attendance.getAttendanceType();
		params[idx++] = attendance.getIsExcused();
		params[idx++] = attendance.getStudentId();
		params[idx++] = attendance.getClassDate();
		params[idx++] = attendance.getMemo();
		params[idx++] = attendance.getRegisterStaffId();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean removeAttendance(int attendanceSeq, String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_attendances SET ");
		query.append("IS_DELETED = 1, DELETE_DATE = NOW(), DELETE_STAFF_ID = ? ");
		query.append("WHERE ATTENDANCE_SEQ = ?");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = staffId;
		params[idx++] = attendanceSeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

}
