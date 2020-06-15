package com.pines.student.meal.schedule.vo;

import com.pines.student.common.vo.LunchSchedule;

public class AddMealLunchScheduleRequest {
	private int riceSeq;
	private int soupSeq;
	private int spicyMaindishSeq;
	private int maindishSeq;
	private int sidedishSeq1;
	private int sidedishSeq2;
	private int sidedishSeq3;
	private int etcSeq1;
	private int etcSeq2;
	private int etcSeq3;

	public int getRiceSeq() {
		return riceSeq;
	}

	public void setRiceSeq(int riceSeq) {
		this.riceSeq = riceSeq;
	}

	public int getSoupSeq() {
		return soupSeq;
	}

	public void setSoupSeq(int soupSeq) {
		this.soupSeq = soupSeq;
	}

	public int getSpicyMaindishSeq() {
		return spicyMaindishSeq;
	}

	public void setSpicyMaindishSeq(int spicyMaindishSeq) {
		this.spicyMaindishSeq = spicyMaindishSeq;
	}

	public int getMaindishSeq() {
		return maindishSeq;
	}

	public void setMaindishSeq(int maindishSeq) {
		this.maindishSeq = maindishSeq;
	}

	public int getSidedishSeq1() {
		return sidedishSeq1;
	}

	public void setSidedishSeq1(int sidedishSeq1) {
		this.sidedishSeq1 = sidedishSeq1;
	}

	public int getSidedishSeq2() {
		return sidedishSeq2;
	}

	public void setSidedishSeq2(int sidedishSeq2) {
		this.sidedishSeq2 = sidedishSeq2;
	}

	public int getSidedishSeq3() {
		return sidedishSeq3;
	}

	public void setSidedishSeq3(int sidedishSeq3) {
		this.sidedishSeq3 = sidedishSeq3;
	}

	public int getEtcSeq1() {
		return etcSeq1;
	}

	public void setEtcSeq1(int etcSeq1) {
		this.etcSeq1 = etcSeq1;
	}

	public int getEtcSeq2() {
		return etcSeq2;
	}

	public void setEtcSeq2(int etcSeq2) {
		this.etcSeq2 = etcSeq2;
	}

	public int getEtcSeq3() {
		return etcSeq3;
	}

	public void setEtcSeq3(int etcSeq3) {
		this.etcSeq3 = etcSeq3;
	}

	@Override
	public String toString() {
		return "AddMealLunchScheduleRequest [riceSeq=" + riceSeq + ", soupSeq=" + soupSeq + ", spicyMaindishSeq=" + spicyMaindishSeq + ", maindishSeq=" + maindishSeq + ", sidedishSeq1=" + sidedishSeq1 + ", sidedishSeq2=" + sidedishSeq2 + ", sidedishSeq3=" + sidedishSeq3
				+ ", etcSeq1=" + etcSeq1 + ", etcSeq2=" + etcSeq2 + ", etcSeq3=" + etcSeq3 + "]";
	}

	public LunchSchedule getSchedule() {
		LunchSchedule result = new LunchSchedule();
		result.setRiceMenuSeq(riceSeq);
		result.setSoupMenuSeq(soupSeq);
		result.setSpicyMaindishMenuSeq(spicyMaindishSeq);
		result.setMaindishMenuSeq(maindishSeq);
		result.setSidedish1MenuSeq(sidedishSeq1);
		result.setSidedish2MenuSeq(sidedishSeq2);
		result.setSidedish3MenuSeq(sidedishSeq3);
		result.setEtc1MenuSeq(etcSeq1);
		result.setEtc2MenuSeq(etcSeq2);
		result.setEtc3MenuSeq(etcSeq3);
		return result;
	}

}
