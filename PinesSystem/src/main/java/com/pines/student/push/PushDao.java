package com.pines.student.push;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.PushHistory;
import com.pines.student.common.vo.PushRequest;
import com.pines.student.common.vo.PushRequest.DEVICE_TYPE;
import com.pines.student.common.vo.StudentDevice;
import com.pines.student.push.vo.PushCondition;

@Repository
public class PushDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean addStudentDevice(StudentDevice studentDevice) {
		StringBuffer query = new StringBuffer();
		int idx = 0;
		Object[] params = null;
		query.append("SELECT COUNT(*) ");
		query.append("  FROM pia_student_devices ");
		query.append(" WHERE TOKEN = ? ");

		params = new Object[1];
		params[idx++] = studentDevice.getToken();

		boolean isDuplicated = jdbcTemplate.queryForObject(query.toString(), params, Integer.class) > 0;
		if (isDuplicated) {
			return true;
		}

		idx = 0;
		query.setLength(0);
		query.append("INSERT INTO pia_student_devices ( ");
		query.append("  STUDENT_ID, OS, TOKEN, REGISTER_DATE ");
		query.append(") VALUES ( ");
		query.append("  ?, ?, ?, NOW() ");
		query.append(" )");

		params = new Object[3];
		params[idx++] = studentDevice.getStudentId();
		params[idx++] = PushRequest.DEVICE_TYPE.valueOf(Tools.getUpperCase(studentDevice.getOs())).name();
		params[idx++] = studentDevice.getToken();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean savePushHistory(PushHistory pushHistory) {
		StringBuffer query = new StringBuffer();
		int idx = 0;
		int paramCount = 12;
		Object[] params = null;
		query.append("INSERT INTO pia_push_history ");
		query.append(" ( ");
		query.append("   RECEIVER_STUDENT_ID, RECEIVER_STUDENT_DEVICE_SEQ, ");
		query.append("   RECEIVER_STUDY_SEQ, RECEIVER_NOTICE_SEQ, RECEIVER_EXAM_SEQ, RECEIVER_REQUEST_SEQ, ");
		query.append("   SENDER_STAFF_ID, SEND_MENU, SEND_DATE, SEND_TOTAL_COUNT, ");
		query.append("   MESSAGE, TITLE, IMAGE_URL, SITE ");
		query.append(" ) ");
		query.append(" VALUES ");
		query.append(" ( ");
		query.append("   ?, ");
		if (pushHistory.getSendTotalCount() < 2 && Tools.isNotEmpty(pushHistory.getReceiverStudentId())) {
			paramCount++;
			query.append("   (SELECT STUDENT_DEVICE_SEQ FROM pia_student_devices WHERE STUDENT_ID = ?), ");
		} else {
			query.append("   NULL, ");
		}
		query.append("   ?, ?, ?, ?, ");
		query.append("   ?, ?, NOW(), ?, ");
		query.append("   ?, ?, ?, ? ");
		query.append(" ) ");

		params = new Object[paramCount];
		params[idx++] = pushHistory.getReceiverStudentId();
		// RECEIVER_STUDENT_DEVICE_SEQ
		if (pushHistory.getSendTotalCount() < 2 && Tools.isNotEmpty(pushHistory.getReceiverStudentId())) {
			params[idx++] = pushHistory.getReceiverStudentId();
		}
		params[idx++] = pushHistory.getReceiverStudySeq();
		params[idx++] = pushHistory.getReceiverNoticeSeq();
		params[idx++] = pushHistory.getReceiverExamSeq();
		params[idx++] = pushHistory.getReceiverRequestSeq();

		params[idx++] = pushHistory.getSenderStaffId();
		params[idx++] = pushHistory.getSendMenu();
		params[idx++] = pushHistory.getSendTotalCount();

		params[idx++] = pushHistory.getMessage();
		params[idx++] = pushHistory.getTitle();
		params[idx++] = pushHistory.getImageUrl();
		params[idx++] = pushHistory.getSite();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public List<StudentDevice> pushStudents(DEVICE_TYPE deviceType, PushCondition condition) {
		int objectSize = 2;
		StringBuffer query = new StringBuffer();
		if (condition.isStudentHistory()) {
			query.append("SELECT DISTINCT(D.TOKEN) AS 'TOKEN', S.STUDENT_ID, D.STUDENT_DEVICE_SEQ, D.OS ");
			query.append("  FROM pia_students S, pia_student_devices D ");
			query.append(" WHERE S.STUDENT_ID = D.STUDENT_ID ");
			query.append("   AND S.IS_DELETED IS FALSE ");
			query.append("   AND S.END_CONTRACT_DATE >= NOW() ");
			query.append("   AND LENGTH(D.TOKEN) > 100 ");
			query.append("   AND UPPER(D.OS) = ? ");
			query.append("   AND S.STUDENT_ID = ? ");
		} else if (condition.isStudyHistory()) {
			query.append("SELECT DISTINCT(D.TOKEN) AS 'TOKEN', G.STUDY_SEQ, S.STUDENT_ID, D.STUDENT_DEVICE_SEQ, D.OS ");
			query.append("  FROM pia_study_level_groupings G, pia_students S, pia_student_devices D ");
			query.append(" WHERE G.STUDENT_ID = S.STUDENT_ID ");
			query.append("   AND G.STUDENT_ID = D.STUDENT_ID ");
			query.append("   AND S.STUDENT_ID = D.STUDENT_ID ");
			query.append("   AND S.END_CONTRACT_DATE >= NOW() ");
			query.append("   AND LENGTH(D.TOKEN) > 100 ");
			query.append("   AND G.IS_DELETED IS FALSE ");
			query.append("   AND S.IS_DELETED IS FALSE ");
			query.append("   AND UPPER(D.OS) = ? ");
			query.append("   AND G.STUDY_SEQ = ? ");
		} else if (condition.isNoticeHistory()) {
			query.append("SELECT DISTINCT(D.TOKEN) AS 'TOKEN', S.STUDENT_ID, N.BRANCH_SEQ, N.LANGUAGE_SEQ, D.STUDENT_DEVICE_SEQ, D.OS ");
			query.append("  FROM pia_notices N, pia_students S, pia_student_devices D ");
			query.append(" WHERE N.BRANCH_SEQ = S.BRANCH_SEQ ");
			query.append("   AND ( ");
			query.append("         (N.IS_FOR_ALL IS TRUE AND (S.LANGUAGE_SEQ > 0)) ");
			query.append("         OR ");
			query.append("         (N.IS_FOR_ALL IS FALSE AND (N.LANGUAGE_SEQ = S.LANGUAGE_SEQ)) ");
			query.append("       ) ");
			query.append("   AND S.STUDENT_ID = D.STUDENT_ID ");
			query.append("   AND N.IS_DELETED IS FALSE ");
			query.append("   AND S.IS_DELETED IS FALSE ");
			query.append("   AND S.END_CONTRACT_DATE >= NOW() ");
			query.append("   AND LENGTH(D.TOKEN) > 100 ");
			query.append("   AND UPPER(D.OS) = ? ");
			query.append("   AND N.NOTICE_SEQ = ? ");
		} else if (condition.isExamHistory()) {
			query.append("SELECT DISTINCT(D.TOKEN) AS 'TOKEN', E.EXAM_RESULT_SEQ, S.STUDENT_ID, D.STUDENT_DEVICE_SEQ, D.OS ");
			query.append("  FROM pia_exam_results E, pia_students S, pia_student_devices D ");
			query.append(" WHERE E.IS_DELETED IS FALSE ");
			query.append("   AND S.IS_DELETED IS FALSE ");
			query.append("   AND E.STUDENT_ID = S.STUDENT_ID ");
			query.append("   AND E.STUDENT_ID = D.STUDENT_ID ");
			query.append("   AND S.STUDENT_ID = D.STUDENT_ID ");
			query.append("   AND S.END_CONTRACT_DATE >= NOW() ");
			query.append("   AND LENGTH(D.TOKEN) > 100 ");
			query.append("   AND UPPER(D.OS) = ? ");
			query.append("   AND E.EXAM_SEQ = ? ");
		} else if (condition.isRequestHistory()) {
			query.append("SELECT DISTINCT(D.TOKEN) AS 'TOKEN', R.REQUEST_SEQ, S.STUDENT_ID, D.STUDENT_DEVICE_SEQ, D.OS ");
			query.append("  FROM pia_requests R, pia_students S, pia_student_devices D ");
			query.append(" WHERE R.STUDENT_ID = S.STUDENT_ID ");
			query.append("   AND S.STUDENT_ID = D.STUDENT_ID ");
			query.append("   AND R.IS_REPLY IS FALSE ");
			query.append("   AND R.IS_DELETED IS FALSE ");
			query.append("   AND S.IS_DELETED IS FALSE ");
			query.append("   AND S.IS_DELETED IS FALSE ");
			query.append("   AND S.END_CONTRACT_DATE >= NOW() ");
			query.append("   AND LENGTH(D.TOKEN) > 100 ");
			query.append("   AND UPPER(D.OS) = ? ");
			query.append("   AND R.REQUEST_SEQ = ? ");
		}

		int idx = 0;
		Object[] params = new Object[objectSize];
		params[idx++] = deviceType.name();
		if (condition.isStudentHistory()) {
			params[idx++] = condition.getStudentId();
		} else if (condition.isStudyHistory()) {
			params[idx++] = condition.getStudySeq();
		} else if (condition.isNoticeHistory()) {
			params[idx++] = condition.getNoticeSeq();
		} else if (condition.isExamHistory()) {
			params[idx++] = condition.getExamSeq();
		} else if (condition.isRequestHistory()) {
			params[idx++] = condition.getRequestSeq();
		}

		List<StudentDevice> studentDevices = null;
		try {
			studentDevices = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudentDevice>(StudentDevice.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			studentDevices = new ArrayList<StudentDevice>();
		}

		return studentDevices;
	}
}
