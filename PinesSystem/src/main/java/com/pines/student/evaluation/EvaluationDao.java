package com.pines.student.evaluation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pines.student.common.Tools;
import com.pines.student.common.exception.NoneUpdatingException;
import com.pines.student.common.vo.Evaluation;
import com.pines.student.common.vo.EvaluationAnswer;
import com.pines.student.common.vo.EvaluationItem;
import com.pines.student.common.vo.EvaluationItemOption;
import com.pines.student.common.vo.SearchCondition;

@Repository
@Transactional(rollbackFor = Exception.class)
public class EvaluationDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Evaluation> getEvaluations(SearchCondition searchCondition) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT E.*, ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = E.BRANCH_SEQ) AS 'BRANCH', ");
		query.append("DATE_FORMAT(E.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("GET_WRITER_NAME_WITH_TITLE(E.STAFF_ID) AS 'WRITER' ");
		query.append("  FROM pia_evaluations E ");
		query.append(" WHERE BRANCH_SEQ = ? ");
		query.append("   AND IS_DELETED IS FALSE ");
		query.append(" ORDER BY UPDATE_DATE DESC ");
		query.append(" LIMIT ?, ? ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = searchCondition.getBranchSeq();
		params[idx++] = searchCondition.getStartIndex();
		params[idx++] = searchCondition.getOffset();

		List<Evaluation> results = null;
		Integer totalCount = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Evaluation>(Evaluation.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("  FROM pia_evaluations E ");
			query.append(" WHERE BRANCH_SEQ = ? ");
			query.append("   AND IS_DELETED IS FALSE ");

			idx = 0;
			params = new Object[1];
			params[idx++] = searchCondition.getBranchSeq();
			totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<Evaluation>();
		}
		return results;
	}

	public Evaluation getEvaluation(int branchSeq, int evaluationSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT E.*, ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = E.BRANCH_SEQ) AS 'BRANCH', ");
		query.append("DATE_FORMAT(E.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("GET_WRITER_NAME_WITH_TITLE(E.STAFF_ID) AS 'WRITER' ");
		query.append("  FROM pia_evaluations E ");
		query.append(" WHERE IS_DELETED IS FALSE ");
		query.append("   AND E.BRANCH_SEQ = ? ");
		query.append("   AND E.EVALUATION_SEQ = ?");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = evaluationSeq;

		Evaluation result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<Evaluation>(Evaluation.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new Evaluation();
		}

		query.setLength(0);
		query.append("SELECT I.*, ");
		query.append("(SELECT L.LANGUAGE_NAME FROM pia_languages L WHERE L.LANGUAGE_SEQ = I.LANGUAGE_SEQ) AS 'LANGUAGE', ");
		query.append("DATE_FORMAT(I.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE' ");
		query.append("  FROM pia_evaluation_items I ");
		query.append(" WHERE I.IS_DELETED IS FALSE ");
		query.append("   AND I.EVALUATION_SEQ = ? ");
		query.append("ORDER BY EVALUATION_SEQ, EVALUATION_GROUP_SEQ, ORDER_NO, LANGUAGE_SEQ");

		idx = 0;
		params = new Object[1];
		params[idx++] = evaluationSeq;
		List<EvaluationItem> items = null;
		try {
			items = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<EvaluationItem>(EvaluationItem.class));

			query.setLength(0);
			query.append("SELECT P.* ");
			query.append("  FROM pia_evaluation_item_options P ");
			query.append(" WHERE P.IS_DELETED IS FALSE ");
			query.append("   AND P.EVALUATION_ITEM_SEQ = ? ");
			query.append("ORDER BY P.ORDER_NO, OPTION_NO DESC ");

			List<EvaluationItemOption> options = null;
			for (EvaluationItem item : items) {
				idx = 0;
				params = new Object[1];
				params[idx++] = item.getEvaluationItemSeq();
				try {
					options = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<EvaluationItemOption>(EvaluationItemOption.class));
				} catch (org.springframework.dao.EmptyResultDataAccessException e) {
					options = new ArrayList<EvaluationItemOption>();
				}
				item.setOptions(options);
				options = new ArrayList<EvaluationItemOption>();
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			items = new ArrayList<EvaluationItem>();
		}

		result.setItems(items);
		return result;
	}

	public boolean addEvaluation(Evaluation evaluation) throws Exception {
		Object[] params = null;
		int idx = 0;
		int evaluationSeq = 0;
		int evaluationItemSeq = 0;
		String evaluationSql = getEvaluationInsertSql();
		String evaluationItemsSql = getEvaluationItemInsertSql();
		String evaluationItemOptionsSql = getEvaluationItemOptionInsertSql();

		params = new Object[3];
		params[idx++] = evaluation.getBranchSeq();
		params[idx++] = evaluation.getSummary();
		params[idx++] = evaluation.getStaffId();

		boolean isSuccessed = jdbcTemplate.update(evaluationSql, params) > 0;

		Integer evaluationIntegerSeq = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
		evaluationSeq = Tools.getInt(evaluationIntegerSeq);

		if (isSuccessed) {
			for (EvaluationItem item : evaluation.getItems()) {
				evaluationItemSeq = insertEvaluationItem(evaluationSeq, item, evaluationItemsSql);
				if (evaluationItemSeq > 0) {
					for (EvaluationItemOption option : item.getOptions()) {
						insertEvaluationItemOption(evaluationItemSeq, option, evaluationItemOptionsSql);
					}
				} else {
					throw new NoneUpdatingException();
				}
			}
		} else {
			throw new NoneUpdatingException();
		}
		return isSuccessed;
	}

	private void insertEvaluationItemOption(int evaluationItemSeq, EvaluationItemOption option, String insertSql) throws NoneUpdatingException {
		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = evaluationItemSeq;
		params[idx++] = option.getOptionContent();
		params[idx++] = option.getOrderNo();
		params[idx++] = option.getOptionNo();

		if (jdbcTemplate.update(insertSql, params) < 1) {
			throw new NoneUpdatingException();
		}
	}

	private int insertEvaluationItem(int evaluationSeq, EvaluationItem item, String itemSql) throws Exception {
		int evaluationGroupSeq = item.getEvaluationGroupSeq();
		if (evaluationGroupSeq < 1) {
			evaluationGroupSeq = getNewEvaluationGroupSeq(evaluationSeq);
		}

		int idx = 0;
		Object[] params = new Object[6];
		params[idx++] = evaluationSeq;
		params[idx++] = evaluationGroupSeq;
		params[idx++] = item.getLanguageSeq();
		params[idx++] = item.getOptionType();
		params[idx++] = item.getOrderNo();
		params[idx++] = item.getItemContent();

		if (jdbcTemplate.update(itemSql, params) < 1) {
			throw new NoneUpdatingException();
		}

		Integer evaluationItemIntegerSeq = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
		return Tools.getInt(evaluationItemIntegerSeq);

	}

	private int getNewEvaluationGroupSeq(int evaluationSeq) {
		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = evaluationSeq;
		Integer newEvaluationGroupSeq = jdbcTemplate.queryForObject("SELECT MAX(EVALUATION_GROUP_SEQ) + 1 AS 'NEW_EVALUATION_GROUP_SEQ' FROM pia_evaluation_items WHERE EVALUATION_SEQ = ?", params, Integer.class);
		return Tools.getInt(newEvaluationGroupSeq);
	}

	private void insertEvaluationItemAndOptions(int evaluationSeq, EvaluationItem item, String itemSql, String optionSql) throws Exception {
		int evaluationItemSeq = item.getEvaluationItemSeq();
		if (evaluationItemSeq < 1) {
			evaluationItemSeq = insertEvaluationItem(evaluationSeq, item, itemSql);
		}

		if (evaluationItemSeq > 0) {
			for (EvaluationItemOption option : item.getOptions()) {
				insertEvaluationItemOption(evaluationItemSeq, option, optionSql);
			}
		} else {
			throw new NoneUpdatingException();
		}
	}

	private boolean updateEvaluation(Evaluation evaluation) throws Exception {
		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = evaluation.getSummary();
		params[idx++] = evaluation.getEvaluationSeq();

		boolean isSuccessed = jdbcTemplate.update(getEvaluationUpdateSql(), params) > 0;
		if (!isSuccessed) {
			throw new NoneUpdatingException();
		}
		return isSuccessed;
	}

	public boolean newEvaluationItem(Evaluation evaluation) throws Exception {
		String evaluationItemInsertSql = getEvaluationItemInsertSql();
		String evaluationItemOptionInsertSql = getEvaluationItemOptionInsertSql();

		boolean isSuccessed = updateEvaluation(evaluation);
		for (EvaluationItem item : evaluation.getItems()) {
			insertEvaluationItemAndOptions(evaluation.getEvaluationSeq(), item, evaluationItemInsertSql, evaluationItemOptionInsertSql);
		}
		return isSuccessed;
	}

	public boolean removeEvaluation(int branchSeq, int evaluationSeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_evaluations ");
		query.append("   SET IS_DELETED = 1 ");
		query.append(" WHERE BRANCH_SEQ = ? ");
		query.append("   AND EVALUATION_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = evaluationSeq;

		boolean isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		if (isSuccessed) {
			query.setLength(0);
			query.append("SELECT EVALUATION_ITEM_SEQ FROM pia_evaluation_items WHERE EVALUATION_SEQ = ? ");

			idx = 0;
			params = new Object[1];
			params[idx++] = evaluationSeq;

			List<Integer> itemSeqs = null;
			try {
				itemSeqs = jdbcTemplate.queryForList(query.toString(), params, Integer.class);
			} catch (org.springframework.dao.EmptyResultDataAccessException e) {
				itemSeqs = new ArrayList<Integer>();
			}

			idx = 0;
			params = new Object[1];
			params[idx++] = evaluationSeq;

			jdbcTemplate.update(getEvaluationItemsDeleteByEvaluationSeqSql(), params);

			String itemOptionDeleteSql = getEvaluationItemOptionDeleteByEvaluationItemSeqSql();
			for (Integer itemSeq : itemSeqs) {
				idx = 0;
				params = new Object[1];
				params[idx++] = itemSeq;

				jdbcTemplate.update(itemOptionDeleteSql, params);
			}
		}

		return isSuccessed;
	}

	public List<EvaluationItem> getEvaluationItemsForStudent(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT I.EVALUATION_SEQ, I.EVALUATION_ITEM_SEQ, I.EVALUATION_GROUP_SEQ, I.LANGUAGE_SEQ, I.OPTION_TYPE, I.ORDER_NO AS ITEM_ORDER_NO, I.ITEM_CONTENT ");
		query.append("  FROM pia_evaluation_items I ");
		query.append(" WHERE I.IS_DELETED IS FALSE ");
		query.append("   AND I.EVALUATION_SEQ = ( ");
		query.append("       SELECT EVALUATION_SEQ ");
		query.append("         FROM pia_evaluations ");
		query.append("        WHERE IS_DELETED IS FALSE ");
		query.append("          AND BRANCH_SEQ = (SELECT BRANCH_SEQ FROM pia_students WHERE STUDENT_ID = ? ) ");
		query.append("        ORDER BY UPDATE_DATE DESC ");
		query.append("        LIMIT 1 ");
		query.append(" ) ");
		query.append(" ORDER BY I.ORDER_NO ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = studentId;

		List<EvaluationItem> results = null;
		List<EvaluationItemOption> options = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<EvaluationItem>(EvaluationItem.class));

			query.setLength(0);
			query.append("SELECT P.* ");
			query.append("  FROM pia_evaluation_item_options P ");
			query.append(" WHERE P.IS_DELETED IS FALSE ");
			query.append("   AND P.EVALUATION_ITEM_SEQ = ? ");
			query.append(" ORDER BY P.ORDER_NO ");
			for (EvaluationItem evaluationItem : results) {
				idx = 0;
				params = new Object[1];
				params[idx++] = evaluationItem.getEvaluationItemSeq();
				try {
					options = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<EvaluationItemOption>(EvaluationItemOption.class));
				} catch (org.springframework.dao.EmptyResultDataAccessException e) {
					options = new ArrayList<EvaluationItemOption>();
				}
				evaluationItem.setOptions(options);
			}
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<EvaluationItem>();
		}
		return results;
	}

	public boolean evaluateByStudent(List<EvaluationAnswer> evaluationAnswer) throws Exception {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_evaluation_answers ( ");
		query.append(" STUDENT_ID, EVALUATION_SEQ, EVALUATION_ITEM_SEQ, OPTION_SEQ, OPTION_TYPE, MEMO, ");
		query.append(" TERM_SEQ, LEVEL_SEQ, IS_DELETED, REGISTER_DATE ");
		query.append(") VALUES ( ");
		query.append(" ?, ?, ?, ?, ?, ?, ");
		query.append(" GET_PROGRESS_TERM_SEQ(), (SELECT LEVEL_SEQ FROM pia_students WHERE STUDENT_ID = ?), 0, NOW() ");
		query.append(") ");

		int idx = 0;
		Object[] params = null;
		boolean isSuccessed = false;
		for (EvaluationAnswer answered : evaluationAnswer) {
			idx = 0;
			params = new Object[7];
			params[idx++] = answered.getStudentId();
			params[idx++] = answered.getEvaluationSeq();
			params[idx++] = answered.getEvaluationItemSeq();
			params[idx++] = answered.getOptionSeq();
			params[idx++] = answered.getOptionType();
			params[idx++] = answered.getMemo();
			params[idx++] = answered.getStudentId();

			isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
			if (!isSuccessed) {
				throw new NoneUpdatingException();
			}

		}

		return isSuccessed;
	}

	private String getEvaluationInsertSql() {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_evaluations ( ");
		query.append(" BRANCH_SEQ, ");
		query.append(" SUMMARY, ");
		query.append(" IS_DELETED, ");
		query.append(" REGISTER_DATE, ");
		query.append(" UPDATE_DATE, ");
		query.append(" STAFF_ID ");
		query.append(") VALUES ( ");
		query.append(" ?, ?, 0, NOW(), NOW(), ? ");
		query.append(") ");
		return query.toString();
	}

	private String getEvaluationItemInsertSql() {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_evaluation_items ( ");
		query.append("  EVALUATION_SEQ, ");
		query.append("  EVALUATION_GROUP_SEQ, ");
		query.append("  LANGUAGE_SEQ, ");
		query.append("  OPTION_TYPE, ");
		query.append("  ORDER_NO, ");
		query.append("  ITEM_CONTENT, ");
		query.append("  IS_DELETED, ");
		query.append("  REGISTER_DATE ");
		query.append(") VALUES (  ");
		query.append("  ?, ?, ?, ?, ?, ?, ");
		query.append("  0, NOW()");
		query.append(")  ");
		return query.toString();
	}

	private String getEvaluationItemOptionInsertSql() {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_evaluation_item_options ( ");
		query.append("  EVALUATION_ITEM_SEQ, ");
		query.append("  OPTION_CONTENT, ");
		query.append("  ORDER_NO, ");
		query.append("  OPTION_NO, ");
		query.append("  IS_DELETED, ");
		query.append("  REGISTER_DATE ");
		query.append(")  ");
		query.append("VALUES ( ");
		query.append("  ?, ?, ?, ?, ");
		query.append("  0, NOW() ");
		query.append(")  ");
		return query.toString();
	}

	private String getEvaluationUpdateSql() {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_evaluations SET ");
		query.append(" SUMMARY = ?, ");
		query.append(" UPDATE_DATE = NOW() ");
		query.append("WHERE EVALUATION_SEQ = ? ");
		return query.toString();
	}

	private String getEvaluationItemsDeleteByEvaluationSeqSql() {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_evaluation_items ");
		query.append("   SET IS_DELETED = 1 ");
		query.append(" WHERE EVALUATION_SEQ = ? ");
		return query.toString();
	}

	private String getEvaluationItemDeleteSql() {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_evaluation_items ");
		query.append("   SET IS_DELETED = 1 ");
		query.append(" WHERE EVALUATION_ITEM_SEQ = ? ");
		return query.toString();
	}

	private String getEvaluationItemOptionDeleteByEvaluationItemSeqSql() {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_evaluation_item_options ");
		query.append("   SET IS_DELETED = 1 ");
		query.append(" WHERE EVALUATION_ITEM_SEQ = ? ");
		return query.toString();
	}

	private String getEvaluationItemOptionDeleteSql() {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_evaluation_item_options ");
		query.append("   SET IS_DELETED = 1 ");
		query.append(" WHERE OPTION_SEQ = ? ");
		return query.toString();
	}

	public void deleteEvaluationItems(List<EvaluationItem> deleteEvaluationItems) {
		int idx = 0;
		Object[] params = null;
		for (EvaluationItem evaluationItem : deleteEvaluationItems) {
			idx = 0;
			params = new Object[1];
			params[idx++] = evaluationItem.getEvaluationItemSeq();
			jdbcTemplate.update(getEvaluationItemDeleteSql(), params);
			jdbcTemplate.update(getEvaluationItemOptionDeleteByEvaluationItemSeqSql(), params);
		}
	}

	public void deleteEvaluationOptions(List<EvaluationItemOption> deleteEvaluationOptions) {
		int idx = 0;
		Object[] params = null;
		for (EvaluationItemOption evaluationItemOption : deleteEvaluationOptions) {
			idx = 0;
			params = new Object[1];
			params[idx++] = evaluationItemOption.getOptionSeq();
			jdbcTemplate.update(getEvaluationItemOptionDeleteSql(), params);
		}

	}

}
