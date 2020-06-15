package com.pines.student.exam.result.vo;

import org.springframework.web.multipart.MultipartFile;

import com.pines.student.common.vo.ExamResult;

public class AddExamResultsRequest {
	private int levelSeq;
	private String studentId;
	private MultipartFile file;

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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "AddExamResultsRequest [levelSeq=" + levelSeq + ", studentId=" + studentId + ", file=" + file + "]";
	}

	public ExamResult getExamResult(int examSeq, String staffId, String filePath) {
		ExamResult result = new ExamResult();
		result.setExamSeq(examSeq);
		result.setLevelSeq(levelSeq);
		result.setStudentId(studentId);
		result.setStaffId(staffId);
		result.setResultFilePath(filePath);
		return result;
	}

}
