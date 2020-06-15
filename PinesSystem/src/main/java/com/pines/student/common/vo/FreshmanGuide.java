package com.pines.student.common.vo;

public class FreshmanGuide {
	private int totalCount;
	private int freshmanGuideSeq;
	private int branchSeq;
	private int nationalitySeq;
	private int studentGroupSeq;
	private String nationality;
	private String branch;
	private String groupName;
	private String title;
	private String content;
	private String writerId;
	private String writer;
	private boolean hasAttachment;
	private String fileDownloadUrl;
	private String originalFilename;
	private String registerDate;
	private String formRegisterDate;
	private boolean isDeleted;
	private boolean isDeleteAttachment;
	private String shortFormRegisterDate;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getFreshmanGuideSeq() {
		return freshmanGuideSeq;
	}

	public void setFreshmanGuideSeq(int freshmanGuideSeq) {
		this.freshmanGuideSeq = freshmanGuideSeq;
	}

	public int getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(int branchSeq) {
		this.branchSeq = branchSeq;
	}

	public int getStudentGroupSeq() {
		return studentGroupSeq;
	}

	public void setStudentGroupSeq(int studentGroupSeq) {
		this.studentGroupSeq = studentGroupSeq;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public boolean hasAttachment() {
		return hasAttachment;
	}

	public void setHasAttachment(boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	public String getFileDownloadUrl() {
		return fileDownloadUrl;
	}

	public void setFileDownloadUrl(String fileDownloadUrl) {
		this.fileDownloadUrl = fileDownloadUrl;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public void setDeleteAttachment(boolean isDeleteAttachment) {
		this.isDeleteAttachment = isDeleteAttachment;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getFormRegisterDate() {
		return formRegisterDate;
	}

	public void setFormRegisterDate(String formRegisterDate) {
		this.formRegisterDate = formRegisterDate;
	}

	public boolean isHasAttachment() {
		return hasAttachment;
	}

	public boolean getIsDeleteAttachment() {
		return isDeleteAttachment;
	}

	public void setIsDeleteAttachment(boolean isDeleteAttachment) {
		this.isDeleteAttachment = isDeleteAttachment;
	}

	public int getNationalitySeq() {
		return nationalitySeq;
	}

	public void setNationalitySeq(int nationalitySeq) {
		this.nationalitySeq = nationalitySeq;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getShortFormRegisterDate() {
		return shortFormRegisterDate;
	}

	public void setShortFormRegisterDate(String shortFormRegisterDate) {
		this.shortFormRegisterDate = shortFormRegisterDate;
	}

	@Override
	public String toString() {
		return "FreshmanGuide [totalCount=" + totalCount + ", freshmanGuideSeq=" + freshmanGuideSeq + ", branchSeq=" + branchSeq + ", nationalitySeq=" + nationalitySeq + ", studentGroupSeq=" + studentGroupSeq + ", nationality=" + nationality + ", branch=" + branch
				+ ", groupName=" + groupName + ", title=" + title + ", content=" + content + ", writerId=" + writerId + ", writer=" + writer + ", hasAttachment=" + hasAttachment + ", fileDownloadUrl=" + fileDownloadUrl + ", originalFilename=" + originalFilename
				+ ", registerDate=" + registerDate + ", formRegisterDate=" + formRegisterDate + ", isDeleted=" + isDeleted + ", isDeleteAttachment=" + isDeleteAttachment + ", shortFormRegisterDate=" + shortFormRegisterDate + "]";
	}

}
