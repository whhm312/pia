package com.pines.student.guide.vo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.SearchCondition;

public class FreshmanGuidesRequest {
	private int branchSeq;
	private int selectedPage;
	private int offset;
	private int[] nationalitySeqs = new int[0];
	private int groupSeq;
	private String writer;
	private String titleContent;

	public FreshmanGuidesRequest(int branchSeq, List<Integer> nationalitySeqs, Map<String, String> parameters) {
		this.branchSeq = branchSeq;
		selectedPage = Tools.getInt(parameters.get("selectedPage"));
		offset = Tools.getInt(parameters.get("offset"));
		groupSeq = Tools.getInt(parameters.get("groupSeq"));
		writer = Tools.decode(parameters.get("writer"));
		titleContent = Tools.decode(parameters.get("titleContent"));

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

	public int getGroupSeq() {
		return groupSeq;
	}

	public void setGroupSeq(int groupSeq) {
		this.groupSeq = groupSeq;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitleContent() {
		return titleContent;
	}

	public void setTitleContent(String titleContent) {
		this.titleContent = titleContent;
	}

	@Override
	public String toString() {
		return "FreshmanGuidesRequest [branchSeq=" + branchSeq + ", selectedPage=" + selectedPage + ", offset=" + offset + ", nationalitySeqs=" + Arrays.toString(nationalitySeqs) + ", groupSeq=" + groupSeq + "]";
	}

	public SearchCondition getConditions() {
		SearchCondition result = new SearchCondition();
		result.setBranchSeq(branchSeq);
		result.setSelectedPage(selectedPage);
		result.setOffset(offset);
		result.setNationalitySeqs(nationalitySeqs);
		result.setGroupSeq(groupSeq);
		result.setWriter(writer);
		result.setTitleContent(titleContent);
		return result;
	}

}
