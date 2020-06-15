package com.pines.student.request;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.sms.ISMSService;
import com.pines.student.common.sms.SMS;
import com.pines.student.common.vo.Request;
import com.pines.student.request.vo.AddRequestRequest;
import com.pines.student.request.vo.ProgressRequestRequest;
import com.pines.student.request.vo.ReplyRequestRequest;
import com.pines.student.request.vo.RequestResponse;
import com.pines.student.request.vo.RequestsRequest;
import com.pines.student.request.vo.RequestsResponse;
import com.pines.student.request.vo.StudentRequestsResponse;

@RestController
public class RequestController {

	@Autowired
	RequestDao requestDao;

	@Autowired
	ISMSService smsService;

	@GetMapping("/branches/{branchSeq}/students/{studentId}/requests")
	public CommonResponseResult getStudentRequests(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "studentId", required = true) String studentId) {
		CommonResponseResult result = new CommonResponseResult();

		List<Request> requests = requestDao.getStudentRequests(branchSeq, studentId);
		List<StudentRequestsResponse> response = new ArrayList<StudentRequestsResponse>();
		StudentRequestsResponse requestResponse = null;
		for (Request request : requests) {
			requestResponse = new StudentRequestsResponse();
			requestResponse.setDetail(Tools.blankInsteadOfNull(request.getDetail()));
			requestResponse.setIsReply(request.getIsReply());
			requestResponse.setRegisterDate(Tools.blankInsteadOfNull(request.getFormRegisterDate()));
			requestResponse.setReply(Tools.blankInsteadOfNull(request.getReply()));
			requestResponse.setReplyDate(Tools.blankInsteadOfNull(request.getFormReplyDate()));
			requestResponse.setStaff(Tools.blankInsteadOfNull(request.getStaff()));
			requestResponse.setType(Tools.blankInsteadOfNull(request.getType()));
			requestResponse.setStatus(Tools.blankInsteadOfNull(request.getStatus()));
			requestResponse.setProgressDate(Tools.blankInsteadOfNull(request.getFormProgressDate()));
			requestResponse.setProgressStaffId(Tools.blankInsteadOfNull(request.getProgressStaffId()));
			response.add(requestResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (requests.size() > 0) {
			body.setTotalCount(requests.get(0).getTotalCount());
		} else {
			body.setTotalCount(0);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PostMapping("/branches/{branchSeq}/students/{studentId}/requests")
	public CommonResponseResult addRequest(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "studentId", required = true) String studentId, @RequestBody AddRequestRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		Request newRequest = request.getRequest(branchSeq, studentId);
		boolean isSuccessed = requestDao.addRequest(newRequest);
		if (isSuccessed) {
			String message = "New request is registered now. [" + newRequest.getType() + "]";
			SMS sms = new SMS();
			sms.setMessage(message);
			sms.addReceiverNumber("639178336317"); // Jacob
			sms.addReceiverNumber("639178243912"); // Justin
			sms.addReceiverNumber("639260030588"); // Mark
			sms.addReceiverNumber("639568897475"); // Ethan
			sms.addReceiverNumber("639054743072"); // Summer
			smsService.sends(sms);

			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/students/requests")
	public CommonResponseResult getRequests(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestParam Map<String, String> parameters, @RequestParam(name = "type[]", required = false) List<String> typies,
			@RequestParam(name = "status[]", required = false) List<String> statuses) {
		CommonResponseResult result = new CommonResponseResult();

		RequestsRequest requestsRequest = new RequestsRequest(branchSeq, typies, statuses, parameters);
		List<Request> requests = requestDao.getRequests(requestsRequest.getConditions(), requestsRequest.getSelectedPage(), requestsRequest.getOffset());
		List<RequestsResponse> response = new ArrayList<RequestsResponse>();
		RequestsResponse requestResponse = null;
		for (Request request : requests) {
			requestResponse = new RequestsResponse();
			requestResponse.setReplyDate(Tools.blankInsteadOfNull(request.getFormReplyDate()));
			requestResponse.setRegisterDate(Tools.blankInsteadOfNull(request.getFormRegisterDate()));
			requestResponse.setRequestSeq(request.getRequestSeq());
			requestResponse.setStaff(Tools.blankInsteadOfNull(request.getStaff()));
			requestResponse.setStatus(request.getStatus());
			requestResponse.setStudent(Tools.blankInsteadOfNull(request.getStudent()));
			requestResponse.setType(Tools.blankInsteadOfNull(request.getType()));
			requestResponse.setProgressDate(Tools.blankInsteadOfNull(request.getFormProgressDate()));
			requestResponse.setProgressStaffId(Tools.blankInsteadOfNull(request.getProgressStaff()));
			requestResponse.setCampus(Tools.blankInsteadOfNull(request.getCampus()));
			response.add(requestResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (requests.size() > 0) {
			body.setTotalCount(requests.get(0).getTotalCount());
		} else {
			body.setTotalCount(0);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/students/requests/{requestSeq}")
	public CommonResponseResult getRequest(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "requestSeq", required = true) int requestSeq) {
		CommonResponseResult result = new CommonResponseResult();

		Request request = requestDao.getRequest(branchSeq, requestSeq);
		RequestResponse response = new RequestResponse();
		response.setBranch(Tools.blankInsteadOfNull(request.getBranch()));
		response.setNationality(Tools.blankInsteadOfNull(request.getNationality()));
		response.setStudent(Tools.blankInsteadOfNull(request.getStudent()));
		response.setBirthday(Tools.blankInsteadOfNull(request.getBirthday()));
		response.setType(Tools.blankInsteadOfNull(request.getType()));
		response.setDetail(Tools.blankInsteadOfNull(request.getDetail()));
		response.setRegisterDate(Tools.blankInsteadOfNull(request.getFormRegisterDate()));
		response.setReply(Tools.blankInsteadOfNull(request.getReply()));
		response.setReplyDate(Tools.blankInsteadOfNull(request.getFormReplyDate()));
		response.setStaff(Tools.blankInsteadOfNull(request.getStaff()));
		response.setStatus(request.getStatus());
		response.setSex(Tools.blankInsteadOfNull(request.getSex()));
		response.setProgressDate(Tools.blankInsteadOfNull(request.getFormProgressDate()));
		response.setProgressStaffId(Tools.blankInsteadOfNull(request.getProgressStaff()));
		response.setProgressDetail(Tools.blankInsteadOfNull(request.getProgressDetail()));
		response.setStudentId(Tools.blankInsteadOfNull(request.getStudentId()));
		response.setIsCanPushMessage(request.getStudentDeviceCount() > 0);

		CommonResponseBody body = new CommonResponseBody();
		if (request.getRequestSeq() < 1) {
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
	@PostMapping("/branches/{branchSeq}/students/requests/{requestSeq}/progress")
	public CommonResponseResult progressRequest(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "requestSeq", required = true) int requestSeq, @RequestBody ProgressRequestRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		request.setStaffId(authentication.getName());
		CommonResponseResult result = new CommonResponseResult();

		boolean isSuccess = requestDao.progressRequest(request.getRequest(branchSeq, requestSeq));
		if (isSuccess) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/students/requests/{requestSeq}/reply")
	public CommonResponseResult replyRequest(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "requestSeq", required = true) int requestSeq, @RequestBody ReplyRequestRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		request.setStaffId(authentication.getName());
		CommonResponseResult result = new CommonResponseResult();

		boolean isSuccess = requestDao.replyRequest(request.getRequest(branchSeq, requestSeq));
		if (isSuccess) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/branches/{branchSeq}/students/requests/{requestSeq}")
	public CommonResponseResult removeRequest(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "requestSeq", required = true) int requestSeq) {
		CommonResponseResult result = new CommonResponseResult();
		boolean isSuccess = requestDao.removeRequest(branchSeq, requestSeq);
		if (isSuccess) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}
}
