package com.pines.student.common.vo;

public class Activity {
	private int activitySeq;
	private int campusSeq;
	private String title;
	private StringBuffer content;
	private String writerId;
	private String writer;
	private String acceptStartDate;
	private String acceptEndDate;
	private String formStartDate;
	private String formEndDate;
	private boolean hasAttachment;
	private StringBuffer attachmentFile;
	private String status;
	private String registerDate;
	private String formRegisterDate;
	private boolean isDeleted;

	public int getActivitySeq() {
		return activitySeq;
	}

	public void setActivitySeq(int activitySeq) {
		this.activitySeq = activitySeq;
	}

	public int getCampusSeq() {
		return campusSeq;
	}

	public void setCampusSeq(int campusSeq) {
		this.campusSeq = campusSeq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public StringBuffer getContent() {
		return content;
	}

	public void setContent(StringBuffer content) {
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

	public String getAcceptStartDate() {
		return acceptStartDate;
	}

	public void setAcceptStartDate(String acceptStartDate) {
		this.acceptStartDate = acceptStartDate;
	}

	public String getAcceptEndDate() {
		return acceptEndDate;
	}

	public void setAcceptEndDate(String acceptEndDate) {
		this.acceptEndDate = acceptEndDate;
	}

	public boolean isHasAttachment() {
		return hasAttachment;
	}

	public void setHasAttachment(boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	public StringBuffer getAttachmentFile() {
		return attachmentFile;
	}

	public void setAttachmentFile(StringBuffer attachmentFile) {
		this.attachmentFile = attachmentFile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Activity [activitySeq=" + activitySeq + ", campusSeq=" + campusSeq + ", title=" + title + ", content=" + content + ", writerId=" + writerId + ", writer=" + writer + ", acceptStartDate=" + acceptStartDate + ", acceptEndDate=" + acceptEndDate + ", formStartDate="
				+ formStartDate + ", formEndDate=" + formEndDate + ", hasAttachment=" + hasAttachment + ", attachmentFile=" + attachmentFile + ", status=" + status + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + ", isDeleted=" + isDeleted + "]";
	}

}
