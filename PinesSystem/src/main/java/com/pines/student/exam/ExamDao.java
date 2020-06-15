package com.pines.student.exam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pines.student.common.Tools;
import com.pines.student.common.exception.AlreadyAppliedExamException;
import com.pines.student.common.exception.ClosedApplyExamException;
import com.pines.student.common.exception.ClosedCancelExamException;
import com.pines.student.common.vo.Exam;
import com.pines.student.common.vo.ExamApplicant;
import com.pines.student.common.vo.ExamResult;
import com.pines.student.common.vo.SearchCondition;
import com.pines.student.common.vo.Student;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ExamDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Exam> getRecentExam(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT E.*, ");
		query.append("DATE_FORMAT(E.EXAM_START_DATE, '%Y/%m/%d') AS 'FORM_EXAM_START_DATE', ");
		query.append("DATE_FORMAT(E.EXAM_END_DATE, '%Y/%m/%d') AS 'FORM_EXAM_END_DATE', ");
		query.append("IFNULL((SELECT A.APPLICANT_SEQ FROM pia_exam_applicants A WHERE A.EXAM_SEQ = E.EXAM_SEQ AND A.STUDENT_ID = S.STUDENT_ID AND IS_CANCELED IS FALSE), 0) AS 'APPLICANT_SEQ' ");
		query.append("FROM pia_students S LEFT JOIN pia_exams E ON S.BRANCH_SEQ = E.BRANCH_SEQ AND S.CAMPUS_SEQ = E.CAMPUS_SEQ AND E.TERM_SEQ = GET_PROGRESS_TERM_SEQ() ");
		query.append("WHERE E.IS_DELETED IS FALSE ");
		query.append("  AND S.STUDENT_ID = ? ");
		query.append("  AND E.EXAM_START_DATE >= NOW() ");
		query.append("ORDER BY EXAM_START_DATE ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studentId;

		List<Exam> results = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Exam>(Exam.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<Exam>();
		}

		query.setLength(0);
		query.append("SELECT COUNT(E.EXAM_SEQ) ");
		query.append("FROM pia_students S LEFT JOIN pia_exams E ON S.BRANCH_SEQ = E.BRANCH_SEQ AND S.CAMPUS_SEQ = E.CAMPUS_SEQ AND S.TERM_SEQ = E.TERM_SEQ ");
		query.append("WHERE E.IS_DELETED IS FALSE ");
		query.append("  AND E.TERM_SEQ = GET_PROGRESS_TERM_SEQ() ");
		query.append("  AND S.STUDENT_ID = ? ");
		query.append("  AND E.EXAM_START_DATE >= NOW() ");

		idx = 0;
		params = new Object[1];
		params[idx++] = studentId;

		int totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		if (results.size() > 0) {
			results.get(0).setTotalCount(Tools.getInt(totalCount));
		}

		return results;
	}

	public List<Exam> getExams(SearchCondition searchCondition) {
		int paramsCount = 3;
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = S.BRANCH_SEQ) AS 'BRANCH', ");
		query.append("(SELECT C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = S.CAMPUS_SEQ) AS 'CAMPUS', ");
		query.append("(SELECT TERM FROM pia_terms T WHERE T.TERM_SEQ = S.TERM_SEQ) AS 'TERM', ");
		query.append("DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(S.UPDATE_DATE, '%Y/%m/%d') AS 'FORM_UPDATE_DATE', ");
		query.append("DATE_FORMAT(S.EXAM_START_DATE, '%Y/%m/%d') AS 'FORM_EXAM_START_DATE', ");
		query.append("DATE_FORMAT(S.EXAM_END_DATE, '%Y/%m/%d') AS 'FORM_EXAM_END_DATE', ");
		query.append("(SELECT COUNT(*) FROM pia_exam_results R WHERE R.EXAM_SEQ = S.EXAM_SEQ AND R.IS_DELETED IS FALSE) AS 'SAVE_RESULT_COUNT', ");
		query.append("GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'WRITER' ");
		query.append(" FROM pia_exams S ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");
		if (searchCondition.isCampusesCondition()) {
			query.append("  AND CAMPUS_SEQ IN ( ");
			int loopCount = searchCondition.getCampusSeqs().length;
			for (int i = 0; i < loopCount; i++) {
				query.append(" ? ");
				paramsCount++;
				if (i == 0 && loopCount > 1) {
					query.append(",");
				} else if (i > 0 && (loopCount - 1) > i) {
					query.append(",");
				}
			}

			query.append(" ) ");
		}

		if (searchCondition.hasTermSeqCondition()) {
			query.append(" AND TERM_SEQ = ? ");
			paramsCount++;
		}

		if (searchCondition.hasExamTypes()) {
			int loopCount = searchCondition.getExamTypes().length;
			query.append("  AND EXAM_TYPE IN ( ");
			for (int i = 0; i < loopCount; i++) {
				query.append(" ? ");
				paramsCount++;
				if (i == 0 && loopCount > 1) {
					query.append(",");
				} else if (i > 0 && (loopCount - 1) > i) {
					query.append(",");
				}
			}

			query.append(" ) ");
		}

		query.append(" ORDER BY EXAM_START_DATE DESC, EXAM_END_DATE DESC ");
		query.append(" LIMIT ?, ? ");

		List<Exam> results = null;
		Integer totalCount = null;
		try {

			int idx = 0;
			Object[] params = new Object[paramsCount];

			params[idx++] = searchCondition.getBranchSeq();

			if (searchCondition.isCampusesCondition()) {
				for (int seq : searchCondition.getCampusSeqs()) {
					params[idx++] = seq;
				}
			}

			if (searchCondition.hasTermSeqCondition()) {
				params[idx++] = searchCondition.getTermSeq();
			}

			if (searchCondition.hasExamTypes()) {
				for (String examType : searchCondition.getExamTypes()) {
					params[idx++] = examType;
				}
			}

			params[idx++] = searchCondition.getStartIndex();
			params[idx++] = searchCondition.getOffset();

			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Exam>(Exam.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM pia_exams S ");
			query.append("WHERE IS_DELETED IS FALSE ");
			query.append("  AND BRANCH_SEQ = ? ");
			if (searchCondition.isCampusesCondition()) {
				query.append("  AND CAMPUS_SEQ IN ( ");
				int loopCount = searchCondition.getCampusSeqs().length;
				for (int i = 0; i < loopCount; i++) {
					query.append(" ? ");
					if (i == 0 && loopCount > 1) {
						query.append(",");
					} else if (i > 0 && (loopCount - 1) > i) {
						query.append(",");
					}
				}

				query.append(" ) ");
			}

			if (searchCondition.hasTermSeqCondition()) {
				query.append(" AND TERM_SEQ = ? ");
			}

			if (searchCondition.hasExamTypes()) {
				int loopCount = searchCondition.getExamTypes().length;
				query.append("  AND EXAM_TYPE IN ( ");
				for (int i = 0; i < loopCount; i++) {
					query.append(" ? ");
					if (i == 0 && loopCount > 1) {
						query.append(",");
					} else if (i > 0 && (loopCount - 1) > i) {
						query.append(",");
					}
				}

				query.append(" ) ");
			}

			idx = 0;
			params = new Object[paramsCount - 2];
			params[idx++] = searchCondition.getBranchSeq();

			if (searchCondition.isCampusesCondition()) {
				for (int seq : searchCondition.getCampusSeqs()) {
					params[idx++] = seq;
				}
			}

			if (searchCondition.hasTermSeqCondition()) {
				params[idx++] = searchCondition.getTermSeq();
			}

			if (searchCondition.hasExamTypes()) {
				for (String examType : searchCondition.getExamTypes()) {
					params[idx++] = examType;
				}
			}

			totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);

			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<Exam>();
			results.get(0).setTotalCount(0);
		}
		return results;
	}

	public Exam getExam(int branchSeq, int campusSeq, int termSeq, int examSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = S.BRANCH_SEQ) AS 'BRANCH', ");
		query.append("(SELECT C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = S.CAMPUS_SEQ) AS 'CAMPUS', ");
		query.append("(SELECT TERM FROM pia_terms T WHERE T.TERM_SEQ = S.TERM_SEQ) AS 'TERM', ");
		query.append("DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(S.UPDATE_DATE, '%Y/%m/%d') AS 'FORM_UPDATE_DATE', ");
		query.append("DATE_FORMAT(S.EXAM_START_DATE, '%Y/%m/%d') AS 'FORM_EXAM_START_DATE', ");
		query.append("DATE_FORMAT(S.EXAM_END_DATE, '%Y/%m/%d') AS 'FORM_EXAM_END_DATE', ");
		query.append("GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'WRITER' ");
		query.append(" FROM pia_exams S ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append("  AND CAMPUS_SEQ = ? ");
		query.append("  AND TERM_SEQ = ? ");
		query.append("  AND EXAM_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;
		params[idx++] = termSeq;
		params[idx++] = examSeq;

		Exam result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<Exam>(Exam.class));

			query.setLength(0);
			query.append("SELECT IFNULL(R.EXAM_RESULT_SEQ, 0) AS EXAM_RESULT_SEQ, IFNULL(A2.EXAM_SEQ, 0) AS EXAM_SEQ, A2.CAMPUS_SEQ, IFNULL(A2.LEVEL_SEQ, 0) AS LEVEL_SEQ, ");
			query.append("       A2.STUDENT_ID, A2.STUDENT_NAME, ");
			query.append("       (SELECT DATE_FORMAT(S.DATE_OF_BIRTH, '%Y/%m/%d') AS BIRTHDAY FROM pia_students S WHERE S.STUDENT_ID = A2.STUDENT_ID) AS BIRTHDAY, ");
			query.append("       (SELECT L.LEVEL_NAME FROM pia_study_levels L WHERE L.LEVEL_SEQ = A2.LEVEL_SEQ) AS LEVEL, ");
			query.append("       R.RESULT_FILE_PATH, DATE_FORMAT(R.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE' ");
			query.append("  FROM ( ");
			query.append("          SELECT E.EXAM_SEQ, E.BRANCH_SEQ, E.CAMPUS_SEQ, A1.LEVEL_SEQ, ");
			query.append("                 A1.STUDENT_ID, A1.STUDENT_NAME ");
			query.append("            FROM pia_exams E, ");
			query.append("                 ( SELECT S.*, G.STUDENT_ID, G.INPUT_STUDENT_NAME AS 'STUDENT_NAME', G.LEVEL_SEQ ");
			query.append("                     FROM pia_studies S, pia_study_level_groupings G ");
			query.append("                    WHERE S.STUDY_SEQ = G.STUDY_SEQ ");
			query.append("                      AND S.IS_DELETED IS FALSE ");
			query.append("                      AND G.IS_DELETED IS FALSE ");
			query.append("                 ) A1 ");
			query.append("           WHERE E.BRANCH_SEQ = A1.BRANCH_SEQ ");
			query.append("             AND E.CAMPUS_SEQ = A1.CAMPUS_SEQ ");
			query.append("             AND E.TERM_SEQ = A1.TERM_SEQ ");
			query.append("             AND E.IS_DELETED IS FALSE ");
			query.append("             AND E.EXAM_SEQ = ? ");
			query.append("             AND E.BRANCH_SEQ = ? ");
			query.append("             AND E.CAMPUS_SEQ = ? ");
			query.append("             AND E.TERM_SEQ = ? ");
			query.append("       ) A2 LEFT JOIN pia_exam_results R ON A2.EXAM_SEQ = R.EXAM_SEQ AND A2.STUDENT_ID = R.STUDENT_ID AND R.IS_DELETED IS FALSE ");
			query.append(" WHERE A2.EXAM_SEQ = ? ");
			query.append(" ORDER BY LEVEL, STUDENT_NAME, BIRTHDAY ");

			idx = 0;
			params = new Object[5];
			params[idx++] = examSeq;
			params[idx++] = branchSeq;
			params[idx++] = campusSeq;
			params[idx++] = termSeq;
			params[idx++] = examSeq;

			List<ExamResult> examResult = null;
			try {
				examResult = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<ExamResult>(ExamResult.class));
			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				examResult = new ArrayList<ExamResult>();
			}

			result.setResults(examResult);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new Exam();
			result.setResults(new ArrayList<ExamResult>());
		}

		return result;
	}

	public int addExam(Exam exam) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_exams ( ");
		query.append("BRANCH_SEQ, CAMPUS_SEQ, TERM_SEQ, ");
		query.append("EXAM_START_DATE, EXAM_END_DATE, EXAM_TYPE, STAFF_ID, ");
		query.append("REGISTER_DATE, IS_DELETED, UPDATE_DATE ");
		query.append(") ");
		query.append("VALUES ");
		query.append("( ");
		query.append("?, ?, ?, ");
		query.append("?, ?, ?, ?, ");
		query.append("NOW(), 0, NOW() ");
		query.append(") ");

		int idx = 0;
		Object[] params = new Object[7];
		params[idx++] = exam.getBranchSeq();
		params[idx++] = exam.getCampusSeq();
		params[idx++] = exam.getTermSeq();
		params[idx++] = exam.getExamStartDate();
		params[idx++] = exam.getExamEndDate();
		params[idx++] = exam.getExamType();
		params[idx++] = exam.getStaffId();

		boolean isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		if (!isSuccessed) {
			return 0;
		}

		query.setLength(0);
		query.append("SELECT LAST_INSERT_ID() ");

		int examSeq = jdbcTemplate.queryForObject(query.toString(), Integer.class);
		return examSeq;
	}

	public boolean removeExam(int branchSeq, int campusSeq, int termSeq, int examSeq, String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_exams SET ");
		query.append("STAFF_ID = ?, IS_DELETED = 1, UPDATE_DATE = NOW() ");
		query.append("WHERE BRANCH_SEQ = ? ");
		query.append("  AND CAMPUS_SEQ = ? ");
		query.append("  AND TERM_SEQ = ? ");
		query.append("  AND EXAM_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[5];
		params[idx++] = staffId;
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;
		params[idx++] = termSeq;
		params[idx++] = examSeq;

		boolean isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		if (isSuccessed) {

			query.setLength(0);
			query.append("UPDATE pia_exam_results SET ");
			query.append("STAFF_ID = ?, IS_DELETED = 1, DELETE_DATE = NOW() ");
			query.append("WHERE EXAM_SEQ = ? ");

			idx = 0;
			params = new Object[2];
			params[idx++] = staffId;
			params[idx++] = examSeq;

			jdbcTemplate.update(query.toString(), params);
		}

		return true;
	}

	public int applyExam(ExamApplicant examApplicant) throws AlreadyAppliedExamException, ClosedApplyExamException {
		int idx = 0;
		Object[] params = null;
		StringBuffer query = new StringBuffer();
		if (!examApplicant.isRegisterByStaff()) {
			query.setLength(0);
			query.append("SELECT DATEDIFF(EXAM_START_DATE, NOW()) ");
			query.append("  FROM pia_exams ");
			query.append(" WHERE EXAM_SEQ = ? ");

			params = new Object[1];
			params[idx++] = examApplicant.getExamSeq();
			int datediffCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (datediffCount < 1) {
				throw new ClosedApplyExamException();
			}
		}

		query.setLength(0);
		query.append("SELECT APPLICANT_SEQ ");
		query.append("  FROM pia_exam_applicants ");
		query.append(" WHERE EXAM_SEQ = ? ");
		query.append("   AND STUDENT_ID = ? ");
		query.append("   AND IS_CANCELED IS FALSE ");

		idx = 0;
		params = new Object[2];
		params[idx++] = examApplicant.getExamSeq();
		params[idx++] = examApplicant.getStudentId();
		try {
			int count = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (count > 0) {
				throw new AlreadyAppliedExamException();
			}
		} catch (EmptyResultDataAccessException e) {
		}

		query.setLength(0);
		query.append("INSERT INTO pia_exam_applicants ( ");
		query.append("EXAM_SEQ, STUDENT_ID, REGISTER_DATE, ");
		if (examApplicant.isRegisterByStaff()) {
			query.append("REGISTER_STAFF_ID, ");
		} else {
			query.append("REGISTER_STUDENT_ID, ");
		}

		query.append("IS_CANCELED ");
		query.append(") ");
		query.append("VALUES ");
		query.append("( ");
		query.append("?, ?, NOW(), ?, 0  ");
		query.append(") ");

		idx = 0;
		params = new Object[3];
		params[idx++] = examApplicant.getExamSeq();
		params[idx++] = examApplicant.getStudentId();
		if (examApplicant.isRegisterByStaff()) {
			params[idx++] = examApplicant.getRegisterStaffId();
		} else {
			params[idx++] = examApplicant.getRegisterStudentId();
		}

		boolean isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		if (!isSuccessed) {
			return 0;
		}

		query.setLength(0);
		query.append("SELECT LAST_INSERT_ID() ");

		int examSeq = jdbcTemplate.queryForObject(query.toString(), Integer.class);
		return examSeq;
	}

	public boolean cancelExam(ExamApplicant examApplicant) throws ClosedCancelExamException {
		int idx = 0;
		Object[] params = null;
		StringBuffer query = new StringBuffer();
		if (!examApplicant.isRegisterByStaff()) {
			query.setLength(0);
			query.append("SELECT DATEDIFF(EXAM_START_DATE, NOW()) ");
			query.append("  FROM pia_exams ");
			query.append(" WHERE EXAM_SEQ = ? ");

			idx = 0;
			params = new Object[1];
			params[idx++] = examApplicant.getExamSeq();
			int datediffCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (datediffCount < 1) {
				throw new ClosedCancelExamException();
			}
		}

		query.setLength(0);
		query.append("UPDATE pia_exam_applicants SET ");
		query.append("IS_CANCELED = 1, ");

		if (examApplicant.isRegisterByStaff()) {
			query.append("CANCEL_STAFF_ID = ?, ");
		} else {
			query.append("CANCEL_STUDENT_ID = ?, ");
		}

		query.append("CANCEL_DATE = NOW() ");
		query.append("WHERE APPLICANT_SEQ = ? ");

		idx = 0;
		params = new Object[2];
		if (examApplicant.isRegisterByStaff()) {
			params[idx++] = examApplicant.getRegisterStaffId();
		} else {
			params[idx++] = examApplicant.getRegisterStudentId();
		}
		params[idx++] = examApplicant.getApplicantSeq();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public List<Student> getStudents(int examSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.NAME, ");
		query.append("(SELECT C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = S.CAMPUS_SEQ) AS 'CAMPUS', ");
		query.append("(SELECT CODE FROM pia_nationalities N WHERE N.NATIONALITY_SEQ = S.NATIONALITY_SEQ) AS 'NATIONALITY_CODE', ");
		query.append("(SELECT T.TERM_NAME FROM pia_term_details T WHERE T.TERM_DETAIL_SEQ = S.TERM_DETAIL_SEQ) AS 'TERM' ");
		query.append(" FROM pia_exam_applicants A, pia_students S ");
		query.append("WHERE A.STUDENT_ID = S.STUDENT_ID ");
		query.append("  AND A.EXAM_SEQ = ? ");
		query.append("  AND IS_CANCELED IS FALSE ");
		query.append("ORDER BY NAME ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = examSeq;

		List<Student> result = null;
		try {
			result = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Student>(Student.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new ArrayList<Student>();
		}
		return result;
	}

	public boolean addExams(List<Exam> exams) {
		int isSuccessedCount = 0;
		for (Exam exam : exams) {
			if (addExam(exam) > 0) {
				isSuccessedCount++;
			}
		}
		return isSuccessedCount > 0;
	}

}
