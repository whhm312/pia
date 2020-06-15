package com.pines.student.exam;

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
import com.pines.student.common.exception.AlreadyAppliedExamException;
import com.pines.student.common.exception.ClosedApplyExamException;
import com.pines.student.common.exception.ClosedCancelExamException;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.Exam;
import com.pines.student.common.vo.ExamResult;
import com.pines.student.common.vo.Student;
import com.pines.student.exam.result.vo.ExamResultsResponse;
import com.pines.student.exam.vo.AddExamMultiCampusesRequest;
import com.pines.student.exam.vo.AddExamRequest;
import com.pines.student.exam.vo.AddExamResponse;
import com.pines.student.exam.vo.ApplicantStudentsExcelView;
import com.pines.student.exam.vo.ApplyExamRequest;
import com.pines.student.exam.vo.ApplyExamResponse;
import com.pines.student.exam.vo.CancelExamRequest;
import com.pines.student.exam.vo.ExamResponse;
import com.pines.student.exam.vo.ExamsRequest;
import com.pines.student.exam.vo.ExamsResponse;
import com.pines.student.exam.vo.RecentExamResponse;
import com.pines.student.login.vo.StaffLoginDetailsVO;
import com.pines.student.login.vo.StudentLoginDetailsVO;

@RestController
public class ExamController {

	@Autowired
	ExamDao examDao;

