package com.pines.student.common.vo;

import java.util.Arrays;
import java.util.List;

import com.pines.student.common.Tools;

public class SearchCondition {
	private int selectedPage;
	private int offset;
	private int branchSeq;
	private int campusSeq;
	private int nationalitySeq;
	private int languageSeq;
	private int termSeq;
	private int groupSeq;
	private int[] campusSeqs;
	private int[] languageSeqs;
	private boolean isTopOfList;
	private boolean isPopup;
	private String writer;
	private String titleContent;
	private int[] nationalitySeqs;
	private String term;
	private String roomState;
	private String studyState;
	private List<String> statuses;
	private String name;
	private String examType;
	private String[] examTypes;
	private String classDate;
	private int levelSeq;
	private boolean isForAll;
	private int termDetailSeq;
	private String startDate;
	private String endDate;
	private String searchDate;
	private int limitedHour;
	private int limitedMinute;
	private int maximumMinute;
	private int entranceSeq;
	private String searchType;
	private String searchValue;
	private String searchSection;
	private List<String> overtimeExceptionStartTimes;
	private List<String> overtimeExceptionEndTimes;
	private boolean isExcelDownload;
	private String searchRoom;
	private boolean isUnlimitedSearch;

	public int getSelectedPage() {
		return selectedPage;
	}

