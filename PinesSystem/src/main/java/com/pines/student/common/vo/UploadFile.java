package com.pines.student.common.vo;

import java.io.File;

public class UploadFile {
	private String fileDownloadUrl;
	private String registerDate;
	private String originalFilename;
	private long fileSize;
	private String filePath;
	private File file;

	public String getFileDownloadUrl() {
		return fileDownloadUrl;
	}

	public void setFileDownloadUrl(String fileDownloadUrl) {
		this.fileDownloadUrl = fileDownloadUrl;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "UploadFile [fileDownloadUrl=" + fileDownloadUrl + ", registerDate=" + registerDate + ", originalFilename=" + originalFilename + ", fileSize=" + fileSize + ", filePath=" + filePath + ", file=" + file + "]";
	}

	public Attachment getAttachment() {
		Attachment result = new Attachment();
		result.setFileDownloadUrl(fileDownloadUrl);
		result.setFileSize(fileSize);
		result.setOriginalFilename(originalFilename);
		return result;
	}

}
