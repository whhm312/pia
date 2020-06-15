package com.pines.student.meal.schedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.BreakfastEvaluationDetail;
import com.pines.student.common.vo.BreakfastSchedule;
import com.pines.student.common.vo.DinnerEvaluationDetail;
import com.pines.student.common.vo.DinnerSchedule;
import com.pines.student.common.vo.LunchEvaluationDetail;
import com.pines.student.common.vo.LunchSchedule;
import com.pines.student.common.vo.MealEvaluation;
import com.pines.student.common.vo.MealSchedule;
import com.pines.student.common.vo.MealsEvaluations;
import com.pines.student.common.vo.TodayBreakfastSchedule;
import com.pines.student.common.vo.TodayDinnerSchedule;
import com.pines.student.common.vo.TodayLunchSchedule;
import com.pines.student.common.vo.TodayMealSchedule;

@Repository
@Transactional(rollbackFor = Exception.class)
public class MealScheduleDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public TodayMealSchedule getTodayMeal(int branchSeq, int languageSeq) {
		StringBuffer query = new StringBuffer();
		int idx = 0;
		Object[] params = null;

		// breakfast
		query.setLength(0);
		query.append("SELECT ");
		query.append("MEAL_SEQ, BRANCH_SEQ, MEAL_DATE, ");
		query.append("PORRIDGE_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?, PORRIDGE_MENU_SEQ) as 'PORRIDEG_MENU', ");
		query.append("BREAD_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?, BREAD_MENU_SEQ) as 'BREAD_MENU', ");
		query.append("RICE_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?, RICE_MENU_SEQ) as 'RICE_MENU', ");
		query.append("SOUP_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SOUP_MENU_SEQ) as 'SOUP_MENU', ");
		query.append("SPICY_MAINDISH_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SPICY_MAINDISH_MENU_SEQ) as 'SPICY_MAINDISH_MENU', ");
		query.append("MAINDISH_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  MAINDISH_MENU_SEQ) as 'MAINDISH_MENU', ");
		query.append("SIDEDISH_1_MENU_SEQ AS sidedish1menuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SIDEDISH_1_MENU_SEQ) as 'sidedish1menu', ");
		query.append("SIDEDISH_2_MENU_SEQ AS sidedish2menuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SIDEDISH_2_MENU_SEQ) as 'sidedish2menu', ");
		query.append("SIDEDISH_3_MENU_SEQ AS sidedish3menuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SIDEDISH_3_MENU_SEQ) as 'sidedish3menu', ");
		query.append("ETC_1_MENU_SEQ as etc1MenuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  ETC_1_MENU_SEQ) as 'etc1Menu', ");
		query.append("ETC_2_MENU_SEQ as etc2MenuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  ETC_2_MENU_SEQ) as 'etc2Menu', ");
		query.append("ETC_3_MENU_SEQ as etc2MenuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  ETC_3_MENU_SEQ) as 'etc2Menu' ");
		query.append("FROM pia_meals M LEFT JOIN pia_meal_breakfasts B ON M.LUNCH_SEQ = B.BREAKFAST_SEQ ");
		query.append("WHERE M.IS_DELETED IS FALSE ");
		query.append("  AND M.BRANCH_SEQ = ? ");
		query.append("  AND DATE_FORMAT(M.MEAL_DATE, '%Y/%m/%d') = DATE_FORMAT(NOW(), '%Y/%m/%d') ");
		query.append("ORDER BY M.REGISTER_DATE DESC LIMIT 1 ");

		idx = 0;
		params = new Object[13];
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = branchSeq;

