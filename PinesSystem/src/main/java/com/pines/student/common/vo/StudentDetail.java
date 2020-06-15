package com.pines.student.common.vo;

import java.util.List;

public class StudentDetail extends Student {
	private List<Violation> violations;
	private List<Request> requests;
	private List<Consulting> consultings;

	public List<Violation> getViolations() {
		return violations;
	}

	public void setViolations(List<Violation> violations) {
		this.violations = violations;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<Consulting> getConsultings() {
		return consultings;
	}

	public void setConsultings(List<Consulting> consultings) {
		this.consultings = consultings;
	}

	@Override
	public String toString() {
		return "StudentDetail [violations=" + violations + ", requests=" + requests + ", consultings=" + consultings + "]";
	}

}
