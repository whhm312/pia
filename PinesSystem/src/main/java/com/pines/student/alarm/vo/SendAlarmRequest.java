package com.pines.student.alarm.vo;

import com.pines.student.common.vo.Alarm;

public class SendAlarmRequest {
	private String studentId;
	private String message;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SendAlarmRequest [studentId=" + studentId + ", message=" + message + "]";
	}

	public Alarm getAlarm(String sendId) {
		Alarm result = new Alarm();
		result.setMessage(message);
		result.setReceiveId(studentId);
		result.setSendId(sendId);
		return result;
	}

}
