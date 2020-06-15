package com.pines.student.emergency.vo;

import com.pines.student.common.vo.EmergencyContact;

public class ChangeEmergencyContactRequest {
	private String contact;
	private int orderNo;
	private boolean isShown;

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

	public boolean getIsShown() {
		return isShown;
	}

	public void setIsShown(boolean isShown) {
		this.isShown = isShown;
	}

	@Override
	public String toString() {
		return "ChangeEmergencyContactRequest [contact=" + contact + ", orderNo=" + orderNo + ", isShown=" + isShown + "]";
	}

	public EmergencyContact getContact(int branchSeq, int contactSeq) {
		EmergencyContact piaEmergencyContact = new EmergencyContact();
		piaEmergencyContact.setBranchSeq(branchSeq);
		piaEmergencyContact.setEmergencyContactSeq(contactSeq);
		piaEmergencyContact.setEmergencyContact(contact);
		piaEmergencyContact.setOrderNo(orderNo);
		piaEmergencyContact.setIsShown(isShown);
		return piaEmergencyContact;
	}

}