		TodayBreakfastSchedule breakfastSchedule = null;
		try {
			breakfastSchedule = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<TodayBreakfastSchedule>(TodayBreakfastSchedule.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			breakfastSchedule = new TodayBreakfastSchedule();
		}

		// lunch
		query.setLength(0);
		query.append("SELECT ");
		query.append("MEAL_SEQ, BRANCH_SEQ, MEAL_DATE, ");
		query.append("RICE_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?, RICE_MENU_SEQ) as 'RICE_MENU', ");
		query.append("SOUP_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SOUP_MENU_SEQ) as 'SOUP_MENU', ");
		query.append("SPICY_MAINDISH_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SPICY_MAINDISH_MENU_SEQ) as 'SPICY_MAINDISH_MENU', ");
		query.append("MAINDISH_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  MAINDISH_MENU_SEQ) as 'MAINDISH_MENU', ");
		query.append("SIDEDISH_1_MENU_SEQ AS sidedish1menuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SIDEDISH_1_MENU_SEQ) as 'sidedish1menu', ");
		query.append("SIDEDISH_2_MENU_SEQ AS sidedish2menuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SIDEDISH_2_MENU_SEQ) as 'sidedish2menu', ");
		query.append("SIDEDISH_3_MENU_SEQ AS sidedish3menuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SIDEDISH_3_MENU_SEQ) as 'sidedish3menu', ");
		query.append("ETC_1_MENU_SEQ as etc1MenuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  ETC_1_MENU_SEQ) as 'etc1Menu', ");
		query.append("ETC_2_MENU_SEQ as etc2MenuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  ETC_2_MENU_SEQ) as 'etc2Menu', ");
		query.append("ETC_3_MENU_SEQ as etc2MenuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  ETC_3_MENU_SEQ) as 'etc2Menu' ");
		query.append("FROM pia_meals M LEFT JOIN pia_meal_lunches L ON M.LUNCH_SEQ = L.LUNCH_SEQ ");
		query.append("WHERE M.IS_DELETED IS FALSE ");
		query.append("  AND M.BRANCH_SEQ = ? ");
		query.append("  AND DATE_FORMAT(M.MEAL_DATE, '%Y/%m/%d') = DATE_FORMAT(NOW(), '%Y/%m/%d') ");
		query.append("ORDER BY M.REGISTER_DATE DESC LIMIT 1 ");

		idx = 0;
		params = new Object[11];
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = branchSeq;

		TodayLunchSchedule lunchSchedule = null;
		try {
			lunchSchedule = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<TodayLunchSchedule>(TodayLunchSchedule.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			lunchSchedule = new TodayLunchSchedule();
		}

		// dinner
		query.setLength(0);
		query.append("SELECT ");
		query.append("MEAL_SEQ, BRANCH_SEQ, MEAL_DATE, ");
		query.append("RICE_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?, RICE_MENU_SEQ) as 'RICE_MENU', ");
		query.append("SOUP_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SOUP_MENU_SEQ) as 'SOUP_MENU', ");
		query.append("SPICY_MAINDISH_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SPICY_MAINDISH_MENU_SEQ) as 'SPICY_MAINDISH_MENU', ");
		query.append("MAINDISH_MENU_SEQ, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  MAINDISH_MENU_SEQ) as 'MAINDISH_MENU', ");
		query.append("SIDEDISH_1_MENU_SEQ AS sidedish1menuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SIDEDISH_1_MENU_SEQ) as 'sidedish1menu', ");
		query.append("SIDEDISH_2_MENU_SEQ AS sidedish2menuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SIDEDISH_2_MENU_SEQ) as 'sidedish2menu', ");
		query.append("SIDEDISH_3_MENU_SEQ AS sidedish3menuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  SIDEDISH_3_MENU_SEQ) as 'sidedish3menu', ");
		query.append("ETC_1_MENU_SEQ as etc1MenuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  ETC_1_MENU_SEQ) as 'etc1Menu', ");
		query.append("ETC_2_MENU_SEQ as etc2MenuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  ETC_2_MENU_SEQ) as 'etc2Menu', ");
		query.append("ETC_3_MENU_SEQ as etc2MenuSeq, ");
		query.append("GET_MEALMENU_NAME(M.BRANCH_SEQ, ?,  ETC_3_MENU_SEQ) as 'etc2Menu' ");
		query.append("FROM pia_meals M LEFT JOIN pia_meal_dinners D ON M.DINNER_SEQ = D.DINNER_SEQ ");
		query.append("WHERE M.IS_DELETED IS FALSE ");
		query.append("  AND M.BRANCH_SEQ = ? ");
		query.append("  AND DATE_FORMAT(M.MEAL_DATE, '%Y/%m/%d') = DATE_FORMAT(NOW(), '%Y/%m/%d') ");
		query.append("ORDER BY M.REGISTER_DATE DESC LIMIT 1 ");

		idx = 0;
		params = new Object[11];
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = languageSeq;
		params[idx++] = branchSeq;

		TodayDinnerSchedule dinnerSchedule = null;
		try {
			dinnerSchedule = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<TodayDinnerSchedule>(TodayDinnerSchedule.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			dinnerSchedule = new TodayDinnerSchedule();
		}

		// total schedule
		query.setLength(0);
		query.append("SELECT *, ");
		query.append("DATE_FORMAT(M.MEAL_DATE, '%Y/%m/%d') AS 'FORM_MEAL_DATE', ");
		query.append("DATE_FORMAT(M.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE' ");
		query.append("FROM pia_meals M ");
		query.append("WHERE M.IS_DELETED IS FALSE ");
		query.append("  AND M.BRANCH_SEQ = ? ");
		query.append("  AND DATE_FORMAT(M.MEAL_DATE, '%Y/%m/%d') = DATE_FORMAT(NOW(), '%Y/%m/%d') ");
		query.append("ORDER BY M.REGISTER_DATE DESC LIMIT 1 ");

		idx = 0;
		params = new Object[1];
		params[idx++] = branchSeq;

		TodayMealSchedule result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<TodayMealSchedule>(TodayMealSchedule.class));
			result.setBreakfastSchedule(breakfastSchedule);
			result.setLunchSchedule(lunchSchedule);
			result.setDinnerSchedule(dinnerSchedule);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new TodayMealSchedule();
		}
		return result;
	}

