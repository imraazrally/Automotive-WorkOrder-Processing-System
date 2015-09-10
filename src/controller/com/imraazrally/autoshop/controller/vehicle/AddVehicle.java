package com.imraazrally.autoshop.controller.vehicle;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.imraazrally.autoshop.model.login.Key;
import com.imraazrally.autoshop.model.login.KeyVerifier;
import com.imraazrally.autoshop.model.login.LoginConsts;
import com.imraazrally.autoshop.model.login.Permission;
import com.imraazrally.autoshop.model.login.PermissionWallet;

@Controller
public class AddVehicle {
	
	// Only ADMINS are allowed to add vehicles to a selected customer
	private PermissionWallet permissions=new PermissionWallet(){{
		addPermission(new Permission(LoginConsts.ADMIN));
	}};
	
	@RequestMapping ("/addVehicle")
	public ModelAndView addVehicle(
			@RequestParam (value = "customerId") String customerId,
			HttpServletRequest request,
			HttpServletResponse response
	) throws IOException{
		
			// Which view to forward to ?
			ModelAndView target=new ModelAndView("vehicle/addVehicle");
			// Verify User permissions
			Key key = (Key) request.getSession().getAttribute("key");
			if (!verifyPermissions(key))return displayInsufficientPermissionsMessage(new ModelAndView("messageBox"));
			// forwarding  
			target.addObject("customerId",customerId);
			return target;
	}
	

	private boolean verifyPermissions(Key key){
		return new KeyVerifier(key,permissions).verify();
	}
	
	private ModelAndView displayInsufficientPermissionsMessage(ModelAndView target){
		target.addObject("message","Insufficient Permissions!");
		return target;
	}
}
