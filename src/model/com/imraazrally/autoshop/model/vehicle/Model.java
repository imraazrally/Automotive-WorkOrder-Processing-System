package com.imraazrally.autoshop.model.vehicle;

import com.imraazrally.autoshop.model.vehicle.services.VehicleSticker;

public class Model implements VehicleSticker{
	private final String model;
	
	public Model(String model){this.model=model;}
	
	public String getModel()	{return model;}
	public String getInfo()		{return getModel();}
}
