package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImportCustomersFromDb {
	private Connection dbConnection;
	private ArrayList <Customer> customers;
	
	public ImportCustomersFromDb(Connection dbConnection, ResultSet results) throws SQLException{
		this.dbConnection=dbConnection;
		customers=new ArrayList<Customer>();
		retrieveCustomers(results);
	}
	
	private void retrieveCustomers(ResultSet results) throws SQLException{
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
