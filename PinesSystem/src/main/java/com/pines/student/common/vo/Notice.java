package com.pines.student.common.vo;

public class Notice {
	private int totalCount;
	private int noticeSeq;
	private int branchSeq;
	private int languageSeq;
	private String language;
	private String branch;
	private String title;
	private String content;
	private String writerId;
	private String writer;
	private String type;
	private String topOfList;
	private boolean hasAttachment;
	private String fileDownloadUrl;
	private String originalFilename;
	private boolean isTopOfList;
	private boolean isPopup;
	private String popupStartDate;
	private String popupEndDate;
	private String registerDate;
	private String formStartDate;
	private String formEndDate;
	private String formRegisterDate;
	private String formShortRegisterDate;
	private String formPopupStartDate;
	private String formPopupEndDate;
	private boolean isDeleted;
	private boolean isDeleteAttachment;
	private boolean isForAll;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getNoticeSeq() {
		return noticeSeq;
	}

	public void setNoticeSeq(int noticeSeq) {
		this.noticeSeq = noticeSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getLanguageSeq() {
		return languageSeq;
	}

	public void setLanguageSeq(int languageSeq) {
		this.languageSeq = languageSeq;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
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

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean hasAttachment() {
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

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getFormStartDate() {
		return formStartDate;
	}

	public void setFormStartDate(String formStartDate) {
		this.formStartDate = formStartDate;
	}

	public String getFormEndDate() {
		return formEndDate;
	}

	public void setFormEndDate(String formEndDate) {
		this.formEndDate = formEndDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public String getFormShortRegisterDate() {
		return formShortRegisterDate;
	}

	public void setFormShortRegisterDate(String formShortRegisterDate) {
		this.formShortRegisterDate = formShortRegisterDate;
	}

	public String getFormPopupStartDate() {
		return formPopupStartDate;
	}

	public void setFormPopupStartDate(String formPopupStartDate) {
		this.formPopupStartDate = formPopupStartDate;
	}

	public String getFormPopupEndDate() {
		return formPopupEndDate;
	}

	public void setFormPopupEndDate(String formPopupEndDate) {
		this.formPopupEndDate = formPopupEndDate;
	}

	public boolean isHasAttachment() {
		return hasAttachment;
	}

	public void setTopOfList(boolean isTopOfList) {
		this.isTopOfList = isTopOfList;
	}

	public void setPopup(boolean isPopup) {
		this.isPopup = isPopup;
	}

	public boolean getIsDeleteAttachment() {
		return isDeleteAttachment;
	}

	public void setIsDeleteAttachment(boolean isDeleteAttachment) {
		this.isDeleteAttachment = isDeleteAttachment;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public void setDeleteAttachment(boolean isDeleteAttachment) {
		this.isDeleteAttachment = isDeleteAttachment;
	}

	public String getTopOfList() {
		return topOfList;
	}

	public void setTopOfList(String topOfList) {
		this.topOfList = topOfList;
	}

	public boolean getIsForAll() {
		return isForAll;
	}

	public void setIsForAll(boolean isForAll) {
		this.isForAll = isForAll;
	}

	@Override
	public String toString() {
		return "Notice [totalCount=" + totalCount + ", noticeSeq=" + noticeSeq + ", branchSeq=" + branchSeq + ", languageSeq=" + languageSeq + ", language=" + language + ", branch=" + branch + ", title=" + title + ", content=" + content + ", writerId=" + writerId + ", writer="
				+ writer + ", type=" + type + ", topOfList=" + topOfList + ", hasAttachment=" + hasAttachment + ", fileDownloadUrl=" + fileDownloadUrl + ", originalFilename=" + originalFilename + ", isTopOfList=" + isTopOfList + ", isPopup=" + isPopup + ", popupStartDate="
				+ popupStartDate + ", popupEndDate=" + popupEndDate + ", registerDate=" + registerDate + ", formStartDate=" + formStartDate + ", formEndDate=" + formEndDate + ", formRegisterDate=" + formRegisterDate + ", formShortRegisterDate=" + formShortRegisterDate
				+ ", formPopupStartDate=" + formPopupStartDate + ", formPopupEndDate=" + formPopupEndDate + ", isDeleted=" + isDeleted + ", isDeleteAttachment=" + isDeleteAttachment + ", isForAll=" + isForAll + "]";
	}

}
