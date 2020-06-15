package com.pines.student.common.vo;

public class StudentPosBalance {
	private int credits;
	private int debits;
	private int balance;

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getDebits() {
		return debits;
	}

	public void setDebits(int debits) {
		this.debits = debits;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "StudentNewestPosBalance [credits=" + credits + ", debits=" + debits + ", balance=" + balance + "]";
	}

}
