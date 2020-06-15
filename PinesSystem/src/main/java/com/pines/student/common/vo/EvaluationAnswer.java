package com.pines.student.common.vo;

public class EvaluationAnswer {
	private int totalCount;
	private int answerSeq;
	private int evaluationSeq;
	private int evaluationItemSeq;
	private int optionSeq;
	private int termSeq;
	private int levelSeq;
	private String studentId;
	private String studentName;
	private boolean isDeleted;
	private String registerDate;
	private String formRegisterDate;
	private String deleteDate;
	private String formDeleteDate;
	private String staffId;
	private String memo;
	private String optionType;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getAnswerSeq() {
		return answerSeq;
	}

	public void setAnswerSeq(int answerSeq) {
		this.answerSeq = answerSeq;
	}

	public int getEvaluationSeq() {
		return evaluationSeq;
	}

	public void setEvaluationSeq(int evaluationSeq) {
		this.evaluationSeq = evaluationSeq;
	}

	public int getEvaluationItemSeq() {
		return evaluationItemSeq;
	}

	public void setEvaluationItemSeq(int evaluationItemSeq) {
		this.evaluationItemSeq = evaluationItemSeq;
	}

	public int getOptionSeq() {
		return optionSeq;
	}

	public void setOptionSeq(int optionSeq) {
		this.optionSeq = optionSeq;
	}

	public int getTermSeq() {
		return termSeq;
	}

	public void setTermSeq(int termSeq) {
		this.termSeq = termSeq;
	}

	public int getLevelSeq() {
		return levelSeq;
	}

	public void setLevelSeq(int levelSeq) {
		this.levelSeq = levelSeq;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public String getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getFormDeleteDate() {
		return formDeleteDate;
	}

	public void setFormDeleteDate(String formDeleteDate) {
		this.formDeleteDate = formDeleteDate;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "EvaluationAnswer [totalCount=" + totalCount + ", answerSeq=" + answerSeq + ", evaluationSeq=" + evaluationSeq + ", evaluationItemSeq=" + evaluationItemSeq + ", optionSeq=" + optionSeq + ", termSeq=" + termSeq + ", levelSeq=" + levelSeq + ", studentId=" + studentId
				+ ", studentName=" + studentName + ", isDeleted=" + isDeleted + ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + ", deleteDate=" + deleteDate + ", formDeleteDate=" + formDeleteDate + ", staffId=" + staffId + ", memo=" + memo
				+ ", optionType=" + optionType + "]";
	}

}
