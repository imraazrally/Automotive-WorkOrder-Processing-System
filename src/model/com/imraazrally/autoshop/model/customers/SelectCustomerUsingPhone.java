package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class SelectCustomerUsingPhone extends SelectCustomer{

	public SelectCustomerUsingPhone(Customer customerInfo, Session session) {
		super(customerInfo, session);
	}

	@Override
	public void select() {
		String SQL=CustomerConsts.GET_CUSTOMER_USING_PHONE_QUERY;
		execute(String.format(SQL, customerInfo.getPhone()));
	}

}
