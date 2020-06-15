package com.pines.student.study;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.pines.student.common.FileTools;
import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseHead;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.Student;
import com.pines.student.common.vo.Study;
import com.pines.student.common.vo.StudyAllInOne;
import com.pines.student.common.vo.StudyLevel;
import com.pines.student.common.vo.StudyLevelGrouping;
import com.pines.student.common.vo.StudySchedule;
import com.pines.student.common.vo.StudyScheduleDetail;
import com.pines.student.common.vo.StudyTimetable;
import com.pines.student.common.vo.StudyTimetableDetail;
import com.pines.student.common.vo.StudyUnknownStudent;
import com.pines.student.common.vo.StudyUnknownStudentLevels;
import com.pines.student.study.vo.AddStudyResponse;
import com.pines.student.study.vo.RegisterStudiesRequest;
import com.pines.student.study.vo.ScheduleValidationResultExcelView;
import com.pines.student.study.vo.StudentStudyScheduleResponse;
import com.pines.student.study.vo.StudentsForMakingSchedule;
import com.pines.student.study.vo.StudentsForMakingScheduleExcelView;
import com.pines.student.study.vo.StudiesRequest;
import com.pines.student.study.vo.StudyAllInOneResponse;
import com.pines.student.study.vo.StudyLevelGroupingResponse;
import com.pines.student.study.vo.StudyLevelWithStudentsResponse;
import com.pines.student.study.vo.StudyLevelWithTimetableResponse;
import com.pines.student.study.vo.StudyScheduleByStudyRoomResponse;
import com.pines.student.study.vo.StudyScheduleExcelReadService;
import com.pines.student.study.vo.StudyScheduleResponse;
import com.pines.student.study.vo.StudyScheduleStudentVaildateResult;
import com.pines.student.study.vo.StudyScheduleTeacherVaildateResult;
import com.pines.student.study.vo.StudySchedulesResponse;
import com.pines.student.study.vo.StudyTimetableDetailResponse;
import com.pines.student.study.vo.StudyUnknownStudentLevelsResponse;
import com.pines.student.study.vo.StudyUnknownStudentResponse;
import com.pines.student.study.vo.TeacherScheduleExcelView;

@RestController
public class StudyScheduleController {

	@Autowired
	StudyScheduleDao studyScheduleDao;

	@Autowired
	StudyScheduleExcelReadService excelReadService;

	@Value("${pia.file.download.path}")
	String FILE_DOWNLOAD_PATH;

	@Value("${pia.download.study.schedule.path}")
	String DOWNLOAD_SCHEDULE_PATH;

	@Value("${pia.file.upload.path}")
	String FILE_UPLOAD_PATH;

	@Value("${pia.upload.study.level.path}")
	String UPLOAD_LEVEL_PATH;

	@Value("${pia.upload.study.timetable.path}")
	String UPLOAD_TIMETABLE_PATH;

	@Value("${pia.upload.study.timetable.detail.path}")
	String UPLOAD_PERSONAL_SCHEDULE_PATH;

