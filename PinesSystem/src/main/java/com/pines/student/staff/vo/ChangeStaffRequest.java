package com.pines.student.staff.vo;

import java.util.ArrayList;
import java.util.List;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Staff;
import com.pines.student.common.vo.StaffAuthorization;

public class ChangeStaffRequest {
	private int branchSeq;
	private int nationalitySeq;
	private String staffId;
	private String realName;
	private String title;
	private String nickName;
	private String contact;
	private String status;
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
		return "ChangeStaffRequest [branchSeq=" + branchSeq + ", nationalitySeq=" + nationalitySeq + ", staffId=" + staffId + ", realName=" + realName + ", title=" + title + ", nickName=" + nickName + ", contact=" + contact + ", status=" + status + ", authorityBranchSeqs="
				+ authorityBranchSeqs + ", idCardSerialNumber=" + idCardSerialNumber + "]";
	}

	public Staff getStaff(int branchSeq, String requestStaffId, String staffId) {
		Staff result = new Staff();
		result.setStaffId(Tools.blankInsteadOfNull(staffId));
		result.setBranchSeq(branchSeq);
		result.setNationalitySeq(nationalitySeq);
		result.setTitle(title);
		result.setRealName(realName);
		result.setNickName(nickName);
		result.setContact(contact);
		result.setStatus(status);
		result.setUpdateStaffId(requestStaffId);
		result.setIdCardSerialNumber(idCardSerialNumber);
		List<StaffAuthorization> authorizations = new ArrayList<StaffAuthorization>();
		StaffAuthorization authorization = null;
		if (authorityBranchSeqs != null) {
			for (Integer authorityBranchSeq : authorityBranchSeqs) {
				authorization = new StaffAuthorization();
				authorization.setBranchSeq(authorityBranchSeq);
				authorizations.add(authorization);
			}
		}
		result.setStaffAuthorizations(authorizations);
		return result;
	}

}
