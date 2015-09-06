package com.imraazrally.autoshop.controller.customers;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imraazrally.autoshop.model.customers.Customer;
import com.imraazrally.autoshop.model.customers.ImportCustomersFromDb;
import com.imraazrally.autoshop.model.customers.SelectAllCustomers;
import com.imraazrally.autoshop.model.customers.SelectCustomerQuery;

@Controller
public class ViewAll {
	@RequestMapping("/viewAllCustomers")
	public ModelAndView viewAllCustomers(HttpServletRequest request){
		//Which view to forward the results to ?
		ModelAndView target=new ModelAndView("customers/lookupResults");
		
		//Getting Database connection from session
		Connection dbConnection=(Connection) request.getSession().getAttribute("dbConnection");
		
		try{
			SelectCustomerQuery query=new SelectAllCustomers(dbConnection);
			ArrayList<Customer> customers=new ImportCustomersFromDb(dbConnection, query.execute()).getCustomers();
			//Storing the list of customers as an attribute
			target.addObject("customers", customers);
		}catch(Exception e){e.printStackTrace();}
				
		
		return target;
	}
}
