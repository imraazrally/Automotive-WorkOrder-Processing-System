package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;

public abstract class SelectCustomerQuery {
	protected Connection dbConnection;
	public abstract ResultSet execute();
}
