package com.pines.student.guide.vo;

import org.springframework.web.multipart.MultipartFile;

import com.pines.student.common.vo.FreshmanGuide;

public class ChangeFreshmanGuideRequest {
	private int branchSeq;
	private int guideSeq;
	private String writerId;
	private String title;
	private String content;
	private boolean hasAttachment;
	private String fileDownloadUrl;
	private MultipartFile attachment;
	private boolean isDeleteAttachment;

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getGuideSeq() {
		return guideSeq;
	}

	public void setGuideSeq(int guideSeq) {
		this.guideSeq = guideSeq;
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

	public String getFileDownloadUrl() {
		return fileDownloadUrl;
	}

	public void setFileDownloadUrl(String fileDownloadUrl) {
		this.fileDownloadUrl = fileDownloadUrl;
	}

	public MultipartFile getAttachment() {
		return attachment;
	}

	public void setAttachment(MultipartFile attachment) {
		this.attachment = attachment;
	}

	public boolean isDeleteAttachment() {
		return isDeleteAttachment;
	}

	public void setDeleteAttachment(boolean isDeleteAttachment) {
		this.isDeleteAttachment = isDeleteAttachment;
	}

	public boolean getIsDeleteAttachment() {
		return isDeleteAttachment;
	}

	public void setIsDeleteAttachment(boolean isDeleteAttachment) {
		this.isDeleteAttachment = isDeleteAttachment;
	}

	@Override
	public String toString() {
		return "ChangeFreshmanGuideRequest [branchSeq=" + branchSeq + ", guideSeq=" + guideSeq + ", writerId=" + writerId + ", title=" + title + ", content=" + content + ", hasAttachment=" + hasAttachment + ", fileDownloadUrl=" + fileDownloadUrl + ", attachment=" + attachment
				+ ", isDeleteAttachment=" + isDeleteAttachment + "]";
	}

	public FreshmanGuide getFreshmanGuide() {
		FreshmanGuide result = new FreshmanGuide();
		result.setBranchSeq(branchSeq);
		result.setFreshmanGuideSeq(guideSeq);
		result.setTitle(title);
		result.setContent(content);
		result.setWriterId(writerId);
		result.setHasAttachment(hasAttachment);
		result.setIsDeleteAttachment(isDeleteAttachment);
		return result;
	}

}
