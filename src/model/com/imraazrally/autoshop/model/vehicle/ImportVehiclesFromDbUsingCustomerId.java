package com.imraazrally.autoshop.model.vehicle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;

public class ImportVehiclesFromDbUsingCustomerId {
	private final Session session;
	private final int customerId;
	private final VehicleStorage vehicleStorage;
	
	public ImportVehiclesFromDbUsingCustomerId(Session session, int customerId){
		this.session=session;
		this.customerId=customerId;
		vehicleStorage=new VehicleStorage();
		importVehiclesFromDb();
	}
	
	@SuppressWarnings("unchecked")
	public void importVehiclesFromDb(){
		String SQL=String.format(VehicleConsts.IMPORT_VEHICLE_QUERY,Integer.toString(customerId));
		try{
			Query query=session.createSQLQuery(SQL).addEntity(VehicleInfo.class);
			query.list().forEach (vehicle -> vehicleStorage.add(new Vehicle((VehicleInfo) vehicle)));
		}catch(Exception e){e.printStackTrace();}
	}
	
	public VehicleStorage getVehicleStorage(){
		return vehicleStorage;
	}
	
}
