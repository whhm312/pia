package com.pines.student.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pines.student.login.vo.StaffLoginDetailsVO;

@Repository
public class StaffLoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public StaffLoginDetailsVO loginStaffSecurity(String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, S.STAFF_ID AS 'USERNAME', ");
		query.append("DATE_FORMAT(S.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("2 AS 'LANGUAGE_SEQ', ");
		query.append("(SELECT  B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = S.BRANCH_SEQ) as 'BRANCH' ");
		query.append("FROM pia_staff S ");
		query.append("WHERE S.STAFF_ID = '");
		query.append(staffId);
		query.append("'");
		query.append("AND S.IS_DELETED IS FALSE ");

		StaffLoginDetailsVO result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), new BeanPropertyRowMapper<StaffLoginDetailsVO>(StaffLoginDetailsVO.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new StaffLoginDetailsVO();
		}

		return result;
	}

}
