package com.pines.student.common.vo;

public class MealsEvaluations {
	private int totalCount;
	private int mealSeq;
	private String writer;
	private String formMealDate;
	private String formRegisterDate;
	private int goodCount;
	private int fineCount;
	private int nogoodCount;
	private int detailsCount;
	private int evaluationTotal;

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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getFormMealDate() {
		return formMealDate;
	}

	public void setFormMealDate(String formMealDate) {
		this.formMealDate = formMealDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public int getGoodCount() {
		return goodCount;
	}

	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
	}

	public int getFineCount() {
		return fineCount;
	}

	public void setFineCount(int fineCount) {
		this.fineCount = fineCount;
	}

	public int getNogoodCount() {
		return nogoodCount;
	}

	public void setNogoodCount(int nogoodCount) {
		this.nogoodCount = nogoodCount;
	}

	public int getDetailsCount() {
		return detailsCount;
	}

	public void setDetailsCount(int detailsCount) {
		this.detailsCount = detailsCount;
	}

	public int getEvaluationTotal() {
		return evaluationTotal;
	}

	public void setEvaluationTotal(int evaluationTotal) {
		this.evaluationTotal = evaluationTotal;
	}

	@Override
	public String toString() {
		return "MealsEvaluations [totalCount=" + totalCount + ", mealSeq=" + mealSeq + ", writer=" + writer + ", formMealDate=" + formMealDate + ", formRegisterDate=" + formRegisterDate + ", goodCount=" + goodCount + ", fineCount=" + fineCount + ", nogoodCount=" + nogoodCount
				+ ", detailsCount=" + detailsCount + ", evaluationTotal=" + evaluationTotal + "]";
	}

}