	public MealSchedule getMealSchedule(int branchSeq, int mealSeq) {
		StringBuffer query = new StringBuffer();
		int idx = 0;
		Object[] params = null;

		// breakfast
		query.setLength(0);
		query.append("SELECT * ");
		query.append("FROM pia_meal_breakfasts_vt ");
		query.append("WHERE BRANCH_SEQ = ? ");
		query.append("  AND MEAL_SEQ = ? ");

		idx = 0;
		params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = mealSeq;

		BreakfastSchedule breakfastSchedule = null;
		try {
			breakfastSchedule = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<BreakfastSchedule>(BreakfastSchedule.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			breakfastSchedule = new BreakfastSchedule();
		}

		// lunch
		query.setLength(0);
		query.append("SELECT * ");
		query.append("FROM pia_meal_lunches_vt ");
		query.append("WHERE BRANCH_SEQ = ? ");
		query.append("  AND MEAL_SEQ = ? ");

		idx = 0;
		params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = mealSeq;

		LunchSchedule lunchSchedule = null;
		try {
			lunchSchedule = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<LunchSchedule>(LunchSchedule.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			lunchSchedule = new LunchSchedule();
		}

		// dinner
		query.setLength(0);
		query.append("SELECT * ");
		query.append("FROM pia_meal_dinners_vt ");
		query.append("WHERE BRANCH_SEQ = ? ");
		query.append("  AND MEAL_SEQ = ? ");

		idx = 0;
		params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = mealSeq;

		DinnerSchedule dinnerSchedule = null;
		try {
			dinnerSchedule = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<DinnerSchedule>(DinnerSchedule.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			dinnerSchedule = new DinnerSchedule();
		}

		// total schedule
		query.setLength(0);
		query.append("SELECT M.*, ");
		query.append("GET_WRITER_NAME_WITH_TITLE(M.WRITER_ID) AS 'WRITER', ");
		query.append("DATE_FORMAT(M.MEAL_DATE, '%Y/%m/%d') AS 'FORM_MEAL_DATE', ");
		query.append("DATE_FORMAT(M.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE' ");
		query.append("FROM pia_meals M ");
		query.append("WHERE M.IS_DELETED IS FALSE ");
		query.append("  AND M.BRANCH_SEQ = ? ");
		query.append("  AND M.MEAL_SEQ = ? ");
		idx = 0;
		params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = mealSeq;

		MealSchedule result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<MealSchedule>(MealSchedule.class));
			result.setBreakfastSchedule(breakfastSchedule);
			result.setLunchSchedule(lunchSchedule);
			result.setDinnerSchedule(dinnerSchedule);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new MealSchedule();
		}
		return result;
	}

	public List<MealsEvaluations> getMeals(int branchSeq, int startIndex, int offset) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT M.*, ");
		query.append("  GET_WRITER_NAME_WITH_TITLE(M.WRITER_ID) AS 'WRITER', ");
		query.append("  DATE_FORMAT(M.MEAL_DATE, '%Y/%m/%d') AS 'FORM_MEAL_DATE', ");
		query.append("  DATE_FORMAT(M.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("  ((SELECT COUNT(*) FROM pia_meal_breakfast_evaluations B WHERE IS_DELETED IS FALSE AND B.BREAKFAST_SEQ = M.BREAKFAST_SEQ AND EVALUATION_LEVEL = 'G' ) + ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_lunch_evaluations L WHERE IS_DELETED IS FALSE AND L.LUNCH_SEQ = M.LUNCH_SEQ AND EVALUATION_LEVEL = 'G' ) + ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_dinner_evaluations D WHERE IS_DELETED IS FALSE AND D.DINNER_SEQ = M.DINNER_SEQ AND EVALUATION_LEVEL = 'G' ) ) AS 'GOOD_COUNT', ");

		query.append("  ((SELECT COUNT(*) FROM pia_meal_breakfast_evaluations B WHERE IS_DELETED IS FALSE AND B.BREAKFAST_SEQ = M.BREAKFAST_SEQ AND EVALUATION_LEVEL = 'F' ) + ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_lunch_evaluations L WHERE IS_DELETED IS FALSE AND L.LUNCH_SEQ = M.LUNCH_SEQ AND EVALUATION_LEVEL = 'F' ) + ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_dinner_evaluations D WHERE IS_DELETED IS FALSE AND D.DINNER_SEQ = M.DINNER_SEQ AND EVALUATION_LEVEL = 'F' ) ) AS 'FINE_COUNT', ");