	@GetMapping("/students/{studentId}/studies/schedule")
	public CommonResponseResult getStudentStudySchedules(@PathVariable(value = "studentId", required = true) String studentId) {
		CommonResponseResult result = new CommonResponseResult();

		List<StudySchedule> studies = studyScheduleDao.getStudentStudySchedules(studentId);
		if (studies.isEmpty()) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		List<StudentStudyScheduleResponse> response = new ArrayList<StudentStudyScheduleResponse>();
		StudentStudyScheduleResponse studyResponse = null;
		for (StudySchedule study : studies) {
			studyResponse = new StudentStudyScheduleResponse();
			studyResponse.setTime(Tools.blankInsteadOfNull(study.getStudyTime()));
			studyResponse.setStudyRoom(Tools.blankInsteadOfNull(study.getStudyRoom()));
			studyResponse.setSubject(Tools.blankInsteadOfNull(study.getSubject()));
			studyResponse.setTeacher(Tools.blankInsteadOfNull(study.getTeacherName()));
			studyResponse.setStudyMember(study.getStudyMember());
			response.add(studyResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (response.isEmpty()) {
			body.setTotalCount(0);
		} else {
			body.setTotalCount(studies.get(0).getTotalCount());
		}
		result.setSuccessHead();
		result.setBody(body);

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/students/{studentId}/studies/schedule/{termDetailSeq}")
	public CommonResponseResult getStudentStudySchedulesForAdmin(@PathVariable(value = "studentId", required = true) String studentId, @PathVariable(value = "termDetailSeq", required = true) int termDetailSeq) {
		CommonResponseResult result = new CommonResponseResult();

		List<StudySchedule> studies = studyScheduleDao.getStudentStudySchedulesForAdmin(studentId, termDetailSeq);
		if (studies.isEmpty()) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		List<StudentStudyScheduleResponse> response = new ArrayList<StudentStudyScheduleResponse>();
		StudentStudyScheduleResponse studyResponse = null;
		for (StudySchedule study : studies) {
			studyResponse = new StudentStudyScheduleResponse();
			studyResponse.setTime(Tools.blankInsteadOfNull(study.getStudyTime()));
			studyResponse.setStudyRoom(Tools.blankInsteadOfNull(study.getStudyRoom()));
			studyResponse.setSubject(Tools.blankInsteadOfNull(study.getSubject()));
			studyResponse.setTeacher(Tools.blankInsteadOfNull(study.getTeacherName()));
			studyResponse.setStudyMember(study.getStudyMember());
			response.add(studyResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (response.isEmpty()) {
			body.setTotalCount(0);
		} else {
			body.setTotalCount(studies.get(0).getTotalCount());
		}
		result.setSuccessHead();
		result.setBody(body);

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/campuses/terms/studies")
	public CommonResponseResult getStudySchedules(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestParam Map<String, String> parameters, @RequestParam(name = "campusSeqs[]", required = false) List<Integer> campusSeqs) {
		CommonResponseResult result = new CommonResponseResult();

		List<Study> studies = studyScheduleDao.getStudySchedules(new StudiesRequest().getRequests(branchSeq, parameters, campusSeqs));

		List<StudySchedulesResponse> response = new ArrayList<StudySchedulesResponse>();
		StudySchedulesResponse studyResponse = null;
		for (Study study : studies) {
			studyResponse = new StudySchedulesResponse();
			studyResponse.setStudySeq(study.getStudySeq());
			studyResponse.setBranchSeq(study.getBranchSeq());
			studyResponse.setBranch(Tools.blankInsteadOfNull(study.getBranch()));
			studyResponse.setCampusSeq(study.getCampusSeq());
			studyResponse.setCampus(Tools.blankInsteadOfNull(study.getCampus()));
			studyResponse.setTerm(Tools.blankInsteadOfNull(study.getTerm()));
			studyResponse.setTermDetailSeq(study.getTermDetailSeq());
			studyResponse.setWriter(Tools.blankInsteadOfNull(study.getWriter()));
			studyResponse.setUpdateDate(Tools.blankInsteadOfNull(study.getFormUpdateDate()));
			response.add(studyResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (response.isEmpty()) {
			body.setTotalCount(0);
		} else {
			body.setTotalCount(studies.get(0).getTotalCount());
		}

		result.setSuccessHead();
		result.setBody(body);

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termDetailSeq}/studies/{studySeq}")
	public CommonResponseResult getStudySchedule(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "termDetailSeq", required = true) int termDetailSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq,
			@PathVariable(value = "studySeq", required = true) int studySeq) {
		CommonResponseResult result = new CommonResponseResult();

		StudyAllInOne study = studyScheduleDao.getStudySchedule(branchSeq, termDetailSeq, campusSeq, studySeq);

		StudyAllInOneResponse studyAllInOneResponse = new StudyAllInOneResponse();
		studyAllInOneResponse.setStudySeq(study.getStudySeq());
		studyAllInOneResponse.setBranchSeq(study.getBranchSeq());
		studyAllInOneResponse.setBranch(Tools.blankInsteadOfNull(study.getBranch()));
		studyAllInOneResponse.setCampus(Tools.blankInsteadOfNull(study.getCampus()));
		studyAllInOneResponse.setTerm(Tools.blankInsteadOfNull(study.getTerm()));
		studyAllInOneResponse.setWriter(Tools.blankInsteadOfNull(study.getWriter()));
		studyAllInOneResponse.setUpdateDate(Tools.blankInsteadOfNull(study.getFormUpdateDate()));

		List<StudyUnknownStudentLevelsResponse> studyUnknownStudentLevelsResponse = new ArrayList<StudyUnknownStudentLevelsResponse>();
		StudyUnknownStudentLevelsResponse studyUnknownStudentLevelResponse = null;
		List<StudyUnknownStudentResponse> studyUnknownStudentsResponse = new ArrayList<StudyUnknownStudentResponse>();
		StudyUnknownStudentResponse studyUnknownStudentResponse = null;
		for (StudyUnknownStudentLevels unknownStudentLevel : study.getUnknownStudents()) {
			studyUnknownStudentLevelResponse = new StudyUnknownStudentLevelsResponse();
			studyUnknownStudentLevelResponse.setLevel(Tools.blankInsteadOfNull(unknownStudentLevel.getLevel()));

			for (StudyUnknownStudent studyUnknownStudent : unknownStudentLevel.getStudents()) {
				studyUnknownStudentResponse = new StudyUnknownStudentResponse();
				studyUnknownStudentResponse.setStudentName(Tools.blankInsteadOfNull(studyUnknownStudent.getStudentName()));
				studyUnknownStudentsResponse.add(studyUnknownStudentResponse);
			}
			studyUnknownStudentLevelResponse.setStudents(studyUnknownStudentsResponse);
			studyUnknownStudentLevelsResponse.add(studyUnknownStudentLevelResponse);

			studyUnknownStudentsResponse = new ArrayList<StudyUnknownStudentResponse>();
		}
		studyAllInOneResponse.setUnknownStudents(studyUnknownStudentLevelsResponse);

		List<StudyLevelGroupingResponse> studyLevelGroupingsResponse = new ArrayList<StudyLevelGroupingResponse>();
		StudyLevelGroupingResponse studyLevelGroupingResponse = null;
		List<StudyLevelWithStudentsResponse> studyLevelsWithStudentsResponse = new ArrayList<StudyLevelWithStudentsResponse>();
		StudyLevelWithStudentsResponse studyLevelWithStudentsResponse = null;
		for (StudyLevel level : study.getLevels()) {
			studyLevelWithStudentsResponse = new StudyLevelWithStudentsResponse();
			studyLevelWithStudentsResponse.setLevelName(Tools.blankInsteadOfNull(level.getLevelName()));
			studyLevelWithStudentsResponse.setWriter(Tools.blankInsteadOfNull(level.getWriter()));
			studyLevelWithStudentsResponse.setUpdateDate(Tools.blankInsteadOfNull(level.getFormUpdateDate()));

			for (StudyLevelGrouping studentStudyLevelGrouping : level.getStudents()) {
				studyLevelGroupingResponse = new StudyLevelGroupingResponse();
				studyLevelGroupingResponse.setCourse(Tools.blankInsteadOfNull(studentStudyLevelGrouping.getCourse()));
				studyLevelGroupingResponse.setStudentName(Tools.blankInsteadOfNull(studentStudyLevelGrouping.getStudentName()));
				studyLevelGroupingResponse.setRequestCourse(Tools.blankInsteadOfNull(studentStudyLevelGrouping.getRequestCourse()));
				studyLevelGroupingResponse.setStudentId(Tools.blankInsteadOfNull(studentStudyLevelGrouping.getStudentId()));
				studyLevelGroupingsResponse.add(studyLevelGroupingResponse);
			}
			studyLevelWithStudentsResponse.setStudentNames(studyLevelGroupingsResponse);
			studyLevelsWithStudentsResponse.add(studyLevelWithStudentsResponse);

			studyLevelGroupingsResponse = new ArrayList<StudyLevelGroupingResponse>();
			studyLevelGroupingResponse = new StudyLevelGroupingResponse();
		}
		studyAllInOneResponse.setStudentLevels(studyLevelsWithStudentsResponse);

		List<StudyTimetableDetailResponse> studyTimetableDetailsResponse = new ArrayList<StudyTimetableDetailResponse>();
		List<StudyLevelWithTimetableResponse> studyLevelsWithTimetablesResponse = new ArrayList<StudyLevelWithTimetableResponse>();
		StudyTimetableDetailResponse studyTimetableDetailResponse = null;
		StudyLevelWithTimetableResponse studyLevelWithTimetableResponse = null;
		for (StudyTimetable studyTimetable : study.getTimetables()) {
			for (StudyTimetableDetail detail : studyTimetable.getDetails()) {
				studyTimetableDetailResponse = new StudyTimetableDetailResponse();
				studyTimetableDetailResponse.setStudyTime(Tools.blankInsteadOfNull(detail.getStudyTime()));
				studyTimetableDetailResponse.setSubject(Tools.blankInsteadOfNull(detail.getSubject()));
				studyTimetableDetailsResponse.add(studyTimetableDetailResponse);
			}

			studyLevelWithTimetableResponse = new StudyLevelWithTimetableResponse();
			studyLevelWithTimetableResponse.setDetails(studyTimetableDetailsResponse);
			studyLevelWithTimetableResponse.setLevelName(Tools.blankInsteadOfNull(studyTimetable.getLevelName()));
			studyLevelsWithTimetablesResponse.add(studyLevelWithTimetableResponse);

			studyTimetableDetailsResponse = new ArrayList<StudyTimetableDetailResponse>();
		}
		studyAllInOneResponse.setStudentTimetables(studyLevelsWithTimetablesResponse);

		List<StudyScheduleResponse> studySchedulesResponse = new ArrayList<StudyScheduleResponse>();
		List<StudyScheduleByStudyRoomResponse> studentStudySchedules = new ArrayList<StudyScheduleByStudyRoomResponse>();
		StudyScheduleResponse scheduleDetailResponse = null;
		StudyScheduleByStudyRoomResponse studyScheduleByStudyRoomResponse = null;
		for (StudySchedule schedule : study.getSchedules()) {
			for (StudyScheduleDetail studentStudyScheduleResponse : schedule.getDetails()) {
				scheduleDetailResponse = new StudyScheduleResponse();
				scheduleDetailResponse.setStudentName(Tools.blankInsteadOfNull(studentStudyScheduleResponse.getStudentName()));
				scheduleDetailResponse.setStudyMember(studentStudyScheduleResponse.getStudyMember());
				scheduleDetailResponse.setStudyTime(Tools.blankInsteadOfNull(studentStudyScheduleResponse.getStudyTime()));
				scheduleDetailResponse.setTeacherName(Tools.blankInsteadOfNull(studentStudyScheduleResponse.getTeacherName()));
				studySchedulesResponse.add(scheduleDetailResponse);
			}

			studyScheduleByStudyRoomResponse = new StudyScheduleByStudyRoomResponse();
			studyScheduleByStudyRoomResponse.setStudyRoom(Tools.blankInsteadOfNull(schedule.getStudyRoom()));
			studyScheduleByStudyRoomResponse.setDetails(studySchedulesResponse);
			studentStudySchedules.add(studyScheduleByStudyRoomResponse);

			studySchedulesResponse = new ArrayList<StudyScheduleResponse>();
		}
		studyAllInOneResponse.setStudentStudySchedules(studentStudySchedules);

		CommonResponseBody body = new CommonResponseBody();
		body.setData(studyAllInOneResponse);
		if (Tools.isEmpty(studyAllInOneResponse.getBranch())) {
			body.setTotalCount(0);
		} else {
			body.setTotalCount(1);
		}

		result.setSuccessHead();
		result.setBody(body);

		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termDetailSeq}/studies")
	public CommonResponseResult addStudy(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "termDetailSeq", required = true) int termDetailSeq) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CommonResponseResult result = new CommonResponseResult();

		int duplicatedStudySeq = studyScheduleDao.duplicatedStudySeq(branchSeq, campusSeq, termDetailSeq);
		if (duplicatedStudySeq > 0) {
			result.setFailureHead(ResultCode.STATUS_10002);
			return result;
		}

		int studySeq = studyScheduleDao.addStudy(branchSeq, campusSeq, termDetailSeq, authentication.getName());
		if (studySeq > 0) {
			AddStudyResponse response = new AddStudyResponse();
			response.setStudySeq(studySeq);

			result.setBody(new CommonResponseBody(1, response));
			result.setSuccessHead();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termDetailSeq}/studies/{studySeq}/levels")
	public CommonResponseResult updateLevels(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "termDetailSeq", required = true) int termDetailSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq,
			@PathVariable(value = "studySeq", required = true) int studySeq, MultipartHttpServletRequest multipartHttpServletRequest) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		CommonResponseResult result = new CommonResponseResult();
		String staffId = authentication.getName();
		// boolean isVaildWriter = studyScheduleDao.isValidWriter(branchSeq, campusSeq,
		// termDetailSeq, studySeq, staffId);
		// if (!isVaildWriter) {
		// result.setFailureHead(ResultCode.STATUS_401);
		// return result;
		// }

		MultipartFile levels = multipartHttpServletRequest.getFile("file");
		if (levels == null || levels.isEmpty()) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		String originalFilename = levels.getOriginalFilename();
		String fileExtension = FileTools.getFileExtension(originalFilename);
		if (Tools.isEmpty(fileExtension)) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		Map<String, List<String>> unKnownStudents = null;
		FileTools.makeDirs(FILE_UPLOAD_PATH + UPLOAD_LEVEL_PATH);
		File destFile = new File(FILE_UPLOAD_PATH + UPLOAD_LEVEL_PATH + FileTools.getUploadFilename(termDetailSeq + "_" + staffId, fileExtension));
		try {
			levels.transferTo(destFile);
			Map<String, List<String>> levelGroupingsMap = excelReadService.readLevel(destFile);

			unKnownStudents = studyScheduleDao.updateLevels(branchSeq, campusSeq, termDetailSeq, studySeq, staffId, levelGroupingsMap);

			studyScheduleDao.insertUnknownStudents(studySeq, staffId, unKnownStudents);
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
			return result;
		}

		result.setSuccessBody();
		result.setSuccessHead();
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termDetailSeq}/studies/{studySeq}/timetable")
	public CommonResponseResult updateTimetable(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "termDetailSeq", required = true) int termDetailSeq,
			@PathVariable(value = "studySeq", required = true) int studySeq, MultipartHttpServletRequest multipartHttpServletRequest, RegisterStudiesRequest request1) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CommonResponseResult result = new CommonResponseResult();

		MultipartFile levels = multipartHttpServletRequest.getFile("file");
		if (levels == null || levels.isEmpty()) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		String originalFilename = levels.getOriginalFilename();
		String fileExtension = FileTools.getFileExtension(originalFilename);
		if (Tools.isEmpty(fileExtension)) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		String staffId = authentication.getName();
		Map<String, Map<String, String>> unKnownTimetable = new LinkedHashMap<String, Map<String, String>>();
		FileTools.makeDirs(FILE_UPLOAD_PATH + UPLOAD_TIMETABLE_PATH);
		File destFile = new File(FILE_UPLOAD_PATH + UPLOAD_TIMETABLE_PATH + FileTools.getUploadFilename(termDetailSeq + "_" + staffId, fileExtension));
		try {
			levels.transferTo(destFile);

			Map<String, Map<String, String>> timetableMap = excelReadService.readTimetable(destFile);
			List<String> unknownLevel = studyScheduleDao.getUnknownLevelname(branchSeq, campusSeq, studySeq, timetableMap);
			if (unknownLevel.size() > 0) {
				CommonResponseHead head = new CommonResponseHead();
				head.setStatus(ResultCode.STATUS_10001.getStatus());
				head.setMessage(ResultCode.STATUS_10001.getMessage());
				result.setBody(new CommonResponseBody(unknownLevel.size(), unknownLevel));
				result.setHead(head);
			} else {
				unKnownTimetable = studyScheduleDao.addTimetable(branchSeq, campusSeq, studySeq, timetableMap, staffId);
				if (unKnownTimetable.isEmpty()) {
					result.setSuccessBody();
					result.setSuccessHead();
				} else {
					result.setBody(new CommonResponseBody(unKnownTimetable.size(), unKnownTimetable));
					result.setSuccessHead();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
			return result;
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termDetailSeq}/studies/{studySeq}/timetable/timebase")
	public CommonResponseResult updateTimetableByTimeBase(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "termDetailSeq", required = true) int termDetailSeq,
			@PathVariable(value = "studySeq", required = true) int studySeq, MultipartHttpServletRequest multipartHttpServletRequest, RegisterStudiesRequest request1) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CommonResponseResult result = new CommonResponseResult();

		MultipartFile levels = multipartHttpServletRequest.getFile("file");
		if (levels == null || levels.isEmpty()) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		String originalFilename = levels.getOriginalFilename();
		String fileExtension = FileTools.getFileExtension(originalFilename);
		if (Tools.isEmpty(fileExtension)) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		String staffId = authentication.getName();
		Map<String, Map<String, String>> unKnownTimetable = new LinkedHashMap<String, Map<String, String>>();
		FileTools.makeDirs(FILE_UPLOAD_PATH + UPLOAD_TIMETABLE_PATH);
		File destFile = new File(FILE_UPLOAD_PATH + UPLOAD_TIMETABLE_PATH + FileTools.getUploadFilename(termDetailSeq + "_" + staffId, fileExtension));
		try {
			levels.transferTo(destFile);

			Map<String, Map<String, String>> timetableMap = excelReadService.readTimetableByTimeBase(destFile);
			List<String> unknownLevel = studyScheduleDao.getUnknownLevelname(branchSeq, campusSeq, studySeq, timetableMap);
			if (unknownLevel.size() > 0) {
				CommonResponseHead head = new CommonResponseHead();
				head.setStatus(ResultCode.STATUS_10001.getStatus());
				head.setMessage(ResultCode.STATUS_10001.getMessage());
				result.setBody(new CommonResponseBody(unknownLevel.size(), unknownLevel));
				result.setHead(head);
			} else {
				unKnownTimetable = studyScheduleDao.addTimetable(branchSeq, campusSeq, studySeq, timetableMap, staffId);
				if (unKnownTimetable.isEmpty()) {
					result.setSuccessBody();
					result.setSuccessHead();
				} else {
					result.setBody(new CommonResponseBody(unKnownTimetable.size(), unKnownTimetable));
					result.setSuccessHead();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
			return result;
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termDetailSeq}/studies/{studySeq}/schedule")
	public CommonResponseResult updateSchedules(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "termDetailSeq", required = true) int termDetailSeq,
			@PathVariable(value = "studySeq", required = true) int studySeq, MultipartHttpServletRequest multipartHttpServletRequest, RegisterStudiesRequest request1) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CommonResponseResult result = new CommonResponseResult();
		String failedFilePath = FILE_DOWNLOAD_PATH + DOWNLOAD_SCHEDULE_PATH + "Schedule_failed_list.txt";
		FileTools.makeDirs(FILE_DOWNLOAD_PATH + DOWNLOAD_SCHEDULE_PATH);

		MultipartFile levels = multipartHttpServletRequest.getFile("file");
		if (levels == null || levels.isEmpty()) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		String originalFilename = levels.getOriginalFilename();
		String fileExtension = FileTools.getFileExtension(originalFilename);
		if (Tools.isEmpty(fileExtension)) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		String staffId = authentication.getName();
		List<String> failedList = new ArrayList<String>();
		FileTools.makeDirs(FILE_UPLOAD_PATH + UPLOAD_PERSONAL_SCHEDULE_PATH);
		File destFile = new File(FILE_UPLOAD_PATH + UPLOAD_PERSONAL_SCHEDULE_PATH + FileTools.getUploadFilename(termDetailSeq + "_" + staffId, fileExtension));
		try {
			levels.transferTo(destFile);
			List<Map<String, String>> detailSchedules = excelReadService.readSchedules(destFile);
			failedList = studyScheduleDao.addSchedules(branchSeq, campusSeq, termDetailSeq, studySeq, detailSchedules, staffId);
			if (!failedList.isEmpty()) {
				Collections.sort(failedList);
				PrintWriter writer = new PrintWriter(failedFilePath, "UTF-8");
				int num = 1;
				for (String failedStudent : failedList) {
					writer.println((num++) + ". " + failedStudent);
				}
				writer.close();
			}
		} catch (FileNotFoundException | UnsupportedEncodingException ee) {
			ee.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			result.setFailureHead(ResultCode.STATUS_500);
			return result;
		}

		if (failedList.isEmpty()) {
			result.setSuccessBody();
			result.setSuccessHead();
		} else {
			result.setBody(new CommonResponseBody(1, failedFilePath));
			result.setSuccessHead();
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termDetailSeq}/studies/{studySeq}")
	public CommonResponseResult removeStudy(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "termDetailSeq", required = true) int termDetailSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq,
			@PathVariable(value = "studySeq", required = true) int studySeq) {

		CommonResponseResult result = new CommonResponseResult();
		// Authentication authentication =
		// SecurityContextHolder.getContext().getAuthentication();
		// boolean isVaildWriter = studyScheduleDao.isValidWriter(branchSeq, campusSeq,
		// termDetailSeq, studySeq, authentication.getName());
		// if (!isVaildWriter) {
		// result.setFailureHead(ResultCode.STATUS_401);
		// return result;
		// }

		boolean isSuccessed = studyScheduleDao.removeStudy(studySeq);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@GetMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termDetailSeq}/studies/{studySeq}/schedule/validate")
	public ModelAndView validateSchedule(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "termDetailSeq", required = true) int termDetailSeq,
			@PathVariable(value = "studySeq", required = true) int studySeq, HttpServletResponse response) {

		List<StudySchedule> validateDuplicationTeachers = studyScheduleDao.getDuplicationTeachers(studySeq);
		List<StudyScheduleTeacherVaildateResult> studyScheduleTeacherVaildateResults = new ArrayList<StudyScheduleTeacherVaildateResult>();
		StudyScheduleTeacherVaildateResult studyScheduleTeacherVaildateResult = null;
		for (StudySchedule schedule : validateDuplicationTeachers) {
			studyScheduleTeacherVaildateResult = new StudyScheduleTeacherVaildateResult();
			studyScheduleTeacherVaildateResult.setStudyRoom(Tools.blankInsteadOfNull(schedule.getStudyRoom()));
			studyScheduleTeacherVaildateResult.setStudyTime(Tools.blankInsteadOfNull(schedule.getStudyTime()));
			studyScheduleTeacherVaildateResult.setTeacherName(Tools.blankInsteadOfNull(schedule.getTeacherName()));

			studyScheduleTeacherVaildateResults.add(studyScheduleTeacherVaildateResult);
		}

		List<StudySchedule> validateDuplicationStudents = studyScheduleDao.getDuplicationStudents(studySeq);
		List<StudyScheduleStudentVaildateResult> validateDuplicationStudentsResults = new ArrayList<StudyScheduleStudentVaildateResult>();
		StudyScheduleStudentVaildateResult validateDuplicationStudentsResult = null;
		for (StudySchedule schedule : validateDuplicationStudents) {
			validateDuplicationStudentsResult = new StudyScheduleStudentVaildateResult();
			validateDuplicationStudentsResult.setStudyRoom(Tools.blankInsteadOfNull(schedule.getStudyRoom()));
			validateDuplicationStudentsResult.setStudyTime(Tools.blankInsteadOfNull(schedule.getStudyTime()));
			validateDuplicationStudentsResult.setStudentName(Tools.blankInsteadOfNull(schedule.getStudentName()));

			validateDuplicationStudentsResults.add(validateDuplicationStudentsResult);
		}

		response.setContentType("application/ms-excel");
		response.setHeader("Content-disposition", "attachment; filename=validationResults.xls");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("studentResults", validateDuplicationStudentsResults);
		model.put("teacherResults", studyScheduleTeacherVaildateResults);
		return new ModelAndView(new ScheduleValidationResultExcelView(), model);
	}

	@GetMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termDetailSeq}/studies/{studySeq}/schedule/students")
	public ModelAndView getStudents(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "termDetailSeq", required = true) int termDetailSeq,
			@PathVariable(value = "studySeq", required = true) int studySeq, HttpServletResponse response) {

		List<Student> students = studyScheduleDao.getStudents(branchSeq, campusSeq);
		List<StudentsForMakingSchedule> studentsForMakingSchedules = new ArrayList<StudentsForMakingSchedule>();
		StudentsForMakingSchedule studyScheduleTeacherVaildateResult = null;
		for (Student student : students) {
			studyScheduleTeacherVaildateResult = new StudentsForMakingSchedule();
			studyScheduleTeacherVaildateResult.setBranch(Tools.blankInsteadOfNull(student.getBranch()));
			studyScheduleTeacherVaildateResult.setCampus(Tools.blankInsteadOfNull(student.getCampus()));
			studyScheduleTeacherVaildateResult.setTerm(Tools.blankInsteadOfNull(student.getTerm()));
			studyScheduleTeacherVaildateResult.setStudentName(Tools.blankInsteadOfNull(student.getName()));
			studyScheduleTeacherVaildateResult.setNationality(Tools.blankInsteadOfNull(student.getNationalityCode()));
			studyScheduleTeacherVaildateResult.setPreLevel(Tools.blankInsteadOfNull(student.getLevel()));
			studyScheduleTeacherVaildateResult.setArrivalDate(Tools.blankInsteadOfNull(student.getFormDateOfStartContract()));
			studyScheduleTeacherVaildateResult.setDepartureDate(Tools.blankInsteadOfNull(student.getFormDateOfEndContract()));
			studyScheduleTeacherVaildateResult.setCourse(Tools.blankInsteadOfNull(student.getCourse()));
			studyScheduleTeacherVaildateResult.setSex(Tools.blankInsteadOfNull(student.getSex()));
			studentsForMakingSchedules.add(studyScheduleTeacherVaildateResult);
		}

		response.setContentType("application/ms-excel");
		response.setHeader("Content-disposition", "attachment; filename=Students.xls");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", studentsForMakingSchedules);
		return new ModelAndView(new StudentsForMakingScheduleExcelView(), model);
	}

	@GetMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termSeq}/studies/{studySeq}/schedule/teachers")
	public ModelAndView getTeachersSchedule(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "termSeq", required = true) int termSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq,
			@PathVariable(value = "studySeq", required = true) int studySeq, HttpServletResponse response) {

		StudyAllInOne studyAllInOne = studyScheduleDao.getTeachersSchedule(studySeq);

		response.setContentType("application/ms-excel");
		response.setHeader("Content-disposition", "attachment; filename=TeachersSchedule.xls");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("schedule", studyAllInOne);
		return new ModelAndView(new TeacherScheduleExcelView(), model);

	}

	@GetMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termSeq}/studies/{studySeq}/schedule/students")
	public ModelAndView getAllStudentsSchedule(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "termSeq", required = true) int termSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq,
			@PathVariable(value = "studySeq", required = true) int studySeq, HttpServletResponse response) {

		StudyAllInOne studyAllInOne = studyScheduleDao.getAllStudentsSchedule(studySeq);

		response.setContentType("application/ms-excel");
		response.setHeader("Content-disposition", "attachment; filename=TeachersSchedule.xls");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("schedule", studyAllInOne);
		return new ModelAndView(new TeacherScheduleExcelView(), model);

	}
}
