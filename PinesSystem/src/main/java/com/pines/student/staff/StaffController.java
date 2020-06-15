package com.pines.student.staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.Staff;
import com.pines.student.common.vo.StaffAuthorization;
import com.pines.student.staff.vo.AddStaffRequest;
import com.pines.student.staff.vo.ChangeStaffPasswordRequest;
import com.pines.student.staff.vo.ChangeStaffRequest;
import com.pines.student.staff.vo.StaffResponse;
import com.pines.student.staff.vo.StaffsForEmergencyContactsResponse;
import com.pines.student.staff.vo.StaffsRequest;
import com.pines.student.staff.vo.StaffsResponse;

@RestController
public class StaffController {

	@Autowired
	StaffDao staffDao;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/contacts/emergency/staffs")
	public CommonResponseResult getStaffsForEmergencyContacts(@PathVariable(value = "branchSeq", required = true) int branchSeq) {
		CommonResponseResult result = new CommonResponseResult();
		List<Staff> staffs = staffDao.getStaffsForEmergencyContacts(branchSeq);
		if (!staffs.isEmpty()) {
			StaffsForEmergencyContactsResponse staffResponse = null;
			List<StaffsForEmergencyContactsResponse> staffsResponse = new ArrayList<StaffsForEmergencyContactsResponse>();
			for (Staff staff : staffs) {
				staffResponse = new StaffsForEmergencyContactsResponse();
				staffResponse.setStaffId(staff.getStaffId());
				staffResponse.setName(staff.getName());
				staffResponse.setNationality(staff.getNationality());
				staffResponse.setContact(staff.getContact());
				staffsResponse.add(staffResponse);
			}
			CommonResponseBody body = new CommonResponseBody(staffs.size(), staffsResponse);
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/staffs")
	public CommonResponseResult getStaffs(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestParam(name = "nationalitySeqs[]", required = false) List<Integer> nationalitySeqs, @RequestParam Map<String, String> parameters) {
		CommonResponseResult result = new CommonResponseResult();

		StaffsRequest request = new StaffsRequest(branchSeq, nationalitySeqs, parameters);
		List<Staff> staffs = staffDao.getStaffs(request.getConditions());
		if (!staffs.isEmpty()) {
			StaffsResponse staffResponse = null;
			List<StaffsResponse> staffsResponse = new ArrayList<StaffsResponse>();
			for (Staff staff : staffs) {
				staffResponse = new StaffsResponse();
				staffResponse.setBranchSeq(staff.getBranchSeq());
				staffResponse.setBranch(Tools.blankInsteadOfNull(staff.getBranch()));
				staffResponse.setNationality(Tools.blankInsteadOfNull(staff.getNationality()));
				staffResponse.setStaffId(Tools.blankInsteadOfNull(staff.getStaffId()));
				staffResponse.setRealName(Tools.blankInsteadOfNull(staff.getRealName()));
				staffResponse.setNickName(Tools.blankInsteadOfNull(staff.getNickName()));
				staffResponse.setContact(Tools.blankInsteadOfNull(staff.getContact()));
				staffResponse.setStatus(Tools.blankInsteadOfNull(staff.getStatus()));
				staffResponse.setUpdateDate(Tools.blankInsteadOfNull(staff.getFormUpdateDate()));
				staffsResponse.add(staffResponse);
			}
			CommonResponseBody body = null;
			if (staffs.size() > 0) {
				body = new CommonResponseBody(staffs.get(0).getTotalCount(), staffsResponse);
			} else {
				body = new CommonResponseBody(0, staffsResponse);
			}
			result.setBody(body);
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_204);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/staffs/{staffId}")
	public CommonResponseResult getStaff(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "staffId", required = true) String staffId) {
		CommonResponseResult result = new CommonResponseResult();

		Staff staff = staffDao.getStaff(staffId);
		StaffResponse response = new StaffResponse();
		response.setBranchSeq(staff.getBranchSeq());
		response.setNationalitySeq(staff.getNationalitySeq());
		response.setContact(Tools.blankInsteadOfNull(staff.getContact()));
		response.setNickName(Tools.blankInsteadOfNull(staff.getNickName()));
		response.setRealName(Tools.blankInsteadOfNull(staff.getRealName()));
		response.setStaffId(Tools.blankInsteadOfNull(staff.getStaffId()));
		response.setStatus(Tools.blankInsteadOfNull(staff.getStatus()));
		response.setTitle(Tools.blankInsteadOfNull(staff.getTitle()));
		response.setUpdateDate(Tools.blankInsteadOfNull(staff.getFormUpdateDate()));
		response.setIdCardSerialNumber(Tools.blankInsteadOfNull(staff.getIdCardSerialNumber()));

		List<Integer> authorityBranchSeqs = new ArrayList<Integer>();
		for (StaffAuthorization authorization : staff.getStaffAuthorizations()) {
			authorityBranchSeqs.add(authorization.getBranchSeq());
		}
		response.setAuthorityBranchSeqs(authorityBranchSeqs);

		CommonResponseBody body = new CommonResponseBody();
		if (staff.getStaffSeq() < 1) {
			body.setEmpty();
		} else {
			body.setData(response);
			body.setTotalCount(1);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/staffs")
	public CommonResponseResult addStaff(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestBody AddStaffRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isSuccessed = staffDao.addStaff(request.getStaff(branchSeq, authentication.getName()));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/branches/{branchSeq}/staffs/{staffId}")
	public CommonResponseResult changeStaff(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "staffId", required = true) String staffId, @RequestBody ChangeStaffRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isSuccessed = staffDao.changeStaff(request.getStaff(branchSeq, authentication.getName(), staffId));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/branches/{branchSeq}/staffs/{staffId}")
	public CommonResponseResult removeStaff(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "staffId", required = true) String staffId) {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isSuccessed = staffDao.removeStaff(staffId, authentication.getName());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PostMapping("/branches/{branchSeq}/staffs/{staffId}/password/change")
	public CommonResponseResult changeStaffPassword(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "staffId", required = true) String staffId, @RequestBody ChangeStaffPasswordRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		CommonResponseResult result = new CommonResponseResult();
		boolean isSuccessed = staffDao.changeStaffPassword(staffId, request.getPassword(), authentication.getName());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/staffs/{staffId}/duplicate")
	public CommonResponseResult isDuplicatedStaffId(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "staffId", required = true) String staffId) {
		CommonResponseResult result = new CommonResponseResult();

		Staff staff = staffDao.getStaff(staffId);

		CommonResponseBody body = new CommonResponseBody();
		if (staff.getStaffSeq() < 1) {
			body.setEmpty();
		} else {
			body.setData(new StaffResponse());
			body.setTotalCount(1);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}
}
