package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectCustomerUsingName {
	private String fName;
	private String lName;
	private Connection dbConnection;
	private ArrayList <Customer> customers;
	
	public SelectCustomerUsingName(String fName, String lName, Connection dbConnection) throws SQLException{
		this.fName=fName;
		this.lName=lName;
		this.dbConnection=dbConnection;
		customers=new ArrayList<Customer>();
		retrieveCustomers();
	}
	
	private void retrieveCustomers() throws SQLException{
		String query=String.format(CustomerConsts.GET_CUSTOMER_USING_NAME_QUERY, fName,lName);
		ResultSet results=dbConnection.createStatement().executeQuery(query);
		//Storing the customers into a list
		while(results.next())customers.add(buildCustomer(results));
	}
	
	public Customer buildCustomer(ResultSet results) throws SQLException{
		//Building a Customer and returning it
		int customerId=results.getInt("customerId");
		String fName=results.getString("fName");
		String lName=results.getString("lName");
		String email=results.getString("email");
		String phone=results.getString("phone");
		String address=results.getString("address");
		return new Customer(customerId, fName, lName, email, phone,address);
	}
	
	
	public ArrayList<Customer> getCustomers(){
		return customers;
	}
	
}
