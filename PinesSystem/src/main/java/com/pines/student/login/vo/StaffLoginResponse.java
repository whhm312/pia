package com.pines.student.login.vo;

import java.util.List;

public class StaffLoginResponse {
	private int branchSeq;
	private String siteAuthorization;
	private List<CookieDataResponse> branches;
	private List<LoginCampusResponse> campuses;
	private List<CookieDataResponse> languages;
	private String staffName;

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public String getSiteAuthorization() {
		return siteAuthorization;
	}

	public void setSiteAuthorization(String siteAuthorization) {
		this.siteAuthorization = siteAuthorization;
	}

	public List<CookieDataResponse> getBranches() {
		return branches;
	}

	public void setBranches(List<CookieDataResponse> branches) {
		this.branches = branches;
	}

	public List<LoginCampusResponse> getCampuses() {
		return campuses;
	}

	public void setCampuses(List<LoginCampusResponse> campuses) {
		this.campuses = campuses;
	}

	public List<CookieDataResponse> getLanguages() {
		return languages;
	}

	public void setLanguages(List<CookieDataResponse> languages) {
		this.languages = languages;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Override
	public String toString() {
		return "StaffLoginResponse [branchSeq=" + branchSeq + ", siteAuthorization=" + siteAuthorization + ", branches=" + branches + ", campuses=" + campuses + ", languages=" + languages + ", staffName=" + staffName + "]";
	}

}
