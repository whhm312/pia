package com.pines.student.common.vo;

public class PosTransaction {
	private String transactionDate;
	private String transactionDateForm;
	private String transactionName;
	private String menuItemName;
	private int atvId;
	private int ticketId;
	private int debit;
	private int credit;
	private int price;
	private int quantity;

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionDateForm() {
		return transactionDateForm;
	}

	public void setTransactionDateForm(String transactionDateForm) {
		this.transactionDateForm = transactionDateForm;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public int getAtvId() {
		return atvId;
	}

	public void setAtvId(int atvId) {
		this.atvId = atvId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getDebit() {
		return debit;
	}

	public void setDebit(int debit) {
		this.debit = debit;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "PosTransaction [transactionDate=" + transactionDate + ", transactionDateForm=" + transactionDateForm + ", transactionName=" + transactionName + ", menuItemName=" + menuItemName + ", atvId=" + atvId + ", ticketId=" + ticketId + ", debit=" + debit + ", credit="
				+ credit + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
