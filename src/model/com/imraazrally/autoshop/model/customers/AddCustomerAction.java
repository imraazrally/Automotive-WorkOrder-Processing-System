package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;
import org.hibernate.Session;

public class AddCustomerAction extends CustomerAction {
	private final Session session;
	private final Customer customer;

	public AddCustomerAction(Customer customer, Session session) {
		this.customer = customer;
		this.session=session;
	}

	public boolean service() {
		try {
			return execute();
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean execute(){
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
		return true;
	}
}
