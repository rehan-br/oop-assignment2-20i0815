package System;

public class bankAccount{
	private customer customerDetail = new customer();
	private date date = new date();
	private double balance;
	private String accountType;
	public bankAccount () {
		balance = -1;
		accountType = null;
		date = null;
		}
	
	
	public bankAccount(String name, String cnic, String address, String phoneNumber, String accountNumber , double balance, int day , int month, int year , String accountType) {
		customerDetail.setName(name);
		customerDetail.setCnic(cnic);
		customerDetail.setAddress(address);
		customerDetail.setPhoneNumber(phoneNumber);
		customerDetail.setAccountNumber(accountNumber);
		this.balance = balance;
		date.setDay(day);
		date.setMonth(month);
		date.setYear(year);
		this.accountType = accountType;
		
	}

	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


	public customer getCustomerDetail() {
		return customerDetail;
	}


	public void setCustomerDetail(customer customerDetail) {
		this.customerDetail = customerDetail;
	}


	public date getDate() {
		return date;
	}


	public void setDate(date date) {
		this.date = date;
	}
	
}
