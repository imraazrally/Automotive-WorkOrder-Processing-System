package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;

import org.hibernate.Session;

import com.imraazrally.autoshop.model.customers.services.CustomerServicesActions;


public class AddCustomerAction extends CustomerAction implements CustomerServicesActions {
	private final Session session;
	private final Customer customer;

	public AddCustomerAction(Customer customer, Session session) {
		this.customer = customer;
		this.session=session;
	}

	public boolean service() {
		try {
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
			session.close();
			// Succesfully added customer
			return true;
		} catch (Exception e){e.printStackTrace();}
		return false;
	}
}
