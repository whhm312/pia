package com.pines.student.emergency.vo;

import com.pines.student.common.vo.EmergencyContact;

public class AddEmergencyContactRequest {
	private int branchSeq;
	private String staffId;
	private String contact;
	private int orderNo;
	private boolean isShown;

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public boolean isShown() {
		return isShown;
	}

	public void setIsShown(boolean isShown) {
		this.isShown = isShown;
	}

	@Override
	public String toString() {
		return "AddEmergencyContactRequest [branchSeq=" + branchSeq + ", staffId=" + staffId + ", contact=" + contact + ", orderNo=" + orderNo + ", isShown=" + isShown + "]";
	}

	public EmergencyContact getContact(int branchSeq) {
		EmergencyContact piaEmergencyContact = new EmergencyContact();
		piaEmergencyContact.setBranchSeq(branchSeq);
		piaEmergencyContact.setStaffId(staffId);
		piaEmergencyContact.setEmergencyContact(contact);
		piaEmergencyContact.setIsShown(isShown);
		piaEmergencyContact.setOrderNo(orderNo);
		return piaEmergencyContact;
	}

}
