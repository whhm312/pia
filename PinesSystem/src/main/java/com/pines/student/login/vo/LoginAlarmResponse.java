package com.pines.student.login.vo;

public class LoginAlarmResponse {
	private int alarmSeq;
	private String message;
	private String sender;
	private String sendDate;

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

	@Override
	public String toString() {
		return "LoginAlarmResponse [alarmSeq=" + alarmSeq + ", message=" + message + ", sender=" + sender + ", sendDate=" + sendDate + "]";
	}

}
