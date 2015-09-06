package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;

public class SelectCustomerUsingId extends SelectCustomerQuery{
	private String customerId;
	
	public SelectCustomerUsingId(Connection dbConnection, String customerId){
		this.dbConnection=dbConnection;
		this.customerId=customerId;
	}
	
	@Override
	public ResultSet execute() {
		try{
			String query=String.format(CustomerConsts.RETRIEVE_CUSTOMER_USING_ID_QUERY, customerId);
			return dbConnection.createStatement().executeQuery(query);
		}catch(Exception e){e.printStackTrace();}
		return null;
	}
	
}
