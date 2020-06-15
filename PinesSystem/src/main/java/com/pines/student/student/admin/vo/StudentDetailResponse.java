package com.pines.student.student.admin.vo;

import java.util.ArrayList;
import java.util.List;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Consulting;
import com.pines.student.common.vo.Request;
import com.pines.student.common.vo.StudentDetail;
import com.pines.student.common.vo.Violation;
import com.pines.student.student.vo.StudentDetailConsultingResponse;
import com.pines.student.student.vo.StudentDetailRequestResponse;
import com.pines.student.student.vo.StudentDetailViolationResponse;

public class StudentDetailResponse {
	private String name;
	private String sex;
	private String nationality;
	private int groupSeq;
	private String studentId;
	private String visaRegisteredDate;
	private String visaExpireDate;
	private String termStartDate;
	private String termEndDate;
	private String term;
	private String weeks;
	private String campus;
	private String level;
	private String room;
	private int nationalitySeq;
	private String givenNames;
	private String surName;
	private String englishName;
	private String dayOfBirth;
	private String localContact;
	private String email;
	private String emergencyContact;
	private String relationshipWithContact;
	private String messengerType;
	private String messengerId;
	private String selfEnglishLevel;
	private boolean isBlocked;
	private String englishMajor;
	private String officialTestScore;
	private String beforeStudyExperience;
	private String plansOfStudyingAbraod;
	private String purposeOfStudying;
	private String requestRoomType;
	private String requestCourse;
	private String requestMemo;
	private int totalViolations;
	private String profilePath;
	private String course;
	private String idCardSerialNumber;
	private boolean isCanPushMessage;
	private List<StudentDetailViolationResponse> violations;
	private int totalRequests;
	private List<StudentDetailRequestResponse> requests;
	private int totalConsultings;
	private List<StudentDetailConsultingResponse> consultings;

