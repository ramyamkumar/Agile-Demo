package com.capgemini.beans;

public class Account {
	
	private int accountNumber;
	private int amount;
	private int drawnAmount;
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getDrawnAmount() {
		return drawnAmount;
	}
	public void setDrawnAmount(int drawnAmount) {
		this.drawnAmount = drawnAmount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + amount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (amount != other.amount)
			return false;
		return true;
	}
	
	

}
