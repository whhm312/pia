package com.pines.student.meal.schedule.vo;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.TodayBreakfastSchedule;
import com.pines.student.common.vo.TodayDinnerSchedule;
import com.pines.student.common.vo.TodayLunchSchedule;
import com.pines.student.common.vo.TodayMealSchedule;

public class TodayMealScheduleResponse {
	private int mealSeq;
	private String menuDate;
	private int breakfastSeq;
	private int lunchSeq;
	private int dinnerSeq;
	private TodayBreakfastScheduleResponse breakfast = new TodayBreakfastScheduleResponse();
	private TodayLunchScheduleResponse lunch = new TodayLunchScheduleResponse();
	private TodayDinnerScheduleResponse dinner = new TodayDinnerScheduleResponse();

	public TodayMealScheduleResponse(TodayMealSchedule mealSchedule) {
		mealSeq = mealSchedule.getMealSeq();
		menuDate = Tools.blankInsteadOfNull(mealSchedule.getFormMealDate());
		breakfastSeq = mealSchedule.getBreakfastSeq();
		lunchSeq = mealSchedule.getLunchSeq();
		dinnerSeq = mealSchedule.getDinnerSeq();
		
		TodayBreakfastSchedule breakfastSchedule = mealSchedule.getBreakfastSchedule();
		breakfast.setPorridgeName(Tools.blankInsteadOfNull(breakfastSchedule.getPorridgeMenu()));
		breakfast.setBreadName(Tools.blankInsteadOfNull(breakfastSchedule.getBreadMenu()));
		breakfast.setRiceName(Tools.blankInsteadOfNull(breakfastSchedule.getRiceMenu()));
		breakfast.setSoupName(Tools.blankInsteadOfNull(breakfastSchedule.getSoupMenu()));
		breakfast.setSpicyMaindishName(Tools.blankInsteadOfNull(breakfastSchedule.getSpicyMaindishMenu()));
		breakfast.setMaindishName(Tools.blankInsteadOfNull(breakfastSchedule.getMaindishMenu()));
		breakfast.setSidedishName1(Tools.blankInsteadOfNull(breakfastSchedule.getSidedish1Menu()));
		breakfast.setSidedishName2(Tools.blankInsteadOfNull(breakfastSchedule.getSidedish2Menu()));
		breakfast.setSidedishName3(Tools.blankInsteadOfNull(breakfastSchedule.getSidedish3Menu()));
		breakfast.setEtcName1(Tools.blankInsteadOfNull(breakfastSchedule.getEtc1Menu()));
		breakfast.setEtcName2(Tools.blankInsteadOfNull(breakfastSchedule.getEtc2Menu()));
		breakfast.setEtcName3(Tools.blankInsteadOfNull(breakfastSchedule.getEtc3Menu()));
		
		TodayLunchSchedule lunchSchedule = mealSchedule.getLunchSchedule();
		lunch.setRiceName(Tools.blankInsteadOfNull(lunchSchedule.getRiceMenu()));
		lunch.setSoupName(Tools.blankInsteadOfNull(lunchSchedule.getSoupMenu()));
		lunch.setSpicyMaindishName(Tools.blankInsteadOfNull(lunchSchedule.getSpicyMaindishMenu()));
		lunch.setMaindishName(Tools.blankInsteadOfNull(lunchSchedule.getMaindishMenu()));
		lunch.setSidedishName1(Tools.blankInsteadOfNull(lunchSchedule.getSidedish1Menu()));
		lunch.setSidedishName2(Tools.blankInsteadOfNull(lunchSchedule.getSidedish2Menu()));
		lunch.setSidedishName3(Tools.blankInsteadOfNull(lunchSchedule.getSidedish3Menu()));
		lunch.setEtcName1(Tools.blankInsteadOfNull(lunchSchedule.getEtc1Menu()));
		lunch.setEtcName2(Tools.blankInsteadOfNull(lunchSchedule.getEtc2Menu()));
		lunch.setEtcName3(Tools.blankInsteadOfNull(lunchSchedule.getEtc3Menu()));
		
		TodayDinnerSchedule dinnerSchedule = mealSchedule.getDinnerSchedule();
		dinner.setRiceName(Tools.blankInsteadOfNull(dinnerSchedule.getRiceMenu()));
		dinner.setSoupName(Tools.blankInsteadOfNull(dinnerSchedule.getSoupMenu()));
		dinner.setSpicyMaindishName(Tools.blankInsteadOfNull(dinnerSchedule.getSpicyMaindishMenu()));
		dinner.setMaindishName(Tools.blankInsteadOfNull(dinnerSchedule.getMaindishMenu()));
		dinner.setSidedishName1(Tools.blankInsteadOfNull(dinnerSchedule.getSidedish1Menu()));
		dinner.setSidedishName2(Tools.blankInsteadOfNull(dinnerSchedule.getSidedish2Menu()));
		dinner.setSidedishName3(Tools.blankInsteadOfNull(dinnerSchedule.getSidedish3Menu()));
		dinner.setEtcName1(Tools.blankInsteadOfNull(dinnerSchedule.getEtc1Menu()));
		dinner.setEtcName2(Tools.blankInsteadOfNull(dinnerSchedule.getEtc2Menu()));
		dinner.setEtcName3(Tools.blankInsteadOfNull(dinnerSchedule.getEtc3Menu()));
	}

	public int getMealSeq() {
		return mealSeq;
	}

	public void setMealSeq(int mealSeq) {
		this.mealSeq = mealSeq;
	}

	public String getMenuDate() {
		return menuDate;
	}

	public void setMenuDate(String menuDate) {
		this.menuDate = menuDate;
	}

	public int getBreakfastSeq() {
		return breakfastSeq;
	}

	public void setBreakfastSeq(int breakfastSeq) {
		this.breakfastSeq = breakfastSeq;
	}

	public int getLunchSeq() {
		return lunchSeq;
	}

	public void setLunchSeq(int lunchSeq) {
		this.lunchSeq = lunchSeq;
	}

	public int getDinnerSeq() {
		return dinnerSeq;
	}

	public void setDinnerSeq(int dinnerSeq) {
		this.dinnerSeq = dinnerSeq;
	}

	public TodayBreakfastScheduleResponse getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(TodayBreakfastScheduleResponse breakfast) {
		this.breakfast = breakfast;
	}

	public TodayLunchScheduleResponse getLunch() {
		return lunch;
	}

	public void setLunch(TodayLunchScheduleResponse lunch) {
		this.lunch = lunch;
	}

	public TodayDinnerScheduleResponse getDinner() {
		return dinner;
	}

	public void setDinner(TodayDinnerScheduleResponse dinner) {
		this.dinner = dinner;
	}

}
