package com.pines.student.meal.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.MealMenu;

@Repository
public class MealMenuDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<MealMenu> getMenus(int branchSeq, int startIndex, int offset) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT M.*, ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = M.BRANCH_SEQ) as 'BRANCH', ");
		query.append("DATE_FORMAT(M.REGISTER_DATE, '%Y/%m/%d %r') AS 'FORM_REGISTER_DATE' ");
		query.append("FROM pia_meal_menus M ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append(" ORDER BY REGISTER_DATE DESC, IS_SPICY, IS_USED ");
		query.append(" LIMIT ?, ? ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = branchSeq;
		params[idx++] = startIndex;
		params[idx++] = offset;

		List<MealMenu> results = null;
		Integer totalCount = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<MealMenu>(MealMenu.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM pia_meal_menus ");
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
			results = new ArrayList<MealMenu>();
		}

		return results;
	}

	public List<MealMenu> getMenus(int branchSeq, String menuType) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT M.*, ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = M.BRANCH_SEQ) as 'BRANCH', ");
		query.append("DATE_FORMAT(M.REGISTER_DATE, '%Y/%m/%d %r') AS 'FORM_REGISTER_DATE' ");
		query.append("FROM pia_meal_menus M ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND IS_USED IS TRUE ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append("  AND MENU_TYPE = ? ");
		query.append(" ORDER BY REGISTER_DATE DESC, IS_SPICY");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = menuType;

		List<MealMenu> results = null;
		Integer totalCount = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<MealMenu>(MealMenu.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM pia_meal_menus ");
			query.append("WHERE IS_DELETED IS FALSE ");
			query.append("  AND BRANCH_SEQ = ? ");
			query.append("  AND MENU_TYPE = ? ");

			idx = 0;
			params = new Object[2];
			params[idx++] = branchSeq;
			params[idx++] = menuType;

			totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<MealMenu>();
		}

		return results;
	}

	public boolean addMealMenu(MealMenu mealMenu) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_meal_menus ( ");
		query.append("BRANCH_SEQ, IS_SPICY, MENU_TYPE, MENU_KOR_NAME, MENU_ENG_NAME, IS_USED, REGISTER_DATE, IS_DELETED ");
		query.append(") ");
		query.append("VALUES ");
		query.append("( ");
		query.append("?, ?, ?, ?, ?, ?, NOW(), 0 ");
		query.append(") ");

		int idx = 0;
		Object[] params = new Object[6];
		params[idx++] = mealMenu.getBranchSeq();
		params[idx++] = mealMenu.getIsSpicy();
		params[idx++] = mealMenu.getMenuType();
		params[idx++] = mealMenu.getMenuKorName();
		params[idx++] = mealMenu.getMenuEngName();
		params[idx++] = mealMenu.getIsUsed();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean changeMealMenu(MealMenu mealMenu) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_meal_menus SET ");
		query.append("MENU_KOR_NAME = ?, MENU_ENG_NAME = ?, IS_USED = ?, IS_SPICY = ? ");
		query.append("WHERE BRANCH_SEQ = ? ");
		query.append("AND MENU_TYPE = ? ");
		query.append("AND MEAL_MENU_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[7];
		params[idx++] = mealMenu.getMenuKorName();
		params[idx++] = mealMenu.getMenuEngName();
		params[idx++] = mealMenu.getIsUsed();
		params[idx++] = mealMenu.getIsSpicy();
		params[idx++] = mealMenu.getBranchSeq();
		params[idx++] = mealMenu.getMenuType();
		params[idx++] = mealMenu.getMealMenuSeq();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean removeMealMenu(int branchSeq, int menuSeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_meal_menus SET ");
		query.append("IS_DELETED = 1 ");
		query.append("WHERE BRANCH_SEQ = ? ");
		query.append("AND MEAL_MENU_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = menuSeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

}
