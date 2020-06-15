package com.pines.student.guide.vo;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.FreshmanGuide;

public class FreshmanGuideResponse {
	private int branchSeq;
	private int nationalitySeq;
	private int groupSeq;
	private String writer;
	private String title;
	private String content;
	private String branch;
	private String nationality;
	private String groupName;
	private boolean hasAttachment;
	private String fileDownloadUrl;
	private String downloadFilename;
	private String registerDate;

	public FreshmanGuideResponse(FreshmanGuide guide) {
		branchSeq = guide.getBranchSeq();
		nationalitySeq = guide.getNationalitySeq();
		groupSeq = guide.getStudentGroupSeq();
		writer = Tools.blankInsteadOfNull(guide.getWriter());
		title = Tools.blankInsteadOfNull(guide.getTitle());
		content = guide.getContent();
		branch = Tools.blankInsteadOfNull(guide.getBranch());
		nationality = Tools.blankInsteadOfNull(guide.getNationality());
		groupName = Tools.blankInsteadOfNull(guide.getGroupName());
		hasAttachment = guide.hasAttachment();
		fileDownloadUrl = Tools.blankInsteadOfNull(guide.getFileDownloadUrl());
		downloadFilename = Tools.blankInsteadOfNull(guide.getOriginalFilename());
		registerDate = Tools.blankInsteadOfNull(guide.getFormRegisterDate());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public boolean isHasAttachment() {
		return hasAttachment;
	}

	public void setHasAttachment(boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	public String getFileDownloadUrl() {
		return fileDownloadUrl;
	}

	public void setFileDownloadUrl(String fileDownloadUrl) {
		this.fileDownloadUrl = fileDownloadUrl;
	}

	public String getDownloadFilename() {
		return downloadFilename;
	}

	public void setDownloadFilename(String downloadFilename) {
		this.downloadFilename = downloadFilename;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getNationalitySeq() {
		return nationalitySeq;
	}

	public void setNationalitySeq(int nationalitySeq) {
		this.nationalitySeq = nationalitySeq;
	}

	public int getGroupSeq() {
		return groupSeq;
	}

	public void setGroupSeq(int groupSeq) {
		this.groupSeq = groupSeq;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "FreshmanGuideResponse [branchSeq=" + branchSeq + ", nationalitySeq=" + nationalitySeq + ", groupSeq=" + groupSeq + ", writer=" + writer + ", title=" + title + ", content=" + content + ", branch=" + branch + ", nationality=" + nationality + ", groupName="
				+ groupName + ", hasAttachment=" + hasAttachment + ", fileDownloadUrl=" + fileDownloadUrl + ", downloadFilename=" + downloadFilename + ", registerDate=" + registerDate + "]";
	}

}