	public StudentDetailResponse(StudentDetail student) {
		name = Tools.blankInsteadOfNull(student.getName());
		sex = Tools.blankInsteadOfNull(student.getSex());
		nationality = Tools.blankInsteadOfNull(student.getNationality());
		groupSeq = student.getStudentGroupSeq();
		studentId = Tools.blankInsteadOfNull(student.getStudentId());
		visaRegisteredDate = Tools.blankInsteadOfNull(student.getVisaRegisterDate());
		visaExpireDate = Tools.blankInsteadOfNull(student.getVisaExtendDate());
		termStartDate = Tools.blankInsteadOfNull(student.getFormTermStartDate());
		termEndDate = Tools.blankInsteadOfNull(student.getFormTermEndDate());
		term = Tools.blankInsteadOfNull(student.getTerm());
		weeks = Tools.blankInsteadOfNull(student.getWeeks());
		campus = Tools.blankInsteadOfNull(student.getCampus());
		level = Tools.blankInsteadOfNull(student.getLevel());
		room = Tools.blankInsteadOfNull(student.getRoom());
		nationalitySeq = student.getNationalitySeq();
		givenNames = Tools.blankInsteadOfNull(student.getGivenNames());
		surName = Tools.blankInsteadOfNull(student.getSurname());
		englishName = Tools.blankInsteadOfNull(student.getEnglishName());
		dayOfBirth = Tools.blankInsteadOfNull(student.getFormDateOfBirth());
		localContact = Tools.blankInsteadOfNull(student.getLocalContact());
		email = Tools.blankInsteadOfNull(student.getEmail());
		emergencyContact = Tools.blankInsteadOfNull(student.getEmergencyContact());
		relationshipWithContact = Tools.blankInsteadOfNull(student.getRelationshipWithContact());
		messengerType = Tools.blankInsteadOfNull(student.getMessengerType());
		messengerId = Tools.blankInsteadOfNull(student.getMessengerId());
		selfEnglishLevel = Tools.blankInsteadOfNull(student.getSelfEnglishLevel());
		isBlocked = student.getIsBlocked();
		englishMajor = student.getEnglishMajor();
		officialTestScore = Tools.blankInsteadOfNull(student.getOfficialTestScore());
		beforeStudyExperience = Tools.blankInsteadOfNull(student.getBeforeStudyExperience());
		plansOfStudyingAbraod = Tools.blankInsteadOfNull(student.getPlansOfStudyingAbraod());
		purposeOfStudying = Tools.blankInsteadOfNull(student.getPurposeOfStudying());
		requestRoomType = Tools.blankInsteadOfNull(student.getRequestRoomType());
		requestCourse = Tools.blankInsteadOfNull(student.getRequestCourse());
		requestMemo = Tools.blankInsteadOfNull(student.getRequestMemo());
		profilePath = Tools.blankInsteadOfNull(student.getProfilePath());
		course = Tools.blankInsteadOfNull(student.getCourse());
		idCardSerialNumber = Tools.blankInsteadOfNull(student.getIdCardSerialNumber());
		isCanPushMessage = student.getStudentDeviceCount() > 0;

		violations = new ArrayList<StudentDetailViolationResponse>();
		StudentDetailViolationResponse violationResponse = null;
		for (Violation violation : student.getViolations()) {
			violationResponse = new StudentDetailViolationResponse();
			violationResponse.setViolationSeq(violation.getViolationSeq());
			violationResponse.setDateOfViolation(Tools.blankInsteadOfNull(violation.getFormRegisterDate()));
			violationResponse.setDetail(Tools.blankInsteadOfNull(violation.getDetail()));
			violationResponse.setRegisterName(Tools.blankInsteadOfNull(violation.getStaff()));
			violationResponse.setType(Tools.blankInsteadOfNull(violation.getRuleType()));
			violationResponse.setMemo(Tools.blankInsteadOfNull(violation.getMemo()));

			violations.add(violationResponse);
		}
		if (!student.getViolations().isEmpty()) {
			totalViolations = student.getViolations().get(0).getTotalCount();
		}

		requests = new ArrayList<StudentDetailRequestResponse>();
		StudentDetailRequestResponse requestResponse = null;
		for (Request request : student.getRequests()) {
			requestResponse = new StudentDetailRequestResponse();
			requestResponse.setRequestSeq(request.getRequestSeq());
			requestResponse.setDetail(Tools.blankInsteadOfNull(request.getDetail()));
			requestResponse.setIsReply(request.getIsReply());
			requestResponse.setRegisterDate(Tools.blankInsteadOfNull(request.getFormRegisterDate()));
			requestResponse.setReply(Tools.blankInsteadOfNull(request.getReply()));
			requestResponse.setReplyDate(Tools.blankInsteadOfNull(request.getFormReplyDate()));
			requestResponse.setReplyName(Tools.blankInsteadOfNull(request.getStaff()));
			requestResponse.setRequestType(Tools.blankInsteadOfNull(request.getType()));

			requests.add(requestResponse);
		}
		if (!student.getRequests().isEmpty()) {
			totalRequests = student.getRequests().get(0).getTotalCount();
		}

		consultings = new ArrayList<StudentDetailConsultingResponse>();
		StudentDetailConsultingResponse consultingResponse = null;
		for (Consulting consulting : student.getConsultings()) {
			consultingResponse = new StudentDetailConsultingResponse();
			consultingResponse.setConsultingSeq(consulting.getConsultingSeq());
			consultingResponse.setDetail(Tools.blankInsteadOfNull(consulting.getDetail()));
			consultingResponse.setRegisterDate(Tools.blankInsteadOfNull(consulting.getFormRegisterDate()));
			consultingResponse.setReplyDate(Tools.blankInsteadOfNull(consulting.getFormReplyDate()));
			consultingResponse.setIsReply(consulting.getIsReply());
			consultingResponse.setReply(Tools.blankInsteadOfNull(consulting.getReply()));
			consultingResponse.setReplyName(Tools.blankInsteadOfNull(consulting.getStaff()));

			consultings.add(consultingResponse);
		}
		if (!student.getConsultings().isEmpty()) {
			totalConsultings = student.getConsultings().get(0).getTotalCount();
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getGroupSeq() {
		return groupSeq;
	}

	public void setGroupSeq(int groupSeq) {
		this.groupSeq = groupSeq;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getVisaRegisteredDate() {
		return visaRegisteredDate;
	}

	public void setVisaRegisteredDate(String visaRegisteredDate) {
		this.visaRegisteredDate = visaRegisteredDate;
	}

	public String getVisaExpireDate() {
		return visaExpireDate;
	}

	public void setVisaExpireDate(String visaExpireDate) {
		this.visaExpireDate = visaExpireDate;
	}

	public String getTermStartDate() {
		return termStartDate;
	}

	public void setTermStartDate(String termStartDate) {
		this.termStartDate = termStartDate;
	}

	public String getTermEndDate() {
		return termEndDate;
	}

	public void setTermEndDate(String termEndDate) {
		this.termEndDate = termEndDate;
	}

	public void setViolations(List<StudentDetailViolationResponse> violations) {
		this.violations = violations;
	}

	public String getWeeks() {
		return weeks;
	}

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getNationalitySeq() {
		return nationalitySeq;
	}

	public void setNationalitySeq(int nationalitySeq) {
		this.nationalitySeq = nationalitySeq;
	}

	public String getGivenNames() {
		return givenNames;
	}

	public void setGivenNames(String givenNames) {
		this.givenNames = givenNames;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
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

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getRelationshipWithContact() {
		return relationshipWithContact;
	}

	public void setRelationshipWithContact(String relationshipWithContact) {
		this.relationshipWithContact = relationshipWithContact;
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

	public String getSelfEnglishLevel() {
		return selfEnglishLevel;
	}

	public void setSelfEnglishLevel(String selfEnglishLevel) {
		this.selfEnglishLevel = selfEnglishLevel;
	}

	public String getEnglishMajor() {
		return englishMajor;
	}

	public void setEnglishMajor(String englishMajor) {
		this.englishMajor = englishMajor;
	}

	public String getOfficialTestScore() {
		return officialTestScore;
	}

	public void setOfficialTestScore(String officialTestScore) {
		this.officialTestScore = officialTestScore;
	}

	public String getBeforeStudyExperience() {
		return beforeStudyExperience;
	}

	public void setBeforeStudyExperience(String beforeStudyExperience) {
		this.beforeStudyExperience = beforeStudyExperience;
	}

	public String getRequestRoomType() {
		return requestRoomType;
	}

	public void setRequestRoomType(String requestRoomType) {
		this.requestRoomType = requestRoomType;
	}

	public List<StudentDetailViolationResponse> getViolations() {
		return violations;
	}

	public void setRules(List<StudentDetailViolationResponse> violations) {
		this.violations = violations;
	}

	public List<StudentDetailRequestResponse> getRequests() {
		return requests;
	}

	public void setRequests(List<StudentDetailRequestResponse> requests) {
		this.requests = requests;
	}

	public List<StudentDetailConsultingResponse> getConsultings() {
		return consultings;
	}

	public void setConsultings(List<StudentDetailConsultingResponse> consultings) {
		this.consultings = consultings;
	}

	public int getTotalViolations() {
		return totalViolations;
	}

	public void setTotalViolations(int totalViolations) {
		this.totalViolations = totalViolations;
	}

	public int getTotalRequests() {
		return totalRequests;
	}

	public void setTotalRequests(int totalRequests) {
		this.totalRequests = totalRequests;
	}

	public int getTotalConsultings() {
		return totalConsultings;
	}

	public void setTotalConsultings(int totalConsultings) {
		this.totalConsultings = totalConsultings;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getRequestCourse() {
		return requestCourse;
	}

	public void setRequestCourse(String requestCourse) {
		this.requestCourse = requestCourse;
	}

	public String getRequestMemo() {
		return requestMemo;
	}

	public void setRequestMemo(String requestMemo) {
		this.requestMemo = requestMemo;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getIdCardSerialNumber() {
		return idCardSerialNumber;
	}

	public void setIdCardSerialNumber(String idCardSerialNumber) {
		this.idCardSerialNumber = idCardSerialNumber;
	}

	public boolean getIsCanPushMessage() {
		return isCanPushMessage;
	}

	public void setIsCanPushMessage(boolean isCanPushMessage) {
		this.isCanPushMessage = isCanPushMessage;
	}

	public boolean getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getPlansOfStudyingAbraod() {
		return plansOfStudyingAbraod;
	}

	public void setPlansOfStudyingAbraod(String plansOfStudyingAbraod) {
		this.plansOfStudyingAbraod = plansOfStudyingAbraod;
	}

	public String getPurposeOfStudying() {
		return purposeOfStudying;
	}

	public void setPurposeOfStudying(String purposeOfStudying) {
		this.purposeOfStudying = purposeOfStudying;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	@Override
	public String toString() {
		return "StudentDetailResponse [name=" + name + ", sex=" + sex + ", nationality=" + nationality + ", groupSeq=" + groupSeq + ", studentId=" + studentId + ", visaRegisteredDate=" + visaRegisteredDate + ", visaExpireDate=" + visaExpireDate + ", termStartDate="
				+ termStartDate + ", termEndDate=" + termEndDate + ", term=" + term + ", weeks=" + weeks + ", campus=" + campus + ", level=" + level + ", room=" + room + ", nationalitySeq=" + nationalitySeq + ", givenNames=" + givenNames + ", surName=" + surName
				+ ", englishName=" + englishName + ", dayOfBirth=" + dayOfBirth + ", localContact=" + localContact + ", email=" + email + ", emergencyContact=" + emergencyContact + ", relationshipWithContact=" + relationshipWithContact + ", messengerType=" + messengerType
				+ ", messengerId=" + messengerId + ", selfEnglishLevel=" + selfEnglishLevel + ", isBlocked=" + isBlocked + ", englishMajor=" + englishMajor + ", officialTestScore=" + officialTestScore + ", beforeStudyExperience=" + beforeStudyExperience
				+ ", plansOfStudyingAbraod=" + plansOfStudyingAbraod + ", purposeOfStudying=" + purposeOfStudying + ", requestRoomType=" + requestRoomType + ", requestCourse=" + requestCourse + ", requestMemo=" + requestMemo + ", totalViolations=" + totalViolations
				+ ", profilePath=" + profilePath + ", course=" + course + ", idCardSerialNumber=" + idCardSerialNumber + ", isCanPushMessage=" + isCanPushMessage + ", violations=" + violations + ", totalRequests=" + totalRequests + ", requests=" + requests + ", totalConsultings="
				+ totalConsultings + ", consultings=" + consultings + "]";
	}

}
