package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;

public class RemoveCustomerAction extends CustomerAction {
	private final Connection dbConnection;
	private final String customerId;
	
	public RemoveCustomerAction(Connection dbConnection, String customerId){
		this.dbConnection=dbConnection;
		this.customerId=customerId;
	}
	
	@Override
	public boolean service() {
		String query=String.format(CustomerConsts.REMOVE_CUSTOMER_QUERY, customerId);
		try{
			dbConnection.createStatement().execute(query);
			return true;
		}catch(Exception e){e.printStackTrace();}
		return false;
	}

}
