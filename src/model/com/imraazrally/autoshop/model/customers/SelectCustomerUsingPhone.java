package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class SelectCustomerUsingPhone {
	private String phone;
	private Session session;
	private List <Customer> customers;
	
	public SelectCustomerUsingPhone(Session session, String phone){
		this.session=session;
		this.phone=phone;
		execute();
	}

	public void execute(){
		// The Query
		String SQL=String.format(CustomerConsts.GET_CUSTOMER_USING_PHONE_QUERY,phone);
		Query query=session.createSQLQuery(SQL).addEntity(Customer.class);
		
		// Store
		customers=query.list();
	}
	
	public List<Customer> getCustomers(){
		return customers;
	}
}
