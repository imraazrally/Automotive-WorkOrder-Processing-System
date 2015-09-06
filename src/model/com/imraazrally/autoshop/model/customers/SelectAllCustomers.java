package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;

public class SelectAllCustomers extends SelectCustomerQuery {

	public SelectAllCustomers(Connection dbConnection){
		this.dbConnection=dbConnection;
	}
	
	@Override
	public ResultSet execute() {
		try{
			String query=CustomerConsts.RETRIEVE_ALL_CUSTOMERS;
			return dbConnection.createStatement().executeQuery(query);
		}catch(Exception e){e.printStackTrace();}
		return null;
	}

}
