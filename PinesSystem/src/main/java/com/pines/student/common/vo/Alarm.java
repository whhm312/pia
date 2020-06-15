package com.pines.student.common.vo;

public class Alarm {
	private int alarmSeq;
	private String message;
	private String sendId;
	private String sender;
	private String sendDate;
	private String formSendDate;
	private String receiveId;
	private String receiver;
	private boolean isRead;
	private String readDate;
	private String formReadDate;

	public int getAlarmSeq() {
		return alarmSeq;
	}

	public void setAlarmSeq(int alarmSeq) {
		this.alarmSeq = alarmSeq;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
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

	public String getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public String getReadDate() {
		return readDate;
	}

	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}

	public String getFormReadDate() {
		return formReadDate;
	}

	public void setFormReadDate(String formReadDate) {
		this.formReadDate = formReadDate;
	}

	@Override
	public String toString() {
		return "Alarm [alarmSeq=" + alarmSeq + ", message=" + message + ", sendId=" + sendId + ", sender=" + sender + ", sendDate=" + sendDate + ", formSendDate=" + formSendDate + ", receiveId=" + receiveId + ", receiver=" + receiver + ", isRead=" + isRead + ", readDate="
				+ readDate + ", formReadDate=" + formReadDate + "]";
	}

}
