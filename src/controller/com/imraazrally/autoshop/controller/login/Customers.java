package com.imraazrally.autoshop.controller.login;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.imraazrally.autoshop.model.login.Key;
import com.imraazrally.autoshop.model.login.KeyVerifier;
import com.imraazrally.autoshop.model.login.LoginConsts;
import com.imraazrally.autoshop.model.login.Permission;
import com.imraazrally.autoshop.model.login.PermissionWallet;

@Controller
public class Customers {
	//Creating a list of allowed permission
	PermissionWallet permissions=new PermissionWallet(){{
			addPermission(new Permission(LoginConsts.ADMIN));
	}};
			
	@RequestMapping("/customers")
	public ModelAndView verifyCredentials(HttpServletRequest request) {
		//Getting Key from session
		Key key = (Key) request.getSession().getAttribute("key");
			
		// Verifying if user has admin level permission
		KeyVerifier verifier=new KeyVerifier(key,permissions);
		if(verifier.verify())return doTask();
	
		// If user is not Admin or Key is not found
		return new ModelAndView(LoginConsts.roleIdToView.get(LoginConsts.BLOCKED));
	}

	private ModelAndView doTask() {
		// This method will be called only if user posses ADMIN level permission
		// forward user to customer page
		return new ModelAndView("customers/customers");
	}
}