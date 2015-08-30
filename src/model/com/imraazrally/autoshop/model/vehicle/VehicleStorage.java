package com.imraazrally.autoshop.model.vehicle;

import java.util.ArrayList;

public class VehicleStorage {
	private ArrayList<Vehicle> vehicles;
	
	public VehicleStorage(){
		vehicles=new ArrayList<Vehicle>();
	}
	
	public void add(Vehicle vehicle){
		vehicles.add(vehicle);
	}
	
	public ArrayList<Vehicle> getVehicles(){
		return vehicles;
	}
}
