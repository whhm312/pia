package com.pines.student.common.exception;

public class AlreadyAppliedExamException extends Exception {
	private static final long serialVersionUID = 3300030300121788298L;

	public AlreadyAppliedExamException() {
		super();
	}

	public AlreadyAppliedExamException(String message) {
		super(message);
	}
}
