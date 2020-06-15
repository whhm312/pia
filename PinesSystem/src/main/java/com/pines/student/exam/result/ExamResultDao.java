package com.pines.student.exam.result;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.ExamResult;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ExamResultDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addExamResults(ExamResult examResults) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT EXAM_RESULT_SEQ ");
		query.append("FROM pia_exam_results ");
		query.append("WHERE EXAM_SEQ = ? ");
		query.append("  AND LEVEL_SEQ = ? ");
		query.append("  AND STUDENT_ID = ? ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = examResults.getExamSeq();
		params[idx++] = examResults.getLevelSeq();
		params[idx++] = examResults.getStudentId();

		int examResultSeq = 0;
		try {
			examResultSeq = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			examResultSeq = 0;
		}

		if (examResultSeq > 0) {
			query.setLength(0);
			query.append("UPDATE pia_exam_results SET ");
			query.append(" RESULT_FILE_PATH = ?, STAFF_ID = ?, ");
			query.append(" REGISTER_DATE = NOW(), DELETE_DATE = NULL, IS_DELETED = 0 ");
			query.append("WHERE EXAM_RESULT_SEQ = ? ");

			idx = 0;
			params = new Object[3];
			params[idx++] = examResults.getResultFilePath();
			params[idx++] = examResults.getStaffId();
			params[idx++] = examResultSeq;

			boolean isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
			if (!isSuccessed) {
				return 0;
			}
			return examResultSeq;
		} else {
			query.setLength(0);
			query.append("INSERT INTO pia_exam_results ( ");
			query.append(" EXAM_SEQ, LEVEL_SEQ, STUDENT_ID, RESULT_FILE_PATH, STAFF_ID, ");
			query.append(" REGISTER_DATE, IS_DELETED ");
			query.append(") ");
			query.append("VALUES ");
			query.append("( ");
			query.append(" ?, ?, ?, ?, ?,  ");
			query.append(" NOW(), 0 ");
			query.append(") ");

			idx = 0;
			params = new Object[5];
			params[idx++] = examResults.getExamSeq();
			params[idx++] = examResults.getLevelSeq();
			params[idx++] = examResults.getStudentId();
			params[idx++] = examResults.getResultFilePath();
			params[idx++] = examResults.getStaffId();

			boolean isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
			if (!isSuccessed) {
				return 0;
			}

			query.setLength(0);
			query.append("SELECT LAST_INSERT_ID() ");
			return jdbcTemplate.queryForObject(query.toString(), Integer.class);
		}
	}

	public String removeExamResult(int examSeq, int resultSeq, String staffId) {
		String resultFilePath = null;

		StringBuffer query = new StringBuffer();
		query.append("SELECT RESULT_FILE_PATH ");
		query.append("FROM pia_exam_results ");
		query.append("WHERE EXAM_SEQ = ? ");
		query.append("  AND EXAM_RESULT_SEQ = ? ");
		query.append("  AND IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = examSeq;
		params[idx++] = resultSeq;

		try {
			resultFilePath = jdbcTemplate.queryForObject(query.toString(), params, String.class);
			if (Tools.isEmpty(resultFilePath)) {
				return "";
			}
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return "";
		}

		query.setLength(0);
		query.append("UPDATE pia_exam_results SET ");
		query.append(" RESULT_FILE_PATH = NULL, STAFF_ID = ?, IS_DELETED = 1, DELETE_DATE = NOW() ");
		query.append("WHERE EXAM_SEQ = ? ");
		query.append("  AND EXAM_RESULT_SEQ = ? ");

		idx = 0;
		params = new Object[3];
		params[idx++] = staffId;
		params[idx++] = examSeq;
		params[idx++] = resultSeq;

		boolean isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		if (!isSuccessed) {
			return "";
		}

		return resultFilePath;
	}

	public String getPath(int branchSeq, int campusSeq, int termSeq, int examSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT CONCAT( ");
		query.append("(SELECT BRANCH_NAME FROM pia_branches WHERE BRANCH_SEQ = ?) ");
		query.append(", '/' ");
		query.append(", (SELECT CAMPUS_NAME FROM pia_campuses WHERE CAMPUS_SEQ = ?)");
		query.append(", '/' ");
		query.append(", (SELECT TERM FROM pia_terms WHERE TERM_SEQ = ?) ");
		query.append(", '/' ");
		query.append(", (SELECT EXAM_TYPE FROM pia_exams WHERE EXAM_SEQ = ?) ");
		query.append(", '/' ");
		query.append(") ");
		query.append("AS PATH ");

		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;
		params[idx++] = termSeq;
		params[idx++] = examSeq;

		return jdbcTemplate.queryForObject(query.toString(), params, String.class);
	}

	public List<ExamResult> getExamResults(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.NAME AS STUDENT_NAME, A.* ");
		query.append("FROM ( ");
		query.append("SELECT R.STUDENT_ID, R.RESULT_FILE_PATH, ");
		query.append("E.EXAM_TYPE, ");
		query.append("DATE_FORMAT(E.EXAM_START_DATE, '%Y/%m/%d') AS 'EXAM_START_DATE',  ");
		query.append("DATE_FORMAT(E.EXAM_END_DATE, '%Y/%m/%d') AS 'EXAM_END_DATE', ");
		query.append("(SELECT TERM FROM pia_terms T WHERE T.TERM_SEQ = E.TERM_SEQ) AS 'TERM' ");
		query.append("FROM pia_exam_results R, pia_exams E ");
		query.append("WHERE E.EXAM_SEQ = R.EXAM_SEQ ");
		query.append(" AND R.STUDENT_ID = ? ");
		query.append(" AND E.IS_DELETED IS FALSE ");
		query.append(" AND R.IS_DELETED IS FALSE ");
		query.append(") A, pia_students S ");
		query.append("WHERE S.STUDENT_ID = A.STUDENT_ID ");
		query.append("ORDER BY EXAM_START_DATE DESC ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studentId;

		List<ExamResult> results = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<ExamResult>(ExamResult.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<ExamResult>();
		}

		query.setLength(0);
		query.append("SELECT COUNT(R.STUDENT_ID) ");
		query.append("FROM pia_exam_results R ");
		query.append("WHERE R.STUDENT_ID = ? ");

		idx = 0;
		params = new Object[1];
		params[idx++] = studentId;

		int totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		if (results.size() > 0) {
			results.get(0).setTotalCount(Tools.getInt(totalCount));
		}

		return results;
	}

}
