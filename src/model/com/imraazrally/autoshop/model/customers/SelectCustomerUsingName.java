package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;

public class SelectCustomerUsingName extends SelectCustomerQuery{
	private String fName;
	private String lName;
	
	public SelectCustomerUsingName(Connection dbConnection, String fName, String lName){
		this.dbConnection=dbConnection;
		this.fName=fName;
		this.lName=lName;
	}
	
	@Override
	public ResultSet execute() {
		try{
			String query=String.format(CustomerConsts.GET_CUSTOMER_USING_NAME_QUERY, fName,lName);
			return dbConnection.createStatement().executeQuery(query);
		}catch(Exception e){e.printStackTrace();}
		return null;
	}
	
}
