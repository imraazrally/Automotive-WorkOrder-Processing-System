package com.imraazrally.autoshop.controller.customers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imraazrally.autoshop.model.login.Key;
import com.imraazrally.autoshop.model.login.KeyVerifier;
import com.imraazrally.autoshop.model.login.LoginConsts;
import com.imraazrally.autoshop.model.login.Permission;
import com.imraazrally.autoshop.model.login.PermissionWallet;

@Controller
public class SelectCustomer {
	
	// In order to select customer, The users need Guest+ levell of permissions. So we predifine a list of permissions;
	PermissionWallet permissions=new PermissionWallet(){{
		addPermission(new Permission(LoginConsts.ADMIN));
		addPermission(new Permission(LoginConsts.GUEST));
	}};

	@RequestMapping("/selectCustomerUsingPhone")
	public ModelAndView selectCustomerUsingPhone(HttpServletRequest request){
		// Getting User Key
		Key key = (Key) request.getSession().getAttribute("key");
		
		// Verifier Object
		KeyVerifier verifier=new KeyVerifier(key, permissions);
		
		// If user's key contains necessary permission allowences, forward to the destination
		if (verifier.verify())return new ModelAndView("customers/selectCustomerPhone");
		
		// Else Display No Access Allowed Page
		return new ModelAndView(LoginConsts.roleIdToView.get(LoginConsts.BLOCKED));
	}
	

}