		query.append("  ((SELECT COUNT(*) FROM pia_meal_breakfast_evaluations B WHERE IS_DELETED IS FALSE AND B.BREAKFAST_SEQ = M.BREAKFAST_SEQ AND EVALUATION_LEVEL = 'N' ) + ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_lunch_evaluations L WHERE IS_DELETED IS FALSE AND L.LUNCH_SEQ = M.LUNCH_SEQ AND EVALUATION_LEVEL = 'N' ) + ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_dinner_evaluations D WHERE IS_DELETED IS FALSE AND D.DINNER_SEQ = M.DINNER_SEQ AND EVALUATION_LEVEL = 'N' )) AS 'NOGOOD_COUNT', ");

		query.append("  ((SELECT COUNT(*) FROM pia_meal_breakfast_evaluations B WHERE IS_DELETED IS FALSE AND B.BREAKFAST_SEQ = M.BREAKFAST_SEQ ) + ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_lunch_evaluations L WHERE IS_DELETED IS FALSE AND L.LUNCH_SEQ = M.LUNCH_SEQ ) + ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_dinner_evaluations D WHERE IS_DELETED IS FALSE AND D.DINNER_SEQ = M.DINNER_SEQ )) AS 'EVALUATION_TOTAL', ");

		query.append("  ((SELECT COUNT(*) FROM pia_meal_breakfast_evaluations B WHERE IS_DELETED IS FALSE AND B.BREAKFAST_SEQ = M.BREAKFAST_SEQ AND EVALUATION_DETAIL IS NOT NULL AND EVALUATION_DETAIL <> '') + ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_lunch_evaluations L WHERE IS_DELETED IS FALSE AND L.LUNCH_SEQ = M.LUNCH_SEQ AND EVALUATION_DETAIL IS NOT NULL AND EVALUATION_DETAIL <> '') + ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_dinner_evaluations D WHERE IS_DELETED IS FALSE AND D.DINNER_SEQ = M.DINNER_SEQ AND EVALUATION_DETAIL IS NOT NULL AND EVALUATION_DETAIL <> '') ) AS 'DETAILS_COUNT' ");

