package com.imraazrally.autoshop.model.vehicle;

import com.imraazrally.autoshop.model.vehicle.services.VehicleSticker;

public class EngineSize implements VehicleSticker {
	private final String cylinders;
	private final String cc;
	
	public EngineSize(String cylinders, String cc){
		this.cylinders=cylinders;
		this.cc=cc;
	}
	
	public String getCylinders()	{return cylinders;}
	public String getCc()			{return cc;}
	public String getInfo()			{return getCylinders() + ":" + getCc();}
}
