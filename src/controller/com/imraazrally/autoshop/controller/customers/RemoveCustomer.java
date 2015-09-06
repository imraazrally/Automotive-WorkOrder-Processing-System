package com.imraazrally.autoshop.controller.customers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.imraazrally.autoshop.model.customers.CustomerAction;
import com.imraazrally.autoshop.model.customers.CustomerServices;
import com.imraazrally.autoshop.model.customers.PrintAjaxResponse;
import com.imraazrally.autoshop.model.customers.RemoveCustomerAction;
import com.imraazrally.autoshop.model.login.Key;
import com.imraazrally.autoshop.model.login.KeyVerifier;
import com.imraazrally.autoshop.model.login.LoginConsts;
import com.imraazrally.autoshop.model.login.Permission;
import com.imraazrally.autoshop.model.login.PermissionWallet;

@Controller
public class RemoveCustomer {
	// Only Admins are allowed to remove customers
	private PermissionWallet permissions=new PermissionWallet(){{
		addPermission(new Permission(LoginConsts.ADMIN));
	}};
			
	@RequestMapping("/removeCustomer")
	public ModelAndView removeCustomer(
			@RequestParam(value="id") String id,
			HttpServletRequest request, HttpServletResponse response
	) throws IOException{
		
		
		ModelAndView target=new ModelAndView("messageBox");
		// Verify Permission Using the key 
		Key key = (Key) request.getSession().getAttribute("key");
		
		// Database Connection
		Connection dbConnection=(Connection) request.getSession().getAttribute("dbConnection");
		
		//Actions
		CustomerAction removeCustomerUsingId=new RemoveCustomerAction(dbConnection,id);
		
	 
		if(verifyPermissions(key)){
			return removeCustomer(removeCustomerUsingId.service(), target);
		}else{
			return displayInsufficientPermissionsMessage(target);
		}
		
	}
	

	private boolean verifyPermissions(Key key){
		return new KeyVerifier(key,permissions).verify();
	}
	
	
	// Below are simple methods for displaying message boxes with status
	private ModelAndView removeCustomer(boolean status, ModelAndView target){
		if(status){
			return displayRemoveSuccessMessage(target);
		}else{
			return displayRemoveFailMessage(target);
		}
	}
	
	private ModelAndView displayInsufficientPermissionsMessage(ModelAndView target){
		target.addObject("message","Insufficient Permissions!");
		return target;
	}
	
	private ModelAndView displayRemoveFailMessage(ModelAndView target){
		target.addObject("message","Failed to remove customer!");
		return target;
	}
	
	private ModelAndView displayRemoveSuccessMessage(ModelAndView target){
		target.addObject("message","Successfully removed customer!");
		return target;
	}
	
}


