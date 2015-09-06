package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class SelectAllCustomers{
	private Session session;
	private List<Customer> customers;
	
	public SelectAllCustomers(Session session){
		this.session=session;
		execute();
	}
	
	
	public void execute() {
		String SQL=String.format(CustomerConsts.RETRIEVE_ALL_CUSTOMERS);
		Query query=session.createSQLQuery(SQL).addEntity(Customer.class);
		customers=query.list();
	}
	
	public List<Customer> getCustomers(){
		return customers;
	}

}
