package com.pines.student.term;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseBody;
import com.pines.student.common.response.CommonResponseResult;
import com.pines.student.common.vo.Term;
import com.pines.student.term.vo.AddTermRequest;
import com.pines.student.term.vo.ChangeTermRequest;
import com.pines.student.term.vo.TermsResponse;

@RestController
public class TermController {

	@Autowired
	TermDao termDao;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/branches/{branchSeq}/terms")
	public CommonResponseResult getTerms(@PathVariable(value = "branchSeq", required = true) int branchSeq) {
		CommonResponseResult result = new CommonResponseResult();

		List<Term> terms = termDao.getTerms(branchSeq);
		List<TermsResponse> response = new ArrayList<TermsResponse>();
		TermsResponse termResponse = null;
		for (Term term : terms) {
			termResponse = new TermsResponse();
			termResponse.setTermSeq(term.getTermSeq());
			termResponse.setName(term.getTerm());
			termResponse.setStartDate(term.getFormStartDate());
			termResponse.setEndDate(term.getFormEndDate());
			response.add(termResponse);
		}

		CommonResponseBody body = new CommonResponseBody();
		body.setData(response);
		if (terms.size() > 0) {
			body.setTotalCount(terms.get(0).getTotalCount());
		} else {
			body.setTotalCount(0);
		}

		result.setSuccessHead();
		result.setBody(body);
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/branches/{branchSeq}/terms")
	public CommonResponseResult addTerm(@PathVariable(value = "branchSeq", required = true) int branchSeq, @RequestBody AddTermRequest request, HttpSession httpSession) {
		request.setBranchSeq(branchSeq);

		CommonResponseResult result = new CommonResponseResult();
		boolean isSuccessed = termDao.addTerm(request.getTerm());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/branches/{branchSeq}/terms/{termSeq}")
	public CommonResponseResult changeTerm(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "termSeq", required = true) int termSeq, @RequestBody ChangeTermRequest request, HttpSession httpSession) {
		request.setBranchSeq(branchSeq);
		request.setTermSeq(termSeq);

		CommonResponseResult result = new CommonResponseResult();
		boolean isSuccessed = termDao.changeTerm(request.getTerm());
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/branches/{branchSeq}/terms/{termSeq}")
	public CommonResponseResult removeTerm(@PathVariable(value = "branchSeq", required = true) int branchSeq, @PathVariable(value = "termSeq", required = true) int termSeq, HttpSession httpSession) {
		CommonResponseResult result = new CommonResponseResult();
		boolean isSuccessed = termDao.removeTerm(branchSeq, termSeq);
		if (isSuccessed) {
			result.setSuccessHead();
			result.setSuccessBody();
		} else {
			result.setFailureHead(ResultCode.STATUS_500);
		}
		return result;
	}
}
