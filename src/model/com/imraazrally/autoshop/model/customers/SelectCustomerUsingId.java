package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class SelectCustomerUsingId{
	private Session session;
	private String customerId;
	private List<Customer> customers;
	
	public SelectCustomerUsingId(Session session, String customerId){
		this.session=session;
		this.customerId=customerId;
		execute();
	}
	
	@SuppressWarnings("unchecked")
	public void execute() {
		String SQL=String.format(CustomerConsts.RETRIEVE_CUSTOMER_USING_ID_QUERY, customerId);
		Query query=session.createSQLQuery(SQL).addEntity(Customer.class);
		customers=query.list();
	}
	
	public List<Customer> getCustomers(){
		return customers;
	}
	
}
