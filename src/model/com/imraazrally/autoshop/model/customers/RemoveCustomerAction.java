package com.imraazrally.autoshop.model.customers;

import java.sql.Connection;

import org.hibernate.Session;

public class RemoveCustomerAction extends CustomerAction {
	private final Customer customer;
	private final Session session;
	
	public RemoveCustomerAction(Customer customer, Session session){
		this.customer=customer;
		this.session=session;
	}
	
	@Override
	public boolean service() {
		try{
			return execute();
		}catch(Exception e){e.printStackTrace();}
		return false;
	}
	
	public boolean execute(){
		session.beginTransaction();
		session.delete(customer);
		session.getTransaction().commit();
		session.close();
		return true;
	}

}
