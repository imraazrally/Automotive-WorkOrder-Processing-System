package com.imraazrally.autoshop.model.customers;

public class Customer {
	private final String fName;
	private final String lName;
	private final String email;
	private final String phone;
	private final String address;

	public Customer(String fName, String lName, String email, String phone, String address) {
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
}
