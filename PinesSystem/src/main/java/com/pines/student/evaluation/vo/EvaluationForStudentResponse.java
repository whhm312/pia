package com.pines.student.evaluation.vo;

import java.util.List;

public class EvaluationForStudentResponse {
	private int evaluationSeq;
	private String classPeriod;
	private String level;
	private int groupClassCnt;
	private int personalClassCnt;
	private List<EvaluationItemsForStudentResponse> items;
	private List<EvaluationClassesResponse> classes;

	public int getEvaluationSeq() {
		return evaluationSeq;
	}

	public void setEvaluationSeq(int evaluationSeq) {
		this.evaluationSeq = evaluationSeq;
	}

	public String getClassPeriod() {
		return classPeriod;
	}

	public void setClassPeriod(String classPeriod) {
		this.classPeriod = classPeriod;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getGroupClassCnt() {
		return groupClassCnt;
	}

	public void setGroupClassCnt(int groupClassCnt) {
		this.groupClassCnt = groupClassCnt;
	}

	public int getPersonalClassCnt() {
		return personalClassCnt;
	}

	public void setPersonalClassCnt(int personalClassCnt) {
		this.personalClassCnt = personalClassCnt;
	}

	public List<EvaluationItemsForStudentResponse> getItems() {
		return items;
	}

	public void setItems(List<EvaluationItemsForStudentResponse> items) {
		this.items = items;
	}

	public List<EvaluationClassesResponse> getClasses() {
		return classes;
	}

	public void setClasses(List<EvaluationClassesResponse> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "EvaluationForStudentResponse [evaluationSeq=" + evaluationSeq + ", classPeriod=" + classPeriod + ", level=" + level + ", groupClassCnt=" + groupClassCnt + ", personalClassCnt=" + personalClassCnt + ", items=" + items + ", classes=" + classes + "]";
	}

}
