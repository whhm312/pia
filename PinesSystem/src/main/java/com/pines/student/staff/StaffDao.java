package com.pines.student.staff;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pines.student.common.vo.SearchCondition;
import com.pines.student.common.vo.Staff;
import com.pines.student.common.vo.StaffAuthorization;

@Repository
public class StaffDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean isValidStaff(String staffId) {
		String query = "SELECT * FROM pia_staff WHERE STAFF_ID = ? AND IS_DELETED IS FALSE";
		Object[] params = new Object[] { staffId };

		try {
			Staff student = jdbcTemplate.queryForObject(query, params, new BeanPropertyRowMapper<Staff>(Staff.class));
			return student.getStaffSeq() > 0;
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return false;
		}
	}

	public List<Staff> getStaffsForEmergencyContacts(int branchSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, N.*, N.CODE AS SHORT_NATIONALITY, ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = S.BRANCH_SEQ) AS 'BRANCH', ");
		query.append("CONCAT(TITLE, ' ', NICK_NAME) AS 'NAME', ");
		query.append("DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(S.UPDATE_DATE, '%Y/%m/%d') AS 'FORM_UPDATE_DATE' ");
		query.append(" FROM pia_staff S, pia_nationalities N ");
		query.append("WHERE S.NATIONALITY_SEQ = N.NATIONALITY_SEQ ");
		query.append("  AND S.IS_DELETED IS FALSE ");
		query.append("  AND S.BRANCH_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = branchSeq;
		return jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Staff>(Staff.class));
	}

	public List<Staff> getStaffs(SearchCondition condition) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, N.*, N.CODE AS SHORT_NATIONALITY, ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = S.BRANCH_SEQ) AS 'BRANCH', ");
		query.append("DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(S.UPDATE_DATE, '%Y/%m/%d') AS 'FORM_UPDATE_DATE' ");
		query.append(" FROM pia_staff S, pia_nationalities N ");
		query.append("WHERE S.NATIONALITY_SEQ = N.NATIONALITY_SEQ ");
		query.append("  AND S.IS_DELETED IS FALSE ");
		query.append("  AND S.BRANCH_SEQ = ? ");

		int totalCnt = 3;
		if (condition.isNationalitiesCondition()) {
			query.append("  AND S.NATIONALITY_SEQ IN ( ");
			for (int i = 0; i < condition.getNationalitySeqs().length; i++) {
				query.append(" ? ");
				++totalCnt;
				if (i == 0 && condition.getNationalitySeqs().length > 1) {
					query.append(",");
				} else if (i > 0 && (condition.getNationalitySeqs().length - 1) > i) {
					query.append(",");
				}
			}

			query.append(" ) ");
		}

		if (condition.isNameCondition()) {
			query.append("  AND (S.REAL_NAME LIKE ? OR S.NICK_NAME LIKE ?)");
			totalCnt += 2;
		}
		query.append(" ORDER BY S.REGISTER_DATE DESC ");
		query.append(" LIMIT ?, ? ");

		int idx = 0;
		Object[] params = new Object[totalCnt];
		params[idx++] = condition.getBranchSeq();
		if (condition.isNationalitiesCondition()) {
			for (int seq : condition.getNationalitySeqs()) {
				params[idx++] = seq;
			}
		}

		if (condition.isNameCondition()) {
			params[idx++] = "%" + condition.getName() + "%";
			params[idx++] = "%" + condition.getName() + "%";
		}

		params[idx++] = condition.getStartIndex();
		params[idx++] = condition.getOffset();

		List<Staff> results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Staff>(Staff.class));
		if (!results.isEmpty()) {
			totalCnt = 1;
			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append(" FROM pia_staff S ");
			query.append("WHERE S.IS_DELETED IS FALSE ");
			query.append("  AND S.BRANCH_SEQ = ? ");

			if (condition.isNationalitiesCondition()) {
				query.append("  AND S.NATIONALITY_SEQ IN ( ");
				for (int i = 0; i < condition.getNationalitySeqs().length; i++) {
					query.append(" ? ");
					++totalCnt;
					if (i == 0 && condition.getNationalitySeqs().length > 1) {
						query.append(",");
					} else if (i > 0 && (condition.getNationalitySeqs().length - 1) > i) {
						query.append(",");
					}
				}

				query.append(" ) ");
			}

			if (condition.isNameCondition()) {
				query.append("  AND (S.REAL_NAME LIKE ? OR S.NICK_NAME LIKE ?)");
				totalCnt += 2;
			}

			idx = 0;
			params = new Object[totalCnt];
			params[idx++] = condition.getBranchSeq();
			if (condition.isNationalitiesCondition()) {
				for (int seq : condition.getNationalitySeqs()) {
					params[idx++] = seq;
				}
			}

			if (condition.isNameCondition()) {
				params[idx++] = "%" + condition.getName() + "%";
				params[idx++] = "%" + condition.getName() + "%";
			}

			int totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (totalCount > 0) {
				results.get(0).setTotalCount(totalCount);
			}
		}
		return results;
	}

	public Staff getStaff(String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, ");
		query.append("DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(S.UPDATE_DATE, '%Y/%m/%d') AS 'FORM_UPDATE_DATE' ");
		query.append(" FROM pia_staff S ");
		query.append("WHERE S.IS_DELETED IS FALSE ");
		query.append("  AND S.STAFF_ID = ? ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = staffId;

		Staff result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<Staff>(Staff.class));

			query.setLength(0);
			query.append("SELECT * FROM pia_staff_authorizations WHERE staff_id = ? AND IS_DELETED IS FALSE ");
			try {
				List<StaffAuthorization> staffAuthorizations = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StaffAuthorization>(StaffAuthorization.class));
				result.setStaffAuthorizations(staffAuthorizations);
			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				result.setStaffAuthorizations(new ArrayList<StaffAuthorization>());
			}
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new Staff();
		}

		return result;
	}

	public boolean addStaff(Staff staff) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_staff ( ");
		query.append("  BRANCH_SEQ, NATIONALITY_SEQ, STATUS, ");
		query.append("  STAFF_ID, PASSWORD, REAL_NAME, TITLE, ");
		query.append("  NICK_NAME, CONTACT, ID_CARD_SERIAL_NUMBER, ");
		query.append("  UPDATE_STAFF_ID, ");
		query.append("  IS_DELETED, REGISTER_DATE, UPDATE_DATE ");
		query.append(") ");
		query.append("VALUES ");
		query.append("( ");
		query.append("  ?, ?, ?, ");
		query.append("  ?, ?, ?, ?, ");
		query.append("  ?, ?, ?, ?, ");
		query.append("  0, NOW(), NOW() ");
		query.append(") ");

		int idx = 0;
		Object[] params = new Object[11];
		params[idx++] = staff.getBranchSeq();
		params[idx++] = staff.getNationalitySeq();
		params[idx++] = staff.getStatus();

		params[idx++] = staff.getStaffId();
		params[idx++] = staff.getPassword();
		params[idx++] = staff.getRealName();
		params[idx++] = staff.getTitle();

		params[idx++] = staff.getNickName();
		params[idx++] = staff.getContact();
		params[idx++] = staff.getIdCardSerialNumber();

		params[idx++] = staff.getUpdateStaffId();

		boolean isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		if (!staff.getStaffAuthorizations().isEmpty()) {
			if (isSuccessed) {
				query.setLength(0);
				query.append("INSERT INTO pia_staff_authorizations (STAFF_ID, BRANCH_SEQ, IS_DELETED, REGISTER_DATE) VALUES(?, ?, 0, NOW())");
				for (StaffAuthorization staffAuthorization : staff.getStaffAuthorizations()) {
					idx = 0;
					params = new Object[2];
					params[idx++] = staff.getStaffId();
					params[idx++] = staffAuthorization.getBranchSeq();
					isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
					if (!isSuccessed) {
						return false;
					}
				}
			}
		}

		return isSuccessed;
	}

	public boolean changeStaff(Staff staff) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_staff SET ");
		query.append("  BRANCH_SEQ = ?, NATIONALITY_SEQ = ?, STATUS = ?, ");
		query.append("  REAL_NAME = ?, TITLE = ?, NICK_NAME = ?, CONTACT = ?, ID_CARD_SERIAL_NUMBER = ?, ");
		query.append("  UPDATE_STAFF_ID = ?, UPDATE_DATE = NOW() ");
		query.append("WHERE STAFF_ID = ? ");

		int idx = 0;
		Object[] params = new Object[10];
		params[idx++] = staff.getBranchSeq();
		params[idx++] = staff.getNationalitySeq();
		params[idx++] = staff.getStatus();
		params[idx++] = staff.getRealName();
		params[idx++] = staff.getTitle();
		params[idx++] = staff.getNickName();
		params[idx++] = staff.getContact();
		params[idx++] = staff.getIdCardSerialNumber();
		params[idx++] = staff.getUpdateStaffId();
		params[idx++] = staff.getStaffId();

		boolean isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		if (!staff.getStaffAuthorizations().isEmpty()) {
			if (isSuccessed) {
				query.setLength(0);
				query.append("UPDATE pia_staff_authorizations SET IS_DELETED = 1 WHERE STAFF_ID = ? ");
				idx = 0;
				params = new Object[1];
				params[idx++] = staff.getStaffId();
				jdbcTemplate.update(query.toString(), params);

				query.setLength(0);
				query.append("INSERT INTO pia_staff_authorizations (STAFF_ID, BRANCH_SEQ, IS_DELETED, REGISTER_DATE) VALUES(?, ?, 0, NOW())");
				for (StaffAuthorization staffAuthorization : staff.getStaffAuthorizations()) {
					idx = 0;
					params = new Object[2];
					params[idx++] = staff.getStaffId();
					params[idx++] = staffAuthorization.getBranchSeq();
					isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
					if (!isSuccessed) {
						return false;
					}
				}
			}
		}
		return isSuccessed;
	}

	public boolean removeStaff(String deletedStaffId, String updateStaffId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_staff SET ");
		query.append("  UPDATE_STAFF_ID = ?, IS_DELETED = 1, UPDATE_DATE = NOW() ");
		query.append("WHERE STAFF_ID = ? ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = updateStaffId;
		params[idx++] = deletedStaffId;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean changeStaffPassword(String staffId, String password, String requestStaffId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_staff SET ");
		query.append("  UPDATE_STAFF_ID = ?, PASSWORD = ?, UPDATE_DATE = NOW() ");
		query.append("WHERE STAFF_ID = ? ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = requestStaffId;
		params[idx++] = password;
		params[idx++] = staffId;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}
}
