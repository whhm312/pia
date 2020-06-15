package com.pines.student.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.PushResponse;
import com.pines.student.push.vo.AddStudentDeviceRequest;
import com.pines.student.push.vo.PushCondition;
import com.pines.student.push.vo.StudentPushRequest;
import com.pines.student.push.vo.StudentPushResponse;
import com.pines.student.push.vo.StudentsPushRequest;

@RestController
public class PushController {

	@Autowired
	PushDao pushDao;

	@Autowired
	PushService pushService;

	@PostMapping("/push/students/{studentId}/device")
	public CommonResponseResult addStudentDevice(@PathVariable(value = "studentId", required = true) String studentId, @RequestBody AddStudentDeviceRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isSuccessed = pushDao.addStudentDevice(request.getStudentDevice(studentId));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/students/push")
	public CommonResponseResult pushStudentsPerCampus(@RequestBody StudentsPushRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		PushCondition condition = request.getCondition();
		PushResponse rushResponse = pushService.pushes(request.getPush(), condition);

		int sendedTotalCount = rushResponse.getFailure() + rushResponse.getSuccess();
		if (sendedTotalCount > 0) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			pushService.savePushHistory(authentication.getName(), request.getPush(), condition, rushResponse);
		}
		StudentPushResponse response = new StudentPushResponse();
		response.setFailure(rushResponse.getFailure());
		response.setSuccess(rushResponse.getSuccess());

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		body.setTotalCount(sendedTotalCount);

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/students/{studentId}/push")
	public CommonResponseResult pushStudent(@PathVariable(value = "studentId", required = true) String studentId, @RequestBody StudentPushRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		PushCondition condition = request.getCondition(studentId);
		PushResponse rushResponse = pushService.push(request.getPush(), condition);

		int sendedTotalCount = rushResponse.getFailure() + rushResponse.getSuccess();
		if (sendedTotalCount > 0) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String staffId = authentication.getName();
			pushService.savePushHistory(staffId, request.getPush(), condition, rushResponse);

			condition.setStudentId(studentId);
			pushService.saveAlarm(staffId, request.getPush(), condition);
		}

		StudentPushResponse response = new StudentPushResponse();
		response.setFailure(rushResponse.getFailure());
		response.setSuccess(rushResponse.getSuccess());

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		body.setTotalCount(sendedTotalCount);

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

}
