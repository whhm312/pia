package com.pines.student.staff.vo;

import java.util.ArrayList;
import java.util.List;

public class StaffResponse {
	private int branchSeq;
	private int nationalitySeq;
	private String staffId;
	private String title;
	private String realName;
	private String nickName;
	private String contact;
	private String status;
	private String updateDate;
	private List<Integer> authorityBranchSeqs = new ArrayList<Integer>();
	private String idCardSerialNumber;

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getNationalitySeq() {
		return nationalitySeq;
	}

	public void setNationalitySeq(int nationalitySeq) {
		this.nationalitySeq = nationalitySeq;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public List<Integer> getAuthorityBranchSeqs() {
		return authorityBranchSeqs;
	}

	public void setAuthorityBranchSeqs(List<Integer> authorityBranchSeqs) {
		this.authorityBranchSeqs = authorityBranchSeqs;
	}

	public String getIdCardSerialNumber() {
		return idCardSerialNumber;
	}

	public void setIdCardSerialNumber(String idCardSerialNumber) {
		this.idCardSerialNumber = idCardSerialNumber;
	}

	@Override
	public String toString() {
		return "StaffResponse [branchSeq=" + branchSeq + ", nationalitySeq=" + nationalitySeq + ", staffId=" + staffId + ", title=" + title + ", realName=" + realName + ", nickName=" + nickName + ", contact=" + contact + ", status=" + status + ", updateDate=" + updateDate
				+ ", authorityBranchSeqs=" + authorityBranchSeqs + ", idCardSerialNumber=" + idCardSerialNumber + "]";
	}

}
