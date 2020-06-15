package com.pines.student.pos.vo;

public class RegisterStudentsResponse {
	private int totalStudentSize;
	private int successStudentCount;
	private int failureStudentCount;

	public int getTotalStudentSize() {
		return totalStudentSize;
	}

	public void setTotalStudentSize(int totalStudentSize) {
		this.totalStudentSize = totalStudentSize;
	}

	public int getSuccessStudentCount() {
		return successStudentCount;
	}

	public void setSuccessStudentCount(int successStudentCount) {
		this.successStudentCount = successStudentCount;
	}

	public int getFailureStudentCount() {
		return failureStudentCount;
	}

	public void setFailureStudentCount(int failureStudentCount) {
		this.failureStudentCount = failureStudentCount;
	}

	@Override
	public String toString() {
		return "RegisterStudentsResponse [totalStudentSize=" + totalStudentSize + ", successStudentCount=" + successStudentCount + ", failureStudentCount=" + failureStudentCount + "]";
	}

}
