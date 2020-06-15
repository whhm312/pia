package com.pines.student.request.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Request;

public class RequestsRequest {
	private int branchSeq;
	private int selectedPage;
	private int offset;
	private List<String> statuses;
	private List<String> typies;
	private String staff;
	private String student;
	private int campusSeq;

	public RequestsRequest(int branchSeq, List<String> typies, List<String> statuses, Map<String, String> parameters) {
		this.branchSeq = branchSeq;
		this.staff = Tools.blankInsteadOfNull(parameters.get("staff"));
		this.student = Tools.blankInsteadOfNull(parameters.get("student"));
		this.selectedPage = parameters.get("selectedPage") == null ? 0 : Integer.parseInt(parameters.get("selectedPage"));
		this.offset = parameters.get("offset") == null ? 10 : Integer.parseInt(parameters.get("offset"));
		this.campusSeq = Tools.getInt(parameters.get("campusSeq"));
		if (typies == null) {
			this.typies = new ArrayList<String>();
		} else {
			this.typies = typies;
		}

		if (statuses == null) {
			this.statuses = new ArrayList<String>();
		} else {
			this.statuses = statuses;
		}
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getSelectedPage() {
		if (selectedPage < 1) {
			return 0;
		}
		return selectedPage;
	}

	public void setSelectedPage(int selectedPage) {
		this.selectedPage = selectedPage;
	}

	public int getOffset() {
		if (offset < 1) {
			return 10;
		}
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public List<String> getTypies() {
		return typies;
	}

	public void setTypies(List<String> typies) {
		this.typies = typies;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public List<String> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<String> statuses) {
		this.statuses = statuses;
	}

	public int getCampusSeq() {
		return campusSeq;
	}

	public void setCampusSeq(int campusSeq) {
		this.campusSeq = campusSeq;
	}

	@Override
	public String toString() {
		return "RequestsRequest [branchSeq=" + branchSeq + ", selectedPage=" + selectedPage + ", offset=" + offset + ", statuses=" + statuses + ", typies=" + typies + ", staff=" + staff + ", student=" + student + ", campusSeq=" + campusSeq + "]";
	}

	public Request getConditions() {
		Request result = new Request();
		result.setBranchSeq(branchSeq);
		result.setTypies(typies);
		result.setStaff(staff);
		result.setStudent(student);
		result.setStatuses(statuses);
		result.setCampusSeq(campusSeq);
		return result;
	}

}
