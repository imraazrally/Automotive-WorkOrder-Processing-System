package com.imraazrally.autoshop.controller.customers;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.imraazrally.autoshop.model.customers.Customer;
import com.imraazrally.autoshop.model.customers.CustomerAction;
import com.imraazrally.autoshop.model.customers.CustomerProfile;
import com.imraazrally.autoshop.model.customers.CustomerServices;
import com.imraazrally.autoshop.model.customers.SelectCustomerUsingId;
import com.imraazrally.autoshop.model.vehicle.ImportVehiclesFromDbUsingCustomerId;
import com.imraazrally.autoshop.model.vehicle.Vehicle;
import com.imraazrally.autoshop.model.vehicle.VehicleInfo;
import com.imraazrally.autoshop.model.vehicle.VehicleStorage;

@Controller
public class Profile {
	
	@RequestMapping("/customerProfile")
	public ModelAndView customerProfileHome(
	
			@RequestParam (value="id") String id,
			HttpServletRequest request
	
	){
		//Which view to forward the customer to ?
		ModelAndView target=new ModelAndView("customers/customerProfile");
		Connection dbConnection=(Connection)request.getSession().getAttribute("dbConnection");
		SessionFactory sessionFactory=(SessionFactory)request.getSession().getAttribute("sessionFactory");
	
		//Building Customer based on Input parameter from request (customerId)
		try{
			Customer customerInfo=new Customer(){{
				setCustomerId(new Integer(id));
			}};
			
			SelectCustomerUsingId select=new SelectCustomerUsingId(customerInfo,sessionFactory.openSession());
			ImportVehiclesFromDbUsingCustomerId importVehicle=new ImportVehiclesFromDbUsingCustomerId(sessionFactory.openSession(), id);

			//Building a Profile
			Customer customer=select.getCustomers().get(0);
			CustomerProfile profile=new CustomerProfile(customer,importVehicle.getVehicleStorage());
			target.addObject("profile",profile);
			//Forwarind Page
		}catch(Exception e){e.printStackTrace();}
		return target;
	}
}
