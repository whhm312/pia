package com.pines.student.notice.vo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.SearchCondition;

public class NoticesRequest {
	private int branchSeq;
	private int selectedPage;
	private int offset;
	private int[] languageSeqs = new int[0];
	private boolean isPopup;
	private String writer;
	private String titleContent;
	private boolean isForAll;

	public NoticesRequest(int branchSeq, Map<String, String> parameters, List<Integer> languageSeqs) {
		this.branchSeq = branchSeq;
		selectedPage = Tools.getInt(parameters.get("selectedPage"));
		offset = Tools.getInt(parameters.get("offset"));
		isPopup = Tools.getBoolean(parameters.get("isPopup"));
		writer = Tools.decode(parameters.get("writer"));
		titleContent = Tools.decode(parameters.get("titleContent"));
		isForAll = Tools.getBoolean(parameters.get("isForAll"));

		if (languageSeqs != null) {
			this.languageSeqs = new int[languageSeqs.size()];
			int i = 0;
			for (Integer integer : languageSeqs) {
				this.languageSeqs[i++] = Tools.getInt(integer);
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

	public int[] getLanguageSeqs() {
		return languageSeqs;
	}

	public void setLanguageSeqs(int[] languageSeqs) {
		this.languageSeqs = languageSeqs;
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

	public boolean getIsForAll() {
		return isForAll;
	}

	public void setIsForAll(boolean isForAll) {
		this.isForAll = isForAll;
	}

	@Override
	public String toString() {
		return "NoticesRequest [branchSeq=" + branchSeq + ", selectedPage=" + selectedPage + ", offset=" + offset + ", languageSeqs=" + Arrays.toString(languageSeqs) + ", isPopup=" + isPopup + ", writer=" + writer + ", titleContent=" + titleContent + ", isForAll=" + isForAll
				+ "]";
	}

	public SearchCondition getConditions() {
		SearchCondition result = new SearchCondition();
		result.setBranchSeq(branchSeq);
		result.setSelectedPage(selectedPage);
		result.setOffset(offset);
		result.setLanguageSeqs(languageSeqs);
		result.setIsPopup(isPopup);
		result.setWriter(writer);
		result.setTitleContent(titleContent);
		result.setIsForAll(isForAll);
		return result;
	}

}
