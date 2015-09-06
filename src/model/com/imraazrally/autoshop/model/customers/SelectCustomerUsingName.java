package com.imraazrally.autoshop.model.customers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class SelectCustomerUsingName {
	private String fName;
	private String lName;
	private Session session;
	private List<Customer>customers;
	
	public SelectCustomerUsingName(String fName, String lName, Session session){
		this.fName=fName;
		this.lName=lName;
		this.session=session;
		execute();
	}
	
	@SuppressWarnings("unchecked")
	public void execute(){
		// The Query
		String SQL=String.format(CustomerConsts.GET_CUSTOMER_USING_NAME_QUERY,fName,lName);
		Query query=session.createSQLQuery(SQL).addEntity(Customer.class);		
		// Storing the List of Customers
		customers=query.list();
	}
	
	public List<Customer> getCustomers(){
		return customers;
	}
	
}
