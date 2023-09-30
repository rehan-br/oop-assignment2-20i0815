package System;

public class customer {
	private String name;
	private String address;
	private String phoneNumber;
	private String accountNumber;
	private String cnic;
	
	public customer(){
		name = null;
		address = null;
		phoneNumber = null;
		accountNumber = null;
		cnic = null;
	}
	

	public customer(String name, String address, String phoneNumber, String accountNumber , String cnic) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
		this.cnic = cnic;
	}

	public String getCnic() {
		return cnic;
	}


	public void setCnic(String cnic) {
		this.cnic = cnic;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	

}
