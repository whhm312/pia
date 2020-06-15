package com.pines.student.evaluation.result;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.Evaluation;
import com.pines.student.common.vo.EvaluationItem;
import com.pines.student.common.vo.EvaluationItemOption;
import com.pines.student.common.vo.EvaluationResult;
import com.pines.student.evaluation.result.vo.EvaluationResultsRequest;
import com.pines.student.evaluation.result.vo.EvaluationResultsResponse;
import com.pines.student.evaluation.result.vo.EvaluatiosResultsResponse;
import com.pines.student.evaluation.vo.AddEvaluationRequest;
import com.pines.student.evaluation.vo.EvaluationItemOptionsResponse;
import com.pines.student.evaluation.vo.EvaluationItemsResponse;

@RestController
public class EvaluationResultController {

	@Autowired
	EvaluationResultDao evaluationResultDao;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/evaluations/results")
	public CommonResponseResult getEvaluationResults(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestBody EvaluationResultsRequest request) {
		CommonResponseResult result = new CommonResponseResult();
		List<EvaluationResult> evaluations = evaluationResultDao.getEvaluationResults(request.getEvaluationResults(branchSeq));
		List<EvaluatiosResultsResponse> response = new ArrayList<EvaluatiosResultsResponse>();
		EvaluatiosResultsResponse evaluationsResponse = null;
		for (EvaluationResult evaluation : evaluations) {
			evaluationsResponse = new EvaluatiosResultsResponse();
			evaluationsResponse.setEvalutaionSeq(evaluation.getEvalutaionSeq());
			evaluationsResponse.setBranch(evaluation.getBranch());
			evaluationsResponse.setTerm(evaluation.getTerm());
			evaluationsResponse.setAnswerCount(evaluation.getAnswerCount());
			evaluationsResponse.setTermStudentCount(evaluation.getTermStudentCount());
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
	@GetMapping("/branches/{branchSeq}/evaluations/{evaluationSeq}/results")
	public CommonResponseResult getEvaluationResults(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "evaluationSeq", required = true) int evaluationSeq) {
		CommonResponseResult result = new CommonResponseResult();

		EvaluationResultsResponse response = new EvaluationResultsResponse();
		Evaluation evaluation = evaluationResultDao.getEvaluationResults(branchSeq, evaluationSeq);

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
				optionResponse.setOptionSeq(evalOptions.getOptionSeq());
				optionResponse.setOrderNo(evalOptions.getOrderNo());
				options.add(optionResponse);
			}
			itemResponse.setOptions(options);
			items.add(itemResponse);

			options = new ArrayList<EvaluationItemOptionsResponse>();
		}

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
	@PostMapping("/branches/{branchSeq}/evaluations/{evaluationSeq}/results")
	public CommonResponseResult addEvaluation(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "evaluationSeq", required = true) int evaluationSeq, @RequestBody AddEvaluationRequest request) throws Exception {
		CommonResponseResult result = new CommonResponseResult();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isSuccessed = evaluationResultDao.addEvaluation(request.getEvaluation(branchSeq, authentication.getName()));
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

}
