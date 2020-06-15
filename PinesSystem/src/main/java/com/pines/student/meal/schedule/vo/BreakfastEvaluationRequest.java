package com.pines.student.meal.schedule.vo;

import com.pines.student.common.vo.MealEvaluation;

public class BreakfastEvaluationRequest {
	private int branchSeq;
	private int mealSeq;
	private int breakfastSeq;
	private String writerId;
	private boolean isSpicy;
	private String satisfaction;
	private StringBuffer detail;

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

	public int getBreakfastSeq() {
		return breakfastSeq;
	}

	public void setBreakfastSeq(int breakfastSeq) {
		this.breakfastSeq = breakfastSeq;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public boolean isSpicy() {
		return isSpicy;
	}

	public void setSpicy(boolean isSpicy) {
		this.isSpicy = isSpicy;
	}

	public String getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}

	public StringBuffer getDetail() {
		return detail;
	}

	public void setDetail(StringBuffer detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "BreakfastEvaluationRequest [branchSeq=" + branchSeq + ", mealSeq=" + mealSeq + ", breakfastSeq=" + breakfastSeq + ", writerId=" + writerId + ", isSpicy=" + isSpicy + ", satisfaction=" + satisfaction + ", detail=" + detail + "]";
	}

	public MealEvaluation getEvaluation() {
		MealEvaluation result = new MealEvaluation();
		result.setBranchSeq(branchSeq);
		result.setMealSeq(mealSeq);
		result.setWriterId(writerId);
		result.setBreakfastEvaluation(true);
		result.setBreakfastSeq(breakfastSeq);
		result.setDetail(detail);
		result.setSpicy(isSpicy);
		result.setSatisfaction(satisfaction);
		return result;
	}

}
