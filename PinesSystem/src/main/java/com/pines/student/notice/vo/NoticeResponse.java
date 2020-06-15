package com.pines.student.notice.vo;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Notice;

public class NoticeResponse {
	private String branch;
	private String language;
	private int languageSeq;
	private String title;
	private String content;
	private String writer;
	private boolean hasAttachment;
	private String fileDownloadUrl;
	private String downloadFilename;
	private String registerDate;
	private boolean isTopOfList;
	private boolean isPopup;
	private String popupStartDate;
	private String popupEndDate;
	private boolean isForAll;

	public NoticeResponse(Notice notice) {
		branch = Tools.blankInsteadOfNull(notice.getBranch());
		language = Tools.blankInsteadOfNull(notice.getLanguage());
		languageSeq = notice.getLanguageSeq();
		title = Tools.blankInsteadOfNull(notice.getTitle());
		content = notice.getContent();
		writer = Tools.blankInsteadOfNull(notice.getWriter());
		hasAttachment = notice.hasAttachment();
		fileDownloadUrl = Tools.blankInsteadOfNull(notice.getFileDownloadUrl());
		downloadFilename = Tools.blankInsteadOfNull(notice.getOriginalFilename());
		registerDate = Tools.blankInsteadOfNull(notice.getFormRegisterDate());
		isTopOfList = notice.getIsTopOfList();
		isPopup = notice.getIsPopup();
		popupStartDate = Tools.blankInsteadOfNull(notice.getFormPopupStartDate());
		popupEndDate = Tools.blankInsteadOfNull(notice.getFormPopupEndDate());
		isForAll = notice.getIsForAll();
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getLanguageSeq() {
		return languageSeq;
	}

	public void setLanguageSeq(int languageSeq) {
		this.languageSeq = languageSeq;
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

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public boolean getIsTopOfList() {
		return isTopOfList;
	}

	public void setIsTopOfList(boolean isTopOfList) {
		this.isTopOfList = isTopOfList;
	}

	public boolean getIsPopup() {
		return isPopup;
	}

	public void setIsPopup(boolean isPopup) {
		this.isPopup = isPopup;
	}

	public String getPopupStartDate() {
		return popupStartDate;
	}

	public void setPopupStartDate(String popupStartDate) {
		this.popupStartDate = popupStartDate;
	}

	public String getPopupEndDate() {
		return popupEndDate;
	}

	public void setPopupEndDate(String popupEndDate) {
		this.popupEndDate = popupEndDate;
	}

	public String getDownloadFilename() {
		return downloadFilename;
	}

	public void setDownloadFilename(String downloadFilename) {
		this.downloadFilename = downloadFilename;
	}

	public void setTopOfList(boolean isTopOfList) {
		this.isTopOfList = isTopOfList;
	}

	public void setPopup(boolean isPopup) {
		this.isPopup = isPopup;
	}

	public boolean getIsForAll() {
		return isForAll;
	}

	public void setIsForAll(boolean isForAll) {
		this.isForAll = isForAll;
	}

	@Override
	public String toString() {
		return "NoticeResponse [branch=" + branch + ", language=" + language + ", languageSeq=" + languageSeq + ", title=" + title + ", content=" + content + ", writer=" + writer + ", hasAttachment=" + hasAttachment + ", fileDownloadUrl=" + fileDownloadUrl + ", downloadFilename="
				+ downloadFilename + ", registerDate=" + registerDate + ", isTopOfList=" + isTopOfList + ", isPopup=" + isPopup + ", popupStartDate=" + popupStartDate + ", popupEndDate=" + popupEndDate + ", isForAll=" + isForAll + "]";
	}

}
