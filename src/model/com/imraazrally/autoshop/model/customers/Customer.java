package com.imraazrally.autoshop.model.customers;

public class Customer {
	private int customerId;
	private String fName;
	private String lName;
	private String email;
	private String phone;
	private String address;

	public Customer(String fName, String lName, String email, String phone, String address) {
		this.fName = new String(fName);
		this.lName = new String(lName);
		this.email = new String(email);
		this.phone = new String(phone);
		this.address = new String(address);
	}
	
	public Customer(int customerId, String fName, String lName, String email, String phone, String address){
		this.customerId=customerId;
		this.fName = new String(fName);
		this.lName = new String(lName);
		this.email = new String(email);
		this.phone = new String(phone);
		this.address = new String(address);
	}
	
	public String getFName() {
		return new String(fName);
	}

	public String getLName() {
		return new String(lName);
	}

	public String getEmail() {
		return new String(email);
	}

	public String getPhone() {
		return new String(phone);
	}

	public String getAddress() {
		return new String(address);
	}
	
	public int getCustomerId(){
		return customerId;
	}
}
