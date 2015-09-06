package com.imraazrally.autoshop.controller.customers;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imraazrally.autoshop.model.customers.Customer;
import com.imraazrally.autoshop.model.customers.SelectAllCustomers;

@Controller
public class ViewAll {
	@RequestMapping("/viewAllCustomers")
	public ModelAndView viewAllCustomers(HttpServletRequest request){
		//Which view to forward the results to ?
		ModelAndView target=new ModelAndView("customers/lookupResults");
		SessionFactory sessionFactory=(SessionFactory)request.getSession().getAttribute("sessionFactory");
		
		try{
			SelectAllCustomers select=new SelectAllCustomers(new Customer(),sessionFactory.openSession());
			//Storing the list of customers as an attribute
			target.addObject("customers", select.getCustomers());
		}catch(Exception e){e.printStackTrace();}
			
		return target;
	}
}
