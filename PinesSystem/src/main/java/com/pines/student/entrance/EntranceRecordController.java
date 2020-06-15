package com.pines.student.entrance;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.EntranceRecord;
import com.pines.student.common.vo.EntranceRecordDetail;
import com.pines.student.entrance.vo.EntranceRecordDetailResponse;
import com.pines.student.entrance.vo.EntranceRecordsExcelView;
import com.pines.student.entrance.vo.EntranceRecordsResponse;
import com.pines.student.entrance.vo.EntrancesRecordsRequest;
import com.pines.student.entrance.vo.RegisterEntranceConsultRequest;

@RestController
public class EntranceRecordController {

	@Autowired
	EntranceRecordDao entranceRecordDao;

	@GetMapping("/branches/{branchSeq}/campuses/{campusSeq}/entrances/records")
	public CommonResponseResult getEntranceRecoards(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @RequestParam Map<String, String> parameters,
			@RequestParam(name = "overtimeExceptionStartTimes[]", required = false) List<String> overtimeExceptionStartTimes, @RequestParam(name = "overtimeExceptionEndTimes[]", required = false) List<String> overtimeExceptionEndTimes) throws UnsupportedEncodingException {
		CommonResponseResult result = new CommonResponseResult();

		EntrancesRecordsRequest request = new EntrancesRecordsRequest();
		List<EntranceRecord> entranceRecords = entranceRecordDao.getEntranceRecoards(request.getConditions(branchSeq, campusSeq, parameters, overtimeExceptionStartTimes, overtimeExceptionEndTimes));

		EntranceRecordsResponse entranceRecordsResponse = new EntranceRecordsResponse();
		List<EntranceRecordsResponse> response = new ArrayList<EntranceRecordsResponse>();
		for (EntranceRecord entranceRecord : entranceRecords) {
			entranceRecordsResponse = new EntranceRecordsResponse();
			entranceRecordsResponse.setEntranceRecordSeq(entranceRecord.getEntranceRecordSeq());
			entranceRecordsResponse.setEntranceName(Tools.blankInsteadOfNull(entranceRecord.getEntranceName()));
			entranceRecordsResponse.setEntranceSeq(entranceRecord.getEntranceSeq());
			entranceRecordsResponse.setStudentName(Tools.blankInsteadOfNull(entranceRecord.getStudentName()));
			entranceRecordsResponse.setInDate(Tools.blankInsteadOfNull(entranceRecord.getFormInDate()));
			entranceRecordsResponse.setOutDate(Tools.blankInsteadOfNull(entranceRecord.getFormOutDate()));
			entranceRecordsResponse.setOvertime(Tools.getTime(entranceRecord.getOutInGapSeconds()));
			entranceRecordsResponse.setConsultSeq(entranceRecord.getConsultSeq());
			entranceRecordsResponse.setStaffName(Tools.blankInsteadOfNull(entranceRecord.getStaffName()));
			entranceRecordsResponse.setBirthday(Tools.blankInsteadOfNull(entranceRecord.getBirthday()));
			entranceRecordsResponse.setLevel(Tools.blankInsteadOfNull(entranceRecord.getLevel()));
			entranceRecordsResponse.setNationality(Tools.blankInsteadOfNull(entranceRecord.getNationality()));
			entranceRecordsResponse.setTerm(Tools.blankInsteadOfNull(entranceRecord.getTerm()));
			entranceRecordsResponse.setRoom(Tools.blankInsteadOfNull(entranceRecord.getRoom()));
			response.add(entranceRecordsResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (response.isEmpty()) {
			body.setTotalCount(0);
		} else {
			body.setTotalCount(entranceRecords.get(0).getTotalCount());
		}

		result.setSuccessHead();
		result.setBody(body);

		return result;
	}

	@GetMapping("/branches/{branchSeq}/campuses/{campusSeq}/entrances/records/download")
	public ModelAndView getEntranceRecordsDownload(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @RequestParam Map<String, String> parameters, HttpServletResponse response,
			@RequestParam(name = "overtimeExceptionStartTimes[]", required = false) List<String> overtimeExceptionStartTimes, @RequestParam(name = "overtimeExceptionEndTimes[]", required = false) List<String> overtimeExceptionEndTimes) throws UnsupportedEncodingException {
		EntrancesRecordsRequest request = new EntrancesRecordsRequest();
		List<EntranceRecord> entranceRecords = entranceRecordDao.getEntranceRecoards(request.getConditions(branchSeq, campusSeq, parameters, overtimeExceptionStartTimes, overtimeExceptionEndTimes));

		String filename = "Entrance_Records_" + parameters.get("searchSection") + "_" + Tools.getTodayStringType("yyyy-MM-dd_HH:mm") + ".xls";
		response.setContentType("application/ms-excel");
		response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("entranceRecords", entranceRecords);
		return new ModelAndView(new EntranceRecordsExcelView(), model);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/campuses/{campusSeq}/entrances/{entranceSeq}/records/{recordSeq}")
	public CommonResponseResult getEntranceConsult(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "entranceSeq", required = true) int entranceSeq,
			@PathVariable(value = "recordSeq", required = true) int recordSeq) {
		CommonResponseResult result = new CommonResponseResult();

		EntranceRecordDetail entranceRecord = entranceRecordDao.getEntranceConsult(recordSeq);
		CommonResponseBody body = new CommonResponseBody();
		if (entranceRecord.getEntranceRecordSeq() > 0) {
			EntranceRecordDetailResponse response = new EntranceRecordDetailResponse();
			response.setEntranceRecordSeq(entranceRecord.getEntranceRecordSeq());
			response.setConsultSeq(entranceRecord.getConsultSeq());
			response.setBranch(Tools.blankInsteadOfNull(entranceRecord.getBranch()));
			response.setCampus(Tools.blankInsteadOfNull(entranceRecord.getCampus()));
			response.setEntranceName(Tools.blankInsteadOfNull(entranceRecord.getEntranceName()));
			response.setStaffName(Tools.blankInsteadOfNull(entranceRecord.getStaffName()));
			response.setIsExcused(entranceRecord.getIsExcused());
			response.setInDate(Tools.blankInsteadOfNull(entranceRecord.getFormInDate()));
			response.setOutDate(Tools.blankInsteadOfNull(entranceRecord.getFormOutDate()));
			response.setOutInGapSeconds(entranceRecord.getOutInGapSeconds());
			response.setStudentName(Tools.blankInsteadOfNull(entranceRecord.getStudentName()));
			response.setConsultDate(Tools.blankInsteadOfNull(entranceRecord.getConsultDate()));
			response.setConsultResult(Tools.blankInsteadOfNull(entranceRecord.getConsultResult()));
			response.setConsultStaffName(Tools.blankInsteadOfNull(entranceRecord.getConsultStaffName()));
			body.setData(response);
			body.setTotalCount(1);
		} else {
			body.setEmpty();
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/campuses/{campusSeq}/entrances/{entranceSeq}/records/{recordSeq}/consult")
	public CommonResponseResult registerEntranceRecordConsult(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "entranceSeq", required = true) int entranceSeq,
			@PathVariable(value = "recordSeq", required = true) int recordSeq, @RequestBody RegisterEntranceConsultRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isSuccessed = entranceRecordDao.registerEntranceRecordConsult(request.getEntranceConsult(recordSeq, authentication.getName()));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/branches/{branchSeq}/campuses/{campusSeq}/entrances/{entranceSeq}/records/{recordSeq}/consult")
	public CommonResponseResult removeEntranceRecordConsult(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "entranceSeq", required = true) int entranceSeq,
			@PathVariable(value = "recordSeq", required = true) int recordSeq) {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isSuccessed = entranceRecordDao.removeEntranceRecordConsult(recordSeq, authentication.getName());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/campuses/{campusSeq}/entrances/{entranceSeq}/records")
	public CommonResponseResult insertMockEntranceRecords(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "entranceSeq", required = true) int entranceSeq) {
		CommonResponseResult result = new CommonResponseResult();
		boolean isSuccessed = entranceRecordDao.insertMockEntranceRecords(campusSeq, entranceSeq);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}
}
