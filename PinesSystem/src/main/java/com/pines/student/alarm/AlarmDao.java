package com.pines.student.alarm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pines.student.common.vo.Alarm;

@Repository
public class AlarmDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean readAlarm(String studentId, int alarmSeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_alarms ");
		query.append("   SET ");
		query.append("    IS_READ = 1, ");
		query.append("    READ_DATE = NOW() ");
		query.append(" WHERE RECEIVE_ID = ? ");
		query.append("   AND ALARM_SEQ = ? ");

		Object[] params = new Object[] { studentId, alarmSeq };
		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean isValidAlarm(int alarmSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("FROM pia_alarms ");
		query.append("WHERE ALARM_SEQ = ?");
		query.append("  AND IS_DELETED IS FALSE");

		Object[] params = new Object[] { alarmSeq };
		Alarm student = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<Alarm>(Alarm.class));
		return student.getAlarmSeq() > 0;
	}

	public boolean isValidReveiver(String studentId, int alarmSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("  FROM pia_alarms ");
		query.append(" WHERE RECEIVE_ID = ? ");
		query.append("   AND ALARM_SEQ = ? ");

		Object[] params = new Object[] { studentId, alarmSeq };
		Alarm student = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<Alarm>(Alarm.class));
		return student.getAlarmSeq() > 0;
	}

	public List<Alarm> getAllAlarmsForExcel(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT A.*, ");
		query.append("(SELECT CONCAT(S.TITLE, ' ', S.NICK_NAME) FROM pia_staff S WHERE S.STAFF_ID = A.SEND_ID) AS 'SENDER', ");
		query.append("DATE_FORMAT(A.SEND_DATE, '%Y/%m/%d %r') AS 'FORM_SEND_DATE', ");
		query.append("DATE_FORMAT(A.READ_DATE, '%Y/%m/%d %r') AS 'FORM_READ_DATE' ");
		query.append("FROM pia_alarms A ");
		query.append("WHERE A.RECEIVE_ID = ? ");
		query.append("  AND A.IS_DELETED IS FALSE ");
		query.append("ORDER BY A.READ_DATE DESC ");

		Object[] params = new Object[] { studentId };
		return jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Alarm>(Alarm.class));
	}

	public boolean send(Alarm alarm) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_alarms (");
		query.append("    MESSAGE, SEND_ID, SEND_DATE, ");
		query.append("    RECEIVE_ID, IS_READ, IS_DELETED ");
		query.append(") VALUES (");
		query.append("    ?, ?, NOW(), ");
		query.append("    ?, 0, 0 ");
		query.append(") ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = alarm.getMessage();
		params[idx++] = alarm.getSendId();
		params[idx++] = alarm.getReceiveId();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean deleteAlarm(int alarmSeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_alarms ");
		query.append("   SET ");
		query.append("    IS_DELETED = 1, ");
		query.append("    DELETE_DATE = NOW() ");
		query.append(" WHERE ALARM_SEQ = ? ");

		Object[] params = new Object[] { alarmSeq };
		return jdbcTemplate.update(query.toString(), params) > 0;
	}
}
