package com.pines.student.login.vo;

import java.util.ArrayList;
import java.util.List;

import com.pines.student.common.vo.Activity;
import com.pines.student.common.vo.Alarm;
import com.pines.student.common.vo.EmergencyContact;
import com.pines.student.common.vo.Notice;

public class StudentAutoLoginResponse {
	private boolean isTraveling;
	private boolean isBlocked;
	private List<LoginActivityResponse> activities;
	private List<LoginNoticeResponse> notices;
	private List<LoginAlarmResponse> alarms;
	private List<LoginEmergencyContactResponse> emergencyContacts;

	public boolean getIsTraveling() {
		return isTraveling;
	}

	public void setIsTraveling(boolean isTraveling) {
		this.isTraveling = isTraveling;
	}

	public boolean getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public List<LoginActivityResponse> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = new ArrayList<LoginActivityResponse>();

		LoginActivityResponse response = null;
		for (Activity activity : activities) {
			response = new LoginActivityResponse();
			response.setActivitySeq(activity.getActivitySeq());
			response.setContent(activity.getContent());
			response.setTitle(activity.getTitle());
			response.setAcceptStartDate(activity.getFormStartDate());
			response.setAcceptEndDate(activity.getFormEndDate());

			this.activities.add(response);
		}
	}

	public List<LoginNoticeResponse> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = new ArrayList<LoginNoticeResponse>();
		LoginNoticeResponse response = null;

		for (Notice notice : notices) {
			response = new LoginNoticeResponse();
			response.setNoticeSeq(notice.getNoticeSeq());
			response.setTitle(notice.getTitle());
			response.setContent(notice.getContent());
			response.setWriter(notice.getWriter());
			response.setRegisterDate(notice.getFormStartDate());

			this.notices.add(response);
		}
	}

	public List<LoginAlarmResponse> getAlarms() {
		return alarms;
	}

	public void setAlarms(List<Alarm> alarms) {
		this.alarms = new ArrayList<LoginAlarmResponse>();

		LoginAlarmResponse response = null;
		for (Alarm alarm : alarms) {
			response = new LoginAlarmResponse();
			response.setAlarmSeq(alarm.getAlarmSeq());
			response.setMessage(alarm.getMessage());
			response.setSendDate(alarm.getFormSendDate());
			response.setSender(alarm.getSender());

			this.alarms.add(response);
		}
	}

	public List<LoginEmergencyContactResponse> getEmergencyContacts() {
		return emergencyContacts;
	}

	public void setEmergencyContacts(List<EmergencyContact> emergencyContacts) {
		this.emergencyContacts = new ArrayList<LoginEmergencyContactResponse>();
		LoginEmergencyContactResponse response = null;

		for (EmergencyContact piaEmergencyContact : emergencyContacts) {
			response = new LoginEmergencyContactResponse();
			response.setNationality(piaEmergencyContact.getNationalityAlphaThree());
			response.setName(piaEmergencyContact.getName());
			response.setContact(piaEmergencyContact.getEmergencyContact());

			this.emergencyContacts.add(response);
		}
	}

	@Override
	public String toString() {
		return "StudentAutoLoginResponse [isTraveling=" + isTraveling + ", isBlocked=" + isBlocked + ", activities=" + activities + ", notices=" + notices + ", alarms=" + alarms + ", emergencyContacts=" + emergencyContacts + "]";
	}

}
