package com.imraazrally.autoshop.model.vehicle;

import com.imraazrally.autoshop.model.vehicle.services.VehicleSticker;

public class Make implements VehicleSticker{
	private final String make;
	
	public Make(String make){
		this.make=make;
	}
	
	public String getMake(){
		return make;
	}
	
	public String getInfo(){
		return getMake();
	}
}
