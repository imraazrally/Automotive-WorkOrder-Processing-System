package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.imraazrally.autoshop.model.customers.services.SelectCustomer;

public class SelectCustomerUsingPhone implements SelectCustomer{
	private String phoneNo;
	private Connection dbConnection;
	private ArrayList<Customer> customers;
	
	public SelectCustomerUsingPhone(String phoneNo, Connection dbConnection) throws SQLException{
		this.phoneNo=phoneNo;
		this.dbConnection=dbConnection;
		this.customers=new ArrayList<Customer>();
		retrieveCustomers();
	}
	
	private void retrieveCustomers() throws SQLException{
		// The SQL Query
		String query=String.format(CustomerConsts.GET_CUSTOMER_USING_PHONE_QUERY, phoneNo);
		ResultSet results=dbConnection.createStatement().executeQuery(query);
		
		// for each row of customer information that we retrieve, we build a customer object and store it
		while(results.next())
			customers.add(buildCustomer(results));
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
