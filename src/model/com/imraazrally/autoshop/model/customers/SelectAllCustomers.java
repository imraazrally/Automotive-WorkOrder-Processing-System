package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class SelectAllCustomers extends SelectCustomer{

	public SelectAllCustomers(Customer customerInfo, Session session) {
		super(customerInfo, session);
	}

	@Override
	public void select() {
		execute(CustomerConsts.RETRIEVE_ALL_CUSTOMERS);
	}
	
}
