package com.pines.student.study.vo;

import java.util.List;
import java.util.Map;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.SearchCondition;

public class StudiesRequest {
	public SearchCondition getRequests(int branchSeq, Map<String, String> parameters, List<Integer> campusSeqs) {
		int[] campuses = new int[0];
		if (campusSeqs != null) {
			campuses = new int[campusSeqs.size()];
			int i = 0;
			for (Integer integer : campusSeqs) {
				campuses[i++] = Tools.getInt(integer);
			}
		}
		
		SearchCondition result = new SearchCondition();
		result.setBranchSeq(branchSeq);
		result.setSelectedPage(Tools.getInt(parameters.get("selectedPage"), 1));
		result.setOffset(Tools.getInt(parameters.get("offset"), 10));
		result.setTermSeq(Tools.getInt(parameters.get("termSeq"), 0));
		result.setCampusSeqs(campuses);
		result.setWriter(Tools.decode(parameters.get("writer")));
		return result;
	}

}
