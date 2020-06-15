package com.pines.student.guide.vo;

import org.springframework.web.multipart.MultipartFile;

import com.pines.student.common.vo.FreshmanGuide;

public class AddFreshmanGuideRequest {
	private int branchSeq;
	private int nationalitySeq;
	private String title;
	private String content;
	private String writerId;
	private boolean hasAttachment;
	private String fileDownloadUrl;
	MultipartFile attachment;

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

	@Override
	public String toString() {
		return "AddFreshmanGuideRequest [branchSeq=" + branchSeq + ", nationalitySeq=" + nationalitySeq + ", title=" + title + ", content=" + content + ", writerId=" + writerId + ", hasAttachment=" + hasAttachment + ", fileDownloadUrl=" + fileDownloadUrl + ", attachment="
				+ attachment + "]";
	}

	public FreshmanGuide getFreshmanGuide() {
		FreshmanGuide result = new FreshmanGuide();
		result.setBranchSeq(branchSeq);
		result.setNationalitySeq(nationalitySeq);
		result.setTitle(title);
		result.setContent(content);
		result.setWriterId(writerId);
		result.setHasAttachment(hasAttachment);
		return result;
	}

}
