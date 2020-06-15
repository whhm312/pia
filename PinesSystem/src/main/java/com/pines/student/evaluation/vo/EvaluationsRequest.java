package com.pines.student.evaluation.vo;

import java.util.Map;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.SearchCondition;

public class EvaluationsRequest {

	public SearchCondition getRequests(int branchSeq, Map<String, String> parameters) {
		SearchCondition result = new SearchCondition();
		result.setBranchSeq(branchSeq);
		result.setSelectedPage(Tools.getInt(parameters.get("selectedPage"), 1));
		result.setOffset(Tools.getInt(parameters.get("offset"), 10));
		return result;
	}

}
