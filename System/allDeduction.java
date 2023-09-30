package System;

public class allDeduction {
	
	private date date = new date();
	private transactionalHistory deduct = new transactionalHistory();
	
	public allDeduction() {
		date = null;
		deduct = null;
	}
	public allDeduction(String accountNumber , String typeOfTransaction, double deduction , int day , int month , int year) {
		deduct.getCustomerDetail().setAccountNumber(accountNumber);
		deduct.setTransactionType(typeOfTransaction);
		deduct.setTransactionAmount(deduction);
		date.setDay(day);
		date.setMonth(month);
		date.setYear(year);
	}
	public date getDate() {
		return date;
	}
	public void setDate(date date) {
		this.date = date;
	}
	public transactionalHistory getDeduct() {
		return deduct;
	}
	public void setDeduct(transactionalHistory deduct) {
		this.deduct = deduct;
	}
	
	
}
