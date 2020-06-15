package com.pines.student.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pines.student.common.vo.Activity;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ActivityDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean join(int activitySeq, String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO ");
		query.append("  pia_activity_join_members ( ");
		query.append("    ACTIVITY_SEQ, ");
		query.append("    CAMPUS_SEQ, ");
		query.append("    STUDENT_SEQ, ");
		query.append("    REGISTER_DATE ");
		query.append("  ) VALUES (");
		query.append("    ?, ");
		query.append("    (SELECT CAMPUS_SEQ FROM pia_activities WHERE ACTIVITY_SEQ = ?), ");
		query.append("    (SELECT STUDENT_SEQ FROM pia_students WHERE STUDENT_ID = ?), ");
		query.append("    NOW() ");
		query.append("  ) ");

		boolean isSuccessed = false;

		Object[] params = new Object[] { activitySeq, activitySeq, studentId };
		isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		if (!isSuccessed) {
			throw new RuntimeException("Insert of Joining in Activity Fail and Needs Rollback.");
		}

		query.setLength(0);
		query.append("UPDATE pia_activities SET ");
		query.append("TOTAL_JOIN_MEMBER_COUNT = TOTAL_JOIN_MEMBER_COUNT+ 1 ");
		query.append("WHERE ACTIVITY_SEQ = ? ");
		params = new Object[] { activitySeq };
		isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		if (!isSuccessed) {
			throw new RuntimeException("Insert fail and needs rollback.");
		}

		return isSuccessed;
	}

	public boolean isAvailableActivity(int activitySeq) {
		String query = "SELECT * FROM pia_activities WHERE ACTIVITY_SEQ = ? AND STATUS = 'PLAN' AND IS_DELETED IS FALSE AND NOW() BETWEEN ACCEPT_START_DATE AND ACCEPT_END_DATE";
		Object[] params = new Object[] { activitySeq };

		Activity activity = jdbcTemplate.queryForObject(query, params, new BeanPropertyRowMapper<Activity>(Activity.class));
		return activity.getActivitySeq() > 0;
	}

}
