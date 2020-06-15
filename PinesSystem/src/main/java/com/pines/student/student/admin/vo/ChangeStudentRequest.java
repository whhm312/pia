package com.pines.student.student.admin.vo;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Student;

public class ChangeStudentRequest {
	private String nationality;
	private String name;
	private String passportSurname;
	private String passportGivennames;
	private String sex;
	private String dateOfBirth;
	private String emergencyContact;
	private String relationshipWithEmergencyContact;
	private String localContact;
	private String email;
	private String messengerType;
	private String messengerId;
	private String englishName;

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassportSurname() {
		return passportSurname;
	}

	public void setPassportSurname(String passportSurname) {
		this.passportSurname = passportSurname;
	}

	public String getPassportGivennames() {
		return passportGivennames;
	}

	public void setPassportGivennames(String passportGivennames) {
		this.passportGivennames = passportGivennames;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

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

	@Override
	public String toString() {
		return "ChangeStudentRequest [nationality=" + nationality + ", name=" + name + ", passportSurname=" + passportSurname + ", passportGivennames=" + passportGivennames + ", sex=" + sex + ", dateOfBirth=" + dateOfBirth + ", emergencyContact=" + emergencyContact
				+ ", relationshipWithEmergencyContact=" + relationshipWithEmergencyContact + ", localContact=" + localContact + ", email=" + email + ", messengerType=" + messengerType + ", messengerId=" + messengerId + ", englishName=" + englishName + "]";
	}

	public Student getStudent(String studentId) {
		Student result = new Student();
		result.setStudentId(studentId);
		result.setNationality(nationality);
		result.setName(Tools.trim(name));
		result.setSurname(Tools.trim(passportSurname));
		result.setGivenNames(Tools.trim(passportGivennames));
		result.setSex(sex);
		result.setDateOfBirth(dateOfBirth);
		result.setEmergencyContact(emergencyContact);
		result.setRelationshipWithContact(relationshipWithEmergencyContact);
		result.setLocalContact(localContact);
		result.setEmail(email);
		result.setMessengerType(messengerType);
		result.setMessengerId(messengerId);
		result.setEnglishName(englishName);
		return result;
	}
}
