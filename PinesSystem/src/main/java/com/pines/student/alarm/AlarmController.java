package com.pines.student.alarm;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pines.student.alarm.vo.AlarmsExcelView;
import com.pines.student.alarm.vo.SendAlarmRequest;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.student.admin.StudentForAdminDao;

@RestController
public class AlarmController {

	@Autowired
	AlarmDao alarmDao;

	@Autowired
	StudentForAdminDao studentDao;

	@PostMapping("/students/{studentId}/alarms/{alarmSeq}/read")
	public CommonResponseResult read(@PathVariable(value = "studentId", required = true) String studentId, @PathVariable(value = "alarmSeq", required = true) int alarmSeq) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isValidAlarm = alarmDao.isValidAlarm(alarmSeq);
		if (!isValidAlarm) {
			result.setFailureHead(ResultCode.STATUS_404);
			return result;
		}

		boolean isValidReveiver = alarmDao.isValidReveiver(studentId, alarmSeq);
		if (!isValidReveiver) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		boolean isValidStudent = studentDao.isValidStudent(studentId);
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		boolean isSuccessed = alarmDao.readAlarm(studentId, alarmSeq);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;

	}

	@GetMapping(value = "/students/{studentId}/alarms/download")
	public ModelAndView download(@PathVariable(value = "studentId", required = true) String studentId, HttpServletResponse response) {
		response.setContentType("application/ms-excel");
		response.setHeader("Content-disposition", "attachment; filename=myAlarms.xls");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("alarms", alarmDao.getAllAlarmsForExcel(studentId));
		return new ModelAndView(new AlarmsExcelView(), model);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/alarms/send")
	public CommonResponseResult send(SendAlarmRequest request) {
		CommonResponseResult result = new CommonResponseResult();
		boolean isValidStudent = studentDao.isValidStudent(request.getStudentId());
		if (!isValidStudent) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isSuccessed = alarmDao.send(request.getAlarm(authentication.getName()));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/alarms/{alarmSeq}")
	public CommonResponseResult deleteAlarm(@PathVariable(value = "alarmSeq", required = true) int alarmSeq) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isValidAlarm = alarmDao.isValidAlarm(alarmSeq);
		if (!isValidAlarm) {
			result.setFailureHead(ResultCode.STATUS_404);
			return result;
		}

		boolean isSuccessed = alarmDao.deleteAlarm(alarmSeq);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;

	}
}
