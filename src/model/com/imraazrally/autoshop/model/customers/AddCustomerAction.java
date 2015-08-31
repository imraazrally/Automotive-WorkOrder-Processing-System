package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;

import com.imraazrally.autoshop.model.customers.services.CustomerServicesActions;


public class AddCustomerAction extends CustomerAction implements CustomerServicesActions {
	private final Connection dbConnection;
	private final Customer customer;

	public AddCustomerAction(Connection dbConnection, Customer customer) {
		this.dbConnection = dbConnection;
		this.customer = customer;
	}

	public boolean service() {
		String query = String.format(CustomerConsts.ADD_CUSTOMER_QUERY, customer.getFName(), customer.getLName(),
				customer.getEmail(), customer.getPhone(), customer.getAddress());

		try {
			dbConnection.createStatement().execute(query);
			// Succesfully added customer
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// If the query couldn't be processed, it means customer couldn't be
		// added
		return false;
	}
}