	@GetMapping("/students/{studentId}/exams/recent/exam")
	public CommonResponseResult getLatestExam(@PathVariable(value = "studentId", required = true) String studentId) {
		CommonResponseResult result = new CommonResponseResult();

		List<Exam> exams = examDao.getRecentExam(studentId);

		List<RecentExamResponse> recentExamsResponse = new ArrayList<RecentExamResponse>();
		RecentExamResponse examResponse = null;
		for (Exam exam : exams) {
			examResponse = new RecentExamResponse();
			examResponse.setExamType(Tools.blankInsteadOfNull(exam.getExamType()));
			examResponse.setExamStartDate(Tools.blankInsteadOfNull(exam.getFormExamStartDate()));
			examResponse.setExamEndDate(Tools.blankInsteadOfNull(exam.getFormExamEndDate()));
			examResponse.setExamSeq(exam.getExamSeq());
			examResponse.setApplicantSeq(exam.getApplicantSeq());
			recentExamsResponse.add(examResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		if (exams.isEmpty()) {
			body.setEmpty();
		} else {
			body.setTotalCount(exams.get(0).getTotalCount());
			body.setData(recentExamsResponse);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/campuses/terms/exams")
	public CommonResponseResult getExams(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestParam Map<String, String> parameters, @RequestParam(name = "campusSeqs[]", required = false) List<Integer> campusSeqs,
			@RequestParam(name = "examTypes[]", required = false) List<String> examTypes) {
		CommonResponseResult result = new CommonResponseResult();

		List<Exam> exams = examDao.getExams(new ExamsRequest().getRequests(branchSeq, parameters, campusSeqs, examTypes));
		List<ExamsResponse> response = new ArrayList<ExamsResponse>();
		ExamsResponse examsResponse = null;
		for (Exam exam : exams) {
			examsResponse = new ExamsResponse();
			examsResponse.setExamSeq(exam.getExamSeq());
			examsResponse.setBranchSeq(exam.getBranchSeq());
			examsResponse.setCampusSeq(exam.getCampusSeq());
			examsResponse.setTermSeq(exam.getTermSeq());
			examsResponse.setBranch(Tools.blankInsteadOfNull(exam.getBranch()));
			examsResponse.setCampus(Tools.blankInsteadOfNull(exam.getCampus()));
			examsResponse.setTerm(Tools.blankInsteadOfNull(exam.getTerm()));
			examsResponse.setExamType(Tools.blankInsteadOfNull(exam.getExamType()));
			examsResponse.setExamStartDate(Tools.blankInsteadOfNull(exam.getFormExamStartDate()));
			examsResponse.setSaveResultCount(exam.getSaveResultCount());
			examsResponse.setUpdateDate(Tools.blankInsteadOfNull(exam.getFormUpdateDate()));
			response.add(examsResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (exams.size() > 0) {
			body.setTotalCount(exams.get(0).getTotalCount());
		} else {
			body.setTotalCount(0);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termSeq}/exams/{examSeq}")
	public CommonResponseResult getExam(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "termSeq", required = true) int termSeq,
			@PathVariable(value = "examSeq", required = true) int examSeq) {
		CommonResponseResult result = new CommonResponseResult();

		ExamResponse response = new ExamResponse();
		List<ExamResultsResponse> examResultsResponse = new ArrayList<ExamResultsResponse>();
		ExamResultsResponse examResultResponse = null;

		Exam exam = examDao.getExam(branchSeq, campusSeq, termSeq, examSeq);
		response.setBranch(Tools.blankInsteadOfNull(exam.getBranch()));
		response.setCampus(Tools.blankInsteadOfNull(exam.getCampus()));
		response.setTerm(Tools.blankInsteadOfNull(exam.getTerm()));
		response.setExamSeq(exam.getExamSeq());
		response.setExamType(Tools.blankInsteadOfNull(exam.getExamType()));
		response.setExamStartDate(Tools.blankInsteadOfNull(exam.getFormExamStartDate()));
		response.setExamEndDate(Tools.blankInsteadOfNull(exam.getFormExamEndDate()));
		response.setUpdateDate(exam.getFormUpdateDate());
		for (ExamResult examResult : exam.getResults()) {
			examResultResponse = new ExamResultsResponse();
			examResultResponse.setExamResultSeq(examResult.getExamResultSeq());
			examResultResponse.setStudentId(Tools.blankInsteadOfNull(examResult.getStudentId()));
			examResultResponse.setStudentName(Tools.blankInsteadOfNull(examResult.getStudentName()));
			examResultResponse.setBirthday(Tools.blankInsteadOfNull(examResult.getBirthday()));
			examResultResponse.setLevel(Tools.blankInsteadOfNull(examResult.getLevel()));
			examResultResponse.setLevelSeq(examResult.getLevelSeq());
			examResultResponse.setResultFilePath(Tools.blankInsteadOfNull(examResult.getResultFilePath()));
			examResultResponse.setRegisterDate(Tools.blankInsteadOfNull(examResult.getFormRegisterDate()));
			examResultsResponse.add(examResultResponse);
		}
		response.setSaveResultCount(examResultsResponse.size());
		response.setResults(examResultsResponse);

		CommonResponseBody body = new CommonResponseBody();
		if (exam.getExamSeq() < 1) {
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
	@PostMapping("/branches/{branchSeq}/campuses/terms/{termSeq}/exams")
	public CommonResponseResult addExamMultiCampuses(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "termSeq", required = true) int termSeq, @RequestBody AddExamMultiCampusesRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		boolean isSuccessed = examDao.addExams(request.getExams(branchSeq, termSeq, authentication.getName()));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termSeq}/exams")
	public CommonResponseResult addExam(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "termSeq", required = true) int termSeq, @RequestBody AddExamRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int examSeq = examDao.addExam(request.getExam(branchSeq, campusSeq, termSeq, authentication.getName()));

		AddExamResponse response = new AddExamResponse();
		response.setExamSeq(examSeq);

		if (examSeq > 0) {
			result.setSuccessHead();
			result.setBody(new CommonResponseBody(1, response));
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/branches/{branchSeq}/campuses/{campusSeq}/terms/{termSeq}/exams/{examSeq}")
	public CommonResponseResult removeExam(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "campusSeq", required = true) int campusSeq, @PathVariable(value = "termSeq", required = true) int termSeq,
			@PathVariable(value = "examSeq", required = true) int examSeq) {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isSuccessed = examDao.removeExam(branchSeq, campusSeq, termSeq, examSeq, authentication.getName());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PostMapping("/exams/{examSeq}/apply")
	public CommonResponseResult applyExam(@PathVariable(value = "examSeq", required = true) int examSeq, @RequestBody ApplyExamRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication.getPrincipal() instanceof StaffLoginDetailsVO) && !(authentication.getPrincipal() instanceof StudentLoginDetailsVO)) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		try {
			int applicantSeq = examDao.applyExam(request.getExamApplicant(examSeq, authentication));
			if (applicantSeq > 0) {
				ApplyExamResponse response = new ApplyExamResponse();
				response.setApplicantSeq(applicantSeq);
				result.setBody(new CommonResponseBody(1, response));
				result.setSuccessHead();
			} else {
				result.setFailureHead(ResultCode.STATUS_500);
			}
			return result;
		} catch (AlreadyAppliedExamException e) {
			result.setFailureHead(ResultCode.STATUS_10003);
			return result;
		} catch (ClosedApplyExamException e) {
			result.setFailureHead(ResultCode.STATUS_10004);
			return result;
		}
	}

	@PostMapping("/exams/{examSeq}/cancel")
	public CommonResponseResult cancelExam(@PathVariable(value = "examSeq", required = true) int examSeq, @RequestBody CancelExamRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication.getPrincipal() instanceof StaffLoginDetailsVO) && !(authentication.getPrincipal() instanceof StudentLoginDetailsVO)) {
			result.setFailureHead(ResultCode.STATUS_401);
			return result;
		}

		try {
			boolean isSuccessed = examDao.cancelExam(request.getExamApplicant(authentication));
			if (isSuccessed) {
				result.setSuccessBody();
				result.setSuccessHead();
			} else {
				result.setFailureHead(ResultCode.STATUS_500);
			}
			return result;
		} catch (ClosedCancelExamException e) {
			result.setFailureHead(ResultCode.STATUS_10005);
			return result;
		}
	}

	@GetMapping("/exams/{examSeq}/students/download")
	public ModelAndView getStudentsDownload(@PathVariable(value = "examSeq", required = true) int examSeq, HttpServletResponse response) {
		List<Student> students = examDao.getStudents(examSeq);

		response.setContentType("application/ms-excel");
		response.setHeader("Content-disposition", "attachment; filename=OPT_Applicant_Student_List.xls");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", students);
		return new ModelAndView(new ApplicantStudentsExcelView(), model);
	}

}
