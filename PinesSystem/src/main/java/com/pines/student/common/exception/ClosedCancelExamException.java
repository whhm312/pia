package com.pines.student.common.exception;

public class ClosedCancelExamException extends Exception {
	private static final long serialVersionUID = 1329436283188373855L;

	public ClosedCancelExamException() {
		super();
	}

	public ClosedCancelExamException(String message) {
		super(message);
	}
}
