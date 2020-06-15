package com.pines.student.emergency;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.EmergencyContact;
import com.pines.student.emergency.vo.AddEmergencyContactRequest;
import com.pines.student.emergency.vo.ChangeEmergencyContactRequest;
import com.pines.student.emergency.vo.EmergencyContactResponse;

@RestController
public class EmergencyContactController {

	@Autowired
	EmergencyContactDao emergencyContactDao;

	@GetMapping("/branches/{branchSeq}/emergency/contacts")
	public CommonResponseResult getEmergencyContacts(@PathVariable(value = "branchSeq", required = true) int branchSeq) {
		CommonResponseResult result = new CommonResponseResult();

		List<EmergencyContact> contacts = emergencyContactDao.getEmergencyContacts(branchSeq);
		List<EmergencyContactResponse> contactsResponse = new ArrayList<EmergencyContactResponse>();
		EmergencyContactResponse contactResponse = null;
		for (EmergencyContact contact : contacts) {
			contactResponse = new EmergencyContactResponse();
			contactResponse.setContactSeq(contact.getEmergencyContactSeq());
			contactResponse.setStaffId(Tools.blankInsteadOfNull(contact.getStaffId()));
			contactResponse.setTitle(contact.getTitle());
			contactResponse.setName(contact.getName());
			contactResponse.setNationality(contact.getNationalityAlphaThree());
			contactResponse.setContact(contact.getEmergencyContact());
			contactResponse.setOrderNo(contact.getOrderNo());
			contactResponse.setIsShown(contact.getIsShown());
			contactsResponse.add(contactResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(contactsResponse);
		body.setTotalCount(contacts.size());

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/emergency/contacts")
	public CommonResponseResult addEmergencyContact(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestBody AddEmergencyContactRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isSuccessed = emergencyContactDao.addEmergencyContact(request.getContact(branchSeq));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/branches/{branchSeq}/emergency/contacts/{contactSeq}")
	public CommonResponseResult changeEmergencyContact(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "contactSeq", required = true) int contactSeq, @RequestBody ChangeEmergencyContactRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isSuccessed = emergencyContactDao.changeEmergencyContact(request.getContact(branchSeq, contactSeq));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/branches/{branchSeq}/emergency/contacts/{contactSeq}")
	public CommonResponseResult removeEmergencyContact(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "contactSeq", required = true) int contactSeq) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isSuccessed = emergencyContactDao.removeEmergencyContact(branchSeq, contactSeq);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}
}
