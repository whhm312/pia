package com.pines.student.common.vo;

public class MealMenu {
	private int totalCount;
	private int branchSeq;
	private int mealMenuSeq;
	private String menuType;
	private String menuKorName;
	private String menuEngName;
	private boolean isUsed;
	private String registerDate;
	private String formRegisterDate;
	private boolean isDeleted;
	private boolean isSpicy;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getMealMenuSeq() {
		return mealMenuSeq;
	}

	public void setMealMenuSeq(int mealMenuSeq) {
		this.mealMenuSeq = mealMenuSeq;
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

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public boolean getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(boolean isUsed) {
		this.isUsed = isUsed;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean getIsSpicy() {
		return isSpicy;
	}

	public void setIsSpicy(boolean isSpicy) {
		this.isSpicy = isSpicy;
	}

	@Override
	public String toString() {
		return "MealMenu [totalCount=" + totalCount + ", branchSeq=" + branchSeq + ", mealMenuSeq=" + mealMenuSeq + ", menuType=" + menuType + ", menuKorName=" + menuKorName + ", menuEngName=" + menuEngName + ", isUsed=" + isUsed + ", registerDate=" + registerDate
				+ ", formRegisterDate=" + formRegisterDate + ", isDeleted=" + isDeleted + ", isSpicy=" + isSpicy + "]";
	}

}
