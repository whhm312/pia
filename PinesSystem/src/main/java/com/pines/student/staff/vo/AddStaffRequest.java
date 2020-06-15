package com.pines.student.staff.vo;

import java.util.ArrayList;
import java.util.List;

import com.pines.student.common.vo.Staff;
import com.pines.student.common.vo.StaffAuthorization;

public class AddStaffRequest {
	private int nationalitySeq;
	private String staffId;
	private String password;
	private String realName;
	private String title;
	private String nickName;
	private String contact;
	private String requestStaffId;
	private String status;
	private List<Integer> authorityBranchSeqs = new ArrayList<Integer>();
	private String idCardSerialNumber;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getRequestStaffId() {
		return requestStaffId;
	}

	public void setRequestStaffId(String requestStaffId) {
		this.requestStaffId = requestStaffId;
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
		return "AddStaffRequest [nationalitySeq=" + nationalitySeq + ", staffId=" + staffId + ", password=" + password + ", realName=" + realName + ", title=" + title + ", nickName=" + nickName + ", contact=" + contact + ", requestStaffId=" + requestStaffId + ", status=" + status
				+ ", authorityBranchSeqs=" + authorityBranchSeqs + ", idCardSerialNumber=" + idCardSerialNumber + "]";
	}

	public Staff getStaff(int branchSeq, String requestStaffId) {
		Staff result = new Staff();
		result.setBranchSeq(branchSeq);
		result.setNationalitySeq(nationalitySeq);
		result.setTitle(title);
		result.setRealName(realName);
		result.setNickName(nickName);
		result.setStaffId(staffId);
		result.setPassword(password);
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
