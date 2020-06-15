package com.pines.student.notice.vo;

import org.springframework.web.multipart.MultipartFile;

import com.pines.student.common.vo.Notice;

public class AddNoticeRequest {
	private int branchSeq;
	private int languageSeq;
	private String writerId;
	private String title;
	private String content;
	private boolean hasAttachment;
	private boolean isTopOfList;
	private boolean isPopup;
	private String popupStartDate;
	private String popupEndDate;
	MultipartFile attachment;
	private boolean isForAll;

	public Notice getNotice() {
		Notice notice = new Notice();
		notice.setBranchSeq(branchSeq);
		notice.setLanguageSeq(languageSeq);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setWriterId(writerId);
		notice.setHasAttachment(hasAttachment);
		notice.setIsTopOfList(isTopOfList);
		notice.setIsPopup(isPopup);
		notice.setPopupStartDate(popupStartDate);
		notice.setPopupEndDate(popupEndDate);
		notice.setIsForAll(isForAll);
		return notice;
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

	public boolean isHasAttachment() {
		return hasAttachment;
	}

	public void setHasAttachment(boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	public void setIsTopOfList(boolean isTopOfList) {
		this.isTopOfList = isTopOfList;
	}

	public boolean getIsTopOfList() {
		return isTopOfList;
	}

	public void setTopOfList(boolean isTopOfList) {
		this.isTopOfList = isTopOfList;
	}

	public void setIsPopup(boolean isPopup) {
		this.isPopup = isPopup;
	}

	public boolean getIsPopup() {
		return isPopup;
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

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public MultipartFile getAttachment() {
		return attachment;
	}

	public void setAttachment(MultipartFile attachment) {
		this.attachment = attachment;
	}

	public boolean getIsForAll() {
		return isForAll;
	}

	public void setIsForAll(boolean isForAll) {
		this.isForAll = isForAll;
	}

	@Override
	public String toString() {
		return "AddNoticeRequest [branchSeq=" + branchSeq + ", languageSeq=" + languageSeq + ", writerId=" + writerId + ", title=" + title + ", content=" + content + ", hasAttachment=" + hasAttachment + ", isTopOfList=" + isTopOfList + ", isPopup=" + isPopup + ", popupStartDate="
				+ popupStartDate + ", popupEndDate=" + popupEndDate + ", attachment=" + attachment + ", isForAll=" + isForAll + "]";
	}

}
