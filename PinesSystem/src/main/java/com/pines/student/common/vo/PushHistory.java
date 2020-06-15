package com.pines.student.common.vo;

public class PushHistory {
	private int pushHistorySeq;
	private String receiverStudentId;
	private int receiverStudentDeviceSeq;
	private int receiverStudySeq;
	private int receiverNoticeSeq;
	private int receiverExamSeq;
	private int receiverRequestSeq;
	private String senderStaffId;
	private String sendMenu;
	private String sendDate;
	private String formSendDate;
	private int sendTotalCount;
	private String message;
	private String title;
	private String imageUrl;
	private String site;

	public int getPushHistorySeq() {
		return pushHistorySeq;
	}

	public void setPushHistorySeq(int pushHistorySeq) {
		this.pushHistorySeq = pushHistorySeq;
	}

	public String getReceiverStudentId() {
		return receiverStudentId;
	}

	public void setReceiverStudentId(String receiverStudentId) {
		this.receiverStudentId = receiverStudentId;
	}

	public int getReceiverStudentDeviceSeq() {
		return receiverStudentDeviceSeq;
	}

	public void setReceiverStudentDeviceSeq(int receiverStudentDeviceSeq) {
		this.receiverStudentDeviceSeq = receiverStudentDeviceSeq;
	}

	public int getReceiverStudySeq() {
		return receiverStudySeq;
	}

	public void setReceiverStudySeq(int receiverStudySeq) {
		this.receiverStudySeq = receiverStudySeq;
	}

	public int getReceiverNoticeSeq() {
		return receiverNoticeSeq;
	}

	public void setReceiverNoticeSeq(int receiverNoticeSeq) {
		this.receiverNoticeSeq = receiverNoticeSeq;
	}

	public int getReceiverExamSeq() {
		return receiverExamSeq;
	}

	public void setReceiverExamSeq(int receiverExamSeq) {
		this.receiverExamSeq = receiverExamSeq;
	}

	public int getReceiverRequestSeq() {
		return receiverRequestSeq;
	}

	public void setReceiverRequestSeq(int receiverRequestSeq) {
		this.receiverRequestSeq = receiverRequestSeq;
	}

	public String getSenderStaffId() {
		return senderStaffId;
	}

	public void setSenderStaffId(String senderStaffId) {
		this.senderStaffId = senderStaffId;
	}

	public String getSendMenu() {
		return sendMenu;
	}

	public void setSendMenu(String sendMenu) {
		this.sendMenu = sendMenu;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getFormSendDate() {
		return formSendDate;
	}

	public void setFormSendDate(String formSendDate) {
		this.formSendDate = formSendDate;
	}

	public int getSendTotalCount() {
		return sendTotalCount;
	}

	public void setSendTotalCount(int sendTotalCount) {
		this.sendTotalCount = sendTotalCount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "PushHistory [pushHistorySeq=" + pushHistorySeq + ", receiverStudentId=" + receiverStudentId + ", receiverStudentDeviceSeq=" + receiverStudentDeviceSeq + ", receiverStudySeq=" + receiverStudySeq + ", receiverNoticeSeq=" + receiverNoticeSeq
				+ ", receiverExamSeq=" + receiverExamSeq + ", receiverRequestSeq=" + receiverRequestSeq + ", senderStaffId=" + senderStaffId + ", sendMenu=" + sendMenu + ", sendDate=" + sendDate + ", formSendDate=" + formSendDate + ", sendTotalCount=" + sendTotalCount
				+ ", message=" + message + ", title=" + title + ", imageUrl=" + imageUrl + ", site=" + site + "]";
	}

}
