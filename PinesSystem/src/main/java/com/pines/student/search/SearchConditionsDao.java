package com.pines.student.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pines.student.common.vo.Branch;
import com.pines.student.common.vo.Campus;
import com.pines.student.common.vo.Entrance;
import com.pines.student.common.vo.Language;
import com.pines.student.common.vo.Level;
import com.pines.student.common.vo.Nationality;
import com.pines.student.common.vo.StudentGroup;
import com.pines.student.common.vo.Term;
import com.pines.student.common.vo.TermDetail;
import com.pines.student.common.vo.Timetable;

@Repository
public class SearchConditionsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Nationality> getNationalities() {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("FROM pia_nationalities ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("ORDER BY NATIONALITY ");

		try {
			return jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Nationality>(Nationality.class));
		} catch (Exception e) {
			return new ArrayList<Nationality>();
		}
	}

	public List<StudentGroup> getStudentGroups(int branchSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("FROM pia_student_groups ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append(" AND BRANCH_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = branchSeq;

		try {
			return jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<StudentGroup>(StudentGroup.class));
		} catch (Exception e) {
			return new ArrayList<StudentGroup>();
		}
	}

	public List<Campus> getCampuses(int branchSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("FROM pia_campuses ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append(" AND BRANCH_SEQ = ? ");
		query.append("ORDER BY ORDER_SEQ ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = branchSeq;
		try {
			return jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Campus>(Campus.class));
		} catch (Exception e) {
			return new ArrayList<Campus>();
		}
	}

	public List<Branch> getBranches() {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("FROM pia_branches ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("ORDER BY BRANCH_NAME ");

		try {
			return jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Branch>(Branch.class));
		} catch (Exception e) {
			return new ArrayList<Branch>();
		}
	}

	public List<Language> getLanguages() {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("FROM pia_languages ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("ORDER BY LANGUAGE_NAME ");

		try {
			return jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Language>(Language.class));
		} catch (Exception e) {
			return new ArrayList<Language>();
		}
	}

	public List<Term> getTerms(int branchSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("FROM pia_terms ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append(" AND BRANCH_SEQ = ? ");
		query.append("ORDER BY TERM DESC ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = branchSeq;
		try {
			return jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Term>(Term.class));
		} catch (Exception e) {
			return new ArrayList<Term>();
		}
	}

	public List<Level> getLevels(int branchSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("FROM pia_study_levels ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append(" AND BRANCH_SEQ = ? ");
		query.append("ORDER BY LEVEL_NAME ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = branchSeq;
		try {
			return jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Level>(Level.class));
		} catch (Exception e) {
			return new ArrayList<Level>();
		}
	}

	public List<TermDetail> getTermDetails(int branchSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("FROM pia_term_details ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append(" AND TERM_SEQ IN (SELECT TERM_SEQ FROM pia_terms WHERE BRANCH_SEQ = ?) ");
		query.append("ORDER BY TERM_NAME DESC ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = branchSeq;
		try {
			return jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<TermDetail>(TermDetail.class));
		} catch (Exception e) {
			return new ArrayList<TermDetail>();
		}
	}

	public List<Level> getLevels(int branchSeq, int campusSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("FROM pia_study_levels ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append(" AND BRANCH_SEQ = ? ");
		query.append(" AND CAMPUS_SEQ = ? ");
		query.append("ORDER BY LEVEL_NAME ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;
		try {
			return jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Level>(Level.class));
		} catch (Exception e) {
			return new ArrayList<Level>();
		}
	}

	public List<Timetable> getTimetable(int branchSeq, int campusSeq, int levelSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("  FROM pia_study_timetables ");
		query.append(" WHERE IS_DELETED IS FALSE ");
		query.append("   AND STUDY_SEQ = ( ");
		query.append("    SELECT STUDY_SEQ ");
		query.append("      FROM pia_studies ");
		query.append("     WHERE TERM_DETAIL_SEQ = GET_PROGRESS_TERM_DETAIL_SEQ() ");
		query.append("       AND BRANCH_SEQ = ? ");
		query.append("       AND CAMPUS_SEQ = ? ");
		query.append("       AND IS_DELETED IS FALSE ");
		query.append("   ) ");
		query.append("  AND LEVEL_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;
		params[idx++] = levelSeq;
		try {
			return jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Timetable>(Timetable.class));
		} catch (Exception e) {
			return new ArrayList<Timetable>();
		}
	}

	public List<Entrance> getEntrances(int branchSeq, int campusSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("  FROM pia_entrances ");
		query.append(" WHERE IS_DELETED IS FALSE ");
		query.append("   AND BRANCH_SEQ = ? ");
		query.append("   AND CAMPUS_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = campusSeq;

		try {
			return jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Entrance>(Entrance.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new ArrayList<Entrance>();
		}
	}

	public List<Campus> getCampusEachEntrances(int branchSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * ");
		query.append("  FROM pia_campuses ");
		query.append(" WHERE CAMPUS_SEQ IN ( ");
		query.append("		SELECT CAMPUS_SEQ ");
		query.append("  	      FROM pia_entrances ");
		query.append(" 		 WHERE IS_DELETED IS FALSE ");
		query.append("   	   AND BRANCH_SEQ = ? ");
		query.append(" ) ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = branchSeq;

		try {
			return jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Campus>(Campus.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new ArrayList<Campus>();
		}
	}
}
