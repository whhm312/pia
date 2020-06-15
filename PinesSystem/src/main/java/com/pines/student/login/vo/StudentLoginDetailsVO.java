package com.pines.student.login.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class StudentLoginDetailsVO implements UserDetails {
	private static final long serialVersionUID = 1583398909513535357L;

	private String username;
	private String password;
	private String name;
	private boolean isAccountNonExpired = true;
	private boolean isAccountNonLocked = true;
	private boolean isCredentialsNonExpired = true;
	private boolean isEnabled = true;
	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	private int studentSeq;
	private int campusSeq;
	private int branchSeq;
	private int languageSeq;
	private int nationalitySeq;
	private int termSeq;
	private String campus;
	private String branch;
	private String language;
	private String term;
	private String studentId;
	private String nationality;
	private String dateOfBirth;
	private String sex;
	private String surName;
	private String givenNames;
	private String englishName;
	private String emergencyContact;
	private String relationshipWithContactor;
	private String localContact;
	private String email;
	private String messengerType;
	private String messengerId;
	private String dateOfLastLogin;
	private String favorites;
	private boolean isTraveling;
	private boolean isBlocked;

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public int getStudentSeq() {
		return studentSeq;
	}

	public void setStudentSeq(int studentSeq) {
		this.studentSeq = studentSeq;
	}

	public int getCampusSeq() {
		return campusSeq;
	}

	public void setCampusSeq(int campusSeq) {
		this.campusSeq = campusSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getLanguageSeq() {
		return languageSeq;
	}

	public void setLanguageSeq(int languageSeq) {
		this.languageSeq = languageSeq;
	}

	public int getNationalitySeq() {
		return nationalitySeq;
	}

	public void setNationalitySeq(int nationalitySeq) {
		this.nationalitySeq = nationalitySeq;
	}

	public int getTermSeq() {
		return termSeq;
	}

	public void setTermSeq(int termSeq) {
		this.termSeq = termSeq;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getGivenNames() {
		return givenNames;
	}

	public void setGivenNames(String givenNames) {
		this.givenNames = givenNames;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getRelationshipWithContactor() {
		return relationshipWithContactor;
	}

	public void setRelationshipWithContactor(String relationshipWithContactor) {
		this.relationshipWithContactor = relationshipWithContactor;
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

	public String getDateOfLastLogin() {
		return dateOfLastLogin;
	}

	public void setDateOfLastLogin(String dateOfLastLogin) {
		this.dateOfLastLogin = dateOfLastLogin;
	}

	public String getFavorites() {
		return favorites;
	}

	public void setFavorites(String favorites) {
		this.favorites = favorites;
	}

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

	@Override
	public String toString() {
		return "StudentLoginDetailsVO [username=" + username + ", password=" + password + ", name=" + name + ", isAccountNonExpired=" + isAccountNonExpired + ", isAccountNonLocked=" + isAccountNonLocked + ", isCredentialsNonExpired=" + isCredentialsNonExpired + ", isEnabled="
				+ isEnabled + ", authorities=" + authorities + ", studentSeq=" + studentSeq + ", campusSeq=" + campusSeq + ", branchSeq=" + branchSeq + ", languageSeq=" + languageSeq + ", nationalitySeq=" + nationalitySeq + ", termSeq=" + termSeq + ", campus=" + campus
				+ ", branch=" + branch + ", language=" + language + ", term=" + term + ", studentId=" + studentId + ", nationality=" + nationality + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", surName=" + surName + ", givenNames=" + givenNames + ", englishName="
				+ englishName + ", emergencyContact=" + emergencyContact + ", relationshipWithContactor=" + relationshipWithContactor + ", localContact=" + localContact + ", email=" + email + ", messengerType=" + messengerType + ", messengerId=" + messengerId
				+ ", dateOfLastLogin=" + dateOfLastLogin + ", favorites=" + favorites + ", isTraveling=" + isTraveling + ", isBlocked=" + isBlocked + "]";
	}

}
