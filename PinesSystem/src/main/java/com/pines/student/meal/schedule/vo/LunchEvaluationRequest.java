package com.pines.student.meal.schedule.vo;

import com.pines.student.common.vo.MealEvaluation;

public class LunchEvaluationRequest {
	private int branchSeq;
	private int mealSeq;
	private int lunchSeq;
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

	public int getLunchSeq() {
		return lunchSeq;
	}

	public void setLunchSeq(int lunchSeq) {
		this.lunchSeq = lunchSeq;
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
		return "LunchEvaluationRequest [branchSeq=" + branchSeq + ", mealSeq=" + mealSeq + ", lunchSeq=" + lunchSeq + ", writerId=" + writerId + ", isSpicy=" + isSpicy + ", satisfaction=" + satisfaction + ", detail=" + detail + "]";
	}

	public MealEvaluation getEvaluation() {
		MealEvaluation result = new MealEvaluation();
		result.setBranchSeq(branchSeq);
		result.setMealSeq(mealSeq);
		result.setWriterId(writerId);
		result.setLunchEvaluation(true);
		result.setLunchSeq(lunchSeq);
		result.setDetail(detail);
		result.setSpicy(isSpicy);
		result.setSatisfaction(satisfaction);
		return result;
	}

}
