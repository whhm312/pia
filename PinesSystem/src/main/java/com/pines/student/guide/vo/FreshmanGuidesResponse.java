package com.pines.student.guide.vo;

public class FreshmanGuidesResponse {
	private int guideSeq;
	private int branchSeq;
	private String branch;
	private String nationality;
	private String group;
	private String title;
	private String writer;
	private String registerDate;
	private boolean hasAttachment;

	public int getGuideSeq() {
		return guideSeq;
	}

	public void setGuideSeq(int guideSeq) {
		this.guideSeq = guideSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public boolean getHasAttachment() {
		return hasAttachment;
	}

	public void setHasAttachment(boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	@Override
	public String toString() {
		return "FreshmanGuidesResponse [guideSeq=" + guideSeq + ", branchSeq=" + branchSeq + ", branch=" + branch + ", nationality=" + nationality + ", group=" + group + ", title=" + title + ", writer=" + writer + ", registerDate=" + registerDate + ", hasAttachment="
				+ hasAttachment + "]";
	}

}
