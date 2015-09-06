package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class SelectCustomerUsingId extends SelectCustomer{

	public SelectCustomerUsingId(Customer customerInfo, Session session) {
		super(customerInfo, session);
	}

	@Override
	public void select() {
		String customerId=Integer.toString(customerInfo.getCustomerId());
		execute(String.format(CustomerConsts.RETRIEVE_CUSTOMER_USING_ID_QUERY, customerId));
	}

}
