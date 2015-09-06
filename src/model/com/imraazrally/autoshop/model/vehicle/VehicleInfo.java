package com.imraazrally.autoshop.model.vehicle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class VehicleInfo {
	@Id
	private  int customerId;
	private  int year;
	private  String make;
	private  String model;
	private  int cylinders;
	private  int cc;
	
	public VehicleInfo(){}
	
	public VehicleInfo(int year, String make, String model, int cylinders, int cc){
		this.year=year;
		this.make=make;
		this.model=model;
		this.cylinders=cylinders;
		this.cc=cc;
	}
	
	public void setCustomerId(int customerId){
		this.customerId=customerId;
	}
	
	public void setYear(int year){
		this.year=year;
	}
	
	public void setMake(String make){
		this.make=make;
	}
	
	public void setModel(String model){
		this.model=model;
	}
	
	public void setCylinders(int cylinders){
		this.cylinders=cylinders;
	}
	
	public void setCc(int cc){
		this.cc=cc;
	}
	
	
	public int getYear(){
		return year;
	}
	
	public String getMake(){
		return make;
	}
	
	public String getModel(){
		return model;
	}
	
	public int getCylinders(){
		return cylinders;
	}
	
	public int getCc(){
		return cc;
	}
	
}
