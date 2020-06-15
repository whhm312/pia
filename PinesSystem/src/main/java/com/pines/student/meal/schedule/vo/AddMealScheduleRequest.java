package com.pines.student.meal.schedule.vo;

import com.pines.student.common.vo.MealSchedule;

public class AddMealScheduleRequest {
	private int branchSeq;
	private String menuDate;
	private String writerId;
	private AddMealBreakfastScheduleRequest breakfast = new AddMealBreakfastScheduleRequest();
	private AddMealLunchScheduleRequest lunch = new AddMealLunchScheduleRequest();
	private AddMealDinnerScheduleRequest dinner = new AddMealDinnerScheduleRequest();

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
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

	public AddMealBreakfastScheduleRequest getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(AddMealBreakfastScheduleRequest breakfast) {
		this.breakfast = breakfast;
	}

	public AddMealLunchScheduleRequest getLunch() {
		return lunch;
	}

	public void setLunch(AddMealLunchScheduleRequest lunch) {
		this.lunch = lunch;
	}

	public AddMealDinnerScheduleRequest getDinner() {
		return dinner;
	}

	public void setDinner(AddMealDinnerScheduleRequest dinner) {
		this.dinner = dinner;
	}

	@Override
	public String toString() {
		return "AddMealScheduleRequest [branchSeq=" + branchSeq + ", menuDate=" + menuDate + ", writerId=" + writerId + ", breakfast=" + breakfast + ", lunch=" + lunch + ", dinner=" + dinner + "]";
	}

	public MealSchedule getMealSchedule() {
		MealSchedule result = new MealSchedule();
		result.setBranchSeq(branchSeq);
		result.setMealDate(menuDate);
		result.setWriterId(writerId);
		result.setBreakfastSchedule(breakfast.getSchedule());
		result.setLunchSchedule(lunch.getSchedule());
		result.setDinnerSchedule(dinner.getSchedule());
		return result;
	}

}
