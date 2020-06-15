package com.pines.student.meal.schedule.vo;

public class LunchEvaluationDetailResponse {
	private String satisfaction;
	private String detail;
	private boolean isSpicyMenu;
	private String registerDate;
	private String name;
	private String nationality;
	private String sex;
	private String dateOfBirth;

	public String getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(String satisfaction) {
		if ("G".equals(satisfaction)) {
			this.satisfaction = "Good";
		} else if ("F".equals(satisfaction)) {
			this.satisfaction = "Fine";
		} else if ("N".equals(satisfaction)) {
			this.satisfaction = "Not Good";
		} else {
			this.satisfaction = satisfaction;
		}
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public boolean getIsSpicyMenu() {
		return isSpicyMenu;
	}

	public void setIsSpicyMenu(boolean isSpicyMenu) {
		this.isSpicyMenu = isSpicyMenu;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "LunchEvaluationDetailResponse [satisfaction=" + satisfaction + ", detail=" + detail + ", isSpicyMenu=" + isSpicyMenu + ", registerDate=" + registerDate + ", name=" + name + ", nationality=" + nationality + ", sex=" + sex + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}

}
