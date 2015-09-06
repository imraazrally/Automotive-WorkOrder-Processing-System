package com.imraazrally.autoshop.model.customers;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_info")
public class Customer {
	@Id
	private int customerId;
	private String fName;
	private String lName;
	private String email;
	private String phone;
	private String address;

	public Customer (){}
	
	public Customer (int customerId){
		this.customerId=customerId;
	}
	
	public Customer(int customerId, String fName, String lName, String email, String phone, String address) {
		this.customerId=customerId;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phone = phone;
		this.address =address;
	}
	
	public Customer(String fName, String lName, String email, String phone, String address) {
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phone = phone;
		this.address =address;
	}
	
	public void setCustomerId(int customerId){
		this.customerId=customerId;
	}
	
	public void setFName(String fName){
		this.fName=fName;
	}
	
	public void setLName(String lName){
		this.lName=lName;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public void setPhone(String phone){
		this.phone=phone;
	}
	
	public void setAddress(String address){
		this.address=address;
	}
	
	public String getFName() {
		return fName;
	}

	public String getLName() {
		return lName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}
	
	public int getCustomerId(){
		return customerId;
	}
}
