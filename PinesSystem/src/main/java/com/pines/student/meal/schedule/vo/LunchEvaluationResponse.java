package com.pines.student.meal.schedule.vo;

import java.util.List;

public class LunchEvaluationResponse {
	private String menuKor;
	private String menuEng;
	private int totalCount;
	private int goodCount;
	private int fineCount;
	private int nogoodCount;
	private List<LunchEvaluationDetailResponse> comments;

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

	public List<LunchEvaluationDetailResponse> getComments() {
		return comments;
	}

	public void setComments(List<LunchEvaluationDetailResponse> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "LunchEvaluationResponse [menuKor=" + menuKor + ", menuEng=" + menuEng + ", totalCount=" + totalCount + ", goodCount=" + goodCount + ", fineCount=" + fineCount + ", nogoodCount=" + nogoodCount + ", comments=" + comments + "]";
	}

}
