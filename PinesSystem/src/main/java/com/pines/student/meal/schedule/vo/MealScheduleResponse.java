package com.pines.student.meal.schedule.vo;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.BreakfastSchedule;
import com.pines.student.common.vo.DinnerSchedule;
import com.pines.student.common.vo.LunchSchedule;
import com.pines.student.common.vo.MealSchedule;

public class MealScheduleResponse {
	private String menuDate;
	private String writer;
	private BreakfastScheduleResponse breakfast;
	private LunchScheduleResponse lunch;
	private DinnerScheduleResponse dinner;

	public MealScheduleResponse(MealSchedule mealSchedule) {
		menuDate = Tools.blankInsteadOfNull(mealSchedule.getFormMealDate());
		writer = Tools.blankInsteadOfNull(mealSchedule.getWriter());

		BreakfastSchedule breakfastSchedule = mealSchedule.getBreakfastSchedule();
		if (breakfastSchedule != null) {
			breakfast = new BreakfastScheduleResponse();
			breakfast.setPorridgeSeq(breakfastSchedule.getPorridgeMenuSeq());
			breakfast.setBreadSeq(breakfastSchedule.getBreadMenuSeq());
			breakfast.setRiceSeq(breakfastSchedule.getRiceMenuSeq());
			breakfast.setSoupSeq(breakfastSchedule.getSoupMenuSeq());
			breakfast.setSpicyMaindishSeq(breakfastSchedule.getSpicyMaindishMenuSeq());
			breakfast.setMaindishSeq(breakfastSchedule.getMaindishMenuSeq());
			breakfast.setSidedishSeq1(breakfastSchedule.getSidedish1MenuSeq());
			breakfast.setSidedishSeq2(breakfastSchedule.getSidedish2MenuSeq());
			breakfast.setSidedishSeq3(breakfastSchedule.getSidedish3MenuSeq());
			breakfast.setEtcSeq1(breakfastSchedule.getEtc1MenuSeq());
			breakfast.setEtcSeq2(breakfastSchedule.getEtc2MenuSeq());
			breakfast.setEtcSeq3(breakfastSchedule.getEtc3MenuSeq());
		}

		LunchSchedule lunchSchedule = mealSchedule.getLunchSchedule();
		if (lunchSchedule != null) {
			lunch = new LunchScheduleResponse();
			lunch.setRiceSeq(lunchSchedule.getRiceMenuSeq());
			lunch.setSoupSeq(lunchSchedule.getSoupMenuSeq());
			lunch.setSpicyMaindishSeq(lunchSchedule.getSpicyMaindishMenuSeq());
			lunch.setMaindishSeq(lunchSchedule.getMaindishMenuSeq());
			lunch.setSidedishSeq1(lunchSchedule.getSidedish1MenuSeq());
			lunch.setSidedishSeq2(lunchSchedule.getSidedish2MenuSeq());
			lunch.setSidedishSeq3(lunchSchedule.getSidedish3MenuSeq());
			lunch.setEtcSeq1(lunchSchedule.getEtc1MenuSeq());
			lunch.setEtcSeq2(lunchSchedule.getEtc2MenuSeq());
			lunch.setEtcSeq3(lunchSchedule.getEtc3MenuSeq());
		}

		DinnerSchedule dinnerSchedule = mealSchedule.getDinnerSchedule();
		if (dinnerSchedule != null) {
			dinner = new DinnerScheduleResponse();
			dinner.setRiceSeq(dinnerSchedule.getRiceMenuSeq());
			dinner.setSoupSeq(dinnerSchedule.getSoupMenuSeq());
			dinner.setSpicyMaindishSeq(dinnerSchedule.getSpicyMaindishMenuSeq());
			dinner.setMaindishSeq(dinnerSchedule.getMaindishMenuSeq());
			dinner.setSidedishSeq1(dinnerSchedule.getSidedish1MenuSeq());
			dinner.setSidedishSeq2(dinnerSchedule.getSidedish2MenuSeq());
			dinner.setSidedishSeq3(dinnerSchedule.getSidedish3MenuSeq());
			dinner.setEtcSeq1(dinnerSchedule.getEtc1MenuSeq());
			dinner.setEtcSeq2(dinnerSchedule.getEtc2MenuSeq());
			dinner.setEtcSeq3(dinnerSchedule.getEtc3MenuSeq());
		}
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

	public BreakfastScheduleResponse getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(BreakfastScheduleResponse breakfast) {
		this.breakfast = breakfast;
	}

	public LunchScheduleResponse getLunch() {
		return lunch;
	}

	public void setLunch(LunchScheduleResponse lunch) {
		this.lunch = lunch;
	}

	public DinnerScheduleResponse getDinner() {
		return dinner;
	}

	public void setDinner(DinnerScheduleResponse dinner) {
		this.dinner = dinner;
	}

	@Override
	public String toString() {
		return "MealScheduleResponse [menuDate=" + menuDate + ", writer=" + writer + ", breakfast=" + breakfast + ", lunch=" + lunch + ", dinner=" + dinner + "]";
	}

}
