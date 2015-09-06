package com.imraazrally.autoshop.tests.customers;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.imraazrally.autoshop.model.customers.AddCustomerAction;
import com.imraazrally.autoshop.model.customers.Customer;
import com.imraazrally.autoshop.model.customers.ImportCustomersFromDb;
import com.imraazrally.autoshop.model.customers.SelectCustomerQuery;
import com.imraazrally.autoshop.model.customers.SelectCustomerUsingPhone;
import com.imraazrally.autoshop.model.login.LoginConsts;
import com.imraazrally.autoshop.model.login.LoginDb;


@SuppressWarnings("unused")
public class CustomerTest {
	private Customer customer;
	private Connection dbConnection;
	
	private boolean ranCustomerObjectTest=false;
	private boolean ranAddCustomerTest=false;
	
	
	public void customerObjectTest(){
		// Setting Flag
		ranCustomerObjectTest=true;
		
		// Pre defined customer information
		String fName="Imraaztest7144504";
		String lName="Rally";
		String email="raisoft2020@gmail.com";
		String phone="1234test1234";
		String address="NJ";
		
		//Creating Customer
		dbConnection=new LoginDb().getConnection(LoginConsts.DB_URL, LoginConsts.DB_USER, LoginConsts.DB_PASS);		
		customer=new Customer(fName,lName,email,phone,address);
		
		//Checking if customer object responds as expected
		assertNotNull(dbConnection);
		assertEquals(fName,customer.getFName());
		assertEquals(lName,customer.getLName());
		assertEquals(email,customer.getEmail());
		assertEquals(phone,customer.getPhone());
		assertEquals(address,customer.getAddress());
	}
	
	@Test
	// Testing if addCustomerAction works (Supposed to add the customer to the database and return true if successful)
	public void addCustomerTest(){
		ranAddCustomerTest=true;
		customerObjectTest();
		assertEquals(true,new AddCustomerAction(dbConnection,customer).service());
	}
	
	@Test
	// Using our customers phone number, we select the customer and check if the fisrt names match. 
	public void selectCustomerUsingPhone() throws SQLException{
		if(!ranAddCustomerTest) addCustomerTest();
		SelectCustomerQuery query=new SelectCustomerUsingPhone(dbConnection, customer.getPhone());
		assertEquals(customer.getFName(),new ImportCustomersFromDb(dbConnection, query.execute()).getCustomers().get(0).getFName());
	}
	
	
}
