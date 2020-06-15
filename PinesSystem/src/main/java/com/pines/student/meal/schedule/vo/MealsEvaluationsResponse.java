package com.pines.student.meal.schedule.vo;

public class MealsEvaluationsResponse {
	private int mealSeq;
	private String menuDate;
	private int satisfactionGoodCount;
	private int satisfactionFineCount;
	private int satisfactionNoGoodCount;
	private int satisfactionTotalCount;
	private int detailCount;
	private String registerDate;
	private String writer;

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

	public int getSatisfactionGoodCount() {
		return satisfactionGoodCount;
	}

	public void setSatisfactionGoodCount(int satisfactionGoodCount) {
		this.satisfactionGoodCount = satisfactionGoodCount;
	}

	public int getSatisfactionFineCount() {
		return satisfactionFineCount;
	}

	public void setSatisfactionFineCount(int satisfactionFineCount) {
		this.satisfactionFineCount = satisfactionFineCount;
	}

	public int getSatisfactionNoGoodCount() {
		return satisfactionNoGoodCount;
	}

	public void setSatisfactionNoGoodCount(int satisfactionNoGoodCount) {
		this.satisfactionNoGoodCount = satisfactionNoGoodCount;
	}

	public int getSatisfactionTotalCount() {
		return satisfactionTotalCount;
	}

	public void setSatisfactionTotalCount(int satisfactionTotalCount) {
		this.satisfactionTotalCount = satisfactionTotalCount;
	}

	public int getDetailCount() {
		return detailCount;
	}

	public void setDetailCount(int detailCount) {
		this.detailCount = detailCount;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "MealsEvaluationsResponse [mealSeq=" + mealSeq + ", menuDate=" + menuDate + ", satisfactionGoodCount=" + satisfactionGoodCount + ", satisfactionFineCount=" + satisfactionFineCount + ", satisfactionNoGoodCount=" + satisfactionNoGoodCount
				+ ", satisfactionTotalCount=" + satisfactionTotalCount + ", detailCount=" + detailCount + ", registerDate=" + registerDate + ", writer=" + writer + "]";
	}
}
