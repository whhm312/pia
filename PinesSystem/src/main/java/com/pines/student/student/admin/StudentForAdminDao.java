package com.pines.student.student.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pines.student.common.MD5Tools;
import com.pines.student.common.Tools;
import com.pines.student.common.vo.Consulting;
import com.pines.student.common.vo.IdCardExcel;
import com.pines.student.common.vo.NewStudentExcel;
import com.pines.student.common.vo.Request;
import com.pines.student.common.vo.SearchCondition;
import com.pines.student.common.vo.Student;
import com.pines.student.common.vo.StudentChangeName;
import com.pines.student.common.vo.StudentDetail;
import com.pines.student.common.vo.StudentIdCard;
import com.pines.student.common.vo.StudentNameExcel;
import com.pines.student.common.vo.StudentPeriodHistory;
import com.pines.student.common.vo.Violation;
import com.pines.student.pos.PosDao;

@Repository
@Transactional(rollbackFor = Exception.class)
public class StudentForAdminDao {

	@Autowired
	PosDao posDao;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean isValidStudent(String studentId) {
		String query = "SELECT * FROM pia_students WHERE STUDENT_ID = ? AND IS_DELETED IS FALSE";
		Object[] params = new Object[] { studentId };

		try {
			Student student = jdbcTemplate.queryForObject(query, params, new BeanPropertyRowMapper<Student>(Student.class));
			return student.getStudentSeq() > 0;
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return false;
		}
	}

	public boolean isValidStudent(String studentId, String password) {
		String query = "SELECT * FROM pia_students WHERE STUDENT_ID = ? AND PASSWORD = ?";
		Object[] params = new Object[] { studentId, password };

		Student student = jdbcTemplate.queryForObject(query, params, new BeanPropertyRowMapper<Student>(Student.class));
		return student.getStudentSeq() > 0;
	}

	public boolean changeBasicInformation(String studentId, Student student) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append(" NATIONALITY = ?, ");
		query.append(" NAME = ?, ");
		query.append(" SURNAME = ?, ");
		query.append(" GIVEN_NAMES = ?, ");
		query.append(" SEX = ? ");
		query.append(" WHERE STUDENT_ID = ?");

