package com.pines.student.term;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Term;

@Repository
public class TermDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Term> getTerms(int branchSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT T.*, ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = T.BRANCH_SEQ) as 'BRANCH', ");
		query.append("DATE_FORMAT(T.REGISTER_DATE, '%Y/%m/%d %r') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(T.START_DATE, '%Y/%m/%d') AS 'FORM_START_DATE', ");
		query.append("DATE_FORMAT(T.END_DATE, '%Y/%m/%d') AS 'FORM_END_DATE' ");
		query.append("FROM pia_terms T ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append(" ORDER BY TERM DESC ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = branchSeq;

		List<Term> results = null;
		Integer totalCount = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Term>(Term.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM pia_terms ");
			query.append("WHERE IS_DELETED IS FALSE ");
			query.append("  AND BRANCH_SEQ = ? ");

			idx = 0;
			params = new Object[1];
			params[idx++] = branchSeq;

			totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<Term>();
		}

		return results;
	}

	public boolean addTerm(Term term) {
		StringBuffer query = new StringBuffer();

		query.append("INSERT INTO pia_terms ( ");
		query.append("BRANCH_SEQ, TERM, START_DATE, END_DATE, ");
		query.append("REGISTER_DATE, IS_DELETED ");
		query.append(") ");
		query.append("VALUES ");
		query.append("( ");
		query.append("?, ?, ");
		query.append("STR_TO_DATE(?, '%Y/%m/%d'), STR_TO_DATE(?, '%Y/%m/%d'), ");
		query.append("NOW(), 0 ");
		query.append(") ");

		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = term.getBranchSeq();
		params[idx++] = term.getTerm();
		params[idx++] = term.getStartDate();
		params[idx++] = term.getEndDate();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean changeTerm(Term term) {
		StringBuffer query = new StringBuffer();

		query.append("UPDATE pia_terms SET ");
		query.append("  TERM = ?, START_DATE = STR_TO_DATE(?, '%Y/%m/%d'), END_DATE = STR_TO_DATE(?, '%Y/%m/%d') ");
		query.append("WHERE TERM_SEQ = ? ");
		query.append("  AND BRANCH_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[5];
		params[idx++] = term.getTerm();
		params[idx++] = term.getStartDate();
		params[idx++] = term.getEndDate();
		params[idx++] = term.getTermSeq();
		params[idx++] = term.getBranchSeq();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean removeTerm(int branchSeq, int termSeq) {
		StringBuffer query = new StringBuffer();

		query.append("UPDATE pia_terms SET ");
		query.append("  IS_DELETED = 1 ");
		query.append("WHERE TERM_SEQ = ? ");
		query.append("  AND BRANCH_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = termSeq;
		params[idx++] = branchSeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

}
