package com.pines.student.room.vo;

import com.pines.student.common.vo.StudentRoom;

public class ChangeRoomRequest {
	private String checkInDate;
	private String checkOutDate;

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@Override
	public String toString() {
		return "ChangeRoomRequest [checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + "]";
	}

	public StudentRoom getRequest(String staffId, String roomName, String studentId) {
		StudentRoom result = new StudentRoom();
		return result;
	}

}
