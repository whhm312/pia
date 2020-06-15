package com.pines.student.login.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pines.student.common.vo.Branch;
import com.pines.student.common.vo.Campus;
import com.pines.student.common.vo.Language;

public class StaffLoginDetailsVO implements UserDetails {
	private static final long serialVersionUID = 3928088529969824655L;
	private String username;
	private String password;
	private String name;
	private boolean isAccountNonExpired = true;
	private boolean isAccountNonLocked = true;
	private boolean isCredentialsNonExpired = true;
	private boolean isEnabled = true;
	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	private int staffSeq;
	private int branchSeq;
	private int languageSeq;
	private int groupSeq;
	private String realName;
	private String title;
	private String nickName;
	private String nationality;
	private String nationalityAlphaThree;
	private boolean isDeleted;
	private String registerDate;
	private String formRegisterDate;
	private String siteAuthorization;
	private List<Branch> branches;
	private List<Campus> campuses;
	private List<Language> languages;
	private String staffName;

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
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public int getStaffSeq() {
		return staffSeq;
	}

	public void setStaffSeq(int staffSeq) {
		this.staffSeq = staffSeq;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public int getGroupSeq() {
		return groupSeq;
	}

	public void setGroupSeq(int groupSeq) {
		this.groupSeq = groupSeq;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNationalityAlphaThree() {
		return nationalityAlphaThree;
	}

	public void setNationalityAlphaThree(String nationalityAlphaThree) {
		this.nationalityAlphaThree = nationalityAlphaThree;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public String getSiteAuthorization() {
		return siteAuthorization;
	}

	public void setSiteAuthorization(String stieAuthorization) {
		this.siteAuthorization = stieAuthorization;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public List<Campus> getCampuses() {
		return campuses;
	}

	public void setCampuses(List<Campus> campuses) {
		this.campuses = campuses;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Override
	public String toString() {
		return "StaffLoginDetailsVO [username=" + username + ", password=" + password + ", name=" + name + ", isAccountNonExpired=" + isAccountNonExpired + ", isAccountNonLocked=" + isAccountNonLocked + ", isCredentialsNonExpired=" + isCredentialsNonExpired + ", isEnabled="
				+ isEnabled + ", authorities=" + authorities + ", staffSeq=" + staffSeq + ", branchSeq=" + branchSeq + ", languageSeq=" + languageSeq + ", groupSeq=" + groupSeq + ", realName=" + realName + ", title=" + title + ", nickName=" + nickName + ", nationality="
				+ nationality + ", nationalityAlphaThree=" + nationalityAlphaThree + ", isDeleted=" + isDeleted + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + ", siteAuthorization=" + siteAuthorization + ", branches=" + branches + ", campuses="
				+ campuses + ", languages=" + languages + ", staffName=" + staffName + "]";
	}

}
