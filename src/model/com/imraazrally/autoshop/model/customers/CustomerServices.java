package com.imraazrally.autoshop.model.customers;

import java.io.PrintWriter;
import java.sql.Connection;

public class CustomerServices implements com.imraazrally.autoshop.model.customers.services.CustomerServices {
	public boolean execute(CustomerAction action) {
		return action.service();
	}
}
