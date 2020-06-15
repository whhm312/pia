package com.pines.student.meal.menu.vo;

import com.pines.student.common.vo.MealMenu;

public class ChangeMealMenuRequest {
	private int branchSeq;
	private int menuSeq;
	private String menuType;
	private String menuKorName;
	private String menuEngName;
	private boolean isUsed;
	private boolean isSpicy;

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getMenuKorName() {
		return menuKorName;
	}

	public void setMenuKorName(String menuKorName) {
		this.menuKorName = menuKorName;
	}

	public String getMenuEngName() {
		return menuEngName;
	}

	public void setMenuEngName(String menuEngName) {
		this.menuEngName = menuEngName;
	}

	public boolean getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public boolean getIsSpicy() {
		return isSpicy;
	}

	public void setIsSpicy(boolean isSpicy) {
		this.isSpicy = isSpicy;
	}

	@Override
	public String toString() {
		return "ChangeMealMenuRequest [branchSeq=" + branchSeq + ", menuSeq=" + menuSeq + ", menuType=" + menuType + ", menuKorName=" + menuKorName + ", menuEngName=" + menuEngName + ", isUsed=" + isUsed + ", isSpicy=" + isSpicy + "]";
	}

	public MealMenu getMealMenu() {
		MealMenu result = new MealMenu();
		result.setBranchSeq(branchSeq);
		result.setMenuType(menuType);
		result.setMealMenuSeq(menuSeq);
		result.setMenuKorName(menuKorName);
		result.setMenuEngName(menuEngName);
		result.setIsSpicy(isSpicy);
		result.setIsUsed(isUsed);
		return result;
	}

}
