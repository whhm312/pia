package com.pines.student.meal.schedule.vo;

import java.util.List;

public class BreakfastEvaluationResponse {
	private String menuKor;
	private String menuEng;
	private int totalCount;
	private int goodCount;
	private int fineCount;
	private int nogoodCount;
	private List<BreakfastEvaluationDetailResponse> comments;

	public String getMenuKor() {
		return menuKor;
	}

	public void setMenuKor(String menuKor) {
		this.menuKor = menuKor;
	}

	public String getMenuEng() {
		return menuEng;
	}

	public void setMenuEng(String menuEng) {
		this.menuEng = menuEng;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
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

	public List<BreakfastEvaluationDetailResponse> getComments() {
		return comments;
	}

	public void setComments(List<BreakfastEvaluationDetailResponse> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "BreakfastEvaluationResponse [menuKor=" + menuKor + ", menuEng=" + menuEng + ", totalCount=" + totalCount + ", goodCount=" + goodCount + ", fineCount=" + fineCount + ", nogoodCount=" + nogoodCount + ", comments=" + comments + "]";
	}

}
