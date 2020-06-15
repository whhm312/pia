package com.pines.student.common.vo;

import java.util.List;

import com.pines.student.common.Tools;

public class MealEvaluation {
	private int branchSeq;
	private int mealSeq;

	private boolean isBreakfastEvaluation;
	private int breakfastSeq;
	private boolean isLunchEvaluation;
	private int lunchSeq;
	private boolean isDinnerEvaluation;
	private int dinnerSeq;
	private String writerId;
	private boolean isSpicy;
	private String satisfaction;
	private StringBuffer detail;

	private String formMealDate;
	private String formRegisterDate;
	private String writer;
	private BreakfastSchedule breakfastSchedule;
	private LunchSchedule lunchSchedule;
	private DinnerSchedule dinnerSchedule;

	private int breakfastTotalCount;
	private int breakfastGoodCount;
	private int breakfastFineCount;
	private int breakfastNogoodCount;

	private int lunchTotalCount;
	private int lunchGoodCount;
	private int lunchFineCount;
	private int lunchNogoodCount;

	private int dinnerTotalCount;
	private int dinnerGoodCount;
	private int dinnerFineCount;
	private int dinnerNogoodCount;

	private List<BreakfastEvaluationDetail> breakfastEvaluationDetails;
	private List<LunchEvaluationDetail> lunchEvaluationDetails;
	private List<DinnerEvaluationDetail> dinnerEvaluationDetails;

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getMealSeq() {
		return mealSeq;
	}

	public void setMealSeq(int mealSeq) {
		this.mealSeq = mealSeq;
	}

	public boolean isBreakfastEvaluation() {
		return isBreakfastEvaluation;
	}

	public void setBreakfastEvaluation(boolean isBreakfastEvaluation) {
		this.isBreakfastEvaluation = isBreakfastEvaluation;
	}

	public int getBreakfastSeq() {
		return breakfastSeq;
	}

	public void setBreakfastSeq(int breakfastSeq) {
		this.breakfastSeq = breakfastSeq;
	}

	public boolean isLunchEvaluation() {
		return isLunchEvaluation;
	}

	public void setLunchEvaluation(boolean isLunchEvaluation) {
		this.isLunchEvaluation = isLunchEvaluation;
	}

	public int getLunchSeq() {
		return lunchSeq;
	}

	public void setLunchSeq(int lunchSeq) {
		this.lunchSeq = lunchSeq;
	}

	public boolean isDinnerEvaluation() {
		return isDinnerEvaluation;
	}

	public void setDinnerEvaluation(boolean isDinnerEvaluation) {
		this.isDinnerEvaluation = isDinnerEvaluation;
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

	public boolean isSpicy() {
		return isSpicy;
	}

	public void setSpicy(boolean isSpicy) {
		this.isSpicy = isSpicy;
	}

	public String getSatisfaction() {
		if ("Good".equals(satisfaction)) {
			satisfaction = "G";
		} else if ("Fine".equals(satisfaction)) {
			satisfaction = "F";
		} else if ("No Good".equals(satisfaction)) {
			satisfaction = "N";
		}
		return satisfaction;
	}

	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}

	public StringBuffer getDetail() {
		return detail;
	}

