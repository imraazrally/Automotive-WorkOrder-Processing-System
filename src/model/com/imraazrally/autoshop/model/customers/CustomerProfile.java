package com.imraazrally.autoshop.model.customers;

import java.util.ArrayList;

import com.imraazrally.autoshop.model.vehicle.Vehicle;
import com.imraazrally.autoshop.model.vehicle.VehicleStorage;

public class CustomerProfile {
	private Customer customerInfo;
	private VehicleStorage vehiclesStorage;
	
	public CustomerProfile(Customer customerInfo, VehicleStorage vehiclesStorage){
		this.customerInfo=customerInfo;
		this.vehiclesStorage=vehiclesStorage;
	}
	
	public Customer getCustomerInfo()			 {return customerInfo;}
	public VehicleStorage getVehicleStorage() 	 {return vehiclesStorage;}
	public ArrayList<Vehicle> getVehicles() 	 {return getVehicleStorage().getVehicles();}
}
