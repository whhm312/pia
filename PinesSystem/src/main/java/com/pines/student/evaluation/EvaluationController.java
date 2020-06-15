package com.pines.student.evaluation;

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
import com.pines.student.common.vo.Evaluation;
import com.pines.student.common.vo.EvaluationItem;
import com.pines.student.common.vo.EvaluationItemOption;
import com.pines.student.common.vo.Student;
import com.pines.student.common.vo.StudySchedule;
import com.pines.student.evaluation.vo.AddEvaluationRequest;
import com.pines.student.evaluation.vo.ChangeEvaluationRequest;
import com.pines.student.evaluation.vo.EvaluateByStudentRequest;
import com.pines.student.evaluation.vo.EvaluationClassesResponse;
import com.pines.student.evaluation.vo.EvaluationForStudentResponse;
import com.pines.student.evaluation.vo.EvaluationItemOptionsForStudentResponse;
import com.pines.student.evaluation.vo.EvaluationItemOptionsResponse;
import com.pines.student.evaluation.vo.EvaluationItemsForStudentResponse;
import com.pines.student.evaluation.vo.EvaluationItemsResponse;
import com.pines.student.evaluation.vo.EvaluationResponse;
import com.pines.student.evaluation.vo.EvaluationsRequest;
import com.pines.student.evaluation.vo.EvaluationsResponse;
import com.pines.student.student.StudentDao;
import com.pines.student.study.StudyScheduleDao;

@RestController
public class EvaluationController {

	@Autowired
	EvaluationDao evaluationDao;

	@Autowired
	StudyScheduleDao studyScheduleDao;

	@Autowired
	StudentDao studentDao;

