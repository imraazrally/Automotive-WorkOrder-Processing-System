package com.imraazrally.autoshop.model.customers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public abstract class SelectCustomer {
	protected Customer customerInfo;
	protected Session session;
	protected List<Customer> customers;
	
	public SelectCustomer(Customer customerInfo, Session session){
		this.customerInfo=customerInfo;
		this.session=session;
		select();
	}
	
	public abstract void select();
	
	public void execute(String SQL){
		Query query=session.createSQLQuery(SQL).addEntity(Customer.class);
		customers=query.list();
	}
	
	public List<Customer> getCustomers(){
		return customers;
	}
}
