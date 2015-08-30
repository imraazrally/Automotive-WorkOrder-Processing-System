package com.imraazrally.autoshop.model.vehicle;

import com.imraazrally.autoshop.model.vehicle.services.VehicleSticker;

public class Year implements VehicleSticker {
	private final String year;
	
	public Year(String year){this.year=year;}
	
	public String getYear(){return year;}
	public String getInfo(){return getYear();}
}
