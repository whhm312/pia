package com.pines.student.student.vo;

import com.pines.student.common.vo.Student;

public class ChangeExtraInformationRequest {
	private String emergencyContact;
	private String relationshipWithEmergencyContact;
	private String localContact;
	private String email;
	private String messengerType;
	private String messengerId;
	private String englishName;

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getRelationshipWithEmergencyContact() {
		return relationshipWithEmergencyContact;
	}

	public void setRelationshipWithEmergencyContact(String relationshipWithEmergencyContact) {
		this.relationshipWithEmergencyContact = relationshipWithEmergencyContact;
	}

	public String getLocalContact() {
		return localContact;
	}

	public void setLocalContact(String localContact) {
		this.localContact = localContact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessengerType() {
		return messengerType;
	}

	public void setMessengerType(String messengerType) {
		this.messengerType = messengerType;
	}

	public String getMessengerId() {
		return messengerId;
	}

	public void setMessengerId(String messengerId) {
		this.messengerId = messengerId;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public Student getStudent() {
		Student student = new Student();
		student.setEmergencyContact(emergencyContact);
		student.setRelationshipWithContact(relationshipWithEmergencyContact);
		student.setLocalContact(localContact);
		student.setEmail(email);
		student.setMessengerType(messengerType);
		student.setMessengerId(messengerId);
		student.setEnglishName(englishName);
		return student;
	}

	@Override
	public String toString() {
		return "ChangeExtraInformationRequest [emergencyContact=" + emergencyContact + ", relationshipWithEmergencyContact=" + relationshipWithEmergencyContact + ", localContact=" + localContact + ", email=" + email + ", messengerType=" + messengerType + ", messengerId="
				+ messengerId + ", englishName=" + englishName + "]";
	}

}