	public void setDetail(StringBuffer detail) {
		this.detail = detail;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public int getBreakfastTotalCount() {
		return breakfastTotalCount;
	}

	public void setBreakfastTotalCount(int breakfastTotalCount) {
		this.breakfastTotalCount = breakfastTotalCount;
	}

	public int getBreakfastGoodCount() {
		return breakfastGoodCount;
	}

	public void setBreakfastGoodCount(int breakfastGoodCount) {
		this.breakfastGoodCount = breakfastGoodCount;
	}

	public int getBreakfastFineCount() {
		return breakfastFineCount;
	}

	public void setBreakfastFineCount(int breakfastFineCount) {
		this.breakfastFineCount = breakfastFineCount;
	}

	public int getBreakfastNogoodCount() {
		return breakfastNogoodCount;
	}

	public void setBreakfastNogoodCount(int breakfastNogoodCount) {
		this.breakfastNogoodCount = breakfastNogoodCount;
	}

	public int getLunchTotalCount() {
		return lunchTotalCount;
	}

	public void setLunchTotalCount(int lunchTotalCount) {
		this.lunchTotalCount = lunchTotalCount;
	}

	public int getLunchGoodCount() {
		return lunchGoodCount;
	}

	public void setLunchGoodCount(int lunchGoodCount) {
		this.lunchGoodCount = lunchGoodCount;
	}

	public int getLunchFineCount() {
		return lunchFineCount;
	}

	public void setLunchFineCount(int lunchFineCount) {
		this.lunchFineCount = lunchFineCount;
	}

	public int getLunchNogoodCount() {
		return lunchNogoodCount;
	}

	public void setLunchNogoodCount(int lunchNogoodCount) {
		this.lunchNogoodCount = lunchNogoodCount;
	}

	public int getDinnerTotalCount() {
		return dinnerTotalCount;
	}

	public void setDinnerTotalCount(int dinnerTotalCount) {
		this.dinnerTotalCount = dinnerTotalCount;
	}

	public int getDinnerGoodCount() {
		return dinnerGoodCount;
	}

	public void setDinnerGoodCount(int dinnerGoodCount) {
		this.dinnerGoodCount = dinnerGoodCount;
	}

	public int getDinnerFineCount() {
		return dinnerFineCount;
	}

	public void setDinnerFineCount(int dinnerFineCount) {
		this.dinnerFineCount = dinnerFineCount;
	}

	public int getDinnerNogoodCount() {
		return dinnerNogoodCount;
	}

	public void setDinnerNogoodCount(int dinnerNogoodCount) {
		this.dinnerNogoodCount = dinnerNogoodCount;
	}

	public List<BreakfastEvaluationDetail> getBreakfastEvaluationDetails() {
		return breakfastEvaluationDetails;
	}

	public void setBreakfastEvaluationDetails(List<BreakfastEvaluationDetail> breakfastEvaluationDetails) {
		this.breakfastEvaluationDetails = breakfastEvaluationDetails;
	}

	public List<LunchEvaluationDetail> getLunchEvaluationDetails() {
		return lunchEvaluationDetails;
	}

	public void setLunchEvaluationDetails(List<LunchEvaluationDetail> lunchEvaluationDetails) {
		this.lunchEvaluationDetails = lunchEvaluationDetails;
	}

	public List<DinnerEvaluationDetail> getDinnerEvaluationDetails() {
		return dinnerEvaluationDetails;
	}

	public void setDinnerEvaluationDetails(List<DinnerEvaluationDetail> dinnerEvaluationDetails) {
		this.dinnerEvaluationDetails = dinnerEvaluationDetails;
	}

	@Override
	public String toString() {
		return "MealEvaluation [branchSeq=" + branchSeq + ", mealSeq=" + mealSeq + ", isBreakfastEvaluation=" + isBreakfastEvaluation + ", breakfastSeq=" + breakfastSeq + ", isLunchEvaluation=" + isLunchEvaluation + ", lunchSeq=" + lunchSeq + ", isDinnerEvaluation="
				+ isDinnerEvaluation + ", dinnerSeq=" + dinnerSeq + ", writerId=" + writerId + ", isSpicy=" + isSpicy + ", satisfaction=" + satisfaction + ", detail=" + detail + ", formMealDate=" + formMealDate + ", formRegisterDate=" + formRegisterDate + ", writer=" + writer
				+ ", breakfastSchedule=" + breakfastSchedule + ", lunchSchedule=" + lunchSchedule + ", dinnerSchedule=" + dinnerSchedule + ", breakfastTotalCount=" + breakfastTotalCount + ", breakfastGoodCount=" + breakfastGoodCount + ", breakfastFineCount=" + breakfastFineCount
				+ ", breakfastNogoodCount=" + breakfastNogoodCount + ", lunchTotalCount=" + lunchTotalCount + ", lunchGoodCount=" + lunchGoodCount + ", lunchFineCount=" + lunchFineCount + ", lunchNogoodCount=" + lunchNogoodCount + ", dinnerTotalCount=" + dinnerTotalCount
				+ ", dinnerGoodCount=" + dinnerGoodCount + ", dinnerFineCount=" + dinnerFineCount + ", dinnerNogoodCount=" + dinnerNogoodCount + ", breakfastEvaluationDetails=" + breakfastEvaluationDetails + ", lunchEvaluationDetails=" + lunchEvaluationDetails
				+ ", dinnerEvaluationDetails=" + dinnerEvaluationDetails + "]";
	}

	public String getBreakfastMenuKor() {
		StringBuffer sb = new StringBuffer();
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getPorridgeMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getBreadMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getRiceMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getSoupMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getSpicyMaindishMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getMaindishMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getSidedish1MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getSidedish2MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getSidedish3MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getEtc1MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getEtc2MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getEtc3MenuKor()));

