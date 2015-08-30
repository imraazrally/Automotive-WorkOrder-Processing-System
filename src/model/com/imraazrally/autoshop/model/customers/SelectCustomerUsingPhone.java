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
	
	public void retrieveCustomers() throws SQLException{
		// The SQL Query
		String query=String.format(CustomerConsts.GET_CUSTOMER_USING_PHONE_QUERY, phoneNo);
		ResultSet results=dbConnection.createStatement().executeQuery(query);
		
		// for each row of customer information that we retrieve, we build a customer object and store it
		while(results.next()){
			try{
				customers.add(buildCustomer(results));
			}catch(Exception e){e.printStackTrace();}
		}
		
	}
	
	public Customer buildCustomer(ResultSet results) throws SQLException{
		//Building a Customer
		Customer customer= new Customer(
								results.getInt("customerId"),
								results.getString("fName"),
								results.getString("lName"),
								results.getString("email"),
								results.getString("phone"),
								results.getString("address")
							);
		
		return customer;
	}
	
	public ArrayList<Customer> getCustomers(){
		return customers;
	}

}
