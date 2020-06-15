package com.pines.student.student.admin.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.SearchCondition;

public class StudentsRequest {
	private int branchSeq;
	private int selectedPage;
	private int offset;
	private int[] campusSeqs = new int[0];
	private int[] nationalitySeqs = new int[0];
	private String roomState;
	private List<String> statuses;
	private String name;
	private int termDetailSeq;

	public StudentsRequest(int branchSeq, Map<String, String> parameters, List<Integer> campusSeqs, List<Integer> nationalitySeqs, List<String> statuses) {
		this.branchSeq = branchSeq;
		selectedPage = Tools.getInt(parameters.get("selectedPage"));
		offset = Tools.getInt(parameters.get("offset"));
		termDetailSeq = Tools.getInt(parameters.get("termDetailSeq"));
		roomState = Tools.decode(parameters.get("roomState"));
		name = Tools.decode(parameters.get("name"));

		if (selectedPage < 1) {
			selectedPage = 1;
		}

		if (offset == 0) {
			offset = 10;
		}

		if (campusSeqs != null) {
			this.campusSeqs = new int[campusSeqs.size()];
			int i = 0;
			for (Integer integer : campusSeqs) {
				this.campusSeqs[i++] = Tools.getInt(integer);
			}
		}

		if (nationalitySeqs != null) {
			this.nationalitySeqs = new int[nationalitySeqs.size()];
			int i = 0;
			for (Integer integer : nationalitySeqs) {
				this.nationalitySeqs[i++] = Tools.getInt(integer);
			}
		}

		this.statuses = new ArrayList<String>();
		if (statuses != null) {
			for (String status : statuses) {
				this.statuses.add(status);
			}
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

	public int[] getCampusSeqs() {
		return campusSeqs;
	}

	public void setCampusSeqs(int[] campusSeqs) {
		this.campusSeqs = campusSeqs;
	}

	public int[] getNationalitySeqs() {
		return nationalitySeqs;
	}

	public void setNationalitySeqs(int[] nationalitySeqs) {
		this.nationalitySeqs = nationalitySeqs;
	}

	public String getRoomState() {
		return roomState;
	}

	public void setRoomState(String roomState) {
		this.roomState = roomState;
	}

	public List<String> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<String> statuses) {
		this.statuses = statuses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTermDetailSeq() {
		return termDetailSeq;
	}

	public void setTermDetailSeq(int termDetailSeq) {
		this.termDetailSeq = termDetailSeq;
	}

	@Override
	public String toString() {
		return "StudentsRequest [branchSeq=" + branchSeq + ", selectedPage=" + selectedPage + ", offset=" + offset + ", campusSeqs=" + Arrays.toString(campusSeqs) + ", nationalitySeqs=" + Arrays.toString(nationalitySeqs) + ", roomState=" + roomState + ", statuses=" + statuses
				+ ", name=" + name + ", termDetailSeq=" + termDetailSeq + "]";
	}

	public SearchCondition getConditions() {
		SearchCondition result = new SearchCondition();
		result.setBranchSeq(branchSeq);
		result.setSelectedPage(selectedPage);
		result.setOffset(offset);
		result.setCampusSeqs(campusSeqs);
		result.setNationalitySeqs(nationalitySeqs);
		result.setTermDetailSeq(termDetailSeq);
		result.setRoomState(roomState);
		result.setStatuses(statuses);
		result.setName(name);
		return result;
	}

}
