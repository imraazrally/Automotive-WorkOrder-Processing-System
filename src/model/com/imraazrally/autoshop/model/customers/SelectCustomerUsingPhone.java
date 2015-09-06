package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;

public class SelectCustomerUsingPhone extends SelectCustomerQuery {
	private String phone;
	
	public SelectCustomerUsingPhone(Connection dbConnection, String phone){
		this.dbConnection=dbConnection;
		this.phone=phone;
	}

	@Override
	public ResultSet execute() {
		try{
			String query=String.format(CustomerConsts.GET_CUSTOMER_USING_PHONE_QUERY, phone);
			return dbConnection.createStatement().executeQuery(query);
		}catch(Exception e){e.printStackTrace();}
		return null;
	}
}
