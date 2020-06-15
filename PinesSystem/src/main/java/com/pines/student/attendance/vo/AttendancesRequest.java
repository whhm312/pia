package com.pines.student.attendance.vo;

import com.pines.student.common.vo.SearchCondition;

public class AttendancesRequest {
	private int selectedPage;
	private int offset;
	private String classDate;

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

	public String getClassDate() {
		return classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}

	@Override
	public String toString() {
		return "AttendancesRequest [selectedPage=" + selectedPage + ", offset=" + offset + ", classDate=" + classDate + "]";
	}

	public SearchCondition getConditions(int branchSeq, int campusSeq) {
		SearchCondition result = new SearchCondition();
		result.setBranchSeq(branchSeq);
		result.setCampusSeq(campusSeq);
		result.setOffset(offset);
		result.setSelectedPage(selectedPage);
		result.setClassDate(classDate);
		return result;
	}

}
