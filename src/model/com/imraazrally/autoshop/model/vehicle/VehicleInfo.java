package com.imraazrally.autoshop.model.vehicle;

public class VehicleInfo {
	private final Year year;
	private final Make make;
	private final Model model;
	private final EngineSize engineSize;
	
	public VehicleInfo(Year year, Make make, Model model, EngineSize engineSize){
		this.year=year;
		this.make=make;
		this.model=model;
		this.engineSize=engineSize;
	}
	
	public String getYear(){
		return year.getInfo();
	}
	
	public String getMake(){
		return make.getInfo();
	}
	
	public String getModel(){
		return model.getInfo();
	}
	
	public String getCylinders(){
		return engineSize.getCylinders();
	}
	
	public String getCc(){
		return engineSize.getCc();
	}
	
}
