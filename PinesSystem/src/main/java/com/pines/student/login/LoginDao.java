package com.pines.student.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pines.student.common.vo.Activity;
import com.pines.student.common.vo.Alarm;
import com.pines.student.common.vo.Branch;
import com.pines.student.common.vo.Campus;
import com.pines.student.common.vo.EmergencyContact;
import com.pines.student.common.vo.Language;
import com.pines.student.common.vo.Notice;
import com.pines.student.login.vo.StaffLoginDetailsVO;
import com.pines.student.login.vo.StudentAutoLogin;
import com.pines.student.login.vo.StudentLoginDetailsVO;

@Repository
public class LoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public StudentLoginDetailsVO login(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, S.STUDENT_ID AS 'USERNAME', ");
		query.append("(SELECT  L.LANGUAGE_NAME FROM pia_languages L WHERE L.LANGUAGE_SEQ = S.LANGUAGE_SEQ) AS 'LANGUAGE', ");
		query.append("(SELECT T.TERM_NAME FROM pia_term_details T WHERE T.TERM_DETAIL_SEQ = S.TERM_DETAIL_SEQ) AS 'TERM', ");
		query.append("(SELECT  C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = S.CAMPUS_SEQ) AS 'CAMPUS', ");
		query.append("(SELECT  B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = S.BRANCH_SEQ) AS 'BRANCH' ");
		query.append("FROM pia_students S ");
		query.append("WHERE S.STUDENT_ID = '");
		query.append(studentId);
		query.append("'");

		StudentLoginDetailsVO result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), new BeanPropertyRowMapper<StudentLoginDetailsVO>(StudentLoginDetailsVO.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new StudentLoginDetailsVO();
		}
		return result;
	}

	public List<Notice> getLoginNotices(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT N.*, ");
		query.append("GET_WRITER_NAME_WITH_TITLE(N.WRITER_ID) AS 'WRITER', ");
		query.append("DATE_FORMAT(N.POPUP_START_DATE, '%Y/%m/%d') AS 'FORM_START_DATE', ");
		query.append("DATE_FORMAT(N.POPUP_END_DATE, '%Y/%m/%d') AS 'FORM_END_DATE', ");
		query.append("DATE_FORMAT(N.REGISTER_DATE, '%Y/%m/%d %r') AS 'FORM_REGISTER_DATE' ");
		query.append("FROM pia_notices N ");
		query.append("WHERE N.IS_DELETED IS FALSE ");
		query.append("AND N.BRANCH_SEQ = (SELECT S.BRANCH_SEQ FROM pia_students S WHERE S.STUDENT_ID = '");
		query.append(studentId);
		query.append("') ");
		query.append("AND (N.LANGUAGE_SEQ = (SELECT S.LANGUAGE_SEQ FROM pia_students S WHERE S.STUDENT_ID = '");
		query.append(studentId);
		query.append("')  OR (N.LANGUAGE_SEQ = 2 AND N.IS_FOR_ALL IS TRUE))");

		query.append("AND N.IS_POPUP IS TRUE ");
		query.append("AND DATE_FORMAT(NOW(), '%Y/%m/%d') BETWEEN DATE_FORMAT(POPUP_START_DATE, '%Y/%m/%d') AND DATE_FORMAT(POPUP_END_DATE, '%Y/%m/%d') ");

		List<Notice> results = null;
		try {
			results = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Notice>(Notice.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<Notice>();
		}
		return results;
	}

	public List<EmergencyContact> getLoginEmergencyContacts(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT E.*, ST.*, ");
		query.append("CONCAT(ST.TITLE, ' ', ST.NICK_NAME) AS 'name', ");
		query.append("DATE_FORMAT(E.REGISTER_DATE, '%Y/%m/%d %r') AS 'FORM_REGISTER_DATE' ");
		query.append("FROM pia_emergency_contacts E, pia_staff ST ");
		query.append("WHERE E.STAFF_ID = ST.STAFF_ID ");
		query.append("  AND E.IS_SHOWN IS TRUE ");
		query.append("  AND E.IS_DELETED IS FALSE ");
		query.append("  AND ST.IS_DELETED IS FALSE ");
		query.append("  AND E.BRANCH_SEQ = (SELECT S.BRANCH_SEQ FROM pia_students S WHERE S.STUDENT_ID = '");
		query.append(studentId);
		query.append("')");

		List<EmergencyContact> results = null;
		try {
			results = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<EmergencyContact>(EmergencyContact.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<EmergencyContact>();
		}
		return results;
	}

	public List<Alarm> getLoginAlarms(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT A.*, ");
		query.append("     (SELECT CONCAT(S.TITLE, ' ', S.NICK_NAME) FROM pia_staff S WHERE S.STAFF_ID = A.SEND_ID) AS 'SENDER', ");
		query.append("     DATE_FORMAT(A.SEND_DATE, '%Y/%m/%d %r') AS 'FORM_SEND_DATE' ");
		query.append(" FROM pia_alarms A ");
		query.append("WHERE A.IS_READ IS FALSE ");
		query.append("  AND A.IS_DELETED IS FALSE ");
		query.append("  AND A.RECEIVE_ID = '");
		query.append(studentId);
		query.append("'");
		query.append("ORDER BY SEND_DATE DESC ");

		List<Alarm> results = null;
		try {
			results = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Alarm>(Alarm.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<Alarm>();
		}
		return results;
	}

	public List<Activity> getLoginActivities(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT A.*, ");
		query.append("GET_WRITER_NAME_WITH_TITLE(A.WRITER_ID) AS 'WRITER', ");
		query.append("DATE_FORMAT(A.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(A.ACCEPT_START_DATE, '%Y/%m/%d') AS 'FORM_START_DATE', ");
		query.append("DATE_FORMAT(A.ACCEPT_END_DATE, '%Y/%m/%d') AS 'FORM_END_DATE' ");
		query.append("FROM pia_activities A ");
		query.append("WHERE A.IS_DELETED IS FALSE ");
		query.append("AND NOW() BETWEEN A.ACCEPT_START_DATE AND A.ACCEPT_END_DATE ");
		query.append("AND A.STATUS = 'PLAN' ");
		query.append(" AND A.CAMPUS_SEQ = (SELECT S.CAMPUS_SEQ FROM pia_students S WHERE S.STUDENT_ID = '");
		query.append(studentId);
		query.append("')");
		query.append("ORDER BY A.ACCEPT_END_DATE DESC ");

		List<Activity> results = null;
		try {
			results = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Activity>(Activity.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<Activity>();
		}
		return results;
	}

	public void setLastLoginDate(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append(" DATE_OF_LAST_LOGIN = NOW() ");
		query.append(" WHERE STUDENT_ID = ? ");
		query.append(" AND IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studentId;

		jdbcTemplate.update(query.toString(), params);
	}

	public StaffLoginDetailsVO getStaff(String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, S.STAFF_ID AS 'USERNAME', ");
		query.append("DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'STAFF_NAME', ");
		query.append("2 AS 'LANGUAGE_SEQ', ");
		query.append("(SELECT  B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = S.BRANCH_SEQ) as 'BRANCH' ");
		query.append("FROM pia_staff S ");
		query.append("WHERE S.STAFF_ID = ? ");
		query.append(" AND S.IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = staffId;

		StaffLoginDetailsVO result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<StaffLoginDetailsVO>(StaffLoginDetailsVO.class));

			query.setLength(0);
			query.append("SELECT B.* ");
			query.append("FROM pia_branches B, pia_staff_authorizations A ");
			query.append("WHERE B.BRANCH_SEQ = A.BRANCH_SEQ ");
			query.append("AND B.IS_DELETED IS FALSE ");
			query.append("AND A.IS_DELETED IS FALSE ");
			query.append("AND A.STAFF_ID = ? ");

			List<Branch> branches = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Branch>(Branch.class));
			result.setBranches(branches);

			query.setLength(0);
			query.append("SELECT C.* ");
			query.append("FROM pia_campuses C, pia_staff_authorizations A ");
			query.append("WHERE C.BRANCH_SEQ = A.BRANCH_SEQ ");
			query.append("AND C.IS_DELETED IS FALSE ");
			query.append("AND A.IS_DELETED IS FALSE ");
			query.append("AND A.STAFF_ID = ? ");
			query.append("ORDER BY BRANCH_SEQ, ORDER_SEQ ");

			List<Campus> campuses = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Campus>(Campus.class));
			result.setCampuses(campuses);

			query.setLength(0);
			query.append("SELECT * ");
			query.append("FROM pia_languages ");
			query.append("WHERE IS_DELETED IS FALSE ");
			query.append("ORDER BY LANGUAGE_NAME ");

			List<Language> languages = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Language>(Language.class));
			result.setLanguages(languages);

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new StaffLoginDetailsVO();
		}
		return result;
	}

	public StudentAutoLogin loginAuto(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.* ");
		query.append("FROM pia_students S ");
		query.append("WHERE S.STUDENT_ID = '");
		query.append(studentId);
		query.append("'");

		StudentAutoLogin result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), new BeanPropertyRowMapper<StudentAutoLogin>(StudentAutoLogin.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new StudentAutoLogin();
		}
		return result;
	}

}
