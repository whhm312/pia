package com.pines.student.notice.vo;

import org.springframework.web.multipart.MultipartFile;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Notice;

public class ChangeNoticeRequest {
	private int branchSeq;
	private int noticeSeq;
	private String writerId;
	private String title;
	private String content;
	private boolean hasAttachment;
	private boolean isTopOfList;
	private boolean isPopup;
	private String popupStartDate;
	private String popupEndDate;
	private MultipartFile attachment;
	private boolean isDeleteAttachment;

	public Notice getNotice() {
		Notice notice = new Notice();
		notice.setBranchSeq(branchSeq);
		notice.setNoticeSeq(noticeSeq);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setHasAttachment(hasAttachment);
		notice.setIsTopOfList(isTopOfList);
		notice.setIsPopup(isPopup);
		notice.setPopupStartDate(Tools.isEmpty(popupStartDate) ? null : popupStartDate);
		notice.setPopupEndDate(Tools.isEmpty(popupEndDate) ? null : popupEndDate);
		notice.setIsDeleteAttachment(isDeleteAttachment);
		return notice;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getNoticeSeq() {
		return noticeSeq;
	}

	public void setNoticeSeq(int noticeSeq) {
		this.noticeSeq = noticeSeq;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
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

	public MultipartFile getAttachment() {
		return attachment;
	}

	public void setAttachment(MultipartFile attachment) {
		this.attachment = attachment;
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

	@Override
	public String toString() {
		return "ChangeNoticeRequest [branchSeq=" + branchSeq + ", noticeSeq=" + noticeSeq + ", writerId=" + writerId + ", title=" + title + ", content=" + content + ", hasAttachment=" + hasAttachment + ", isTopOfList=" + isTopOfList + ", isPopup=" + isPopup + ", popupStartDate="
				+ popupStartDate + ", popupEndDate=" + popupEndDate + ", attachment=" + attachment + ", isDeleteAttachment=" + isDeleteAttachment + "]";
	}

}
