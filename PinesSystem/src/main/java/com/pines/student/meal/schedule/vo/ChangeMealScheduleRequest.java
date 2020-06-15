package com.pines.student.meal.schedule.vo;

import com.pines.student.common.vo.MealSchedule;

public class ChangeMealScheduleRequest {
	private int branchSeq;
	private int mealSeq;
	private String menuDate;
	private String writerId;
	private ChangeMealBreakfastScheduleRequest breakfast = new ChangeMealBreakfastScheduleRequest();
	private ChangeMealLunchScheduleRequest lunch = new ChangeMealLunchScheduleRequest();
	private ChangeMealDinnerScheduleRequest dinner = new ChangeMealDinnerScheduleRequest();

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
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

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public ChangeMealBreakfastScheduleRequest getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(ChangeMealBreakfastScheduleRequest breakfast) {
		this.breakfast = breakfast;
	}

	public ChangeMealLunchScheduleRequest getLunch() {
		return lunch;
	}

	public void setLunch(ChangeMealLunchScheduleRequest lunch) {
		this.lunch = lunch;
	}

	public ChangeMealDinnerScheduleRequest getDinner() {
		return dinner;
	}

	public void setDinner(ChangeMealDinnerScheduleRequest dinner) {
		this.dinner = dinner;
	}

	@Override
	public String toString() {
		return "ChangeMealScheduleRequest [branchSeq=" + branchSeq + ", mealSeq=" + mealSeq + ", menuDate=" + menuDate + ", writerId=" + writerId + ", breakfast=" + breakfast + ", lunch=" + lunch + ", dinner=" + dinner + "]";
	}

	public MealSchedule getMealSchedule() {
		MealSchedule result = new MealSchedule();
		result.setBranchSeq(branchSeq);
		result.setMealSeq(mealSeq);
		result.setMealDate(menuDate);
		result.setWriterId(writerId);
		result.setBreakfastSchedule(breakfast.getSchedule());
		result.setLunchSchedule(lunch.getSchedule());
		result.setDinnerSchedule(dinner.getSchedule());
		return result;
	}

}
