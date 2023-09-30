package System;

public class transactionalHistory extends bankAccount{
	
	private double transactionAmount;
	private int timeOfTransaction;
	private String transactionType;
	private int transactionEachMonth;
	public transactionalHistory() {
		super();
		transactionAmount = -1; 
		timeOfTransaction = -1;
		transactionType = null;
		transactionEachMonth  = 0;
		}

	public transactionalHistory(String name, String cnic, String address, String phoneNumber, String accountNumber,
			double balance, int day, int month, int year, String accountType , double transactionAmount , int timeOfTransaction , String transactionType, int transactionEachMonth) {
		super(name, cnic, address, phoneNumber, accountNumber, balance, day, month, year, accountType);
		this.transactionAmount = transactionAmount; 
		this.timeOfTransaction = timeOfTransaction;
		this.transactionType = transactionType; 
		this.transactionEachMonth = transactionEachMonth;
	}
	

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public int getTimeOfTransaction() {
		return timeOfTransaction;
	}

	public void setTimeOfTransaction(int timeOfTransaction) {
		this.timeOfTransaction = timeOfTransaction;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getTransactionEachMonth() {
		return transactionEachMonth;
	}

	public void setTransactionEachMonth(int transactionEachMonth) {
		this.transactionEachMonth = transactionEachMonth;
	}

	

	
}
