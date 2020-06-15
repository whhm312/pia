package com.pines.student.entrance.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.SearchCondition;

public class EntrancesRecordsRequest {

	public SearchCondition getConditions(int branchSeq, int campusSeq, Map<String, String> parameters, List<String> overtimeExceptionStartTimes, List<String> overtimeExceptionEndTimes) {
		int selectedPage = Tools.getInt(parameters.get("selectedPage"));
		int offset = Tools.getInt(parameters.get("offset"));

		if (selectedPage < 1) {
			selectedPage = 1;
		}

		if (offset < 1) {
			offset = 10;
		}

		SearchCondition result = new SearchCondition();
		result.setIsExcelDownload(Tools.getBoolean(parameters.get("isExcelDownload")));
		result.setBranchSeq(branchSeq);
		result.setCampusSeq(campusSeq);
		result.setEntranceSeq(Tools.getInt(parameters.get("entranceSeq")));
		result.setSelectedPage(selectedPage);
		result.setOffset(offset);
		result.setSearchSection(Tools.blankInsteadOfNull(parameters.get("searchSection")));
		if (overtimeExceptionStartTimes == null) {
			result.setOvertimeExceptionStartTimes(new ArrayList<String>());
		} else {
			result.setOvertimeExceptionStartTimes(overtimeExceptionStartTimes);
		}
		if (overtimeExceptionEndTimes == null) {
			result.setOvertimeExceptionEndTimes(new ArrayList<String>());
		} else {
			result.setOvertimeExceptionEndTimes(overtimeExceptionEndTimes);
		}

		if ("CURFEW".equals(result.getSearchSection())) {
			result.setSearchDate(Tools.blankInsteadOfNull(parameters.get("searchDate")));
			result.setLimitedHour(Tools.getInt(parameters.get("limitedHour")));
			result.setLimitedMinute(Tools.getInt(parameters.get("limitedMinute")));
			result.setMaximumMinute(Tools.getInt(parameters.get("maximumMinute")));
		} else if ("ORVERTIME".equals(result.getSearchSection())) {
			result.setStartDate(Tools.blankInsteadOfNull(parameters.get("startDate")));
			result.setEndDate(Tools.blankInsteadOfNull(parameters.get("endDate")));
			result.setMaximumMinute(Tools.getInt(parameters.get("maximumMinute")));
		} else if ("INCOMPLETE".equals(result.getSearchSection())) {
			result.setStartDate(Tools.blankInsteadOfNull(parameters.get("startDate")));
			result.setEndDate(Tools.blankInsteadOfNull(parameters.get("endDate")));
		} else if ("OUTING".equals(result.getSearchSection())) {
			result.setSearchRoom(Tools.blankInsteadOfNull(parameters.get("searchRoom")));
		} else if ("RECORD".equals(result.getSearchSection())) {
			result.setStartDate(Tools.blankInsteadOfNull(parameters.get("startDate")));
			result.setEndDate(Tools.blankInsteadOfNull(parameters.get("endDate")));
		}

		result.setIsUnlimitedSearch(Tools.getBoolean(parameters.get("isUnlimitedSearch")));
		result.setSearchType(Tools.blankInsteadOfNull(parameters.get("searchType")));
		result.setSearchValue(Tools.blankInsteadOfNull(parameters.get("searchValue")));

		return result;
	}
}
