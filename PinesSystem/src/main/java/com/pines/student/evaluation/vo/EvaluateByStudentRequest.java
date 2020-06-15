package com.pines.student.evaluation.vo;

import java.util.ArrayList;
import java.util.List;

import com.pines.student.common.vo.EvaluationAnswer;

public class EvaluateByStudentRequest {
	private int evaluationSeq;
	private List<EvaluateItemByStudentRequest> items;

	public int getEvaluationSeq() {
		return evaluationSeq;
	}

	public void setEvaluationSeq(int evaluationSeq) {
		this.evaluationSeq = evaluationSeq;
	}

	public List<EvaluateItemByStudentRequest> getItems() {
		return items;
	}

	public void setItems(List<EvaluateItemByStudentRequest> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "EvaluateByStudentRequest [evaluationSeq=" + evaluationSeq + ", items=" + items + "]";
	}

	public List<EvaluationAnswer> getEvaluationAnswer(String studentId) {
		List<EvaluationAnswer> results = new ArrayList<EvaluationAnswer>();
		EvaluationAnswer answer = null;
		for (EvaluateItemByStudentRequest answered : items) {
			answer = new EvaluationAnswer();
			answer.setEvaluationSeq(evaluationSeq);
			answer.setEvaluationItemSeq(answered.getEvaluationItemSeq());
			answer.setOptionSeq(answered.getOptionSeq());
			answer.setOptionType(answered.getOptionType());
			answer.setMemo(answered.getOpinion());
			answer.setStudentId(studentId);
			results.add(answer);
		}
		return results;
	}

}