	public void setSelectedPage(int selectedPage) {
		this.selectedPage = selectedPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getStartIndex() {
		return Tools.getStartIndex(selectedPage, offset);
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getCampusSeq() {
		return campusSeq;
	}

	public void setCampusSeq(int campusSeq) {
		this.campusSeq = campusSeq;
	}

	public boolean isCampusCondition() {
		return campusSeq > 0;
	}

	public int getNationalitySeq() {
		return nationalitySeq;
	}

	public void setNationalitySeq(int nationalitySeq) {
		this.nationalitySeq = nationalitySeq;
	}

	public boolean isNationalityCondition() {
		return nationalitySeq > 0;
	}

	public int getLanguageSeq() {
		return languageSeq;
	}

	public void setLanguageSeq(int languageSeq) {
		this.languageSeq = languageSeq;
	}

	public boolean isLanguageCondition() {
		return languageSeq > 0;
	}

	public int getTermSeq() {
		return termSeq;
	}

	public void setTermSeq(int termSeq) {
		this.termSeq = termSeq;
	}

	public boolean hasTermSeqCondition() {
		return this.termSeq > 0;
	}

	public int getGroupSeq() {
		return groupSeq;
	}

	public void setGroupSeq(int groupSeq) {
		this.groupSeq = groupSeq;
	}

	public boolean isGroupCondition() {
		return groupSeq > 0;
	}

	public int[] getLanguageSeqs() {
		return languageSeqs;
	}

	public void setLanguageSeqs(int[] languageSeqs) {
		this.languageSeqs = languageSeqs;
	}

	public boolean isLanguagesCondition() {
		return languageSeqs.length > 0;
	}

	public int[] getCampusSeqs() {
		return campusSeqs;
	}

	public void setCampusSeqs(int[] campusSeqs) {
		this.campusSeqs = campusSeqs;
	}

	public boolean isCampusesCondition() {
		return campusSeqs.length > 0;
	}

	public boolean isTopOfList() {
		return isTopOfList;
	}

	public void setTopOfList(boolean isTopOfList) {
		this.isTopOfList = isTopOfList;
	}

	public boolean getIsPopup() {
		return isPopup;
	}

	public void setIsPopup(boolean isPopup) {
		this.isPopup = isPopup;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public boolean isWriterCondition() {
		return !Tools.isEmpty(writer);
	}

	public String getTitleContent() {
		return titleContent;
	}

	public void setTitleContent(String titleContent) {
		this.titleContent = titleContent;
	}

	public boolean isTitleContentCondition() {
		return !Tools.isEmpty(titleContent);
	}

	public int[] getNationalitySeqs() {
		return nationalitySeqs;
	}

	public void setNationalitySeqs(int[] nationalitySeqs) {
		this.nationalitySeqs = nationalitySeqs;
	}

	public boolean isNationalitiesCondition() {
		return nationalitySeqs.length > 0;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public boolean isTermCondition() {
		return !Tools.isEmpty(term);
	}

	public String getRoomState() {
		return roomState;
	}

	public void setRoomState(String roomState) {
		this.roomState = roomState;
	}

	public boolean isRoomStateCondition() {
		return !Tools.isEmpty(roomState);
	}

	public String getStudyState() {
		return studyState;
	}

	public void setStudyState(String studyState) {
		this.studyState = studyState;
	}

	public boolean isStudyStateCondition() {
		return !Tools.isEmpty(studyState);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isNameCondition() {
		return !Tools.isEmpty(name);
	}

	public List<String> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<String> statuses) {
		this.statuses = statuses;
	}

	public boolean isStatusesCondition() {
		return !this.statuses.isEmpty();
	}

	public boolean hasExamType() {
		return Tools.isNotEmpty(examType);
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public boolean hasExamTypes() {
		if (examTypes == null) {
			return false;
		}
		return examTypes.length > 0;
	}

	public String[] getExamTypes() {
		return examTypes;
	}

	public void setExamTypes(String[] examTypes) {
		this.examTypes = examTypes;
	}

	public String getClassDate() {
		return classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}

	public boolean isClassDateCondition() {
		return !Tools.isEmpty(classDate);
	}

	public int getLevelSeq() {
		return levelSeq;
	}

	public void setLevelSeq(int levelSeq) {
		this.levelSeq = levelSeq;
	}

	public boolean isLevelSeq() {
		return levelSeq > 0;
	}

	public boolean getIsForAll() {
		return isForAll;
	}

	public void setIsForAll(boolean isForAll) {
		this.isForAll = isForAll;
	}

	public int getTermDetailSeq() {
		return termDetailSeq;
	}

	public void setTermDetailSeq(int termDetailSeq) {
		this.termDetailSeq = termDetailSeq;
	}

	public boolean isTermDetailCondition() {
		return termDetailSeq > 0;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public boolean isStartDateCondition() {
		return Tools.isNotEmpty(startDate);
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public boolean isEndDateCondition() {
		return Tools.isNotEmpty(endDate);
	}

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

	public boolean isSearchDateCondition() {
		return Tools.isNotEmpty(searchDate);
	}

	public int getLimitedHour() {
		return limitedHour;
	}

	public void setLimitedHour(int limitedHour) {
		this.limitedHour = limitedHour;
	}

	public boolean isLimitedHourCondition() {
		return limitedHour > 0;
	}

	public int getLimitedMinute() {
		return limitedMinute;
	}

	public void setLimitedMinute(int limitedMinute) {
		this.limitedMinute = limitedMinute;
	}

	public boolean isLimitedMinuteCondition() {
		return limitedMinute > 0;
	}

	public int getMaximumMinute() {
		return maximumMinute;
	}

	public void setMaximumMinute(int maximumMinute) {
		this.maximumMinute = maximumMinute;
	}

	public boolean isMaximumMinuteCondition() {
		return maximumMinute > 0;
	}

	public int getEntranceSeq() {
		return entranceSeq;
	}

	public void setEntranceSeq(int entranceSeq) {
		this.entranceSeq = entranceSeq;
	}

	public boolean isEntranceSeqCondition() {
		return entranceSeq > 0;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public boolean isSearchTypeCondition() {
		return Tools.isNotEmpty(searchType);
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public boolean isSearchValueCondition() {
		return Tools.isNotEmpty(searchValue);
	}

	public String getSearchSection() {
		return searchSection;
	}

	public void setSearchSection(String searchSection) {
		this.searchSection = searchSection;
	}

	public boolean isSearchSectionCondition() {
		return Tools.isNotEmpty(searchSection);
	}

	public List<String> getOvertimeExceptionStartTimes() {
		return overtimeExceptionStartTimes;
	}

	public void setOvertimeExceptionStartTimes(List<String> overtimeExceptionStartTimes) {
		this.overtimeExceptionStartTimes = overtimeExceptionStartTimes;
	}

	public boolean isOvertimeExceptionStartTimesCondition() {
		return overtimeExceptionStartTimes.size() > 0;
	}

	public List<String> getOvertimeExceptionEndTimes() {
		return overtimeExceptionEndTimes;
	}

	public void setOvertimeExceptionEndTimes(List<String> overtimeExceptionEndTimes) {
		this.overtimeExceptionEndTimes = overtimeExceptionEndTimes;
	}

	public boolean isOvertimeExceptionEndTimesCondition() {
		return overtimeExceptionEndTimes.size() > 0;
	}

	public boolean isOvertimeExceptionTimesCondition() {
		return isOvertimeExceptionEndTimesCondition() && isOvertimeExceptionStartTimesCondition() && getOvertimeExceptionEndTimes().size() == getOvertimeExceptionStartTimes().size();
	}

	public boolean getIsExcelDownload() {
		return isExcelDownload;
	}

	public void setIsExcelDownload(boolean isExcelDownload) {
		this.isExcelDownload = isExcelDownload;
	}

	public String getSearchRoom() {
		return searchRoom;
	}

	public void setSearchRoom(String searchRoom) {
		this.searchRoom = searchRoom;
	}

	public boolean isSearchRoomCondition() {
		return Tools.isNotEmpty(searchRoom);
	}

	public boolean getIsUnlimitedSearch() {
		return isUnlimitedSearch;
	}

	public void setIsUnlimitedSearch(boolean isUnlimitedSearch) {
		this.isUnlimitedSearch = isUnlimitedSearch;
	}

	@Override
	public String toString() {
		return "SearchCondition [selectedPage=" + selectedPage + ", offset=" + offset + ", branchSeq=" + branchSeq + ", campusSeq=" + campusSeq + ", nationalitySeq=" + nationalitySeq + ", languageSeq=" + languageSeq + ", termSeq=" + termSeq + ", groupSeq=" + groupSeq
				+ ", campusSeqs=" + Arrays.toString(campusSeqs) + ", languageSeqs=" + Arrays.toString(languageSeqs) + ", isTopOfList=" + isTopOfList + ", isPopup=" + isPopup + ", writer=" + writer + ", titleContent=" + titleContent + ", nationalitySeqs="
				+ Arrays.toString(nationalitySeqs) + ", term=" + term + ", roomState=" + roomState + ", studyState=" + studyState + ", statuses=" + statuses + ", name=" + name + ", examType=" + examType + ", examTypes=" + Arrays.toString(examTypes) + ", classDate=" + classDate
				+ ", levelSeq=" + levelSeq + ", isForAll=" + isForAll + ", termDetailSeq=" + termDetailSeq + ", startDate=" + startDate + ", endDate=" + endDate + ", searchDate=" + searchDate + ", limitedHour=" + limitedHour + ", limitedMinute=" + limitedMinute
				+ ", maximumMinute=" + maximumMinute + ", entranceSeq=" + entranceSeq + ", searchType=" + searchType + ", searchValue=" + searchValue + ", searchSection=" + searchSection + ", overtimeExceptionStartTimes=" + overtimeExceptionStartTimes
				+ ", overtimeExceptionEndTimes=" + overtimeExceptionEndTimes + ", isExcelDownload=" + isExcelDownload + ", searchRoom=" + searchRoom + ", isUnlimitedSearch=" + isUnlimitedSearch + "]";
	}

}
