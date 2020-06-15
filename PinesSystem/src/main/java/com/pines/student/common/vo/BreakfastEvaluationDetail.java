package com.pines.student.common.vo;

public class BreakfastEvaluationDetail {
	private int breakfastEvaluationSeq;
	private int breakfastSeq;
	private String evaluationLevel;
	private String evaluationDetail;
	private boolean isSpicyMenu;
	private String formRegisterDate;
	private String name;
	private String nationality;
	private String sex;
	private String formDateOfBirth;

	public int getBreakfastEvaluationSeq() {
		return breakfastEvaluationSeq;
	}

	public void setBreakfastEvaluationSeq(int breakfastEvaluationSeq) {
		this.breakfastEvaluationSeq = breakfastEvaluationSeq;
	}

	public int getBreakfastSeq() {
		return breakfastSeq;
	}

	public void setBreakfastSeq(int breakfastSeq) {
		this.breakfastSeq = breakfastSeq;
	}

	public String getEvaluationLevel() {
		return evaluationLevel;
	}

	public void setEvaluationLevel(String evaluationLevel) {
		this.evaluationLevel = evaluationLevel;
	}

	public String getEvaluationDetail() {
		return evaluationDetail;
	}

	public void setEvaluationDetail(String evaluationDetail) {
		this.evaluationDetail = evaluationDetail;
	}

	public boolean getIsSpicyMenu() {
		return isSpicyMenu;
	}

	public void setIsSpicyMenu(boolean isSpicyMenu) {
		this.isSpicyMenu = isSpicyMenu;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFormDateOfBirth() {
		return formDateOfBirth;
	}

	public void setFormDateOfBirth(String formDateOfBirth) {
		this.formDateOfBirth = formDateOfBirth;
	}

	@Override
	public String toString() {
		return "BreakfastEvaluation [breakfastEvaluationSeq=" + breakfastEvaluationSeq + ", breakfastSeq=" + breakfastSeq + ", evaluationLevel=" + evaluationLevel + ", evaluationDetail=" + evaluationDetail + ", isSpicyMenu=" + isSpicyMenu + ", formRegisterDate="
				+ formRegisterDate + ", name=" + name + ", nationality=" + nationality + ", sex=" + sex + ", formDateOfBirth=" + formDateOfBirth + "]";
	}

}
