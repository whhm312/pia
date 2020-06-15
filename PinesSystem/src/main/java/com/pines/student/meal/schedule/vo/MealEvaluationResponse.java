package com.pines.student.meal.schedule.vo;

import java.util.ArrayList;
import java.util.List;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.BreakfastEvaluationDetail;
import com.pines.student.common.vo.DinnerEvaluationDetail;
import com.pines.student.common.vo.LunchEvaluationDetail;
import com.pines.student.common.vo.MealEvaluation;

public class MealEvaluationResponse {
	private String menuDate;
	private String writer;
	private BreakfastEvaluationResponse breakfast;
	private LunchEvaluationResponse lunch;
	private DinnerEvaluationResponse dinner;

	public MealEvaluationResponse(MealEvaluation mealEvaluation) {
		writer = Tools.blankInsteadOfNull(mealEvaluation.getWriter());
		menuDate = Tools.blankInsteadOfNull(mealEvaluation.getFormMealDate());

		breakfast = new BreakfastEvaluationResponse();
		breakfast.setMenuKor(Tools.blankInsteadOfNull(mealEvaluation.getBreakfastMenuKor()));
		breakfast.setMenuEng(Tools.blankInsteadOfNull(mealEvaluation.getBreakfastMenuEng()));
		breakfast.setGoodCount(mealEvaluation.getBreakfastGoodCount());
		breakfast.setFineCount(mealEvaluation.getBreakfastFineCount());
		breakfast.setNogoodCount(mealEvaluation.getBreakfastNogoodCount());
		breakfast.setTotalCount(mealEvaluation.getBreakfastTotalCount());
		List<BreakfastEvaluationDetailResponse> breakfastComments = new ArrayList<BreakfastEvaluationDetailResponse>();
		BreakfastEvaluationDetailResponse breakfastComment = null;
		for (BreakfastEvaluationDetail detail : mealEvaluation.getBreakfastEvaluationDetails()) {
			breakfastComment = new BreakfastEvaluationDetailResponse();
			breakfastComment.setSatisfaction(Tools.blankInsteadOfNull(detail.getEvaluationLevel()));
			breakfastComment.setDetail(Tools.blankInsteadOfNull(detail.getEvaluationDetail()));
			breakfastComment.setIsSpicyMenu(detail.getIsSpicyMenu());
			breakfastComment.setRegisterDate(Tools.blankInsteadOfNull(detail.getFormRegisterDate()));
			breakfastComment.setName(Tools.blankInsteadOfNull(detail.getName()));
			breakfastComment.setNationality(Tools.blankInsteadOfNull(detail.getNationality()));
			breakfastComment.setSex(Tools.blankInsteadOfNull(detail.getSex()));
			breakfastComment.setDateOfBirth(Tools.blankInsteadOfNull(detail.getFormDateOfBirth()));
			breakfastComments.add(breakfastComment);
		}
		breakfast.setComments(breakfastComments);

		lunch = new LunchEvaluationResponse();
		lunch.setMenuKor(mealEvaluation.getLunchMenuKor());
		lunch.setMenuEng(mealEvaluation.getLunchMenuEng());
		lunch.setGoodCount(mealEvaluation.getLunchGoodCount());
		lunch.setFineCount(mealEvaluation.getLunchFineCount());
		lunch.setNogoodCount(mealEvaluation.getLunchNogoodCount());
		lunch.setTotalCount(mealEvaluation.getLunchTotalCount());
		List<LunchEvaluationDetailResponse> lunchComments = new ArrayList<LunchEvaluationDetailResponse>();
		LunchEvaluationDetailResponse lunchComment = null;
		for (LunchEvaluationDetail detail : mealEvaluation.getLunchEvaluationDetails()) {
			lunchComment = new LunchEvaluationDetailResponse();
			lunchComment.setSatisfaction(Tools.blankInsteadOfNull(detail.getEvaluationLevel()));
			lunchComment.setDetail(Tools.blankInsteadOfNull(detail.getEvaluationDetail()));
			lunchComment.setIsSpicyMenu(detail.getIsSpicyMenu());
			lunchComment.setRegisterDate(Tools.blankInsteadOfNull(detail.getFormRegisterDate()));
			lunchComment.setName(Tools.blankInsteadOfNull(detail.getName()));
			lunchComment.setNationality(Tools.blankInsteadOfNull(detail.getNationality()));
			lunchComment.setSex(Tools.blankInsteadOfNull(detail.getSex()));
			lunchComment.setDateOfBirth(Tools.blankInsteadOfNull(detail.getFormDateOfBirth()));
			lunchComments.add(lunchComment);
		}
		lunch.setComments(lunchComments);

		dinner = new DinnerEvaluationResponse();
		dinner.setMenuKor(mealEvaluation.getDinnerMenuKor());
		dinner.setMenuEng(mealEvaluation.getDinnerMenuEng());
		dinner.setGoodCount(mealEvaluation.getDinnerGoodCount());
		dinner.setFineCount(mealEvaluation.getDinnerFineCount());
		dinner.setNogoodCount(mealEvaluation.getDinnerNogoodCount());
		dinner.setTotalCount(mealEvaluation.getDinnerTotalCount());
		List<DinnerEvaluationDetailResponse> dinnerComments = new ArrayList<DinnerEvaluationDetailResponse>();
		DinnerEvaluationDetailResponse dinnerComment = null;
		for (DinnerEvaluationDetail detail : mealEvaluation.getDinnerEvaluationDetails()) {
			dinnerComment = new DinnerEvaluationDetailResponse();
			dinnerComment.setSatisfaction(Tools.blankInsteadOfNull(detail.getEvaluationLevel()));
			dinnerComment.setDetail(Tools.blankInsteadOfNull(detail.getEvaluationDetail()));
			dinnerComment.setIsSpicyMenu(detail.getIsSpicyMenu());
			dinnerComment.setRegisterDate(Tools.blankInsteadOfNull(detail.getFormRegisterDate()));
			dinnerComment.setName(Tools.blankInsteadOfNull(detail.getName()));
			dinnerComment.setNationality(Tools.blankInsteadOfNull(detail.getNationality()));
			dinnerComment.setSex(Tools.blankInsteadOfNull(detail.getSex()));
			dinnerComment.setDateOfBirth(Tools.blankInsteadOfNull(detail.getFormDateOfBirth()));
			dinnerComments.add(dinnerComment);
		}
		dinner.setComments(dinnerComments);

	}

	public String getMenuDate() {
		return menuDate;
	}

	public void setMenuDate(String menuDate) {
		this.menuDate = menuDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public BreakfastEvaluationResponse getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(BreakfastEvaluationResponse breakfast) {
		this.breakfast = breakfast;
	}

	public LunchEvaluationResponse getLunch() {
		return lunch;
	}

	public void setLunch(LunchEvaluationResponse lunch) {
		this.lunch = lunch;
	}

	public DinnerEvaluationResponse getDinner() {
		return dinner;
	}

	public void setDinner(DinnerEvaluationResponse dinner) {
		this.dinner = dinner;
	}

	@Override
	public String toString() {
		return "MealEvaluationResponse [menuDate=" + menuDate + ", writer=" + writer + ", breakfast=" + breakfast + ", lunch=" + lunch + ", dinner=" + dinner + "]";
	}

}