		return menuReplace(sb);
	}

	public String getBreakfastMenuEng() {
		StringBuffer sb = new StringBuffer();
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getPorridgeMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getBreadMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getRiceMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getSoupMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getSpicyMaindishMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getMaindishMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getSidedish1MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getSidedish2MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getSidedish3MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getEtc1MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getEtc2MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(breakfastSchedule.getEtc3MenuEng()));

		return menuReplace(sb);
	}

	public String getLunchMenuKor() {
		StringBuffer sb = new StringBuffer();
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getRiceMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getSoupMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getSpicyMaindishMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getMaindishMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getSidedish1MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getSidedish2MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getSidedish3MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getEtc1MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getEtc2MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getEtc3MenuKor()));

		return menuReplace(sb);
	}

	public String getLunchMenuEng() {
		StringBuffer sb = new StringBuffer();
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getRiceMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getSoupMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getSpicyMaindishMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getMaindishMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getSidedish1MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getSidedish2MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getSidedish3MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getEtc1MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getEtc2MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(lunchSchedule.getEtc3MenuEng()));

		return menuReplace(sb);
	}

	public String getDinnerMenuKor() {
		StringBuffer sb = new StringBuffer();
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getRiceMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getSoupMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getSpicyMaindishMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getMaindishMenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getSidedish1MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getSidedish2MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getSidedish3MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getEtc1MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getEtc2MenuKor()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getEtc3MenuKor()));

		return menuReplace(sb);
	}

	public String getDinnerMenuEng() {
		StringBuffer sb = new StringBuffer();
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getRiceMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getSoupMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getSpicyMaindishMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getMaindishMenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getSidedish1MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getSidedish2MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getSidedish3MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getEtc1MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getEtc2MenuEng()));
		sb.append(", ");
		sb.append(Tools.blankInsteadOfNull(dinnerSchedule.getEtc3MenuEng()));

		return menuReplace(sb);
	}

	private String menuReplace(StringBuffer sb) {
		String tempSb = sb.toString();
			
		String firstOldChar = ", , ";
		String firstNewChar = ", ";
		while(true) {
			tempSb = tempSb.replaceAll(firstOldChar, firstNewChar);
			if (tempSb.indexOf(firstOldChar) < 0) {
				break;
			}
		}

		String secondOldChar = ",  ";
		String secondNewChar = ", ";
		tempSb = tempSb.replaceAll(secondOldChar, secondNewChar);

		String thirdOldChar = ",, ";
		String thirdNewChar = ",";
		tempSb = tempSb.replaceAll(thirdOldChar, thirdNewChar);

		if (tempSb.lastIndexOf(", ") == tempSb.length() - 2) {
			tempSb = tempSb.substring(0, tempSb.lastIndexOf(", "));
		}

		return tempSb;
	}
}
