package com.imraazrally.autoshop.model.customers;

import java.io.PrintWriter;
import java.sql.Connection;

/*
 Given an action (a subclass of CustomerAction- ex: AddCustomerAction, RemoveCustomerAction), 
 the execute method calls the service() method of the given action.
 */
public class CustomerServices implements com.imraazrally.autoshop.model.customers.services.CustomerServices {
	public boolean execute(CustomerAction action) {
		return action.service();
	}
}
