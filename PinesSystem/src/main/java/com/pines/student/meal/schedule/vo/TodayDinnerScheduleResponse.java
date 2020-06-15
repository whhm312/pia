package com.pines.student.meal.schedule.vo;

public class TodayDinnerScheduleResponse {
	private String riceName;
	private String soupName;
	private String spicyMaindishName;
	private String maindishName;
	private String sidedishName1;
	private String sidedishName2;
	private String sidedishName3;
	private String etcName1;
	private String etcName2;
	private String etcName3;

	public String getRiceName() {
		return riceName;
	}

	public void setRiceName(String riceName) {
		this.riceName = riceName;
	}

	public String getSoupName() {
		return soupName;
	}

	public void setSoupName(String soupName) {
		this.soupName = soupName;
	}

	public String getSpicyMaindishName() {
		return spicyMaindishName;
	}

	public void setSpicyMaindishName(String spicyMaindishName) {
		this.spicyMaindishName = spicyMaindishName;
	}

	public String getMaindishName() {
		return maindishName;
	}

	public void setMaindishName(String maindishName) {
		this.maindishName = maindishName;
	}

	public String getSidedishName1() {
		return sidedishName1;
	}

	public void setSidedishName1(String sidedishName1) {
		this.sidedishName1 = sidedishName1;
	}

	public String getSidedishName2() {
		return sidedishName2;
	}

	public void setSidedishName2(String sidedishName2) {
		this.sidedishName2 = sidedishName2;
	}

	public String getSidedishName3() {
		return sidedishName3;
	}

	public void setSidedishName3(String sidedishName3) {
		this.sidedishName3 = sidedishName3;
	}

	public String getEtcName1() {
		return etcName1;
	}

	public void setEtcName1(String etcName1) {
		this.etcName1 = etcName1;
	}

	public String getEtcName2() {
		return etcName2;
	}

	public void setEtcName2(String etcName2) {
		this.etcName2 = etcName2;
	}

	public String getEtcName3() {
		return etcName3;
	}

	public void setEtcName3(String etcName3) {
		this.etcName3 = etcName3;
	}

	@Override
	public String toString() {
		return "TodayDinnerScheduleResponse [riceName=" + riceName + ", soupName=" + soupName + ", spicyMaindishName=" + spicyMaindishName + ", maindishName=" + maindishName + ", sidedishName1=" + sidedishName1 + ", sidedishName2=" + sidedishName2 + ", sidedishName3="
				+ sidedishName3 + ", etcName1=" + etcName1 + ", etcName2=" + etcName2 + ", etcName3=" + etcName3 + "]";
	}

}