		int idx = 0;
		Object[] params = new Object[6];
		params[idx++] = student.getNationality();
		params[idx++] = student.getName();
		params[idx++] = student.getSurname();
		params[idx++] = student.getGivenNames();
		params[idx++] = student.getSex();
		params[idx++] = studentId;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean removeStudent(String staffId, String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append(" IS_DELETED = 1, ");
		query.append(" DELETED_DATE = NOW(), ");
		query.append(" DELETE_ID = ? ");
		query.append(" WHERE STUDENT_ID = ?");

		Object[] params = new Object[] { staffId, studentId };
		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean addStudent(Student student) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_students (");
		query.append(" STUDENT_ID, ");
		query.append(" BRANCH_SEQ, CAMPUS_SEQ, TERM_SEQ, LANGUAGE_SEQ, PASSWORD, ");
		query.append(" NATIONALITY, NAME, SURNAME, GIVEN_NAMES, SEX, ");
		query.append(" DATE_OF_BIRTH, EMERGENCY_CONTACT, RELATIONSHIP_WITH_CONTACT, ");
		query.append(" LOCAL_CONTACT, EMAIL, MESSENGER_TYPE, MESSENGER_ID, ENGLISH_NAME ");
		query.append(") VALUES ( ");
		query.append("(");
		query.append("SELECT concat(A.TERM_DATE, A.TERM, lpad((A.COUNT+1), 3, 0)) as STUDENT_ID ");
		query.append("FROM ");
		query.append("( ");
		query.append("SELECT ");
		query.append("(SELECT DATE_FORMAT(START_DATE, '%y%m%d') FROM db_pia_offline.pia_terms WHERE TERM_SEQ = ?) AS 'TERM_DATE', ");
		query.append("(SELECT TERM FROM db_pia_offline.pia_terms WHERE TERM_SEQ = ?) AS 'TERM', ");
		query.append("(SELECT COUNT(*) FROM db_pia_offline.pia_students WHERE TERM_SEQ = ?) AS 'COUNT' ");
		query.append(") A ");
		query.append("),");
		query.append(" ?, ?, ?, ?, ?, ");
		query.append(" ?, ?, ?, ?, ?, ");
		query.append(" STR_TO_DATE(?, '%Y/%m/%d'), ?, ?, ");
		query.append(" ?, ?, ?, ?, ? ");
		query.append(")");

		int idx = 0;
		Object[] params = new Object[21];
		params[idx++] = student.getTermSeq();
		params[idx++] = student.getTermSeq();
		params[idx++] = student.getTermSeq();

		params[idx++] = student.getBranchSeq();
		params[idx++] = student.getCampusSeq();
		params[idx++] = student.getTermSeq();
		params[idx++] = student.getLanguageSeq();
		params[idx++] = MD5Tools.makeMD5(student.getDateOfBirth());

		params[idx++] = student.getNationality();
		params[idx++] = student.getName();
		params[idx++] = student.getSurname();
		params[idx++] = student.getGivenNames();
		params[idx++] = student.getSex();

		params[idx++] = student.getDateOfBirth();
		params[idx++] = student.getEmergencyContact();
		params[idx++] = student.getRelationshipWithContact();

		params[idx++] = student.getLocalContact();
		params[idx++] = student.getEmail();
		params[idx++] = student.getMessengerType();
		params[idx++] = student.getMessengerId();
		params[idx++] = student.getEnglishName();

		return jdbcTemplate.update(query.toString(), params) > 0;

	}

	public List<NewStudentExcel> updateFreshmen(String staffId, List<NewStudentExcel> priviousStudents) {
		int idx = 0;
		Object[] params = null;
		StringBuffer query = new StringBuffer();

		query.append("UPDATE pia_students SET ");
		query.append("   BRANCH_SEQ = (SELECT BRANCH_SEQ FROM pia_branches WHERE NOTE = ?), ");
		query.append("   CAMPUS_SEQ = (SELECT CAMPUS_SEQ FROM pia_campuses WHERE CAMPUS_NAME = 'Undecided' AND BRANCH_SEQ = (SELECT BRANCH_SEQ FROM pia_branches WHERE NOTE = ?) AND IS_DELETED IS FALSE), ");
		query.append("   TERM_SEQ = ?, TERM_DETAIL_SEQ = ?, ");
		query.append("   COURSE_SEQ = (SELECT COURSE_SEQ FROM pia_courses WHERE COURSE_NAME = ? AND IS_DELETED IS FALSE), STUDY_STATUS = ?, ");
		query.append("   LEVEL_SEQ = null, ");
		query.append("   FLIGHT_SCHEDULE = ?, GOING_BACK_FLIGHT_SCHEDULE = ?, ");
		query.append("   START_CONTRACT_DATE = ?, END_CONTRACT_DATE = ?, WEEKS = ?, ");
		query.append("   REQUEST_ROOM_TYPE = ?, REQUEST_COURSE = ?, REQUEST_MEMO = ?, ");
		query.append("   SELF_ENGLISH_LEVEL = ?, ENGLISH_MAJOR = ?, OFFICIAL_TEST_SCORE = ?, BEFORE_STUDY_EXPERIENCE = ?, PLANS_OF_STUDYING_ABROAD = ?, PURPOSE_OF_STUDYING = ?, ");
		query.append("   ZIP_CODE = ?, ADDRESS = ?, ");
		query.append("   AGENCY = ?, AGENCY_BRANCH = ?, PERSON_IN_CHARGE = ?, AGENCY_EMAIL = ?, AGENCY_CONTACT_NO = ?, ");
		query.append("   UPDATE_DATE = NOW(), UPDATE_ID = ? ");
		query.append(" WHERE REPLACE(NAME, ' ', '') = REPLACE(?, ' ', '') ");
		query.append("   AND ORIGINAL_BIRTHDAY = ? ");
		query.append("   AND IS_DELETED IS FALSE ");

		int termSeq = 0;
		int tempDetailSeq = 0;
		List<NewStudentExcel> failedList = new ArrayList<NewStudentExcel>();
		for (NewStudentExcel student : priviousStudents) {

			idx = 0;
			params = new Object[1];
			StringBuffer termSeqQuery = new StringBuffer();
			try {
				termSeqQuery.append("SELECT TERM_SEQ, TERM_DETAIL_SEQ "); // term_detail_seq
				termSeqQuery.append("  FROM pia_term_details ");
				termSeqQuery.append(" WHERE TERM_NAME = ? ");
				termSeqQuery.append("   AND IS_DELETED IS FALSE ");

				params[idx++] = student.getA_Batch();
				Map<String, Object> map = jdbcTemplate.queryForMap(termSeqQuery.toString(), params);
				termSeq = (Integer) map.get("TERM_SEQ");
				tempDetailSeq = (Integer) map.get("TERM_DETAIL_SEQ");
			} catch (Exception e) {
				failedList.add(student);
				e.printStackTrace();
				continue;
			}

			idx = 0;
			params = new Object[30];

			params[idx++] = student.getB_Region(); // branchSeq
			params[idx++] = student.getB_Region(); // campusSeq

			params[idx++] = termSeq; // TERM_SEQ
			params[idx++] = tempDetailSeq; // TERM_DETAIL_SEQ

			// COURSE_SEQ
			if (student.getG_Program().indexOf("IS") >= 0) {
				params[idx++] = "Intensive ESL";
			} else if (student.getG_Program().indexOf("SS") >= 0) {
				params[idx++] = "Power ESL";
			} else if ("Speaking".equals(student.getG_Program())) {
				params[idx++] = "Power ESL";
			} else if ("Intensive".equals(student.getG_Program())) {
				params[idx++] = "Intensive ESL";
			} else {
				params[idx++] = student.getG_Program();
			}

			// STUDY_STATUS
			if (Tools.getDate(student.getP_DepartDate()).compareTo(Tools.getToday()) < 0) {
				params[idx++] = "GRADUATED";
			} else {
				if (student.getC_Status() == "연기") {
					params[idx++] = "HOLDED";
				} else if (student.getC_Status() == "취소") {
					params[idx++] = "CANCELED";
				} else {
					params[idx++] = "PROGRESS";
				}
			}

			params[idx++] = student.getS_FlightSchedule(); // FLIGHT_SCHEDULE, GOING_BACK_FLIGHT_SCHEDULE,
			params[idx++] = ""; // student.getW_FlightScheduleGoingBack()

			params[idx++] = student.getN_ArrivalDate(); // START_CONTRACT_DATE, END_CONTRACT_DATE, WEEKS
			params[idx++] = student.getP_DepartDate();
			params[idx++] = student.getO_Period();

			params[idx++] = student.getR_Dormitory(); // REQUEST_ROOM_TYPE, REQUEST_COURSE, REQUEST_MEMO
			params[idx++] = student.getG_Program();
			params[idx++] = student.getT_Remarks() + " " + student.getU_Remarks();

			params[idx++] = student.getW_EnglishLevel(); // SELF_ENGLISH_LEVEL, ENGLISH_MAJOR, OFFICIAL_TEST_SCORE,
			// BEFORE_STUDY_EXPERIENCE, PLANS_OF_STUDYING_ABROAD, PURPOSE_OF_STUDYING,
			params[idx++] = student.getV_Major();
			params[idx++] = student.getX_OfficialScore();
			params[idx++] = student.getY_ExperienceOfStudyingAbroad();
			params[idx++] = student.getZ_PlansOfStudyingAbroad();
			params[idx++] = student.getAA_PurposeOfStudying();

			params[idx++] = student.getAB_ZipCode(); // ZIP_CODE, ADDRESS,
			params[idx++] = student.getAC_Address();

			params[idx++] = student.getQ_Agency(); // AGENCY, AGENCY_BRANCH, PERSON_IN_CHARGE, AGENCY_EMAIL, AGENCY_CONTACT_NO,
			params[idx++] = ""; // student.getQ_Branch();
			params[idx++] = ""; // student.getR_PersonInCharge();
			params[idx++] = ""; // student.getS_Email_Agency();
			params[idx++] = ""; // student.getT_ContqctNo_Agency();

			params[idx++] = staffId;

			params[idx++] = Tools.removeAllSpaces(student.getF_Name());
			params[idx++] = student.getK_Birthday();

			try {
				jdbcTemplate.update(query.toString(), params);
			} catch (Exception e) {
				student.setErrorHint(e.getCause().toString());
				failedList.add(student);
				e.printStackTrace();
			}

		}

		return failedList;
	}

	public List<NewStudentExcel> addFreshmen(String staffId, List<NewStudentExcel> freshmen) {
		int idx = 0;
		Object[] params = null;

		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_students (");
		query.append(" STUDENT_ID, ");
		query.append(" BRANCH_SEQ, ");
		query.append(" CAMPUS_SEQ, ");
		query.append(" NATIONALITY_SEQ, ");
		query.append(" LANGUAGE_SEQ, ");
		query.append(" TERM_SEQ, TERM_DETAIL_SEQ, PASSWORD, ");
		query.append(" NAME, SEX, ");
		query.append(" DATE_OF_BIRTH, ORIGINAL_BIRTHDAY, EMAIL, ");
		query.append(" COURSE_SEQ, STUDY_STATUS, ");
		query.append(" FLIGHT_SCHEDULE, GOING_BACK_FLIGHT_SCHEDULE, ");
		query.append(" START_CONTRACT_DATE, END_CONTRACT_DATE, WEEKS, ");
		query.append(" REQUEST_ROOM_TYPE, REQUEST_COURSE, REQUEST_MEMO, ");
		query.append(" SELF_ENGLISH_LEVEL, ENGLISH_MAJOR, OFFICIAL_TEST_SCORE, BEFORE_STUDY_EXPERIENCE, PLANS_OF_STUDYING_ABROAD, PURPOSE_OF_STUDYING, ");
		query.append(" ZIP_CODE, ADDRESS, ");
		query.append(" AGENCY, AGENCY_BRANCH, PERSON_IN_CHARGE, AGENCY_EMAIL, AGENCY_CONTACT_NO, ");
		query.append(" REGISTER_DATE, REGISTER_ID ");
		query.append(") VALUES ( ");
		query.append("(");
		query.append("SELECT concat(A.TERM_DATE, A.TERM, lpad((A.COUNT+1), 3, 0)) AS STUDENT_ID ");
		query.append("FROM ");
		query.append("  (SELECT ");
		query.append("   (SELECT DATE_FORMAT(START_DATE, '%y%m%d') FROM pia_term_details WHERE TERM_DETAIL_SEQ = ?) AS 'TERM_DATE', ");
		query.append("   (SELECT TERM FROM pia_terms WHERE TERM_SEQ = ? ) AS 'TERM', ");
		query.append("   (SELECT COUNT(*) FROM pia_students WHERE TERM_SEQ = ?) AS 'COUNT') A ");
		query.append("), "); // studentId
		query.append(" (SELECT BRANCH_SEQ FROM pia_branches WHERE NOTE = ?), "); // branchSeq
		query.append(" (SELECT CAMPUS_SEQ FROM pia_campuses WHERE CAMPUS_NAME = 'Undecided' AND BRANCH_SEQ = (SELECT BRANCH_SEQ FROM pia_branches WHERE NOTE = ?) AND IS_DELETED IS FALSE), "); // campusSeq
		query.append(" (SELECT NATIONALITY_SEQ FROM pia_nationalities WHERE CODE = ?), "); // NATIONALITY_SEQ
		query.append(" (SELECT IF( EXISTS(SELECT LANGUAGE_SEQ FROM pia_languages WHERE CODE = ? AND IS_DELETED IS FALSE), (SELECT LANGUAGE_SEQ FROM pia_languages WHERE CODE = ? AND IS_DELETED IS FALSE), 2) AS LANGUAGE_SEQ), "); // LANGUAGE_SEQ
		query.append(" ?, ?, ?, "); // term_seq, term_detail_seq, password
		query.append(" ?, ?, "); // name, sex
		query.append(" STR_TO_DATE(?, '%Y%m%d'), ?, ?, "); // DATE_OF_BIRTH, ORIGINAL_BIRTHDAY, EMAIL,
		query.append(" (SELECT COURSE_SEQ FROM pia_courses WHERE COURSE_NAME = ? AND IS_DELETED IS FALSE), ?, "); // COURSE_SEQ, STUDY_STATUS
		query.append(" ?, ?, "); // FLIGHT_SCHEDULE, GOING_BACK_FLIGHT_SCHEDULE,
		query.append(" ?, ?, ?, "); // START_CONTRACT_DATE, END_CONTRACT_DATE, WEEKS
		query.append(" ?, ?, ?, "); // REQUEST_ROOM_TYPE, REQUEST_COURSE, REQUEST_MEMO
		query.append(" ?, ?, ?, ?, ?, ?, "); // SELF_ENGLISH_LEVEL, ENGLISH_MAJOR, OFFICIAL_TEST_SCORE,
		// BEFORE_STUDY_EXPERIENCE, PLANS_OF_STUDYING_ABROAD, PURPOSE_OF_STUDYING,
		query.append(" ?, ?, "); // ZIP_CODE, ADDRESS,
		query.append(" ?, ?, ?, ?, ?, "); // AGENCY, AGENCY_BRANCH, PERSON_IN_CHARGE, AGENCY_EMAIL, AGENCY_CONTACT_NO,
		query.append(" NOW(), ? "); // REGISTER_DATE, REGISTER_ID
		query.append(")");

		int termSeq = 0;
		int tempDetailSeq = 0;
		List<NewStudentExcel> failedList = new ArrayList<NewStudentExcel>();
		for (NewStudentExcel student : freshmen) {

			idx = 0;
			params = new Object[1];
			StringBuffer termSeqQuery = new StringBuffer();
			try {
				termSeqQuery.append("SELECT TERM_SEQ, TERM_DETAIL_SEQ "); // term_detail_seq
				termSeqQuery.append("  FROM pia_term_details ");
				termSeqQuery.append(" WHERE TERM_NAME = ? ");
				termSeqQuery.append("   AND IS_DELETED IS FALSE ");

				params[idx++] = student.getA_Batch();
				Map<String, Object> map = jdbcTemplate.queryForMap(termSeqQuery.toString(), params);
				termSeq = (Integer) map.get("TERM_SEQ");
				tempDetailSeq = (Integer) map.get("TERM_DETAIL_SEQ");
			} catch (Exception e) {
				failedList.add(student);
				e.printStackTrace();
				continue;
			}

			idx = 0;
			params = new Object[40];

			params[idx++] = tempDetailSeq; // studentId
			params[idx++] = termSeq;
			params[idx++] = termSeq;

			params[idx++] = student.getB_Region(); // branchSeq
			params[idx++] = student.getB_Region(); // branchSeq
			params[idx++] = student.getE_Nationality(); // NATIONALITY_SEQ
			params[idx++] = student.getE_Nationality(); // LANGUAGE_SEQ
			params[idx++] = student.getE_Nationality(); // LANGUAGE_SEQ

			params[idx++] = termSeq; // TERM_SEQ
			params[idx++] = tempDetailSeq; // TERM_DETAIL_SEQ
			// password
			if (Tools.isBirthdayType(student.getK_Birthday())) {
				params[idx++] = MD5Tools.makeMD5(student.getK_Birthday());
			} else {
				params[idx++] = MD5Tools.makeMD5("000000");
			}

			params[idx++] = student.getF_Name(); // name, sex
			params[idx++] = student.getI_Gender();

			if (Tools.isBirthdayType(student.getK_Birthday())) {
				if (Tools.isYyyyMmDdFormat(student.getK_Birthday())) {
					params[idx++] = student.getK_Birthday(); // date_of_birth
				} else {
					params[idx++] = Tools.changeDateFormat(student.getK_Birthday(), "yyMMdd", "yyyyMMdd"); // date_of_birth
				}
			} else {
				params[idx++] = ""; // date_of_birth
			}
			params[idx++] = student.getK_Birthday();
			params[idx++] = student.getL_EMail();

			// COURSE_SEQ
			if (student.getG_Program().indexOf("IS") >= 0) {
				params[idx++] = "Intensive ESL";
			} else if (student.getG_Program().indexOf("SS") >= 0) {
				params[idx++] = "Power ESL";
			} else if ("Speaking".equals(student.getG_Program())) {
				params[idx++] = "Power ESL";
			} else if ("Intensive".equals(student.getG_Program())) {
				params[idx++] = "Intensive ESL";
			} else {
				params[idx++] = student.getG_Program();
			}

			// STUDY_STATUS
			if (Tools.getDate(student.getP_DepartDate()).compareTo(Tools.getToday()) < 0) {
				params[idx++] = "GRADUATED";
			} else {
				if (student.getC_Status() == "연기") {
					params[idx++] = "HOLDED";
				} else if (student.getC_Status() == "취소") {
					params[idx++] = "CANCELED";
				} else {
					params[idx++] = "PROGRESS";
				}
			}

			params[idx++] = student.getS_FlightSchedule(); // FLIGHT_SCHEDULE, GOING_BACK_FLIGHT_SCHEDULE,
			params[idx++] = ""; // student.getW_FlightScheduleGoingBack()

			params[idx++] = student.getN_ArrivalDate(); // START_CONTRACT_DATE, END_CONTRACT_DATE, WEEKS
			params[idx++] = student.getP_DepartDate();
			params[idx++] = student.getO_Period();

			params[idx++] = student.getR_Dormitory(); // REQUEST_ROOM_TYPE, REQUEST_COURSE, REQUEST_MEMO
			params[idx++] = student.getG_Program();
			params[idx++] = student.getT_Remarks() + " " + student.getU_Remarks();

			params[idx++] = student.getW_EnglishLevel(); // SELF_ENGLISH_LEVEL, ENGLISH_MAJOR, OFFICIAL_TEST_SCORE,
			// BEFORE_STUDY_EXPERIENCE, PLANS_OF_STUDYING_ABROAD, PURPOSE_OF_STUDYING,
			params[idx++] = student.getV_Major();
			params[idx++] = student.getX_OfficialScore();
			params[idx++] = student.getY_ExperienceOfStudyingAbroad();
			params[idx++] = student.getZ_PlansOfStudyingAbroad();
			params[idx++] = student.getAA_PurposeOfStudying();

			params[idx++] = student.getAB_ZipCode(); // ZIP_CODE, ADDRESS,
			params[idx++] = student.getAC_Address();

			params[idx++] = student.getQ_Agency(); // AGENCY, AGENCY_BRANCH, PERSON_IN_CHARGE, AGENCY_EMAIL, AGENCY_CONTACT_NO,
			params[idx++] = ""; // student.getQ_Branch();
			params[idx++] = ""; // student.getR_PersonInCharge();
			params[idx++] = ""; // student.getS_Email_Agency();
			params[idx++] = ""; // student.getT_ContqctNo_Agency();

			params[idx++] = staffId;

			try {
				jdbcTemplate.update(query.toString(), params);
			} catch (Exception e) {
				student.setErrorHint(e.getCause().toString());
				failedList.add(student);
				e.printStackTrace();
			}

		}

		return failedList;
	}

	public List<Student> getStudents(SearchCondition condition) {
		int whereCnt = 0;
		int limitedCnt = 0;

		StringBuffer query = new StringBuffer();
		query.append("SELECT A.* ");
		query.append("FROM ( ");
		query.append("SELECT S.*, ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = S.BRANCH_SEQ) AS 'BRANCH', ");
		query.append("(SELECT C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = S.CAMPUS_SEQ) AS 'CAMPUS', ");
		query.append("(SELECT G.GROUP_NAME FROM pia_student_groups G WHERE G.STUDENT_GROUP_SEQ = S.STUDENT_GROUP_SEQ) AS 'GROUP', ");
		query.append("(SELECT T.TERM_NAME FROM pia_term_details T WHERE T.TERM_DETAIL_SEQ = S.TERM_DETAIL_SEQ) AS 'TERM', ");
		query.append("(SELECT CODE FROM pia_nationalities N WHERE N.NATIONALITY_SEQ = S.NATIONALITY_SEQ) AS 'NATIONALITY_CODE', ");
		query.append("(SELECT C.COURSE_NAME FROM pia_courses C WHERE C.COURSE_SEQ = S.COURSE_SEQ) AS 'COURSE', ");
		query.append("(SELECT C.LEVEL_NAME FROM pia_study_levels C WHERE C.LEVEL_SEQ = S.LEVEL_SEQ) AS 'LEVEL', ");
		query.append("DATE_FORMAT(S.START_CONTRACT_DATE, '%Y/%m/%d') AS 'FORM_DATE_OF_START_CONTRACT', ");
		query.append("DATE_FORMAT(S.END_CONTRACT_DATE, '%Y/%m/%d') AS 'FORM_DATE_OF_END_CONTRACT', ");
		query.append("DATE_FORMAT(S.DATE_OF_BIRTH, '%Y/%m/%d') AS 'FORM_DATE_OF_BIRTH', ");
		query.append("CASE ");
		query.append("WHEN (S.SURNAME IS NOT NULL AND S.SURNAME != '') OR (S.GIVEN_NAMES IS NOT NULL AND S.GIVEN_NAMES != '') THEN CONCAT(S.SURNAME, ' ' , S.GIVEN_NAMES) ");
		query.append("WHEN S.NAME IS NOT NULL AND S.NAME != '' THEN S.NAME ");
		query.append("WHEN S.ENGLISH_NAME IS NOT NULL AND S.ENGLISH_NAME != '' THEN S.ENGLISH_NAME ");
		query.append("END AS 'STR_NAME' ");
		query.append("FROM pia_students S ");
		query.append(") A ");

		StringBuffer queryWhere = new StringBuffer();
		queryWhere.append("WHERE IS_DELETED IS FALSE ");
		queryWhere.append("  AND BRANCH_SEQ = ? ");
		++whereCnt;

		if (condition.isCampusesCondition()) {
			queryWhere.append("  AND CAMPUS_SEQ IN ( ");
			for (int i = 0; i < condition.getCampusSeqs().length; i++) {
				queryWhere.append(" ? ");
				++whereCnt;
				if (i == 0 && condition.getCampusSeqs().length > 1) {
					queryWhere.append(",");
				} else if (i > 0 && (condition.getCampusSeqs().length - 1) > i) {
					queryWhere.append(",");
				}
			}
			queryWhere.append(" ) ");
		}

		if (condition.isNationalitiesCondition()) {
			queryWhere.append("  AND NATIONALITY_SEQ IN ( ");
			for (int i = 0; i < condition.getNationalitySeqs().length; i++) {
				queryWhere.append(" ? ");
				++whereCnt;
				if (i == 0 && condition.getNationalitySeqs().length > 1) {
					queryWhere.append(",");
				} else if (i > 0 && (condition.getNationalitySeqs().length - 1) > i) {
					queryWhere.append(",");
				}
			}
			queryWhere.append(" ) ");
		}

		if (condition.isGroupCondition()) {
			queryWhere.append("  AND STUDENT_GROUP_SEQ = ? ");
			++whereCnt;
		}

		if (condition.isStatusesCondition()) {
			queryWhere.append("  AND ( ");
			for (int i = 0; i < condition.getStatuses().size(); i++) {
				if ("PROGRESS".equals(condition.getStatuses().get(i))) {
					queryWhere.append(" END_CONTRACT_DATE >= NOW()  ");
				}

				if (condition.getStatuses().size() > 1 && i % 2 == 1) {
					queryWhere.append(" OR ");
				}

				if ("GRADUATED".equals(condition.getStatuses().get(i))) {
					queryWhere.append(" END_CONTRACT_DATE < NOW()  ");
				}
			}
			queryWhere.append(" ) ");
		}

		if (condition.isNameCondition()) {
			queryWhere.append("  AND STR_NAME LIKE ?");
			++whereCnt;
		}

		if (condition.isTermDetailCondition()) {
			queryWhere.append("  AND TERM_DETAIL_SEQ =  ?");
			++whereCnt;
		}

		query.append(queryWhere);

		StringBuffer queryOrder = new StringBuffer();
		queryOrder.append(" ORDER BY TERM_DETAIL_SEQ DESC, NATIONALITY_SEQ DESC, STR_NAME ");
		query.append(queryOrder);

		StringBuffer queryLimit = new StringBuffer();
		if (condition.getOffset() > 0) {
			queryLimit.append(" LIMIT ?, ? ");
			query.append(queryLimit);
			limitedCnt = 2;
		}

		int idx = 0;
		Object[] params = new Object[whereCnt + limitedCnt];
		params[idx++] = condition.getBranchSeq();

		if (condition.isCampusesCondition()) {
			for (int seq : condition.getCampusSeqs()) {
				params[idx++] = seq;
			}
		}

		if (condition.isNationalitiesCondition()) {
			for (int seq : condition.getNationalitySeqs()) {
				params[idx++] = seq;
			}
		}

		if (condition.isGroupCondition()) {
			params[idx++] = condition.getGroupSeq();
		}

		if (condition.isNameCondition()) {
			params[idx++] = "%" + condition.getName() + "%";
		}

		if (condition.isTermDetailCondition()) {
			params[idx++] = condition.getTermDetailSeq();
		}

		if (condition.getOffset() > 0) {
			params[idx++] = condition.getStartIndex();
			params[idx++] = condition.getOffset();
		}

		List<Student> results = null;
		Integer totalCount = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Student>(Student.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM ( ");
			query.append("SELECT S.*, ");
			query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = S.BRANCH_SEQ) AS 'BRANCH', ");
			query.append("(SELECT C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = S.CAMPUS_SEQ) AS 'CAMPUS', ");
			query.append("(SELECT G.GROUP_NAME FROM pia_student_groups G WHERE G.STUDENT_GROUP_SEQ = S.STUDENT_GROUP_SEQ) AS 'GROUP', ");
			query.append("(SELECT T.TERM_NAME FROM pia_term_details T WHERE T.TERM_DETAIL_SEQ = S.TERM_DETAIL_SEQ) AS 'TERM', ");
			query.append("(SELECT CODE FROM pia_nationalities N WHERE N.NATIONALITY_SEQ = S.NATIONALITY_SEQ) AS 'NATIONALITY_CODE', ");
			query.append("DATE_FORMAT(S.START_CONTRACT_DATE, '%Y/%m/%d') AS 'FORM_DATE_OF_START_CONTRACT', ");
			query.append("DATE_FORMAT(S.END_CONTRACT_DATE, '%Y/%m/%d') AS 'FORM_DATE_OF_END_CONTRACT', ");
			query.append("DATE_FORMAT(S.DATE_OF_BIRTH, '%Y/%m/%d') AS 'FORM_DATE_OF_BIRTH', ");
			query.append("CASE ");
			query.append("WHEN (S.SURNAME IS NOT NULL AND S.SURNAME != '') OR (S.GIVEN_NAMES IS NOT NULL AND S.GIVEN_NAMES != '') THEN CONCAT(S.SURNAME, ' ' , S.GIVEN_NAMES) ");
			query.append("WHEN S.NAME IS NOT NULL AND S.NAME != '' THEN S.NAME ");
			query.append("WHEN S.ENGLISH_NAME IS NOT NULL AND S.ENGLISH_NAME != '' THEN S.ENGLISH_NAME ");
			query.append("END AS 'STR_NAME' ");
			query.append("FROM pia_students S ");
			query.append(") A ");
			query.append(queryWhere);

			idx = 0;
			params = new Object[whereCnt];
			params[idx++] = condition.getBranchSeq();

			if (condition.isCampusesCondition()) {
				for (int seq : condition.getCampusSeqs()) {
					params[idx++] = seq;
				}
			}

			if (condition.isNationalitiesCondition()) {
				for (int seq : condition.getNationalitySeqs()) {
					params[idx++] = seq;
				}
			}

			if (condition.isGroupCondition()) {
				params[idx++] = condition.getGroupSeq();
			}

			if (condition.isNameCondition()) {
				params[idx++] = "%" + condition.getName() + "%";
			}

			if (condition.isTermDetailCondition()) {
				params[idx++] = condition.getTermDetailSeq();
			}

			totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<Student>();
		}

		return results;
	}

	public StudentDetail getStudent(int branchSeq, String studentId) {
		int totalCount = 0;

		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = S.BRANCH_SEQ) AS 'BRANCH', ");
		query.append("(SELECT C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = S.CAMPUS_SEQ) AS 'CAMPUS', ");
		query.append("(SELECT G.GROUP_NAME FROM pia_student_groups G WHERE G.STUDENT_GROUP_SEQ = S.STUDENT_GROUP_SEQ) AS 'GROUP', ");
		query.append("(SELECT T.TERM_NAME FROM pia_term_details T WHERE T.TERM_DETAIL_SEQ = S.TERM_DETAIL_SEQ) AS 'TERM', ");
		query.append("(SELECT CODE FROM pia_nationalities N WHERE N.NATIONALITY_SEQ = S.NATIONALITY_SEQ) AS 'NATIONALITY_CODE', ");
		query.append("DATE_FORMAT(S.VISA_REGISTER_DATE, '%Y/%m/%d') AS 'FORM_VISA_REGISTER_DATE', ");
		query.append("DATE_FORMAT(S.VISA_EXTEND_DATE, '%Y/%m/%d') AS 'FORM_VISA_EXTEND_DATE', ");
		query.append("DATE_FORMAT(S.START_CONTRACT_DATE, '%Y/%m/%d') AS 'FORM_TERM_START_DATE', ");
		query.append("DATE_FORMAT(S.END_CONTRACT_DATE, '%Y/%m/%d') AS 'FORM_TERM_END_DATE', ");
		query.append("DATE_FORMAT(S.DATE_OF_BIRTH, '%Y/%m/%d') AS 'FORM_DATE_OF_BIRTH', ");
		query.append("(SELECT C.COURSE_NAME FROM pia_courses C WHERE C.COURSE_SEQ = S.COURSE_SEQ) AS 'COURSE', ");
		query.append("(SELECT C.LEVEL_NAME FROM pia_study_levels C WHERE C.LEVEL_SEQ = S.LEVEL_SEQ) AS 'LEVEL', ");
		query.append("(SELECT P.FILE_PATH FROM pia_student_picture P WHERE P.STUDENT_ID = S.STUDENT_ID AND IS_DELETED IS FALSE) AS 'PROFILE_PATH', ");
		query.append("(SELECT COUNT(*) FROM pia_student_devices D WHERE D.STUDENT_ID = S.STUDENT_ID) AS 'STUDENT_DEVICE_COUNT' ");
		query.append("FROM pia_students S ");
		query.append("WHERE S.BRANCH_SEQ = ? ");
		query.append("  AND S.STUDENT_ID = ? ");
		query.append("  AND S.IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = studentId;

		StudentDetail result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<StudentDetail>(StudentDetail.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new StudentDetail();
		}

		if (Tools.isNotNull(result.getStudentId())) {
			idx = 0;
			params = new Object[1];
			params[idx++] = studentId;

			query.setLength(0);
			query.append("SELECT S.*, ");
			query.append("  R.RULE_TYPE, ");
			query.append("  R.DETAIL, ");
			query.append("  GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'STAFF', ");
			query.append("  DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE' ");
			query.append("FROM pia_student_violations S, pia_rules R ");
			query.append("WHERE S.STUDENT_ID = ? ");
			query.append("  AND S.IS_DELETED IS FALSE ");
			query.append("  AND S.RULE_SEQ = R.RULE_SEQ ");

			List<Violation> violations = null;
			try {
				violations = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Violation>(Violation.class));

				query.setLength(0);
				query.append("SELECT COUNT(*) ");
				query.append("FROM pia_student_violations S ");
				query.append("WHERE S.STUDENT_ID = ? ");
				query.append("  AND S.IS_DELETED IS FALSE ");

				totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
				if (violations.size() > 0) {
					violations.get(0).setTotalCount(Tools.getInt(totalCount));
				}
			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				violations = new ArrayList<Violation>();
			}

			query.setLength(0);
			query.append("SELECT S.*, ");
			query.append("  GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'STAFF', ");
			query.append("  DATE_FORMAT(S.REPLY_DATE, '%Y/%m/%d') AS 'FORM_REPLY_DATE', ");
			query.append("  DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE' ");
			query.append("FROM pia_requests S ");
			query.append("WHERE S.STUDENT_ID = ? ");
			query.append("  AND S.IS_DELETED IS FALSE ");

			List<Request> requests = null;
			try {
				requests = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Request>(Request.class));

				query.setLength(0);
				query.append("SELECT COUNT(*) ");
				query.append("FROM pia_requests S ");
				query.append("WHERE S.STUDENT_ID = ? ");
				query.append("  AND S.IS_DELETED IS FALSE ");

				totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
				if (requests.size() > 0) {
					requests.get(0).setTotalCount(Tools.getInt(totalCount));
				}

			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				requests = new ArrayList<Request>();
			}

			query.setLength(0);
			query.append("SELECT S.*, ");
			query.append("  GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'STAFF', ");
			query.append("  DATE_FORMAT(S.REPLY_DATE, '%Y/%m/%d') AS 'FORM_REPLY_DATE', ");
			query.append("  DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE' ");
			query.append("FROM pia_consultings S ");
			query.append("WHERE S.STUDENT_ID = ? ");
			query.append("  AND S.IS_DELETED IS FALSE ");

			List<Consulting> consultings = null;
			try {
				consultings = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Consulting>(Consulting.class));

				query.setLength(0);
				query.append("SELECT COUNT(*) ");
				query.append("FROM pia_consultings S ");
				query.append("WHERE S.STUDENT_ID = ? ");
				query.append("  AND S.IS_DELETED IS FALSE ");

				totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
				if (consultings.size() > 0) {
					consultings.get(0).setTotalCount(Tools.getInt(totalCount));
				}

			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				consultings = new ArrayList<Consulting>();
			}

			result.setViolations(violations);
			result.setRequests(requests);
			result.setConsultings(consultings);
		} else {
			result.setViolations(new ArrayList<Violation>());
			result.setRequests(new ArrayList<Request>());
			result.setConsultings(new ArrayList<Consulting>());
		}

