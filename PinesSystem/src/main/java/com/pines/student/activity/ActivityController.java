package com.pines.student.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.student.admin.StudentForAdminDao;

@RestController
public class ActivityController {

	@Autowired
	ActivityDao activityDao;

	@Autowired
	StudentForAdminDao studentDao;

	@PostMapping("/activities/{activitySeq}/join/{studentId}")
	public CommonResponseResult join(@PathVariable int activitySeq, @PathVariable String studentId) {
		CommonResponseResult result = new CommonResponseResult();
		boolean isAvailableActivity = activityDao.isAvailableActivity(activitySeq);
		if (!isAvailableActivity) {
			result.setFailureHead(ResultCode.STATUS_404);
			return result;
		}

		boolean isValidStudent = studentDao.isValidStudent(studentId);
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		boolean isSuccessed = activityDao.join(activitySeq, studentId);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}

		return result;
	}
}
