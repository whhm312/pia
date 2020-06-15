package com.pines.student.emergency;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pines.student.common.vo.EmergencyContact;

@Repository
public class EmergencyContactDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<EmergencyContact> getEmergencyContacts(int branchSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT E.*, ST.*, ");
		query.append("ST.NICK_NAME AS 'name', ");
		query.append("(SELECT CODE FROM pia_nationalities N WHERE N.NATIONALITY_SEQ = ST.NATIONALITY_SEQ) AS 'nationalityAlphaThree', ");
		query.append("DATE_FORMAT(E.REGISTER_DATE, '%Y/%m/%d %r') AS 'FORM_REGISTER_DATE' ");
		query.append("FROM pia_emergency_contacts E, pia_staff ST ");
		query.append("WHERE E.STAFF_ID = ST.STAFF_ID ");
		query.append("  AND E.IS_DELETED IS FALSE ");
		query.append("  AND ST.IS_DELETED IS FALSE ");
		query.append("  AND E.BRANCH_SEQ = ");
		query.append(branchSeq);
		query.append(" ORDER BY ORDER_NO ASC, ST.NICK_NAME ");

		List<EmergencyContact> results = null;
		try {
			results = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<EmergencyContact>(EmergencyContact.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<EmergencyContact>();
		}
		return results;
	}

	public boolean addEmergencyContact(EmergencyContact contact) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_emergency_contacts (ORDER_NO, BRANCH_SEQ, STAFF_ID, EMERGENCY_CONTACT, IS_SHOWN, IS_DELETED, REGISTER_DATE) ");
		query.append("VALUES ");
		query.append("( ");
		query.append("?, ?, ?, ?, ?, 0, NOW() ");
		query.append(") ");

		int idx = 0;
		Object[] params = new Object[5];
		params[idx++] = contact.getOrderNo();
		params[idx++] = contact.getBranchSeq();
		params[idx++] = contact.getStaffId();
		params[idx++] = contact.getEmergencyContact();
		params[idx++] = contact.getIsShown();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean changeEmergencyContact(EmergencyContact contact) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_emergency_contacts ");
		query.append("   SET ");
		query.append(" EMERGENCY_CONTACT = ?, ");
		query.append(" ORDER_NO = ?, ");
		query.append(" IS_SHOWN = ? ");
		query.append(" WHERE EMERGENCY_CONTACT_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = contact.getEmergencyContact();
		params[idx++] = contact.getOrderNo();
		params[idx++] = contact.getIsShown();
		params[idx++] = contact.getEmergencyContactSeq();
		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean removeEmergencyContact(int branchSeq, int contactSeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_emergency_contacts ");
		query.append("   SET ");
		query.append(" IS_DELETED = 1 ");
		query.append(" WHERE EMERGENCY_CONTACT_SEQ = ? ");
		query.append("   AND BRANCH_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = contactSeq;
		params[idx++] = branchSeq;
		return jdbcTemplate.update(query.toString(), params) > 0;
	}

}
