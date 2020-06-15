package com.pines.student.evaluation.vo;

import java.util.ArrayList;
import java.util.List;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Evaluation;
import com.pines.student.common.vo.EvaluationItem;
import com.pines.student.common.vo.EvaluationItemOption;

public class ChangeEvaluationRequest {
	private String summary;
	private List<NewEvaluationItemsReqeust> addItems;
	private List<Integer> deleteItems;
	private List<Integer> deleteOptionSeqs;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<NewEvaluationItemsReqeust> getAddItems() {
		return addItems;
	}

	public void setAddItems(List<NewEvaluationItemsReqeust> addItems) {
		this.addItems = addItems;
	}

	public List<Integer> getDeleteItems() {
		return deleteItems;
	}

	public void setDeleteItems(List<Integer> deleteItems) {
		this.deleteItems = deleteItems;
	}

	public List<Integer> getDeleteOptionSeqs() {
		return deleteOptionSeqs;
	}

	public void setDeleteOptionSeqs(List<Integer> deleteOptionSeqs) {
		this.deleteOptionSeqs = deleteOptionSeqs;
	}

	@Override
	public String toString() {
		return "ChangeEvaluationRequest [summary=" + summary + ", addItems=" + addItems + ", deleteItems=" + deleteItems
				+ ", deleteOptionSeqs=" + deleteOptionSeqs + "]";
	}

	public Evaluation getEvaluation(int branchSeq, int evaluationSeq) {
		Evaluation result = new Evaluation();
		result.setBranchSeq(branchSeq);
		result.setEvaluationSeq(evaluationSeq);
		result.setSummary(summary);

		List<EvaluationItemOption> evaluationItemOptions = null;
		EvaluationItemOption evaluationItemOption = null;
		List<EvaluationItem> evaluationItems = new ArrayList<EvaluationItem>();
		EvaluationItem evaluationItem = null;
		if (addItems != null && !addItems.isEmpty()) {
			for (NewEvaluationItemsReqeust item : addItems) {
				evaluationItem = new EvaluationItem();
				evaluationItem.setEvaluationItemSeq(item.getEvaluationItemSeq());
				evaluationItem.setEvaluationGroupSeq(item.getEvaluationGroupSeq());
				evaluationItem.setItemContent(Tools.blankInsteadOfNull(item.getItemContent()));
				evaluationItem.setLanguageSeq(item.getLanguageSeq());
				evaluationItem.setOptionType(Tools.blankInsteadOfNull(item.getOptionType()));
				evaluationItem.setOrderNo(item.getOrderNo());

				evaluationItemOptions = new ArrayList<EvaluationItemOption>();
				if (item.getOptions() != null && !item.getOptions().isEmpty()) {
					for (NewEvaluationItemOptionsRequest option : item.getOptions()) {
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

	public List<EvaluationItem> getDeleteEvaluationItems() {
		List<EvaluationItem> items = new ArrayList<EvaluationItem>();
		EvaluationItem item = null;
		for (Integer itemSeq : deleteItems) {
			item = new EvaluationItem();
			item.setEvaluationItemSeq(Tools.getInt(itemSeq));
			items.add(item);
		}
		return items;
	}

	public List<EvaluationItemOption> getDeleteEvaluationOptions() {
		List<EvaluationItemOption> options = new ArrayList<EvaluationItemOption>();
		EvaluationItemOption option = null;
		for (Integer optionSeq : deleteOptionSeqs) {
			option = new EvaluationItemOption();
			option.setOptionSeq(Tools.getInt(optionSeq));
			options.add(option);
		}
		return options;
	}

}
