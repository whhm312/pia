package com.pines.student.study;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.SearchCondition;
import com.pines.student.common.vo.Student;
import com.pines.student.common.vo.Study;
import com.pines.student.common.vo.StudyAllInOne;
import com.pines.student.common.vo.StudyLevel;
import com.pines.student.common.vo.StudyLevelGrouping;
import com.pines.student.common.vo.StudySchedule;
import com.pines.student.common.vo.StudyScheduleDetail;
import com.pines.student.common.vo.StudyTimetable;
import com.pines.student.common.vo.StudyTimetableDetail;
import com.pines.student.common.vo.StudyUnknownStudent;
import com.pines.student.common.vo.StudyUnknownStudentLevels;
import com.pines.student.common.vo.TeacherScheduleDetail;

@Repository
@Transactional(rollbackFor = Exception.class)
public class StudyScheduleDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<StudySchedule> getStudentStudySchedules(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT C.*, S.TEACHER_NAME, IFNULL(S.SCHEDULE_SEQ, 0) AS SCHEDULE_SEQ, STUDY_ROOM, IFNULL(S.STUDY_MEMBER, 0) AS STUDY_MEMBER ");
		query.append("  FROM ( ");
		query.append("        SELECT IFNULL(T.TIMETABLE_SEQ, 0) AS TIMETABLE_SEQ, IFNULL(T.STUDY_SEQ, 0) AS STUDY_SEQ, IFNULL(T.LEVEL_SEQ, 0) AS LEVEL_SEQ, T.STUDY_TIME, T.SUBJECT, B.STUDENT_ID ");
		query.append("          FROM ( ");
		query.append(" 					SELECT S.STUDY_SEQ, L.LEVEL_SEQ, L.STUDENT_ID ");
		query.append(" 					  FROM pia_studies S, pia_study_level_groupings L ");
		query.append("  				 WHERE S.STUDY_SEQ = L.STUDY_SEQ ");
		query.append(" 					   AND STUDENT_ID = ? ");
		query.append(" 					   AND S.IS_DELETED IS FALSE ");
		query.append(" 					   AND L.IS_DELETED IS FALSE ");
		query.append(" 					   AND S.TERM_SEQ = GET_PROGRESS_TERM_SEQ() ");
		query.append("               ) B LEFT JOIN pia_study_timetables T ON B.STUDY_SEQ = T.STUDY_SEQ AND B.LEVEL_SEQ = T.LEVEL_SEQ AND T.IS_DELETED IS FALSE ");
		query.append("       ) C LEFT JOIN pia_study_schedules S ON C.STUDY_SEQ = S.STUDY_SEQ AND C.LEVEL_SEQ = S.LEVEL_SEQ AND C.STUDENT_ID = S.STUDENT_ID AND C.TIMETABLE_SEQ = S.TIMETABLE_SEQ AND S.IS_DELETED IS FALSE ");
		query.append(" ORDER BY TIMETABLE_SEQ ");
		// query.append(" ORDER BY FIELD (S.STUDY_TIME, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5,
		// 6, 7) ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studentId;

		List<StudySchedule> results = null;
		Integer totalCount = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudySchedule>(StudySchedule.class));

			query.setLength(0);
			query.append("SELECT COUNT(*)");
			query.append("  FROM ( ");
			query.append("        SELECT T.TIMETABLE_SEQ, T.STUDY_SEQ, T.LEVEL_SEQ, T.STUDY_TIME, T.SUBJECT, B.STUDENT_ID ");
			query.append("          FROM ( ");
			query.append(" 					SELECT S.STUDY_SEQ, L.LEVEL_SEQ, L.STUDENT_ID ");
			query.append(" 					  FROM pia_studies S, pia_study_level_groupings L ");
			query.append("  				 WHERE S.STUDY_SEQ = L.STUDY_SEQ ");
			query.append(" 					   AND STUDENT_ID = ? ");
			query.append(" 					   AND S.IS_DELETED IS FALSE ");
			query.append(" 					   AND L.IS_DELETED IS FALSE ");
			query.append(" 					   AND S.TERM_SEQ = GET_PROGRESS_TERM_SEQ() ");
			query.append("               ) B LEFT JOIN pia_study_timetables T ON B.STUDY_SEQ = T.STUDY_SEQ AND B.LEVEL_SEQ = T.LEVEL_SEQ AND T.IS_DELETED IS FALSE ");
			query.append("       ) C LEFT JOIN pia_study_schedules S ON C.STUDY_SEQ = S.STUDY_SEQ AND C.LEVEL_SEQ = S.LEVEL_SEQ AND C.STUDENT_ID = S.STUDENT_ID AND C.TIMETABLE_SEQ = S.TIMETABLE_SEQ AND S.IS_DELETED IS FALSE ");

			totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<StudySchedule>();
		}
		return results;
	}

	public List<StudySchedule> getStudentStudySchedulesForAdmin(String studentId, int termDetailSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT C.*, S.TEACHER_NAME, IFNULL(S.SCHEDULE_SEQ, 0) AS SCHEDULE_SEQ, STUDY_ROOM, IFNULL(S.STUDY_MEMBER, 0) AS STUDY_MEMBER ");
		query.append("  FROM ( ");
		query.append("        SELECT IFNULL(T.TIMETABLE_SEQ, 0) AS TIMETABLE_SEQ, IFNULL(T.STUDY_SEQ, 0) AS STUDY_SEQ, IFNULL(T.LEVEL_SEQ, 0) AS LEVEL_SEQ, T.STUDY_TIME, T.SUBJECT, B.STUDENT_ID ");
		query.append("          FROM ( ");
		query.append("                SELECT ST.STUDY_SEQ, A.LEVEL_SEQ, A.STUDENT_ID ");
		query.append("                  FROM ( ");
		query.append("                        SELECT S.STUDENT_ID, L.* ");
		query.append("                          FROM pia_students S LEFT JOIN pia_study_levels L ON L.LEVEL_SEQ = S.LEVEL_SEQ ");
		query.append("                         WHERE STUDENT_ID = ? ");
		query.append("                       ) A LEFT JOIN pia_studies ST ON ST.BRANCH_SEQ = A.BRANCH_SEQ AND ST.CAMPUS_SEQ = A.CAMPUS_SEQ AND ST.IS_DELETED IS FALSE ");
		query.append("                  WHERE ST.TERM_DETAIL_SEQ = ? ");
		query.append("               ) B LEFT JOIN pia_study_timetables T ON B.STUDY_SEQ = T.STUDY_SEQ AND B.LEVEL_SEQ = T.LEVEL_SEQ AND T.IS_DELETED IS FALSE ");
		query.append("       ) C LEFT JOIN pia_study_schedules S ON C.STUDY_SEQ = S.STUDY_SEQ AND C.LEVEL_SEQ = S.LEVEL_SEQ AND C.STUDENT_ID = S.STUDENT_ID AND C.TIMETABLE_SEQ = S.TIMETABLE_SEQ AND S.IS_DELETED IS FALSE ");
		query.append(" ORDER BY TIMETABLE_SEQ ");
		// query.append(" ORDER BY FIELD (S.STUDY_TIME, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5,
		// 6, 7) ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = studentId;
		params[idx++] = termDetailSeq;

		List<StudySchedule> results = null;
		Integer totalCount = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudySchedule>(StudySchedule.class));

			query.setLength(0);
			query.append("SELECT COUNT(*)");
			query.append("  FROM ( ");
			query.append("        SELECT T.TIMETABLE_SEQ, T.STUDY_SEQ, T.LEVEL_SEQ, T.STUDY_TIME, T.SUBJECT, B.STUDENT_ID ");
			query.append("          FROM ( ");
			query.append("                SELECT ST.STUDY_SEQ, A.LEVEL_SEQ, A.STUDENT_ID ");
			query.append("                  FROM ( ");
			query.append("                        SELECT S.STUDENT_ID, L.* ");
			query.append("                          FROM pia_students S LEFT JOIN pia_study_levels L ON L.LEVEL_SEQ = S.LEVEL_SEQ ");
			query.append("                         WHERE STUDENT_ID = ? ");
			query.append("                       ) A LEFT JOIN pia_studies ST ON ST.BRANCH_SEQ = A.BRANCH_SEQ AND ST.CAMPUS_SEQ = A.CAMPUS_SEQ AND ST.IS_DELETED IS FALSE ");
			query.append("                  WHERE ST.TERM_DETAIL_SEQ = ? ");
			query.append("               ) B LEFT JOIN pia_study_timetables T ON B.STUDY_SEQ = T.STUDY_SEQ AND B.LEVEL_SEQ = T.LEVEL_SEQ AND T.IS_DELETED IS FALSE ");
			query.append("       ) C LEFT JOIN pia_study_schedules S ON C.STUDY_SEQ = S.STUDY_SEQ AND C.LEVEL_SEQ = S.LEVEL_SEQ AND C.STUDENT_ID = S.STUDENT_ID AND C.TIMETABLE_SEQ = S.TIMETABLE_SEQ AND S.IS_DELETED IS FALSE ");

			totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<StudySchedule>();
		}
		return results;
	}

	public List<Study> getStudySchedules(SearchCondition searchCondition) {
		int paramsCount = 3;
		StringBuffer query = new StringBuffer();
		query.append("SELECT A.*, ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = A.BRANCH_SEQ) AS 'BRANCH', ");
		query.append("(SELECT C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = A.CAMPUS_SEQ) AS 'CAMPUS', ");
		query.append("(SELECT T.TERM_NAME FROM pia_term_details T WHERE T.TERM_DETAIL_SEQ = A.TERM_DETAIL_SEQ) AS 'TERM', ");
		query.append("DATE_FORMAT(A.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(A.UPDATE_DATE, '%Y/%m/%d') AS 'FORM_UPDATE_DATE' ");
		query.append("  FROM ( ");
		query.append("SELECT S.*, ");
		query.append("GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'WRITER' ");
		query.append("FROM pia_studies S ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append(") A ");
		query.append("WHERE BRANCH_SEQ = ? ");
		if (searchCondition.isCampusesCondition()) {
			query.append("  AND CAMPUS_SEQ IN ( ");
			for (int i = 0; i < searchCondition.getCampusSeqs().length; i++) {
				query.append(" ? ");
				paramsCount++;
				if (i == 0 && searchCondition.getCampusSeqs().length > 1) {
					query.append(",");
				} else if (i > 0 && (searchCondition.getCampusSeqs().length - 1) > i) {
					query.append(",");
				}
			}

			query.append(" ) ");
		}

		if (searchCondition.hasTermSeqCondition()) {
			query.append(" AND TERM_DETAIL_SEQ IN (SELECT TERM_DETAIL_SEQ FROM pia_term_details WHERE TERM_SEQ = ? ) ");
			paramsCount++;
		}

		if (searchCondition.isWriterCondition()) {
			query.append("  AND WRITER LIKE ? ");
			paramsCount++;
		}

		query.append(" ORDER BY TERM_DETAIL_SEQ DESC, CAMPUS_SEQ ");
		query.append(" LIMIT ?, ? ");

		List<Study> results = null;
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

			if (searchCondition.isWriterCondition()) {
				params[idx++] = "%" + searchCondition.getWriter() + "%";
			}

			params[idx++] = searchCondition.getStartIndex();
			params[idx++] = searchCondition.getOffset();

			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Study>(Study.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) FROM (  ");
			query.append("SELECT S.*,  ");
			query.append("GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'WRITER' ");
			query.append("FROM pia_studies S ");
			query.append("WHERE IS_DELETED IS FALSE ");
			query.append(") A ");
			query.append("WHERE BRANCH_SEQ = ? ");
			if (searchCondition.isCampusesCondition()) {
				query.append("  AND CAMPUS_SEQ IN ( ");
				for (int i = 0; i < searchCondition.getCampusSeqs().length; i++) {
					query.append(" ? ");
					if (i == 0 && searchCondition.getCampusSeqs().length > 1) {
						query.append(",");
					} else if (i > 0 && (searchCondition.getCampusSeqs().length - 1) > i) {
						query.append(",");
					}
				}

				query.append(" ) ");
			}
			if (searchCondition.hasTermSeqCondition()) {
				query.append(" AND TERM_DETAIL_SEQ IN (SELECT TERM_DETAIL_SEQ FROM pia_term_details WHERE TERM_SEQ = ? ) ");
			}
			if (searchCondition.isWriterCondition()) {
				query.append("  AND WRITER LIKE ? ");
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

			if (searchCondition.isWriterCondition()) {
				params[idx++] = searchCondition.getWriter();
			}

			totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<Study>();
			results.get(0).setTotalCount(0);
		}
		return results;
	}

	public StudyAllInOne getStudySchedule(int branchSeq, int termDetailSeq, int campusSeq, int studySeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = S.BRANCH_SEQ) AS 'BRANCH', ");
		query.append("(SELECT C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = S.CAMPUS_SEQ) AS 'CAMPUS', ");
		query.append("(SELECT T.TERM_NAME FROM pia_term_details T WHERE T.TERM_DETAIL_SEQ = S.TERM_DETAIL_SEQ) AS 'TERM', ");
		query.append("DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(S.UPDATE_DATE, '%Y/%m/%d %r') AS 'FORM_UPDATE_DATE', ");
		query.append("GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'WRITER' ");
		query.append("FROM pia_studies S ");
		query.append("WHERE BRANCH_SEQ = ? ");
		query.append("AND TERM_DETAIL_SEQ = ? ");
		query.append("AND CAMPUS_SEQ = ? ");
		query.append("AND STUDY_SEQ = ? ");
		query.append("AND IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = branchSeq;
		params[idx++] = termDetailSeq;
		params[idx++] = campusSeq;
		params[idx++] = studySeq;

		// 스케쥴 정보
		StudyAllInOne result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<StudyAllInOne>(StudyAllInOne.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new StudyAllInOne();
		}

		// unknown
		query.setLength(0);
		query.append("SELECT DISTINCT STUDENT_LEVEL AS 'level' ");
		query.append("FROM pia_study_unknown_students ");
		query.append("WHERE STUDY_SEQ = ? ");
		query.append("ORDER BY STUDENT_LEVEL ");

		idx = 0;
		params = new Object[1];
		params[idx++] = studySeq;

		List<StudyUnknownStudentLevels> unknownStudentLevels = null;
		List<StudyUnknownStudent> unknownStudents = null;
		try {
			unknownStudentLevels = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudyUnknownStudentLevels>(StudyUnknownStudentLevels.class));

			query.setLength(0);
			query.append("SELECT * ");
			query.append("FROM pia_study_unknown_students ");
			query.append("WHERE STUDY_SEQ = ? ");
			query.append("  AND STUDENT_LEVEL = ? ");
			for (StudyUnknownStudentLevels level : unknownStudentLevels) {
				try {
					idx = 0;
					params = new Object[2];
					params[idx++] = studySeq;
					params[idx++] = level.getLevel();
					unknownStudents = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudyUnknownStudent>(StudyUnknownStudent.class));
				} catch (org.springframework.dao.EmptyResultDataAccessException e) {
					unknownStudents = new ArrayList<StudyUnknownStudent>();
				}

				level.setStudents(unknownStudents);
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			unknownStudentLevels = new ArrayList<StudyUnknownStudentLevels>();
		}

		result.setUnknownStudents(unknownStudentLevels);

		// level
		query.setLength(0);
		query.append("SELECT S.* ");
		query.append("FROM pia_study_levels S ");
		query.append("WHERE BRANCH_SEQ = ? ");
		query.append("AND CAMPUS_SEQ = ? ");
		query.append("ORDER BY LEVEL_NAME ");

		idx = 0;
		params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;

		List<StudyLevel> levels = null;
		try {
			levels = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudyLevel>(StudyLevel.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new StudyAllInOne();
		}

		// level grouping students
		query.setLength(0);
		query.append("SELECT S.NAME AS 'STUDENT_NAME', S.STUDENT_ID, ");
		query.append("       S.REQUEST_COURSE, ");
		query.append("       (SELECT C.COURSE_NAME FROM pia_courses C WHERE C.COURSE_SEQ = S.COURSE_SEQ) AS COURSE ");
		query.append("  FROM pia_study_level_groupings G, pia_students S");
		query.append(" WHERE G.STUDENT_ID = S.STUDENT_ID ");
		query.append("   AND G.STUDY_SEQ = ? ");
		query.append("   AND G.LEVEL_SEQ = ? ");
		query.append("   AND S.IS_DELETED IS FALSE ");
		query.append("   AND G.IS_DELETED IS FALSE ");

		List<StudyLevelGrouping> studentLevelGroupings = null;
		for (StudyLevel studentStudyLevel : levels) {
			idx = 0;
			params = new Object[2];
			params[idx++] = studySeq;
			params[idx++] = studentStudyLevel.getLevelSeq();

			try {
				studentLevelGroupings = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudyLevelGrouping>(StudyLevelGrouping.class));
			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				return new StudyAllInOne();
			}

			studentStudyLevel.setStudents(studentLevelGroupings);
		}

		result.setLevels(levels);

		// timetable
		query.setLength(0);
		query.append("SELECT DISTINCT S.LEVEL_SEQ, ");
		query.append("(SELECT LEVEL_NAME FROM pia_study_levels T WHERE T.LEVEL_SEQ = S.LEVEL_SEQ) AS 'LEVEL_NAME' ");
		query.append("FROM pia_study_timetables S ");
		query.append("WHERE STUDY_SEQ = ? ");
		query.append("AND IS_DELETED IS FALSE ");

		idx = 0;
		params = new Object[1];
		params[idx++] = studySeq;

		List<StudyTimetable> timetables = null;
		try {
			timetables = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudyTimetable>(StudyTimetable.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new StudyAllInOne();
		}

		// timetable group by level
		query.setLength(0);
		query.append("SELECT S.*, ");
		query.append("(SELECT LEVEL_NAME FROM pia_study_levels T WHERE T.LEVEL_SEQ = S.LEVEL_SEQ) AS 'LEVEL_NAME' ");
		query.append("FROM pia_study_timetables S ");
		query.append("WHERE STUDY_SEQ = ? ");
		query.append("AND LEVEL_SEQ = ? ");
		query.append("AND IS_DELETED IS FALSE ");

		List<StudyTimetableDetail> studentTimetableDetails = null;
		for (StudyTimetable timetable : timetables) {
			idx = 0;
			params = new Object[2];
			params[idx++] = studySeq;
			params[idx++] = timetable.getLevelSeq();

			try {
				studentTimetableDetails = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudyTimetableDetail>(StudyTimetableDetail.class));
			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				return new StudyAllInOne();
			}

			timetable.setDetails(studentTimetableDetails);
		}

		result.setTimetables(timetables);

		// schedule
		query.setLength(0);
		query.append("SELECT DISTINCT S.STUDY_ROOM ");
		query.append("FROM pia_study_schedules S ");
		query.append("WHERE STUDY_SEQ = ? ");
		query.append("AND IS_DELETED IS FALSE ");

		idx = 0;
		params = new Object[1];
		params[idx++] = studySeq;

		List<StudySchedule> schedules = null;
		try {
			schedules = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudySchedule>(StudySchedule.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new StudyAllInOne();
		}

		// get schedule group by studyRoom
		query.setLength(0);
		query.append("SELECT SS.*, S.NAME AS 'STUDENT_NAME' ");
		query.append("  FROM pia_study_schedules SS, pia_students S ");
		query.append(" WHERE SS.STUDENT_ID = S.STUDENT_ID ");
		query.append("   AND SS.STUDY_SEQ = ? ");
		query.append("   AND SS.STUDY_ROOM = ? ");
		query.append("   AND SS.IS_DELETED IS FALSE ");
		query.append("   AND S.IS_DELETED IS FALSE ");

		List<StudyScheduleDetail> studentStudyScheduleDetails = null;
		for (StudySchedule studentStudySchedule : schedules) {
			idx = 0;
			params = new Object[2];
			params[idx++] = studySeq;
			params[idx++] = studentStudySchedule.getStudyRoom();

			try {
				studentStudyScheduleDetails = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudyScheduleDetail>(StudyScheduleDetail.class));
			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				return new StudyAllInOne();
			}

			studentStudySchedule.setDetails(studentStudyScheduleDetails);
		}

		result.setSchedules(schedules);

		return result;
	}

	public int addStudy(int branchSeq, int campusSeq, int termDetailSeq, String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_studies ");
		query.append("( ");
		query.append(" BRANCH_SEQ, CAMPUS_SEQ, TERM_SEQ, TERM_DETAIL_SEQ, START_DATE, END_DATE, STAFF_ID, IS_DELETED, UPDATE_DATE, REGISTER_DATE ");
		query.append(") VALUES ( ");
		query.append(" ?, ?, (SELECT TERM_SEQ FROM pia_term_details WHERE TERM_DETAIL_SEQ = ?), ?, ");
		query.append(" (SELECT START_DATE FROM pia_term_details WHERE TERM_DETAIL_SEQ = ?), (SELECT END_DATE FROM pia_term_details WHERE TERM_DETAIL_SEQ = ?), ");
		query.append(" ?, 0, NOW(), NOW() ");
		query.append(") ");

		int idx = 0;
		Object[] params = new Object[7];
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;
		params[idx++] = termDetailSeq;
		params[idx++] = termDetailSeq;
		params[idx++] = termDetailSeq;
		params[idx++] = termDetailSeq;
		params[idx++] = staffId;

		jdbcTemplate.update(query.toString(), params);

		query.setLength(0);
		query.append("SELECT LAST_INSERT_ID() ");
		int studySeq = jdbcTemplate.queryForObject(query.toString(), Integer.class);

		return studySeq;
	}

	public Map<String, List<String>> updateLevels(int branchSeq, int campusSeq, int termDetailSeq, int studySeq, String staffId, Map<String, List<String>> levelMap) {
		if (levelMap == null) {
			return new LinkedHashMap<String, List<String>>();
		}

		Map<String, List<String>> failedStudentsMap = new LinkedHashMap<String, List<String>>();
		List<String> failedStudents = new ArrayList<String>();

		String studentId = null;
		int levelSeq = 0;

		deleteLevelGroupings(studySeq);
		deleteTimetables(studySeq);
		deleteSchedules(studySeq);

		List<String> students = new ArrayList<String>();
		Set<String> levelNames = levelMap.keySet();
		for (String levelName : levelNames) {
			students = levelMap.get(levelName);
			levelSeq = getLevelSeq(branchSeq, campusSeq, staffId, levelName);

			for (String studentName : students) {
				studentId = getStudentId(branchSeq, studentName);
				if (Tools.isEmpty(studentId)) {
					failedStudents.add(studentName);
					continue;
				}

				boolean isSuccessed = insertLevelGrouping(studySeq, levelSeq, studentId, studentName, staffId);
				if (!isSuccessed) {
					failedStudents.add(studentName);
				} else {
					updateStudentLevel(levelSeq, campusSeq, studentId);
				}
			}

			if (!failedStudents.isEmpty()) {
				failedStudentsMap.put(levelName, failedStudents);
				failedStudents = null;
				failedStudents = new ArrayList<String>();
			}
		}

		return failedStudentsMap;
	}

	public List<String> getUnknownLevelname(int branchSeq, int campusSeq, int studySeq, Map<String, Map<String, String>> timetableMap) {
		List<String> unknownLevelname = new ArrayList<String>();
		Set<String> levelKeys = timetableMap.keySet();

		boolean isSuccessed = false;
		for (String levelName : levelKeys) {
			isSuccessed = isValidLevelname(branchSeq, campusSeq, levelName);
			if (!isSuccessed) {
				unknownLevelname.add(levelName);
			}
		}

		return unknownLevelname;
	}

	public Map<String, Map<String, String>> addTimetable(int branchSeq, int campusSeq, int studySeq, Map<String, Map<String, String>> timetableMap, String staffId) {
		Map<String, Map<String, String>> failedTimetable = new LinkedHashMap<String, Map<String, String>>();
		Map<String, String> failedSchedule = new LinkedHashMap<String, String>();
		Set<String> levelKeys = timetableMap.keySet();

		boolean isSuccessed = false;
		String studySubject = null;

		deleteTimetables(studySeq);

		Map<String, String> timetable = null;
		Set<String> timeKeys = null;
		for (String levelName : levelKeys) {
			timetable = timetableMap.get(levelName);
			timeKeys = timetable.keySet();

			for (String studyTime : timeKeys) {
				studySubject = timetable.get(studyTime);
				isSuccessed = insertTimetable(branchSeq, campusSeq, studySeq, levelName, studyTime, studySubject, staffId);
				if (!isSuccessed) {
					failedSchedule.put(studyTime, studySubject);
				}
			}
			failedTimetable.put(levelName, failedSchedule);
		}

		return failedTimetable;
	}

	private boolean isValidLevelname(int branchSeq, int campusSeq, String levelName) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT LEVEL_SEQ FROM pia_study_levels WHERE LEVEL_NAME = ? AND BRANCH_SEQ = ? AND CAMPUS_SEQ = ? AND IS_DELETED IS FALSE");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = levelName;
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;

		int levelSeq = 0;
		try {
			levelSeq = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		} catch (Exception e) {
			levelSeq = 0;
		}

		return levelSeq > 0;
	}

	public List<String> addSchedules(int branchSeq, int campusSeq, int termDetailSeq, int studySeq, List<Map<String, String>> detailSchedules, String staffId) {
		Set<String> keys = null;
		String studentId = null;
		int levelSeq = 0;
		int timetableSeq = 0;

		String studyTime = null;
		int studyMember = 0;
		String studyRoom = null;
		String teacherName = null;
		String studentName = null;

		boolean isSuccessed = false;
		Study study = null;

		deleteSchedules(studySeq);

		List<String> failedStudents = new ArrayList<String>();
		Map<String, String> failedStudent = new LinkedHashMap<String, String>();
		for (Map<String, String> detail : detailSchedules) {
			keys = detail.keySet();
			for (String key : keys) {
				if ("memberCount".equals(key)) {
					studyMember = Tools.getInt(detail.get(key));
				} else if ("teacher".equals(key)) {
					teacherName = detail.get(key);
				} else if ("time".equals(key)) {
					studyTime = detail.get(key);
				} else if ("room".equals(key)) {
					studyRoom = detail.get(key);
				} else if ("student".equals(key)) {
					studentName = detail.get(key);
				}
			} // get from Map

			if (studyMember < 1 || Tools.isEmpty(teacherName) || Tools.isEmpty(studyTime) || Tools.isEmpty(studyRoom) || Tools.isEmpty(studentName)) {
				continue;
			}

			studentId = getStudentId(branchSeq, studentName);
			if (Tools.isEmpty(studentId)) {
				failedStudent.put("Time", studyTime);
				failedStudent.put("Classroom", studyRoom);
				failedStudent.put("Teacher", teacherName);
				failedStudent.put("Type", "1 ON " + studyMember);
				failedStudent.put("Student", studentName);

				failedStudents.add("Lack of Student info (STUDENT_ID IS NULL) " + failedStudent.toString());

				studentId = null;
				studyTime = null;
				studyMember = 0;
				studyRoom = null;
				teacherName = null;
				studentName = null;
				failedStudent = null;
				failedStudent = new LinkedHashMap<String, String>();

				continue;
			}

			study = getPlainStudy(branchSeq, campusSeq, termDetailSeq, studySeq);
			if (Tools.isNull(study)) {
				failedStudent.put("Time", studyTime);
				failedStudent.put("Classroom", studyRoom);
				failedStudent.put("Teacher", teacherName);
				failedStudent.put("Type", "1 ON " + studyMember);
				failedStudent.put("Student", studentName);

				failedStudents.add("Lack of Study info (Study information is null) " + failedStudent.toString());

				studentId = null;
				studyTime = null;
				studyMember = 0;
				studyRoom = null;
				teacherName = null;
				studentName = null;
				failedStudent = null;
				failedStudent = new LinkedHashMap<String, String>();

				continue;
			}

			levelSeq = getStudentLevelSeq(studySeq, studentId);
			if (levelSeq < 1) {
				failedStudent.put("Time", studyTime);
				failedStudent.put("Classroom", studyRoom);
				failedStudent.put("Teacher", teacherName);
				failedStudent.put("Type", "1 ON " + studyMember);
				failedStudent.put("Student", studentName);

				failedStudents.add("Lack of Level info (Level information is null) " + failedStudent.toString());

				studentId = null;
				studyTime = null;
				studyMember = 0;
				studyRoom = null;
				teacherName = null;
				studentName = null;
				failedStudent = null;
				failedStudent = new LinkedHashMap<String, String>();

				continue;
			}

			timetableSeq = getTimetableSeq(studySeq, levelSeq, studyTime);
			if (timetableSeq < 1) {
				failedStudent.put("Time", studyTime);
				failedStudent.put("Classroom", studyRoom);
				failedStudent.put("Teacher", teacherName);
				failedStudent.put("Type", "1 ON " + studyMember);
				failedStudent.put("Student", studentName);

				failedStudents.add("Lack of Timetable info (Timetable information is null) " + failedStudent.toString());

				studentId = null;
				studyTime = null;
				studyMember = 0;
				studyRoom = null;
				teacherName = null;
				studentName = null;
				failedStudent = null;
				failedStudent = new LinkedHashMap<String, String>();

				continue;
			}

			isSuccessed = insertSchedule(studySeq, levelSeq, timetableSeq, studentId, studyTime, studyMember, studyRoom, teacherName, staffId);
			if (!isSuccessed) {
				failedStudent.put("Time", studyTime);
				failedStudent.put("Classroom", studyRoom);
				failedStudent.put("Teacher", teacherName);
				failedStudent.put("Type", "1 ON " + studyMember);
				failedStudent.put("Student", studentName);

				failedStudents.add("Failed Insert info " + failedStudent.toString());

				studentId = null;
				studyTime = null;
				studyMember = 0;
				studyRoom = null;
				teacherName = null;
				studentName = null;
				failedStudent = null;
				failedStudent = new LinkedHashMap<String, String>();
			}
		}

		return failedStudents;
	}

	public boolean removeStudy(int studySeq) {
		boolean isSuccessedStudies = deleteStudy(studySeq);
		boolean isSuccessedLevelGroupings = deleteLevelGroupings(studySeq);
		boolean isSuccessedTimetables = deleteTimetables(studySeq);
		boolean isSuccessedSchedules = deleteSchedules(studySeq);

		if (isSuccessedStudies || isSuccessedLevelGroupings || isSuccessedSchedules || isSuccessedTimetables) {
			return true;
		} else {
			return false;
		}
	}

	public String getStudentIdAtDetailTerm(int branchSeq, int detailTermSeq, String studentName) {
		StringBuffer query = new StringBuffer();
		String birthday = Tools.getOnlyNumber(studentName);
		studentName = Tools.trim(Tools.getOnlyEnglish(studentName));

		int idx = 0;
		Object[] params = null;
		if (Tools.isEmpty(birthday)) {
			// only one person
			query.append("SELECT STUDENT_ID ");
			query.append("  FROM pia_students ");
			query.append(" WHERE BRANCH_SEQ = ? ");
			query.append("   AND REPLACE(NAME, ' ', '') = REPLACE(?, ' ', '') ");
			query.append("   AND (START_CONTRACT_DATE BETWEEN (SELECT D.START_DATE FROM pia_term_details D WHERE D.TERM_DETAIL_SEQ = ?) AND (SELECT D.END_DATE FROM pia_term_details D WHERE D.TERM_DETAIL_SEQ = ?) ");
			query.append("         OR");
			query.append("       END_CONTRACT_DATE BETWEEN (SELECT D.START_DATE FROM pia_term_details D WHERE D.TERM_DETAIL_SEQ = ?) AND (SELECT D.END_DATE FROM pia_term_details D WHERE D.TERM_DETAIL_SEQ = ?)) ");

			params = new Object[6];
			params[idx++] = branchSeq;
			params[idx++] = Tools.removeAllSpaces(studentName);
			params[idx++] = detailTermSeq;
			params[idx++] = detailTermSeq;
			params[idx++] = detailTermSeq;
			params[idx++] = detailTermSeq;

		} else {
			// more than two people
			query.append("SELECT STUDENT_ID ");
			query.append("  FROM pia_students ");
			query.append(" WHERE BRANCH_SEQ = ? ");
			query.append("   AND REPLACE(NAME, ' ', '') = REPLACE(?, ' ', '') ");
			query.append("   AND DATE_FORMAT(DATE_OF_BIRTH, '%y%m%d') LIKE ? ");
			query.append("   AND (START_CONTRACT_DATE BETWEEN (SELECT D.START_DATE FROM pia_term_details D WHERE D.TERM_DETAIL_SEQ = ?) AND (SELECT D.END_DATE FROM pia_term_details D WHERE D.TERM_DETAIL_SEQ = ?) ");
			query.append("         OR");
			query.append("       END_CONTRACT_DATE BETWEEN (SELECT D.START_DATE FROM pia_term_details D WHERE D.TERM_DETAIL_SEQ = ?) AND (SELECT D.END_DATE FROM pia_term_details D WHERE D.TERM_DETAIL_SEQ = ?)) ");

			params = new Object[7];
			params[idx++] = branchSeq;
			params[idx++] = Tools.removeAllSpaces(studentName);
			params[idx++] = birthday + "%";
			params[idx++] = detailTermSeq;
			params[idx++] = detailTermSeq;
			params[idx++] = detailTermSeq;
			params[idx++] = detailTermSeq;
		}

		String studentId = null;
		try {
			studentId = jdbcTemplate.queryForObject(query.toString(), params, String.class);
		} catch (org.springframework.dao.EmptyResultDataAccessException emptyE) {
			studentId = "";
		} catch (org.springframework.dao.IncorrectResultSizeDataAccessException ir) {
			System.out.println("branchSeq : " + branchSeq + ", studentName : " + studentName + ", birthday : " + birthday + ", studentId : " + studentId);
			return studentId;
		} catch (Exception e) {
			e.printStackTrace();
			studentId = "";
		}

		return studentId;
	}

	public String getStudentId(int branchSeq, String studentName) {
		StringBuffer query = new StringBuffer();
		String birthday = Tools.getOnlyNumber(studentName);
		studentName = Tools.trim(Tools.getOnlyEnglish(studentName));

		int idx = 0;
		Object[] params = null;
		if (Tools.isEmpty(birthday)) {
			// only one person
			query.append("SELECT STUDENT_ID FROM pia_students WHERE BRANCH_SEQ = ? AND REPLACE(NAME, ' ', '') = REPLACE(?, ' ', '') AND IS_DELETED IS FALSE ");
			// query.append("SELECT STUDENT_ID FROM pia_students WHERE BRANCH_SEQ = ? AND
			// REPLACE(NAME, ' ', '') = REPLACE(?, ' ', '') AND IS_DELETED IS FALSE AND
			// END_CONTRACT_DATE > NOW() ");
			params = new Object[2];
			params[idx++] = branchSeq;
			params[idx++] = Tools.removeAllSpaces(studentName);

		} else {
			// more than two people
			query.append("SELECT STUDENT_ID FROM pia_students WHERE BRANCH_SEQ = ? AND REPLACE(NAME, ' ', '') = REPLACE(?, ' ', '') AND DATE_FORMAT(DATE_OF_BIRTH, '%Y%m%d') LIKE ? AND IS_DELETED IS FALSE ");
			// query.append("SELECT STUDENT_ID FROM pia_students WHERE BRANCH_SEQ = ? AND
			// REPLACE(NAME, ' ', '') = REPLACE(?, ' ', '') AND DATE_FORMAT(DATE_OF_BIRTH,
			// '%Y%m%d') LIKE ? AND IS_DELETED IS FALSE AND END_CONTRACT_DATE > NOW() ");
			params = new Object[3];
			params[idx++] = branchSeq;
			params[idx++] = Tools.removeAllSpaces(studentName);
			params[idx++] = "%" + birthday + "%";
		}

		String studentId = null;
		try {
			studentId = jdbcTemplate.queryForObject(query.toString(), params, String.class);
		} catch (org.springframework.dao.EmptyResultDataAccessException emptyE) {
			System.err.println("Student information is none = branchSeq : " + branchSeq + ", studentName : " + studentName + ", birthday : " + birthday + ", studentId : " + studentId);
			studentId = "";
		} catch (org.springframework.dao.IncorrectResultSizeDataAccessException ir) {
			System.err.println("Selected more than 1 student information = branchSeq : " + branchSeq + ", studentName : " + studentName + ", birthday : " + birthday + ", studentId : " + studentId);
			ir.printStackTrace();
			return studentId;
		} catch (Exception e) {
			e.printStackTrace();
			studentId = "";
		}

		return studentId;
	}

	public Study getPlainStudy(int branchSeq, int campusSeq, int termDetailSeq, int studySeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * FROM pia_studies WHERE BRANCH_SEQ = ? AND CAMPUS_SEQ = ? AND TERM_DETAIL_SEQ = ? AND STUDY_SEQ = ? AND IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;
		params[idx++] = termDetailSeq;
		params[idx++] = studySeq;

		Study result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<Study>(Study.class));
		} catch (Exception e) {
			result = new Study();
		}

		return result;
	}

	public int getStudentLevelSeq(int studySeq, String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT LEVEL_SEQ FROM pia_study_level_groupings WHERE STUDY_SEQ = ? AND STUDENT_ID = ? AND IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = studySeq;
		params[idx++] = studentId;

		int levelSeq = 0;
		try {
			levelSeq = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		} catch (Exception e) {
			levelSeq = 0;
		}

		return levelSeq;
	}

	public int getTimetableSeq(int studySeq, int levelSeq, String studyTime) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT TIMETABLE_SEQ FROM pia_study_timetables WHERE STUDY_SEQ = ? AND LEVEL_SEQ = ? AND STUDY_TIME = ? AND IS_DELETED IS FALSE");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = studySeq;
		params[idx++] = levelSeq;
		params[idx++] = studyTime;

		int timetableSeq = 0;
		try {
			timetableSeq = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		} catch (Exception e) {
			timetableSeq = 0;
		}

		return timetableSeq;
	}

	public boolean isValidWriter(int branchSeq, int campusSeq, int termDetailSeq, int studySeq, String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT COUNT(*) ");
		query.append("FROM pia_studies ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append("  AND CAMPUS_SEQ = ? ");
		query.append("  AND TERM_DETAIL_SEQ = ? ");
		query.append("  AND STUDY_SEQ = ? ");
		query.append("  AND STAFF_ID = ? ");

		int idx = 0;
		Object[] params = new Object[5];
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;
		params[idx++] = termDetailSeq;
		params[idx++] = studySeq;
		params[idx++] = staffId;

		try {
			return jdbcTemplate.queryForObject(query.toString(), params, Integer.class) > 0;
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return false;
		}
	}

	public int getLevelSeq(int branchSeq, int campusSeq, String staffId, String levelName) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT LEVEL_SEQ FROM pia_study_levels WHERE LEVEL_NAME = ? AND BRANCH_SEQ = ? AND CAMPUS_SEQ = ? AND IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = levelName;
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;

		int levelSeq = 0;
		try {
			levelSeq = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			levelSeq = 0;
		}

		if (levelSeq < 1) {
			query.setLength(0);
			query.append("INSERT INTO pia_study_levels ");
			query.append("( ");
			query.append(" BRANCH_SEQ, CAMPUS_SEQ, LEVEL_NAME, STAFF_ID, UPDATE_DATE, REGISTER_DATE ");
			query.append(") VALUES ( ");
			query.append(" ?, ?, ?, ?, NOW(), NOW() ");
			query.append(") ");

			idx = 0;
			params = new Object[4];
			params[idx++] = branchSeq;
			params[idx++] = campusSeq;
			params[idx++] = levelName;
			params[idx++] = staffId;

			jdbcTemplate.update(query.toString(), params);

			query.setLength(0);
			query.append("SELECT LAST_INSERT_ID() ");
			levelSeq = jdbcTemplate.queryForObject(query.toString(), Integer.class);
		}

		return levelSeq;
	}

	public int getLevelGroupingSeq(int studySeq, int levelSeq, String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT LEVEL_GROUPING_SEQ ");
		query.append("  FROM pia_study_level_groupings ");
		query.append(" WHERE STUDENT_ID = ? ");
		query.append("   AND STUDY_SEQ = ? ");
		query.append("   AND LEVEL_SEQ = ? ");
		query.append("   AND IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = studentId;
		params[idx++] = studySeq;
		params[idx++] = levelSeq;

		int levelGroupingSeq = 0;
		try {
			levelGroupingSeq = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			levelGroupingSeq = 0;
		}

		return levelGroupingSeq;
	}

	public boolean insertLevelGrouping(int studySeq, int levelSeq, String studentId, String studentName, String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_study_level_groupings ");
		query.append("( STUDY_SEQ, LEVEL_SEQ, STUDENT_ID, INPUT_STUDENT_NAME, STAFF_ID, UPDATE_DATE, REGISTER_DATE, IS_DELETED ) ");
		query.append("VALUES ( ");
		query.append(" ?, ?, ?, ?, ?, ");
		query.append(" NOW(), NOW(), 0 ");
		query.append(") ");

		int idx = 0;
		Object[] params = new Object[5];
		params[idx++] = studySeq;
		params[idx++] = levelSeq;
		params[idx++] = studentId;
		params[idx++] = studentName;
		params[idx++] = staffId;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean updateLevelGrouping(int levelGroupingSeq, int levelSeq, String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_study_level_groupings SET ");
		query.append("LEVEL_SEQ = ?, STAFF_ID = ?, UPDATE_DATE = NOW() ");
		query.append("WHERE LEVEL_GROUPING_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = levelSeq;
		params[idx++] = staffId;
		params[idx++] = levelGroupingSeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public int isExistTimetable(int branchSeq, int campusSeq, int studySeq, String levelName, String studyTime) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT TIMETABLE_SEQ ");
		query.append("  FROM pia_study_timetables ");
		query.append(" WHERE STUDY_SEQ = ? ");
		query.append("   AND LEVEL_SEQ = ");
		query.append(" (");
		query.append("     SELECT LEVEL_SEQ ");
		query.append("       FROM pia_study_levels ");
		query.append("     WHERE BRANCH_SEQ = ? ");
		query.append("       AND CAMPUS_SEQ = ? ");
		query.append("       AND LEVEL_NAME = ?");
		query.append(" )");
		query.append("   AND STUDY_TIME = ? ");
		query.append("   AND IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[5];
		params[idx++] = studySeq;
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;
		params[idx++] = levelName;
		params[idx++] = studyTime;

		int timetableSeq = 0;
		try {
			timetableSeq = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			timetableSeq = 0;
		}

		return timetableSeq;
	}

	public boolean insertTimetable(int branchSeq, int campusSeq, int studySeq, String levelName, String studyTime, String studySubject, String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_study_timetables ( ");
		query.append(" STUDY_SEQ, LEVEL_SEQ, ");
		query.append(" STUDY_TIME, SUBJECT, ");
		query.append(" STAFF_ID, IS_DELETED, REGISTER_DATE, UPDATE_DATE ");
		query.append(") VALUES ( ");
		query.append(" ?, ");
		query.append(" (SELECT LEVEL_SEQ FROM pia_study_levels WHERE LEVEL_NAME = ? AND BRANCH_SEQ = ? AND CAMPUS_SEQ = ? AND IS_DELETED IS FALSE ), ");
		query.append(" ?, ?, ");
		query.append(" ?, 0, NOW(), NOW() ");
		query.append(") ");

		int idx = 0;
		Object[] params = new Object[7];
		params[idx++] = studySeq;

		params[idx++] = levelName; // LEVEL_SEQ
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;

		params[idx++] = studyTime;
		params[idx++] = studySubject;

		params[idx++] = staffId;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean updateTimetable(int timetableSeq, String studyTime, String studySubject, String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_study_timetables SET ");
		query.append(" STUDY_TIME = ?, ");
		query.append(" SUBJECT = ?, ");
		query.append(" STAFF_ID = ?, ");
		query.append(" UPDATE_DATE = NOW() ");
		query.append(" WHERE TIMETABLE_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = studyTime;
		params[idx++] = studySubject;
		params[idx++] = staffId;
		params[idx++] = timetableSeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public int getScheduleSeq(int studySeq, int levelSeq, String studentId, String studyTime) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT SCHEDULE_SEQ ");
		query.append("  FROM pia_study_schedules ");
		query.append(" WHERE STUDY_SEQ = ?");
		query.append("   AND LEVEL_SEQ = ?");
		query.append("   AND STUDENT_ID = ?");
		query.append("   AND STUDY_TIME = ?");
		query.append("   AND IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = studySeq;
		params[idx++] = levelSeq;
		params[idx++] = studentId;
		params[idx++] = studyTime;

		int scheduleSeq = 0;
		try {
			scheduleSeq = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			scheduleSeq = 0;
		}
		return scheduleSeq;
	}

	public boolean updateSchedule(int studySeq, int levelSeq, int scheduleSeq, String studentId, String studyTime, int studyMember, String studyRoom, String teacherName, String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_study_schedules SET ");
		query.append(" STUDY_MEMBER = ?, ");
		query.append(" STUDY_ROOM = ?, ");
		query.append(" TEACHER_NAME = ?, ");
		query.append(" TIMETABLE_SEQ = (SELECT TIMETABLE_SEQ FROM pia_study_timetables WHERE LEVEL_SEQ = ? AND STUDY_TIME = ? AND IS_DELETED IS FALSE ), "); // TIMETABLE_SEQ
		query.append(" UPDATE_DATE = NOW() ");
		query.append(" WHERE SCHEDULE_SEQ = ?");

		int idx = 0;
		Object[] params = new Object[6];
		params[idx++] = studyMember;
		params[idx++] = studyRoom;
		params[idx++] = teacherName;

		params[idx++] = levelSeq;
		params[idx++] = studyTime;

		params[idx++] = scheduleSeq;

		boolean isSuccessed = false;
		try {
			isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			isSuccessed = false;
		}

		return isSuccessed;
	}

	public boolean insertSchedule(int studySeq, int levelSeq, int timetableSeq, String studentId, String studyTime, int studyMember, String studyRoom, String teacherName, String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_study_schedules ( ");
		query.append(" STUDY_SEQ, STUDENT_ID, LEVEL_SEQ, ");
		query.append(" STUDY_TIME, STUDY_MEMBER, STUDY_ROOM, TEACHER_NAME, ");
		query.append(" TIMETABLE_SEQ, ");
		query.append(" STAFF_ID, IS_DELETED, REGISTER_DATE, UPDATE_DATE");
		query.append(" ) VALUES ( ");
		query.append(" ?, ?, ?, "); // STUDY_SEQ, STUDENT_ID, LEVEL_SEQ,
		query.append(" ?, ?, ?, ?, "); // STUDY_TIME, STUDY_MEMBER, STUDY_ROOM, TEACHER_NAME,
		query.append(" ?, "); // TIMETABLE_SEQ
		query.append(" ?, 0, NOW(), NOW()");
		query.append(" ) ");

		int idx = 0;
		Object[] params = new Object[9];
		params[idx++] = studySeq;
		params[idx++] = studentId;
		params[idx++] = levelSeq;

		params[idx++] = studyTime;// STUDY_TIME, STUDY_MEMBER, STUDY_ROOM, TEACHER_NAME,
		params[idx++] = studyMember;
		params[idx++] = studyRoom;
		params[idx++] = teacherName;

		params[idx++] = timetableSeq;

		params[idx++] = staffId;

		boolean isSuccessed = false;
		try {
			isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			isSuccessed = false;
		}

		return isSuccessed;
	}

	public boolean deleteStudy(int studySeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_studies ");
		query.append("   SET ");
		query.append(" IS_DELETED = 1, ");
		query.append(" UPDATE_DATE = NOW() ");
		query.append("WHERE STUDY_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studySeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean deleteLevelGroupings(int studySeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_study_level_groupings ");
		query.append("   SET ");
		query.append(" IS_DELETED = 1, ");
		query.append(" UPDATE_DATE = NOW() ");
		query.append("WHERE STUDY_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studySeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean deleteSchedules(int studySeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_study_schedules ");
		query.append("   SET ");
		query.append(" IS_DELETED = 1, ");
		query.append(" UPDATE_DATE = NOW() ");
		query.append("WHERE STUDY_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studySeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean deleteTimetables(int studySeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_study_timetables ");
		query.append("   SET ");
		query.append(" IS_DELETED = 1, ");
		query.append(" UPDATE_DATE = NOW() ");
		query.append("WHERE STUDY_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studySeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean updateStudentLevel(int levelSeq, int campusSeq, String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append(" LEVEL_SEQ = ?, ");
		query.append(" CAMPUS_SEQ = ? ");
		query.append("WHERE STUDENT_ID = ? ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = levelSeq;
		params[idx++] = campusSeq;
		params[idx++] = studentId;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public void insertUnknownStudents(int studySeq, String staffId, Map<String, List<String>> unKnownStudents) {
		StringBuffer query = new StringBuffer();
		int idx = 0;
		Object[] params = null;

		query.append("SELECT COUNT(*) FROM pia_study_unknown_students WHERE STUDY_SEQ = ? ");
		idx = 0;
		params = new Object[1];
		params[idx] = studySeq;

		Integer integerUnknownStudetnsCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		if (Tools.getInt(integerUnknownStudetnsCount) > 0) {
			query.setLength(0);
			query.append("DELETE FROM pia_study_unknown_students WHERE STUDY_SEQ = ? ");
			idx = 0;
			params = new Object[1];
			params[idx] = studySeq;
			jdbcTemplate.update(query.toString(), params);
		}

		query.setLength(0);
		query.append("INSERT pia_study_unknown_students (STUDY_SEQ, STAFF_ID, STUDENT_LEVEL, STUDENT_NAME, REGISTER_DATE) ");
		query.append(" VALUES (?, ?, ?, ?, NOW()) ");

		idx = 0;
		params = new Object[4];
		params[0] = studySeq;
		params[1] = staffId;

		Set<String> keys = unKnownStudents.keySet();
		for (String levelName : keys) {
			params[2] = levelName;
			for (String studentName : unKnownStudents.get(levelName)) {
				params[3] = studentName;
				jdbcTemplate.update(query.toString(), params);
			}
		}
	}

	public List<StudySchedule> getDuplicationTeachers(int studySeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT A.*, COUNT(*) NUM ");
		query.append("FROM ( ");
		query.append(" SELECT *, CONCAT(STUDY_TIME, TEACHER_NAME) AS CON_TIME_TEACHER");
		query.append("   FROM pia_study_schedules ");
		query.append("  WHERE STUDY_SEQ = ? ");
		query.append("    AND IS_DELETED IS FALSE ");
		query.append("  GROUP BY TIMETABLE_SEQ  ");
		query.append(") A ");
		query.append(" GROUP BY CON_TIME_TEACHER ");
		query.append(" HAVING NUM > 1 ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studySeq;

		List<StudySchedule> schedules = null;
		try {
			schedules = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudySchedule>(StudySchedule.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new ArrayList<StudySchedule>();
		}

		List<StudySchedule> validateResult = null;
		List<StudySchedule> results = new ArrayList<StudySchedule>();

		query.setLength(0);
		query.append("SELECT A.* ");
		query.append("  FROM pia_study_schedules A ");
		query.append(" WHERE STUDY_TIME = ? ");
		query.append("   AND TEACHER_NAME = ? ");
		query.append("   AND STUDY_SEQ = ? ");
		query.append("   AND IS_DELETED IS FALSE ");
		for (StudySchedule studySchedule : schedules) {
			idx = 0;
			params = new Object[3];
			params[idx++] = studySchedule.getStudyTime();
			params[idx++] = studySchedule.getTeacherName();
			params[idx++] = studySeq;

			try {
				validateResult = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudySchedule>(StudySchedule.class));
				for (StudySchedule schedule : validateResult) {
					results.add(schedule);
				}
			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				validateResult = new ArrayList<StudySchedule>();
			}
		}

		return results;
	}

	public List<StudySchedule> getDuplicationStudents(int studySeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT A.*, COUNT(*) NUM ");
		query.append("FROM ( ");
		query.append(" SELECT *, CONCAT(STUDY_TIME, STUDENT_ID) AS CON_TIME_STUDENT");
		query.append("   FROM pia_study_schedules ");
		query.append("  WHERE STUDY_SEQ = ? ");
		query.append("    AND IS_DELETED IS FALSE ");
		query.append(") A ");
		query.append(" GROUP BY CON_TIME_STUDENT ");
		query.append(" HAVING NUM > 1 ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studySeq;

		List<StudySchedule> schedules = null;
		try {
			schedules = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudySchedule>(StudySchedule.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new ArrayList<StudySchedule>();
		}

		List<StudySchedule> validateResult = null;
		List<StudySchedule> results = new ArrayList<StudySchedule>();

		query.setLength(0);
		query.append("SELECT A.*, ");
		query.append("(SELECT NAME FROM pia_students T WHERE T.STUDENT_ID = A.STUDENT_ID) AS 'STUDENT_NAME' ");
		query.append("  FROM pia_study_schedules A ");
		query.append(" WHERE STUDY_TIME = ? ");
		query.append("   AND STUDENT_ID = ? ");
		query.append("   AND STUDY_SEQ = ? ");
		query.append("   AND IS_DELETED IS FALSE ");
		for (StudySchedule studySchedule : schedules) {
			idx = 0;
			params = new Object[3];
			params[idx++] = studySchedule.getStudyTime();
			params[idx++] = studySchedule.getStudentId();
			params[idx++] = studySeq;

			try {
				validateResult = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudySchedule>(StudySchedule.class));
				for (StudySchedule schedule : validateResult) {
					results.add(schedule);
				}
			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				validateResult = new ArrayList<StudySchedule>();
			}
		}

		return results;
	}

	public List<Student> getStudents(int branchSeq, int campusSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT A.* FROM (  ");
		query.append("     SELECT ");
		query.append("         BRANCH_SEQ, CAMPUS_SEQ, TERM_SEQ, TERM_DETAIL_SEQ, NATIONALITY_SEQ, SURNAME, GIVEN_NAMES, LEVEL_SEQ, ENGLISH_NAME, NAME, IS_DELETED, ");
		query.append("         REQUEST_COURSE AS 'COURSE', SEX, ");
		query.append("         (SELECT B.BRANCH_NAME FROM PIA_BRANCHES B WHERE B.BRANCH_SEQ = S.BRANCH_SEQ) AS 'BRANCH', ");
		query.append("         (SELECT C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = S.CAMPUS_SEQ) AS 'CAMPUS', ");
		query.append("         (SELECT T.TERM_NAME FROM pia_term_details T WHERE T.TERM_DETAIL_SEQ = S.TERM_DETAIL_SEQ) AS 'TERM', ");
		query.append("         (SELECT CODE FROM pia_nationalities N WHERE N.NATIONALITY_SEQ = S.NATIONALITY_SEQ) AS 'NATIONALITY_CODE', ");
		query.append("         (SELECT C.LEVEL_NAME FROM pia_study_levels C WHERE C.LEVEL_SEQ = S.LEVEL_SEQ) AS 'LEVEL', ");
		query.append("         DATE_FORMAT(S.START_CONTRACT_DATE, '%Y/%m/%d') AS 'FORM_DATE_OF_START_CONTRACT', ");
		query.append("         DATE_FORMAT(S.END_CONTRACT_DATE, '%Y/%m/%d') AS 'FORM_DATE_OF_END_CONTRACT', ");
		query.append("         DATE_FORMAT(S.DATE_OF_BIRTH, '%Y/%m/%d') AS 'FORM_DATE_OF_BIRTH', ");
		query.append("         CASE ");
		query.append("           WHEN (S.SURNAME IS NOT NULL AND S.SURNAME != '') OR (S.GIVEN_NAMES IS NOT NULL AND S.GIVEN_NAMES != '') THEN CONCAT(S.SURNAME, ' ' , S.GIVEN_NAMES) ");
		query.append("           WHEN S.NAME IS NOT NULL AND S.NAME != '' THEN S.NAME ");
		query.append("           WHEN S.ENGLISH_NAME IS NOT NULL AND S.ENGLISH_NAME != '' THEN S.ENGLISH_NAME ");
		query.append("         END AS 'STR_NAME' ");
		query.append("      FROM PIA_STUDENTS S ");
		query.append(" ) A ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append("  AND (");
		query.append("  			CAMPUS_SEQ = ? ");
		query.append("  			OR CAMPUS_SEQ = (SELECT C.CAMPUS_SEQ FROM pia_campuses C WHERE branch_seq = ? AND C.CAMPUS_NAME = 'Interview') ");
		query.append("  			OR CAMPUS_SEQ = (SELECT C.CAMPUS_SEQ FROM pia_campuses C WHERE branch_seq = ? AND C.CAMPUS_NAME = 'Undecided') ");
		query.append("  		) ");
		query.append("  AND IS_DELETED IS FALSE ");
		query.append("  AND FORM_DATE_OF_END_CONTRACT >= NOW() ");
		query.append("ORDER BY ISNULL(LEVEL) ASC, TERM_DETAIL_SEQ DESC, CAMPUS_SEQ, NATIONALITY_SEQ DESC, STR_NAME ");

		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;
		params[idx++] = branchSeq;
		params[idx++] = branchSeq;

		List<Student> schedules = null;
		try {
			schedules = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Student>(Student.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new ArrayList<Student>();
		}

		return schedules;
	}

	public int duplicatedStudySeq(int branchSeq, int campusSeq, int termDetailSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT STUDY_SEQ FROM pia_studies WHERE BRANCH_SEQ = ? AND CAMPUS_SEQ = ? AND TERM_DETAIL_SEQ = ? AND IS_DELETED IS FALSE ");
		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;
		params[idx++] = termDetailSeq;

		int studySeq = 0;
		try {
			studySeq = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			studySeq = 0;
		}
		return studySeq;
	}

	public StudyAllInOne getTeachersSchedule(int studySeq) {
		StudyAllInOne result = new StudyAllInOne();
		int idx = 0;
		StringBuffer query = new StringBuffer();
		query.append("SELECT DISTINCT S.STUDY_TIME ");
		query.append("  FROM pia_study_timetables S ");
		query.append(" WHERE STUDY_SEQ = ? ");
		query.append("   AND IS_DELETED IS FALSE ");
		query.append(" ORDER BY FIELD (S.STUDY_TIME, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7)");

		idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studySeq;

		List<StudyTimetable> timetables = null;
		try {
			timetables = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudyTimetable>(StudyTimetable.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new StudyAllInOne();
		}
		result.setTimetables(timetables);

		idx = 0;
		query.setLength(0);
		query.append("SELECT DISTINCT S.TEACHER_NAME ");
		query.append("FROM pia_study_schedules S ");
		query.append("WHERE STUDY_SEQ = ? ");
		query.append("AND IS_DELETED IS FALSE ");
		query.append("ORDER BY TEACHER_NAME ");

		params = new Object[1];
		params[idx++] = studySeq;

		List<StudySchedule> schedules = null;
		try {
			schedules = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudySchedule>(StudySchedule.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new StudyAllInOne();
		}

		idx = 0;
		query.setLength(0);
		query.append("SELECT S.*, T.SUBJECT ");
		query.append("FROM pia_study_schedules S, pia_study_timetables T ");
		query.append("WHERE S.TIMETABLE_SEQ = T.TIMETABLE_SEQ ");
		query.append("AND S.STUDY_SEQ = T.STUDY_SEQ ");
		query.append("AND S.LEVEL_SEQ = T.LEVEL_SEQ ");
		query.append("AND S.STUDY_TIME = T.STUDY_TIME ");
		query.append("AND S.STUDY_SEQ = ? ");
		query.append("AND S.TEACHER_NAME = ? ");
		query.append("AND S.IS_DELETED IS FALSE ");
		query.append("AND T.IS_DELETED IS FALSE ");
		query.append("GROUP BY STUDY_TIME ");
		query.append("ORDER BY FIELD (S.STUDY_TIME, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7)");

		List<TeacherScheduleDetail> studentStudyScheduleDetails = null;
		List<String> studentNames;
		StringBuffer studentNameQuery = new StringBuffer();
		studentNameQuery.append("SELECT D.NAME ");
		studentNameQuery.append("  FROM pia_study_schedules S, pia_students D ");
		studentNameQuery.append(" WHERE D.STUDENT_ID = S.STUDENT_ID ");
		studentNameQuery.append("   AND S.IS_DELETED IS FALSE  ");
		studentNameQuery.append("   AND S.STUDY_SEQ = ? ");
		studentNameQuery.append("   AND S.TEACHER_NAME = ? ");
		studentNameQuery.append("   AND S.STUDY_TIME = ?");
		studentNameQuery.append(" ORDER BY NAME ");

		for (StudySchedule studentStudySchedule : schedules) {
			idx = 0;
			params = new Object[2];
			params[idx++] = studySeq;
			params[idx++] = studentStudySchedule.getTeacherName();

			try {
				studentStudyScheduleDetails = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<TeacherScheduleDetail>(TeacherScheduleDetail.class));
			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				return new StudyAllInOne();
			}

			for (TeacherScheduleDetail teacherScheduleDetail : studentStudyScheduleDetails) {

				idx = 0;
				params = new Object[3];
				params[idx++] = studySeq;
				params[idx++] = studentStudySchedule.getTeacherName();
				params[idx++] = teacherScheduleDetail.getStudyTime();

				studentNames = jdbcTemplate.queryForList(studentNameQuery.toString(), params, String.class);
				teacherScheduleDetail.setStudentNames(studentNames);
			}

			studentStudySchedule.setTeacherScheduleDetails(studentStudyScheduleDetails);
		}

		result.setSchedules(schedules);

		return result;
	}

	public StudyAllInOne getAllStudentsSchedule(int studySeq) {
		StudyAllInOne result = new StudyAllInOne();
		int idx = 0;
		StringBuffer query = new StringBuffer();
		query.append("SELECT DISTINCT S.STUDY_TIME ");
		query.append("  FROM pia_study_timetables S ");
		query.append(" WHERE STUDY_SEQ = ? ");
		query.append("   AND IS_DELETED IS FALSE ");
		query.append(" ORDER BY TIMETABLE_SEQ ");

		idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studySeq;

		List<StudyTimetable> timetables = null;
		try {
			timetables = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudyTimetable>(StudyTimetable.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new StudyAllInOne();
		}
		result.setTimetables(timetables);

		idx = 0;
		query.setLength(0);
		query.append("SELECT DISTINCT S.TEACHER_NAME ");
		query.append("FROM pia_study_schedules S ");
		query.append("WHERE STUDY_SEQ = ? ");
		query.append("AND IS_DELETED IS FALSE ");
		query.append("ORDER BY TEACHER_NAME ");

		params = new Object[1];
		params[idx++] = studySeq;

		List<StudySchedule> schedules = null;
		try {
			schedules = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudySchedule>(StudySchedule.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new StudyAllInOne();
		}

		idx = 0;
		query.setLength(0);
		query.append("SELECT S.*, T.SUBJECT ");
		query.append("FROM pia_study_schedules S, pia_study_timetables T ");
		query.append("WHERE S.TIMETABLE_SEQ = T.TIMETABLE_SEQ ");
		query.append("AND S.STUDY_SEQ = T.STUDY_SEQ ");
		query.append("AND S.LEVEL_SEQ = T.LEVEL_SEQ ");
		query.append("AND S.STUDY_TIME = T.STUDY_TIME ");
		query.append("AND S.STUDY_SEQ = ? ");
		query.append("AND S.TEACHER_NAME = ? ");
		query.append("AND S.IS_DELETED IS FALSE ");
		query.append("AND T.IS_DELETED IS FALSE ");
		query.append("GROUP BY STUDY_TIME ");
		query.append("ORDER BY FIELD (S.STUDY_TIME, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7)");

		List<TeacherScheduleDetail> studentStudyScheduleDetails = null;
		List<String> studentNames;
		StringBuffer studentNameQuery = new StringBuffer();
		studentNameQuery.append("SELECT D.NAME ");
		studentNameQuery.append("  FROM pia_study_schedules S, pia_students D ");
		studentNameQuery.append(" WHERE D.STUDENT_ID = S.STUDENT_ID ");
		studentNameQuery.append("   AND S.IS_DELETED IS FALSE  ");
		studentNameQuery.append("   AND S.STUDY_SEQ = ? ");
		studentNameQuery.append("   AND S.TEACHER_NAME = ? ");
		studentNameQuery.append("   AND S.STUDY_TIME = ?");
		studentNameQuery.append(" ORDER BY NAME ");

		for (StudySchedule studentStudySchedule : schedules) {
			idx = 0;
			params = new Object[2];
			params[idx++] = studySeq;
			params[idx++] = studentStudySchedule.getTeacherName();

			try {
				studentStudyScheduleDetails = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<TeacherScheduleDetail>(TeacherScheduleDetail.class));
			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				return new StudyAllInOne();
			}

			for (TeacherScheduleDetail teacherScheduleDetail : studentStudyScheduleDetails) {

				idx = 0;
				params = new Object[3];
				params[idx++] = studySeq;
				params[idx++] = studentStudySchedule.getTeacherName();
				params[idx++] = teacherScheduleDetail.getStudyTime();

				studentNames = jdbcTemplate.queryForList(studentNameQuery.toString(), params, String.class);
				teacherScheduleDetail.setStudentNames(studentNames);
			}

			studentStudySchedule.setTeacherScheduleDetails(studentStudyScheduleDetails);
		}

		result.setSchedules(schedules);

		return result;
	}
}
