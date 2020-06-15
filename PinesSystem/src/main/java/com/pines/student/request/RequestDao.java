package com.pines.student.request;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Request;

@Repository
public class RequestDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Request> getStudentRequests(int branchSeq, String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, ");
		query.append("  GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'STAFF', ");
		query.append("  DATE_FORMAT(S.REPLY_DATE, '%m/%d') AS 'FORM_REPLY_DATE', ");
		query.append("  DATE_FORMAT(S.REGISTER_DATE, '%m/%d') AS 'FORM_REGISTER_DATE' ");
		query.append("FROM pia_requests S ");
		query.append("WHERE S.BRANCH_SEQ = ? ");
		query.append("  AND S.STUDENT_ID = ? ");
		query.append("  AND S.IS_DELETED = FALSE ");
		query.append("ORDER BY REGISTER_DATE DESC, REPLY_DATE ");

		List<Request> requests = null;
		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = studentId;

		try {
			requests = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Request>(Request.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM pia_requests S ");
			query.append("WHERE S.BRANCH_SEQ = ? ");
			query.append("  AND S.STUDENT_ID = ? ");
			query.append("  AND S.IS_DELETED = FALSE ");

			int totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (requests.size() > 0) {
				requests.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			requests = new ArrayList<Request>();
		}

		return requests;
	}

	public List<Request> getStudentsRequests(int branchSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, ");
		query.append("  GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'STAFF', ");
		query.append("  DATE_FORMAT(S.REPLY_DATE, '%Y/%m/%d') AS 'FORM_REPLY_DATE', ");
		query.append("  DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE' ");
		query.append("FROM pia_requests S ");
		query.append("WHERE S.BRANCH_SEQ = ? ");
		query.append("  AND S.IS_DELETED = FALSE ");

		List<Request> requests = null;
		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = branchSeq;

		try {
			requests = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Request>(Request.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM pia_requests S ");
			query.append("WHERE S.BRANCH_SEQ = ? ");
			query.append("  AND S.IS_DELETED = FALSE ");

			int totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (requests.size() > 0) {
				requests.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			requests = new ArrayList<Request>();
		}

		return requests;
	}

	public boolean addRequest(Request request) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_requests (BRANCH_SEQ, CAMPUS_SEQ, STUDENT_ID, DETAIL, TYPE, IS_DELETED, REGISTER_DATE) ");
		query.append("VALUES ");
		query.append("( ");
		query.append("?, ");
		query.append("(SELECT CAMPUS_SEQ FROM pia_students WHERE STUDENT_ID = ?), ");
		query.append("?, ?, ?, 0, NOW() ");
		query.append(") ");

		int idx = 0;
		Object[] params = new Object[5];
		params[idx++] = request.getBranchSeq();
		params[idx++] = request.getStudentId();
		params[idx++] = request.getStudentId();
		params[idx++] = request.getDetail();
		params[idx++] = request.getType();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean replyRequest(Request request) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_requests ");
		query.append("SET ");
		query.append("STAFF_ID = ?, REPLY = ?, REPLY_DATE = NOW(), IS_REPLY = 1, STATUS = 'Finish'");
		query.append("WHERE BRANCH_SEQ = ? ");
		query.append("  AND REQUEST_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = request.getStaffId();
		params[idx++] = request.getReply();
		params[idx++] = request.getBranchSeq();
		params[idx++] = request.getRequestSeq();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public List<Request> getRequests(Request conditions, int selectedPage, int offset) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT A. * ");
		query.append("FROM ( ");
		query.append("SELECT S.*, ");
		query.append("  (SELECT  C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = S.CAMPUS_SEQ) AS 'CAMPUS', ");
		query.append("  (SELECT T.NAME FROM pia_students T WHERE T.STUDENT_ID = S.STUDENT_ID) AS 'STUDENT', ");
		query.append("  (SELECT CONCAT(T.SURNAME, ' ', T.GIVEN_NAMES) FROM pia_students T WHERE T.STUDENT_ID = S.STUDENT_ID) AS 'STUDENT_PASSPORT', ");
		query.append("  GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'STAFF', ");
		query.append("  GET_WRITER_NAME_WITH_TITLE(S.PROGRESS_STAFF_ID) AS 'PROGRESS_STAFF', ");
		query.append("  DATE_FORMAT(S.REPLY_DATE, '%Y/%m/%d') AS 'FORM_REPLY_DATE', ");
		query.append("  DATE_FORMAT(S.PROGRESS_DATE, '%Y/%m/%d') AS 'FORM_PROGRESS_DATE', ");
		query.append("  DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE' ");
		query.append("FROM pia_requests S ");
		query.append("WHERE S.BRANCH_SEQ = ? ");
		query.append("  AND S.IS_DELETED = FALSE ");
		query.append(") A ");
		query.append("WHERE A.BRANCH_SEQ = ? ");
		int paramsCount = 4;

		if (conditions.getCampusSeq() > 0) {
			query.append("  AND CAMPUS_SEQ = ? ");
			paramsCount++;
		}

		if (Tools.isNotEmpty(conditions.getStaff())) {
			query.append("  AND ( A.STAFF LIKE ? OR A.PROGRESS_STAFF LIKE ? )");
			paramsCount = paramsCount + 2;
		}

		if (Tools.isNotEmpty(conditions.getStudent())) {
			query.append("  AND ( A.STUDENT LIKE ? OR A.STUDENT_PASSPORT LIKE ? )");
			paramsCount = paramsCount + 2;
		}

		int typeSize = conditions.getTypies().size();
		if (typeSize > 0) {
			query.append("  AND A.TYPE IN ( ");
			for (int i = 0; i < typeSize; i++) {
				paramsCount++;
				query.append(" ? ");

				if (i == 0 && typeSize > 1) {
					query.append(",");
				} else if (i > 0 && (typeSize - 1) > i) {
					query.append(",");
				}
			}
			query.append(" ) ");
		}

		int statusSize = conditions.getStatuses().size();
		if (statusSize > 0) {
			query.append("  AND A.STATUS IN ( ");
			for (int i = 0; i < statusSize; i++) {
				paramsCount++;
				query.append(" ? ");

				if (i == 0 && statusSize > 1) {
					query.append(",");
				} else if (i > 0 && (statusSize - 1) > i) {
					query.append(",");
				}
			}
			query.append(" ) ");
		}

		query.append("ORDER BY REGISTER_DATE DESC, REPLY_DATE ");
		query.append("LIMIT ?, ? ");

		List<Request> requests = null;
		int idx = 0;
		Object[] params = new Object[paramsCount];
		params[idx++] = conditions.getBranchSeq();
		params[idx++] = conditions.getBranchSeq();

		if (conditions.getCampusSeq() > 0) {
			params[idx++] = conditions.getCampusSeq();
		}

		if (Tools.isNotEmpty(conditions.getStaff())) {
			params[idx++] = "%" + conditions.getStaff() + "%";
			params[idx++] = "%" + conditions.getStaff() + "%";
		}

		if (Tools.isNotEmpty(conditions.getStudent())) {
			params[idx++] = "%" + conditions.getStudent() + "%";
			params[idx++] = "%" + conditions.getStudent() + "%";
		}

		if (typeSize > 0) {
			for (String type : conditions.getTypies()) {
				params[idx++] = type;
			}
		}

		if (statusSize > 0) {
			for (String status : conditions.getStatuses()) {
				params[idx++] = status;
			}
		}

		params[idx++] = Tools.getStartIndex(selectedPage, offset);
		params[idx++] = offset;

		try {
			requests = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Request>(Request.class));

			paramsCount = 2;
			idx = 0;
			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM ( ");
			query.append("SELECT S.*, ");
			query.append("  (SELECT T.NAME FROM pia_students T WHERE T.STUDENT_ID = S.STUDENT_ID) AS 'STUDENT', ");
			query.append("  (SELECT CONCAT(T.SURNAME, ' ', T.GIVEN_NAMES) FROM pia_students T WHERE T.STUDENT_ID = S.STUDENT_ID) AS 'STUDENT_PASSPORT', ");
			query.append("  GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'STAFF', ");
			query.append("  GET_WRITER_NAME_WITH_TITLE(S.PROGRESS_STAFF_ID) AS 'PROGRESS_STAFF', ");
			query.append("  DATE_FORMAT(S.REPLY_DATE, '%Y/%m/%d') AS 'FORM_REPLY_DATE', ");
			query.append("  DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE' ");
			query.append("FROM pia_requests S ");
			query.append("WHERE S.BRANCH_SEQ = ? ");
			query.append("  AND S.IS_DELETED = FALSE ");
			query.append(") A ");
			query.append("WHERE A.BRANCH_SEQ = ? ");

			if (conditions.getCampusSeq() > 0) {
				query.append("  AND CAMPUS_SEQ = ? ");
				paramsCount++;
			}

			if (Tools.isNotEmpty(conditions.getStaff())) {
				query.append("  AND (A.STAFF LIKE ? OR A.PROGRESS_STAFF LIKE ? )");
				paramsCount = paramsCount + 2;
			}

			if (Tools.isNotEmpty(conditions.getStudent())) {
				query.append("  AND ( A.STUDENT LIKE ? OR A.STUDENT_PASSPORT LIKE ? )");
				paramsCount = paramsCount + 2;
			}

			if (typeSize > 0) {
				query.append("  AND A.TYPE IN ( ");
				for (int i = 0; i < typeSize; i++) {
					paramsCount++;
					query.append(" ? ");

					if (i == 0 && typeSize > 1) {
						query.append(",");
					} else if (i > 0 && (typeSize - 1) > i) {
						query.append(",");
					}
				}
				query.append(" ) ");
			}

			if (statusSize > 0) {
				query.append("  AND A.STATUS IN ( ");
				for (int i = 0; i < statusSize; i++) {
					paramsCount++;
					query.append(" ? ");

					if (i == 0 && statusSize > 1) {
						query.append(",");
					} else if (i > 0 && (statusSize - 1) > i) {
						query.append(",");
					}
				}
				query.append(" ) ");
			}

			params = new Object[paramsCount];
			params[idx++] = conditions.getBranchSeq();
			params[idx++] = conditions.getBranchSeq();

			if (conditions.getCampusSeq() > 0) {
				params[idx++] = conditions.getCampusSeq();
			}

			if (Tools.isNotEmpty(conditions.getStaff())) {
				params[idx++] = "%" + conditions.getStaff() + "%";
			}

			if (Tools.isNotEmpty(conditions.getStudent())) {
				params[idx++] = "%" + conditions.getStudent() + "%";
			}

			if (typeSize > 0) {
				for (String type : conditions.getTypies()) {
					params[idx++] = type;
				}
			}

			if (statusSize > 0) {
				for (String status : conditions.getStatuses()) {
					params[idx++] = status;
				}
			}

			int totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (requests.size() > 0) {
				requests.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			requests = new ArrayList<Request>();
		}

		return requests;
	}

	public Request getRequest(int branchSeq, int requestSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, T.SEX, ");
		query.append("  (SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = S.BRANCH_SEQ) as 'BRANCH', ");
		query.append("  GET_NATIONALITY(T.NATIONALITY_SEQ) AS 'NATIONALITY', ");
		query.append("  T.NAME AS 'STUDENT', ");
		query.append("  GET_WRITER_NAME_WITH_TITLE(S.STAFF_ID) AS 'STAFF', ");
		query.append("  GET_WRITER_NAME_WITH_TITLE(S.PROGRESS_STAFF_ID) AS 'PROGRESS_STAFF', ");
		query.append("  DATE_FORMAT(T.DATE_OF_BIRTH, '%Y/%m/%d') AS 'BIRTHDAY', ");
		query.append("  DATE_FORMAT(S.REPLY_DATE, '%Y/%m/%d %r') AS 'FORM_REPLY_DATE', ");
		query.append("  DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d %r') AS 'FORM_REGISTER_DATE', ");
		query.append("  DATE_FORMAT(S.PROGRESS_DATE, '%Y/%m/%d %r') AS 'FORM_PROGRESS_DATE', ");
		query.append("  (SELECT COUNT(*) FROM pia_student_devices D WHERE D.STUDENT_ID = T.STUDENT_ID) AS 'STUDENT_DEVICE_COUNT' ");
		query.append("FROM pia_requests S, pia_students T ");
		query.append("WHERE S.STUDENT_ID = T.STUDENT_ID ");
		query.append("  AND S.BRANCH_SEQ = ? ");
		query.append("  AND S.REQUEST_SEQ = ? ");
		query.append("  AND S.IS_DELETED = FALSE ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = requestSeq;

		Request result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<Request>(Request.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new Request();
		}
		return result;
	}

	public boolean removeRequest(int branchSeq, int requestSeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_requests ");
		query.append("SET ");
		query.append("IS_DELETED = 1 ");
		query.append("WHERE BRANCH_SEQ = ? ");
		query.append("  AND REQUEST_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = requestSeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean progressRequest(Request request) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_requests ");
		query.append("SET ");
		query.append("PROGRESS_STAFF_ID = ?, PROGRESS_DETAIL = ?, PROGRESS_DATE = NOW(), STATUS = 'Progress' ");
		query.append("WHERE BRANCH_SEQ = ? ");
		query.append("  AND REQUEST_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = request.getProgressStaffId();
		params[idx++] = request.getProgressDetail();
		params[idx++] = request.getBranchSeq();
		params[idx++] = request.getRequestSeq();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

}
