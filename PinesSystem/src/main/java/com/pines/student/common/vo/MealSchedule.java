package com.pines.student.common.vo;

public class MealSchedule {
	private int totalCount;
	private int mealSeq;
	private int branchSeq;
	private String mealDate;
	private String formMealDate;
	private int breakfastSeq;
	private int lunchSeq;
	private int dinnerSeq;
	private String writerId;
	private String writer;
	private String registerDate;
	private String formRegisterDate;
	private boolean isDeleted;

	private int satisfactionGoodCount;
	private int satisfactionFineCount;
	private int satisfactionNoGoodCount;
	private int detailCount;

	private BreakfastSchedule breakfastSchedule;
	private LunchSchedule lunchSchedule;
	private DinnerSchedule dinnerSchedule;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getMealSeq() {
		return mealSeq;
	}

	public void setMealSeq(int mealSeq) {
		this.mealSeq = mealSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public String getMealDate() {
		return mealDate;
	}

	public void setMealDate(String mealDate) {
		this.mealDate = mealDate;
	}

	public String getFormMealDate() {
		return formMealDate;
	}

	public void setFormMealDate(String formMealDate) {
		this.formMealDate = formMealDate;
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

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	public int getDetailCount() {
		return detailCount;
	}

	public void setDetailCount(int detailCount) {
		this.detailCount = detailCount;
	}

	public BreakfastSchedule getBreakfastSchedule() {
		return breakfastSchedule;
	}

	public void setBreakfastSchedule(BreakfastSchedule breakfastSchedule) {
		this.breakfastSchedule = breakfastSchedule;
	}

	public LunchSchedule getLunchSchedule() {
		return lunchSchedule;
	}

	public void setLunchSchedule(LunchSchedule lunchSchedule) {
		this.lunchSchedule = lunchSchedule;
	}

	public DinnerSchedule getDinnerSchedule() {
		return dinnerSchedule;
	}

	public void setDinnerSchedule(DinnerSchedule dinnerSchedule) {
		this.dinnerSchedule = dinnerSchedule;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "MealSchedule [totalCount=" + totalCount + ", mealSeq=" + mealSeq + ", branchSeq=" + branchSeq + ", mealDate=" + mealDate + ", formMealDate=" + formMealDate + ", breakfastSeq=" + breakfastSeq + ", lunchSeq=" + lunchSeq + ", dinnerSeq=" + dinnerSeq + ", writerId="
				+ writerId + ", writer=" + writer + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + ", isDeleted=" + isDeleted + ", satisfactionGoodCount=" + satisfactionGoodCount + ", satisfactionFineCount=" + satisfactionFineCount
				+ ", satisfactionNoGoodCount=" + satisfactionNoGoodCount + ", detailCount=" + detailCount + ", breakfastSchedule=" + breakfastSchedule + ", lunchSchedule=" + lunchSchedule + ", dinnerSchedule=" + dinnerSchedule + "]";
	}

}
