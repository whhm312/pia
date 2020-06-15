package com.pines.student.evaluation.result.vo;

import com.pines.student.common.vo.SearchCondition;

public class EvaluationResultsRequest {
	private int termSeq;

	public int getTermSeq() {
		return termSeq;
	}

	public void setTermSeq(int termSeq) {
		this.termSeq = termSeq;
	}

	@Override
	public String toString() {
		return "EvaluationResultsRequest [termSeq=" + termSeq + "]";
	}

	public SearchCondition getEvaluationResults(int branchSeq) {
		SearchCondition result = new SearchCondition();
		result.setBranchSeq(branchSeq);
		result.setTermSeq(termSeq);
		return result;
	}

}
