package com.pines.student.student.admin.vo;

import com.pines.student.common.vo.Student;

public class AddStudentRequest {
	private int branchSeq;
	private int campusSeq;
	private int termSeq;
	private int languageSeq;
	private String password;
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

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getCampusSeq() {
		return campusSeq;
	}

	public void setCampusSeq(int campusSeq) {
		this.campusSeq = campusSeq;
	}

	public int getTermSeq() {
		return termSeq;
	}

	public void setTermSeq(int termSeq) {
		this.termSeq = termSeq;
	}

	public int getLanguageSeq() {
		return languageSeq;
	}

	public void setLanguageSeq(int languageSeq) {
		this.languageSeq = languageSeq;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public Student getStudent() {
		Student student = new Student();
		student.setBranchSeq(branchSeq);
		student.setCampusSeq(campusSeq);
		student.setTermSeq(termSeq);
		student.setLanguageSeq(languageSeq);
		student.setPassword(password);
		student.setNationality(nationality);
		student.setName(name);
		student.setSurname(passportSurname);
		student.setGivenNames(passportGivennames);
		student.setSex(sex);
		student.setDateOfBirth(dateOfBirth);
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
		return "AddStudentRequest [branchSeq=" + branchSeq + ", campusSeq=" + campusSeq + ", termSeq=" + termSeq + ", languageSeq=" + languageSeq + ", password=" + password + ", nationality=" + nationality + ", name=" + name + ", passportSurname=" + passportSurname
				+ ", passportGivennames=" + passportGivennames + ", sex=" + sex + ", dateOfBirth=" + dateOfBirth + ", emergencyContact=" + emergencyContact + ", relationshipWithEmergencyContact=" + relationshipWithEmergencyContact + ", localContact=" + localContact + ", email="
				+ email + ", messengerType=" + messengerType + ", messengerId=" + messengerId + ", englishName=" + englishName + "]";
	}

}
