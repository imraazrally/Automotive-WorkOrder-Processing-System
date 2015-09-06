package com.imraazrally.autoshop.model.customers;

import org.hibernate.Session;

public class SelectCustomerUsingName extends SelectCustomer{

	public SelectCustomerUsingName(Customer customerInfo, Session session) {
		super(customerInfo, session);
	}

	@Override
	public void select() {
		String SQL=CustomerConsts.GET_CUSTOMER_USING_NAME_QUERY;
		execute(String.format(SQL,customerInfo.getFName(),customerInfo.getLName()));
	}

}