		query.append(" FROM pia_meals M ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append("ORDER BY M.MEAL_DATE DESC ");
		query.append("LIMIT ?, ? ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = branchSeq;
		params[idx++] = startIndex;
		params[idx++] = offset;

		List<MealsEvaluations> results = null;
		Integer totalCount = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<MealsEvaluations>(MealsEvaluations.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM pia_meals ");
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
			results = new ArrayList<MealsEvaluations>();
		}
		return results;
	}

	public MealEvaluation getEvaluation(int branchSeq, int mealSeq, int languageSeq) {
		StringBuffer query = new StringBuffer();
		int idx = 0;
		Object[] params = null;

		query.setLength(0);
		query.append("SELECT ");
		query.append("  M.*, ");
		query.append("  GET_WRITER_NAME_WITH_TITLE(M.WRITER_ID) AS 'WRITER', ");
		query.append("  DATE_FORMAT(M.MEAL_DATE, '%Y/%m/%d') AS 'FORM_MEAL_DATE', ");
		query.append("  DATE_FORMAT(M.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_breakfast_evaluations B WHERE IS_DELETED IS FALSE AND B.BREAKFAST_SEQ = M.BREAKFAST_SEQ AND EVALUATION_LEVEL = 'G' ) AS 'BREAKFAST_GOOD_COUNT', ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_breakfast_evaluations B WHERE IS_DELETED IS FALSE AND B.BREAKFAST_SEQ = M.BREAKFAST_SEQ AND EVALUATION_LEVEL = 'F' ) AS 'BREAKFAST_FINE_COUNT', ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_breakfast_evaluations B WHERE IS_DELETED IS FALSE AND B.BREAKFAST_SEQ = M.BREAKFAST_SEQ AND EVALUATION_LEVEL = 'N' ) AS 'BREAKFAST_NOGOOD_COUNT', ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_breakfast_evaluations B WHERE IS_DELETED IS FALSE AND B.BREAKFAST_SEQ = M.BREAKFAST_SEQ ) AS 'BREAKFAST_TOTAL_COUNT', ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_lunch_evaluations L WHERE IS_DELETED IS FALSE AND L.LUNCH_SEQ = M.LUNCH_SEQ AND EVALUATION_LEVEL = 'G' ) AS 'LUNCH_GOOD_COUNT', ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_lunch_evaluations L WHERE IS_DELETED IS FALSE AND L.LUNCH_SEQ = M.LUNCH_SEQ AND EVALUATION_LEVEL = 'F' ) AS 'LUNCH_FINE_COUNT', ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_lunch_evaluations L WHERE IS_DELETED IS FALSE AND L.LUNCH_SEQ = M.LUNCH_SEQ AND EVALUATION_LEVEL = 'N' ) AS 'LUNCH_NOGOOD_COUNT', ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_lunch_evaluations L WHERE IS_DELETED IS FALSE AND L.LUNCH_SEQ = M.LUNCH_SEQ ) AS 'LUNCH_TOTAL_COUNT', ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_dinner_evaluations D WHERE IS_DELETED IS FALSE AND D.DINNER_SEQ = M.DINNER_SEQ AND EVALUATION_LEVEL = 'G' ) AS 'DINNER_GOOD_COUNT', ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_dinner_evaluations D WHERE IS_DELETED IS FALSE AND D.DINNER_SEQ = M.DINNER_SEQ AND EVALUATION_LEVEL = 'F' ) AS 'DINNER_FINE_COUNT', ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_dinner_evaluations D WHERE IS_DELETED IS FALSE AND D.DINNER_SEQ = M.DINNER_SEQ AND EVALUATION_LEVEL = 'N' ) AS 'DINNER_NOGOOD_COUNT', ");
		query.append("  (SELECT COUNT(*) FROM pia_meal_dinner_evaluations D WHERE IS_DELETED IS FALSE AND D.DINNER_SEQ = M.DINNER_SEQ ) AS 'DINNER_TOTAL_COUNT'");
		query.append(" FROM pia_meals M ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append("  AND MEAL_SEQ = ? ");

		idx = 0;
		params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = mealSeq;

		MealEvaluation result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<MealEvaluation>(MealEvaluation.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new MealEvaluation();
		}

		query.setLength(0);
		query.append("SELECT B.*, S.*, ");
		query.append("DATE_FORMAT(B.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(S.DATE_OF_BIRTH, '%Y/%m/%d') AS 'FORM_DATE_OF_BIRTH' ");
		query.append("FROM pia_meal_breakfast_evaluations B, pia_students S ");
		query.append("WHERE B.WRITER_ID = S.STUDENT_ID ");
		query.append("AND B.EVALUATION_DETAIL IS NOT NULL ");
		query.append("AND B.EVALUATION_DETAIL <> '' ");
		query.append("AND B.IS_DELETED IS FALSE ");
		query.append("AND S.IS_DELETED IS FALSE ");
		query.append("AND B.BREAKFAST_SEQ = (SELECT BREAKFAST_SEQ FROM pia_meals WHERE MEAL_SEQ = ?) ");

		idx = 0;
		params = new Object[1];
		params[idx++] = mealSeq;

		List<BreakfastEvaluationDetail> breakfastEvaluations = null;
		try {
			breakfastEvaluations = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<BreakfastEvaluationDetail>(BreakfastEvaluationDetail.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			breakfastEvaluations = new ArrayList<BreakfastEvaluationDetail>();
		}

		query.setLength(0);
		query.append("SELECT L.*, S.*, ");
		query.append("DATE_FORMAT(L.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(S.DATE_OF_BIRTH, '%Y/%m/%d') AS 'FORM_DATE_OF_BIRTH' ");
		query.append("FROM pia_meal_lunch_evaluations L, pia_students S ");
		query.append("WHERE L.IS_DELETED IS FALSE ");
		query.append("AND L.EVALUATION_DETAIL IS NOT NULL ");
		query.append("AND L.EVALUATION_DETAIL <> '' ");
		query.append("AND S.IS_DELETED IS FALSE ");
		query.append("AND L.WRITER_ID = S.STUDENT_ID ");
		query.append("AND L.LUNCH_SEQ = (SELECT LUNCH_SEQ FROM pia_meals WHERE MEAL_SEQ = ?) ");

		idx = 0;
		params = new Object[1];
		params[idx++] = mealSeq;

		List<LunchEvaluationDetail> lunchEvaluations = null;
		try {
			lunchEvaluations = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<LunchEvaluationDetail>(LunchEvaluationDetail.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			lunchEvaluations = new ArrayList<LunchEvaluationDetail>();
		}

		query.setLength(0);
		query.append("SELECT D.*, S.*, ");
		query.append("DATE_FORMAT(D.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(S.DATE_OF_BIRTH, '%Y/%m/%d') AS 'FORM_DATE_OF_BIRTH' ");
		query.append("FROM pia_meal_dinner_evaluations D, pia_students S ");
		query.append("WHERE D.IS_DELETED IS FALSE ");
		query.append("AND D.EVALUATION_DETAIL IS NOT NULL ");
		query.append("AND D.EVALUATION_DETAIL <> '' ");
		query.append("AND S.IS_DELETED IS FALSE ");
		query.append("AND D.WRITER_ID = S.STUDENT_ID ");
		query.append("AND D.DINNER_SEQ = (SELECT DINNER_SEQ FROM pia_meals WHERE MEAL_SEQ = ?) ");

		idx = 0;
		params = new Object[1];
		params[idx++] = mealSeq;

		List<DinnerEvaluationDetail> dinnerEvaluations = null;
		try {
			dinnerEvaluations = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<DinnerEvaluationDetail>(DinnerEvaluationDetail.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			dinnerEvaluations = new ArrayList<DinnerEvaluationDetail>();
		}

		result.setBreakfastEvaluationDetails(breakfastEvaluations);
		result.setLunchEvaluationDetails(lunchEvaluations);
		result.setDinnerEvaluationDetails(dinnerEvaluations);

		MealSchedule mealSchedule = getMealSchedule(branchSeq, mealSeq);
		result.setBreakfastSchedule(mealSchedule.getBreakfastSchedule());
		result.setLunchSchedule(mealSchedule.getLunchSchedule());
		result.setDinnerSchedule(mealSchedule.getDinnerSchedule());
		return result;
	}

	public boolean addMealSchedule(MealSchedule mealSchedule) {
		boolean isSuccessed = false;
		StringBuffer query = new StringBuffer();
		int idx = 0;
		Object[] params = null;
		int breakfastSeq = 0;
		int lunchSeq = 0;
		int dinnerSeq = 0;

		// INSERT pia_meal_breakfasts
		query.setLength(0);
		query.append("INSERT INTO pia_meal_breakfasts ( ");
		query.append(" PORRIDGE_MENU_SEQ, BREAD_MENU_SEQ, ");
		query.append(" RICE_MENU_SEQ, SOUP_MENU_SEQ, SPICY_MAINDISH_MENU_SEQ, MAINDISH_MENU_SEQ, ");
		query.append(" SIDEDISH_1_MENU_SEQ, SIDEDISH_2_MENU_SEQ, SIDEDISH_3_MENU_SEQ, ");
		query.append(" ETC_1_MENU_SEQ, ETC_2_MENU_SEQ, ETC_3_MENU_SEQ ");
		query.append(") ");
		query.append("VALUES ");
		query.append("( ");
		query.append(" ?, ?, ");
		query.append(" ?, ?, ?, ?, ");
		query.append(" ?, ?, ?, ");
		query.append(" ?, ?, ? ");
		query.append(") ");

		idx = 0;
		params = new Object[12];
		params[idx++] = mealSchedule.getBreakfastSchedule().getPorridgeMenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getBreadMenuSeq();

		params[idx++] = mealSchedule.getBreakfastSchedule().getRiceMenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getSoupMenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getSpicyMaindishMenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getMaindishMenuSeq();

		params[idx++] = mealSchedule.getBreakfastSchedule().getSidedish1MenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getSidedish2MenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getSidedish3MenuSeq();

		params[idx++] = mealSchedule.getBreakfastSchedule().getEtc1MenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getEtc2MenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getEtc3MenuSeq();

		isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;

		query.setLength(0);
		query.append("SELECT LAST_INSERT_ID()");
		Integer breakfastIntegerSeq = jdbcTemplate.queryForObject(query.toString(), Integer.class);
		breakfastSeq = Tools.getInt(breakfastIntegerSeq);

		// INSERT pia_meal_lunches
		query.setLength(0);
		query.append("INSERT INTO pia_meal_lunches ( ");
		query.append(" RICE_MENU_SEQ, SOUP_MENU_SEQ, SPICY_MAINDISH_MENU_SEQ, MAINDISH_MENU_SEQ, ");
		query.append(" SIDEDISH_1_MENU_SEQ, SIDEDISH_2_MENU_SEQ, SIDEDISH_3_MENU_SEQ, ");
		query.append(" ETC_1_MENU_SEQ, ETC_2_MENU_SEQ, ETC_3_MENU_SEQ ");
		query.append(") ");
		query.append("VALUES ");
		query.append("( ");
		query.append(" ?, ?, ?, ?, ");
		query.append(" ?, ?, ?, ");
		query.append(" ?, ?, ? ");
		query.append(") ");

		idx = 0;
		params = new Object[10];
		params[idx++] = mealSchedule.getLunchSchedule().getRiceMenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getSoupMenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getSpicyMaindishMenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getMaindishMenuSeq();

		params[idx++] = mealSchedule.getLunchSchedule().getSidedish1MenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getSidedish2MenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getSidedish3MenuSeq();

		params[idx++] = mealSchedule.getLunchSchedule().getEtc1MenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getEtc2MenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getEtc3MenuSeq();

		isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;

		query.setLength(0);
		query.append("SELECT LAST_INSERT_ID()");
		Integer lunchIntegerSeq = jdbcTemplate.queryForObject(query.toString(), Integer.class);

		lunchSeq = Tools.getInt(lunchIntegerSeq);

		// INSERT pia_meal_dinners
		query.setLength(0);
		query.append("INSERT INTO pia_meal_dinners ( ");
		query.append(" RICE_MENU_SEQ, SOUP_MENU_SEQ, SPICY_MAINDISH_MENU_SEQ, MAINDISH_MENU_SEQ, ");
		query.append(" SIDEDISH_1_MENU_SEQ, SIDEDISH_2_MENU_SEQ, SIDEDISH_3_MENU_SEQ, ");
		query.append(" ETC_1_MENU_SEQ, ETC_2_MENU_SEQ, ETC_3_MENU_SEQ ");
		query.append(") ");
		query.append("VALUES ");
		query.append("( ");
		query.append(" ?, ?, ?, ?, ");
		query.append(" ?, ?, ?, ");
		query.append(" ?, ?, ? ");
		query.append(") ");

		idx = 0;
		params = new Object[10];
		params[idx++] = mealSchedule.getDinnerSchedule().getRiceMenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getSoupMenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getSpicyMaindishMenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getMaindishMenuSeq();

		params[idx++] = mealSchedule.getDinnerSchedule().getSidedish1MenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getSidedish2MenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getSidedish3MenuSeq();

		params[idx++] = mealSchedule.getDinnerSchedule().getEtc1MenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getEtc2MenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getEtc3MenuSeq();

		isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;

		query.setLength(0);
		query.append("SELECT LAST_INSERT_ID()");
		Integer dinnerIntegerSeq = jdbcTemplate.queryForObject(query.toString(), Integer.class);
		dinnerSeq = Tools.getInt(dinnerIntegerSeq);

		// INSERT pia_meals
		query.setLength(0);
		query.append("INSERT INTO pia_meals ( ");
		query.append("BRANCH_SEQ, MEAL_DATE, BREAKFAST_SEQ, LUNCH_SEQ, DINNER_SEQ, WRITER_ID, ");
		query.append("REGISTER_DATE, IS_DELETED ");
		query.append(") ");
		query.append("VALUES ");
		query.append("( ");
		query.append("?, STR_TO_DATE(?, '%Y/%m/%d'), ?, ?, ?, ?, ");
		query.append("NOW(), 0 ");
		query.append(") ");

		idx = 0;
		params = new Object[6];
		params[idx++] = mealSchedule.getBranchSeq();
		params[idx++] = mealSchedule.getMealDate();
		params[idx++] = breakfastSeq;
		params[idx++] = lunchSeq;
		params[idx++] = dinnerSeq;
		params[idx++] = mealSchedule.getWriterId();

		isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;

		return isSuccessed;
	}

	public boolean evaluateMeal(MealEvaluation mealEvaluation) {
		StringBuffer query = new StringBuffer();
		if (mealEvaluation.isBreakfastEvaluation()) {
			query.append("INSERT INTO pia_meal_breakfast_evaluations ( ");
			query.append("BREAKFAST_SEQ, ");
		} else if (mealEvaluation.isLunchEvaluation()) {
			query.append("INSERT INTO pia_meal_lunch_evaluations ( ");
			query.append("LUNCH_SEQ, ");
		} else if (mealEvaluation.isDinnerEvaluation()) {
			query.append("INSERT INTO pia_meal_dinner_evaluations ( ");
			query.append("DINNER_SEQ, ");
		}

		query.append("EVALUATION_LEVEL, EVALUATION_DETAIL, IS_SPICY_MENU, WRITER_ID, ");
		query.append("REGISTER_DATE, IS_DELETED ");
		query.append(") ");
		query.append("VALUES ");
		query.append("( ");
		query.append("?, ?, ?, ?, ?, ");
		query.append("NOW(), 0 ");
		query.append(") ");

		int idx = 0;
		Object[] params = new Object[5];
		if (mealEvaluation.isBreakfastEvaluation()) {
			params[idx++] = mealEvaluation.getBreakfastSeq();
		} else if (mealEvaluation.isLunchEvaluation()) {
			params[idx++] = mealEvaluation.getLunchSeq();
		} else if (mealEvaluation.isDinnerEvaluation()) {
			params[idx++] = mealEvaluation.getDinnerSeq();
		}

		params[idx++] = mealEvaluation.getSatisfaction();
		params[idx++] = mealEvaluation.getDetail();
		params[idx++] = mealEvaluation.isSpicy();
		params[idx++] = mealEvaluation.getWriterId();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean changeMealSchedule(MealSchedule mealSchedule) {
		boolean isSuccessed = false;
		StringBuffer query = new StringBuffer();
		int idx = 0;
		Object[] params = null;

		// update pia_meal_breakfasts
		query.setLength(0);
		query.append("UPDATE pia_meal_breakfasts ");
		query.append("SET ");
		query.append(" PORRIDGE_MENU_SEQ = ?, ");
		query.append(" BREAD_MENU_SEQ = ?, ");
		query.append(" RICE_MENU_SEQ = ?, ");
		query.append(" SOUP_MENU_SEQ = ?, ");
		query.append(" SPICY_MAINDISH_MENU_SEQ = ?, ");
		query.append(" MAINDISH_MENU_SEQ = ?, ");
		query.append(" SIDEDISH_1_MENU_SEQ = ?, ");
		query.append(" SIDEDISH_2_MENU_SEQ = ?, ");
		query.append(" SIDEDISH_3_MENU_SEQ = ?, ");
		query.append(" ETC_1_MENU_SEQ = ?, ");
		query.append(" ETC_2_MENU_SEQ = ?, ");
		query.append(" ETC_3_MENU_SEQ = ? ");
		query.append(" ");
		query.append("WHERE BREAKFAST_SEQ = (SELECT BREAKFAST_SEQ FROM pia_meals WHERE MEAL_SEQ = ?) ");

		idx = 0;
		params = new Object[13];
		params[idx++] = mealSchedule.getBreakfastSchedule().getPorridgeMenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getBreadMenuSeq();

		params[idx++] = mealSchedule.getBreakfastSchedule().getRiceMenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getSoupMenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getSpicyMaindishMenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getMaindishMenuSeq();

		params[idx++] = mealSchedule.getBreakfastSchedule().getSidedish1MenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getSidedish2MenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getSidedish3MenuSeq();

		params[idx++] = mealSchedule.getBreakfastSchedule().getEtc1MenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getEtc2MenuSeq();
		params[idx++] = mealSchedule.getBreakfastSchedule().getEtc3MenuSeq();

		params[idx++] = mealSchedule.getMealSeq();

		isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;

		// update pia_meal_lunches
		query.setLength(0);
		query.append("UPDATE pia_meal_lunches ");
		query.append("SET ");
		query.append(" RICE_MENU_SEQ = ?, ");
		query.append(" SOUP_MENU_SEQ = ?, ");
		query.append(" SPICY_MAINDISH_MENU_SEQ = ?, ");
		query.append(" MAINDISH_MENU_SEQ = ?, ");
		query.append(" SIDEDISH_1_MENU_SEQ = ?, ");
		query.append(" SIDEDISH_2_MENU_SEQ = ?, ");
		query.append(" SIDEDISH_3_MENU_SEQ = ?, ");
		query.append(" ETC_1_MENU_SEQ = ?, ");
		query.append(" ETC_2_MENU_SEQ = ?, ");
		query.append(" ETC_3_MENU_SEQ = ? ");
		query.append(" ");
		query.append("WHERE LUNCH_SEQ = (SELECT LUNCH_SEQ FROM pia_meals WHERE MEAL_SEQ = ?) ");

		idx = 0;
		params = new Object[11];
		params[idx++] = mealSchedule.getLunchSchedule().getRiceMenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getSoupMenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getSpicyMaindishMenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getMaindishMenuSeq();

		params[idx++] = mealSchedule.getLunchSchedule().getSidedish1MenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getSidedish2MenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getSidedish3MenuSeq();

		params[idx++] = mealSchedule.getLunchSchedule().getEtc1MenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getEtc2MenuSeq();
		params[idx++] = mealSchedule.getLunchSchedule().getEtc3MenuSeq();

		params[idx++] = mealSchedule.getMealSeq();

		isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;

		// update pia_meal_dinners
		query.setLength(0);
		query.append("UPDATE pia_meal_dinners ");
		query.append("SET ");
		query.append(" RICE_MENU_SEQ = ?, ");
		query.append(" SOUP_MENU_SEQ = ?, ");
		query.append(" SPICY_MAINDISH_MENU_SEQ = ?, ");
		query.append(" MAINDISH_MENU_SEQ = ?, ");
		query.append(" SIDEDISH_1_MENU_SEQ = ?, ");
		query.append(" SIDEDISH_2_MENU_SEQ = ?, ");
		query.append(" SIDEDISH_3_MENU_SEQ = ?, ");
		query.append(" ETC_1_MENU_SEQ = ?, ");
		query.append(" ETC_2_MENU_SEQ = ?, ");
		query.append(" ETC_3_MENU_SEQ = ? ");
		query.append(" ");
		query.append("WHERE DINNER_SEQ = (SELECT DINNER_SEQ FROM pia_meals WHERE MEAL_SEQ = ?) ");

		idx = 0;
		params = new Object[11];
		params[idx++] = mealSchedule.getDinnerSchedule().getRiceMenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getSoupMenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getSpicyMaindishMenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getMaindishMenuSeq();

		params[idx++] = mealSchedule.getDinnerSchedule().getSidedish1MenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getSidedish2MenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getSidedish3MenuSeq();

		params[idx++] = mealSchedule.getDinnerSchedule().getEtc1MenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getEtc2MenuSeq();
		params[idx++] = mealSchedule.getDinnerSchedule().getEtc3MenuSeq();

		params[idx++] = mealSchedule.getMealSeq();

		isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;

		return isSuccessed;
	}

	public boolean removeMealSchedule(int branchSeq, int mealSeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_meals ");
		query.append("   SET ");
		query.append(" IS_DELETED = 1 ");
		query.append(" WHERE BRANCH_SEQ = ? ");
		query.append("   AND MEAL_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = mealSeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

}
