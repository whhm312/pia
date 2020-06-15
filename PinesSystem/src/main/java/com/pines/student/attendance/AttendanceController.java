package com.pines.student.attendance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pines.student.attendance.vo.AddAttendanceRequest;
import com.pines.student.attendance.vo.AttendanceResponse;
import com.pines.student.attendance.vo.AttendancesRequest;
import com.pines.student.attendance.vo.AttendancesResponse;
import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.Attendance;

@RestController
public class AttendanceController {

	@Autowired
	AttendanceDao attendanceDao;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/campuses/{campusSeq}/attendances")
	public CommonResponseResult getAttendancesByCampuses(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, AttendancesRequest request) {
		CommonResponseResult result = new CommonResponseResult();
		List<Attendance> attendances = attendanceDao.getAttendances(request.getConditions(branchSeq, campusSeq));
		List<AttendancesResponse> response = new ArrayList<AttendancesResponse>();
		AttendancesResponse attendancesResponse = null;
		for (Attendance attendance : attendances) {
			attendancesResponse = new AttendancesResponse();
			attendancesResponse.setAttendanceSeq(attendance.getAttendanceSeq());
			attendancesResponse.setAttendanceType(Tools.blankInsteadOfNull(attendance.getAttendanceType()));
			attendancesResponse.setBranch(Tools.blankInsteadOfNull(attendance.getBranch()));
			attendancesResponse.setBranchSeq(attendance.getBranchSeq());
			attendancesResponse.setCampus(Tools.blankInsteadOfNull(attendance.getCampus()));
			attendancesResponse.setCampusSeq(attendance.getCampusSeq());
			attendancesResponse.setClassDate(Tools.blankInsteadOfNull(attendance.getClassDate()));
			attendancesResponse.setClassTeacherName(Tools.blankInsteadOfNull(attendance.getClassTeacherName()));
			attendancesResponse.setClassTime(Tools.blankInsteadOfNull(attendance.getClassTime()));
			attendancesResponse.setIsExcused(attendance.getIsExcused());
			attendancesResponse.setMemo(Tools.blankInsteadOfNull(attendance.getMemo()));
			attendancesResponse.setStudentName(Tools.blankInsteadOfNull(attendance.getStudentName()));
			response.add(attendancesResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (attendances.size() > 0) {
			body.setTotalCount(attendances.get(0).getTotalCount());
		} else {
			body.setTotalCount(0);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/campuses/{campusSeq}/attendances/{attendanceSeq}")
	public CommonResponseResult getAttendance(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "attendanceSeq", required = true) int attendanceSeq) {
		CommonResponseResult result = new CommonResponseResult();

		Attendance attendance = attendanceDao.getAttendance(attendanceSeq);
		AttendanceResponse response = new AttendanceResponse();
		response.setAttendanceSeq(attendance.getAttendanceSeq());
		response.setAttendanceType(Tools.blankInsteadOfNull(attendance.getAttendanceType()));
		response.setIsExcused(attendance.getIsExcused());
		response.setMemo(Tools.blankInsteadOfNull(attendance.getMemo()));
		response.setBranch(Tools.blankInsteadOfNull(attendance.getBranch()));
		response.setBranchSeq(attendance.getBranchSeq());
		response.setCampus(Tools.blankInsteadOfNull(attendance.getCampus()));
		response.setCampusSeq(attendance.getCampusSeq());
		response.setStudentName(Tools.blankInsteadOfNull(attendance.getStudentName()));
		response.setClassDate(Tools.blankInsteadOfNull(attendance.getClassDate()));
		response.setClassRoom(Tools.blankInsteadOfNull(attendance.getClassRoom()));
		response.setClassTeacherName(Tools.blankInsteadOfNull(attendance.getClassTeacherName()));
		response.setClassTime(Tools.blankInsteadOfNull(attendance.getClassTime()));
		response.setRegisterDate(Tools.blankInsteadOfNull(attendance.getFormRegisterDate()));
		response.setRegisterStaffId(Tools.blankInsteadOfNull(attendance.getRegisterStaffId()));
		CommonResponseBody body = new CommonResponseBody();
		if (attendance.getAttendanceSeq() < 1) {
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
	@PostMapping("/branches/{branchSeq}/campuses/{campusSeq}/attendances")
	public CommonResponseResult addAttendance(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @RequestBody AddAttendanceRequest request) {
		CommonResponseResult result = new CommonResponseResult();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isSuccessed = attendanceDao.addAttendance(request.getAttendance(authentication.getName()));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/branches/{branchSeq}/campuses/{campusSeq}/attendances/{attendanceSeq}")
	public CommonResponseResult removeAttendance(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "attendanceSeq", required = true) int attendanceSeq) {
		CommonResponseResult result = new CommonResponseResult();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isSuccessed = attendanceDao.removeAttendance(attendanceSeq, authentication.getName());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

}
