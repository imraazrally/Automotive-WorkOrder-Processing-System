package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveCustomerUsingId {
	private final Connection dbConnection;
	private final String customerId;
	private Customer customer;
	
	public RetrieveCustomerUsingId(Connection dbConnection, String customerId){
		this.dbConnection=dbConnection;
		this.customerId=customerId;
		service();
	}
	
	public boolean service() {
		String query=String.format(CustomerConsts.RETRIEVE_CUSTOMER_USING_ID_QUERY, customerId);
		
		try{
			buildCustomer(dbConnection.createStatement().executeQuery(query));
		}catch(Exception e){e.printStackTrace();}
		
		return false;
	}
	
	public void buildCustomer(ResultSet results) throws SQLException{
		results.next();
		int customerId=results.getInt("customerId");
		String fName=results.getString("fName");
		String lName=results.getString("lName");
		String email=results.getString("email");
		String phone=results.getString("phone");
		String address=results.getString("address");
		//Assinging customer
		customer=new Customer(customerId, fName,lName,email,phone,address);
	}
	
	public Customer getCustomer(){
		return customer;
	}

}
