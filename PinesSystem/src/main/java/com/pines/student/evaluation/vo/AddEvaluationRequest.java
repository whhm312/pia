package com.pines.student.evaluation.vo;

import java.util.ArrayList;
import java.util.List;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Evaluation;
import com.pines.student.common.vo.EvaluationItem;
import com.pines.student.common.vo.EvaluationItemOption;

public class AddEvaluationRequest {
	private String summary;
	private List<AddEvaluationItemsReqeust> items;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<AddEvaluationItemsReqeust> getItems() {
		return items;
	}

	public void setItems(List<AddEvaluationItemsReqeust> items) {
		this.items = items;
	}

	public Evaluation getEvaluation(int branchSeq, String staffId) {
		Evaluation result = new Evaluation();
		result.setBranchSeq(branchSeq);
		result.setStaffId(staffId);
		result.setSummary(summary);

		List<EvaluationItemOption> evaluationItemOptions = null;
		EvaluationItemOption evaluationItemOption = null;
		List<EvaluationItem> evaluationItems = new ArrayList<EvaluationItem>();
		EvaluationItem evaluationItem = null;
		if (items != null && !items.isEmpty()) {
			for (AddEvaluationItemsReqeust item : items) {
				evaluationItem = new EvaluationItem();
				evaluationItem.setEvaluationGroupSeq(item.getEvaluationGroupSeq());
				evaluationItem.setItemContent(Tools.blankInsteadOfNull(item.getItemContent()));
				evaluationItem.setLanguageSeq(item.getLanguageSeq());
				evaluationItem.setOptionType(Tools.blankInsteadOfNull(item.getOptionType()));
				evaluationItem.setOrderNo(item.getOrderNo());

				evaluationItemOptions = new ArrayList<EvaluationItemOption>();
				if (item.getOptions() != null && !item.getOptions().isEmpty()) {
					for (AddEvaluationItemOptionsRequest option : item.getOptions()) {
						evaluationItemOption = new EvaluationItemOption();
						evaluationItemOption.setOptionContent(Tools.blankInsteadOfNull(option.getOptionContent()));
						evaluationItemOption.setOrderNo(option.getOrderNo());
						evaluationItemOption.setOptionNo(option.getOptionNo());
						evaluationItemOptions.add(evaluationItemOption);
					}
				}
				evaluationItem.setOptions(evaluationItemOptions);

				evaluationItems.add(evaluationItem);
			}
		}
		result.setItems(evaluationItems);
		return result;
	}

}