	@GetMapping("/students/{studentId}/evaluations/recent/evaluation")
	public CommonResponseResult getEvaluationForStudent(@PathVariable(value = "studentId", required = true) String studentId) {
		CommonResponseResult result = new CommonResponseResult();
		EvaluationForStudentResponse evaluationResponse = new EvaluationForStudentResponse();

		Student student = studentDao.getStudent(studentId);
		String termStartDate = Tools.blankInsteadOfNull(student.getFormTermStartDate());
		String termEndDate = Tools.blankInsteadOfNull(student.getFormTermEndDate());
		String classPeriod = "";
		if (Tools.isNotEmpty(termStartDate)) {
			classPeriod = termStartDate;
			if (Tools.isNotEmpty(termEndDate)) {
				classPeriod += " ~ ";
				classPeriod += termEndDate;
			}
		}
		evaluationResponse.setClassPeriod(Tools.blankInsteadOfNull(classPeriod));
		evaluationResponse.setLevel(Tools.blankInsteadOfNull(student.getLevel()));

		List<EvaluationClassesResponse> classesResponse = new ArrayList<EvaluationClassesResponse>();
		EvaluationClassesResponse classResponse = null;
		List<StudySchedule> classes = studyScheduleDao.getStudentStudySchedules(studentId);
		int groupClassCnt = 0;
		int personalClassCnt = 0;
		for (StudySchedule studySchedule : classes) {
			if (studySchedule.getStudyMember() > 0 && studySchedule.getStudyMember() < 2) {
				personalClassCnt++;
			} else if (studySchedule.getStudyMember() > 1) {
				groupClassCnt++;
			}

			classResponse = new EvaluationClassesResponse();
			classResponse.setScheduleSeq(studySchedule.getScheduleSeq());
			classResponse.setTeacherName(Tools.blankInsteadOfNull(studySchedule.getTeacherName()));
			classResponse.setSubject(Tools.blankInsteadOfNull(studySchedule.getSubject()));
			classesResponse.add(classResponse);
		}

		int evaluationSeq = 0;
		List<EvaluationItemOptionsForStudentResponse> optionsResponse = new ArrayList<EvaluationItemOptionsForStudentResponse>();
		EvaluationItemOptionsForStudentResponse optionResponse = null;
		List<EvaluationItemsForStudentResponse> itemsResponse = new ArrayList<EvaluationItemsForStudentResponse>();
		EvaluationItemsForStudentResponse itemResponse = null;
		List<EvaluationItem> evaluations = evaluationDao.getEvaluationItemsForStudent(studentId);
		for (EvaluationItem evaluation : evaluations) {
			for (EvaluationItemOption option : evaluation.getOptions()) {
				optionResponse = new EvaluationItemOptionsForStudentResponse();
				optionResponse.setOptionSeq(option.getOptionSeq());
				optionResponse.setOptionContent(Tools.blankInsteadOfNull(option.getOptionContent()));
				optionsResponse.add(optionResponse);
			}

			itemResponse = new EvaluationItemsForStudentResponse();
			itemResponse.setEvaluationItemSeq(evaluation.getEvaluationItemSeq());
			itemResponse.setItemContent(Tools.blankInsteadOfNull(evaluation.getItemContent()));
			itemResponse.setOptionType(Tools.blankInsteadOfNull(evaluation.getOptionType()));
			itemResponse.setOptions(optionsResponse);
			itemsResponse.add(itemResponse);
			evaluationSeq = evaluation.getEvaluationSeq();

			optionsResponse = new ArrayList<EvaluationItemOptionsForStudentResponse>();
		}

		evaluationResponse.setEvaluationSeq(evaluationSeq);
		evaluationResponse.setGroupClassCnt(groupClassCnt);
		evaluationResponse.setPersonalClassCnt(personalClassCnt);
		evaluationResponse.setClasses(classesResponse);
		evaluationResponse.setItems(itemsResponse);

		CommonResponseBody body = new CommonResponseBody();
		body.setData(evaluationResponse);
		if (evaluations.size() > 0) {
			body.setTotalCount(evaluations.get(0).getTotalCount());
		} else {
			body.setTotalCount(0);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PostMapping("/students/{studentId}/evaluations/{evaluationSeq}/evaluate")
	public CommonResponseResult evaluateByStudent(@PathVariable(value = "studentId", required = true) String studentId, @RequestBody EvaluateByStudentRequest request) throws Exception {
		CommonResponseResult result = new CommonResponseResult();
		boolean isSuccessed = evaluationDao.evaluateByStudent(request.getEvaluationAnswer(studentId));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/evaluations")
	public CommonResponseResult getEvaluations(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestParam Map<String, String> parameters) {
		CommonResponseResult result = new CommonResponseResult();
		List<Evaluation> evaluations = evaluationDao.getEvaluations(new EvaluationsRequest().getRequests(branchSeq, parameters));
		List<EvaluationsResponse> response = new ArrayList<EvaluationsResponse>();
		EvaluationsResponse evaluationsResponse = null;
		for (Evaluation evaluation : evaluations) {
			evaluationsResponse = new EvaluationsResponse();
			evaluationsResponse.setEvaluationSeq(evaluation.getEvaluationSeq());
			evaluationsResponse.setBranchSeq(evaluation.getBranchSeq());
			evaluationsResponse.setBranch(Tools.blankInsteadOfNull(evaluation.getBranch()));
			evaluationsResponse.setSummary(Tools.blankInsteadOfNull(evaluation.getSummary()));
			evaluationsResponse.setRegisterDate(Tools.blankInsteadOfNull(evaluation.getFormRegisterDate()));
			evaluationsResponse.setWriter(Tools.blankInsteadOfNull(evaluation.getWriter()));
			response.add(evaluationsResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (evaluations.size() > 0) {
			body.setTotalCount(evaluations.get(0).getTotalCount());
		} else {
			body.setTotalCount(0);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/evaluations/{evaluationSeq}")
	public CommonResponseResult getEvaluation(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "evaluationSeq", required = true) int evaluationSeq) {
		CommonResponseResult result = new CommonResponseResult();

		EvaluationResponse response = new EvaluationResponse();
		Evaluation evaluation = evaluationDao.getEvaluation(branchSeq, evaluationSeq);
		response.setBranchSeq(evaluation.getBranchSeq());
		response.setBranch(Tools.blankInsteadOfNull(evaluation.getBranch()));
		response.setEvaluationSeq(evaluation.getEvaluationSeq());
		response.setRegisterDate(Tools.blankInsteadOfNull(evaluation.getFormRegisterDate()));
		response.setSummary(Tools.blankInsteadOfNull(evaluation.getSummary()));
		response.setWriter(Tools.blankInsteadOfNull(evaluation.getWriter()));

		List<EvaluationItemOptionsResponse> options = new ArrayList<EvaluationItemOptionsResponse>();
		EvaluationItemOptionsResponse optionResponse = null;
		List<EvaluationItemsResponse> items = new ArrayList<EvaluationItemsResponse>();
		EvaluationItemsResponse itemResponse = null;
		for (EvaluationItem evalItems : evaluation.getItems()) {
			itemResponse = new EvaluationItemsResponse();
			itemResponse.setEvaluationGroupSeq(evalItems.getEvaluationGroupSeq());
			itemResponse.setEvaluationItemSeq(evalItems.getEvaluationItemSeq());
			itemResponse.setItemContent(Tools.blankInsteadOfNull(evalItems.getItemContent()));
			itemResponse.setLanguage(Tools.blankInsteadOfNull(evalItems.getLanguage()));
			itemResponse.setLanguageSeq(evalItems.getLanguageSeq());
			itemResponse.setOptionType(Tools.blankInsteadOfNull(evalItems.getOptionType()));
			itemResponse.setOrderNo(evalItems.getOrderNo());

			for (EvaluationItemOption evalOptions : evalItems.getOptions()) {
				optionResponse = new EvaluationItemOptionsResponse();
				optionResponse.setOptionContent(Tools.blankInsteadOfNull(evalOptions.getOptionContent()));
				optionResponse.setOptionNo(evalOptions.getOptionNo());
				optionResponse.setOptionSeq(evalOptions.getOptionSeq());
				optionResponse.setOrderNo(evalOptions.getOrderNo());
				options.add(optionResponse);
			}
			itemResponse.setOptions(options);
			items.add(itemResponse);

			options = new ArrayList<EvaluationItemOptionsResponse>();
		}
		response.setItems(items);

		CommonResponseBody body = new CommonResponseBody();
		if (evaluation.getEvaluationSeq() < 1) {
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
	@PostMapping("/branches/{branchSeq}/evaluations")
	public CommonResponseResult addEvaluation(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestBody AddEvaluationRequest request) throws Exception {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isSuccessed = evaluationDao.addEvaluation(request.getEvaluation(branchSeq, authentication.getName()));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/branches/{branchSeq}/evaluations/{evaluationSeq}")
	public CommonResponseResult changeEvaluation(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "evaluationSeq", required = true) int evaluationSeq, @RequestBody ChangeEvaluationRequest request) throws Exception {
		CommonResponseResult result = new CommonResponseResult();

		boolean isSuccessed = evaluationDao.newEvaluationItem(request.getEvaluation(branchSeq, evaluationSeq));
		evaluationDao.deleteEvaluationItems(request.getDeleteEvaluationItems());
		evaluationDao.deleteEvaluationOptions(request.getDeleteEvaluationOptions());

		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/branches/{branchSeq}/evaluations/{evaluationSeq}")
	public CommonResponseResult removeEvaluation(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "evaluationSeq", required = true) int evaluationSeq) {
		CommonResponseResult result = new CommonResponseResult();

		boolean isSuccessed = evaluationDao.removeEvaluation(branchSeq, evaluationSeq);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}
}
