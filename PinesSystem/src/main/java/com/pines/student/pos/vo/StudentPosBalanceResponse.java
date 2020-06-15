package com.pines.student.pos.vo;

public class StudentPosBalanceResponse {
	private String balance;

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "StudentNewestPosPointResponse [balance=" + balance + "]";
	}

}