		return result;
	}

	public boolean changeInformation(Student student) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		if (Tools.isNumber(student.getNationality())) {
			query.append(" NATIONALITY_SEQ = ?, ");
		} else {
			query.append(" NATIONALITY_SEQ = (SELECT N.NATIONALITY_SEQ FROM pia_nationalities N WHERE N.NATIONALITY = ?), ");
		}
		query.append(" NAME = ?, ");
		query.append(" SURNAME = ?, ");
		query.append(" GIVEN_NAMES = ?, ");
		query.append(" SEX = ?, ");
		query.append(" DATE_OF_BIRTH = STR_TO_DATE(?, '%Y/%m/%d'), ");
		query.append(" EMERGENCY_CONTACT = ?, ");
		query.append(" RELATIONSHIP_WITH_CONTACT = ?, ");
		query.append(" LOCAL_CONTACT = ?, ");
		query.append(" EMAIL = ?, ");
		query.append(" MESSENGER_TYPE = ?, ");
		query.append(" MESSENGER_ID = ?, ");
		query.append(" ENGLISH_NAME = ? ");
		query.append(" WHERE STUDENT_ID = ?");

		int idx = 0;
		Object[] params = new Object[14];
		params[idx++] = student.getNationality();
		params[idx++] = Tools.getOnlyEnglish(Tools.getUpperCase(student.getName()));
		params[idx++] = student.getSurname();
		params[idx++] = student.getGivenNames();
		params[idx++] = student.getSex();
		params[idx++] = student.getDateOfBirth();
		params[idx++] = student.getEmergencyContact();
		params[idx++] = student.getRelationshipWithContact();
		params[idx++] = student.getLocalContact();
		params[idx++] = student.getEmail();
		params[idx++] = student.getMessengerType();
		params[idx++] = student.getMessengerId();
		params[idx++] = student.getEnglishName();
		params[idx++] = student.getStudentId();
		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean unblockStudent(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append(" IS_BLOCKED = 0");
		query.append(" WHERE STUDENT_ID = ?");
		query.append(" AND IS_DELETED IS FALSE ");

		Object[] params = new Object[] { studentId };
		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean blockStudent(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append(" IS_BLOCKED = 1");
		query.append(" WHERE STUDENT_ID = ?");
		query.append(" AND IS_DELETED IS FALSE ");

		Object[] params = new Object[] { studentId };
		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public List<Student> getStudentsByLevel(int branchSeq, int campusSeq, int levelSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, ");
		query.append("DATE_FORMAT(S.DATE_OF_BIRTH, '%y%m%d') AS 'FORM_DATE_OF_BIRTH', ");
		query.append("CASE ");
		query.append("WHEN (S.SURNAME IS NOT NULL AND S.SURNAME != '') OR (S.GIVEN_NAMES IS NOT NULL AND S.GIVEN_NAMES != '') THEN CONCAT(S.SURNAME, ' ' , S.GIVEN_NAMES) ");
		query.append("WHEN S.NAME IS NOT NULL AND S.NAME != '' THEN S.NAME ");
		query.append("WHEN S.ENGLISH_NAME IS NOT NULL AND S.ENGLISH_NAME != '' THEN S.ENGLISH_NAME ");
		query.append("END AS 'STR_NAME' ");
		query.append("FROM pia_students S ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND TERM_SEQ = GET_PROGRESS_TERM_SEQ() ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append("  AND CAMPUS_SEQ = ? ");
		query.append("  AND LEVEL_SEQ = ? ");
		query.append(" ORDER BY STR_NAME, DATE_OF_BIRTH ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;
		params[idx++] = levelSeq;

		List<Student> results = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Student>(Student.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM pia_students S ");
			query.append("WHERE IS_DELETED IS FALSE ");
			query.append("  AND TERM_SEQ = GET_PROGRESS_TERM_SEQ() ");
			query.append("  AND BRANCH_SEQ = ? ");
			query.append("  AND CAMPUS_SEQ = ? ");
			query.append("  AND LEVEL_SEQ = ? ");

			Integer totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<Student>();
		}

		return results;
	}

	public Map<String, List<NewStudentExcel>> seperateFreshmen(String staffId, List<NewStudentExcel> freshmen) {
		int idx = 0;
		Object[] params = null;
		StringBuffer checkEnrolledStudentQuery = new StringBuffer();

		checkEnrolledStudentQuery.append("SELECT T.TERM_NAME ");
		checkEnrolledStudentQuery.append("  FROM pia_students S, pia_term_details T ");
		checkEnrolledStudentQuery.append(" WHERE S.TERM_DETAIL_SEQ <> T.TERM_DETAIL_SEQ ");
		checkEnrolledStudentQuery.append("   AND S.IS_DELETED IS FALSE ");
		checkEnrolledStudentQuery.append("   AND T.IS_DELETED IS FALSE ");
		checkEnrolledStudentQuery.append("   AND T.TERM_NAME = ? ");
		checkEnrolledStudentQuery.append("   AND REPLACE(S.NAME, ' ', '') = REPLACE(?, ' ', '') ");
		checkEnrolledStudentQuery.append("   AND S.ORIGINAL_BIRTHDAY = ? ");

		StringBuffer query = new StringBuffer();
		query.append("SELECT COUNT(*) ");
		query.append("  FROM pia_students ");
		query.append(" WHERE TERM_DETAIL_SEQ = (SELECT TERM_DETAIL_SEQ FROM pia_term_details WHERE TERM_NAME = ? AND IS_DELETED IS FALSE) ");
		query.append("   AND REPLACE(NAME, ' ', '') = REPLACE(?, ' ', '') ");
		query.append("   AND ORIGINAL_BIRTHDAY = ? ");
		query.append("   AND IS_DELETED IS FALSE ");

		Map<String, List<NewStudentExcel>> result = new HashMap<String, List<NewStudentExcel>>();
		List<NewStudentExcel> enrolledStudents = new ArrayList<NewStudentExcel>();
		List<NewStudentExcel> duplicationStudents = new ArrayList<NewStudentExcel>();
		List<NewStudentExcel> newStudents = new ArrayList<NewStudentExcel>();
		List<NewStudentExcel> errorStudents = new ArrayList<NewStudentExcel>();
		for (NewStudentExcel freshman : freshmen) {

			idx = 0;
			params = new Object[3];
			params[idx++] = freshman.getA_Batch();
			params[idx++] = Tools.removeAllSpaces(freshman.getF_Name());
			params[idx++] = freshman.getK_Birthday();
			String termDetailName = null;
			try {
				termDetailName = jdbcTemplate.queryForObject(checkEnrolledStudentQuery.toString(), params, String.class);
				System.err.println("[ENROLLED] Previous Batch : " + termDetailName + ", NEW_Batch : " + freshman.getA_Batch() + ", Name : " + freshman.getF_Name() + ", Birthday : " + freshman.getK_Birthday());
				enrolledStudents.add(freshman);
			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				Integer integerDuplication = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
				if (integerDuplication < 1) {
					System.err.println("[NEW] A_Batch : " + freshman.getA_Batch() + ", F_Name : " + freshman.getF_Name() + ", K_Birthday : " + freshman.getK_Birthday());
					newStudents.add(freshman);
				} else {
					System.err.println("[DUPLICATED] A_Batch : " + freshman.getA_Batch() + ", F_Name : " + freshman.getF_Name() + ", K_Birthday : " + freshman.getK_Birthday());
					duplicationStudents.add(freshman);
				}
			} catch (Exception e) {
				System.err.println("[ERROR] " + freshman.toString());
				errorStudents.add(freshman);
			}
		}

		result.put("newStudents", newStudents);
		result.put("duplicationStudents", duplicationStudents);
		result.put("enrolledStudents", enrolledStudents);
		result.put("errorStudents", errorStudents);
		return result;
	}

	public boolean changeStudentName(String studentId, String studentName) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append(" NAME = ? ");
		query.append(" WHERE STUDENT_ID = ? ");
		query.append("   AND IS_DELETED IS FALSE ");

		studentName = Tools.getOnlyEnglish(Tools.getUpperCase(studentName));
		Object[] params = new Object[] { studentName, studentId };
		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean chagneStudentName(StudentChangeName studentIdCard) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append(" NAME = ? ");
		query.append(" WHERE STUDENT_ID = ? ");
		query.append("   AND NAME = ? ");
		query.append("   AND IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = studentIdCard.getNewName();
		params[idx++] = studentIdCard.getStudentId();
		params[idx++] = studentIdCard.getOriginalName();
		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean registerStudentIdCard(StudentIdCard studentIdCard) throws Exception {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append(" ID_CARD_SERIAL_NUMBER = ? ");
		query.append(" WHERE STUDENT_ID = ? ");
		query.append("   AND IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = studentIdCard.getIdCardSerialNumber();
		params[idx++] = studentIdCard.getStudentId();
		boolean isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		if (isSuccessed) {
			query.setLength(0);
			query.append("INSERT INTO pia_student_id_card_history (STUDENT_ID, ID_CARD_SERIAL_NUMBER, REASON_TYPE, MEMO, STAFF_ID, REGISTER_DATE) ");
			query.append("VALUES (?, ?, ?, ?, ?, NOW())");

			idx = 0;
			params = new Object[5];
			params[idx++] = studentIdCard.getStudentId();
			params[idx++] = studentIdCard.getIdCardSerialNumber();
			params[idx++] = studentIdCard.getReasonType();
			params[idx++] = studentIdCard.getMemo();
			params[idx++] = studentIdCard.getStaffId();
			isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
			if (isSuccessed) {
				Student student = getStudent(studentIdCard.getStudentId());
				studentIdCard.setStudentName(student.getName());

				isSuccessed = posDao.registerStudent(studentIdCard);
				if (!isSuccessed) {
					throw new Exception("Insert Student information in POS System is failed.");
				}
			}
		}
		return isSuccessed;
	}

	public boolean registerProfilePicture(String studentId, String originalFilename, File destFile) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_student_picture ");
		query.append("   SET ");
		query.append(" IS_DELETED = 1, ");
		query.append(" IMAGE = NULL ");
		query.append(" WHERE STUDENT_ID = ? ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studentId;

		jdbcTemplate.update(query.toString(), params);

		query.setLength(0);
		query.append("INSERT INTO pia_student_picture (STUDENT_ID, ORIGINAL_FILENAME, FILE_SIZE, FILE_PATH, IMAGE, IS_DELETED, REGISTER_DATE) ");
		query.append(" VALUES (?, ?, ?, ?, LOAD_FILE (?), 0, NOW()) ");

		idx = 0;
		params = new Object[5];
		params[idx++] = studentId;
		params[idx++] = originalFilename;
		params[idx++] = destFile.length();
		params[idx++] = Tools.getPath(destFile.getPath());
		params[idx++] = destFile.getPath();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public List<IdCardExcel> registerIdCards(String staffId, List<IdCardExcel> idCardExcels) throws Exception {
		List<IdCardExcel> uploadFailedResults = new ArrayList<IdCardExcel>();
		boolean isSuccessed = false;
		StudentIdCard studentIdCard = null;
		for (IdCardExcel idCardExcel : idCardExcels) {
			if (idCardExcel.getC_CardSerialNumber().length() < 9) {
				uploadFailedResults.add(idCardExcel);
				continue;
			}

			studentIdCard = new StudentIdCard();
			studentIdCard.setIdCardSerialNumber(idCardExcel.getC_CardSerialNumber());
			studentIdCard.setReasonType("New");
			studentIdCard.setMemo("Register by excel file.");
			studentIdCard.setStaffId(staffId);
			studentIdCard.setStudentId(idCardExcel.getB_StudentId());

			isSuccessed = registerStudentIdCard(studentIdCard);
			if (isSuccessed) {
				posDao.registerStudent(studentIdCard);
			} else {
				uploadFailedResults.add(idCardExcel);
			}
		}
		return uploadFailedResults;
	}

	public Student getStudent(String studentId) {
		String query = "SELECT * FROM pia_students WHERE STUDENT_ID = ? AND IS_DELETED IS FALSE";
		Object[] params = new Object[] { studentId };

		try {
			return jdbcTemplate.queryForObject(query, params, new BeanPropertyRowMapper<Student>(Student.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new Student();
		}
	}

	public List<StudentNameExcel> changeStudentNames(String staffId, List<StudentNameExcel> studentNamesExcel) {
		List<StudentNameExcel> result = new ArrayList<StudentNameExcel>();
		boolean isSuccessed = false;
		StudentChangeName studentChangeName = null;
		for (StudentNameExcel studentName : studentNamesExcel) {
			if (Tools.isEmpty(studentName.getC_NewName())) {
				continue;
			}

			studentChangeName = new StudentChangeName();
			studentChangeName.setStudentId(studentName.getA_StudentId());
			studentChangeName.setOriginalName(studentName.getB_OriginalName());
			studentChangeName.setNewName(studentName.getC_NewName());

			isSuccessed = chagneStudentName(studentChangeName);
			if (!isSuccessed) {
				result.add(studentName);
			} else {
				System.out.println("[Success Changing Stduent's name] " + studentChangeName.toString());
			}
		}
		return result;
	}

	public boolean changePeriod(StudentPeriodHistory newPeriod) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT ");
		query.append("    DATE_FORMAT(START_CONTRACT_DATE, '%Y/%m/%d') AS 'FORM_TERM_START_DATE', ");
		query.append("    DATE_FORMAT(END_CONTRACT_DATE, '%Y/%m/%d') AS 'FORM_TERM_END_DATE' ");
		query.append("  FROM pia_students ");
		query.append(" WHERE STUDENT_ID = ? ");
		query.append("   AND IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = newPeriod.getStudentId();
		Student result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<Student>(Student.class));

		newPeriod.setFormPreviousEndDate(result.getFormTermEndDate());
		newPeriod.setFormPreviousStartDate(result.getFormTermStartDate());

		query.setLength(0);
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append("       START_CONTRACT_DATE = ?,  ");
		query.append("       END_CONTRACT_DATE = ? ");
		query.append(" WHERE STUDENT_ID = ? ");
		query.append("   AND IS_DELETED IS FALSE ");

		idx = 0;
		params = new Object[3];
		params[idx++] = newPeriod.getNewStartDate();
		params[idx++] = newPeriod.getNewEndDate();
		params[idx++] = newPeriod.getStudentId();

		boolean isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		if (isSuccessed) {
			query.setLength(0);
			query.append("INSERT INTO pia_student_period_history (STUDENT_ID, STAFF_ID, PREVIOUS_START_DATE, PREVIOUS_END_DATE, NEW_START_DATE, NEW_END_DATE, REGISTER_DATE) ");
			query.append("VALUES (?, ?, ?, ?, ?, ?, NOW())");

			idx = 0;
			params = new Object[6];
			params[idx++] = newPeriod.getStudentId();
			params[idx++] = newPeriod.getStaffId();
			params[idx++] = newPeriod.getFormPreviousStartDate();
			params[idx++] = newPeriod.getFormPreviousEndDate();
			params[idx++] = newPeriod.getNewStartDate();
			params[idx++] = newPeriod.getNewEndDate();
			isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		}
		return isSuccessed;
	}
}
