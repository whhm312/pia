package com.pines.student.staff.vo;

import java.util.List;
import java.util.Map;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.SearchCondition;

public class StaffsRequest {
	private int branchSeq;
	private int selectedPage;
	private int offset;
	private int[] nationalitySeqs = new int[0];
	private String name;

	public StaffsRequest(int branchSeq, List<Integer> nationalitySeqs, Map<String, String> parameters) {
		this.branchSeq = branchSeq;
		selectedPage = Tools.getInt(parameters.get("selectedPage"));
		offset = Tools.getInt(parameters.get("offset"));
		name = Tools.blankInsteadOfNull(Tools.decode(parameters.get("name")));

		if (nationalitySeqs != null) {
			this.nationalitySeqs = new int[nationalitySeqs.size()];
			int i = 0;
			for (Integer integer : nationalitySeqs) {
				this.nationalitySeqs[i++] = Tools.getInt(integer);
			}
		}

		if (selectedPage < 1) {
			selectedPage = 1;
		}

		if (offset < 1) {
			offset = 10;
		}
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getSelectedPage() {
		return selectedPage;
	}

	public void setSelectedPage(int selectedPage) {
		this.selectedPage = selectedPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int[] getNationalitySeqs() {
		return nationalitySeqs;
	}

	public void setNationalitySeqs(int[] nationalitySeqs) {
		this.nationalitySeqs = nationalitySeqs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SearchCondition getConditions() {
		SearchCondition result = new SearchCondition();
		result.setBranchSeq(branchSeq);
		result.setSelectedPage(selectedPage);
		result.setOffset(offset);
		result.setNationalitySeqs(nationalitySeqs);
		result.setName(name);
		return result;
	}
}
