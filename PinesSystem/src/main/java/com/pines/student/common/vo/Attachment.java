package com.pines.student.common.vo;

public class Attachment {
	private String originalFilename;
	private String fileDownloadUrl;
	private long fileSize;

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public String getFileDownloadUrl() {
		return fileDownloadUrl;
	}

	public void setFileDownloadUrl(String fileDownloadUrl) {
		this.fileDownloadUrl = fileDownloadUrl;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "Attachment [originalFilename=" + originalFilename + ", fileDownloadUrl=" + fileDownloadUrl + ", fileSize=" + fileSize + "]";
	}

}
